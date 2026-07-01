package androidx.work.impl.model;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: loaded from: classes.dex */
@Entity(foreignKeys = {@ForeignKey(childColumns = {"work_spec_id"}, entity = WorkSpec.class, onDelete = 5, onUpdate = 5, parentColumns = {ModelAuditLogEntry.CHANGE_KEY_ID})}, indices = {@Index({"work_spec_id"})}, primaryKeys = {ModelAuditLogEntry.CHANGE_KEY_NAME, "work_spec_id"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkName {

    @NonNull
    @ColumnInfo(name = ModelAuditLogEntry.CHANGE_KEY_NAME)
    public final String name;

    @NonNull
    @ColumnInfo(name = "work_spec_id")
    public final String workSpecId;

    public WorkName(@NonNull String str, @NonNull String str2) {
        this.name = str;
        this.workSpecId = str2;
    }
}
