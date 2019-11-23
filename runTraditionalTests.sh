#!/bin/sh
mvn clean test -Dtest=TraditionalTests
mvn surefire-report:report-only
start ./target/site/surefire-report.html

