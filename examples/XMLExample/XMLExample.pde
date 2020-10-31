import latex.*;

void setup() {
  size(680, 163);
  
  String latex = "\\begin{array}{|c|l|||r|c|}";
  latex += "\\hline";
  latex += "\\text{Matrix}&\\multicolumn{2}{|c|}{\\text{Multicolumns}}&\\text{Font sizes commands}\\cr";
  latex += "\\hline";
  latex += "\\begin{pmatrix}\\alpha_{11}&\\cdots&\\alpha_{1n}\\cr\\hdotsfor{3}\\cr\\alpha_{n1}&\\cdots&\\alpha_{nn}\\end{pmatrix}&\\Large \\text{Large Right}&\\small \\text{small Left}&\\tiny \\text{tiny Tiny}\\cr";
  latex += "\\hline";
  latex += "\\multicolumn{4}{|c|}{\\Huge \\text{Huge Multicolumns}}\\cr";
  latex += "\\hline";
  latex += "\\end{array}";
  
  XML svg = PTeX.toXML(latex);
  saveXML(svg, "example.svg");
  PShape formula = loadShape("example.svg");
  shape(formula, 0, 0);
}
