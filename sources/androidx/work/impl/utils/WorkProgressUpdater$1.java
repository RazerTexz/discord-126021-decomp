package androidx.work.impl.utils;

import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.WorkInfo$State;
import androidx.work.impl.model.WorkProgress;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class WorkProgressUpdater$1 implements Runnable {
    public final /* synthetic */ WorkProgressUpdater this$0;
    public final /* synthetic */ Data val$data;
    public final /* synthetic */ SettableFuture val$future;
    public final /* synthetic */ UUID val$id;

    public WorkProgressUpdater$1(WorkProgressUpdater workProgressUpdater, UUID uuid, Data data, SettableFuture settableFuture) {
        this.this$0 = workProgressUpdater;
        this.val$id = uuid;
        this.val$data = data;
        this.val$future = settableFuture;
    }

    @Override // java.lang.Runnable
    public void run() {
        String string = this.val$id.toString();
        Logger logger = Logger.get();
        String str = WorkProgressUpdater.TAG;
        logger.debug(str, String.format("Updating progress for %s (%s)", this.val$id, this.val$data), new Throwable[0]);
        this.this$0.mWorkDatabase.beginTransaction();
        try {
            WorkSpec workSpec = this.this$0.mWorkDatabase.workSpecDao().getWorkSpec(string);
            if (workSpec == null) {
                throw new IllegalStateException("Calls to setProgressAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
            }
            if (workSpec.state == WorkInfo$State.RUNNING) {
                this.this$0.mWorkDatabase.workProgressDao().insert(new WorkProgress(string, this.val$data));
            } else {
                Logger.get().warning(str, String.format("Ignoring setProgressAsync(...). WorkSpec (%s) is not in a RUNNING state.", string), new Throwable[0]);
            }
            this.val$future.set(null);
            this.this$0.mWorkDatabase.setTransactionSuccessful();
        } catch (Throwable th) {
            try {
                Logger.get().error(WorkProgressUpdater.TAG, "Error updating Worker progress", th);
                this.val$future.setException(th);
            } finally {
                this.this$0.mWorkDatabase.endTransaction();
            }
        }
    }
}
