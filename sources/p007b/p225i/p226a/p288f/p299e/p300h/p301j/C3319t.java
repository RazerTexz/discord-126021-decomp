package p007b.p225i.p226a.p288f.p299e.p300h.p301j;

import android.os.Handler;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.ComponentCallbacks2C3281c;

/* JADX INFO: renamed from: b.i.a.f.e.h.j.t */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3319t implements ComponentCallbacks2C3281c.a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C3293g f9450a;

    public C3319t(C3293g c3293g) {
        this.f9450a = c3293g;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.ComponentCallbacks2C3281c.a
    /* JADX INFO: renamed from: a */
    public final void mo4066a(boolean z2) {
        Handler handler = this.f9450a.f9390x;
        handler.sendMessage(handler.obtainMessage(1, Boolean.valueOf(z2)));
    }
}
