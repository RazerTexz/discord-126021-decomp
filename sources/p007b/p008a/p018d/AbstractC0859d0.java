package p007b.p008a.p018d;

import androidx.annotation.MainThread;
import androidx.view.ViewModel;
import com.discord.app.AppComponent;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.PublishSubject;
import p658rx.subjects.Subject;

/* JADX INFO: renamed from: b.a.d.d0 */
/* JADX INFO: compiled from: AppViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0859d0<V> extends ViewModel implements AppComponent {
    private final Subject<Void, Void> unsubscribeSignal;
    private final BehaviorSubject<V> viewStateSubject;

    /* JADX WARN: Illegal instructions before constructor call */
    public AbstractC0859d0() {
        DefaultConstructorMarker defaultConstructorMarker = null;
        this(defaultConstructorMarker, 1, defaultConstructorMarker);
    }

    public AbstractC0859d0(V v) {
        BehaviorSubject<V> behaviorSubjectM11129k0 = BehaviorSubject.m11129k0();
        this.viewStateSubject = behaviorSubjectM11129k0;
        PublishSubject publishSubjectM11133k0 = PublishSubject.m11133k0();
        C12238m.checkNotNullExpressionValue(publishSubjectM11133k0, "PublishSubject.create()");
        this.unsubscribeSignal = publishSubjectM11133k0;
        if (v != null) {
            behaviorSubjectM11129k0.onNext(v);
        }
    }

    @Override // com.discord.app.AppComponent
    public Subject<Void, Void> getUnsubscribeSignal() {
        return this.unsubscribeSignal;
    }

    public final V getViewState() {
        BehaviorSubject<V> behaviorSubject = this.viewStateSubject;
        C12238m.checkNotNullExpressionValue(behaviorSubject, "viewStateSubject");
        return behaviorSubject.m11132n0();
    }

    public V modifyPendingViewState(V v, V v2) {
        return v2;
    }

    public final Observable<V> observeViewState() {
        BehaviorSubject<V> behaviorSubject = this.viewStateSubject;
        C12238m.checkNotNullExpressionValue(behaviorSubject, "viewStateSubject");
        return behaviorSubject;
    }

    @Override // androidx.view.ViewModel
    public void onCleared() {
        super.onCleared();
        getUnsubscribeSignal().onNext(null);
    }

    public final V requireViewState() {
        V viewState = getViewState();
        C12238m.checkNotNull(viewState);
        return viewState;
    }

    @MainThread
    public void updateViewState(V v) {
        this.viewStateSubject.onNext(modifyPendingViewState(getViewState(), v));
    }

    public final <T> T withViewState(Function1<? super V, ? extends T> function1) {
        C12238m.checkNotNullParameter(function1, "block");
        return function1.invoke(requireViewState());
    }

    public /* synthetic */ AbstractC0859d0(Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : obj);
    }
}
