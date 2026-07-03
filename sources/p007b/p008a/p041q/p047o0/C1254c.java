package p007b.p008a.p041q.p047o0;

import com.discord.utilities.logging.Logger;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: b.a.q.o0.c */
/* JADX INFO: compiled from: RtcStatsCollector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1254c<T> implements Action1<Throwable> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C1255d f1806j;

    public C1254c(C1255d c1255d) {
        this.f1806j = c1255d;
    }

    @Override // p658rx.functions.Action1
    public void call(Throwable th) {
        Logger.e$default(this.f1806j.f1810d, "RtcStatsCollector: Error collecting stats", th, null, 4, null);
    }
}
