package j0.l.a;

import java.util.Objects;
import rx.Producer;

/* JADX INFO: compiled from: OnSubscribeConcatMap.java */
/* JADX INFO: loaded from: classes3.dex */
public class g implements Producer {
    public final /* synthetic */ h$c j;

    public g(h hVar, h$c h_c) {
        this.j = h_c;
    }

    @Override // rx.Producer
    public void j(long j) {
        h$c h_c = this.j;
        Objects.requireNonNull(h_c);
        if (j > 0) {
            h_c.m.j(j);
        } else if (j < 0) {
            throw new IllegalArgumentException(b.d.b.a.a.t("n >= 0 required but it was ", j));
        }
    }
}
