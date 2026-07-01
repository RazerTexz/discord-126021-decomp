package d0;

/* JADX INFO: compiled from: KotlinVersion.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements Comparable<e> {
    public static final e j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;

    static {
        new e$a(null);
        j = f.get();
    }

    public e(int i, int i2, int i3) {
        this.l = i;
        this.m = i2;
        this.n = i3;
        if (i >= 0 && 255 >= i && i2 >= 0 && 255 >= i2 && i3 >= 0 && 255 >= i3) {
            this.k = (i << 16) + (i2 << 8) + i3;
            return;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i + '.' + i2 + '.' + i3).toString());
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(e eVar) {
        return compareTo2(eVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            obj = null;
        }
        e eVar = (e) obj;
        return eVar != null && this.k == eVar.k;
    }

    public int hashCode() {
        return this.k;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.l);
        sb.append('.');
        sb.append(this.m);
        sb.append('.');
        sb.append(this.n);
        return sb.toString();
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, "other");
        return this.k - eVar.k;
    }
}
