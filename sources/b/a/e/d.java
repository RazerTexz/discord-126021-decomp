package b.a.e;

import d0.z.d.m;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;
import rx.subjects.Subject;

/* JADX INFO: compiled from: Backgrounded.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static boolean a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Subject<Boolean, Boolean> f65b;
    public static Subscription c;
    public static final d d = new d();

    static {
        BehaviorSubject behaviorSubjectL0 = BehaviorSubject.l0(true);
        m.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(isBackgrounded)");
        f65b = behaviorSubjectL0;
    }

    public final Observable<Boolean> a() {
        Observable<Boolean> observableR = f65b.r();
        m.checkNotNullExpressionValue(observableR, "emitter.distinctUntilChanged()");
        return observableR;
    }
}
