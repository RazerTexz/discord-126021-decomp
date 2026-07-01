package androidx.constraintlayout.solver;

/* JADX INFO: loaded from: classes.dex */
public interface ArrayRow$ArrayRowVariables {
    void add(SolverVariable solverVariable, float f, boolean z2);

    void clear();

    boolean contains(SolverVariable solverVariable);

    void display();

    void divideByAmount(float f);

    float get(SolverVariable solverVariable);

    int getCurrentSize();

    SolverVariable getVariable(int i);

    float getVariableValue(int i);

    int indexOf(SolverVariable solverVariable);

    void invert();

    void put(SolverVariable solverVariable, float f);

    float remove(SolverVariable solverVariable, boolean z2);

    int sizeInBytes();

    float use(ArrayRow arrayRow, boolean z2);
}
