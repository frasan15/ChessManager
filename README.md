# Chess Manager

Write a program that can manage chess games.

The classes are in the `chess` package. The main class is `ChessManager`.  
The `ExampleMain` class in the `main` package provides examples of using the main methods and required controls.  
All exceptions are of type `ChessException`.

---

## R1: Chessboard

The `Board` class represents a square chessboard. The constructor accepts two parameters: the name of the board, which uniquely identifies it, and its size (number of cells on one side).

The name and size can be retrieved using the appropriate getters: `getName()` and `getSize()`.

The `Piece` class defines constants representing pieces.

- The `addPiece(String p, int x, int y)` method allows you to add a piece to the board at position `(x, y)`.
  - Passing `null` as the first parameter removes the piece at `(x, y)` if present.
- The `getPiece(int x, int y)` method returns the piece at position `(x, y)`. If no piece is present, the method returns `null`.
- Both methods throw an exception if the provided position is invalid.

---

## R2: Players

The `Player` class represents a player. The constructor receives the player's name, nationality, and age.

- The class should implement `toString()`, which returns this information separated by commas. **Do not** include spaces unless already present in the name or nationality.
  - Example: `"Edoardo,Italian,29"`

The `ChessManager` class includes the following methods:

- `addBoard(Board b)`: Adds a `Board` to `ChessManager`.
- `getBoard(String boardName)`: Returns the `Board` given its name.
- `addPlayer(Player p)`: Adds a `Player` to `ChessManager`.
- `getPlayer(String playerName)`: Returns the `Player` given the name.
- `addPlayerToBoard(String playerName, String boardName)`: Specifies that the player `playerName` is playing on the board `boardName`.
- `getBoardsOfPlayer(String playerName)`: Returns a `Collection` of boards on which the player `playerName` is playing.

---

## R3: Tournaments

- `createTournament(String tournamentName)`: Creates a tournament uniquely identified by its name. Throws an exception if a tournament with the same name already exists.

- `addPlayerToTournament(String tournamentName, String playerName, Integer score)`: Adds the player `playerName` to the tournament `tournamentName`, specifying the score. Throws an exception if the player `playerName` has not been defined.

- `getLeadingPlayer(String tournamentName)`: Returns the name of the player with the highest score in the tournament along with the score, separated by `":"`.  
  - Example: `"Edoardo:51"`
  - **Do not** include spaces unless already present in the name. Return `null` if there are no players in the tournament. Assume there are **no ties**.

---

## R4: Interface

Create a graphical interface that, initialized with a populated board, allows the retrieval of a piece (or `null`) given its position `(x, y)`.  
Also, allow removal of a piece given its position `(x, y)`. Handle `ChessException`s that occur in both operations when the provided position is invalid by displaying a message to the user.

- Classes for the interface should be in the `gui` package. The `Client` class contains an example `main`.
- Write code to start the interface in the `start(Board b)` method, which receives the initialized board as a parameter.

---

## R5: N Queens

The `fillQueens(String boardName, Integer boardSize)` method returns a `Board` named `boardName` of size `boardSize` containing only queens, in a number equal to the size of the `Board`. The queens must be positioned so that no queen is under attack from any other queen.

- A queen can attack other pieces by moving any number of cells horizontally, vertically, or diagonally.

Use smaller board sizes (from 3 to 10) due to the problem's complexity.

- An example main provides the `printBoard(Board b)` function for printing the board to the screen.
- It is recommended to use the `checkQueen(Board b, int x, int y)` function for placement checks. This function returns `true` if it's possible to place a queen in cell `(x, y)` without violating constraints and `false` otherwise.

---
