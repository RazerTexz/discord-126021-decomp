package androidx.work;

import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class WorkQuery {
    private final List<WorkInfo$State> mStates;
    private final List<String> mTags;
    private final List<String> mUniqueWorkNames;

    public WorkQuery(@NonNull WorkQuery$Builder workQuery$Builder) {
        this.mUniqueWorkNames = workQuery$Builder.mUniqueWorkNames;
        this.mTags = workQuery$Builder.mTags;
        this.mStates = workQuery$Builder.mStates;
    }

    @NonNull
    public List<WorkInfo$State> getStates() {
        return this.mStates;
    }

    @NonNull
    public List<String> getTags() {
        return this.mTags;
    }

    @NonNull
    public List<String> getUniqueWorkNames() {
        return this.mUniqueWorkNames;
    }
}
