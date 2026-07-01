package b.i.a.g.f;

/* JADX INFO: compiled from: StaticLayoutBuilderCompat.java */
/* JADX INFO: loaded from: classes3.dex */
public class a$a extends Exception {
    /* JADX WARN: Illegal instructions before constructor call */
    public a$a(Throwable th) {
        StringBuilder sbU = b.d.b.a.a.U("Error thrown initializing StaticLayout ");
        sbU.append(th.getMessage());
        super(sbU.toString(), th);
    }
}
