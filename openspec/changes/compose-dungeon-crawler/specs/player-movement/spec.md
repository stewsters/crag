## ADDED Requirements

### Requirement: Player can move in four directions
The player character SHALL be able to move up, down, left, and right on a grid-based dungeon using arrow keys. Each movement consumes one turn and updates the player's position.

#### Scenario: Move up
- **WHEN** player presses the up arrow key
- **THEN** player position moves one cell upward (y decreases)

#### Scenario: Move down
- **WHEN** player presses the down arrow key
- **THEN** player position moves one cell downward (y increases)

#### Scenario: Move left
- **WHEN** player presses the left arrow key
- **THEN** player position moves one cell leftward (x decreases)

#### Scenario: Move right
- **WHEN** player presses the right arrow key
- **THEN** player position moves one cell rightward (x increases)

### Requirement: Movement is blocked by walls
The player SHALL not be able to move into wall tiles (dungeon edges). Attempting to move into a wall SHALL be rejected and not consume a turn.

#### Scenario: Prevent movement into top wall
- **WHEN** player is adjacent to the top wall and presses up arrow
- **THEN** player position does not change and no turn is consumed

#### Scenario: Prevent movement into bottom wall
- **WHEN** player is adjacent to the bottom wall and presses down arrow
- **THEN** player position does not change and no turn is consumed

#### Scenario: Prevent movement into left wall
- **WHEN** player is adjacent to the left wall and presses left arrow
- **THEN** player position does not change and no turn is consumed

#### Scenario: Prevent movement into right wall
- **WHEN** player is adjacent to the right wall and presses right arrow
- **THEN** player position does not change and no turn is consumed

### Requirement: Movement is instantaneous
Movement SHALL occur immediately upon key press with no animation delay in the initial version.

#### Scenario: Immediate position update
- **WHEN** player presses an arrow key
- **THEN** player position is updated in the game state immediately
