/*
 *  Copyright 2010 giacomo.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */
package org.apache.struts.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.ejb.EJB;

/**
 *
 * @author Giacomo Stefano Gabriele
 */
public class AnnotationUtils {
    /**
     * 
     * @param clazz
     * @return
     */
    public static Map<Field,EJB> getEjb(Object action) {
        Map<Field,EJB> lista = new HashMap<Field, EJB>();

        for (Field field : action.getClass().getDeclaredFields()) {
            for (Annotation annotation : field.getDeclaredAnnotations()) {
                if (annotation instanceof EJB) {
                    lista.put(field,(EJB)annotation);
                }
            }
        }
        return lista;
    }

    public static Map<Field,Resource>getResources(Object action) {
        Map<Field,Resource> lista = new HashMap<Field, Resource>();

        for (Field field : action.getClass().getDeclaredFields()) {
            for (Annotation annotation : field.getDeclaredAnnotations()) {
                if (annotation instanceof Resource) {
                    lista.put(field,(Resource)annotation);
                }
            }
        }
        return lista;
    }
}
