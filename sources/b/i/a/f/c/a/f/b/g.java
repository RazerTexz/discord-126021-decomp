package b.i.a.f.c.a.f.b;

import android.content.Context;
import android.os.Handler;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public static b.i.a.f.e.l.a a = new b.i.a.f.e.l.a("GoogleSignInCommon", new String[0]);

    public static void a(Context context) {
        m.b(context).a();
        Set<b.i.a.f.e.h.c> set = b.i.a.f.e.h.c.a;
        synchronized (set) {
        }
        Iterator<b.i.a.f.e.h.c> it = set.iterator();
        if (it.hasNext()) {
            Objects.requireNonNull(it.next());
            throw new UnsupportedOperationException();
        }
        synchronized (b.i.a.f.e.h.j.g.l) {
            b.i.a.f.e.h.j.g gVar = b.i.a.f.e.h.j.g.m;
            if (gVar != null) {
                gVar.f1358s.incrementAndGet();
                Handler handler = gVar.f1359x;
                handler.sendMessageAtFrontOfQueue(handler.obtainMessage(10));
            }
        }
    }
}
