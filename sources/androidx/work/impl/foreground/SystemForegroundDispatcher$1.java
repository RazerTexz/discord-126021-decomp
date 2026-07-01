package androidx.work.impl.foreground;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkSpec;

/* JADX INFO: loaded from: classes.dex */
public class SystemForegroundDispatcher$1 implements Runnable {
    public final /* synthetic */ SystemForegroundDispatcher this$0;
    public final /* synthetic */ WorkDatabase val$database;
    public final /* synthetic */ String val$workSpecId;

    public SystemForegroundDispatcher$1(SystemForegroundDispatcher systemForegroundDispatcher, WorkDatabase workDatabase, String str) {
        this.this$0 = systemForegroundDispatcher;
        this.val$database = workDatabase;
        this.val$workSpecId = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        WorkSpec workSpec = this.val$database.workSpecDao().getWorkSpec(this.val$workSpecId);
        if (workSpec == null || !workSpec.hasConstraints()) {
            return;
        }
        synchronized (this.this$0.mLock) {
            this.this$0.mWorkSpecById.put(this.val$workSpecId, workSpec);
            this.this$0.mTrackedWorkSpecs.add(workSpec);
            SystemForegroundDispatcher systemForegroundDispatcher = this.this$0;
            systemForegroundDispatcher.mConstraintsTracker.replace(systemForegroundDispatcher.mTrackedWorkSpecs);
        }
    }
}
