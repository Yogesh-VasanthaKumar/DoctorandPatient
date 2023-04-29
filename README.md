# Doctor-Patient API

This is a sample API for a Doctor-Patient appointment booking system. The API allows patients to register and specify their symptoms, and then suggests doctors to them based on their location and the nature of their symptoms.

## Technologies Used

- Java Spring Boot
- MySQL
- Hibernate

## API Endpoints

### Patients

- `POST /patients`: Creates a new patient in the system
- `GET /patients/{id}`: Retrieves a patient by ID
- `GET /patients/{patientId}/suggest-doctors`: Suggests doctors to a patient based on their location and symptoms

### Doctors

- `POST /doctors`: Creates a new doctor in the system
- `GET /doctors/{id}`: Retrieves a doctor by ID
- `GET /doctors`: Retrieves all doctors in the system

## Data Model

### Patient

- `id`: Unique identifier for the patient
- `name`: Name of the patient
- `city`: City where the patient is located
- `email`: Email address of the patient
- `phone`: Phone number of the patient
- `symptom`: The symptom that the patient is experiencing

### Doctor

- `id`: Unique identifier for the doctor
- `name`: Name of the doctor
- `speciality`: The doctor's speciality
- `city`: The city where the doctor is located

## Running the Application

To run the application, follow these steps:

1. Clone this repository to your local machine
2. Create a MySQL database named `doctor_patient`
3. Update the application properties in `src/main/resources/application.properties` to match your database configuration
4. Run the application using the command `mvn spring-boot:run`
5. The API will be available at `http://localhost:8080`
