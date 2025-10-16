package views;

import controllers.ControlRegistrarCita;
import exceptions.CitaExistenteException;
import exceptions.MedicoInexistenteException;
import exceptions.MedicoNoDisponibleException;
import exceptions.PacienteNoRegistradoException;
import exceptions.SinMedicosException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import models.IObserver;
import models.dto.CitaDTO;
import models.dto.MedicoDTO;
import models.dto.PacienteDTO;

public class VistaConsola implements IObserver {

    private final ControlRegistrarCita control;
    private final Scanner sc;

    public VistaConsola(ControlRegistrarCita control) {
        this.control = control;
        this.sc = new Scanner(System.in);
        this.control.agregarObservador(this);
    }

    // --- Observer: se ejecuta cuando se registra una nueva cita ---
    @Override
    public void notificar(CitaDTO citaDTO) {
        System.out.println("\n=== Nueva cita registrada ===");
        System.out.println(citaDTO.mostrarInfo());
        System.out.println("============================\n");
    }

    // --- Metodo principal ---
    public void iniciar() {
        System.out.println("\n=== Sistema de Registro de Citas ===");

        // Ingreso del paciente
        PacienteDTO pacienteDTO = null;
        while (pacienteDTO == null) {
            try {
                System.out.print("Ingrese su numero de seguridad social (NSS): ");
                int nss = Integer.parseInt(sc.nextLine());
                pacienteDTO = control.buscarPacienteDTO(nss);
                System.out.println("\nBienvenido, " + pacienteDTO.getNombre() + "!");
                System.out.println("Telefono: " + pacienteDTO.getTelefono());
                System.out.println("Direccion: " + pacienteDTO.getDireccion());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un numero valido.");
            } catch (PacienteNoRegistradoException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // Mostrar menu principal
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Apartar cita");
            System.out.println("2. Ver mis citas");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            String opcion = sc.nextLine();

            switch (opcion) {
                case "1" ->
                    apartarCita(pacienteDTO);
                case "2" ->
                    verCitas(pacienteDTO);
                case "3" -> {
                    System.out.println("Saliendo del sistema...");
                    salir = true;
                }
                default ->
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        }
    }

    // --- Apartar cita ---
    private void apartarCita(PacienteDTO pacienteDTO) {
        System.out.println("\n--- Apartar cita ---");

        try {
            List<MedicoDTO> medicosDTO = control.obtenerMedicosDTO();
            System.out.println("\n--- Medicos disponibles ---");
            for (MedicoDTO m : medicosDTO) {
                System.out.println("ID: " + m.getId()
                        + " | " + m.getNombre()
                        + " | " + m.getEspecialidad()
                        + " | Consultorio: " + m.getConsultorio());
            }
        } catch (SinMedicosException e) {
            System.out.println("Error: " + e.getMessage());
        }

        MedicoDTO medicoDTO = null;
        while (medicoDTO == null) {
            System.out.print("Ingrese el ID del medico que desea: ");
            try {
                int idMedico = Integer.parseInt(sc.nextLine());
                medicoDTO = control.buscarMedicoDTO(idMedico);
                if (medicoDTO == null) {
                    System.out.println("ID de medico no valido, intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido.");
            } catch (MedicoInexistenteException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        LocalDateTime fechaHora = null;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        while (fechaHora == null) {
            System.out.print("Ingrese la fecha y hora de la cita (yyyy-MM-dd HH:mm): ");
            String input = sc.nextLine();
            try {
                LocalDateTime ingresada = LocalDateTime.parse(input, fmt);
                if (ingresada.isBefore(LocalDateTime.now())) {
                    System.out.println("La fecha no puede ser anterior al momento actual. Intente de nuevo.");
                } else {
                    fechaHora = ingresada;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Formato incorrecto. Intente de nuevo.");
            }
        }

        System.out.print("Ingrese el motivo de la cita: ");
        String motivo = sc.nextLine();

        try {
            CitaDTO citaDTO = control.registrarCita(
                    pacienteDTO,
                    medicoDTO,
                    fechaHora,
                    motivo
            );
            System.out.println("\nCita registrada con exito:");
            System.out.println(citaDTO.mostrarInfo());
        } catch (MedicoNoDisponibleException | CitaExistenteException e) {
            System.out.println("No se pudo registrar la cita: " + e.getMessage());
        }

        System.out.println("\nPresione ENTER para volver al menu...");
        sc.nextLine();
    }

    // --- Ver citas del paciente ---
    private void verCitas(PacienteDTO pacienteDTO) {
        System.out.println("\n--- Mis Citas ---");

        List<CitaDTO> citas = control.obtenerCitasPorPaciente(pacienteDTO);
        if (citas.isEmpty()) {
            System.out.println("No tiene citas registradas.");
        } else {
            for (CitaDTO c : citas) {
                System.out.println(c.mostrarInfo());
            }
        }

        System.out.println("\nPresione ENTER para volver al menu...");
        sc.nextLine();
    }

}
