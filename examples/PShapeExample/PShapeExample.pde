import latex.*;

void setup() {
  size(640, 360);
  shapeMode(CENTER);

  PShape formula = PTeX.toPShape("\\nabla \\rho = 0");
  shape(formula, width * 0.5, height * 0.5);
}
