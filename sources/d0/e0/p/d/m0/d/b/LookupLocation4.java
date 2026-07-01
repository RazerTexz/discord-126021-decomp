package d0.e0.p.d.m0.d.b;

import b.d.b.a.outline;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.d.b.e, reason: use source file name */
/* JADX INFO: compiled from: LookupLocation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class LookupLocation4 implements Serializable {
    public static final a j = new a(null);
    public static final LookupLocation4 k = new LookupLocation4(-1, -1);
    private final int column;
    private final int line;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.d.b.e$a */
    /* JADX INFO: compiled from: LookupLocation.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final LookupLocation4 getNO_POSITION() {
            return LookupLocation4.k;
        }
    }

    public LookupLocation4(int i, int i2) {
        this.line = i;
        this.column = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LookupLocation4)) {
            return false;
        }
        LookupLocation4 lookupLocation4 = (LookupLocation4) obj;
        return this.line == lookupLocation4.line && this.column == lookupLocation4.column;
    }

    public int hashCode() {
        return (this.line * 31) + this.column;
    }

    public String toString() {
        StringBuilder sbU = outline.U("Position(line=");
        sbU.append(this.line);
        sbU.append(", column=");
        return outline.A(sbU, this.column, ')');
    }
}
