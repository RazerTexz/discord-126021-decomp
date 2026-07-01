package b.a.q.o0;

import d0.z.d.o;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: VideoQuality.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f extends o implements Function2<Long, Long, Long> {
    public static final f j = new f();

    public f() {
        super(2);
    }

    public final long a(long j2, long j3) {
        return j3 > j2 ? j2 : j2 - j3;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Long invoke(Long l, Long l2) {
        return Long.valueOf(a(l.longValue(), l2.longValue()));
    }
}
