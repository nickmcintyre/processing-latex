add_library("latex")

def setup():
    size(640, 360)
    shapeMode(CENTER)
  
    formula = PTeX.toPShape("\\nabla \\rho = 0")
    shape(formula, 0.25 * width, 0.5 * height)
    
    fontSize = 40
    backgroundColor = color(255, 0, 0)
    textColor = color(255, 120)
    formula = PTeX.toPShape("\\nabla \\rho = 0", fontSize, backgroundColor, textColor)
    shape(formula, 0.5 * width, 0.5 * height)
    
    colorbox = "\\colorbox{black}{"
    colorbox += "\\textcolor{red}{\\nabla}"
    colorbox += "\\textcolor{yellow}{\\rho}"
    colorbox += "\\textcolor{blue}{=}"
    colorbox += "\\textcolor{green}{0}"
    colorbox += "}"
    formula = PTeX.toPShape(colorbox)
    shape(formula, 0.75 * width, 0.5 * height)
