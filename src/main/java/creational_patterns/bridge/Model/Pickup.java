/*
 * Copyright (c) 2024 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package creational_patterns.bridge.Model;

public class Pickup extends Model {

    boolean hasCover;

    public Pickup(double baseCost) {
        super(baseCost);
        this.hasCover = false;
    }

    public void setHasCover(boolean hasCover) {
        this.hasCover = hasCover;
    }

    @Override
    public double calculateFinalCost() {
        double cost = this.baseCost * (1 + this.engine.costIncreasePercentage());
        if (this.hasCover) {
            cost += 5000.0d;
        }
        return cost;
    }

}
