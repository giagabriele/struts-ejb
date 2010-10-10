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

package org.apache.struts.action;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.exceptions.InjectionException;
import org.apache.struts.util.AnnotationUtils;
import org.apache.struts.util.InjectionUtils;

/**
 *
 * @author Giacomo Stefamo Gabriele
 */
public class EjbRequestProcessor extends RequestProcessor{

    @Override
    protected Action processActionCreate(HttpServletRequest request, HttpServletResponse response, ActionMapping mapping) throws IOException {
        Action action = super.processActionCreate(request, response, mapping);
        try {
            InjectionUtils.injection(action);
            return action;
        } catch (InjectionException ex) {
            log.warn("Injection Failure!!!!", ex);
        }
        return action;
    }


}
