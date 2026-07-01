package com.discord.utilities.views;

import d0.z.d.Intrinsics3;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: ViewVisibilityObserver.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewVisibilityObserver {
    private final BehaviorSubject<Boolean> isVisibleSubject = BehaviorSubject.k0();

    public final Observable<Boolean> observeIsVisible() {
        Observable<Boolean> observableR = this.isVisibleSubject.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "isVisibleSubject.distinctUntilChanged()");
        return observableR;
    }

    public final void updateVisibility(boolean isVisible) {
        this.isVisibleSubject.onNext(Boolean.valueOf(isVisible));
    }
}
