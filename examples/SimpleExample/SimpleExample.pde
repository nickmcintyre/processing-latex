import latex.*;
import java.io.IOException;

PShape tex;

void setup() {
  size(680, 163);
  
  generateSVG();
  tex = loadShape("Example5_shaped.svg");
  shape(tex, 0, 0);
}

void generateSVG() {
  String latex = "\\begin{array}{|c|l|||r|c|}";
  latex += "\\hline";
  latex += "\\text{Matrix}&\\multicolumn{2}{|c|}{\\text{Multicolumns}}&\\text{Font sizes commands}\\cr";
  latex += "\\hline";
  latex += "\\begin{pmatrix}\\alpha_{11}&\\cdots&\\alpha_{1n}\\cr\\hdotsfor{3}\\cr\\alpha_{n1}&\\cdots&\\alpha_{nn}\\end{pmatrix}&\\Large \\text{Large Right}&\\small \\text{small Left}&\\tiny \\text{tiny Tiny}\\cr";
  latex += "\\hline";
  latex += "\\multicolumn{4}{|c|}{\\Huge \\text{Huge Multicolumns}}\\cr";
  latex += "\\hline";
  latex += "\\end{array}";
  println(latex);
  try {
    Convert.toSVG(latex, dataPath("Example5.svg"), false);
    Convert.toSVG(latex, dataPath("Example5_shaped.svg"), true);
  } catch (IOException ex) {
    throw new RuntimeException(ex);
  }
}
