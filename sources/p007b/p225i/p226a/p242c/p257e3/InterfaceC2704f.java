package p007b.p225i.p226a.p242c.p257e3;

import android.os.Handler;
import androidx.annotation.Nullable;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: renamed from: b.i.a.c.e3.f */
/* JADX INFO: compiled from: BandwidthMeter.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC2704f {

    /* JADX INFO: renamed from: b.i.a.c.e3.f$a */
    /* JADX INFO: compiled from: BandwidthMeter.java */
    public interface a {

        /* JADX INFO: renamed from: b.i.a.c.e3.f$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: BandwidthMeter.java */
        public static final class C13224a {

            /* JADX INFO: renamed from: a */
            public final CopyOnWriteArrayList<C13225a> f6524a = new CopyOnWriteArrayList<>();

            /* JADX INFO: renamed from: b.i.a.c.e3.f$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: BandwidthMeter.java */
            public static final class C13225a {

                /* JADX INFO: renamed from: a */
                public final Handler f6525a;

                /* JADX INFO: renamed from: b */
                public final a f6526b;

                /* JADX INFO: renamed from: c */
                public boolean f6527c;

                public C13225a(Handler handler, a aVar) {
                    this.f6525a = handler;
                    this.f6526b = aVar;
                }
            }

            /* JADX INFO: renamed from: a */
            public void m2847a(a aVar) {
                for (C13225a c13225a : this.f6524a) {
                    if (c13225a.f6526b == aVar) {
                        c13225a.f6527c = true;
                        this.f6524a.remove(c13225a);
                    }
                }
            }
        }
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    InterfaceC2680a0 mo2844c();

    /* JADX INFO: renamed from: d */
    void mo2845d(a aVar);

    /* JADX INFO: renamed from: f */
    void mo2846f(Handler handler, a aVar);
}
