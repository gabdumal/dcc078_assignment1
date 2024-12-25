/*
 * Copyright (c) 2024 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.automotive.vehicle.Model;

public class Hatchback extends Model {

    private int doorsAmount;

    public Hatchback(double baseCost) {
        super(baseCost);
        this.doorsAmount = 4;
    }

    public void setDoorsAmount(int doorsAmount) {
        if (doorsAmount < 2) {
            throw new IllegalArgumentException("Um carro deve ter ao menos duas portas.");
        }
        if (doorsAmount > 4) {
            throw new IllegalArgumentException("Um carro não pode ter mais de quatro portas.");
        }
        this.doorsAmount = doorsAmount;
    }

    @Override
    public double calculateFinalCost() {
        double cost = this.baseCost * (1 + this.engine.costIncreasePercentage());
        double doorsDiscount = (4 - this.doorsAmount) * 1000.0d;
        return cost - doorsDiscount;
    }

}
