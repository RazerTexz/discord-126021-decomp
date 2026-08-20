package p007b.p225i.p226a.p288f.p299e.p300h.p301j;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import java.util.Set;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p300h.AbstractC3268c;
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a;
import p007b.p225i.p226a.p288f.p299e.p304k.C3347c;
import p007b.p225i.p226a.p288f.p337l.C4335a;
import p007b.p225i.p226a.p288f.p337l.C4346c;
import p007b.p225i.p226a.p288f.p337l.InterfaceC4349f;
import p007b.p225i.p226a.p288f.p337l.p338b.BinderC4339d;

/* JADX INFO: renamed from: b.i.a.f.e.h.j.g0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class BinderC3294g0 extends BinderC4339d implements AbstractC3268c.a, AbstractC3268c.b {

    /* JADX INFO: renamed from: a */
    public static C3266a.a<? extends InterfaceC4349f, C4335a> f9413a = C4346c.f11456c;

    /* JADX INFO: renamed from: b */
    public final Context f9414b;

    /* JADX INFO: renamed from: c */
    public final Handler f9415c;

    /* JADX INFO: renamed from: d */
    public final C3266a.a<? extends InterfaceC4349f, C4335a> f9416d;

    /* JADX INFO: renamed from: e */
    public Set<Scope> f9417e;

    /* JADX INFO: renamed from: f */
    public C3347c f9418f;

    /* JADX INFO: renamed from: g */
    public InterfaceC4349f f9419g;

    /* JADX INFO: renamed from: h */
    public InterfaceC3296h0 f9420h;

    @WorkerThread
    public BinderC3294g0(Context context, Handler handler, @NonNull C3347c c3347c) {
        C3266a.a<? extends InterfaceC4349f, C4335a> aVar = f9413a;
        this.f9414b = context;
        this.f9415c = handler;
        C1460d.m595z(c3347c, "ClientSettings must not be null");
        this.f9418f = c3347c;
        this.f9417e = c3347c.f9502b;
        this.f9416d = aVar;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.InterfaceC3290f
    @WorkerThread
    /* JADX INFO: renamed from: c */
    public final void mo4076c(int i) {
        this.f9419g.mo4036h();
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.InterfaceC3303l
    @WorkerThread
    /* JADX INFO: renamed from: g */
    public final void mo4087g(@NonNull ConnectionResult connectionResult) {
        ((C3293g.b) this.f9420h).m4104b(connectionResult);
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.InterfaceC3290f
    @WorkerThread
    /* JADX INFO: renamed from: i */
    public final void mo4077i(@Nullable Bundle bundle) {
        this.f9419g.mo5998d(this);
    }
}
