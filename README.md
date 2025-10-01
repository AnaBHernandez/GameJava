# 🎮 GameJava - Colección de Juegos en Java

Una colección de 3 juegos clásicos implementados en Java con interfaz de consola.

## 📋 Características

- **Menú interactivo** para seleccionar juegos
- **3 juegos completos**: Adivinar Número, Ahorcado y Conecta 4
- **Interfaz de usuario amigable** con mensajes claros
- **Validación de entrada** en todos los juegos
- **Sistema de reinicio** para jugar múltiples veces

## 🚀 Cómo Ejecutar

### Requisitos
- Java 8 o superior
- Compilador javac

### Compilación y Ejecución

```bash
# Compilar todos los archivos
javac *.java

# Ejecutar el menú principal
java menu
```

### Ejecución Individual de Juegos

```bash
# Adivinar Número
java adivinarJuego

# Ahorcado
java ahorcado

# Conecta 4
java conecta
```

## 🎯 Juegos Incluidos

### 🎲 **Adivinar el Número**
- El programa genera un número aleatorio entre 1 y 100
- El jugador debe adivinar el número con pistas de "mayor" o "menor"
- Muestra el número de intentos al finalizar
- Opción de reiniciar el juego

### 🎯 **Ahorcado**
- Selección aleatoria de palabras predefinidas
- Sistema visual del ahorcado que se completa con cada error
- Detección de letras correctas e incorrectas
- Victoria al completar la palabra o derrota al completar el ahorcado

### 🎯 **Conecta 4**
- Tablero de 6x7 casillas
- Dos jugadores (X y O) por turnos
- Objetivo: conectar 4 fichas en línea (horizontal, vertical o diagonal)
- Validación de movimientos y detección automática de victoria

## 🛠️ Estructura del Proyecto

```
GameJava/
├── menu.java          # Menú principal
├── adivinarJuego.java # Juego de adivinar número
├── ahorcado.java      # Juego del ahorcado
├── conecta.java       # Juego Conecta 4
└── README.md          # Este archivo
```

## 🎮 Cómo Jugar

1. Ejecuta `java menu` para acceder al menú principal
2. Selecciona el juego que deseas jugar (1-3)
3. Sigue las instrucciones en pantalla
4. ¡Disfruta jugando!

## 📝 Notas Técnicas

- Todos los juegos incluyen validación de entrada
- Sistema de manejo de errores implementado
- Código modular y bien documentado
- Compatible con cualquier sistema que tenga Java instalado
