/*
 * Copyright (c) 2024.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package creational_patterns.factory_method;

public class ServiceSale implements IService {

    public String run() {
        return "Sale of products completed";
    }

    @Override
    public String cancel() {
        return "Sale of products canceled";
    }
}
