package b.i.a.f.i.b;

import androidx.annotation.WorkerThread;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@WorkerThread
public final class y3 implements Runnable {
    public final z3 j;
    public final int k;
    public final Throwable l;
    public final byte[] m;
    public final String n;
    public final Map<String, List<String>> o;

    public y3(String str, z3 z3Var, int i, Throwable th, byte[] bArr, Map map, w3 w3Var) {
        Objects.requireNonNull(z3Var, "null reference");
        this.j = z3Var;
        this.k = i;
        this.l = th;
        this.m = bArr;
        this.n = str;
        this.o = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.a(this.n, this.k, this.l, this.m, this.o);
    }
}
