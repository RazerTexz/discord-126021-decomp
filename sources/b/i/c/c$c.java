package b.i.c;

import android.annotation.TargetApi;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FirebaseApp.java */
/* JADX INFO: loaded from: classes3.dex */
@TargetApi(14)
public class c$c implements b.i.a.f.e.h.j.c$a {
    public static AtomicReference<c$c> a = new AtomicReference<>();

    @Override // b.i.a.f.e.h.j.c$a
    public void a(boolean z2) {
        Object obj = c.a;
        synchronized (c.a) {
            for (c cVar : new ArrayList(c.c.values())) {
                if (cVar.h.get()) {
                    Log.d("FirebaseApp", "Notifying background state change listeners.");
                    Iterator<c$b> it = cVar.k.iterator();
                    while (it.hasNext()) {
                        it.next().a(z2);
                    }
                }
            }
        }
    }
}
