add_library("latex")

def setup():
    size(640, 360)
    shapeMode(CENTER)

    tex = PTeX(this)
  
    formula = tex.toPShape("\\nabla \\rho = 0")
    shape(formula, width * 0.5, height * 0.5)
