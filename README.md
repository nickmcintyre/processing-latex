# processing-latex
**Beautiful typesetting with Processing.**

- Thin wrapper around [JLaTeXMath](https://github.com/opencollab/jlatexmath).
- Works in Python mode.
- Still early days. Things will break.

## Example
The following example converts a LaTeX string to a `PShape` object, then displays it.

```java
import latex.*;

void setup() {
  size(640, 360);
  shapeMode(CENTER);

  PShape formula = PTeX.toPShape("\\nabla \\rho = 0");
  shape(formula, width * 0.5, height * 0.5);
}
```
