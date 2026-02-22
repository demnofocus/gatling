Gatling plugin for Maven - Java ecommerce applcation load tests
============================================

A simple showcase of a Maven project using the Gatling plugin for Maven. Refer to the plugin documentation
[on the Gatling website](https://gatling.io/docs/current/extensions/maven_plugin/) for usage.

This project is written in Java, others are available for [Kotlin](https://github.com/gatling/gatling-maven-plugin-demo-kotlin)
and [Scala](https://github.com/gatling/gatling-maven-plugin-demo-scala).

It includes:

* [Maven Wrapper](https://maven.apache.org/wrapper/), so that you can immediately run Maven with `./mvnw` without having
  to install it on your computer
* minimal `pom.xml`
* latest version of `io.gatling:gatling-maven-plugin` applied
* sample [Simulation](https://gatling.io/docs/gatling/reference/current/general/concepts/#simulation) class,
  demonstrating sufficient Gatling functionality
* proper source file layout

# GitHub Actions:

## Important

Set executable permissions to run-gatling.sh in test project directory under project/actions/

To set permissions follow the below steps:
* Open GitBash in actions directory
* Check the file mode in the Git index
  * `$ git ls-tree HEAD run-gatling.sh`
    * if it shows as `100644` the file does not have executable permissions
* Set executable permissions
  * `chmod +x run-gatling.sh`
  * `git update-index --chmod=+x run-gatling.sh`
  * `git commit -m "Set execute permissions for run-gatling.sh`
* Check the file mode in the Git index, if it shows as `100755` the file now has executable permissions