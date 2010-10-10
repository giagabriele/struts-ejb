/*
 *  Copyright 2010 Giacomo Gabriele Stefano.
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
package org.apache.struts.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author Giacomo Gabriele Stefano
 */
@Retention(RetentionPolicy.CLASS)
public @interface Action {

    /**
     * <p>The internal name of this action mapping. If an action has a name, it may be used
     * as a shortcut in a URI. For example, an action with an identification of "editPerson"
     * may be internally forwarded as "editPerson?id=1" which will then resolve to the
     * real URI path at execution time.</p>
     *
     * @return the actionId
     * @since Struts 1.3.6
     */
    public String actionId();

    /**
     * <p>
     * Context-relative path of the submitted request, starting with a
     * slash ("/") character, and omitting any filename extension if extension
     * mapping is being used.
     *</p>
     */
    public String path();

    /**
     *<p>
     * The formBean associated whit this Action
     * </p>
     */
    public FormBean formbean();

    /**
     * <p>
     * Scope ("request" or "session") within which our form bean is accessed, if any.
     * </p>
     */
    public Scope scope() default Scope.REQUEST;

    /**
     *<p>
     * Prefix used to match request parameter names to form bean property names, if any.
     * </p>
     */
    public String prefix();

    public boolean validate() default false;

    /**
     * <p>
     * Context-relative path of the input form to which control
     * should be returned if a validation error is encountered.  Required if
     * "formBean" is specified and the input bean returns validation errors.
     *</p>
     */
    public String input();

    /**
     * <p>
     * General purpose configuration parameter that can be used to pass
     * extra information to the Action instance selected by this Action.
     * Struts does not itself use this value in any way.
     *</p>
     */
    public String parameter();

    /**
     * <p>
     * Request-scope or session-scope attribute name under which
     * our form bean is accessed, if it is different from the form bean's
     * specified <code>name</code>.
     * </p>
     */
    public String attribute();

    /**
     * <p>Mutator for for cancellable property</p>
     */
    public boolean concelable() default false;

    /**
     * <p>
     * Path of the ActionConfig that this object should inherit
     * properties from.
     * </p>
     */
    public String extend();

    /**
     * <p>
     * Context-relative path of the web application resource that will
     * process this request. Exactly one of <code>forward</code>,
     * <code>include</code>, or <code>type</code> must be specified.
     * </p>
     */
    public String include();

    public String roles();

    /**
     * <p>
     * Suffix used to match request parameter names to form bean property names, if any.
     * </p>
     */
    public String suffix();

    /**
     * <p>
     * Determine whether Action is configured as the default one for this
     * module. </p>
     */
    public boolean unknown();

    /**
     * <p>
     * Get the name of a <code>commons-chain</code> command which should
     * be executed as part of the processing of this action.
     * </p>
     * @since Struts 1.3.0
     */
    public String command();

    /**
     * <p>
     * Get the name of a <code>commons-chain</code> catalog in which a
     * specified command should be sought.  This is likely to be infrequently
     * used after a future release of <code>commons-chain</code> supports a
     * one-string expression of a catalog/chain combination.
     * </p>
     * @since Struts 1.3.0
     */
    public String catalog();

    /**
     * <p>
     * The ActionForwards associated with this Action
     * </p>
     */
    public Forwards forwards();
}
