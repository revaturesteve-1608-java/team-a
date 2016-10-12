package com.gc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

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
	
	@Around("execution(* com.gc.controller.ClientController.reassignSeatAndEmail(..))")
	public ResponseEntity<Seat> sendEmail(ProceedingJoinPoint jpp) throws Throwable{
		jpp.proceed();
		Object[] args = jpp.getArgs();
		System.out.println("Class1: "+args[0].getClass() + "Class2:" + args[1].getClass());
		Seat seat = (Seat) args[1];
		Ticket ticket = (Ticket) args[2];
		System.out.println(ticket.getEmail());
//		mailer.sendMail("kyle.james.garner@gmail.com", "Your Seat Has Been Reassigned!", "Dear "+ ticket.getFirstName()+",\n\n"+
//						"\tYour flight info is as follows:\n" +
//						"\tTicket Number: " + ticket.getTicketId() + "\n" +
//						"\tE-mail: "+ticket.getEmail() + "\n"
//						"\tSeat Number: " + seat.getSeatId() + "\n" +
//						"\tSeat Class: " + seat.getClass() + "\n" 
//						"\n\tEnjoy Your Flight!\n\t\tRev-Thompson International Airport");
		return new ResponseEntity<Seat>(seat,seat==null?HttpStatus.NOT_FOUND:HttpStatus.ACCEPTED);
	}
}
