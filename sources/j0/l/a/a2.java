package j0.l.a;

import rx.Producer;

/* JADX INFO: compiled from: OperatorSwitch.java */
/* JADX INFO: loaded from: classes3.dex */
public class a2 implements Producer {
    public final /* synthetic */ y1$c j;

    public a2(y1$c y1_c) {
        this.j = y1_c;
    }

    @Override // rx.Producer
    public void j(long j) {
        Producer producer;
        if (j <= 0) {
            if (j < 0) {
                throw new IllegalArgumentException(b.d.b.a.a.t("n >= 0 expected but it was ", j));
            }
            return;
        }
        y1$c y1_c = this.j;
        synchronized (y1_c) {
            producer = y1_c.f3783s;
            y1_c.r = b.i.a.f.e.o.f.f(y1_c.r, j);
        }
        if (producer != null) {
            producer.j(j);
        }
        y1_c.b();
    }
}
