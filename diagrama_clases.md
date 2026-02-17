# Diagrama de Clases - Sudoku Distribuido RMI

```mermaid
classDiagram
    direction TB
    
    class Remote:::interface {
        <<interface>>
    }
    
    class SudokuInterface:::interface {
        <<interface>>
        +generar4x4() int[][]
        +generar9x9() int[][]
        +generar16x16() int[][]
    }
    
    class UnicastRemoteObject {
        Base class para objetos remotos
    }
    
    class SudokuImplement {
        -tamano: int
        +getTamano() int
        +setTamano(int)
        +SudokuImplement(int)
        +generar4x4() int[][]
        +generar9x9() int[][]
        +generar16x16() int[][]
        -crearMatriz(int) int[][]
    }
    
    class SudokuServer {
        +main(String[])
    }
    
    class SudokuClient {
        -sudoku: SudokuInterface
        -scanner: Scanner
        +main(String[])
        -obtenerRemoto() SudokuInterface
        -mostrarMenu()
        -obtenerOpcion() int
        -generarYMostrar(int, String)
        -mostrarMatriz(int[][], String)
    }
    
    Remote <|-- SudokuInterface: extends
    SudokuInterface <|.. SudokuImplement: implements
    UnicastRemoteObject <|-- SudokuImplement: extends
    SudokuServer --> SudokuImplement: crea instancia
    SudokuServer --> Registry: usa
    SudokuClient --> SudokuInterface: usa (remota)
    SudokuClient --> Registry: accede
    
    class Registry {
        Registro RMI
    }
    
    style SudokuInterface fill:#000000
    style Remote fill:#000000
    style SudokuImplement fill:#000000
    style SudokuServer fill:#000000
    style SudokuClient fill:#000000


