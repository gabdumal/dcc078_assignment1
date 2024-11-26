/*
 * Copyright (c) 2024.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package creational_patterns.factory_method;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ServiceFactoryTest {

    @Test
    void shouldReturnExceptionForNonexistentService() {
        try {
            IService service = ServiceFactory.getService("Repairing");
            fail();
        } catch (IllegalArgumentException exception) {
            assertEquals("No such service: Repairing", exception.getMessage());
        }
    }

    @Test
    void shouldReturnExceptionForInvalidService() {
        try {
            IService service = ServiceFactory.getService("Acquisition");
            fail();
        } catch (IllegalArgumentException exception) {
            assertEquals("Invalid service: Acquisition", exception.getMessage());
        }
    }

}
