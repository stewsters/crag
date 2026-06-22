## 1. Project Setup

- [x] 1.1 Create Compose Multiplatform project structure with shared `commonMain` module
- [x] 1.2 Add Compose and Kotlin dependencies to build.gradle.kts
- [x] 1.3 Set up desktop (JVM) platform target
- [x] 1.4 Create desktop main function and window setup

## 2. Minimal Game State

- [x] 2.1 Create immutable data classes for game state (GameState, Position)
- [x] 2.2 Define game action types (Move Up, Move Down, Move Left, Move Right)
- [x] 2.3 Implement pure state update function (reducer) with boundary checking
- [x] 2.4 Create game engine that processes actions and returns new state

## 3. Basic Rendering

- [x] 3.1 Create Compose UI components for dungeon grid rendering
- [x] 3.2 Render a simple grid with visual cell separation
- [x] 3.3 Render player character (emoji or simple symbol) at current position
- [x] 3.4 Wire game state to UI so rendering updates when state changes

## 4. Input and Movement

- [x] 4.1 Implement arrow key event handling in Compose
- [x] 4.2 Convert keyboard events to game actions
- [x] 4.3 Dispatch actions to game engine and update UI
- [x] 4.4 Test player movement with arrow keys (manual testing)
- [x] 4.5 Test boundary conditions (movement at edges)

## 5. Polish and Expand

- [x] 5.1 Add turn counter to game state and display on screen
- [x] 5.2 Build and test full desktop application
- [x] 5.3 Add basic README with build and run instructions
- [x] 5.4 Plan next features (enemies, items, etc.)
