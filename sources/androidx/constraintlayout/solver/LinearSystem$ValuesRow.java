package androidx.constraintlayout.solver;

/* JADX INFO: loaded from: classes.dex */
public class LinearSystem$ValuesRow extends ArrayRow {
    public final /* synthetic */ LinearSystem this$0;

    public LinearSystem$ValuesRow(LinearSystem linearSystem, Cache cache) {
        this.this$0 = linearSystem;
        this.variables = new SolverVariableValues(this, cache);
    }
}
