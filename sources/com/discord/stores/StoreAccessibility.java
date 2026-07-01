package com.discord.stores;

import android.content.Context;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.accessibility.AccessibilityFeatureFlags;
import com.discord.utilities.accessibility.AccessibilityMonitor;
import com.discord.utilities.accessibility.AccessibilityState;
import com.discord.utilities.analytics.AnalyticSuperProperties;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.util.EnumSet;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

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

    public /* synthetic */ StoreAccessibility(Dispatcher dispatcher, ObservationDeck observationDeck, AccessibilityMonitor accessibilityMonitor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck, (i & 4) != 0 ? AccessibilityMonitor.Companion.getINSTANCE() : accessibilityMonitor);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreAccessibility storeAccessibility) {
        return storeAccessibility.dispatcher;
    }

    public static final /* synthetic */ boolean access$getReducedMotionEnabled$p(StoreAccessibility storeAccessibility) {
        return storeAccessibility.reducedMotionEnabled;
    }

    public static final /* synthetic */ void access$setReducedMotionEnabled$p(StoreAccessibility storeAccessibility, boolean z2) {
        storeAccessibility.reducedMotionEnabled = z2;
    }

    public static final /* synthetic */ void access$updateMonitoredAccessibilityState(StoreAccessibility storeAccessibility, AccessibilityState accessibilityState) {
        storeAccessibility.updateMonitoredAccessibilityState(accessibilityState);
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
        m.checkNotNullParameter(context, "context");
        this.reducedMotionEnabled = this.reducedMotionCache.get().booleanValue();
        ObservableExtensionsKt.appSubscribe$default(this.accessibilityMonitor.observeAccessibilityState(), StoreAccessibility.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreAccessibility$init$1(this), 62, (Object) null);
    }

    /* JADX INFO: renamed from: isReducedMotionEnabled, reason: from getter */
    public final boolean getReducedMotionEnabled() {
        return this.reducedMotionEnabled;
    }

    public final boolean isScreenreaderEnabled() {
        return getAccessibilityFeatures().contains(AccessibilityFeatureFlags.SCREENREADER);
    }

    public final Observable<EnumSet<AccessibilityFeatureFlags>> observeAccessibilityFeatures() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreAccessibility$observeAccessibilityFeatures$1(this), 14, null);
    }

    public final Observable<Boolean> observeReducedMotionEnabled() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreAccessibility$observeReducedMotionEnabled$1(this), 14, null);
    }

    public final Observable<Boolean> observeScreenreaderEnabled() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreAccessibility$observeScreenreaderEnabled$1(this), 14, null);
    }

    public final void setReducedMotionEnabled(boolean enabled) {
        this.dispatcher.schedule(new StoreAccessibility$setReducedMotionEnabled$1(this, enabled));
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
        m.checkNotNullExpressionValue(enumSetCopyOf, "features");
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
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(accessibilityMonitor, "accessibilityMonitor");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.accessibilityMonitor = accessibilityMonitor;
        AccessibilityFeatureFlags accessibilityFeatureFlags = AccessibilityFeatureFlags.NONE;
        this.accessibilityFeatures = EnumSet.of(accessibilityFeatureFlags);
        this.reducedMotionCache = new Persister<>("CACHE_KEY_ACCESSIBILITY_REDUCED_MOTION_ENABLED", Boolean.FALSE);
        EnumSet<AccessibilityFeatureFlags> enumSetOf = EnumSet.of(accessibilityFeatureFlags);
        m.checkNotNullExpressionValue(enumSetOf, "EnumSet.of(AccessibilityFeatureFlags.NONE)");
        this.accessibilityFeaturesSnapshot = enumSetOf;
    }
}
