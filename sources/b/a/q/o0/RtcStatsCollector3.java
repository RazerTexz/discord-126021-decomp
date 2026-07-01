package b.a.q.o0;

import com.discord.utilities.logging.Logger;
import rx.functions.Action1;

/* JADX INFO: renamed from: b.a.q.o0.c, reason: use source file name */
/* JADX INFO: compiled from: RtcStatsCollector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RtcStatsCollector3<T> implements Action1<Throwable> {
    public final /* synthetic */ RtcStatsCollector4 j;

    public RtcStatsCollector3(RtcStatsCollector4 rtcStatsCollector4) {
        this.j = rtcStatsCollector4;
    }

    @Override // rx.functions.Action1
    public void call(Throwable th) {
        Logger.e$default(this.j.d, "RtcStatsCollector: Error collecting stats", th, null, 4, null);
    }
}
