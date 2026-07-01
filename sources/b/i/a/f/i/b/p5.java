package b.i.a.f.i.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class p5 implements Runnable {
    public final /* synthetic */ String j;
    public final /* synthetic */ String k;
    public final /* synthetic */ String l;
    public final /* synthetic */ long m;
    public final /* synthetic */ z4 n;

    public p5(z4 z4Var, String str, String str2, String str3, long j) {
        this.n = z4Var;
        this.j = str;
        this.k = str2;
        this.l = str3;
        this.m = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.j == null) {
            this.n.a.k.w().D(this.k, null);
            return;
        }
        h7 h7VarW = this.n.a.k.w();
        String str = this.k;
        h7VarW.b();
        synchronized (h7VarW) {
            String str2 = h7VarW.m;
            if (str2 != null) {
                str2.equals(str);
            }
            h7VarW.m = str;
        }
    }
}
