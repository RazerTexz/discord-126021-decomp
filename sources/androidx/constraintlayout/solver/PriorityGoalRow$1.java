package androidx.constraintlayout.solver;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class PriorityGoalRow$1 implements Comparator<SolverVariable> {
    public final /* synthetic */ PriorityGoalRow this$0;

    public PriorityGoalRow$1(PriorityGoalRow priorityGoalRow) {
        this.this$0 = priorityGoalRow;
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(SolverVariable solverVariable, SolverVariable solverVariable2) {
        return compare2(solverVariable, solverVariable2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(SolverVariable solverVariable, SolverVariable solverVariable2) {
        return solverVariable.f30id - solverVariable2.f30id;
    }
}
