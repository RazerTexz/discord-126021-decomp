package b.i.a.c.e3;

import android.os.Handler;
import androidx.annotation.Nullable;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: renamed from: b.i.a.c.e3.f, reason: use source file name */
/* JADX INFO: compiled from: BandwidthMeter.java */
/* JADX INFO: loaded from: classes3.dex */
public interface BandwidthMeter {

    /* JADX INFO: renamed from: b.i.a.c.e3.f$a */
    /* JADX INFO: compiled from: BandwidthMeter.java */
    public interface a {

        /* JADX INFO: renamed from: b.i.a.c.e3.f$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: BandwidthMeter.java */
        public static final class C0029a {
            public final CopyOnWriteArrayList<C0030a> a = new CopyOnWriteArrayList<>();

            /* JADX INFO: renamed from: b.i.a.c.e3.f$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: BandwidthMeter.java */
            public static final class C0030a {
                public final Handler a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final a f940b;
                public boolean c;

                public C0030a(Handler handler, a aVar) {
                    this.a = handler;
                    this.f940b = aVar;
                }
            }

            public void a(a aVar) {
                for (C0030a c0030a : this.a) {
                    if (c0030a.f940b == aVar) {
                        c0030a.c = true;
                        this.a.remove(c0030a);
                    }
                }
            }
        }
    }

    @Nullable
    TransferListener c();

    void d(a aVar);

    void f(Handler handler, a aVar);
}
