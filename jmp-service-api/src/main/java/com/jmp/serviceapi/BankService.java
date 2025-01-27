package com.jmp.serviceapi;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.jmp.dto.BankCard;
import com.jmp.dto.Subscription;
import com.jmp.dto.User;

public interface BankService {
	
	void subscribe(BankCard bankCard);

	Optional<Subscription> getSubscriptionByBankCardNumber(String cardnNumber);

	List<User> getAllUsers();
	
	public List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> condition);
	
	default double getAverageUsersAge() {
        List<User> users = getAllUsers();
        LocalDate now = LocalDate.now();

        // Calculate average age
        return users.stream()
                .mapToLong(user -> ChronoUnit.YEARS.between(user.getBirthday(), now)) 
                .average() 
                .orElse(0.0);
    }
	
	
	static boolean isPayableUser(User user) {
		LocalDate now = LocalDate.now();
	    long age = ChronoUnit.YEARS.between(user.getBirthday(), now);
	    return age >= 18;
	}
	
}
