package androidx.work.impl.utils;

import androidx.annotation.WorkerThread;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class CancelWorkRunnable$3 extends CancelWorkRunnable {
    public final /* synthetic */ boolean val$allowReschedule;
    public final /* synthetic */ String val$name;
    public final /* synthetic */ WorkManagerImpl val$workManagerImpl;

    public CancelWorkRunnable$3(WorkManagerImpl workManagerImpl, String str, boolean z2) {
        this.val$workManagerImpl = workManagerImpl;
        this.val$name = str;
        this.val$allowReschedule = z2;
    }

    @Override // androidx.work.impl.utils.CancelWorkRunnable
    @WorkerThread
    public void runInternal() {
        WorkDatabase workDatabase = this.val$workManagerImpl.getWorkDatabase();
        workDatabase.beginTransaction();
        try {
            Iterator<String> it = workDatabase.workSpecDao().getUnfinishedWorkWithName(this.val$name).iterator();
            while (it.hasNext()) {
                cancel(this.val$workManagerImpl, it.next());
            }
            workDatabase.setTransactionSuccessful();
            workDatabase.endTransaction();
            if (this.val$allowReschedule) {
                reschedulePendingWorkers(this.val$workManagerImpl);
            }
        } catch (Throwable th) {
            workDatabase.endTransaction();
            throw th;
        }
    }
}
