package s.a.b2;

import s.a.m0;

/* JADX INFO: compiled from: HandlerDispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$a implements m0 {
    public final /* synthetic */ a j;
    public final /* synthetic */ Runnable k;

    public a$a(a aVar, Runnable runnable) {
        this.j = aVar;
        this.k = runnable;
    }

    @Override // s.a.m0
    public void dispose() {
        this.j.k.removeCallbacks(this.k);
    }
}
