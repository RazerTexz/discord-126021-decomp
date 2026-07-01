package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class ActivityHandler$InternalState {
    public boolean background;
    public boolean delayStart;
    public boolean enabled;
    public boolean firstLaunch;
    public boolean firstSdkStart;
    public boolean offline;
    public boolean sessionResponseProcessed;
    public final /* synthetic */ ActivityHandler this$0;
    public boolean updatePackages;

    public ActivityHandler$InternalState(ActivityHandler activityHandler) {
        this.this$0 = activityHandler;
    }

    public boolean hasFirstSdkStartNotOcurred() {
        return !this.firstSdkStart;
    }

    public boolean hasFirstSdkStartOcurred() {
        return this.firstSdkStart;
    }

    public boolean hasSessionResponseNotBeenProcessed() {
        return !this.sessionResponseProcessed;
    }

    public boolean isDisabled() {
        return !this.enabled;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean isFirstLaunch() {
        return this.firstLaunch;
    }

    public boolean isInBackground() {
        return this.background;
    }

    public boolean isInDelayedStart() {
        return this.delayStart;
    }

    public boolean isInForeground() {
        return !this.background;
    }

    public boolean isNotFirstLaunch() {
        return !this.firstLaunch;
    }

    public boolean isNotInDelayedStart() {
        return !this.delayStart;
    }

    public boolean isOffline() {
        return this.offline;
    }

    public boolean isOnline() {
        return !this.offline;
    }

    public boolean itHasToUpdatePackages() {
        return this.updatePackages;
    }
}
