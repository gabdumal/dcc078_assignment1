/*
 * Copyright (c) 2024 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package creational_patterns.bridge;

import creational_patterns.bridge.Engine.*;
import creational_patterns.bridge.Model.Sedan;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SedanTest {

    @Test
    void shouldReturnSedanCostWithGasoline() {
        Engine engine = new Gasoline();
        Sedan sedan = new Sedan(80000.0d);
        sedan.setEngine(engine);
        assertEquals(86000.0d, sedan.calculateFinalCost());
    }

    @Test
    void shouldReturnSedanCostWithDiesel() {
        Engine engine = new Diesel();
        Sedan sedan = new Sedan(80000.0d);
        sedan.setEngine(engine);
        assertEquals(87200.0d, sedan.calculateFinalCost());
    }

    @Test
    void shouldReturnSedanCostWithEthanol() {
        Engine engine = new Ethanol();
        Sedan sedan = new Sedan(80000.0d);
        sedan.setEngine(engine);
        assertEquals(88000.0d, sedan.calculateFinalCost());
    }

    @Test
    void shouldReturnSedanCostWithNaturalGas() {
        Engine engine = new NaturalGas();
        Sedan sedan = new Sedan(80000.0d);
        sedan.setEngine(engine);
        assertEquals(90000.0d, sedan.calculateFinalCost());
    }

    @Test
    void shouldReturnSedanCostWithElectric() {
        Engine engine = new Electric();
        Sedan sedan = new Sedan(80000.0d);
        sedan.setEngine(engine);
        assertEquals(92000.0d, sedan.calculateFinalCost());
    }

}
