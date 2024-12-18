/*
 * Copyright (c) 2024 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package creational_patterns.bridge;

public abstract class Model {

    protected String description;
    protected double baseCost;
    protected Engine engine;

    public Model(double baseCost) {
        this.baseCost = baseCost;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBaseCost(double baseCost) {
        this.baseCost = baseCost;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public abstract double calculateFinalCost();
}
