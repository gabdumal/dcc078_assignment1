/*
 * Copyright (c) 2024 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package creational_patterns.factory_method;

import static java.lang.Class.forName;

public class ServiceFactory {

    public static IService getService(String serviceName) {
        Class newClass = null;
        Object newObject = null;

        try {
            newClass = forName("creational_patterns.factory_method.Service" + serviceName);
            newObject = newClass.newInstance();
        } catch (Exception exception) {
            throw new IllegalArgumentException("No such service: " + serviceName);
        }

        if (!(newObject instanceof IService)) {
            throw new IllegalArgumentException("Invalid service: %s".formatted(serviceName));
        }

        return (IService) newObject;
    }

}
