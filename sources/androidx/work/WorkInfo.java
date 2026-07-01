package androidx.work;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import b.d.b.a.a;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class WorkInfo {

    @NonNull
    private UUID mId;

    @NonNull
    private Data mOutputData;

    @NonNull
    private Data mProgress;
    private int mRunAttemptCount;

    @NonNull
    private WorkInfo$State mState;

    @NonNull
    private Set<String> mTags;

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
    public WorkInfo(@NonNull UUID uuid, @NonNull WorkInfo$State workInfo$State, @NonNull Data data, @NonNull List<String> list, @NonNull Data data2, int i) {
        this.mId = uuid;
        this.mState = workInfo$State;
        this.mOutputData = data;
        this.mTags = new HashSet(list);
        this.mProgress = data2;
        this.mRunAttemptCount = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || WorkInfo.class != obj.getClass()) {
            return false;
        }
        WorkInfo workInfo = (WorkInfo) obj;
        if (this.mRunAttemptCount == workInfo.mRunAttemptCount && this.mId.equals(workInfo.mId) && this.mState == workInfo.mState && this.mOutputData.equals(workInfo.mOutputData) && this.mTags.equals(workInfo.mTags)) {
            return this.mProgress.equals(workInfo.mProgress);
        }
        return false;
    }

    @NonNull
    public UUID getId() {
        return this.mId;
    }

    @NonNull
    public Data getOutputData() {
        return this.mOutputData;
    }

    @NonNull
    public Data getProgress() {
        return this.mProgress;
    }

    @IntRange(from = 0)
    public int getRunAttemptCount() {
        return this.mRunAttemptCount;
    }

    @NonNull
    public WorkInfo$State getState() {
        return this.mState;
    }

    @NonNull
    public Set<String> getTags() {
        return this.mTags;
    }

    public int hashCode() {
        return ((this.mProgress.hashCode() + ((this.mTags.hashCode() + ((this.mOutputData.hashCode() + ((this.mState.hashCode() + (this.mId.hashCode() * 31)) * 31)) * 31)) * 31)) * 31) + this.mRunAttemptCount;
    }

    public String toString() {
        StringBuilder sbU = a.U("WorkInfo{mId='");
        sbU.append(this.mId);
        sbU.append('\'');
        sbU.append(", mState=");
        sbU.append(this.mState);
        sbU.append(", mOutputData=");
        sbU.append(this.mOutputData);
        sbU.append(", mTags=");
        sbU.append(this.mTags);
        sbU.append(", mProgress=");
        sbU.append(this.mProgress);
        sbU.append('}');
        return sbU.toString();
    }
}
