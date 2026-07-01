package b.i.a.c.a3;

import android.os.Handler;
import androidx.annotation.Nullable;
import b.i.a.c.MediaItem2;
import b.i.a.c.Timeline;
import b.i.a.c.e3.DefaultAllocator;
import b.i.a.c.e3.TransferListener;
import b.i.a.c.w2.DrmSessionEventListener;
import java.io.IOException;

/* JADX INFO: renamed from: b.i.a.c.a3.a0, reason: use source file name */
/* JADX INFO: compiled from: MediaSource.java */
/* JADX INFO: loaded from: classes3.dex */
public interface MediaSource2 {

    /* JADX INFO: renamed from: b.i.a.c.a3.a0$a */
    /* JADX INFO: compiled from: MediaSource.java */
    public static final class a extends MediaPeriodId {
        public a(Object obj) {
            super(obj);
        }

        public a b(Object obj) {
            return new a(this.a.equals(obj) ? this : new MediaPeriodId(obj, this.f835b, this.c, this.d, this.e));
        }

        public a(Object obj, long j, int i) {
            super(obj, j, i);
        }

        public a(Object obj, int i, int i2, long j) {
            super(obj, i, i2, j);
        }

        public a(MediaPeriodId mediaPeriodId) {
            super(mediaPeriodId);
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.a3.a0$b */
    /* JADX INFO: compiled from: MediaSource.java */
    public interface b {
        void a(MediaSource2 mediaSource2, Timeline timeline);
    }

    void a(b bVar);

    void b(Handler handler, MediaSourceEventListener mediaSourceEventListener);

    void c(MediaSourceEventListener mediaSourceEventListener);

    void d(b bVar);

    MediaItem2 e();

    void f(Handler handler, DrmSessionEventListener drmSessionEventListener);

    void g(DrmSessionEventListener drmSessionEventListener);

    void h() throws IOException;

    boolean i();

    void j(MediaPeriod mediaPeriod);

    @Nullable
    Timeline k();

    void l(b bVar, @Nullable TransferListener transferListener);

    void m(b bVar);

    MediaPeriod n(a aVar, DefaultAllocator defaultAllocator, long j);
}
