package androidx.work;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import p007b.p100d.p104b.p105a.C1643a;

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
    private State mState;

    @NonNull
    private Set<String> mTags;

    public enum State {
        ENQUEUED,
        RUNNING,
        SUCCEEDED,
        FAILED,
        BLOCKED,
        CANCELLED;

        public boolean isFinished() {
            return this == SUCCEEDED || this == FAILED || this == CANCELLED;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkInfo(@NonNull UUID uuid, @NonNull State state, @NonNull Data data, @NonNull List<String> list, @NonNull Data data2, int i) {
        this.mId = uuid;
        this.mState = state;
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
    public State getState() {
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
        StringBuilder sbM833U = C1643a.m833U("WorkInfo{mId='");
        sbM833U.append(this.mId);
        sbM833U.append('\'');
        sbM833U.append(", mState=");
        sbM833U.append(this.mState);
        sbM833U.append(", mOutputData=");
        sbM833U.append(this.mOutputData);
        sbM833U.append(", mTags=");
        sbM833U.append(this.mTags);
        sbM833U.append(", mProgress=");
        sbM833U.append(this.mProgress);
        sbM833U.append('}');
        return sbM833U.toString();
    }
}
