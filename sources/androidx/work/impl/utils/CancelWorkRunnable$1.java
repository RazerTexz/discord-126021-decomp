package androidx.work.impl.utils;

import androidx.annotation.WorkerThread;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class CancelWorkRunnable$1 extends CancelWorkRunnable {
    public final /* synthetic */ UUID val$id;
    public final /* synthetic */ WorkManagerImpl val$workManagerImpl;

    public CancelWorkRunnable$1(WorkManagerImpl workManagerImpl, UUID uuid) {
        this.val$workManagerImpl = workManagerImpl;
        this.val$id = uuid;
    }

    @Override // androidx.work.impl.utils.CancelWorkRunnable
    @WorkerThread
    public void runInternal() {
        WorkDatabase workDatabase = this.val$workManagerImpl.getWorkDatabase();
        workDatabase.beginTransaction();
        try {
            cancel(this.val$workManagerImpl, this.val$id.toString());
            workDatabase.setTransactionSuccessful();
            workDatabase.endTransaction();
            reschedulePendingWorkers(this.val$workManagerImpl);
        } catch (Throwable th) {
            workDatabase.endTransaction();
            throw th;
        }
    }
}
