package j0.l.a;

import java.util.Objects;
import rx.Producer;

/* JADX INFO: compiled from: OnSubscribeFlattenIterable.java */
/* JADX INFO: loaded from: classes3.dex */
public class m implements Producer {
    public final /* synthetic */ n$a j;

    public m(n nVar, n$a n_a) {
        this.j = n_a;
    }

    @Override // rx.Producer
    public void j(long j) {
        n$a n_a = this.j;
        Objects.requireNonNull(n_a);
        if (j > 0) {
            b.i.a.f.e.o.f.c0(n_a.o, j);
            n_a.b();
        } else if (j < 0) {
            throw new IllegalStateException(b.d.b.a.a.t("n >= 0 required but it was ", j));
        }
    }
}
