/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora_dev;

import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

public class Derivadas {

    private String funcion = "";
    DJep djep;
    Node nodoFuncion;
    Node nodoDerivada;

    public Derivadas() {
    }

    public void setFuncionADerivar(String funcion) {
        this.funcion = funcion;
    }

    public String getFuncionDerivada() {
        return this.funcion;
    }

    public void derivar() {

        try {

            this.djep = new DJep();
            this.djep.addStandardFunctions();

            this.djep.addStandardConstants();

            this.djep.addComplex();

            this.djep.setAllowUndeclared(true);

            this.djep.setAllowAssignment(true);

            this.djep.setImplicitMul(true);

            this.djep.addStandardDiffRules();

            this.nodoFuncion = this.djep.parse(this.funcion);

            Node diff = this.djep.differentiate(nodoFuncion, "x");

            this.nodoDerivada = this.djep.simplify(diff);

            this.nodoDerivada = this.djep.simplify(this.nodoDerivada); // Simplify again

            this.funcion = this.djep.toString(this.nodoDerivada);

        } catch (ParseException e) {
            this.funcion = "NaN";
            System.out.println("Error: " + e.getErrorInfo());
        }

    }

}