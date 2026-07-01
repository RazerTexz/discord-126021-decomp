package b.i.a.f.l;

import androidx.core.app.NotificationCompat;
import b.i.a.f.e.h.a$a;
import b.i.a.f.e.h.a$g;
import com.google.android.gms.common.api.Scope;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final a$g<b.i.a.f.l.b.a> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a$g<b.i.a.f.l.b.a> f1590b;
    public static final a$a<b.i.a.f.l.b.a, a> c;
    public static final a$a<b.i.a.f.l.b.a, g> d;

    static {
        a$g<b.i.a.f.l.b.a> a_g = new a$g<>();
        a = a_g;
        a$g<b.i.a.f.l.b.a> a_g2 = new a$g<>();
        f1590b = a_g2;
        e eVar = new e();
        c = eVar;
        d dVar = new d();
        d = dVar;
        new Scope("profile");
        new Scope(NotificationCompat.CATEGORY_EMAIL);
        b.c.a.a0.d.z(eVar, "Cannot construct an Api with a null ClientBuilder");
        b.c.a.a0.d.z(a_g, "Cannot construct an Api with a null ClientKey");
        b.c.a.a0.d.z(dVar, "Cannot construct an Api with a null ClientBuilder");
        b.c.a.a0.d.z(a_g2, "Cannot construct an Api with a null ClientKey");
    }
}
