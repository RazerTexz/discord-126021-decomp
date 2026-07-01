package d0.e0.p.d.m0.d.b;

import java.io.Serializable;

/* JADX INFO: compiled from: LookupLocation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements Serializable {
    public static final e$a j = new e$a(null);
    public static final e k = new e(-1, -1);
    private final int column;
    private final int line;

    public e(int i, int i2) {
        this.line = i;
        this.column = i2;
    }

    public static final /* synthetic */ e access$getNO_POSITION$cp() {
        return k;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.line == eVar.line && this.column == eVar.column;
    }

    public int hashCode() {
        return (this.line * 31) + this.column;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Position(line=");
        sbU.append(this.line);
        sbU.append(", column=");
        return b.d.b.a.a.A(sbU, this.column, ')');
    }
}
