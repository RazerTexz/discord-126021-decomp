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
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import j0.l.e.ScalarSynchronousObservable;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Action1;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: AccessibilityMonitor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AccessibilityMonitor {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = LazyJVM.lazy(AccessibilityMonitor2.INSTANCE);
    private AccessibilityManager accessibilityManager;
    private AccessibilityMonitor4 accessibilityState;
    private final SerializedSubject<AccessibilityMonitor4, AccessibilityMonitor4> accessibilityStateSubject;
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
            Intrinsics3.checkNotNullParameter(application, "application");
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
        AccessibilityMonitor4 accessibilityMonitor4 = new AccessibilityMonitor4(null, 1, 0 == true ? 1 : 0);
        this.accessibilityState = accessibilityMonitor4;
        this.accessibilityStateSubject = new SerializedSubject<>(BehaviorSubject.l0(accessibilityMonitor4));
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
                Intrinsics3.throwUninitializedPropertyAccessException("accessibilityManager");
            }
            accessibilityManager.addAccessibilityStateChangeListener(new AccessibilityManager.AccessibilityStateChangeListener() { // from class: com.discord.utilities.accessibility.AccessibilityMonitor.handleInitialState.1
                @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
                public final void onAccessibilityStateChanged(final boolean z2) {
                    new ScalarSynchronousObservable(Unit.a).q(200L, TimeUnit.MILLISECONDS).V(new Action1<Unit>() { // from class: com.discord.utilities.accessibility.AccessibilityMonitor.handleInitialState.1.1
                        @Override // rx.functions.Action1
                        public final void call(Unit unit) {
                            AccessibilityMonitor.this.handleScreenreaderEnabledUpdate(z2);
                        }
                    });
                }
            });
            AccessibilityManager accessibilityManager2 = this.accessibilityManager;
            if (accessibilityManager2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("accessibilityManager");
            }
            handleScreenreaderEnabledUpdate(accessibilityManager2.isEnabled());
            ContentResolver contentResolver = context.getContentResolver();
            Intrinsics3.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
            this.contentResolver = contentResolver;
            Uri uriFor = Settings.Global.getUriFor("transition_animation_scale");
            ContentResolver contentResolver2 = this.contentResolver;
            if (contentResolver2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("contentResolver");
            }
            contentResolver2.registerContentObserver(uriFor, false, this.animationScaleObserver);
            Resources resources = context.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "context.resources");
            handleUIModeUpdate(resources.getConfiguration().uiMode);
        }
    }

    private final void handleReduceMotionUpdated() {
        EnumSet<AccessibilityFeatureFlags> enumSetCopyOf = EnumSet.copyOf((EnumSet) this.accessibilityState.getFeatures());
        ContentResolver contentResolver = this.contentResolver;
        if (contentResolver == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("contentResolver");
        }
        String string = Settings.Global.getString(contentResolver, "transition_animation_scale");
        if (Intrinsics3.areEqual(string, "0.0") || Intrinsics3.areEqual(string, "0")) {
            enumSetCopyOf.add(AccessibilityFeatureFlags.REDUCED_MOTION);
        } else {
            enumSetCopyOf.remove(AccessibilityFeatureFlags.REDUCED_MOTION);
        }
        AccessibilityMonitor4 accessibilityMonitor4 = this.accessibilityState;
        Intrinsics3.checkNotNullExpressionValue(enumSetCopyOf, "features");
        updateAccessibilityState(accessibilityMonitor4.copy(enumSetCopyOf));
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002c  */
    private final void handleScreenreaderEnabledUpdate(boolean enabled) {
        EnumSet<AccessibilityFeatureFlags> enumSetCopyOf = EnumSet.copyOf((EnumSet) this.accessibilityState.getFeatures());
        AccessibilityManager accessibilityManager = this.accessibilityManager;
        if (accessibilityManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("accessibilityManager");
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        if (enabled) {
            Intrinsics3.checkNotNullExpressionValue(enabledAccessibilityServiceList, "services");
            if (!enabledAccessibilityServiceList.isEmpty()) {
                enumSetCopyOf.add(AccessibilityFeatureFlags.SCREENREADER);
            } else {
                enumSetCopyOf.remove(AccessibilityFeatureFlags.SCREENREADER);
            }
        } else {
            enumSetCopyOf.remove(AccessibilityFeatureFlags.SCREENREADER);
        }
        AccessibilityMonitor4 accessibilityMonitor4 = this.accessibilityState;
        Intrinsics3.checkNotNullExpressionValue(enumSetCopyOf, "features");
        updateAccessibilityState(accessibilityMonitor4.copy(enumSetCopyOf));
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
        AccessibilityMonitor4 accessibilityMonitor4 = this.accessibilityState;
        Intrinsics3.checkNotNullExpressionValue(enumSetCopyOf, "features");
        updateAccessibilityState(accessibilityMonitor4.copy(enumSetCopyOf));
    }

    private final void updateAccessibilityState(AccessibilityMonitor4 newState) {
        this.accessibilityState = newState;
        this.accessibilityStateSubject.k.onNext(newState);
    }

    public final void bindContext(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        handleInitialState(context);
    }

    public final Observable<AccessibilityMonitor4> observeAccessibilityState() {
        Observable<AccessibilityMonitor4> observableR = this.accessibilityStateSubject.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "accessibilityStateSubject.distinctUntilChanged()");
        return observableR;
    }
}
