import latex.*;

void setup() {
  size(640, 360);
  shapeMode(CENTER);

  PTeX tex = new PTeX(this);
  
  String latex = "\\nabla \\rho = 0";
  XML svg = tex.toXML(latex);
  saveXML(svg, "example.svg");
  PShape formula = loadShape("example.svg");
  shape(formula, width * 0.5, height * 0.5);
}
