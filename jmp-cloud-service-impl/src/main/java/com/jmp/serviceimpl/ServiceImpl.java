package com.jmp.serviceimpl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.jmp.dto.BankCard;
import com.jmp.dto.Subscription;
import com.jmp.dto.User;
import com.jmp.serviceapi.BankService;

public class ServiceImpl implements BankService {

	List<BankCard> bankCards = new ArrayList<>();

	List<Subscription> subscriptions = new ArrayList<>();

//	List<User> users = new ArrayList<>();

	@Override
	public void subscribe(BankCard bankCard) {
		Subscription subscription = new Subscription(bankCard.getNumber(), LocalDate.now());
		subscriptions.add(subscription);
	}

	@Override
	public Optional<Subscription> getSubscriptionByBankCardNumber(String cardNumber) {
		return subscriptions.stream().filter(subscriber -> subscriber.getBankcardNumber().equals(cardNumber))
				.findFirst();
	}
	
	//21
	public Subscription getSubscriptionOrThrow(String bankCardNumber) throws SubscriptionNotFoundException {
        return getSubscriptionByBankCardNumber(bankCardNumber)
                .orElseThrow(() -> new SubscriptionNotFoundException(
                        "No subscription found for bank card number: " + bankCardNumber));
    }
	
	public List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> condition) {
        return getAllSubscriptions().stream()
                .filter(condition)
                .collect(Collectors.toList());
    }
	
    public List<Subscription> getAllSubscriptions() {
        return subscriptions;
    }

	@Override
	public List<User> getAllUsers() {
//		List<User> users = new ArrayList<>();
//        for (BankCard bankCard : bankCards) {
//            users.add(bankCard.getUser());
//        }
//        return users;

		return bankCards.stream().map(BankCard::getUser).collect(Collectors.toUnmodifiableList());
	}

	public void addBankCard(BankCard bankCard) {
		bankCards.add(bankCard);
	}

	public void addSubscription(Subscription subscription) {
		subscriptions.add(subscription);
	}

}
