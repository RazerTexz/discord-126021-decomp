package d0.e0.p.d.m0.e.b.b0;

import d0.t.j;
import d0.t.n;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: KotlinClassHeader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public final a$a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.f.a0.b.f f3366b;
    public final String[] c;
    public final String[] d;
    public final String[] e;
    public final String f;
    public final int g;

    public a(a$a a_a, d0.e0.p.d.m0.f.a0.b.f fVar, d0.e0.p.d.m0.f.a0.b.c cVar, String[] strArr, String[] strArr2, String[] strArr3, String str, int i, String str2) {
        m.checkNotNullParameter(a_a, "kind");
        m.checkNotNullParameter(fVar, "metadataVersion");
        m.checkNotNullParameter(cVar, "bytecodeVersion");
        this.a = a_a;
        this.f3366b = fVar;
        this.c = strArr;
        this.d = strArr2;
        this.e = strArr3;
        this.f = str;
        this.g = i;
    }

    public final boolean a(int i, int i2) {
        return (i & i2) != 0;
    }

    public final String[] getData() {
        return this.c;
    }

    public final String[] getIncompatibleData() {
        return this.d;
    }

    public final a$a getKind() {
        return this.a;
    }

    public final d0.e0.p.d.m0.f.a0.b.f getMetadataVersion() {
        return this.f3366b;
    }

    public final String getMultifileClassName() {
        String str = this.f;
        if (getKind() == a$a.MULTIFILE_CLASS_PART) {
            return str;
        }
        return null;
    }

    public final List<String> getMultifilePartNames() {
        String[] strArr = this.c;
        if (!(getKind() == a$a.MULTIFILE_CLASS)) {
            strArr = null;
        }
        List<String> listAsList = strArr != null ? j.asList(strArr) : null;
        return listAsList != null ? listAsList : n.emptyList();
    }

    public final String[] getStrings() {
        return this.e;
    }

    public final boolean isPreRelease() {
        return a(this.g, 2);
    }

    public final boolean isUnstableFirBinary() {
        return a(this.g, 64) && !a(this.g, 32);
    }

    public final boolean isUnstableJvmIrBinary() {
        return a(this.g, 16) && !a(this.g, 32);
    }

    public String toString() {
        return this.a + " version=" + this.f3366b;
    }
}
