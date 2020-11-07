import latex.*;

void setup() {
  size(640, 360);
  shapeMode(CENTER);

  PTeX tex = new PTeX(this);

  PShape formula = tex.toPShape("\\nabla \\rho = 0");
  shape(formula, width * 0.5, height * 0.5);
}
