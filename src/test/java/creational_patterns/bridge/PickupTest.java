/*
 * Copyright (c) 2024 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package creational_patterns.bridge;

import creational_patterns.bridge.Engine.*;
import creational_patterns.bridge.Model.Pickup;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PickupTest {

    @Test
    void shouldReturnPickupCostWithGasolineWithoutCover() {
        Engine engine = new Gasoline();
        Pickup pickup = new Pickup(100000.0d);
        pickup.setEngine(engine);
        assertEquals(107500.0d, pickup.calculateFinalCost(), 0.0001d);
    }

    @Test
    void shouldReturnPickupCostWithGasolineWithCover() {
        Engine engine = new Gasoline();
        Pickup pickup = new Pickup(100000.0d);
        pickup.setEngine(engine);
        pickup.setHasCover(true);
        assertEquals(112500.0d, pickup.calculateFinalCost(), 0.0001d);
    }

    @Test
    void shouldReturnPickupCostWithDieselWithoutCover() {
        Engine engine = new Diesel();
        Pickup pickup = new Pickup(100000.0d);
        pickup.setEngine(engine);
        assertEquals(109000.0d, pickup.calculateFinalCost(), 0.0001d);
    }

    @Test
    void shouldReturnPickupCostWithDieselWithCover() {
        Engine engine = new Diesel();
        Pickup pickup = new Pickup(100000.0d);
        pickup.setEngine(engine);
        pickup.setHasCover(true);
        assertEquals(114000.0d, pickup.calculateFinalCost(), 0.0001d);
    }

    @Test
    void shouldReturnPickupCostWithEthanolWithoutCover() {
        Engine engine = new Ethanol();
        Pickup pickup = new Pickup(100000.0d);
        pickup.setEngine(engine);
        assertEquals(110000.0d, pickup.calculateFinalCost(), 0.0001d);
    }

    @Test
    void shouldReturnPickupCostWithEthanolWithCover() {
        Engine engine = new Ethanol();
        Pickup pickup = new Pickup(100000.0d);
        pickup.setEngine(engine);
        pickup.setHasCover(true);
        assertEquals(115000.0d, pickup.calculateFinalCost(), 0.0001d);
    }

    @Test
    void shouldReturnPickupCostWithNaturalGasWithoutCover() {
        Engine engine = new NaturalGas();
        Pickup pickup = new Pickup(100000.0d);
        pickup.setEngine(engine);
        assertEquals(112500.0d, pickup.calculateFinalCost(), 0.0001d);
    }

    @Test
    void shouldReturnPickupCostWithNaturalGasWithCover() {
        Engine engine = new NaturalGas();
        Pickup pickup = new Pickup(100000.0d);
        pickup.setEngine(engine);
        pickup.setHasCover(true);
        assertEquals(117500.0d, pickup.calculateFinalCost(), 0.0001d);
    }

    @Test
    void shouldReturnPickupCostWithElectricWithoutCover() {
        Engine engine = new Electric();
        Pickup pickup = new Pickup(100000.0d);
        pickup.setEngine(engine);
        assertEquals(115000.0d, pickup.calculateFinalCost(), 0.0001d);
    }

    @Test
    void shouldReturnPickupCostWithElectricWithCover() {
        Engine engine = new Electric();
        Pickup pickup = new Pickup(100000.0d);
        pickup.setEngine(engine);
        pickup.setHasCover(true);
        assertEquals(120000.0d, pickup.calculateFinalCost(), 0.0001d);
    }

}
