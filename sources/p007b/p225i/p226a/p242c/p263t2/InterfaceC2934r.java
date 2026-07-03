package p007b.p225i.p226a.p242c.p263t2;

import android.os.Handler;
import androidx.annotation.Nullable;
import java.util.Objects;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p263t2.InterfaceC2934r;
import p007b.p225i.p226a.p242c.p265v2.C2957e;
import p007b.p225i.p226a.p242c.p265v2.C2959g;

/* JADX INFO: renamed from: b.i.a.c.t2.r */
/* JADX INFO: compiled from: AudioRendererEventListener.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC2934r {

    /* JADX INFO: renamed from: b.i.a.c.t2.r$a */
    /* JADX INFO: compiled from: AudioRendererEventListener.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        @Nullable
        public final Handler f7790a;

        /* JADX INFO: renamed from: b */
        @Nullable
        public final InterfaceC2934r f7791b;

        public a(@Nullable Handler handler, @Nullable InterfaceC2934r interfaceC2934r) {
            if (interfaceC2934r != null) {
                Objects.requireNonNull(handler);
            } else {
                handler = null;
            }
            this.f7790a = handler;
            this.f7791b = interfaceC2934r;
        }

        /* JADX INFO: renamed from: a */
        public void m3498a(final C2957e c2957e) {
            synchronized (c2957e) {
            }
            Handler handler = this.f7790a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: b.i.a.c.t2.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        InterfaceC2934r.a aVar = this.f7684j;
                        C2957e c2957e2 = c2957e;
                        Objects.requireNonNull(aVar);
                        synchronized (c2957e2) {
                        }
                        InterfaceC2934r interfaceC2934r = aVar.f7791b;
                        int i = C2738e0.f6708a;
                        interfaceC2934r.mo3301k(c2957e2);
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: B */
    void mo3291B(String str);

    /* JADX INFO: renamed from: C */
    void mo3292C(String str, long j, long j2);

    /* JADX INFO: renamed from: I */
    void mo3293I(C2811j1 c2811j1, @Nullable C2959g c2959g);

    /* JADX INFO: renamed from: N */
    void mo3294N(Exception exc);

    /* JADX INFO: renamed from: R */
    void mo3295R(long j);

    /* JADX INFO: renamed from: T */
    void mo3296T(Exception exc);

    @Deprecated
    /* JADX INFO: renamed from: U */
    void mo3297U(C2811j1 c2811j1);

    /* JADX INFO: renamed from: d */
    void mo3299d(boolean z2);

    /* JADX INFO: renamed from: e0 */
    void mo3300e0(int i, long j, long j2);

    /* JADX INFO: renamed from: k */
    void mo3301k(C2957e c2957e);

    /* JADX INFO: renamed from: m */
    void mo3302m(C2957e c2957e);
}
