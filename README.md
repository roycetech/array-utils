# array-utils

Common array utilities, only one function for now. Prefer to reuse, but I
 couldn't find what I needed, so I just wrote my own. This project is built for
 at least Java 1.8.

[![Build Status](https://travis-ci.com/roycetech/array-utils.svg?branch=master)](https://travis-ci.com/roycetech/array-utils)
[![Test Coverage](https://api.codeclimate.com/v1/badges/6330244f9f409c00e60c/test_coverage)](https://codeclimate.com/github/roycetech/array-utils/test_coverage)
[![Maintainability](https://api.codeclimate.com/v1/badges/6330244f9f409c00e60c/maintainability)](https://codeclimate.com/github/roycetech/array-utils/maintainability)
[![Maven Central](https://img.shields.io/maven-central/v/com.github.roycetech.commons/array-utils.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.github.roycetech.commons%22%20AND%20a:%22array-utils%22)

### To build

`mvn test`

### Release process

- Develop, develop, develop
- Commit any outstanding changes
- Verify build passes with `mvn test`
- Update versions to release version with `mvn versions:set -DnewVersion=1.0.2`
- Commit release version
- Run deployment with: `mvn clean deploy -P release`
- Update versions to next snapshot version: `mvn versions:set -DnewVersion=1.0.2-SNAPSHOT`
- Commit new snapshot version
- Develop, develop, develop and rinse and repeat

### References

[Working with Apache Maven](https://central.sonatype.org/pages/apache-maven.html)
