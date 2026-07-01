package b.a.a.d;

/* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f$b$b extends f$b {
    public final int a;

    public f$b$b(int i) {
        super(null);
        this.a = i;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof f$b$b) && this.a == ((f$b$b) obj).a;
        }
        return true;
    }

    public int hashCode() {
        return this.a;
    }

    public String toString() {
        return b.d.b.a.a.B(b.d.b.a.a.U("Success(successMessageStringRes="), this.a, ")");
    }
}
