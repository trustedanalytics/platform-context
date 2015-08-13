# platform-context
Provides basic information about Trusted Analytics platform instance.

# Deployment
To run the service locally or in Cloud Foundry, the following environment variables need to be defined:

* `VCAP_SERVICES_SSO_CREDENTIALS_APIENDPOINT` - a Cloud Foundry API endpoint;
* `VCAP_SERVICES_SSO_CREDENTIALS_TOKENKEY` - an UAA endpoint for verifying token signatures;

Starting the service locally:
`mvn spring-boot:run`

