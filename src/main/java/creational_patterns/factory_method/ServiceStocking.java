/*
 * Copyright (c) 2024.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package creational_patterns.factory_method;

public class ServiceStocking implements IService {

    public String run() {
        return "Stocking of products completed";
    }

    @Override
    public String cancel() {
        return "Stocking of products canceled";
    }
}
