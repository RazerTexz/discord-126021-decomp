package androidx.work.impl.model;

import android.database.Cursor;
import androidx.collection.ArrayMap;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.work.Data;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class WorkSpecDao_Impl$10 implements Callable<List<WorkSpec$WorkInfoPojo>> {
    public final /* synthetic */ WorkSpecDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public WorkSpecDao_Impl$10(WorkSpecDao_Impl workSpecDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = workSpecDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ List<WorkSpec$WorkInfoPojo> call() throws Exception {
        return call2();
    }

    public void finalize() {
        this.val$_statement.release();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public List<WorkSpec$WorkInfoPojo> call2() throws Exception {
        WorkSpecDao_Impl.access$000(this.this$0).beginTransaction();
        try {
            Cursor cursorQuery = DBUtil.query(WorkSpecDao_Impl.access$000(this.this$0), this.val$_statement, true, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, ModelAuditLogEntry.CHANGE_KEY_ID);
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "output");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_attempt_count");
                ArrayMap arrayMap = new ArrayMap();
                ArrayMap arrayMap2 = new ArrayMap();
                while (cursorQuery.moveToNext()) {
                    if (!cursorQuery.isNull(columnIndexOrThrow)) {
                        String string = cursorQuery.getString(columnIndexOrThrow);
                        if (((ArrayList) arrayMap.get(string)) == null) {
                            arrayMap.put(string, new ArrayList());
                        }
                    }
                    if (!cursorQuery.isNull(columnIndexOrThrow)) {
                        String string2 = cursorQuery.getString(columnIndexOrThrow);
                        if (((ArrayList) arrayMap2.get(string2)) == null) {
                            arrayMap2.put(string2, new ArrayList());
                        }
                    }
                }
                cursorQuery.moveToPosition(-1);
                WorkSpecDao_Impl.access$100(this.this$0, arrayMap);
                WorkSpecDao_Impl.access$200(this.this$0, arrayMap2);
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    ArrayList arrayList2 = !cursorQuery.isNull(columnIndexOrThrow) ? (ArrayList) arrayMap.get(cursorQuery.getString(columnIndexOrThrow)) : null;
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    ArrayList arrayList3 = !cursorQuery.isNull(columnIndexOrThrow) ? (ArrayList) arrayMap2.get(cursorQuery.getString(columnIndexOrThrow)) : null;
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                    }
                    WorkSpec$WorkInfoPojo workSpec$WorkInfoPojo = new WorkSpec$WorkInfoPojo();
                    workSpec$WorkInfoPojo.f40id = cursorQuery.getString(columnIndexOrThrow);
                    workSpec$WorkInfoPojo.state = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                    workSpec$WorkInfoPojo.output = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow3));
                    workSpec$WorkInfoPojo.runAttemptCount = cursorQuery.getInt(columnIndexOrThrow4);
                    workSpec$WorkInfoPojo.tags = arrayList2;
                    workSpec$WorkInfoPojo.progress = arrayList3;
                    arrayList.add(workSpec$WorkInfoPojo);
                }
                WorkSpecDao_Impl.access$000(this.this$0).setTransactionSuccessful();
                cursorQuery.close();
                WorkSpecDao_Impl.access$000(this.this$0).endTransaction();
                return arrayList;
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        } catch (Throwable th2) {
            WorkSpecDao_Impl.access$000(this.this$0).endTransaction();
            throw th2;
        }
    }
}
