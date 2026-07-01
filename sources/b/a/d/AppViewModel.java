package b.a.d;

import androidx.annotation.MainThread;
import androidx.view.ViewModel;
import com.discord.app.AppComponent;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/* JADX INFO: renamed from: b.a.d.d0, reason: use source file name */
/* JADX INFO: compiled from: AppViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class AppViewModel<V> extends ViewModel implements AppComponent {
    private final Subject<Void, Void> unsubscribeSignal;
    private final BehaviorSubject<V> viewStateSubject;

    /* JADX WARN: Illegal instructions before constructor call */
    public AppViewModel() {
        DefaultConstructorMarker defaultConstructorMarker = null;
        this(defaultConstructorMarker, 1, defaultConstructorMarker);
    }

    public AppViewModel(V v) {
        BehaviorSubject<V> behaviorSubjectK0 = BehaviorSubject.k0();
        this.viewStateSubject = behaviorSubjectK0;
        PublishSubject publishSubjectK0 = PublishSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.unsubscribeSignal = publishSubjectK0;
        if (v != null) {
            behaviorSubjectK0.onNext(v);
        }
    }

    @Override // com.discord.app.AppComponent
    public Subject<Void, Void> getUnsubscribeSignal() {
        return this.unsubscribeSignal;
    }

    public final V getViewState() {
        BehaviorSubject<V> behaviorSubject = this.viewStateSubject;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "viewStateSubject");
        return behaviorSubject.n0();
    }

    public V modifyPendingViewState(V v, V v2) {
        return v2;
    }

    public final Observable<V> observeViewState() {
        BehaviorSubject<V> behaviorSubject = this.viewStateSubject;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "viewStateSubject");
        return behaviorSubject;
    }

    @Override // androidx.view.ViewModel
    public void onCleared() {
        super.onCleared();
        getUnsubscribeSignal().onNext(null);
    }

    public final V requireViewState() {
        V viewState = getViewState();
        Intrinsics3.checkNotNull(viewState);
        return viewState;
    }

    @MainThread
    public void updateViewState(V v) {
        this.viewStateSubject.onNext(modifyPendingViewState(getViewState(), v));
    }

    public final <T> T withViewState(Function1<? super V, ? extends T> function1) {
        Intrinsics3.checkNotNullParameter(function1, "block");
        return function1.invoke(requireViewState());
    }

    public /* synthetic */ AppViewModel(Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : obj);
    }
}
