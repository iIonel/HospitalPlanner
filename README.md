# HospitalPlanner
medical consultation management application for doctors and patients


## Screenshots

![App Screenshot](![image](https://github.com/iIonel/HospitalPlanner/assets/45739581/a4cff87f-e9eb-44d7-8cfd-3ed11fd4123d))

## Resume

- after **registration**, everyone will have the role of user.
- **the admin** will be able to set/delete the doctor role from a user
- **the user and the admin** will be able to create appointments with a specific doctor
- **the doctor** will be able to see the consultations sent by the patients

## Running
go to /navigation/Connection.dart and set to localhost, your IPv4 (for this go to the command prompt and write ipconfig)

## Tech Stack

**Client:** Flutter

**Server:** Spring, MySql

## Local MySql Code:
```bash
   create table user(
     user_id       int auto_increment
        primary key,
     first_name    varchar(255) null,
     last_name     varchar(255) null,
     email         varchar(255) null,
     user_password varchar(255) null,
     phone_number  varchar(255) null,
     role          int          not null,
     unique (email)
   ); 

  create table consultation(
    user_id           int          null,
    doctor_id         int          null,
    consultation_date varchar(255) null,
    status            varchar(255) null,
    consultation_id   int auto_increment
        primary key
   );
```


## License

[MIT](https://choosealicense.com/licenses/mit/)
