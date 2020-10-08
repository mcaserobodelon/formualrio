package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorFormulario {
	
	@RequestMapping(value="/formulario", method=RequestMethod.GET)		// Tomo los datos del formulario
	  public String hola_get() {
	    return "formulario";
	  }
	
	@RequestMapping(value="/formulario", method=RequestMethod.POST)
	 public String hola_post(Model modelo,
			 	@RequestParam String nombre,
			 	@RequestParam String apellido1,
			 	@RequestParam String apellido2,
			 	@RequestParam String email,
			 	@RequestParam Integer dia,
			 	@RequestParam Integer mes,
			 	@RequestParam Integer anio,
			 	@RequestParam String pwd,
			 	@RequestParam(required = false) String sex,
			 	@RequestParam String dirc,
			 	@RequestParam(required = false) String std,
			 	@RequestParam(required = false) String artMus,
			 	@RequestParam(required = false) String artDep,
			 	@RequestParam(required = false) String artCin,
			 	@RequestParam(required = false) String artLib,
			 	@RequestParam(required = false) String artCie) {
		
		
		modelo.addAttribute("nombre_form", nombre);
		modelo.addAttribute("apellido1_form", apellido1);
		modelo.addAttribute("apellido2_form", apellido2);
		modelo.addAttribute("email_form", email);
		modelo.addAttribute("dia_form", dia);
		modelo.addAttribute("mes_form", mes);
		modelo.addAttribute("anio_form", anio);
		modelo.addAttribute("pwd_form", pwd);
		modelo.addAttribute("sex_form", sex);
		modelo.addAttribute("dirc_form", dirc);
		modelo.addAttribute("std_form", std);
		modelo.addAttribute("artMus_form", artMus);
		modelo.addAttribute("artDep_form", artDep);
		modelo.addAttribute("artCin_form", artCin);
		modelo.addAttribute("artLib_form", artLib);
		modelo.addAttribute("artCie_form", artCie);
		
		return "datosFormulario";
	}
	
	/* Aquí empiezó el segundo ejercicio, calcular el indice de masa corporal tomando los tados en un formulario*/
	
	@RequestMapping(value="/formularioIMC", method=RequestMethod.GET)		// Tomo los datos del formulario
	  public String imc_get() {
	    return "formularioIMC";
	  }
	
	@RequestMapping(value="/formularioIMC", method=RequestMethod.POST)
	 public String imc_post(Model modelo,
			 	@RequestParam Integer peso,
			 	@RequestParam Integer estaturacm,
			 	@RequestParam(required = false) String sex) {
		
		// Calculamos el indice de masa corporal
		double estaturacm2 = estaturacm;
		double estaturam = estaturacm2 / 100;
		Double solc =  peso / (estaturam * estaturam);
		String cadena = String.valueOf(solc);
		
		// Usamos el metodo indiceMC para guardar la frase correspondiente
		
		
		String frase = indiceMC(solc, sex);
		
		
		// Guardamos para enviar los datos a la siguiente pagina
		modelo.addAttribute("peso_form", peso);
		modelo.addAttribute("estatura_form", estaturam);
		modelo.addAttribute("sex_form", sex);
		modelo.addAttribute("solc_form", cadena);
		modelo.addAttribute("frase_form", frase);
		
		
		return "datosIMC";
	}
	
	private static String indiceMC (double porciento, String sexo) {	// Le pasamos un % de IMC y nos devuelve una frase, ej en forma o sobrepeso
        String solc = "muerto";
        if (sexo.equals("h")) {
            if (porciento > 2 && porciento < 5) {
                solc = "Grasas esencial";
                return solc;
            }
            else if ( porciento < 13){
                solc = "Atletas";
                return solc;
            }
            else if ( porciento < 17){
                solc = "Fitness";
                return solc;
            }
            else if ( porciento < 24){
                solc = "Aceptable";
                return solc;
            }
            else {
                solc = "Obesidad";
                return solc;
            }
        }
        else if (sexo.equals("m")) {
            if (porciento > 10 && porciento < 13) {
                solc = "Grasas esencial";
                return solc;
            }
            else if ( porciento < 20){
                solc = "Atletas";
                return solc;
            }
            else if ( porciento < 24){
                solc = "Fitness";
                return solc;
            }
            else if ( porciento < 31){
                solc = "Aceptable";
                return solc;
            }
            else {
                solc = "Obesidad";
                return solc;
            }
        }
        else {
            return solc;
        }
    }
}
