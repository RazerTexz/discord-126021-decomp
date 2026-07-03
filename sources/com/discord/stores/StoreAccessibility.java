package com.discord.stores;

import android.content.Context;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.accessibility.AccessibilityFeatureFlags;
import com.discord.utilities.accessibility.AccessibilityMonitor;
import com.discord.utilities.accessibility.AccessibilityState;
import com.discord.utilities.analytics.AnalyticSuperProperties;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.persister.Persister;
import java.util.EnumSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

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

    /* JADX INFO: renamed from: com.discord.stores.StoreAccessibility$init$1 */
    /* JADX INFO: compiled from: StoreAccessibility.kt */
    public static final class C56701 extends AbstractC12240o implements Function1<AccessibilityState, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreAccessibility$init$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreAccessibility.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ AccessibilityState $it;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(AccessibilityState accessibilityState) {
                super(0);
                this.$it = accessibilityState;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreAccessibility.this.updateMonitoredAccessibilityState(this.$it);
            }
        }

        public C56701() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AccessibilityState accessibilityState) {
            invoke2(accessibilityState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AccessibilityState accessibilityState) {
            C12238m.checkNotNullParameter(accessibilityState, "it");
            StoreAccessibility.this.dispatcher.schedule(new AnonymousClass1(accessibilityState));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAccessibility$observeAccessibilityFeatures$1 */
    /* JADX INFO: compiled from: StoreAccessibility.kt */
    public static final class C56711 extends AbstractC12240o implements Function0<EnumSet<AccessibilityFeatureFlags>> {
        public C56711() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final EnumSet<AccessibilityFeatureFlags> invoke() {
            return StoreAccessibility.this.getAccessibilityFeatures();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAccessibility$observeReducedMotionEnabled$1 */
    /* JADX INFO: compiled from: StoreAccessibility.kt */
    public static final class C56721 extends AbstractC12240o implements Function0<Boolean> {
        public C56721() {
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

    /* JADX INFO: renamed from: com.discord.stores.StoreAccessibility$observeScreenreaderEnabled$1 */
    /* JADX INFO: compiled from: StoreAccessibility.kt */
    public static final class C56731 extends AbstractC12240o implements Function0<Boolean> {
        public C56731() {
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

    /* JADX INFO: renamed from: com.discord.stores.StoreAccessibility$setReducedMotionEnabled$1 */
    /* JADX INFO: compiled from: StoreAccessibility.kt */
    public static final class C56741 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ boolean $enabled;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C56741(boolean z2) {
            super(0);
            this.$enabled = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreAccessibility.this.reducedMotionEnabled = this.$enabled;
            StoreAccessibility.this.markChanged();
        }
    }

    public /* synthetic */ StoreAccessibility(Dispatcher dispatcher, ObservationDeck observationDeck, AccessibilityMonitor accessibilityMonitor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck, (i & 4) != 0 ? AccessibilityMonitor.INSTANCE.getINSTANCE() : accessibilityMonitor);
    }

    @StoreThread
    private final void updateMonitoredAccessibilityState(AccessibilityState state) {
        this.accessibilityFeatures = EnumSet.copyOf((EnumSet) state.getFeatures());
        markChanged();
    }

    public final EnumSet<AccessibilityFeatureFlags> getAccessibilityFeatures() {
        return this.accessibilityFeaturesSnapshot;
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        C12238m.checkNotNullParameter(context, "context");
        this.reducedMotionEnabled = this.reducedMotionCache.get().booleanValue();
        ObservableExtensionsKt.appSubscribe(this.accessibilityMonitor.observeAccessibilityState(), (Class<?>) StoreAccessibility.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C56701());
    }

    /* JADX INFO: renamed from: isReducedMotionEnabled, reason: from getter */
    public final boolean getReducedMotionEnabled() {
        return this.reducedMotionEnabled;
    }

    public final boolean isScreenreaderEnabled() {
        return getAccessibilityFeatures().contains(AccessibilityFeatureFlags.SCREENREADER);
    }

    public final Observable<EnumSet<AccessibilityFeatureFlags>> observeAccessibilityFeatures() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C56711(), 14, null);
    }

    public final Observable<Boolean> observeReducedMotionEnabled() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C56721(), 14, null);
    }

    public final Observable<Boolean> observeScreenreaderEnabled() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C56731(), 14, null);
    }

    public final void setReducedMotionEnabled(boolean enabled) {
        this.dispatcher.schedule(new C56741(enabled));
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
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
        C12238m.checkNotNullExpressionValue(enumSetCopyOf, "features");
        this.accessibilityFeaturesSnapshot = enumSetCopyOf;
        AnalyticSuperProperties.INSTANCE.setAccessibilityProperties(isScreenreaderEnabled(), getAccessibilityFeatures());
        this.reducedMotionCache.set(Boolean.valueOf(this.reducedMotionEnabled), true);
    }

    @StoreThread
    public final void updateDetectionAllowed(boolean allowed) {
        this.isDetectionAllowed = allowed;
        markChanged();
    }

    @StoreThread
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
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        C12238m.checkNotNullParameter(accessibilityMonitor, "accessibilityMonitor");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.accessibilityMonitor = accessibilityMonitor;
        AccessibilityFeatureFlags accessibilityFeatureFlags = AccessibilityFeatureFlags.NONE;
        this.accessibilityFeatures = EnumSet.of(accessibilityFeatureFlags);
        this.reducedMotionCache = new Persister<>("CACHE_KEY_ACCESSIBILITY_REDUCED_MOTION_ENABLED", Boolean.FALSE);
        EnumSet<AccessibilityFeatureFlags> enumSetOf = EnumSet.of(accessibilityFeatureFlags);
        C12238m.checkNotNullExpressionValue(enumSetOf, "EnumSet.of(AccessibilityFeatureFlags.NONE)");
        this.accessibilityFeaturesSnapshot = enumSetOf;
    }
}
