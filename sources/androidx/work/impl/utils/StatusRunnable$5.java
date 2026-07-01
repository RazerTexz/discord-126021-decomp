package androidx.work.impl.utils;

import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpec;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class StatusRunnable$5 extends StatusRunnable<List<WorkInfo>> {
    public final /* synthetic */ WorkQuery val$querySpec;
    public final /* synthetic */ WorkManagerImpl val$workManager;

    public StatusRunnable$5(WorkManagerImpl workManagerImpl, WorkQuery workQuery) {
        this.val$workManager = workManagerImpl;
        this.val$querySpec = workQuery;
    }

    @Override // androidx.work.impl.utils.StatusRunnable
    public /* bridge */ /* synthetic */ List<WorkInfo> runInternal() {
        return runInternal2();
    }

    @Override // androidx.work.impl.utils.StatusRunnable
    /* JADX INFO: renamed from: runInternal, reason: avoid collision after fix types in other method */
    public List<WorkInfo> runInternal2() {
        return WorkSpec.WORK_INFO_MAPPER.apply(this.val$workManager.getWorkDatabase().rawWorkInfoDao().getWorkInfoPojos(RawQueries.workQueryToRawQuery(this.val$querySpec)));
    }
}
