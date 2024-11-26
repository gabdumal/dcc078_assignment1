/*
 * Copyright (c) 2024 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package creational_patterns.factory_method;

// It does not implement the interface
public class ServiceAcquisition {

    public String run() {
        return "Acquisition of items completed";
    }

    public String cancel() {
        return "Acquisition of items canceled";
    }

}
