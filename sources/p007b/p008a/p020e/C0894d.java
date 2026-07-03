package p007b.p008a.p020e;

import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.Subject;

/* JADX INFO: renamed from: b.a.e.d */
/* JADX INFO: compiled from: Backgrounded.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0894d {

    /* JADX INFO: renamed from: a */
    public static boolean f597a = true;

    /* JADX INFO: renamed from: b */
    public static final Subject<Boolean, Boolean> f598b;

    /* JADX INFO: renamed from: c */
    public static Subscription f599c;

    /* JADX INFO: renamed from: d */
    public static final C0894d f600d = new C0894d();

    static {
        BehaviorSubject behaviorSubjectM11130l0 = BehaviorSubject.m11130l0(true);
        C12238m.checkNotNullExpressionValue(behaviorSubjectM11130l0, "BehaviorSubject.create(isBackgrounded)");
        f598b = behaviorSubjectM11130l0;
    }

    /* JADX INFO: renamed from: a */
    public final Observable<Boolean> m185a() {
        Observable<Boolean> observableM11112r = f598b.m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "emitter.distinctUntilChanged()");
        return observableM11112r;
    }
}
