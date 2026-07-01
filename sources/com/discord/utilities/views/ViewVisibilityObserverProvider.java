package com.discord.utilities.views;

import androidx.annotation.MainThread;
import d0.z.d.Intrinsics3;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: ViewVisibilityObserverProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewVisibilityObserverProvider {
    public static final String INLINE_VOICE_FEATURE = "INLINE_VOICE_FEATURE";
    public static final ViewVisibilityObserverProvider INSTANCE = new ViewVisibilityObserverProvider();
    private static final Map<String, WeakReference<ViewVisibilityObserver>> featureNameToObserverRefMap = new LinkedHashMap();

    private ViewVisibilityObserverProvider() {
    }

    @MainThread
    public final ViewVisibilityObserver get(String featureName) {
        Intrinsics3.checkNotNullParameter(featureName, "featureName");
        Map<String, WeakReference<ViewVisibilityObserver>> map = featureNameToObserverRefMap;
        WeakReference<ViewVisibilityObserver> weakReference = map.get(featureName);
        ViewVisibilityObserver viewVisibilityObserver = weakReference != null ? weakReference.get() : null;
        if (viewVisibilityObserver != null) {
            return viewVisibilityObserver;
        }
        ViewVisibilityObserver viewVisibilityObserver2 = new ViewVisibilityObserver();
        map.put(featureName, new WeakReference<>(viewVisibilityObserver2));
        return viewVisibilityObserver2;
    }
}
