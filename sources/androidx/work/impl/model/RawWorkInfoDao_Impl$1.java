package androidx.work.impl.model;

import android.database.Cursor;
import androidx.collection.ArrayMap;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.Data;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class RawWorkInfoDao_Impl$1 implements Callable<List<WorkSpec$WorkInfoPojo>> {
    public final /* synthetic */ RawWorkInfoDao_Impl this$0;
    public final /* synthetic */ SupportSQLiteQuery val$_internalQuery;

    public RawWorkInfoDao_Impl$1(RawWorkInfoDao_Impl rawWorkInfoDao_Impl, SupportSQLiteQuery supportSQLiteQuery) {
        this.this$0 = rawWorkInfoDao_Impl;
        this.val$_internalQuery = supportSQLiteQuery;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ List<WorkSpec$WorkInfoPojo> call() throws Exception {
        return call2();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public List<WorkSpec$WorkInfoPojo> call2() throws Exception {
        Cursor cursorQuery = DBUtil.query(RawWorkInfoDao_Impl.access$000(this.this$0), this.val$_internalQuery, true, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(cursorQuery, ModelAuditLogEntry.CHANGE_KEY_ID);
            int columnIndex2 = CursorUtil.getColumnIndex(cursorQuery, "state");
            int columnIndex3 = CursorUtil.getColumnIndex(cursorQuery, "output");
            int columnIndex4 = CursorUtil.getColumnIndex(cursorQuery, "run_attempt_count");
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            while (cursorQuery.moveToNext()) {
                if (!cursorQuery.isNull(columnIndex)) {
                    String string = cursorQuery.getString(columnIndex);
                    if (((ArrayList) arrayMap.get(string)) == null) {
                        arrayMap.put(string, new ArrayList());
                    }
                }
                if (!cursorQuery.isNull(columnIndex)) {
                    String string2 = cursorQuery.getString(columnIndex);
                    if (((ArrayList) arrayMap2.get(string2)) == null) {
                        arrayMap2.put(string2, new ArrayList());
                    }
                }
            }
            cursorQuery.moveToPosition(-1);
            RawWorkInfoDao_Impl.access$100(this.this$0, arrayMap);
            RawWorkInfoDao_Impl.access$200(this.this$0, arrayMap2);
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                ArrayList arrayList2 = !cursorQuery.isNull(columnIndex) ? (ArrayList) arrayMap.get(cursorQuery.getString(columnIndex)) : null;
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                ArrayList arrayList3 = !cursorQuery.isNull(columnIndex) ? (ArrayList) arrayMap2.get(cursorQuery.getString(columnIndex)) : null;
                if (arrayList3 == null) {
                    arrayList3 = new ArrayList();
                }
                WorkSpec$WorkInfoPojo workSpec$WorkInfoPojo = new WorkSpec$WorkInfoPojo();
                if (columnIndex != -1) {
                    workSpec$WorkInfoPojo.f40id = cursorQuery.getString(columnIndex);
                }
                if (columnIndex2 != -1) {
                    workSpec$WorkInfoPojo.state = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndex2));
                }
                if (columnIndex3 != -1) {
                    workSpec$WorkInfoPojo.output = Data.fromByteArray(cursorQuery.getBlob(columnIndex3));
                }
                if (columnIndex4 != -1) {
                    workSpec$WorkInfoPojo.runAttemptCount = cursorQuery.getInt(columnIndex4);
                }
                workSpec$WorkInfoPojo.tags = arrayList2;
                workSpec$WorkInfoPojo.progress = arrayList3;
                arrayList.add(workSpec$WorkInfoPojo);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
        }
    }
}
