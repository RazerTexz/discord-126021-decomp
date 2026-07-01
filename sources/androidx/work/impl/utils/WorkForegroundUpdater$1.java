package androidx.work.impl.utils;

import android.content.Context;
import androidx.work.ForegroundInfo;
import androidx.work.WorkInfo$State;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.utils.futures.SettableFuture;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class WorkForegroundUpdater$1 implements Runnable {
    public final /* synthetic */ WorkForegroundUpdater this$0;
    public final /* synthetic */ Context val$context;
    public final /* synthetic */ ForegroundInfo val$foregroundInfo;
    public final /* synthetic */ SettableFuture val$future;
    public final /* synthetic */ UUID val$id;

    public WorkForegroundUpdater$1(WorkForegroundUpdater workForegroundUpdater, SettableFuture settableFuture, UUID uuid, ForegroundInfo foregroundInfo, Context context) {
        this.this$0 = workForegroundUpdater;
        this.val$future = settableFuture;
        this.val$id = uuid;
        this.val$foregroundInfo = foregroundInfo;
        this.val$context = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (!this.val$future.isCancelled()) {
                String string = this.val$id.toString();
                WorkInfo$State state = this.this$0.mWorkSpecDao.getState(string);
                if (state == null || state.isFinished()) {
                    throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                }
                this.this$0.mForegroundProcessor.startForeground(string, this.val$foregroundInfo);
                this.val$context.startService(SystemForegroundDispatcher.createNotifyIntent(this.val$context, string, this.val$foregroundInfo));
            }
            this.val$future.set(null);
        } catch (Throwable th) {
            this.val$future.setException(th);
        }
    }
}
