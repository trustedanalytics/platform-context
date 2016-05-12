[![Build Status](https://travis-ci.org/trustedanalytics/platform-context.svg?branch=master)](https://travis-ci.org/trustedanalytics/platform-context)
[![Dependency Status](https://www.versioneye.com/user/projects/57236eabba37ce00350af7c2/badge.svg?style=flat)](https://www.versioneye.com/user/projects/57236eabba37ce00350af7c2)

# platform-context
Provides basic information about Trusted Analytics platform instance.

# Deployment
To run the service locally or in Cloud Foundry, the following environment variables need to be defined:

* `VCAP_SERVICES_SSO_CREDENTIALS_APIENDPOINT` - a Cloud Foundry API endpoint;
* `VCAP_SERVICES_SSO_CREDENTIALS_TOKENKEY` - an UAA endpoint for verifying token signatures;

Starting the service locally:
`mvn spring-boot:run`

