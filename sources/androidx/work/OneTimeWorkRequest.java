package androidx.work;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class OneTimeWorkRequest extends WorkRequest {
    public OneTimeWorkRequest(OneTimeWorkRequest$Builder oneTimeWorkRequest$Builder) {
        super(oneTimeWorkRequest$Builder.mId, oneTimeWorkRequest$Builder.mWorkSpec, oneTimeWorkRequest$Builder.mTags);
    }

    @NonNull
    public static OneTimeWorkRequest from(@NonNull Class<? extends ListenableWorker> cls) {
        return new OneTimeWorkRequest$Builder(cls).build();
    }

    @NonNull
    public static List<OneTimeWorkRequest> from(@NonNull List<Class<? extends ListenableWorker>> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<Class<? extends ListenableWorker>> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new OneTimeWorkRequest$Builder(it.next()).build());
        }
        return arrayList;
    }
}
