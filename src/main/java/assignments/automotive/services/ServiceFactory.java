/*
 * Copyright (c) 2024 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.automotive.services;

import static java.lang.Class.forName;

public class ServiceFactory {

    public static assignments.automotive.services.IService getService(String serviceName) {
        Class newClass = null;
        Object newObject = null;

        try {
            newClass = forName("assignments.automotive.services." + serviceName + "Service");
            newObject = newClass.newInstance();
        }
        catch (Exception exception) {
            throw new IllegalArgumentException("No such service: " + serviceName);
        }

        if (!(newObject instanceof assignments.automotive.services.IService)) {
            throw new IllegalArgumentException("Invalid service: %s".formatted(serviceName));
        }

        return (IService) newObject;
    }

}
