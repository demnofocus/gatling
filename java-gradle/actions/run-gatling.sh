#!/bin/bash

# ======================================================================================================================
# Executing Gatling Tests and generating html reposts
# ======================================================================================================================

set -euo pipefail

# Print the current action for debugging
echo "Info: Starting Gatling Tests..."

# Env variables passed from workflow
SIMULATION="$1"
TEST_DURATION="$2"
RAMP_DURATION="$3"
WORKSPACE="$4"
SECRET_ID="$5"
SECRET_KEY="$6"

echo "Info: Starting Gatling Tests..."
echo "Info: Simulation: ${SIMULATION}"
echo "Info: Test duration: ${TEST_DURATION}"
echo "Info: Ramp duration: ${RAMP_DURATION}"

PROJECT_DIR="${WORKSPACE}/java-gradle"

# Navigate to the project where mvnw is located
echo "Info: Navigating to ${PROJECT_DIR} ..."
cd "${PROJECT_DIR}"

chmod +x gradlew

# Run Gatling test using Gradle Wrapper
echo "Info: Running Gradle Gatling..."
./gradlew --no-daemon --console=plain -q \
  gatlingRun \
  --simulation="${SIMULATION}" \
  -Dtest_duration="${TEST_DURATION}" \
  -Dramp_up_duration="${RAMP_DURATION}" \
  -Dsecret_id="${SECRET_ID}" \
  -Dsecret_key="${SECRET_KEY}"