package edu.spu.se411.lab06_logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import edu.spu.se411.lab06_logging.model.WalletAccount;
import edu.spu.se411.lab06_logging.exceptions.InsufficientFundsException;

public class App {
    

    static Logger Logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        Logger.info("Application is starting...");

        WalletAccount account = new WalletAccount(1000);
        Logger.debug("Wallet account created with balance: 1000");

        try {
            Logger.debug("Withdrawing amount: 1500");
            account.withdraw(1500);
        } catch (InsufficientFundsException e) {
            Logger.error("Exception thrown: " + e.getMessage());
            System.out.println("Exception caught: " + e.getMessage());
        }

        try {
            Logger.debug("Depositing amount: -100");
            account.deposit(-100);
        } catch (IllegalArgumentException e) {
            Logger.error("Exception thrown: " + e.getMessage());
            System.out.println("Exception caught: " + e.getMessage());
        }

        Logger.info("Application is ending...");
    }
}