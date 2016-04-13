package structvisualizer.data;

 /*
 * DataForValueFactory   4/11/16, 19:02
 *
 * By Kyrylo Havrylenko
 *
 */

import java.util.List;

/**
 * Class to save user input from the GUI forms and use later in animation
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class DataForValueFactory {
    Integer iteration;
    boolean rand;
    List<Integer> iterations;
    boolean write;
    Integer setWhat;
    Integer setToWhat;

    public int getSetToWhat() {
        return setToWhat;
    }

    public void setSetToWhat(int setToWhat) {
        this.setToWhat = setToWhat;
    }

    public int getSetWhat() {
        return setWhat;
    }

    public void setSetWhat(int setWhat) {
        this.setWhat = setWhat;
    }

    public int getIteration() {
        return iteration;
    }

    public void setIteration(int iteration) {
        this.iteration = iteration;
    }

    public boolean isRand() {
        return rand;
    }

    public void setRand(boolean rand) {
        this.rand = rand;
    }

    public List<Integer> getIterations() {
        return iterations;
    }

    public void setIterations(List<Integer> iterations) {
        this.iterations = iterations;
    }

    public boolean isWrite() {
        return write;
    }

    public void setWrite(boolean write) {
        this.write = write;
    }

    /**
     *
     * @param iter {@code iteration}
     * @param rand does {@iter iter} has to be rand
     * @param iters
     * @param write
     * @param setWhat from
     * @param setToWhat to
     * @see structvisualizer.valuefactories.TypeValueFactory
     */
    public DataForValueFactory(Integer iter, boolean rand, List<Integer> iters, boolean write, Integer setWhat, Integer
            setToWhat) {
        iteration = iter;
        this.rand = rand;
        iterations = iters;
        this.write = write;
        this.setWhat = setWhat;
        this.setToWhat = setToWhat;
    }
}
