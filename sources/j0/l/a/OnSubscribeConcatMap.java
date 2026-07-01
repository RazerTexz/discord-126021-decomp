package j0.l.a;

import b.d.b.a.outline;
import j0.l.a.OnSubscribeConcatMap2;
import java.util.Objects;
import rx.Producer;

/* JADX INFO: renamed from: j0.l.a.g, reason: use source file name */
/* JADX INFO: compiled from: OnSubscribeConcatMap.java */
/* JADX INFO: loaded from: classes3.dex */
public class OnSubscribeConcatMap implements Producer {
    public final /* synthetic */ OnSubscribeConcatMap2.c j;

    public OnSubscribeConcatMap(OnSubscribeConcatMap2 onSubscribeConcatMap2, OnSubscribeConcatMap2.c cVar) {
        this.j = cVar;
    }

    @Override // rx.Producer
    public void j(long j) {
        OnSubscribeConcatMap2.c cVar = this.j;
        Objects.requireNonNull(cVar);
        if (j > 0) {
            cVar.m.j(j);
        } else if (j < 0) {
            throw new IllegalArgumentException(outline.t("n >= 0 required but it was ", j));
        }
    }
}
