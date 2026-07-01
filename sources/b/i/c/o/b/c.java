package b.i.c.o.b;

import android.content.Context;
import androidx.annotation.NonNull;
import b.i.a.f.e.h.a$a;
import b.i.a.f.e.h.a$d;
import b.i.a.f.e.h.a$d$c;
import b.i.a.f.e.h.a$g;
import b.i.a.f.e.h.b$a;

/* JADX INFO: compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends b.i.a.f.e.h.b<a$d$c> {
    public static final a$g<d> j;
    public static final a$a<d, a$d$c> k;
    public static final b.i.a.f.e.h.a<a$d$c> l;

    static {
        a$g<d> a_g = new a$g<>();
        j = a_g;
        b bVar = new b();
        k = bVar;
        l = new b.i.a.f.e.h.a<>("DynamicLinks.API", bVar, a_g);
    }

    public c(@NonNull Context context) {
        super(context, l, (a$d) null, b$a.a);
    }
}
