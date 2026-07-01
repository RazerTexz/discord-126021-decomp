package j0.l.a;

import b.d.b.a.outline;
import j0.l.a.OnSubscribeFlattenIterable2;
import java.util.Objects;
import rx.Producer;

/* JADX INFO: renamed from: j0.l.a.m, reason: use source file name */
/* JADX INFO: compiled from: OnSubscribeFlattenIterable.java */
/* JADX INFO: loaded from: classes3.dex */
public class OnSubscribeFlattenIterable implements Producer {
    public final /* synthetic */ OnSubscribeFlattenIterable2.a j;

    public OnSubscribeFlattenIterable(OnSubscribeFlattenIterable2 onSubscribeFlattenIterable2, OnSubscribeFlattenIterable2.a aVar) {
        this.j = aVar;
    }

    @Override // rx.Producer
    public void j(long j) {
        OnSubscribeFlattenIterable2.a aVar = this.j;
        Objects.requireNonNull(aVar);
        if (j > 0) {
            b.i.a.f.e.o.f.c0(aVar.o, j);
            aVar.b();
        } else if (j < 0) {
            throw new IllegalStateException(outline.t("n >= 0 required but it was ", j));
        }
    }
}
