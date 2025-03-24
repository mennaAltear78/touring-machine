# Turing Machine Simulator

## 📝 **Project Description**
This project is a simulator for a Turing Machine written in Java. It allows users to input the number of states, alphabet, and transitions to simulate how a Turing machine processes an input string. The program determines whether the input string is accepted or rejected based on the transition rules defined by the user. This project is a representation of how a Turing machine works step-by-step.

## 🔧 **Technologies Used**
- **Language**: Java
- **Libraries**: `Scanner` (for user input)
- **Concepts**:
  - Object-Oriented Programming (OOP)
  - Input Handling
  - Array Manipulation
  - Transition Simulation

## 📦 **How to Use**

1. **Setting Up the Environment**:
   - Ensure you have **Java** installed on your system. If not, you can download it from the official [Java website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
   
2. **Running the Program**:
   - Clone the repository:
     ```
     git clone https://github.com/your-username/turing-machine-simulator.git
     ```
   - Navigate to the project directory:
     ```
     cd turing-machine-simulator
     ```
   - Compile the Java code:
     ```
     javac TuringMachine.java
     ```
   - Run the program:
     ```
     java TuringMachine
     ```

3. **Interacting with the Program**:
   - The program will prompt you to enter:
     - The number of states in the machine.
     - The alphabet for the input string.
     - The machine's alphabet.
     - The transition table for the machine (i.e., how the machine moves from one state to another based on input characters).
     - A string to test on the Turing Machine.
     - The initial head position.

   - The program will then simulate the Turing Machine step by step, showing the string’s state at each step and finally indicating whether the string is accepted or rejected based on the transition rules.

## 🛠️ **Features**

- **State and Alphabet Input**: Users can define custom states and alphabets for the Turing Machine.
- **Transition Handling**: Users can define transitions between states based on the input string.
- **Step-by-step Simulation**: The program runs the Turing Machine in steps, showing the current tape and head position.
- **Final Result**: The program outputs whether the input string is accepted or rejected by the Turing Machine.

## 💡 **How the Turing Machine Works**
- **States**: The machine has a finite set of states, each representing a specific configuration in the computation process.
- **Alphabet**: The machine reads symbols from the input alphabet and manipulates them on the tape.
- **Transition Table**: The transition table defines the rules for how the machine moves from one state to another based on the current symbol on the tape.
- **Head Movement**: The machine moves its head based on the defined transitions ('R' for right, 'L' for left, 'Y' for halt, 'N' for rejection).



