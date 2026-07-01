package j0.l.a;

import rx.Observable;

/* JADX INFO: renamed from: j0.l.a.d, reason: use source file name */
/* JADX INFO: compiled from: NeverObservableHolder.java */
/* JADX INFO: loaded from: classes3.dex */
public enum NeverObservableHolder implements Observable.a<Object> {
    INSTANCE;

    public static final Observable<Object> k = Observable.h0(INSTANCE);

    @Override // rx.functions.Action1
    public void call(Object obj) {
    }
}
