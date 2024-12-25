/*
 * Copyright (c) 2024 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.automotive.services;

public interface IService {

    default void begin() {
        var status = this.getStatus();
        if (status == Status.FINISHED) {
            throw new ServiceError("The service has already finished");
        }
        else if (status == Status.CANCELLED) {
            throw new ServiceError("The service has been cancelled");
        }
        else if (status == Status.RUNNING) {
            throw new ServiceError("The service is already running");
        }
    }

    Status getStatus();

    default void cancel() {
        var status = this.getStatus();
        if (status == Status.FINISHED) {
            throw new ServiceError("The service has already finished");
        }
        else if (status == Status.CANCELLED) {
            throw new ServiceError("The service has already been cancelled");
        }
        else if (status == Status.NOT_STARTED) {
            throw new ServiceError("The service has not started");
        }
    }

    default void run() {
        var status = this.getStatus();
        if (status == Status.FINISHED) {
            throw new ServiceError("The service has already finished");
        }
        else if (status == Status.CANCELLED) {
            throw new ServiceError("The service has been cancelled");
        }
        else if (status == Status.NOT_STARTED) {
            throw new ServiceError("The service has not been started");
        }
    }

}
