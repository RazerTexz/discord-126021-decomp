package androidx.constraintlayout.solver;

/* JADX INFO: loaded from: classes.dex */
public interface LinearSystem$Row {
    void addError(SolverVariable solverVariable);

    void clear();

    SolverVariable getKey();

    SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr);

    void initFromRow(LinearSystem$Row linearSystem$Row);

    boolean isEmpty();

    void updateFromFinalVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z2);

    void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z2);

    void updateFromSystem(LinearSystem linearSystem);
}
