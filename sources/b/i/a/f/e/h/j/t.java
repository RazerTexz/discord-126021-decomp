package b.i.a.f.e.h.j;

import android.os.Handler;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class t implements c$a {
    public final /* synthetic */ g a;

    public t(g gVar) {
        this.a = gVar;
    }

    @Override // b.i.a.f.e.h.j.c$a
    public final void a(boolean z2) {
        Handler handler = this.a.f1359x;
        handler.sendMessage(handler.obtainMessage(1, Boolean.valueOf(z2)));
    }
}
