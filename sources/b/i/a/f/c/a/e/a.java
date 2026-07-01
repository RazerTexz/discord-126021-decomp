package b.i.a.f.c.a.e;

import android.content.Context;
import androidx.annotation.NonNull;
import b.i.a.f.e.h.a$a;
import b.i.a.f.e.h.a$d;
import b.i.a.f.e.h.a$d$c;
import b.i.a.f.e.h.a$g;
import b.i.a.f.e.h.b$a;
import b.i.a.f.h.b.i;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth-api-phone@@17.4.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends b.i.a.f.e.h.b<a$d$c> {
    public static final a$g<i> j;
    public static final a$a<i, a$d$c> k;
    public static final b.i.a.f.e.h.a<a$d$c> l;

    static {
        a$g<i> a_g = new a$g<>();
        j = a_g;
        b bVar = new b();
        k = bVar;
        l = new b.i.a.f.e.h.a<>("SmsRetriever.API", bVar, a_g);
    }

    public a(@NonNull Context context) {
        super(context, l, (a$d) null, b$a.a);
    }
}
