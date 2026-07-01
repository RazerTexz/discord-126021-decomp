package com.discord.widgets.accessibility;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import b.a.a.WidgetAccessibilityDetectionDialog;
import com.discord.app.AppComponent;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.accessibility.AccessibilityFeatureFlags;
import com.discord.utilities.accessibility.AccessibilityMonitor;
import com.discord.utilities.accessibility.AccessibilityMonitor4;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* JADX INFO: compiled from: AccessibilityDetectionNavigator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AccessibilityDetectionNavigator {
    public static final AccessibilityDetectionNavigator INSTANCE = new AccessibilityDetectionNavigator();

    /* JADX INFO: renamed from: com.discord.widgets.accessibility.AccessibilityDetectionNavigator$enqueueNoticeWhenEnabled$1, reason: invalid class name */
    /* JADX INFO: compiled from: AccessibilityDetectionNavigator.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<AccessibilityMonitor4, Unit> {
        public AnonymousClass1(AccessibilityDetectionNavigator accessibilityDetectionNavigator) {
            super(1, accessibilityDetectionNavigator, AccessibilityDetectionNavigator.class, "showAccessibilityDetectionDialog", "showAccessibilityDetectionDialog(Lcom/discord/utilities/accessibility/AccessibilityState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AccessibilityMonitor4 accessibilityMonitor4) {
            invoke2(accessibilityMonitor4);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AccessibilityMonitor4 accessibilityMonitor4) {
            Intrinsics3.checkNotNullParameter(accessibilityMonitor4, "p1");
            ((AccessibilityDetectionNavigator) this.receiver).showAccessibilityDetectionDialog(accessibilityMonitor4);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.accessibility.AccessibilityDetectionNavigator$showAccessibilityDetectionDialog$1, reason: invalid class name */
    /* JADX INFO: compiled from: AccessibilityDetectionNavigator.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<FragmentActivity, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
            return Boolean.valueOf(invoke2(fragmentActivity));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(FragmentActivity fragmentActivity) {
            Intrinsics3.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            WidgetAccessibilityDetectionDialog.Companion companion = WidgetAccessibilityDetectionDialog.INSTANCE;
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            Objects.requireNonNull(companion);
            Intrinsics3.checkNotNullParameter(supportFragmentManager, "fragmentManager");
            new WidgetAccessibilityDetectionDialog().show(supportFragmentManager, "ALLOW_ACCESSIBILITY_DETECTION_DIALOG");
            return true;
        }
    }

    private AccessibilityDetectionNavigator() {
    }

    private final void showAccessibilityDetectionDialog(AccessibilityMonitor4 accessibilityState) {
        if (accessibilityState.getFeatures().contains(AccessibilityFeatureFlags.SCREENREADER)) {
            StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice("ALLOW_ACCESSIBILITY_DETECTION_DIALOG", null, 0L, 0, true, null, 0L, false, 0L, AnonymousClass1.INSTANCE, 486, null));
        }
    }

    public final void enqueueNoticeWhenEnabled(AppComponent appComponent) {
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(AccessibilityMonitor.INSTANCE.getINSTANCE().observeAccessibilityState(), appComponent, null, 2, null), (Class<?>) AccessibilityDetectionNavigator.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }
}
