Gatling plugin for Maven - Java demo project
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

GitHub Actions
==============
### Important
This project uses GitHub composite actions

Set executable permissions to "mvnw" and "run-gatling.sh"
1. Give permission in Bash:
   * Use `chmod +x {filename)`. eg: `chmod +x mvnw`
2. Set permissions:
   * Open GitBash in actions directory
   * Check the file mode in the Git index
     * `$ git ls-tree HEAD run-gatling.sh`
       * if it shows as `100644` the file does not have executable permissions
   * Set executable permissions
     * `chmod +x run-gatling.sh`
     * `git update-index --chmod=+x run-gatling.sh`
     * `git commit -m "Set execute permissions for run-gatling.sh`
   * Check the file mode in the Git index, if it shows as `100755` the file now has executable permissions

To reduce noice of logs use the following log-suppression techniques in bash:
* `-q` for quiet mode
  * Hides:
    * [INFO] Scanning for projects
    * Dependency download logs
    * Progress bars
    * Still shows errors
* `> /dev/null` to redirect stdout to /dev/null (Linux black hole)
* `-B` A Maven flag for batch mode (Disables interactive formatting)
  * For Maven run use `./mvnw -q -B clean gatling:test`