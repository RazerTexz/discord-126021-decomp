package androidx.core.app;

import android.os.AsyncTask;

/* JADX INFO: loaded from: classes.dex */
public final class JobIntentService$CommandProcessor extends AsyncTask<Void, Void, Void> {
    public final /* synthetic */ JobIntentService this$0;

    public JobIntentService$CommandProcessor(JobIntentService jobIntentService) {
        this.this$0 = jobIntentService;
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ Void doInBackground(Void[] voidArr) {
        return doInBackground2(voidArr);
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ void onCancelled(Void r1) {
        onCancelled2(r1);
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ void onPostExecute(Void r1) {
        onPostExecute2(r1);
    }

    /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
    public Void doInBackground2(Void... voidArr) {
        while (true) {
            JobIntentService$GenericWorkItem jobIntentService$GenericWorkItemDequeueWork = this.this$0.dequeueWork();
            if (jobIntentService$GenericWorkItemDequeueWork == null) {
                return null;
            }
            this.this$0.onHandleWork(jobIntentService$GenericWorkItemDequeueWork.getIntent());
            jobIntentService$GenericWorkItemDequeueWork.complete();
        }
    }

    /* JADX INFO: renamed from: onCancelled, reason: avoid collision after fix types in other method */
    public void onCancelled2(Void r1) {
        this.this$0.processorFinished();
    }

    /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
    public void onPostExecute2(Void r1) {
        this.this$0.processorFinished();
    }
}
