package androidx.work.impl.utils;

import androidx.annotation.WorkerThread;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class CancelWorkRunnable$2 extends CancelWorkRunnable {
    public final /* synthetic */ String val$tag;
    public final /* synthetic */ WorkManagerImpl val$workManagerImpl;

    public CancelWorkRunnable$2(WorkManagerImpl workManagerImpl, String str) {
        this.val$workManagerImpl = workManagerImpl;
        this.val$tag = str;
    }

    @Override // androidx.work.impl.utils.CancelWorkRunnable
    @WorkerThread
    public void runInternal() {
        WorkDatabase workDatabase = this.val$workManagerImpl.getWorkDatabase();
        workDatabase.beginTransaction();
        try {
            Iterator<String> it = workDatabase.workSpecDao().getUnfinishedWorkWithTag(this.val$tag).iterator();
            while (it.hasNext()) {
                cancel(this.val$workManagerImpl, it.next());
            }
            workDatabase.setTransactionSuccessful();
            workDatabase.endTransaction();
            reschedulePendingWorkers(this.val$workManagerImpl);
        } catch (Throwable th) {
            workDatabase.endTransaction();
            throw th;
        }
    }
}
