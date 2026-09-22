# Upgrade Plan: rollerspeed (20260904235239)

- **Generated**: 2026-09-04
- **HEAD Branch**: N/A
- **HEAD Commit ID**: N/A

## Available Tools

**JDKs**
- JDK 17.0.20.1: `C:\Users\USUARIO\AppData\Roaming\Code\User\globalStorage\pleiades.java-extension-pack-jdk\java\17\bin` (current project JDK, baseline)
- JDK 25.0.4.1: `C:\Users\USUARIO\AppData\Roaming\Code\User\globalStorage\pleiades.java-extension-pack-jdk\java\25\bin` (target runtime)

**Build Tools**
- Maven Wrapper: 3.9.16 at `mvnw.cmd`

Version control is unavailable because this workspace is not a Git repository; changes will remain uncommitted in the working directory.

## Guidelines

> Note: You can add any specific guidelines or constraints for the upgrade process here if needed, bullet points are preferred.

## Options

- Working branch: N/A (version control unavailable)
- Run tests before and after the upgrade: true

## Upgrade Goals

- Java runtime and compilation target: 25

## Technology Stack

| Technology/Dependency | Current | Min Compatible Version | Why Incompatible |
| --------------------- | ------- | ---------------------- | ---------------- |
| Java | 17 | 25 | User requested latest LTS runtime |
| Spring Boot | 4.0.8 | 4.0.8 | Already compatible with Java 25 |
| Maven Wrapper | 3.9.16 | 3.9.0 | Already compatible and current |
| spring-boot-maven-plugin | Managed by Spring Boot 4.0.8 | 4.0.8 | No upgrade required |

## Derived Upgrades

- Java 25 requires a compatible compiler/runtime; the existing Maven Wrapper 3.9.16 satisfies the build-tool requirement.
- Kotlin is not used, so no Kotlin version change is required.
- Spring Boot 4.0.8 already provides the framework and Jakarta dependencies needed for this Java target.

## Impact Analysis

### Dependency Changes

| File | Dependency | Current | Action | Target | Reason |
|------|------------|---------|--------|--------|--------|
| `pom.xml` | `java.version` | 17 | upgrade | 25 | Set Maven compiler and Spring Boot's Java baseline to the requested LTS runtime |

### Source Code Changes

No source changes are expected. The application uses standard Spring Boot APIs and has no Java-version-specific or removed API usage identified.

### Configuration Changes

No application configuration changes are required. `application.properties` contains only the application name.

### CI/CD Changes

No CI/CD files are present in the workspace.

### Risks & Warnings

- **Runtime environment alignment**: Local builds and deployments must use JDK 25; the POM target alone does not install Java on deployment hosts. **Mitigation**: Verify the final build and tests with the installed JDK 25.
- **Database context test**: The existing context test may require external PostgreSQL configuration at runtime. **Mitigation**: Run the complete test suite and fix any failure rather than treating it as pre-existing.
- **Version control unavailable**: No commits or branch can be created. **Mitigation**: Keep all upgrade artifacts and source changes in the workspace and report exact validation results.

## Upgrade Steps

- Step 1: Setup Environment
  - **Rationale**: Confirm the target JDK and Maven wrapper are available before changing project files.
  - **Changes to Make**: Use the installed JDK 25 and Maven Wrapper 3.9.16; no installation is required.
  - **Verification**: Confirm JDK 25.0.4.1 and wrapper Maven 3.9.16 are available.

- Step 2: Setup Baseline
  - **Rationale**: Capture current Java 17 compilation and test behavior for comparison.
  - **Changes to Make**: None.
  - **Verification**: `mvnw.cmd -B clean compile test-compile` and `mvnw.cmd -B clean test` with JDK 17; record results.

- Step 3: Upgrade Java Target
  - **Rationale**: Apply the only required project change: compile and run against Java 25.
  - **Changes to Make**: Apply the Dependency Changes entry for `pom.xml`.
  - **Verification**: `mvnw.cmd -B clean test-compile` with JDK 25; expected result is successful main and test compilation.

- Step 4: Final Validation
  - **Rationale**: Confirm the requested runtime target and full behavioral compatibility.
  - **Changes to Make**: Resolve any Java 25 compilation or test failures discovered during validation.
  - **Verification**: `mvnw.cmd -B clean test` with JDK 25; expected result is 100% tests passing.

- Step 5: CVE Validation & Fix
  - **Rationale**: Check direct dependencies after the upgrade and remediate any reported vulnerable versions.
  - **Changes to Make**: Upgrade only affected dependency properties or BOM versions if a vulnerability is reported.
  - **Verification**: Compile successfully and re-scan dependencies; expected result is no unresolved fixable CVEs.
