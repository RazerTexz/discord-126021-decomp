package b.i.a.f.e.h.j;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.e.h.a;
import b.i.a.f.e.h.c;
import b.i.a.f.e.h.j.g;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class g0 extends b.i.a.f.l.b.d implements c.a, c.b {
    public static a.AbstractC0035a<? extends b.i.a.f.l.f, b.i.a.f.l.a> a = b.i.a.f.l.c.c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f1364b;
    public final Handler c;
    public final a.AbstractC0035a<? extends b.i.a.f.l.f, b.i.a.f.l.a> d;
    public Set<Scope> e;
    public b.i.a.f.e.k.c f;
    public b.i.a.f.l.f g;
    public h0 h;

    @WorkerThread
    public g0(Context context, Handler handler, @NonNull b.i.a.f.e.k.c cVar) {
        a.AbstractC0035a<? extends b.i.a.f.l.f, b.i.a.f.l.a> abstractC0035a = a;
        this.f1364b = context;
        this.c = handler;
        AnimatableValueParser.z(cVar, "ClientSettings must not be null");
        this.f = cVar;
        this.e = cVar.f1380b;
        this.d = abstractC0035a;
    }

    @Override // b.i.a.f.e.h.j.f
    @WorkerThread
    public final void c(int i) {
        this.g.h();
    }

    @Override // b.i.a.f.e.h.j.l
    @WorkerThread
    public final void g(@NonNull ConnectionResult connectionResult) {
        ((g.b) this.h).b(connectionResult);
    }

    @Override // b.i.a.f.e.h.j.f
    @WorkerThread
    public final void i(@Nullable Bundle bundle) {
        this.g.d(this);
    }
}
