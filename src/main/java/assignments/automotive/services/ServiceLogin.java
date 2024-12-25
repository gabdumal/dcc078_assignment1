/*
 * Copyright (c) 2024 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.automotive.services;

import assignments.automotive.store.User;

public class ServiceLogin
        implements IService {

    private Status status = Status.NOT_STARTED;

    public ServiceLogin() {
        User.resetInstance();
    }

    public User getUser() {
        return User.getInstance();
    }

    @Override
    public String begin() {
        this.status = Status.RUNNING;
        return "Login: inform username and password";
    }

    @Override
    public String cancel() {
        this.status = Status.CANCELLED;
        return "Login: process was cancelled";
    }

    @Override
    public Status getStatus() {
        return this.status;
    }

    @Override
    public boolean isRunning() {
        return this.status == Status.RUNNING;
    }

    public void informUsernameAndPassword(String username, String password) {
        this.tryToRun();

        var user = User.getInstance();
        user.setUsername(username);
        user.setPassword(password);
        this.status = Status.RUNNING;
    }

    public void tryToLogin() {
        this.tryToRun();

        var user = User.getInstance();
        var username = user.getUsername();
        var password = user.getPassword();

        if (username.equalsIgnoreCase("gabriel") && password.equals("banana")) {
            user.setName("Gabriel Alves");
            user.setPhoneNumber("99987651234");
            user.setBankAccount("098-347-198-357");
            user.setLoggedIn(true);
            this.status = Status.FINISHED;
        }
        else if (username.equalsIgnoreCase("lucas") && password.equals("uva")) {
            user.setName("Lucas Barbados");
            user.setPhoneNumber("99912340987");
            user.setBankAccount("647-285-279-123");
            user.setLoggedIn(true);
            this.status = Status.FINISHED;
        }
        else {
            user.setName("");
            user.setPhoneNumber("");
            user.setBankAccount("");
            user.setLoggedIn(false);
            this.status = Status.CANCELLED;
        }
    }

}
