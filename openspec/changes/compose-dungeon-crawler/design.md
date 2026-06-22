## Context

We are building a turn-based dungeon crawler roguelike using Compose Multiplatform and Kotlin. The architecture must separate game logic from UI rendering, following a data-driven approach with composition over inheritance. This enables testability, extensibility, and cross-platform deployment.

## Goals / Non-Goals

**Goals:**
- Establish a clean separation between game state (data) and UI rendering (Compose)
- Implement a turn-based movement system with arrow key input handling
- Create immutable game state with pure functions for state transitions
- Support desktop and web platforms via Compose Multiplatform
- Provide a foundation for future features (enemies, items, combat, etc.)

**Non-Goals:**
- Advanced graphics or animations (simple grid-based rendering)
- Procedural dungeon generation (static dungeon layout for MVP)
- Multiplayer or networking
- Save/load system (out of scope for initial version)
- Sound or music

## Decisions

### 1. Data-Driven Architecture
**Decision**: Game state is represented as immutable data classes. State transitions are pure functions that take current state and an action, returning new state.

**Rationale**: Immutable data structures enable easy testing, time-travel debugging, and undo/redo. Pure functions are deterministic and side-effect free, making game logic predictable and composable.

**Alternatives Considered**:
- Mutable state with side effects: Easier initially but harder to test and debug
- Inheritance-based entity system: Violates composition principle and creates tight coupling

### 2. Separation of Concerns
**Decision**: Game logic (state management, turn system) is completely separate from UI rendering. The game engine produces state, and Compose renders it.

**Rationale**: Allows testing game logic without UI, enables multiple UI implementations, and makes the codebase maintainable.

**Alternatives Considered**:
- Tight coupling of logic and UI: Simpler initially but harder to extend and test

### 3. Composition Over Inheritance
**Decision**: Use data composition (nested data classes) rather than inheritance hierarchies. Entities are composed of components (position, health, etc.).

**Rationale**: More flexible, easier to add/remove features, avoids fragile base class problems.

**Alternatives Considered**:
- Entity inheritance (Player extends Entity): Rigid and hard to extend

### 4. Input Handling
**Decision**: Arrow keys are captured at the Compose level and converted to game actions (Move Up/Down/Left/Right). Actions are processed by the game engine.

**Rationale**: Decouples input from game logic, allows easy remapping or alternative input methods.

### 5. Project Structure
**Decision**: Use Compose Multiplatform with shared code in `commonMain` and platform-specific code in `desktopMain`, `jsMain`, `androidMain` as needed.

**Rationale**: Maximizes code reuse while allowing platform-specific optimizations.

### 6. Dungeon Size
**Decision**: Start with a 32x32 grid of tiles.

**Rationale**: Large enough to be interesting and allow exploration, small enough to render quickly and fit on screen. Can be adjusted later based on performance and gameplay feel.

### 7. Initial Obstacles
**Decision**: Add walls around the edge of the dungeon to create a bounded play area. Interior is open space initially.

**Rationale**: Provides natural boundaries and a sense of containment without the complexity of procedural generation or detailed level design. Easy to expand with more obstacles later.

### 8. Player Character Visual
**Decision**: Use '@' ASCII character for the player initially. Plan to replace with transparent PNGs later.

**Rationale**: ASCII rendering is fast and requires no asset loading, enabling quick iteration. Easy to swap out for sprite-based rendering when ready.

## Risks / Trade-offs

| Risk | Mitigation |
|------|-----------|
| Immutable data structures may have performance overhead | Start simple; optimize only if profiling shows bottleneck |
| Compose Multiplatform is still evolving | Use stable APIs; plan for potential API changes |
| Grid-based rendering may feel limited | Simple to extend with better graphics later |
| No persistence means progress is lost on exit | Add save/load as a future feature |
| 32x32 grid may be too large or small | Easy to adjust after testing gameplay feel |

## Migration Plan

This is a greenfield project, so no migration is needed. The initial implementation will be a standalone Compose Multiplatform application.
