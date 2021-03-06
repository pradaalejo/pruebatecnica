package com.pruebatecnica.pruebatecnica.models.modelsresponse;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Integer id;

    @JsonProperty("nombres")
    @NotNull(message = "El campo nombres no debe ser nulo")
    @NotEmpty(message = "El campo nombres no debe estar vacio")
    private String nombres;

    @JsonProperty("apellidos")
    @NotNull(message = "El campo apellidos no debe ser nulo")
    @NotEmpty(message = "El campo apellidos no debe estar vacio")
    private String apellidos;

    @JsonProperty("fechaIngreso")
    @NotNull(message = "El campo fechaIngreso no debe estar vacio")
    private Date fechaIngreso;

    @JsonProperty("salarioBase")
    @NotNull(message = "El campo salarioBase no debe estar vacio")
    private BigDecimal salarioBase;

    @JsonProperty("fechaRetiro")
    private Date fechaRetiro;

}
