package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class ActivityHandler$30 implements IRunActivityHandler {
    public final /* synthetic */ ActivityHandler this$0;

    public ActivityHandler$30(ActivityHandler activityHandler) {
        this.this$0 = activityHandler;
    }

    @Override // com.adjust.sdk.IRunActivityHandler
    public void run(ActivityHandler activityHandler) {
        ActivityHandler.access$1100(activityHandler, ActivityHandler.access$3000(this.this$0).startEnabled.booleanValue());
    }
}
