package com.jmp.bankapi;

import com.jmp.dto.BankCard;
import com.jmp.dto.User;
import com.jmp.enums.BankCardType;

public interface Bank {

	BankCard createBankCard(User user, BankCardType bankCardType);
}
