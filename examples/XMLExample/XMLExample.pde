import latex.*;

void setup() {
  size(640, 360);
  shapeMode(CENTER);
  
  XML svg = PTeX.toXML("\\nabla \\rho = 0");
  saveXML(svg, "example.svg");
  PShape formula = loadShape("example.svg");
  shape(formula, width * 0.5, height * 0.5);
}
