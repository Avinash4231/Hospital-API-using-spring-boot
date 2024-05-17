package com.avinash.HospitalAPI;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info =@Info(
        title= "Hospital API",
        description= "Suggesting doctor according to patient symptom",
        summary ="Suggesting doctor according to patient location and the symptom",
        termsOfService ="T&C",
        contact =@Contact(
            name ="Avinash",
            email ="help.avinash@gmail.com"
        ),
        license= @License(
            name ="Your License No"
        ),
        version = "v1"
    ),
    servers={
        @Server(
            description = "Dev",
            url = "http://localhost:8080"
        ),
        @Server(
            description = "Test", 
            url = "http://localhost:8080"
        )
    }
)


public class OpenApiConfig {
    
}
