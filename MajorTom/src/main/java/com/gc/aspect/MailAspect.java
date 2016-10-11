package com.gc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
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
	
	@Around("execution(* com.gc.controller.ClientController.reassignSeat(..))")
	public ResponseEntity<Ticket> sendEmail(ProceedingJoinPoint jpp) throws Throwable{
		System.out.println("This is firing off");
		jpp.proceed();
		System.out.println("Can I get an Amen");
		Object[] args = jpp.getArgs();
		System.out.println("args[0]: "+args[0] +"args[1]: "+args[1]);
		int ticketId = (int) args[0];
		Ticket newTicketInfo = dataService.findTicketById(ticketId);
//		if (newTicketInfo != null) {
//			System.out.println(newTicketInfo.getEmail());
//			mailer.sendMail("kyle.james.garner@gmail.com", "This is the Ticket Info", "Dear "+ newTicketInfo.getFirstName()+",\n\n"+
//								"\tYour flight info is as follows:\n" + "\tE-mail: "+newTicketInfo.getEmail()+
//								"\n\n\tEnjoy Your Flight!\n\t\tRev-Thompson International Airport");
//		}
		return new ResponseEntity<Ticket>(newTicketInfo,newTicketInfo==null?HttpStatus.NOT_FOUND:HttpStatus.ACCEPTED);
	}
}
