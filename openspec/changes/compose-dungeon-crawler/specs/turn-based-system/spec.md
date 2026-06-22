## ADDED Requirements

### Requirement: Game operates on a turn-based system
The game SHALL operate on a turn-based system where each player action (movement) consumes exactly one turn. The turn counter SHALL increment after each valid action.

#### Scenario: Turn increments on valid move
- **WHEN** player executes a valid move action
- **THEN** the turn counter increments by one

#### Scenario: Turn does not increment on invalid move
- **WHEN** player attempts an invalid move (e.g., moving outside boundaries)
- **THEN** the turn counter does not increment

### Requirement: Game state tracks current turn number
The game state SHALL include a turn counter that tracks the total number of turns elapsed since game start.

#### Scenario: Initial turn count
- **WHEN** the game starts
- **THEN** the turn counter is set to zero or one

#### Scenario: Turn counter persists
- **WHEN** multiple moves are made
- **THEN** the turn counter reflects the total number of valid moves

### Requirement: Turn-based system is independent of real-time
The game SHALL not advance turns based on elapsed time. Turns only advance when the player takes an action.

#### Scenario: No automatic turn advancement
- **WHEN** the player does not take any action
- **THEN** no turns pass and the game state does not change
