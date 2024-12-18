/*
 * Copyright (c) 2024 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package creational_patterns.bridge;

import creational_patterns.bridge.Engine.*;
import creational_patterns.bridge.Model.Hatchback;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HatchbackTest {

    @Test
    void shouldNotAllowHatchbackWithOneDoor() {
        Hatchback hatchback = new Hatchback(60000.0d);
        assertThrows(IllegalArgumentException.class, () -> {
                    hatchback.setDoorsAmount(1);
                }
        );
    }

    @Test
    void shouldNotAllowHatchbackWithFiveDoors() {
        Hatchback hatchback = new Hatchback(60000.0d);
        assertThrows(IllegalArgumentException.class, () -> {
                    hatchback.setDoorsAmount(5);
                }
        );
    }

    @Test
    void shouldReturnHatchbackCostWithGasolineWithTwoDoors() {
        Engine engine = new Gasoline();
        Hatchback hatchback = new Hatchback(60000.0d);
        hatchback.setEngine(engine);
        hatchback.setDoorsAmount(2);
        assertEquals(62500.0d, hatchback.calculateFinalCost());
    }

    @Test
    void shouldReturnHatchbackCostWithGasolineWithThreeDoors() {
        Engine engine = new Gasoline();
        Hatchback hatchback = new Hatchback(60000.0d);
        hatchback.setEngine(engine);
        hatchback.setDoorsAmount(3);
        assertEquals(63500.0d, hatchback.calculateFinalCost());
    }

    @Test
    void shouldReturnHatchbackCostWithGasolineWithFourDoors() {
        Engine engine = new Gasoline();
        Hatchback hatchback = new Hatchback(60000.0d);
        hatchback.setEngine(engine);
        hatchback.setDoorsAmount(4);
        assertEquals(64500.0d, hatchback.calculateFinalCost());
    }

    @Test
    void shouldReturnHatchbackCostWithDieselWithTwoDoors() {
        Engine engine = new Diesel();
        Hatchback hatchback = new Hatchback(60000.0d);
        hatchback.setEngine(engine);
        hatchback.setDoorsAmount(2);
        assertEquals(63400.0d, hatchback.calculateFinalCost());
    }

    @Test
    void shouldReturnHatchbackCostWithDieselWithThreeDoors() {
        Engine engine = new Diesel();
        Hatchback hatchback = new Hatchback(60000.0d);
        hatchback.setEngine(engine);
        hatchback.setDoorsAmount(3);
        assertEquals(64400.0d, hatchback.calculateFinalCost());
    }

    @Test
    void shouldReturnHatchbackCostWithDieselWithFourDoors() {
        Engine engine = new Diesel();
        Hatchback hatchback = new Hatchback(60000.0d);
        hatchback.setEngine(engine);
        hatchback.setDoorsAmount(4);
        assertEquals(65400.0d, hatchback.calculateFinalCost());
    }

    @Test
    void shouldReturnHatchbackCostWithEthanolWithTwoDoors() {
        Engine engine = new Ethanol();
        Hatchback hatchback = new Hatchback(60000.0d);
        hatchback.setEngine(engine);
        hatchback.setDoorsAmount(2);
        assertEquals(64000.0d, hatchback.calculateFinalCost());
    }

    @Test
    void shouldReturnHatchbackCostWithEthanolWithThreeDoors() {
        Engine engine = new Ethanol();
        Hatchback hatchback = new Hatchback(60000.0d);
        hatchback.setEngine(engine);
        hatchback.setDoorsAmount(3);
        assertEquals(65000.0d, hatchback.calculateFinalCost());
    }

    @Test
    void shouldReturnHatchbackCostWithEthanolWithFourDoors() {
        Engine engine = new Ethanol();
        Hatchback hatchback = new Hatchback(60000.0d);
        hatchback.setEngine(engine);
        hatchback.setDoorsAmount(4);
        assertEquals(66000.0d, hatchback.calculateFinalCost());
    }

    @Test
    void shouldReturnHatchbackCostWithNaturalGasWithTwoDoors() {
        Engine engine = new NaturalGas();
        Hatchback hatchback = new Hatchback(60000.0d);
        hatchback.setEngine(engine);
        hatchback.setDoorsAmount(2);
        assertEquals(65500.0d, hatchback.calculateFinalCost());
    }

    @Test
    void shouldReturnHatchbackCostWithNaturalGasWithThreeDoors() {
        Engine engine = new NaturalGas();
        Hatchback hatchback = new Hatchback(60000.0d);
        hatchback.setEngine(engine);
        hatchback.setDoorsAmount(3);
        assertEquals(66500.0d, hatchback.calculateFinalCost());
    }

    @Test
    void shouldReturnHatchbackCostWithNaturalGasWithFourDoors() {
        Engine engine = new NaturalGas();
        Hatchback hatchback = new Hatchback(60000.0d);
        hatchback.setEngine(engine);
        hatchback.setDoorsAmount(4);
        assertEquals(67500.0d, hatchback.calculateFinalCost());
    }

    @Test
    void shouldReturnHatchbackCostWithElectricWithTwoDoors() {
        Engine engine = new Electric();
        Hatchback hatchback = new Hatchback(60000.0d);
        hatchback.setEngine(engine);
        hatchback.setDoorsAmount(2);
        assertEquals(67000.0d, hatchback.calculateFinalCost());
    }

    @Test
    void shouldReturnHatchbackCostWithElectricWithThreeDoors() {
        Engine engine = new Electric();
        Hatchback hatchback = new Hatchback(60000.0d);
        hatchback.setEngine(engine);
        hatchback.setDoorsAmount(3);
        assertEquals(68000.0d, hatchback.calculateFinalCost());
    }

    @Test
    void shouldReturnHatchbackCostWithElectricWithFourDoors() {
        Engine engine = new Electric();
        Hatchback hatchback = new Hatchback(60000.0d);
        hatchback.setEngine(engine);
        hatchback.setDoorsAmount(4);
        assertEquals(69000.0d, hatchback.calculateFinalCost());
    }

}
