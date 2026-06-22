## ADDED Requirements

### Requirement: Game state is represented as immutable data
Game state SHALL be represented using immutable data classes. State transitions SHALL be pure functions that take the current state and an action, returning a new state without modifying the original.

#### Scenario: State update creates new instance
- **WHEN** a move action is processed
- **THEN** a new game state object is created with updated player position
- **AND** the original game state remains unchanged

### Requirement: Game state includes player position and dungeon dimensions
The game state SHALL contain the player's current position (x, y coordinates) and the dungeon dimensions (width, height).

#### Scenario: Initial game state
- **WHEN** the game starts
- **THEN** game state contains player position and dungeon dimensions

### Requirement: Actions are processed through a pure function
Game actions (move up, move down, move left, move right) SHALL be processed through a pure function that takes current state and action, returning new state.

#### Scenario: Process move action
- **WHEN** a move action is dispatched
- **THEN** the game engine processes it and returns updated state
- **AND** the function is deterministic (same input always produces same output)

### Requirement: Game state is testable without UI
Game logic and state management SHALL be completely independent of UI rendering, allowing state transitions to be tested in isolation.

#### Scenario: Test state transition
- **WHEN** unit tests call the state update function
- **THEN** the function returns correct new state without requiring Compose or UI components
