/*
 * Sample API
 * API description in Markdown.
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.api;

import org.openapitools.client.ApiException;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for DefaultApi
 */
@Ignore
public class DefaultApiTest {

    private final DefaultApi api = new DefaultApi();

    
    /**
     * Returns a list of users.
     *
     * Optional extended description in Markdown.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void usersGetTest() throws ApiException {
        api.usersGet();

        // TODO: test validations
    }
    
}
