Repo: gatling
=============
This Repo Consist of Sample Gatling Perf Testing Java Project.

Read the individual project "README.md" for more insight

Also includes GitHub Action CI execution setup to run each project without conflict from main branch.

Projects
========
### 1. java-maven
Java Maven project with sample perf test scripts

### 2. java-gradle
Java Gradle project with sample perf test scripts

Test Simulations
================
1. LoadTest: 
   
   Simulates continuous steady load (usually average or max load in Prod) during test time duration along with a ramp-up time for ramping up users.
2. StressTest

   Simulates stressed continuous steady load (usually X times the LoadTest load) during test time duration along with a ramp-up time for ramping up users.
3. BreakpointTest

   Simulates increasing load at a controlled rate with ramp-up periods and steady periods for each user count level.