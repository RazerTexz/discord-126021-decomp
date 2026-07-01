package androidx.work.impl.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Relation;
import androidx.work.Data;
import androidx.work.WorkInfo;
import androidx.work.WorkInfo$State;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class WorkSpec$WorkInfoPojo {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @ColumnInfo(name = ModelAuditLogEntry.CHANGE_KEY_ID)
    public String f40id;

    @ColumnInfo(name = "output")
    public Data output;

    @Relation(entity = WorkProgress.class, entityColumn = "work_spec_id", parentColumn = ModelAuditLogEntry.CHANGE_KEY_ID, projection = {"progress"})
    public List<Data> progress;

    @ColumnInfo(name = "run_attempt_count")
    public int runAttemptCount;

    @ColumnInfo(name = "state")
    public WorkInfo$State state;

    @Relation(entity = WorkTag.class, entityColumn = "work_spec_id", parentColumn = ModelAuditLogEntry.CHANGE_KEY_ID, projection = {"tag"})
    public List<String> tags;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WorkSpec$WorkInfoPojo)) {
            return false;
        }
        WorkSpec$WorkInfoPojo workSpec$WorkInfoPojo = (WorkSpec$WorkInfoPojo) obj;
        if (this.runAttemptCount != workSpec$WorkInfoPojo.runAttemptCount) {
            return false;
        }
        String str = this.f40id;
        if (str == null ? workSpec$WorkInfoPojo.f40id != null : !str.equals(workSpec$WorkInfoPojo.f40id)) {
            return false;
        }
        if (this.state != workSpec$WorkInfoPojo.state) {
            return false;
        }
        Data data = this.output;
        if (data == null ? workSpec$WorkInfoPojo.output != null : !data.equals(workSpec$WorkInfoPojo.output)) {
            return false;
        }
        List<String> list = this.tags;
        if (list == null ? workSpec$WorkInfoPojo.tags != null : !list.equals(workSpec$WorkInfoPojo.tags)) {
            return false;
        }
        List<Data> list2 = this.progress;
        List<Data> list3 = workSpec$WorkInfoPojo.progress;
        if (list2 != null) {
            return list2.equals(list3);
        }
        return list3 == null;
    }

    public int hashCode() {
        String str = this.f40id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        WorkInfo$State workInfo$State = this.state;
        int iHashCode2 = (iHashCode + (workInfo$State != null ? workInfo$State.hashCode() : 0)) * 31;
        Data data = this.output;
        int iHashCode3 = (((iHashCode2 + (data != null ? data.hashCode() : 0)) * 31) + this.runAttemptCount) * 31;
        List<String> list = this.tags;
        int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        List<Data> list2 = this.progress;
        return iHashCode4 + (list2 != null ? list2.hashCode() : 0);
    }

    @NonNull
    public WorkInfo toWorkInfo() {
        List<Data> list = this.progress;
        return new WorkInfo(UUID.fromString(this.f40id), this.state, this.output, this.tags, (list == null || list.isEmpty()) ? Data.EMPTY : this.progress.get(0), this.runAttemptCount);
    }
}
