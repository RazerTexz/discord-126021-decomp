package androidx.work.impl.utils;

import androidx.work.WorkInfo;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpec;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class StatusRunnable$3 extends StatusRunnable<List<WorkInfo>> {
    public final /* synthetic */ String val$tag;
    public final /* synthetic */ WorkManagerImpl val$workManager;

    public StatusRunnable$3(WorkManagerImpl workManagerImpl, String str) {
        this.val$workManager = workManagerImpl;
        this.val$tag = str;
    }

    @Override // androidx.work.impl.utils.StatusRunnable
    public /* bridge */ /* synthetic */ List<WorkInfo> runInternal() {
        return runInternal2();
    }

    @Override // androidx.work.impl.utils.StatusRunnable
    /* JADX INFO: renamed from: runInternal, reason: avoid collision after fix types in other method */
    public List<WorkInfo> runInternal2() {
        return WorkSpec.WORK_INFO_MAPPER.apply(this.val$workManager.getWorkDatabase().workSpecDao().getWorkStatusPojoForTag(this.val$tag));
    }
}
