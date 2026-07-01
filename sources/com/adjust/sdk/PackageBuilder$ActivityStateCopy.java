package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class PackageBuilder$ActivityStateCopy {
    public int eventCount;
    public long lastInterval;
    public String pushToken;
    public int sessionCount;
    public long sessionLength;
    public int subsessionCount;
    public final /* synthetic */ PackageBuilder this$0;
    public long timeSpent;
    public String uuid;

    public PackageBuilder$ActivityStateCopy(PackageBuilder packageBuilder, ActivityState activityState) {
        this.this$0 = packageBuilder;
        this.eventCount = -1;
        this.sessionCount = -1;
        this.subsessionCount = -1;
        this.timeSpent = -1L;
        this.lastInterval = -1L;
        this.sessionLength = -1L;
        this.uuid = null;
        this.pushToken = null;
        if (activityState == null) {
            return;
        }
        this.eventCount = activityState.eventCount;
        this.sessionCount = activityState.sessionCount;
        this.subsessionCount = activityState.subsessionCount;
        this.timeSpent = activityState.timeSpent;
        this.lastInterval = activityState.lastInterval;
        this.sessionLength = activityState.sessionLength;
        this.uuid = activityState.uuid;
        this.pushToken = activityState.pushToken;
    }
}
