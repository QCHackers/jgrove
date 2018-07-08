import jquil.QVM;
import jquil.g;
import jquil.Program;
import java.util.Arrays;

public class EPR {
    public static void main(String[] args) {
        QVM qvm = new QVM();

        Program p = new Program(g.H(0),
            g.CNOT(0, 1));

        System.out.println("Wavefunction " + qvm.wavefunction(p, Arrays.asList(1, 2)));

    }
}
