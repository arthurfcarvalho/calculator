# Mobile Programming Calculator Project

This project is a simple calculator developed as an assignment for the **Mobile Programming** course in the **Software Development and Analysis** program at **IFTM - Campus Patrocínio**. The calculator is designed for Android devices, using **Kotlin** for the programming logic and **XML** for the layout.

## 📱 Features

- **Basic Operations**: Supports addition, subtraction, multiplication, and division.
- **Extra Functions**:
  - `C` button to clear the screen content.
  - `=` button to calculate the current operation result.
  - Error handling, such as division by zero, to prevent app crashes.
  - Validations to prevent consecutive operators.
- **Layout Customization**: The interface is designed to be user-friendly, with an organized layout using **GridLayout** or **LinearLayout** and customizable button size and colors.

## 📐 Project Structure

- **XML Layout**: The layout was built using XML, with components like `LinearLayout` or `GridLayout` to organize buttons in an orderly and functional way.
  - Includes number buttons (0 to 9) and mathematical operations (`+`, `-`, `*`, `/`).
  - Additional buttons for `C` (clear the screen) and `=` (calculate the result).
  - A display field (`TextView` or `EditText`) at the top to show entered values and operation results.

- **Logic in Kotlin**: The Kotlin code handles the operations and implements the calculator’s logic.
  - Supports basic operation execution.
  - Displays the result when `=` is pressed.
  - Resets the screen with the `C` button.

## 🚀 Getting Started

### Prerequisites

- **Android Studio** installed and set up.
- This project was developed in **Kotlin**.

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/arthurfcarvalho/calculator.git
2. Open Android Studio and select "Open an Existing Project".
3. Navigate to the folder where the repository was cloned and select it.
4. Wait for Android Studio to configure the environment and load all required dependencies.

### Running the Calculator

1. Connect an Android device or set up an emulator.
2. In Android Studio, select the target device and click "Run" or press **Shift + F10**.

## 📄 Usage

- **Operations**: Enter numbers and operators to perform calculations directly.
- **Controls**:
  - **C**: Clears the current calculation to start a new one.
  - **=**: Displays the result of the operation.
- **Input Validation**: The calculator prevents multiple decimal points and consecutive operators.

## 🖼 App Interface

![image](https://github.com/user-attachments/assets/e563c8b4-df0e-48ef-9c6c-2a08e88449bd)

## ⚙ Technologies Used

- **Kotlin**: Programming language used for the calculator logic.
- **XML**: Used to develop the interface layout.
- **Android SDK**: Essential tools and libraries for Android development.

## 👥 About the Project

This project was developed as a practical assignment at IFTM - Campus Patrocínio, for the Mobile Programming course in the Software Development and Analysis program.
