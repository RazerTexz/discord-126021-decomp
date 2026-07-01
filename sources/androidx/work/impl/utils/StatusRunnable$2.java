package androidx.work.impl.utils;

import androidx.work.WorkInfo;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpec$WorkInfoPojo;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class StatusRunnable$2 extends StatusRunnable<WorkInfo> {
    public final /* synthetic */ UUID val$id;
    public final /* synthetic */ WorkManagerImpl val$workManager;

    public StatusRunnable$2(WorkManagerImpl workManagerImpl, UUID uuid) {
        this.val$workManager = workManagerImpl;
        this.val$id = uuid;
    }

    @Override // androidx.work.impl.utils.StatusRunnable
    public /* bridge */ /* synthetic */ WorkInfo runInternal() {
        return runInternal();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.work.impl.utils.StatusRunnable
    public WorkInfo runInternal() {
        WorkSpec$WorkInfoPojo workStatusPojoForId = this.val$workManager.getWorkDatabase().workSpecDao().getWorkStatusPojoForId(this.val$id.toString());
        if (workStatusPojoForId != null) {
            return workStatusPojoForId.toWorkInfo();
        }
        return null;
    }
}
