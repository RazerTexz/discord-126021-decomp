package p007b.p225i.p226a.p242c.p260g3;

import android.os.Handler;
import androidx.annotation.Nullable;
import java.util.Objects;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p265v2.C2957e;
import p007b.p225i.p226a.p242c.p265v2.C2959g;

/* JADX INFO: renamed from: b.i.a.c.g3.x */
/* JADX INFO: compiled from: VideoRendererEventListener.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC2787x {

    /* JADX INFO: renamed from: b.i.a.c.g3.x$a */
    /* JADX INFO: compiled from: VideoRendererEventListener.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        @Nullable
        public final Handler f6952a;

        /* JADX INFO: renamed from: b */
        @Nullable
        public final InterfaceC2787x f6953b;

        public a(@Nullable Handler handler, @Nullable InterfaceC2787x interfaceC2787x) {
            if (interfaceC2787x != null) {
                Objects.requireNonNull(handler);
            } else {
                handler = null;
            }
            this.f6952a = handler;
            this.f6953b = interfaceC2787x;
        }
    }

    /* JADX INFO: renamed from: F */
    void mo3185F(int i, long j);

    /* JADX INFO: renamed from: K */
    void mo3186K(Object obj, long j);

    @Deprecated
    /* JADX INFO: renamed from: O */
    void mo3187O(C2811j1 c2811j1);

    /* JADX INFO: renamed from: P */
    void mo3188P(C2957e c2957e);

    /* JADX INFO: renamed from: Q */
    void mo3189Q(C2811j1 c2811j1, @Nullable C2959g c2959g);

    /* JADX INFO: renamed from: V */
    void mo3190V(Exception exc);

    /* JADX INFO: renamed from: Z */
    void mo3191Z(C2957e c2957e);

    /* JADX INFO: renamed from: f */
    void mo3192f(C2788y c2788y);

    /* JADX INFO: renamed from: h0 */
    void mo3193h0(long j, int i);

    /* JADX INFO: renamed from: l */
    void mo3194l(String str);

    /* JADX INFO: renamed from: n */
    void mo3195n(String str, long j, long j2);
}
