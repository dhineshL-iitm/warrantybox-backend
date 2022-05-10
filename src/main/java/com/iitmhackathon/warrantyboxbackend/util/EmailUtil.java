package com.iitmhackathon.warrantyboxbackend.util;

public class EmailUtil {
    public static String getWelcomeBody(String username){
        return String.format("Thanks for Registering with us %s",username);
    }
    public static String getRaiseTicketBody(String product){
        return String.format("Your ticket has been raised for %s.",product);
    }
    public static String getRaiseTicketBodyBrand(String product){
        return String.format("A ticket has been raised for %s.",product);
    }
    public static String getResolvedBody(String product){
        return String.format("Your ticket has been resolved for %s.",product);
    }
}
