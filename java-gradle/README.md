Gatling plugin for Gradle - Java demo project
=============================================

A simple showcase of a Gradle project using the Gatling plugin for Gradle. Refer to the plugin documentation
[on the Gatling website](https://docs.gatling.io/reference/integrations/build-tools/gradle-plugin/) for usage.

This project is written in Java, others are available for [Kotlin](https://github.com/gatling/gatling-gradle-plugin-demo-kotlin)
and [Scala](https://github.com/gatling/gatling-gradle-plugin-demo-scala).

It includes:

* Gradle Wrapper, so you don't need to install Gradle (a JDK must be installed and $JAVA_HOME configured)
* minimal `build.gradle` leveraging Gradle wrapper
* latest version of `io.gatling.gradle` plugin applied
* sample [Simulation](https://docs.gatling.io/reference/glossary/#simulation) class,
demonstrating sufficient Gatling functionality
* proper source file layout
* "gradle-wrapper.jar" should be commited to origin

GitHub Actions
==============
### Important
This project uses GitHub composite actions

Set executable permissions to "gradlew" and "run-gatling.sh"

1. Give permission in Bash: 
   * Use `chmod +x {filename)`. eg: `chmod +x gradlew`

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
* `--console=plain` to disable fancy console formatting and just print normal text.
    * Gradle supports different console modes:
        * `rich` (default locally) → progress bars, animated updates
        * `plain` → simple text output
        * For Gradle use: `./gradlew --no-daemon --console=plain -q gatlingRun`

Run with `--no-daemon`

Gradle normally runs with a background daemon process to speed up local builds. In CI (GitHub Actions) each runner is temporary and there’s no benefit to daemon reuse
