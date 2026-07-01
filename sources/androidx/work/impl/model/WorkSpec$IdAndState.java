package androidx.work.impl.model;

import androidx.room.ColumnInfo;
import androidx.work.WorkInfo$State;
import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: loaded from: classes.dex */
public class WorkSpec$IdAndState {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @ColumnInfo(name = ModelAuditLogEntry.CHANGE_KEY_ID)
    public String f39id;

    @ColumnInfo(name = "state")
    public WorkInfo$State state;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WorkSpec$IdAndState)) {
            return false;
        }
        WorkSpec$IdAndState workSpec$IdAndState = (WorkSpec$IdAndState) obj;
        if (this.state != workSpec$IdAndState.state) {
            return false;
        }
        return this.f39id.equals(workSpec$IdAndState.f39id);
    }

    public int hashCode() {
        return this.state.hashCode() + (this.f39id.hashCode() * 31);
    }
}
