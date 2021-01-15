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
public class EmployeePayResponse {

    @Id
    private Integer id;

    @JsonProperty("nombres")
    private String nombres;

    @JsonProperty("apellidos")
    private String apellidos;

    @JsonProperty("fechaIngreso")
    private Date fechaIngreso;

    @JsonProperty("salarioBase")
    private Double salarioBase;

    @JsonProperty("valorApaqar")
    private BigDecimal valorApaqar;


}
