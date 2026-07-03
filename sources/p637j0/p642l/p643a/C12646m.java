package p637j0.p642l.p643a;

import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p642l.p643a.C12650n;
import p658rx.Producer;

/* JADX INFO: renamed from: j0.l.a.m */
/* JADX INFO: compiled from: OnSubscribeFlattenIterable.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12646m implements Producer {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C12650n.a f26909j;

    public C12646m(C12650n c12650n, C12650n.a aVar) {
        this.f26909j = aVar;
    }

    @Override // p658rx.Producer
    /* JADX INFO: renamed from: j */
    public void mo10704j(long j) {
        C12650n.a aVar = this.f26909j;
        Objects.requireNonNull(aVar);
        if (j > 0) {
            C3404f.m4276c0(aVar.f26924o, j);
            aVar.m10773b();
        } else if (j < 0) {
            throw new IllegalStateException(C1643a.m877t("n >= 0 required but it was ", j));
        }
    }
}
