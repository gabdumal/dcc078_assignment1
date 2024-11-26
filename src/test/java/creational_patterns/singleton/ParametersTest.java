/*
 * Copyright (c) 2024 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package creational_patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParametersTest {

    @Test
    public void shouldReturnStoreName() {
        Parameters.getInstance().setStoreName("Doces de Cristal");
        assertEquals("Doces de Cristal", Parameters.getInstance().getStoreName());
    }

    @Test
    public void shouldReturnLoggedUsername() {
        Parameters.getInstance().setLoggedUsername("Gabriel");
        assertEquals("Gabriel", Parameters.getInstance().getLoggedUsername());
    }

}
