package androidx.work;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class WorkQuery$Builder {
    public List<String> mUniqueWorkNames = new ArrayList();
    public List<String> mTags = new ArrayList();
    public List<WorkInfo$State> mStates = new ArrayList();

    private WorkQuery$Builder() {
    }

    @NonNull
    @SuppressLint({"BuilderSetStyle"})
    public static WorkQuery$Builder fromStates(@NonNull List<WorkInfo$State> list) {
        WorkQuery$Builder workQuery$Builder = new WorkQuery$Builder();
        workQuery$Builder.addStates(list);
        return workQuery$Builder;
    }

    @NonNull
    @SuppressLint({"BuilderSetStyle"})
    public static WorkQuery$Builder fromTags(@NonNull List<String> list) {
        WorkQuery$Builder workQuery$Builder = new WorkQuery$Builder();
        workQuery$Builder.addTags(list);
        return workQuery$Builder;
    }

    @NonNull
    @SuppressLint({"BuilderSetStyle"})
    public static WorkQuery$Builder fromUniqueWorkNames(@NonNull List<String> list) {
        WorkQuery$Builder workQuery$Builder = new WorkQuery$Builder();
        workQuery$Builder.addUniqueWorkNames(list);
        return workQuery$Builder;
    }

    @NonNull
    public WorkQuery$Builder addStates(@NonNull List<WorkInfo$State> list) {
        this.mStates.addAll(list);
        return this;
    }

    @NonNull
    public WorkQuery$Builder addTags(@NonNull List<String> list) {
        this.mTags.addAll(list);
        return this;
    }

    @NonNull
    public WorkQuery$Builder addUniqueWorkNames(@NonNull List<String> list) {
        this.mUniqueWorkNames.addAll(list);
        return this;
    }

    @NonNull
    public WorkQuery build() {
        if (this.mUniqueWorkNames.isEmpty() && this.mTags.isEmpty() && this.mStates.isEmpty()) {
            throw new IllegalArgumentException("Must specify uniqueNames, tags or states when building a WorkQuery");
        }
        return new WorkQuery(this);
    }
}
