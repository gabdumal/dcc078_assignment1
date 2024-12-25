/*
 * Copyright (c) 2024 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.automotive.store;

public class User {

    private static final User instance = new User();
    private boolean loggedIn;
    private String username;
    private String password;
    private String name;
    private String phoneNumber;
    private String bankAccount;

    public static User getInstance() {
        return instance;
    }

    public static void resetInstance() {
        var user = User.getInstance();
        user.initializeInstance();
    }

    private void initializeInstance() {
        this.loggedIn = false;
        this.username = "";
        this.password = "";
        this.name = "";
        this.phoneNumber = "";
        this.bankAccount = "";
    }

    public boolean isLoggedIn() {
        return this.loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

}
