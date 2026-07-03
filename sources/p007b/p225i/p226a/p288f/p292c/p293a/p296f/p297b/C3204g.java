package p007b.p225i.p226a.p288f.p292c.p293a.p296f.p297b;

import android.content.Context;
import android.os.Handler;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import p007b.p225i.p226a.p288f.p299e.p300h.AbstractC3268c;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3293g;
import p007b.p225i.p226a.p288f.p299e.p305l.C3395a;

/* JADX INFO: renamed from: b.i.a.f.c.a.f.b.g */
/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3204g {

    /* JADX INFO: renamed from: a */
    public static C3395a f9235a = new C3395a("GoogleSignInCommon", new String[0]);

    /* JADX INFO: renamed from: a */
    public static void m3986a(Context context) {
        C3210m.m3990b(context).m3991a();
        Set<AbstractC3268c> set = AbstractC3268c.f9338a;
        synchronized (set) {
        }
        Iterator<AbstractC3268c> it = set.iterator();
        if (it.hasNext()) {
            Objects.requireNonNull(it.next());
            throw new UnsupportedOperationException();
        }
        synchronized (C3293g.f9378l) {
            C3293g c3293g = C3293g.f9379m;
            if (c3293g != null) {
                c3293g.f9385s.incrementAndGet();
                Handler handler = c3293g.f9390x;
                handler.sendMessageAtFrontOfQueue(handler.obtainMessage(10));
            }
        }
    }
}
