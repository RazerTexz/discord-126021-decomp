package androidx.work.impl;

import androidx.arch.core.util.Function;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec$WorkInfoPojo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class WorkManagerImpl$2 implements Function<List<WorkSpec$WorkInfoPojo>, WorkInfo> {
    public final /* synthetic */ WorkManagerImpl this$0;

    public WorkManagerImpl$2(WorkManagerImpl workManagerImpl) {
        this.this$0 = workManagerImpl;
    }

    @Override // androidx.arch.core.util.Function
    public /* bridge */ /* synthetic */ WorkInfo apply(List<WorkSpec$WorkInfoPojo> list) {
        return apply2(list);
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public WorkInfo apply2(List<WorkSpec$WorkInfoPojo> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        return list.get(0).toWorkInfo();
    }
}
