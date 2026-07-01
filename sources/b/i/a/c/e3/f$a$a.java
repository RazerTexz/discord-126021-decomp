package b.i.a.c.e3;

import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: BandwidthMeter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f$a$a {
    public final CopyOnWriteArrayList<f$a$a$a> a = new CopyOnWriteArrayList<>();

    public void a(f$a f_a) {
        for (f$a$a$a f_a_a_a : this.a) {
            if (f_a_a_a.f940b == f_a) {
                f_a_a_a.c = true;
                this.a.remove(f_a_a_a);
            }
        }
    }
}
