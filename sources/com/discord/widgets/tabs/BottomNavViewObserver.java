package com.discord.widgets.tabs;

import d0.g;
import d0.z.d.m;
import kotlin.Lazy;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: BottomNavViewObserver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BottomNavViewObserver implements TabsHostBottomNavigationView$HeightChangedListener {
    public static final BottomNavViewObserver$Companion Companion = new BottomNavViewObserver$Companion(null);
    private static final Lazy INSTANCE$delegate = g.lazy(BottomNavViewObserver$Companion$INSTANCE$2.INSTANCE);
    private final BehaviorSubject<Integer> heightSubject = BehaviorSubject.l0(0);

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public final Observable<Integer> observeHeight() {
        BehaviorSubject<Integer> behaviorSubject = this.heightSubject;
        m.checkNotNullExpressionValue(behaviorSubject, "heightSubject");
        return behaviorSubject;
    }

    @Override // com.discord.widgets.tabs.TabsHostBottomNavigationView$HeightChangedListener
    public void onHeightChanged(int height) {
        this.heightSubject.onNext(Integer.valueOf(height));
    }
}
