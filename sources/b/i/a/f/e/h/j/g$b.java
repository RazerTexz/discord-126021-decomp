package b.i.a.f.e.h.j;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import b.i.a.f.e.h.a$f;
import b.i.a.f.e.k.b$c;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class g$b implements h0, b$c {
    public final a$f a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b<?> f1362b;

    @Nullable
    public b.i.a.f.e.k.g c = null;

    @Nullable
    public Set<Scope> d = null;
    public boolean e = false;
    public final /* synthetic */ g f;

    public g$b(g gVar, a$f a_f, b<?> bVar) {
        this.f = gVar;
        this.a = a_f;
        this.f1362b = bVar;
    }

    @Override // b.i.a.f.e.k.b$c
    public final void a(@NonNull ConnectionResult connectionResult) {
        this.f.f1359x.post(new z(this, connectionResult));
    }

    @WorkerThread
    public final void b(ConnectionResult connectionResult) {
        g$a<?> g_a = this.f.t.get(this.f1362b);
        if (g_a != null) {
            b.c.a.a0.d.s(g_a.m.f1359x);
            a$f a_f = g_a.f1361b;
            String name = g_a.c.getClass().getName();
            String strValueOf = String.valueOf(connectionResult);
            a_f.c(b.d.b.a.a.l(strValueOf.length() + name.length() + 25, "onSignInFailed for ", name, " with ", strValueOf));
            g_a.e(connectionResult, null);
        }
    }
}
