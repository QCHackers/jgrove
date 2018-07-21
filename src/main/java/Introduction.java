package jgrove;

import jquil.QVMConnection;
import jquil.g;
import jquil.Program;
import jquil.WavefunctionSimulator;
import jquil.Wavefunction;
import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.complex.ComplexFormat;
import java.lang.Math;
import java.util.*;

/**
 * <h1>Introduction to quantum programming</h1>
 * The Introduction class contains
 * most of the programs on
 * http://pyquil.readthedocs.io/en/latest/intro.html
 * <p>
 */
public class Introduction {
    public Introduction() {}

    public static void run() {

	WavefunctionSimulator wfnsim = new WavefunctionSimulator();
	QVMConnection quantum_simulator = new QVMConnection();
	Wavefunction wfn = new Wavefunction();
	Program p = new Program(g.H(0));

	wfn = wfnsim.wavefunction(p);
	System.out.println("Before measurement: H|0> = " + wfn.amplitudes());

	p.measure(0, 0);

	for (int i = 0; i < 5; i++) {
	    wfn = wfnsim.wavefunction(p);
	    System.out.println("After measurement: " + wfn.amplitudes());
	}

    }


    public static void classical_control() {
      
	WavefunctionSimulator wfnsim = new WavefunctionSimulator();
	Wavefunction wfn = new Wavefunction();
 
	Program true_branch = new Program(g.X(7));
	Program false_branch = new Program(g.I(7));


	Program p = new Program(g.X(0)).measure(0, 1).if_then(1, true_branch, false_branch);
	
	p.measure(7, 7);

	System.out.println(p.getProgram());
	System.out.println(QVMConnection.run(p, Arrays.asList(7)));
  

    }

    public static void measure() {

	WavefunctionSimulator wfnsim = new WavefunctionSimulator();
	QVMConnection quantum_simulator = new QVMConnection();
	Wavefunction wfn = new Wavefunction();
	Program p = new Program(g.I(0));

	System.out.println("Qvm wavefunction " + QVMConnection.run(p, Arrays.asList(0, 1))); 

    }

}
