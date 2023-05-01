# DefaultApi

All URIs are relative to *https://api.example.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**usersGet**](DefaultApi.md#usersGet) | **GET** /users | Returns a list of users.

<a name="usersGet"></a>

# **usersGet**

> usersGet()

Returns a list of users.

Optional extended description in Markdown.

### Example

```java
// Import classes:

import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.example.com");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        try {
            apiInstance.usersGet();
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#usersGet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

