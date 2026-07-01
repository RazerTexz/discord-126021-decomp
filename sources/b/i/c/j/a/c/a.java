package b.i.c.j.a.c;

import android.content.Context;
import android.os.Bundle;
import b.i.a.f.h.l.g;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements b.i.c.l.f {
    public static final b.i.c.l.f a = new a();

    @Override // b.i.c.l.f
    public final Object a(b.i.c.l.e eVar) {
        b.i.c.c cVar = (b.i.c.c) eVar.a(b.i.c.c.class);
        Context context = (Context) eVar.a(Context.class);
        b.i.c.q.d dVar = (b.i.c.q.d) eVar.a(b.i.c.q.d.class);
        Objects.requireNonNull(cVar, "null reference");
        Objects.requireNonNull(context, "null reference");
        Objects.requireNonNull(dVar, "null reference");
        Objects.requireNonNull(context.getApplicationContext(), "null reference");
        if (b.i.c.j.a.b.a == null) {
            synchronized (b.i.c.j.a.b.class) {
                if (b.i.c.j.a.b.a == null) {
                    Bundle bundle = new Bundle(1);
                    if (cVar.h()) {
                        dVar.b(b.i.c.a.class, b.i.c.j.a.e.j, b.i.c.j.a.d.a);
                        bundle.putBoolean("dataCollectionDefaultEnabled", cVar.g());
                    }
                    b.i.c.j.a.b.a = new b.i.c.j.a.b(g.a(context, null, null, null, bundle).f);
                }
            }
        }
        return b.i.c.j.a.b.a;
    }
}
