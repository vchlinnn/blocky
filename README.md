# Blocky Game

_(Gamewerks corporation internal code—do not share!)_

## Credits

Primary developer (debugger): Linh Vu

### Resources Used

+ Article on Java enums: https://www.w3schools.com/java/java_enums.asp
+ Wikipedia on the shuffle method: https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle
+ Tetris online for inspiration: https://tetris.com/play-tetris

## Changelog

~~~console
+ Fix loop index in Loader.java out of bounds --> game runable yet still buggy
+ Add missing break statement in switch cases in BlockyGame.java
+ Add processMovement() method to step() method in BlockyGame.java to enable pieces move left/right
+ Have getCompletedRows() store row indices instead of booleans in Board.java for correct delete rows
+ Implemented random block generation with modifications in Piece.java and PieceKind.java
~~~
