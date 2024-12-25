/*
 * Copyright (c) 2024 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.automotive.services;

import assignments.automotive.vehicle.Engine.*;
import assignments.automotive.vehicle.Model.*;

public class PurchaseService
        implements IService {

    private Model model = null;
    private Status status = Status.NOT_STARTED;

    public void begin() {
        IService.super.begin();
        this.status = Status.RUNNING;
        this.model = null;
    }

    @Override
    public Status getStatus() {
        return this.status;
    }

    public void cancel() {
        IService.super.cancel();
        this.status = Status.CANCELLED;
        this.model = null;
    }

    public void run() {
        IService.super.run();
        if (model != null) {
            this.status = Status.FINISHED;
        }
        else {
            this.status = Status.CANCELLED;
        }
    }

    public void informModelAndEngine(ModelType modelType, EngineType engineType) {
        if (this.status != Status.RUNNING) {
            throw new ServiceError("The service is not running");
        }

        var engine = this.getEngine(engineType);
        var model = this.getModel(modelType);
        model.setEngine(engine);
        this.model = model;
    }

    private Engine getEngine(EngineType engineType) {
        if (engineType == EngineType.DIESEL) {
            return new Diesel();
        }
        else if (engineType == EngineType.ELECTRIC) {
            return new Electric();
        }
        else if (engineType == EngineType.ETHANOL) {
            return new Ethanol();
        }
        else if (engineType == EngineType.GASOLINE) {
            return new Gasoline();
        }
        else if (engineType == EngineType.NATURAL_GAS) {
            return new NaturalGas();
        }
        throw new IllegalArgumentException("This engine does not exist");
    }

    private Model getModel(ModelType modelType) {
        if (modelType == ModelType.HATCHBACK) {
            return new Hatchback(80000.0d);
        }
        else if (modelType == ModelType.PICKUP) {
            return new Pickup(100000.0d);
        }
        else if (modelType == ModelType.SEDAN) {
            return new Sedan(90000.0d);
        }
        throw new IllegalArgumentException("This model does not exist");
    }

    public void informHatchbackDoorsAmount(int doorsAmount) {
        if (this.status != Status.RUNNING) {
            throw new ServiceError("The service is not running");
        }
        else if (this.model == null) {
            throw new RuntimeException("The Model has not been set");
        }
        else if (!(this.model instanceof Hatchback)) {
            throw new RuntimeException("The Model is not a Hatchback");
        }
        ((Hatchback) this.model).setDoorsAmount(doorsAmount);
    }

    public void informIfPickupHasCover(boolean hasCover) {
        if (this.status != Status.RUNNING) {
            throw new ServiceError("The service is not running");
        }
        else if (this.model == null) {
            throw new RuntimeException("The Model has not been set");
        }
        else if (!(this.model instanceof Pickup)) {
            throw new RuntimeException("The Model is not a Pickup");
        }
        ((Pickup) this.model).setHasCover(hasCover);
    }

    public double calculateFinalCost() {
        if (this.status != Status.FINISHED) {
            throw new ServiceError("The service has not finished");
        }
        else if (this.model == null) {
            throw new RuntimeException("The model has not been set");
        }
        return this.model.calculateFinalCost();
    }

}
