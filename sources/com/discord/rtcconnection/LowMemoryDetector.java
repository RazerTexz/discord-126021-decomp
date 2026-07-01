package com.discord.rtcconnection;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.discord.rtcconnection.enums.TrimMemoryLevel;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.logging.LoggingProvider;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: LowMemoryDetector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LowMemoryDetector implements ComponentCallbacks2 {

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final AtomicBoolean isOom = new AtomicBoolean(false);

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics3.checkNotNullParameter(newConfig, "newConfig");
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.isOom.set(true);
        if (this.isOom.get()) {
            Logger.i$default(LoggingProvider.INSTANCE.get(), "LowMemoryDetector", "Normal memory", null, 4, null);
        } else {
            Logger.w$default(LoggingProvider.INSTANCE.get(), "LowMemoryDetector", "Low memory", null, 4, null);
        }
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        TrimMemoryLevel trimMemoryLevel;
        Objects.requireNonNull(TrimMemoryLevel.INSTANCE);
        TrimMemoryLevel[] trimMemoryLevelArrValues = TrimMemoryLevel.values();
        int i = 0;
        while (true) {
            if (i >= 7) {
                trimMemoryLevel = null;
                break;
            }
            trimMemoryLevel = trimMemoryLevelArrValues[i];
            if (trimMemoryLevel.getValue() == level) {
                break;
            } else {
                i++;
            }
        }
        if (trimMemoryLevel != null) {
            Logger.i$default(LoggingProvider.INSTANCE.get(), "LowMemoryDetector", "Memory trim level: " + trimMemoryLevel, null, 4, null);
            switch (trimMemoryLevel) {
                case Background:
                case RunningModerate:
                    Logger.i$default(LoggingProvider.INSTANCE.get(), "LowMemoryDetector", "ignoring low priority oom messages.", null, 4, null);
                    break;
                case Moderate:
                case RunningLow:
                    Logger.i$default(LoggingProvider.INSTANCE.get(), "LowMemoryDetector", "ignoring medium priority oom messages.", null, 4, null);
                    break;
                case Complete:
                case RunningCritical:
                    onLowMemory();
                    break;
                case UiHidden:
                    Logger.i$default(LoggingProvider.INSTANCE.get(), "LowMemoryDetector", "UI is hidden because the app is in the background.", null, 4, null);
                    break;
            }
        }
    }
}
