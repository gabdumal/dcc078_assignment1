/*
 * Copyright (c) 2024 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.automotive.services;

import assignments.automotive.store.User;

public class LoginService
        implements IService {

    private Status status = Status.NOT_STARTED;

    public LoginService() {
        User.resetInstance();
    }

    public User getUser() {
        if (this.status != Status.FINISHED) {
            throw new ServiceError("The service has not finished");
        }
        return User.getInstance();
    }

    public void begin() {
        IService.super.begin();
        this.status = Status.RUNNING;
        User.resetInstance();
    }

    @Override
    public Status getStatus() {
        return this.status;
    }

    public void cancel() {
        IService.super.cancel();
        this.status = Status.CANCELLED;
        User.resetInstance();
    }

    public void run() {
        IService.super.run();

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
            User.resetInstance();
            this.status = Status.CANCELLED;
        }
    }

    public void informUsernameAndPassword(String username, String password) {
        if (this.status != Status.RUNNING) {
            throw new ServiceError("The service is not running");
        }

        var user = User.getInstance();
        user.setUsername(username);
        user.setPassword(password);
    }

}
