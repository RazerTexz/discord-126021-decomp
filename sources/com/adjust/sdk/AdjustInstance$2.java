package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class AdjustInstance$2 implements IRunActivityHandler {
    public final /* synthetic */ AdjustInstance this$0;
    public final /* synthetic */ String val$key;
    public final /* synthetic */ String val$value;

    public AdjustInstance$2(AdjustInstance adjustInstance, String str, String str2) {
        this.this$0 = adjustInstance;
        this.val$key = str;
        this.val$value = str2;
    }

    @Override // com.adjust.sdk.IRunActivityHandler
    public void run(ActivityHandler activityHandler) {
        activityHandler.addSessionPartnerParameterI(this.val$key, this.val$value);
    }
}
