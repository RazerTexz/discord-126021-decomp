package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class AdjustInstance$4 implements IRunActivityHandler {
    public final /* synthetic */ AdjustInstance this$0;
    public final /* synthetic */ String val$key;

    public AdjustInstance$4(AdjustInstance adjustInstance, String str) {
        this.this$0 = adjustInstance;
        this.val$key = str;
    }

    @Override // com.adjust.sdk.IRunActivityHandler
    public void run(ActivityHandler activityHandler) {
        activityHandler.removeSessionPartnerParameterI(this.val$key);
    }
}
