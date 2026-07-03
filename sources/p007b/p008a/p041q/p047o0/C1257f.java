package p007b.p008a.p041q.p047o0;

import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: b.a.q.o0.f */
/* JADX INFO: compiled from: VideoQuality.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1257f extends AbstractC12240o implements Function2<Long, Long, Long> {

    /* JADX INFO: renamed from: j */
    public static final C1257f f1867j = new C1257f();

    public C1257f() {
        super(2);
    }

    /* JADX INFO: renamed from: a */
    public final long m363a(long j, long j2) {
        return j2 > j ? j : j - j2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Long invoke(Long l, Long l2) {
        return Long.valueOf(m363a(l.longValue(), l2.longValue()));
    }
}
