# Tick Tack Toe
# Not working. WIP

class SeaChess
  def initialize()
    @arr2 = Array.new(9, -1)
  end

  def play()
    i = 1
    userInput = "not win"
    while i < 10 || userInput == "win"
      if i % 2 == 0
        puts "user 1: "
        userInput = getUserInput("x")
        while(userInput == '*')
          puts "user 1: "
          userInput = getUserInput("x")
        end
      else
        puts "user 2: "
        userInput = getUserInput("o")
        while(userInput == '*')
          puts "user 2: "
          userInput = getUserInput("o")
        end
      end
      i = i + 1
    end
    puts "Game Over"
  end

  def getUserInput(symbol)
    userRow = (gets.chomp).to_i
    userCol = (gets.chomp).to_i
    u1CurPos = 3*userRow+userCol
    if @arr2[u1CurPos] != -1 || @arr2[u1CurPos] == "x" || @arr2[u1CurPos] == "o"
      return "*"
    else
      @arr2[u1CurPos] = symbol
    end
    checkWin(userRow, userCol) ? "win" : "not win"
  end

  def getElement(row, col)
    if row != -1 || col != -1
      @arr2[row * 3 + col]
    end
  end

  def setElement(row, col, val)
    if row != -1 || col != -1
      @arr2[3 * row + col] = val
    end
  end

# left
# right
# up
# down 
# boundaries

  def checkWin(row, col)
    #current
    current = getElement(row, col)
    #up
    up = getElement(row-1, col)
    #down
    down = getElement(row+1, col)
    # left
    left = getElement(row, col-1)
    # right
    right = getElement(row, col+1)

    # diagonally up left
    diagUpLeft = getElement(row-1, col-1)
    # up above
    upAbove = getElement(row-1, col)
    # diagonally up right
    diagUpRight = getElement(row-1, col+1)

    # diagonally current left
    currLeft = getElement(row, col-1)
    # current above
    currAbove = getElement(row, col)    
    # diagonally current right
    diagCurrRight = getElement(row, col+1)    

    # current below
    currBelow = getElement(row-1, col)
    # diagonally down left
    diagDownLeft = getElement(row-1, col-1)    
    # diagonally down right
    diagDownRight = getElement(row+1, col+1)

    counter = 0

    if(current == up)
      counter = counter + 1
    end
    if(current == down)
      counter = counter + 1
    end
    if(current == left)
      counter = counter + 1
    end
    if(current == right)
      counter = counter + 1
    end
    if(current == diagUpLeft)
      counter = counter + 1
    end
    if(current == upAbove)
      counter = counter + 1
    end
        if(current == diagUpRight)
      counter = counter + 1
    end
        if(current == currLeft)
      counter = counter + 1
    end
        if(current == currAbove)
      counter = counter + 1
    end
        if(current == diagCurrRight)
      counter = counter + 1
    end
        if(current == currBelow)
      counter = counter + 1
    end
        if(current == diagDownLeft)
      counter = counter + 1
    end
        if(current == diagDownRight)
      counter = counter + 1
    end 

    counter >= 3 ? true : false
  end

end

# play

seaChess = SeaChess.new()

seaChess.play

