package androidx.constraintlayout.solver.state;

import b.d.b.a.a;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintReference$IncorrectConstraintException extends Exception {
    private final ArrayList<String> mErrors;
    public final /* synthetic */ ConstraintReference this$0;

    public ConstraintReference$IncorrectConstraintException(ConstraintReference constraintReference, ArrayList<String> arrayList) {
        this.this$0 = constraintReference;
        this.mErrors = arrayList;
    }

    public ArrayList<String> getErrors() {
        return this.mErrors;
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sbU = a.U("IncorrectConstraintException: ");
        sbU.append(this.mErrors.toString());
        return sbU.toString();
    }
}
