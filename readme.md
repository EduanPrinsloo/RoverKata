# The Perseverance Mission...
A Pair of robotic rovers are to be landed by SpaceX on a plateau of Mars.

This plateau, which is curiously rectangular, must be navigated by the rovers so that their onboard cameras can get a complete view of the surrounding terrain to send back to Earth.
A rover's position is represented by a combination of x and y coordinates. 

The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0 which means the rover is in the bottom left corner.
In order to control a rover, SpaceX sends a simple string of letters.

The possible letters are *'N'(Up)*, *'S'(Down)*, *'E'(Right)*, and *'W'(Left)* which makes the rover move one block in that direction
The movements have the following effect on a rover position:

+ _N : (x, y+1)_
+ _S : (x, y-1)_
+ _E : (x+1, y)_
+ _W : (x-1, y)_

### Inputs:
+ The first line of input is the upper-right coordinates of the plateau, the lower-left coordinates are assumed to be 0, 0. 
+ The rest of the input is information pertaining to the rovers that have been deployed, each rover has two lines of input:
  + The first line gives the rover's initial position. 
  + The second line is a series of instructions telling the rover how to explore the plateau i.e. *SWENNSW*

__The position is made up of two integers, corresponding to the x and y coordinates.__

### Output:
The output of the program should be the intersection points of the rovers...

### Your Objectives:
It is your job to write code in a hardcore TDD fashion that will execute the commands from the inputs and identify the intersection paths of the rovers, you should try not to spend more than 4 hours.
