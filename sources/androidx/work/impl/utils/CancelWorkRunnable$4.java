package androidx.work.impl.utils;

import androidx.annotation.WorkerThread;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class CancelWorkRunnable$4 extends CancelWorkRunnable {
    public final /* synthetic */ WorkManagerImpl val$workManagerImpl;

    public CancelWorkRunnable$4(WorkManagerImpl workManagerImpl) {
        this.val$workManagerImpl = workManagerImpl;
    }

    @Override // androidx.work.impl.utils.CancelWorkRunnable
    @WorkerThread
    public void runInternal() {
        WorkDatabase workDatabase = this.val$workManagerImpl.getWorkDatabase();
        workDatabase.beginTransaction();
        try {
            Iterator<String> it = workDatabase.workSpecDao().getAllUnfinishedWork().iterator();
            while (it.hasNext()) {
                cancel(this.val$workManagerImpl, it.next());
            }
            new PreferenceUtils(this.val$workManagerImpl.getWorkDatabase()).setLastCancelAllTimeMillis(System.currentTimeMillis());
            workDatabase.setTransactionSuccessful();
        } finally {
            workDatabase.endTransaction();
        }
    }
}
