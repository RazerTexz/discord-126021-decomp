package com.discord.widgets.status;

import androidx.annotation.MainThread;
import d0.z.d.m;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetGlobalStatusIndicatorState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGlobalStatusIndicatorState {
    public static final WidgetGlobalStatusIndicatorState$Provider Provider = new WidgetGlobalStatusIndicatorState$Provider(null);
    private static final WidgetGlobalStatusIndicatorState callIndicatorState = new WidgetGlobalStatusIndicatorState();
    private final BehaviorSubject<WidgetGlobalStatusIndicatorState$State> stateSubject = BehaviorSubject.k0();

    public static final /* synthetic */ WidgetGlobalStatusIndicatorState access$getCallIndicatorState$cp() {
        return callIndicatorState;
    }

    public static /* synthetic */ void updateState$default(WidgetGlobalStatusIndicatorState widgetGlobalStatusIndicatorState, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            BehaviorSubject<WidgetGlobalStatusIndicatorState$State> behaviorSubject = widgetGlobalStatusIndicatorState.stateSubject;
            m.checkNotNullExpressionValue(behaviorSubject, "stateSubject");
            WidgetGlobalStatusIndicatorState$State widgetGlobalStatusIndicatorState$StateN0 = behaviorSubject.n0();
            z2 = widgetGlobalStatusIndicatorState$StateN0 != null ? widgetGlobalStatusIndicatorState$StateN0.isVisible() : false;
        }
        if ((i & 2) != 0) {
            BehaviorSubject<WidgetGlobalStatusIndicatorState$State> behaviorSubject2 = widgetGlobalStatusIndicatorState.stateSubject;
            m.checkNotNullExpressionValue(behaviorSubject2, "stateSubject");
            WidgetGlobalStatusIndicatorState$State widgetGlobalStatusIndicatorState$StateN1 = behaviorSubject2.n0();
            z3 = widgetGlobalStatusIndicatorState$StateN1 != null ? widgetGlobalStatusIndicatorState$StateN1.isCustomBackground() : false;
        }
        if ((i & 4) != 0) {
            BehaviorSubject<WidgetGlobalStatusIndicatorState$State> behaviorSubject3 = widgetGlobalStatusIndicatorState.stateSubject;
            m.checkNotNullExpressionValue(behaviorSubject3, "stateSubject");
            WidgetGlobalStatusIndicatorState$State widgetGlobalStatusIndicatorState$StateN2 = behaviorSubject3.n0();
            z4 = widgetGlobalStatusIndicatorState$StateN2 != null ? widgetGlobalStatusIndicatorState$StateN2.isViewingCall() : false;
        }
        widgetGlobalStatusIndicatorState.updateState(z2, z3, z4);
    }

    public final Observable<WidgetGlobalStatusIndicatorState$State> observeState() {
        Observable<WidgetGlobalStatusIndicatorState$State> observableR = this.stateSubject.r();
        m.checkNotNullExpressionValue(observableR, "stateSubject.distinctUntilChanged()");
        return observableR;
    }

    @MainThread
    public final void updateState(boolean isVisible, boolean isPrimaryBackground, boolean isViewingCall) {
        this.stateSubject.onNext(new WidgetGlobalStatusIndicatorState$State(isVisible, isPrimaryBackground, isViewingCall));
    }
}
