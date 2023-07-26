package me.sqli.transaction.services.impl;

import java.time.LocalDateTime;

import me.sqli.clients.balance.BalanceClient;
import me.sqli.clients.customer.CustomerCheckResponse;
import me.sqli.clients.customer.CustomerClient;
import me.sqli.transaction.entities.Transaction;
import me.sqli.transaction.repositories.TransactionRepository;
import me.sqli.transaction.services.TransactionService;

public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final CustomerClient customerClient;
    private final BalanceClient balanceClient;

    public TransactionServiceImpl(TransactionRepository transactionRepository, CustomerClient customerClient, BalanceClient balanceClient) {
        this.transactionRepository = transactionRepository;
        this.customerClient = customerClient;
        this.balanceClient = balanceClient;
    }

    // debit transaction
    public Transaction performDebitTransaction(Long accountNo, int amount, String transType, String purpose, Long toAccount) {

        CustomerCheckResponse customerCheckResponse = customerClient.getCustomerByAccountNo(accountNo);

        if (customerCheckResponse.customerRequest() == null) {
            throw new IllegalArgumentException("Client account not found.");
        }

        Integer balance = balanceClient.checkSufficientBalance(accountNo);

        if (balance < amount) {
            throw new IllegalArgumentException("Insufficient balance for the debit transaction.");
        }

        if ("Transfer".equalsIgnoreCase(transType)) {
            if (toAccount == null || toAccount.equals(accountNo)) {
                throw new IllegalArgumentException("Invalid destination account number.");
            }

            CustomerCheckResponse recipient = customerClient.getCustomerByAccountNo(accountNo);
            if (recipient.customerRequest() == null) {
                throw new IllegalArgumentException("Recipient account not found.");
            }

            //Todo  Perform the transfer
            //clientBalance.getBalance() - amount;
            //recipientBalance.getBalance() + amount;

            // Todo update balance client and recipient
            // Todo Create transaction records for sender and recipient

        } else if ("Retrait Gab".equalsIgnoreCase(transType) || "Retrait En Espèces ".equalsIgnoreCase(transType)) {

            // Todo setBalance(clientBalance.getBalance() - amount);
            // Todo balanceService.updateBalance(clientBalance);

            //Todo Create transaction record
        } else if ("Account-to-Account Transfer".equalsIgnoreCase(transType)) {

        } else {
            // Other debit transaction types not specified, handle accordingly
            throw new IllegalArgumentException("Invalid debit transaction type.");
        }

        return null;
    }

    public Transaction performCreditTransaction(Long accountNo, int amount, String transType, String purpose, Long fromAccount) {
        // Check if the client's account exists before performing the credit transaction
        CustomerCheckResponse customerCheckResponse = customerClient.getCustomerByAccountNo(accountNo);

        if (customerCheckResponse.customerRequest() == null) {
            throw new IllegalArgumentException("Client account not found.");
        }

        if ("Deposit".equalsIgnoreCase(transType)) {
            // Todo  Deposit to the client's account

            // Todo Create transaction record

        } else if ("Account-to-Account Transfer".equalsIgnoreCase(transType)) {
            // Account-to-account transfer from another client's account
            if (fromAccount == null || fromAccount.equals(accountNo)) {
                throw new IllegalArgumentException("Invalid source account number.");
            }

            CustomerCheckResponse senderCheckResponse = customerClient.getCustomerByAccountNo(accountNo);

            if (senderCheckResponse.customerRequest() == null) {
                throw new IllegalArgumentException("Source account not found.");
            }

            // Todo chack balance < amount

            // Todo senderBalance.setBalance(senderBalance.getBalance() - amount);
            // Todo clientBalance.setBalance(clientBalance.getBalance() + amount);

            // Todo balanceService.updateBalance(senderBalance);
            // Todo balanceService.updateBalance(clientBalance);

            // Todo Create transaction records for sender and recipient

        } else {
            throw new IllegalArgumentException("Invalid credit transaction type.");
        }

        return null;
    }

    private void createTransactionRecord(Long accountNo, int amount, String transType, String purpose, Long toAccount, int newBalance) {
        Transaction transaction = new Transaction();
        transaction.setAccountNo(accountNo);
        transaction.setAmount(amount);
        transaction.setTransType(transType);
        transaction.setTransDate(LocalDateTime.now());
        transaction.setPurpose(purpose);
        transaction.setToAccount(toAccount);
        transaction.setAccountBal(newBalance);

        createTransaction(transaction);
    }

    public void createTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }
}
