package jgrove;

import jquil.g;
import jquil.QVMConnection;
import jquil.Program;
import jquil.WavefunctionSimulator;
import jquil.Wavefunction;

import java.util.Arrays;

public class EPR {  

    public static void runEPR() {
	
	WavefunctionSimulator wvfsim = new WavefunctionSimulator();
	
        Program p = new Program(g.H(0),
				g.CNOT(0, 1));   

	System.out.println("BELL state before measurement " +  Wavefunction.bra_ket(wvfsim.wavefunction(p)));

	p.measure(0,0);
	p.measure(1,1);
	
	System.out.println("Bell state after measurement " + QVMConnection.run(p, Arrays.asList(0, 1)));
	

    }

}
