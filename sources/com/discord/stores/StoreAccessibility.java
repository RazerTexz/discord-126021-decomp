package com.discord.stores;

import android.content.Context;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.accessibility.AccessibilityFeatureFlags;
import com.discord.utilities.accessibility.AccessibilityMonitor;
import com.discord.utilities.accessibility.AccessibilityMonitor4;
import com.discord.utilities.analytics.AnalyticSuperProperties;
import com.discord.utilities.error.Error;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.EnumSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: StoreAccessibility.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAccessibility extends StoreV2 {
    private EnumSet<AccessibilityFeatureFlags> accessibilityFeatures;
    private EnumSet<AccessibilityFeatureFlags> accessibilityFeaturesSnapshot;
    private final AccessibilityMonitor accessibilityMonitor;
    private final Dispatcher dispatcher;
    private boolean fontScaledDown;
    private boolean fontScaledUp;
    private boolean isDetectionAllowed;
    private final ObservationDeck observationDeck;
    private final Persister<Boolean> reducedMotionCache;
    private boolean reducedMotionEnabled;

    /* JADX INFO: renamed from: com.discord.stores.StoreAccessibility$init$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAccessibility.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<AccessibilityMonitor4, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreAccessibility$init$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreAccessibility.kt */
        public static final class C00731 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ AccessibilityMonitor4 $it;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00731(AccessibilityMonitor4 accessibilityMonitor4) {
                super(0);
                this.$it = accessibilityMonitor4;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreAccessibility.this.updateMonitoredAccessibilityState(this.$it);
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AccessibilityMonitor4 accessibilityMonitor4) {
            invoke2(accessibilityMonitor4);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AccessibilityMonitor4 accessibilityMonitor4) {
            Intrinsics3.checkNotNullParameter(accessibilityMonitor4, "it");
            StoreAccessibility.this.dispatcher.schedule(new C00731(accessibilityMonitor4));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAccessibility$observeAccessibilityFeatures$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAccessibility.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<EnumSet<AccessibilityFeatureFlags>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final EnumSet<AccessibilityFeatureFlags> invoke() {
            return StoreAccessibility.this.getAccessibilityFeatures();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAccessibility$observeReducedMotionEnabled$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAccessibility.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Boolean> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return StoreAccessibility.this.reducedMotionEnabled;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAccessibility$observeScreenreaderEnabled$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAccessibility.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Boolean> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return StoreAccessibility.this.isScreenreaderEnabled();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAccessibility$setReducedMotionEnabled$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAccessibility.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $enabled;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(0);
            this.$enabled = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreAccessibility.this.reducedMotionEnabled = this.$enabled;
            StoreAccessibility.this.markChanged();
        }
    }

    public /* synthetic */ StoreAccessibility(Dispatcher dispatcher, ObservationDeck observationDeck, AccessibilityMonitor accessibilityMonitor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck, (i & 4) != 0 ? AccessibilityMonitor.INSTANCE.getINSTANCE() : accessibilityMonitor);
    }

    @Store3
    private final void updateMonitoredAccessibilityState(AccessibilityMonitor4 state) {
        this.accessibilityFeatures = EnumSet.copyOf((EnumSet) state.getFeatures());
        markChanged();
    }

    public final EnumSet<AccessibilityFeatureFlags> getAccessibilityFeatures() {
        return this.accessibilityFeaturesSnapshot;
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        this.reducedMotionEnabled = this.reducedMotionCache.get().booleanValue();
        ObservableExtensionsKt.appSubscribe(this.accessibilityMonitor.observeAccessibilityState(), (Class<?>) StoreAccessibility.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    /* JADX INFO: renamed from: isReducedMotionEnabled, reason: from getter */
    public final boolean getReducedMotionEnabled() {
        return this.reducedMotionEnabled;
    }

    public final boolean isScreenreaderEnabled() {
        return getAccessibilityFeatures().contains(AccessibilityFeatureFlags.SCREENREADER);
    }

    public final Observable<EnumSet<AccessibilityFeatureFlags>> observeAccessibilityFeatures() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<Boolean> observeReducedMotionEnabled() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<Boolean> observeScreenreaderEnabled() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final void setReducedMotionEnabled(boolean enabled) {
        this.dispatcher.schedule(new AnonymousClass1(enabled));
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        EnumSet<AccessibilityFeatureFlags> enumSetCopyOf = EnumSet.copyOf((EnumSet) this.accessibilityFeatures);
        if (!this.isDetectionAllowed) {
            enumSetCopyOf.remove(AccessibilityFeatureFlags.SCREENREADER);
        }
        if (this.reducedMotionEnabled) {
            enumSetCopyOf.add(AccessibilityFeatureFlags.REDUCED_MOTION_FROM_USER_SETTINGS);
        } else {
            enumSetCopyOf.remove(AccessibilityFeatureFlags.REDUCED_MOTION_FROM_USER_SETTINGS);
        }
        if (this.fontScaledUp) {
            enumSetCopyOf.add(AccessibilityFeatureFlags.CHAT_FONT_SCALE_INCREASED);
        }
        if (this.fontScaledDown) {
            enumSetCopyOf.add(AccessibilityFeatureFlags.CHAT_FONT_SCALE_DECREASED);
        }
        Intrinsics3.checkNotNullExpressionValue(enumSetCopyOf, "features");
        this.accessibilityFeaturesSnapshot = enumSetCopyOf;
        AnalyticSuperProperties.INSTANCE.setAccessibilityProperties(isScreenreaderEnabled(), getAccessibilityFeatures());
        this.reducedMotionCache.set(Boolean.valueOf(this.reducedMotionEnabled), true);
    }

    @Store3
    public final void updateDetectionAllowed(boolean allowed) {
        this.isDetectionAllowed = allowed;
        markChanged();
    }

    @Store3
    public final void updateFontScale(int scale) {
        if (scale == 100 || scale == -1) {
            this.fontScaledUp = false;
            this.fontScaledDown = false;
        } else if (scale > 100) {
            this.fontScaledUp = true;
            this.fontScaledDown = false;
        } else if (scale < 100) {
            this.fontScaledUp = false;
            this.fontScaledDown = true;
        }
        markChanged();
    }

    public StoreAccessibility(Dispatcher dispatcher, ObservationDeck observationDeck, AccessibilityMonitor accessibilityMonitor) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(accessibilityMonitor, "accessibilityMonitor");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.accessibilityMonitor = accessibilityMonitor;
        AccessibilityFeatureFlags accessibilityFeatureFlags = AccessibilityFeatureFlags.NONE;
        this.accessibilityFeatures = EnumSet.of(accessibilityFeatureFlags);
        this.reducedMotionCache = new Persister<>("CACHE_KEY_ACCESSIBILITY_REDUCED_MOTION_ENABLED", Boolean.FALSE);
        EnumSet<AccessibilityFeatureFlags> enumSetOf = EnumSet.of(accessibilityFeatureFlags);
        Intrinsics3.checkNotNullExpressionValue(enumSetOf, "EnumSet.of(AccessibilityFeatureFlags.NONE)");
        this.accessibilityFeaturesSnapshot = enumSetOf;
    }
}
