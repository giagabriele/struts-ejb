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

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import javax.ejb.EJB;
import javax.naming.NamingException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.exceptions.InjectionException;
import org.apache.struts.exceptions.LookupException;

/**
 *
 * @author Giacomo Stefamo Gabriele
 */
public class InjectionUtils {
    /**
     * <p>Commons Logging instance.</p>
     */
    protected static final Log log = LogFactory.getLog(InjectionUtils.class);

    public static void injection(Action action) throws InjectionException {
        try{
            for (Field field :action.getClass().getDeclaredFields()) {
                EJB ejb = field.getAnnotation(EJB.class);
                if(ejb != null){
                    if(ejb.mappedName()!=null && !ejb.mappedName().equals("")){
                         Object value = LookupUtils.lookup(ejb.mappedName());
                         injection(action, field,value);

                    }else{
                        Class clazz = field.getType();
                        Object value = LookupUtils.lookup(clazz);
                        injection(action, field,value);
                    }
                }
            }
        } catch (InjectionException ex) {
            throw ex;
        }catch(NamingException e){
            throw new LookupException(e);
        }
    }
    protected static void injection(Object action, Field field, Object value) throws InjectionException {
        try {
            field.setAccessible(true);
            field.set(action, value);
//            Method metodoSET = action.getClass().getMethod(getNameMethodSET(field.getName()), field.getType());
//            metodoSET.invoke(action, value);
        } catch (Exception e) {
            throw new InjectionException(e);
        }
    }

    protected static String getNameMethodSET(String nameField) {
        return getNameMethod(nameField, "set");
    }

    protected static String getNameMethod(String nameField, String getOrSet) {
        StringBuilder sb = new StringBuilder();
        sb.append(getOrSet);
        sb.append(nameField.substring(0, 1).toUpperCase());
        sb.append(nameField.substring(1));
        return sb.toString();
    }
}
