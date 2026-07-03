package p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: d0.e0.p.d.m0.d.b.e */
/* JADX INFO: compiled from: LookupLocation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11483e implements Serializable {

    /* JADX INFO: renamed from: j */
    public static final a f23135j = new a(null);

    /* JADX INFO: renamed from: k */
    public static final C11483e f23136k = new C11483e(-1, -1);
    private final int column;
    private final int line;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.d.b.e$a */
    /* JADX INFO: compiled from: LookupLocation.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final C11483e getNO_POSITION() {
            return C11483e.f23136k;
        }
    }

    public C11483e(int i, int i2) {
        this.line = i;
        this.column = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11483e)) {
            return false;
        }
        C11483e c11483e = (C11483e) obj;
        return this.line == c11483e.line && this.column == c11483e.column;
    }

    public int hashCode() {
        return (this.line * 31) + this.column;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("Position(line=");
        sbM833U.append(this.line);
        sbM833U.append(", column=");
        return C1643a.m813A(sbM833U, this.column, ')');
    }
}
