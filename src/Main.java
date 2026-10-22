package src;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private final String id;
    private final String name;
    private final List<Double> grades;

    public Student(String id, String name) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "El ID no puede estar vacío."
            );
        }

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "El nombre no puede estar vacío."
            );
        }

        this.id = id.trim();
        this.name = name.trim();
        this.grades = new ArrayList<>();
    }

    public void addGrade(double grade) {
        if (!Double.isFinite(grade) || grade < 0 || grade > 100) {
            throw new IllegalArgumentException(
                "La calificación debe estar entre 0 y 100."
            );
        }

        grades.add(grade);
    }

    public double calculateAverage() {
        if (grades.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;

        for (double grade : grades) {
            total += grade;
        }

        return total / grades.size();
    }

    public String getLetterGrade() {
        double average = calculateAverage();

        if (average >= 90) {
            return "A";
        }
        if (average >= 80) {
            return "B";
        }
        if (average >= 70) {
            return "C";
        }
        if (average >= 60) {
            return "D";
        }

        return "F";
    }

    public boolean isPassing() {
        return !grades.isEmpty() && calculateAverage() >= 60;
    }

    public boolean isHonorRoll() {
        return !grades.isEmpty() && calculateAverage() >= 90;
    }

    public boolean removeGradeByIndex(int index) {
        if (index < 0 || index >= grades.size()) {
            return false;
        }

        grades.remove(index);
        return true;
    }

    public boolean removeGradeByValue(double grade) {
        return grades.remove(Double.valueOf(grade));
    }

    public void printReport() {
        System.out.println("\n===== REPORTE DEL ESTUDIANTE =====");
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + name);
        System.out.println("Cantidad de calificaciones: " + grades.size());

        if (grades.isEmpty()) {
            System.out.println("Promedio: No disponible");
            System.out.println("Calificación por letra: No disponible");
            System.out.println("Estado: No disponible");
        } else {
            System.out.printf(
                "Promedio: %.2f%n",
                calculateAverage()
            );
            System.out.println(
                "Calificación por letra: " + getLetterGrade()
            );
            System.out.println(
                "Estado: " + (isPassing() ? "Aprobado" : "Reprobado")
            );
        }

        System.out.println(
            "Cuadro de honor: " + (isHonorRoll() ? "Sí" : "No")
        );
        System.out.println("Calificaciones: " + grades);
        System.out.println("==================================");
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student student = createStudent(scanner);
        boolean running = true;

        while (running) {
            showMenu();
            String option = scanner.nextLine().trim();

            switch (option) {
                case "1":
                    addGrade(scanner, student);
                    break;
                case "2":
                    removeGradeByIndex(scanner, student);
                    break;
                case "3":
                    removeGradeByValue(scanner, student);
                    break;
                case "4":
                    student.printReport();
                    break;
                case "5":
                    running = false;
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Error: opción no válida.");
            }
        }

        scanner.close();
    }

    private static Student createStudent(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Ingresa el ID del estudiante: ");
                String id = scanner.nextLine();

                System.out.print("Ingresa el nombre del estudiante: ");
                String name = scanner.nextLine();

                return new Student(id, name);
            } catch (IllegalArgumentException exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n=== GESTIÓN DE CALIFICACIONES ===");
        System.out.println("1. Agregar calificación");
        System.out.println("2. Eliminar calificación por posición");
        System.out.println("3. Eliminar calificación por valor");
        System.out.println("4. Mostrar reporte");
        System.out.println("5. Salir");
        System.out.print("Selecciona una opción: ");
    }

    private static void addGrade(
        Scanner scanner,
        Student student
    ) {
        try {
            System.out.print("Ingresa la calificación (0-100): ");
            double grade = Double.parseDouble(scanner.nextLine().trim());
            student.addGrade(grade);
            System.out.println("Calificación agregada correctamente.");
        } catch (NumberFormatException exception) {
            System.out.println("Error: debes ingresar un número válido.");
        } catch (IllegalArgumentException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }

    private static void removeGradeByIndex(
        Scanner scanner,
        Student student
    ) {
        try {
            System.out.print(
                "Ingresa la posición de la calificación (desde 1): "
            );
            int position = Integer.parseInt(scanner.nextLine().trim());

            if (student.removeGradeByIndex(position - 1)) {
                System.out.println("Calificación eliminada.");
            } else {
                System.out.println("Error: posición no válida.");
            }
        } catch (NumberFormatException exception) {
            System.out.println("Error: ingresa un número entero.");
        }
    }

    private static void removeGradeByValue(
        Scanner scanner,
        Student student
    ) {
        try {
            System.out.print("Ingresa el valor que deseas eliminar: ");
            double grade = Double.parseDouble(scanner.nextLine().trim());

            if (!Double.isFinite(grade)) {
                System.out.println("Error: ingresa un número válido.");
            } else if (student.removeGradeByValue(grade)) {
                System.out.println("Calificación eliminada.");
            } else {
                System.out.println(
                    "Error: no se encontró esa calificación."
                );
            }
        } catch (NumberFormatException exception) {
            System.out.println("Error: debes ingresar un número válido.");
        }
    }
}


