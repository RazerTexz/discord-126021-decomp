package b.a.q.o0;

import rx.functions.Action1;

/* JADX INFO: compiled from: RtcStatsCollector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b<T> implements Action1<Long> {
    public final /* synthetic */ d j;

    public b(d dVar) {
        this.j = dVar;
    }

    @Override // rx.functions.Action1
    public void call(Long l) {
        this.j.e.n(new a(this.j));
    }
}
