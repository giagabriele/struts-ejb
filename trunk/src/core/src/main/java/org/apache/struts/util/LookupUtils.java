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

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 *
 * @author Giacomo Stefamo Gabriele
 */
public class LookupUtils {
    /**
     * <p>Commons Logging instance.</p>
     */
    protected static final Log log = LogFactory.getLog(InjectionUtils.class);

    public static Object lookup(String jndiName) throws NamingException {
        log.info("JnDiName [ "+jndiName+" ]");
        Context context = new InitialContext();
        return context.lookup(jndiName);
    }
    /**
     * Called when server is glassfish
     * @param clazz
     * @return
     * @throws NamingException
     */
     public static Object lookup(Class clazz) throws NamingException {
       return lookup(clazz.getName());
     }
     
     public static Object lookup(EJB ejb) throws NamingException{
         return lookup(ejb.beanName());
     }
}
