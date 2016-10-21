package com.gc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.gc.dto.ReassignSeatDTO;
import com.gc.model.MailManager;
import com.gc.model.Seat;
import com.gc.service.DataService;

/**
 * Manages the emails sent by the application, using Spring Aspects
 * 
 * @author Kyle Garner
 */
@Aspect //Needed to tell it that it can use aspectj annotations
@Component
public class MailAspect {
	
	@Autowired
	MailManager mailer;
	
	@Autowired
	DataService dataService;
	
	/**
	 * Sends an email to the specified email address informing the recipient that their 
	 * seat reservation has been changed. Will need to be changed to seat2.getTicket.getEmail
	 * from the static email address currently used
	 * 
	 * @param ProceedingJoinPoint specifying where the aspect should be run, generally taken 
	 * care of by one of the AspectJ annotations
	 * 
	 * @return ResponseEntity<Seat> to pass the seat back from the AJAX request that the original 
	 * function returned
	 * 
	 * @exception Throwable required by AspectJ
	 */
	@Around("execution(* com.gc.controller.ClientController.reassignSeat(..))")
	public ResponseEntity<Seat> sendEmail(ProceedingJoinPoint jpp) throws Throwable{
		Object[] args = jpp.getArgs();
		ReassignSeatDTO seatDTO = (ReassignSeatDTO) args[1];
		Seat seat1 = dataService.findSeatById(seatDTO.getSeatId());
		Seat seat2 = dataService.findSeatById(seatDTO.getSeat2Id());
		// Sending the email
		mailer.sendMail(seat1.getTicket().getEmail(), "Your Seat Has Been Reassigned!", "Dear "+ seat1.getTicket().getFirstName()+",\n\n"+
						"\tYour flight info is as follows:\n" +
						"\tTicket Number: " + seat1.getTicket().getTicketId() + "\n" +
						"\tE-mail: " + seat1.getTicket().getEmail() + "\n" +
						"\n\tYour old seat information was:\n" +
						"\tSeat Number: " + seat1.getSeatId() + "\n" +
						"\tSeat Class: " + seat1.getSeatType().getSeatTypeName() + "\n"  +
						"\n\tYour new seat information is:\n" +
						"\tSeat Number: " + seat2.getSeatId() + "\n" +
						"\tSeat Class: " + seat2.getSeatType().getSeatTypeName() + "\n"  +
						"\n\tEnjoy Your Flight!\n\t\tRev-Thompson International Airport");
		// Email sent
		jpp.proceed();
		return new ResponseEntity<>(seat1,HttpStatus.ACCEPTED);
	}
}
