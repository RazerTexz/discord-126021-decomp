package b.d.a.a;

/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class x implements Runnable {
    public final /* synthetic */ e j;
    public final /* synthetic */ d k;

    public /* synthetic */ x(e eVar, d dVar) {
        this.j = eVar;
        this.k = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.onConsumeResponse(p.k, this.k.a);
    }
}
