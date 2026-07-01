package b.i.a.c.e3.b0;

import androidx.annotation.Nullable;
import java.io.File;

/* JADX INFO: compiled from: CacheSpan.java */
/* JADX INFO: loaded from: classes3.dex */
public class h implements Comparable<h> {
    public final String j;
    public final long k;
    public final long l;
    public final boolean m;

    @Nullable
    public final File n;
    public final long o;

    public h(String str, long j, long j2, long j3, @Nullable File file) {
        this.j = str;
        this.k = j;
        this.l = j2;
        this.m = file != null;
        this.n = file;
        this.o = j3;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(h hVar) {
        return f(hVar);
    }

    public int f(h hVar) {
        if (!this.j.equals(hVar.j)) {
            return this.j.compareTo(hVar.j);
        }
        long j = this.k - hVar.k;
        if (j == 0) {
            return 0;
        }
        return j < 0 ? -1 : 1;
    }

    public String toString() {
        long j = this.k;
        return b.d.b.a.a.C(b.d.b.a.a.R(44, "[", j, ", "), this.l, "]");
    }
}
