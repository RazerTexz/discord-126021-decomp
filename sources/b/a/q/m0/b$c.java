package b.a.q.m0;

import rx.functions.Action1;

/* JADX INFO: compiled from: ScreenCapturer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b$c<T> implements Action1<Long> {
    public final /* synthetic */ b j;

    public b$c(b bVar) {
        this.j = bVar;
    }

    @Override // rx.functions.Action1
    public void call(Long l) {
        this.j.k.run();
    }
}
