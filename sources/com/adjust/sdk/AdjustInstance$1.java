package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class AdjustInstance$1 implements IRunActivityHandler {
    public final /* synthetic */ AdjustInstance this$0;
    public final /* synthetic */ String val$key;
    public final /* synthetic */ String val$value;

    public AdjustInstance$1(AdjustInstance adjustInstance, String str, String str2) {
        this.this$0 = adjustInstance;
        this.val$key = str;
        this.val$value = str2;
    }

    @Override // com.adjust.sdk.IRunActivityHandler
    public void run(ActivityHandler activityHandler) {
        activityHandler.addSessionCallbackParameterI(this.val$key, this.val$value);
    }
}
