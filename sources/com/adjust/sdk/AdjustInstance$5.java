package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public class AdjustInstance$5 implements IRunActivityHandler {
    public final /* synthetic */ AdjustInstance this$0;

    public AdjustInstance$5(AdjustInstance adjustInstance) {
        this.this$0 = adjustInstance;
    }

    @Override // com.adjust.sdk.IRunActivityHandler
    public void run(ActivityHandler activityHandler) {
        activityHandler.resetSessionCallbackParametersI();
    }
}
