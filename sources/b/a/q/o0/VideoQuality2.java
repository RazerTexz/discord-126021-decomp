package b.a.q.o0;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: b.a.q.o0.f, reason: use source file name */
/* JADX INFO: compiled from: VideoQuality.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VideoQuality2 extends Lambda implements Function2<Long, Long, Long> {
    public static final VideoQuality2 j = new VideoQuality2();

    public VideoQuality2() {
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
