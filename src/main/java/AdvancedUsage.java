package jgrove;

import jquil.g;
import jquil.Program;
import jquil.Program;
import jquil.WavefunctionSimulator;
import jquil.Wavefunction;

import java.lang.Math;

/**
 * <h1>Advanced features of jquil</h1>
 * The Advanced Usage class contains
 * most of the programs on
 * http://pyquil.readthedocs.io/en/latest/advanced_usage.html
 * <p>
 */
public class AdvancedUsage {
    public AdvancedUsage() {}

    public static Program qft(int q0, int q1, int q2) {
	
	Program p = new Program(g.H(q2),
				g.CPHASE((Math.PI)/2.0, q1, q2),
				g.H(q1),
				g.CPHASE((Math.PI)/4.0, q0, q2),
				g.CPHASE((Math.PI)/2.0, q0, q1),
				g.H(q0),
				g.SWAP(q0, q2));
	return p;
	   
    }

    public static void run_qft(){
	WavefunctionSimulator wfnsim = new WavefunctionSimulator();

     	Program dummy_qubits = new Program(g.I(1),
					   g.I(2));

	Program state_prep = new Program(g.X(0));
	
	state_prep = state_prep.add(dummy_qubits);

	Program qft = state_prep.add(qft(0, 1, 2));

	System.out.println("Qft " + wfnsim.wavefunction(qft).amplitudes());

    }
}
