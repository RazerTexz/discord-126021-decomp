package com.discord.utilities.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.accessibility.AccessibilityManager;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.C12083g;
import p507d0.p592z.p594d.C12238m;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.functions.Action1;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: AccessibilityMonitor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AccessibilityMonitor {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = C12083g.lazy(AccessibilityMonitor$Companion$INSTANCE$2.INSTANCE);
    private AccessibilityManager accessibilityManager;
    private AccessibilityState accessibilityState;
    private final SerializedSubject<AccessibilityState, AccessibilityState> accessibilityStateSubject;
    private final ContentObserver animationScaleObserver;
    private ContentResolver contentResolver;

    /* JADX INFO: compiled from: AccessibilityMonitor.kt */
    public static final class Companion {
        private Companion() {
        }

        public final AccessibilityMonitor getINSTANCE() {
            Lazy lazy = AccessibilityMonitor.INSTANCE$delegate;
            Companion companion = AccessibilityMonitor.INSTANCE;
            return (AccessibilityMonitor) lazy.getValue();
        }

        public final void initialize(Application application) {
            C12238m.checkNotNullParameter(application, "application");
            getINSTANCE().bindContext(application);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AccessibilityMonitor() {
        final Handler handler = new Handler(Looper.getMainLooper());
        this.animationScaleObserver = new ContentObserver(handler) { // from class: com.discord.utilities.accessibility.AccessibilityMonitor$animationScaleObserver$1
            @Override // android.database.ContentObserver
            public void onChange(boolean selfChange) {
                onChange(selfChange, null);
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean selfChange, Uri uri) {
                this.this$0.handleReduceMotionUpdated();
            }
        };
        AccessibilityState accessibilityState = new AccessibilityState(null, 1, 0 == true ? 1 : 0);
        this.accessibilityState = accessibilityState;
        this.accessibilityStateSubject = new SerializedSubject<>(BehaviorSubject.m11130l0(accessibilityState));
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
                C12238m.throwUninitializedPropertyAccessException("accessibilityManager");
            }
            accessibilityManager.addAccessibilityStateChangeListener(new AccessibilityManager.AccessibilityStateChangeListener() { // from class: com.discord.utilities.accessibility.AccessibilityMonitor.handleInitialState.1
                @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
                public final void onAccessibilityStateChanged(final boolean z2) {
                    new C12721k(Unit.f27425a).m11111q(200L, TimeUnit.MILLISECONDS).m11096V(new Action1<Unit>() { // from class: com.discord.utilities.accessibility.AccessibilityMonitor.handleInitialState.1.1
                        @Override // p658rx.functions.Action1
                        public final void call(Unit unit) {
                            AccessibilityMonitor.this.handleScreenreaderEnabledUpdate(z2);
                        }
                    });
                }
            });
            AccessibilityManager accessibilityManager2 = this.accessibilityManager;
            if (accessibilityManager2 == null) {
                C12238m.throwUninitializedPropertyAccessException("accessibilityManager");
            }
            handleScreenreaderEnabledUpdate(accessibilityManager2.isEnabled());
            ContentResolver contentResolver = context.getContentResolver();
            C12238m.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
            this.contentResolver = contentResolver;
            Uri uriFor = Settings.Global.getUriFor("transition_animation_scale");
            ContentResolver contentResolver2 = this.contentResolver;
            if (contentResolver2 == null) {
                C12238m.throwUninitializedPropertyAccessException("contentResolver");
            }
            contentResolver2.registerContentObserver(uriFor, false, this.animationScaleObserver);
            Resources resources = context.getResources();
            C12238m.checkNotNullExpressionValue(resources, "context.resources");
            handleUIModeUpdate(resources.getConfiguration().uiMode);
        }
    }

    private final void handleReduceMotionUpdated() {
        EnumSet<AccessibilityFeatureFlags> enumSetCopyOf = EnumSet.copyOf((EnumSet) this.accessibilityState.getFeatures());
        ContentResolver contentResolver = this.contentResolver;
        if (contentResolver == null) {
            C12238m.throwUninitializedPropertyAccessException("contentResolver");
        }
        String string = Settings.Global.getString(contentResolver, "transition_animation_scale");
        if (C12238m.areEqual(string, "0.0") || C12238m.areEqual(string, "0")) {
            enumSetCopyOf.add(AccessibilityFeatureFlags.REDUCED_MOTION);
        } else {
            enumSetCopyOf.remove(AccessibilityFeatureFlags.REDUCED_MOTION);
        }
        AccessibilityState accessibilityState = this.accessibilityState;
        C12238m.checkNotNullExpressionValue(enumSetCopyOf, "features");
        updateAccessibilityState(accessibilityState.copy(enumSetCopyOf));
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002c  */
    private final void handleScreenreaderEnabledUpdate(boolean enabled) {
        EnumSet<AccessibilityFeatureFlags> enumSetCopyOf = EnumSet.copyOf((EnumSet) this.accessibilityState.getFeatures());
        AccessibilityManager accessibilityManager = this.accessibilityManager;
        if (accessibilityManager == null) {
            C12238m.throwUninitializedPropertyAccessException("accessibilityManager");
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        if (enabled) {
            C12238m.checkNotNullExpressionValue(enabledAccessibilityServiceList, "services");
            if (!enabledAccessibilityServiceList.isEmpty()) {
                enumSetCopyOf.add(AccessibilityFeatureFlags.SCREENREADER);
            } else {
                enumSetCopyOf.remove(AccessibilityFeatureFlags.SCREENREADER);
            }
        } else {
            enumSetCopyOf.remove(AccessibilityFeatureFlags.SCREENREADER);
        }
        AccessibilityState accessibilityState = this.accessibilityState;
        C12238m.checkNotNullExpressionValue(enumSetCopyOf, "features");
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
        C12238m.checkNotNullExpressionValue(enumSetCopyOf, "features");
        updateAccessibilityState(accessibilityState.copy(enumSetCopyOf));
    }

    private final void updateAccessibilityState(AccessibilityState newState) {
        this.accessibilityState = newState;
        this.accessibilityStateSubject.f27653k.onNext(newState);
    }

    public final void bindContext(Context context) {
        C12238m.checkNotNullParameter(context, "context");
        handleInitialState(context);
    }

    public final Observable<AccessibilityState> observeAccessibilityState() {
        Observable<AccessibilityState> observableM11112r = this.accessibilityStateSubject.m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "accessibilityStateSubject.distinctUntilChanged()");
        return observableM11112r;
    }
}
