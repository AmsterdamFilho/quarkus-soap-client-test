# quarkus-soap-client-test

This repository is intended to test the if Quarkus can consume a SOAP web service. It reuses same working code, without Quarkus, from this repository:

https://github.com/vicziani/learnwebservices

It exposes a rest api that redirects requests to some public soap web service. The master branch uses JAX-WS RI client and the cxf branch uses CXF client.

It is necessary to execute the plugin jaxws-maven-plugin:wsimport or cfx-codegen:wsdl2java (depending on the branch) before running the application.

The application can be tested using swagger-ui in dev mode.
