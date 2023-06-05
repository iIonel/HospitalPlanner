# HospitalPlanner
medical consultation management application for doctors and patients


## Screenshots

![image](https://github.com/iIonel/HospitalPlanner/assets/45739581/09f04715-06d1-45a7-85dc-646639d0613f)
![image](https://github.com/iIonel/HospitalPlanner/assets/45739581/cda82083-a76b-4eaf-a888-73bc258369d9)
![image](https://github.com/iIonel/HospitalPlanner/assets/45739581/5220db6a-faa0-4858-b54b-18b6c0c361e0)
![image](https://github.com/iIonel/HospitalPlanner/assets/45739581/4fa8b710-c5c5-4f6a-befc-0e5e239179c3)
![image](https://github.com/iIonel/HospitalPlanner/assets/45739581/3e4f6844-6442-4cfe-b11b-c976c6050df1)


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
