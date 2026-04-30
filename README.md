# Java-Basics-project

## Password Policy

This policy defines the mandatory requirements a password must meet to be accepted by the system.

---

### Must-Have Criteria (Base Policy)

Every password **must** fulfil all the following requirements:

1. **Minimum length:** The password must be at least **8 characters** long.
2. **At least one digit:** The password must contain at least one digit (`0`–`9`).
3. **Upper- and lowercase letters:** The password must contain at least one uppercase letter (`A`–`Z`) **and** at least one lowercase letter (`a`–`z`). Passwords that are entirely uppercase or entirely lowercase will be rejected.
4. **No weak or commonly used passwords:** The password must not appear on the stored blocklist of frequently used or compromised passwords (e.g. `password1`, `Passwort1`, `Qwertz12`). The blocklist is based on well-known leak databases (e.g. [HaveIBeenPwned](https://haveibeenpwned.com/Passwords)) and is updated regularly.
5. Must use minimum one **special** character ("`!@#$%^&*()-_+=?.,;:`")

---

### Quick Overview

| Criterion                                  | Base |
|--------------------------------------------|:----:|
| At least 8 characters                      |  ✅   |
| At least one digit (0–9)                   |  ✅   |
| Upper- **and** lowercase letters           |  ✅   |
| Not on the weak-password blocklist         |  ✅   |
| Must use minimum one **special** character |  ✅   |

---

## Build, Run & Tests

### Lokal

```bash
mvn clean verify       # kompilieren + alle Tests ausführen
mvn package            # JAR bauen → target/*.jar
java -jar target/*.jar # JAR starten
` `` 

### CI

![CI Status](https://github.com/bjoern64234/java-basics-projekt.git/actions/workflows/ci.yml/badge.svg)