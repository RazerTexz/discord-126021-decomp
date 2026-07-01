package b.i.a.f.e.h;

import androidx.annotation.Nullable;
import b.i.a.f.e.h.a$d;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class a<O extends a$d> {

    @Nullable
    public final a$a<?, O> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final a$g<?> f1350b;
    public final String c;

    /* JADX WARN: Multi-variable type inference failed */
    public <C extends a$f> a(String str, a$a<C, O> a_a, a$g<C> a_g) {
        b.c.a.a0.d.z(a_a, "Cannot construct an Api with a null ClientBuilder");
        b.c.a.a0.d.z(a_g, "Cannot construct an Api with a null ClientKey");
        this.c = str;
        this.a = a_a;
        this.f1350b = a_g;
    }
}
