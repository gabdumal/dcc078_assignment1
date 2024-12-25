/*
 * Copyright (c) 2024 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.automotive;

import assignments.automotive.services.LoginService;
import assignments.automotive.services.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    @Test
    void shouldGetStatusOfNotRunningFromLoginService() {
        LoginService loginService = new LoginService();
        assertSame(Status.NOT_STARTED, loginService.getStatus());
    }

    @Test
    void shouldLogin() {
        LoginService loginService = new LoginService();

        loginService.begin();
        loginService.informUsernameAndPassword("gabriel", "banana");
        loginService.tryToLogin();
        var user = loginService.getUser();

        assertTrue(user.isLoggedIn() && loginService.getStatus() == Status.FINISHED);
    }

    @Test
    void shouldNotLoginBecauseUsernameAndPasswordHaveNotBeenInformed() {
        LoginService loginService = new LoginService();

        loginService.begin();
        loginService.tryToLogin();
        var user = loginService.getUser();

        assertTrue(!user.isLoggedIn() && loginService.getStatus() == Status.CANCELLED);
    }

    @Test
    void shouldNotLoginBecauseUsernameAndPasswordWereWrong() {
        LoginService loginService = new LoginService();

        loginService.begin();
        loginService.informUsernameAndPassword("ana", "abacaxi");
        loginService.tryToLogin();
        var user = loginService.getUser();

        assertTrue(!user.isLoggedIn() && loginService.getStatus() == Status.CANCELLED);
    }

}
