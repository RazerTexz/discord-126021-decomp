package p007b.p225i.p226a.p288f.p299e.p300h.p301j;

import android.os.Looper;
import androidx.annotation.NonNull;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a;
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a.d;
import p007b.p225i.p226a.p288f.p299e.p300h.C3267b;
import p007b.p225i.p226a.p288f.p299e.p300h.InterfaceC3273h;

/* JADX INFO: renamed from: b.i.a.f.e.h.j.y */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3329y<O extends C3266a.d> extends C3315r {

    /* JADX INFO: renamed from: b */
    @NotOnlyInitialized
    public final C3267b<O> f9466b;

    public C3329y(C3267b<O> c3267b) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.f9466b = c3267b;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.AbstractC3268c
    /* JADX INFO: renamed from: a */
    public final <A extends C3266a.b, R extends InterfaceC3273h, T extends AbstractC3284d<R, A>> T mo4048a(@NonNull T t) {
        this.f9466b.m4047d(0, t);
        return t;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.AbstractC3268c
    /* JADX INFO: renamed from: b */
    public final <A extends C3266a.b, T extends AbstractC3284d<? extends InterfaceC3273h, A>> T mo4049b(@NonNull T t) {
        this.f9466b.m4047d(1, t);
        return t;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.AbstractC3268c
    /* JADX INFO: renamed from: c */
    public final Looper mo4050c() {
        return this.f9466b.f9330e;
    }
}
