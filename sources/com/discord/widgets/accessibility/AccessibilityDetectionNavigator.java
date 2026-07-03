package com.discord.widgets.accessibility;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.app.AppComponent;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.accessibility.AccessibilityFeatureFlags;
import com.discord.utilities.accessibility.AccessibilityMonitor;
import com.discord.utilities.accessibility.AccessibilityState;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p009a.C0831h;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: AccessibilityDetectionNavigator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AccessibilityDetectionNavigator {
    public static final AccessibilityDetectionNavigator INSTANCE = new AccessibilityDetectionNavigator();

    /* JADX INFO: renamed from: com.discord.widgets.accessibility.AccessibilityDetectionNavigator$enqueueNoticeWhenEnabled$1 */
    /* JADX INFO: compiled from: AccessibilityDetectionNavigator.kt */
    public static final /* synthetic */ class C71361 extends C12236k implements Function1<AccessibilityState, Unit> {
        public C71361(AccessibilityDetectionNavigator accessibilityDetectionNavigator) {
            super(1, accessibilityDetectionNavigator, AccessibilityDetectionNavigator.class, "showAccessibilityDetectionDialog", "showAccessibilityDetectionDialog(Lcom/discord/utilities/accessibility/AccessibilityState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AccessibilityState accessibilityState) {
            invoke2(accessibilityState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AccessibilityState accessibilityState) {
            C12238m.checkNotNullParameter(accessibilityState, "p1");
            ((AccessibilityDetectionNavigator) this.receiver).showAccessibilityDetectionDialog(accessibilityState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.accessibility.AccessibilityDetectionNavigator$showAccessibilityDetectionDialog$1 */
    /* JADX INFO: compiled from: AccessibilityDetectionNavigator.kt */
    public static final class C71371 extends AbstractC12240o implements Function1<FragmentActivity, Boolean> {
        public static final C71371 INSTANCE = new C71371();

        public C71371() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
            return Boolean.valueOf(invoke2(fragmentActivity));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(FragmentActivity fragmentActivity) {
            C12238m.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            C0831h.Companion companion = C0831h.INSTANCE;
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            C12238m.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            Objects.requireNonNull(companion);
            C12238m.checkNotNullParameter(supportFragmentManager, "fragmentManager");
            new C0831h().show(supportFragmentManager, "ALLOW_ACCESSIBILITY_DETECTION_DIALOG");
            return true;
        }
    }

    private AccessibilityDetectionNavigator() {
    }

    private final void showAccessibilityDetectionDialog(AccessibilityState accessibilityState) {
        if (accessibilityState.getFeatures().contains(AccessibilityFeatureFlags.SCREENREADER)) {
            StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice("ALLOW_ACCESSIBILITY_DETECTION_DIALOG", null, 0L, 0, true, null, 0L, false, 0L, C71371.INSTANCE, 486, null));
        }
    }

    public final void enqueueNoticeWhenEnabled(AppComponent appComponent) {
        C12238m.checkNotNullParameter(appComponent, "appComponent");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(AccessibilityMonitor.INSTANCE.getINSTANCE().observeAccessibilityState(), appComponent, null, 2, null), (Class<?>) AccessibilityDetectionNavigator.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C71361(this));
    }
}
