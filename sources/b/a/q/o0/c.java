package b.a.q.o0;

import com.discord.utilities.logging.Logger;
import rx.functions.Action1;

/* JADX INFO: compiled from: RtcStatsCollector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c<T> implements Action1<Throwable> {
    public final /* synthetic */ d j;

    public c(d dVar) {
        this.j = dVar;
    }

    @Override // rx.functions.Action1
    public void call(Throwable th) {
        Logger.e$default(this.j.d, "RtcStatsCollector: Error collecting stats", th, null, 4, null);
    }
}
