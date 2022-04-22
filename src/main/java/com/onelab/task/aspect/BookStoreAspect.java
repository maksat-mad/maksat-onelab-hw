package com.onelab.task.aspect;

import com.onelab.task.entities.UserRequestBook;
import com.onelab.task.patterns.singleton.SingletonRepository;
import com.onelab.task.entities.UserRequestTime;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
public class BookStoreAspect {

    private static final Logger logger = LoggerFactory.getLogger(BookStoreAspect.class);

    @Autowired
    public BookStoreAspect(SingletonRepository singletonRepository) {
    }

    @Pointcut("execution(* com.onelab.task.services.user.UserService.find*(..))")
    public void userServiceRequestMethods() {
    }

    @Pointcut("execution(* com.onelab.task.services.user.UserService.buy*(..))")
    public void userServiceBuyMethods() {
    }

    @Before("userServiceRequestMethods()")
    public void LoggingRequestDetails(JoinPoint joinPoint) {
        logger.info("Running method: " + joinPoint.getSignature());
        Object[] signatureArgs = joinPoint.getArgs();
        for (Object signatureArg : signatureArgs) {
            logger.info("Arg: " + signatureArg);
        }

        // save request time for data analysis
        LocalDateTime now = LocalDateTime.now();
        SingletonRepository.getUserRequestTimeRepository()
                .save(new UserRequestTime(0L,
                        java.sql.Date.valueOf(now.toLocalDate())));
    }

    @Before("userServiceBuyMethods()")
    public void LoggingBeforeBuyDetails(JoinPoint joinPoint) {
        logger.info("Running method: " + joinPoint.getSignature());
        Object[] signatureArgs = joinPoint.getArgs();
        List<String> data = new ArrayList<>();
        for (Object signatureArg : signatureArgs) {
            logger.info("Arg: " + signatureArg);
            data.add(signatureArg.toString());
        }
        // save details for data analysis
        try {
            UserRequestBook userRequestBook = new UserRequestBook();
            if (data.size() == 2) {
                userRequestBook.setTitle(SingletonRepository.getBookRepository()
                        .findBookByBookId(Long.parseLong(data.get(0)))
                        .get(0).getTitle());
                userRequestBook.setAuthorName(SingletonRepository.getBookRepository()
                        .findBookByBookId(Long.parseLong(data.get(0)))
                        .get(0).getAuthor().getAuthorName());
                userRequestBook.setAmount(Integer.parseInt(data.get(1)));
            }
            else if (data.size() == 3) {
                userRequestBook.setTitle(data.get(0));
                userRequestBook.setAuthorName(data.get(1));
                userRequestBook.setAmount(Integer.parseInt(data.get(2)));
            }
            SingletonRepository.getUserRequestBookRepository().save(userRequestBook);
        } catch (Exception ex) {
            logger.error("DID NOT SAVE BEFORE BUY DETAILS");
        }
    }

    @AfterReturning(pointcut = "userServiceBuyMethods()",
            returning = "returnValue")
    public void LoggingAfterBuyDetails(JoinPoint joinPoint, String returnValue) {
        logger.info("After this method: " + joinPoint.getSignature());
        logger.info(returnValue);
    }
}
