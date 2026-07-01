package b.i.c.o.b;

import android.content.Context;
import androidx.annotation.NonNull;
import b.i.a.f.e.h.a;
import b.i.a.f.e.h.b;

/* JADX INFO: compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends b.i.a.f.e.h.b<a.d.c> {
    public static final a.g<d> j;
    public static final a.AbstractC0035a<d, a.d.c> k;
    public static final b.i.a.f.e.h.a<a.d.c> l;

    static {
        a.g<d> gVar = new a.g<>();
        j = gVar;
        b bVar = new b();
        k = bVar;
        l = new b.i.a.f.e.h.a<>("DynamicLinks.API", bVar, gVar);
    }

    public c(@NonNull Context context) {
        super(context, l, (a.d) null, b.a.a);
    }
}
