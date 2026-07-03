package p637j0.p642l.p643a;

import p658rx.Observable;
import p658rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.c */
/* JADX INFO: compiled from: EmptyObservableHolder.java */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC12606c implements Observable.InterfaceC13005a<Object> {
    INSTANCE;


    /* JADX INFO: renamed from: k */
    public static final Observable<Object> f26751k = Observable.m11074h0(INSTANCE);

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        ((Subscriber) obj).onCompleted();
    }
}
