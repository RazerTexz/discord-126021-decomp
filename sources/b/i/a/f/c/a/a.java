package b.i.a.f.c.a;

import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.c.a.f.b.f;
import b.i.a.f.e.h.a;
import b.i.a.f.h.c.o;
import b.i.a.f.h.d.d;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final a.g<o> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a.g<f> f1332b;
    public static final a.AbstractC0035a<o, C0033a> c;
    public static final a.AbstractC0035a<f, GoogleSignInOptions> d;
    public static final b.i.a.f.e.h.a<C0033a> e;
    public static final b.i.a.f.e.h.a<GoogleSignInOptions> f;
    public static final b.i.a.f.c.a.d.c g;

    /* JADX INFO: renamed from: b.i.a.f.c.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
    @Deprecated
    public static class C0033a implements a.d {
        public static final C0033a j = new C0033a(new C0034a());
        public final String k;
        public final boolean l;

        @Nullable
        public final String m;

        public C0033a(C0034a c0034a) {
            this.k = c0034a.a;
            this.l = c0034a.f1333b.booleanValue();
            this.m = c0034a.c;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0033a)) {
                return false;
            }
            C0033a c0033a = (C0033a) obj;
            return AnimatableValueParser.h0(this.k, c0033a.k) && this.l == c0033a.l && AnimatableValueParser.h0(this.m, c0033a.m);
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.k, Boolean.valueOf(this.l), this.m});
        }

        /* JADX INFO: renamed from: b.i.a.f.c.a.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
        @Deprecated
        public static class C0034a {
            public String a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Boolean f1333b;

            @Nullable
            public String c;

            public C0034a() {
                this.f1333b = Boolean.FALSE;
            }

            public C0034a(C0033a c0033a) {
                this.f1333b = Boolean.FALSE;
                this.a = c0033a.k;
                this.f1333b = Boolean.valueOf(c0033a.l);
                this.c = c0033a.m;
            }
        }
    }

    static {
        a.g<o> gVar = new a.g<>();
        a = gVar;
        a.g<f> gVar2 = new a.g<>();
        f1332b = gVar2;
        h hVar = new h();
        c = hVar;
        i iVar = new i();
        d = iVar;
        b.i.a.f.e.h.a<c> aVar = b.c;
        e = new b.i.a.f.e.h.a<>("Auth.CREDENTIALS_API", hVar, gVar);
        f = new b.i.a.f.e.h.a<>("Auth.GOOGLE_SIGN_IN_API", iVar, gVar2);
        d dVar = b.d;
        g = new b.i.a.f.h.c.h();
    }
}
