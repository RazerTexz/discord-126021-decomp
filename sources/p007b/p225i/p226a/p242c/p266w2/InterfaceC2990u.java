package p007b.p225i.p226a.p242c.p266w2;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.UnsupportedDrmException;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p266w2.InterfaceC2988s;

/* JADX INFO: renamed from: b.i.a.c.w2.u */
/* JADX INFO: compiled from: DrmSessionManager.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC2990u {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC2990u f8017a = new a();

    /* JADX INFO: renamed from: b.i.a.c.w2.u$a */
    /* JADX INFO: compiled from: DrmSessionManager.java */
    public class a implements InterfaceC2990u {
        @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2990u
        /* JADX INFO: renamed from: a */
        public /* synthetic */ void mo3597a() {
            C2989t.m3595b(this);
        }

        @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2990u
        /* JADX INFO: renamed from: b */
        public /* synthetic */ b mo3598b(Looper looper, InterfaceC2988s.a aVar, C2811j1 c2811j1) {
            return C2989t.m3594a(this, looper, aVar, c2811j1);
        }

        @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2990u
        @Nullable
        /* JADX INFO: renamed from: c */
        public DrmSession mo3599c(Looper looper, @Nullable InterfaceC2988s.a aVar, C2811j1 c2811j1) {
            if (c2811j1.f7158z == null) {
                return null;
            }
            return new C2995z(new DrmSession.DrmSessionException(new UnsupportedDrmException(1), 6001));
        }

        @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2990u
        /* JADX INFO: renamed from: d */
        public int mo3600d(C2811j1 c2811j1) {
            return c2811j1.f7158z != null ? 1 : 0;
        }

        @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2990u
        public /* synthetic */ void release() {
            C2989t.m3596c(this);
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.w2.u$b */
    /* JADX INFO: compiled from: DrmSessionManager.java */
    public interface b {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ int f8018a = 0;

        void release();
    }

    /* JADX INFO: renamed from: a */
    void mo3597a();

    /* JADX INFO: renamed from: b */
    b mo3598b(Looper looper, @Nullable InterfaceC2988s.a aVar, C2811j1 c2811j1);

    @Nullable
    /* JADX INFO: renamed from: c */
    DrmSession mo3599c(Looper looper, @Nullable InterfaceC2988s.a aVar, C2811j1 c2811j1);

    /* JADX INFO: renamed from: d */
    int mo3600d(C2811j1 c2811j1);

    void release();
}
