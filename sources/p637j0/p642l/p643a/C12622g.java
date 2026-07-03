package p637j0.p642l.p643a;

import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p637j0.p642l.p643a.C12626h;
import p658rx.Producer;

/* JADX INFO: renamed from: j0.l.a.g */
/* JADX INFO: compiled from: OnSubscribeConcatMap.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12622g implements Producer {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C12626h.c f26790j;

    public C12622g(C12626h c12626h, C12626h.c cVar) {
        this.f26790j = cVar;
    }

    @Override // p658rx.Producer
    /* JADX INFO: renamed from: j */
    public void mo10704j(long j) {
        C12626h.c cVar = this.f26790j;
        Objects.requireNonNull(cVar);
        if (j > 0) {
            cVar.f26822m.mo10704j(j);
        } else if (j < 0) {
            throw new IllegalArgumentException(C1643a.m877t("n >= 0 required but it was ", j));
        }
    }
}
