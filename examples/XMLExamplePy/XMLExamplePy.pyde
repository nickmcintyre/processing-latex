add_library("latex")

def setup():
    size(640, 360)
    shapeMode(CENTER)

    tex = PTeX(this)
  
    latex = "\\nabla \\rho = 0"
    svg = tex.toXML(latex)
    saveXML(svg, "example.svg")
    formula = loadShape("example.svg")
    shape(formula, width * 0.5, height * 0.5)
