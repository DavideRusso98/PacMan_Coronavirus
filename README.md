# Pacman COVID-19 edition 👾🦠
**PacMan_Coronavirus** is a custom version of the classic Pac-Man arcade game, developed in Java with a theme inspired by the **COVID-19** pandemic. In this edition, the player faces virus-like enemies in a unique, health-themed twist on the original gameplay.

## 🎮 Game Features

-   **COVID-19 Theme**: Enemies are represented by **virus** icons, and the player must avoid or "**heal**" them using special items.
    
-   **Custom Graphics**: Sprites and environments are visually adapted to reflect the pandemic theme.
    
-   **Built in Java**: Cross-platform compatibility for any system that supports the Java Runtime Environment.

## 📁 Project Structure

The **PacMan_Coronavirus** project is organized into three main conceptual layers:

1.  **Entities (Game Objects)**
    
2.  **Handlers (Logic Controllers)**
    
3.  **GUI (Graphics and Input Layer)**
    

This modular structure separates game logic, object behavior, and user interaction, making the code easier to maintain and expand.

### 🧍 Entities

Entities represent all the interactive objects in the game world. These include:

-   **Player (Pac-Man)**: The main character controlled by the user. Handles movement, collisions, and interactions with enemies and items.
    
-   **Virus (Enemy)**: Autonomous characters that follow specific movement patterns. They interact with the player, potentially causing game-over conditions.
    
-   **Map/Tiles**: Static components that define the game environment, including walls, paths, and power-up zones.
    
-   **Collectibles** _(if present)_: Items like dots, vaccines, or power-ups that the player can collect to gain points or temporary abilities.

Each entity contains its own position, sprite, behavior logic, and collision detection.

### ⚙️ Handlers (Controllers)

Handlers are responsible for managing the behavior and coordination of the different components:

-   **Game Loop Handler**: Updates the state of all game objects on each frame and manages time-based events.

 -   **Entity Handler**: This handler manages all dynamic entities, including the player, enemies and potential temporary effects or other moving objects.
 
 -   **Collectibles Handler**: This handler manages all static interactive items that the player can collect, such as dots and vaccines.
 
  -   **Game Handler**: The game handler is the top-level controller of the entire game flow.

These handlers allow for the separation of responsibilities and reduce complexity in the core loop.

### 🖥️ Graphical User Interface

The graphical interface is built using **Java Swing**, particularly `JFrame` and `JPanel`.

-   **GameFrame (JFrame)**: The main application window. Sets the game title, size, and base configuration.
    
-   **GamePanel (JPanel)**: The core rendering surface. Responsible for:
    
    -   Drawing all visible elements (player, enemies, tiles, UI)
        
    -   Capturing and interpreting keyboard input
        
    -   Updating the game based on timer events or frame intervals
        
The GUI layer ensures that the game remains interactive and visually responsive, translating backend logic into a playable experience.


