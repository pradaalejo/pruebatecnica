package com.pruebatecnica.pruebatecnica.models.modelsrequest;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePay {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("mesPago")
    @NotNull(message = "El campo mesPago no debe ser nulo")
    private Integer mesPago;

    @JsonProperty("anioPago")
    @NotNull(message = "El campo anioPago no debe ser nulo")
    private Integer anioPago;

}
