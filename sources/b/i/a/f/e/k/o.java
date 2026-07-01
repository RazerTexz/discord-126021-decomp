package b.i.a.f.e.k;

import android.content.Intent;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class o extends n {
    public final /* synthetic */ Intent j;
    public final /* synthetic */ b.i.a.f.e.h.j.j k;

    public o(Intent intent, b.i.a.f.e.h.j.j jVar, int i) {
        this.j = intent;
        this.k = jVar;
    }

    @Override // b.i.a.f.e.k.n
    public final void a() {
        Intent intent = this.j;
        if (intent != null) {
            this.k.startActivityForResult(intent, 2);
        }
    }
}
