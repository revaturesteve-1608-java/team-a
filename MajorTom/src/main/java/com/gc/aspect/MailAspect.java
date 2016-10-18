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
import com.gc.model.Ticket;
import com.gc.service.DataService;

@Aspect //Needed to tell it that it can use aspectj annotations
@Component
public class MailAspect {
	
	@Autowired
	MailManager mailer;
	
	@Autowired
	DataService dataService;
	
	@Around("execution(* com.gc.controller.ClientController.reassignSeat(..))")
	public ResponseEntity<Seat> sendEmail(ProceedingJoinPoint jpp) throws Throwable{
		Object[] args = jpp.getArgs();
		ReassignSeatDTO seatDTO = (ReassignSeatDTO) args[1];
		Ticket ticket = dataService.findTicketById(seatDTO.getTicketId());
		Seat seat1 = dataService.findSeatById(seatDTO.getSeatId());
		Seat seat2 = dataService.findSeatById(seatDTO.getSeat2Id());
		System.out.println("Sending the email");
		mailer.sendMail("kyle.james.garner@gmail.com", "Your Seat Has Been Reassigned!", "Dear "+ seat1.getTicket().getFirstName()+",\n\n"+
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
		System.out.println("Email sent");
		jpp.proceed();
		return new ResponseEntity<>(seat1,HttpStatus.ACCEPTED);
	}
}
