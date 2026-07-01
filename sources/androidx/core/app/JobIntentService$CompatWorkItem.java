package androidx.core.app;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public final class JobIntentService$CompatWorkItem implements JobIntentService$GenericWorkItem {
    public final Intent mIntent;
    public final int mStartId;
    public final /* synthetic */ JobIntentService this$0;

    public JobIntentService$CompatWorkItem(JobIntentService jobIntentService, Intent intent, int i) {
        this.this$0 = jobIntentService;
        this.mIntent = intent;
        this.mStartId = i;
    }

    @Override // androidx.core.app.JobIntentService$GenericWorkItem
    public void complete() {
        this.this$0.stopSelf(this.mStartId);
    }

    @Override // androidx.core.app.JobIntentService$GenericWorkItem
    public Intent getIntent() {
        return this.mIntent;
    }
}
