package androidx.work.impl.model;

import androidx.arch.core.util.Function;
import androidx.work.WorkInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class WorkSpec$1 implements Function<List<WorkSpec$WorkInfoPojo>, List<WorkInfo>> {
    @Override // androidx.arch.core.util.Function
    public /* bridge */ /* synthetic */ List<WorkInfo> apply(List<WorkSpec$WorkInfoPojo> list) {
        return apply2(list);
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public List<WorkInfo> apply2(List<WorkSpec$WorkInfoPojo> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<WorkSpec$WorkInfoPojo> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toWorkInfo());
        }
        return arrayList;
    }
}
