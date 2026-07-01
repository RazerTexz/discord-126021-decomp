package com.discord.widgets.tabs;

import com.discord.widgets.tabs.TabsHostBottomNavigationView;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: BottomNavViewObserver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BottomNavViewObserver implements TabsHostBottomNavigationView.HeightChangedListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = LazyJVM.lazy(BottomNavViewObserver2.INSTANCE);
    private final BehaviorSubject<Integer> heightSubject = BehaviorSubject.l0(0);

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
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "heightSubject");
        return behaviorSubject;
    }

    @Override // com.discord.widgets.tabs.TabsHostBottomNavigationView.HeightChangedListener
    public void onHeightChanged(int height) {
        this.heightSubject.onNext(Integer.valueOf(height));
    }
}
