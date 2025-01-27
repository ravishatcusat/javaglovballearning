package com.app;
import java.security.Provider.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.jmp.dto.BankCard;
import com.jmp.dto.Subscription;
import com.jmp.dto.User;
import com.jmp.dto.bankcard.CreditBankCard;
import com.jmp.dto.bankcard.DebitBankCard;
import com.jmp.serviceapi.BankService;
import com.jmp.serviceimpl.ServiceImpl;
import com.jmp.serviceimpl.SubscriptionNotFoundException;

public class Application {

	public static void main(String[] args) {
		
		ServiceImpl bankService = new ServiceImpl();
        
        User user1 = new User("abc", "kumar", LocalDate.of(1990, 5, 15));
        User user2 = new User("defg", "singh", LocalDate.of(1985, 8, 25));

        BankCard creditCard = new CreditBankCard("1234-5678-9012-3456", user1);
        BankCard debitCard = new DebitBankCard("9876-5432-1098-7654", user2);

        bankService.addBankCard(creditCard);
        bankService.addBankCard(debitCard);

        bankService.subscribe(creditCard);
        bankService.subscribe(debitCard);

        Optional<Subscription> subscription = bankService.getSubscriptionByBankCardNumber("1234-5678-9012-3456");
        System.out.println("Subscription for card 1234-5678-9012-3456: " + subscription);

        List<User> allUsers = bankService.getAllUsers();
        System.out.println("All Users: " + allUsers);
        
        double averageAge = bankService.getAverageUsersAge();
        System.out.println("Average Users' Age: " + averageAge);
        
        System.out.println(BankService.isPayableUser(user1));
        System.out.println(BankService.isPayableUser(user2));
        
        
        bankService.addSubscription(new Subscription("1234", LocalDate.of(2023, 1, 1)));
        bankService.addSubscription(new Subscription("5678", LocalDate.of(2024, 6, 15)));
        bankService.addSubscription(new Subscription("9999", LocalDate.of(2022, 10, 10)));
        List<Subscription> subscriptions2024 = bankService.getAllSubscriptionsByCondition(
                subs -> subs.getStartDate().getYear() == 2024);
        subscriptions2024.forEach(System.out::println);
        
        
        
        try {
			bankService.getSubscriptionOrThrow("0000-0000-0000-0000");
		} catch (SubscriptionNotFoundException e) {
			e.printStackTrace();
		}

    }


}
