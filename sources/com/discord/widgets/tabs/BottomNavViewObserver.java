package com.discord.widgets.tabs;

import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.C12083g;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: BottomNavViewObserver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BottomNavViewObserver implements TabsHostBottomNavigationView.HeightChangedListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = C12083g.lazy(BottomNavViewObserver$Companion$INSTANCE$2.INSTANCE);
    private final BehaviorSubject<Integer> heightSubject = BehaviorSubject.m11130l0(0);

    /* JADX INFO: compiled from: BottomNavViewObserver.kt */
    public static final class Companion {
        private Companion() {
        }

        public final BottomNavViewObserver getINSTANCE() {
            Lazy lazy = BottomNavViewObserver.INSTANCE$delegate;
            Companion companion = BottomNavViewObserver.INSTANCE;
            return (BottomNavViewObserver) lazy.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final Observable<Integer> observeHeight() {
        BehaviorSubject<Integer> behaviorSubject = this.heightSubject;
        C12238m.checkNotNullExpressionValue(behaviorSubject, "heightSubject");
        return behaviorSubject;
    }

    @Override // com.discord.widgets.tabs.TabsHostBottomNavigationView.HeightChangedListener
    public void onHeightChanged(int height) {
        this.heightSubject.onNext(Integer.valueOf(height));
    }
}
