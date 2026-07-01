package com.discord.utilities.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings$Global;
import android.view.accessibility.AccessibilityManager;
import d0.g;
import d0.z.d.m;
import java.util.EnumSet;
import java.util.List;
import kotlin.Lazy;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: AccessibilityMonitor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AccessibilityMonitor {
    public static final AccessibilityMonitor$Companion Companion = new AccessibilityMonitor$Companion(null);
    private static final Lazy INSTANCE$delegate = g.lazy(AccessibilityMonitor$Companion$INSTANCE$2.INSTANCE);
    private AccessibilityManager accessibilityManager;
    private AccessibilityState accessibilityState;
    private final SerializedSubject<AccessibilityState, AccessibilityState> accessibilityStateSubject;
    private final ContentObserver animationScaleObserver = new AccessibilityMonitor$animationScaleObserver$1(this, new Handler(Looper.getMainLooper()));
    private ContentResolver contentResolver;

    public AccessibilityMonitor() {
        AccessibilityState accessibilityState = new AccessibilityState(null, 1, null);
        this.accessibilityState = accessibilityState;
        this.accessibilityStateSubject = new SerializedSubject<>(BehaviorSubject.l0(accessibilityState));
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public static final /* synthetic */ void access$handleReduceMotionUpdated(AccessibilityMonitor accessibilityMonitor) {
        accessibilityMonitor.handleReduceMotionUpdated();
    }

    public static final /* synthetic */ void access$handleScreenreaderEnabledUpdate(AccessibilityMonitor accessibilityMonitor, boolean z2) {
        accessibilityMonitor.handleScreenreaderEnabledUpdate(z2);
    }

    private final synchronized void handleInitialState(Context context) {
        Object systemService = context.getSystemService("accessibility");
        if (!(systemService instanceof AccessibilityManager)) {
            systemService = null;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) systemService;
        if (accessibilityManager != null) {
            this.accessibilityManager = accessibilityManager;
            if (accessibilityManager == null) {
                m.throwUninitializedPropertyAccessException("accessibilityManager");
            }
            accessibilityManager.addAccessibilityStateChangeListener(new AccessibilityMonitor$handleInitialState$1(this));
            AccessibilityManager accessibilityManager2 = this.accessibilityManager;
            if (accessibilityManager2 == null) {
                m.throwUninitializedPropertyAccessException("accessibilityManager");
            }
            handleScreenreaderEnabledUpdate(accessibilityManager2.isEnabled());
            ContentResolver contentResolver = context.getContentResolver();
            m.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
            this.contentResolver = contentResolver;
            Uri uriFor = Settings$Global.getUriFor("transition_animation_scale");
            ContentResolver contentResolver2 = this.contentResolver;
            if (contentResolver2 == null) {
                m.throwUninitializedPropertyAccessException("contentResolver");
            }
            contentResolver2.registerContentObserver(uriFor, false, this.animationScaleObserver);
            Resources resources = context.getResources();
            m.checkNotNullExpressionValue(resources, "context.resources");
            handleUIModeUpdate(resources.getConfiguration().uiMode);
        }
    }

    private final void handleReduceMotionUpdated() {
        EnumSet<AccessibilityFeatureFlags> enumSetCopyOf = EnumSet.copyOf((EnumSet) this.accessibilityState.getFeatures());
        ContentResolver contentResolver = this.contentResolver;
        if (contentResolver == null) {
            m.throwUninitializedPropertyAccessException("contentResolver");
        }
        String string = Settings$Global.getString(contentResolver, "transition_animation_scale");
        if (m.areEqual(string, "0.0") || m.areEqual(string, "0")) {
            enumSetCopyOf.add(AccessibilityFeatureFlags.REDUCED_MOTION);
        } else {
            enumSetCopyOf.remove(AccessibilityFeatureFlags.REDUCED_MOTION);
        }
        AccessibilityState accessibilityState = this.accessibilityState;
        m.checkNotNullExpressionValue(enumSetCopyOf, "features");
        updateAccessibilityState(accessibilityState.copy(enumSetCopyOf));
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002c  */
    private final void handleScreenreaderEnabledUpdate(boolean enabled) {
        EnumSet<AccessibilityFeatureFlags> enumSetCopyOf = EnumSet.copyOf((EnumSet) this.accessibilityState.getFeatures());
        AccessibilityManager accessibilityManager = this.accessibilityManager;
        if (accessibilityManager == null) {
            m.throwUninitializedPropertyAccessException("accessibilityManager");
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        if (enabled) {
            m.checkNotNullExpressionValue(enabledAccessibilityServiceList, "services");
            if (!enabledAccessibilityServiceList.isEmpty()) {
                enumSetCopyOf.add(AccessibilityFeatureFlags.SCREENREADER);
            } else {
                enumSetCopyOf.remove(AccessibilityFeatureFlags.SCREENREADER);
            }
        } else {
            enumSetCopyOf.remove(AccessibilityFeatureFlags.SCREENREADER);
        }
        AccessibilityState accessibilityState = this.accessibilityState;
        m.checkNotNullExpressionValue(enumSetCopyOf, "features");
        updateAccessibilityState(accessibilityState.copy(enumSetCopyOf));
    }

    private final void handleUIModeUpdate(int uiMode) {
        EnumSet<AccessibilityFeatureFlags> enumSetCopyOf = EnumSet.copyOf((EnumSet) this.accessibilityState.getFeatures());
        int i = uiMode & 48;
        if (i == 16) {
            enumSetCopyOf.add(AccessibilityFeatureFlags.PREFERS_COLOR_SCHEME_LIGHT);
            enumSetCopyOf.remove(AccessibilityFeatureFlags.PREFERS_COLOR_SCHEME_DARK);
        } else if (i != 32) {
            enumSetCopyOf.remove(AccessibilityFeatureFlags.PREFERS_COLOR_SCHEME_LIGHT);
            enumSetCopyOf.remove(AccessibilityFeatureFlags.PREFERS_COLOR_SCHEME_DARK);
        } else {
            enumSetCopyOf.add(AccessibilityFeatureFlags.PREFERS_COLOR_SCHEME_DARK);
            enumSetCopyOf.remove(AccessibilityFeatureFlags.PREFERS_COLOR_SCHEME_LIGHT);
        }
        AccessibilityState accessibilityState = this.accessibilityState;
        m.checkNotNullExpressionValue(enumSetCopyOf, "features");
        updateAccessibilityState(accessibilityState.copy(enumSetCopyOf));
    }

    private final void updateAccessibilityState(AccessibilityState newState) {
        this.accessibilityState = newState;
        this.accessibilityStateSubject.k.onNext(newState);
    }

    public final void bindContext(Context context) {
        m.checkNotNullParameter(context, "context");
        handleInitialState(context);
    }

    public final Observable<AccessibilityState> observeAccessibilityState() {
        Observable<AccessibilityState> observableR = this.accessibilityStateSubject.r();
        m.checkNotNullExpressionValue(observableR, "accessibilityStateSubject.distinctUntilChanged()");
        return observableR;
    }
}
