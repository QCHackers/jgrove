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

}
