/*
 * Copyright (c) 2024 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.automotive;

import assignments.automotive.services.ServiceFactory;
import assignments.automotive.services.ServiceLogin;
import assignments.automotive.services.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    @Test
    void shouldGetStatusOfNotRunningFromLoginService() {
        var login = ServiceFactory.getService("Login");
        assertSame(Status.NOT_STARTED, login.getStatus());
    }

    @Test
    void shouldLogin() {
        var login = (ServiceLogin) ServiceFactory.getService("Login");

        login.begin();
        login.informUsernameAndPassword("gabriel", "banana");
        login.tryToLogin();
        var user = login.getUser();

        assertTrue(user.isLoggedIn() && login.getStatus() == Status.FINISHED);
    }

    @Test
    void shouldNotLoginBecauseUsernameAndPasswordHaveNotBeenInformed() {
        var login = (ServiceLogin) ServiceFactory.getService("Login");

        login.begin();
        login.tryToLogin();
        var user = login.getUser();

        assertTrue(!user.isLoggedIn() && login.getStatus() == Status.CANCELLED);
    }

    @Test
    void shouldNotLoginBecauseUsernameAndPasswordWereWrong() {
        var login = (ServiceLogin) ServiceFactory.getService("Login");

        login.begin();
        login.informUsernameAndPassword("ana", "abacaxi");
        login.tryToLogin();
        var user = login.getUser();

        assertTrue(!user.isLoggedIn() && login.getStatus() == Status.CANCELLED);
    }

}
