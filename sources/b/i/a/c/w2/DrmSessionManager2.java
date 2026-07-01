package b.i.a.c.w2;

import android.os.Looper;
import androidx.annotation.Nullable;
import b.i.a.c.Format2;
import b.i.a.c.w2.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.UnsupportedDrmException;

/* JADX INFO: renamed from: b.i.a.c.w2.u, reason: use source file name */
/* JADX INFO: compiled from: DrmSessionManager.java */
/* JADX INFO: loaded from: classes3.dex */
public interface DrmSessionManager2 {
    public static final DrmSessionManager2 a = new a();

    /* JADX INFO: renamed from: b.i.a.c.w2.u$a */
    /* JADX INFO: compiled from: DrmSessionManager.java */
    public class a implements DrmSessionManager2 {
        @Override // b.i.a.c.w2.DrmSessionManager2
        public /* synthetic */ void a() {
            DrmSessionManager.b(this);
        }

        @Override // b.i.a.c.w2.DrmSessionManager2
        public /* synthetic */ b b(Looper looper, DrmSessionEventListener.a aVar, Format2 format2) {
            return DrmSessionManager.a(this, looper, aVar, format2);
        }

        @Override // b.i.a.c.w2.DrmSessionManager2
        @Nullable
        public DrmSession c(Looper looper, @Nullable DrmSessionEventListener.a aVar, Format2 format2) {
            if (format2.f1020z == null) {
                return null;
            }
            return new ErrorStateDrmSession(new DrmSession.DrmSessionException(new UnsupportedDrmException(1), 6001));
        }

        @Override // b.i.a.c.w2.DrmSessionManager2
        public int d(Format2 format2) {
            return format2.f1020z != null ? 1 : 0;
        }

        @Override // b.i.a.c.w2.DrmSessionManager2
        public /* synthetic */ void release() {
            DrmSessionManager.c(this);
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.w2.u$b */
    /* JADX INFO: compiled from: DrmSessionManager.java */
    public interface b {
        public static final /* synthetic */ int a = 0;

        void release();
    }

    void a();

    b b(Looper looper, @Nullable DrmSessionEventListener.a aVar, Format2 format2);

    @Nullable
    DrmSession c(Looper looper, @Nullable DrmSessionEventListener.a aVar, Format2 format2);

    int d(Format2 format2);

    void release();
}
