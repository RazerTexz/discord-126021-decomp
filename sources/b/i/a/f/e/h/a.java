package b.i.a.f.e.h;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.e.h.a.d;
import b.i.a.f.e.h.c;
import b.i.a.f.e.k.b;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class a<O extends d> {

    @Nullable
    public final AbstractC0035a<?, O> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final g<?> f1350b;
    public final String c;

    /* JADX INFO: renamed from: b.i.a.f.e.h.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    public static abstract class AbstractC0035a<T extends f, O> extends e<T, O> {
        @Deprecated
        public T a(Context context, Looper looper, b.i.a.f.e.k.c cVar, O o, c.a aVar, c.b bVar) {
            return (T) b(context, looper, cVar, o, aVar, bVar);
        }

        public T b(Context context, Looper looper, b.i.a.f.e.k.c cVar, O o, b.i.a.f.e.h.j.f fVar, b.i.a.f.e.h.j.l lVar) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    public interface b {
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    public static class c<C extends b> {
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    public interface d {

        /* JADX INFO: renamed from: b.i.a.f.e.h.a$d$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
        public interface InterfaceC0036a extends d {
            Account T();
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
        public interface b extends d {
            GoogleSignInAccount L();
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
        public static final class c implements d {
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    public static abstract class e<T extends b, O> {
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    public interface f extends b {
        @NonNull
        Set<Scope> a();

        void b(@Nullable b.i.a.f.e.k.g gVar, @Nullable Set<Scope> set);

        void c(String str);

        boolean e();

        String f();

        void g(b.c cVar);

        void h();

        void i(b.e eVar);

        boolean j();

        boolean k();

        int l();

        Feature[] m();

        @Nullable
        String n();

        boolean o();
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    public static final class g<C extends f> extends c<C> {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <C extends f> a(String str, AbstractC0035a<C, O> abstractC0035a, g<C> gVar) {
        AnimatableValueParser.z(abstractC0035a, "Cannot construct an Api with a null ClientBuilder");
        AnimatableValueParser.z(gVar, "Cannot construct an Api with a null ClientKey");
        this.c = str;
        this.a = abstractC0035a;
        this.f1350b = gVar;
    }
}
