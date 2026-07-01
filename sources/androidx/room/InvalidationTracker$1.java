package androidx.room;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Set;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
public class InvalidationTracker$1 implements Runnable {
    public final /* synthetic */ InvalidationTracker this$0;

    public InvalidationTracker$1(InvalidationTracker invalidationTracker) {
        this.this$0 = invalidationTracker;
    }

    private Set<Integer> checkUpdatedTable() {
        HashSet hashSet = new HashSet();
        Cursor cursorQuery = this.this$0.mDatabase.query(new SimpleSQLiteQuery(InvalidationTracker.SELECT_UPDATED_TABLES_SQL));
        while (cursorQuery.moveToNext()) {
            try {
                hashSet.add(Integer.valueOf(cursorQuery.getInt(0)));
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }
        cursorQuery.close();
        if (!hashSet.isEmpty()) {
            this.this$0.mCleanupStatement.executeUpdateDelete();
        }
        return hashSet;
    }

    @Override // java.lang.Runnable
    public void run() {
        Lock closeLock = this.this$0.mDatabase.getCloseLock();
        Set<Integer> setCheckUpdatedTable = null;
        try {
            try {
                closeLock.lock();
                if (!this.this$0.ensureInitialization()) {
                    closeLock.unlock();
                    return;
                }
                if (!this.this$0.mPendingRefresh.compareAndSet(true, false)) {
                    closeLock.unlock();
                    return;
                }
                if (this.this$0.mDatabase.inTransaction()) {
                    closeLock.unlock();
                    return;
                }
                RoomDatabase roomDatabase = this.this$0.mDatabase;
                if (roomDatabase.mWriteAheadLoggingEnabled) {
                    SupportSQLiteDatabase writableDatabase = roomDatabase.getOpenHelper().getWritableDatabase();
                    writableDatabase.beginTransaction();
                    try {
                        setCheckUpdatedTable = checkUpdatedTable();
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                } else {
                    setCheckUpdatedTable = checkUpdatedTable();
                }
                closeLock.unlock();
                if (setCheckUpdatedTable == null || setCheckUpdatedTable.isEmpty()) {
                    return;
                }
                synchronized (this.this$0.mObserverMap) {
                    Iterator<Map$Entry<InvalidationTracker$Observer, InvalidationTracker$ObserverWrapper>> it = this.this$0.mObserverMap.iterator();
                    while (it.hasNext()) {
                        it.next().getValue().notifyByTableInvalidStatus(setCheckUpdatedTable);
                    }
                }
            } catch (Throwable th2) {
                closeLock.unlock();
                throw th2;
            }
        } catch (SQLiteException | IllegalStateException e) {
            Log.e(Room.LOG_TAG, "Cannot run invalidation tracker. Is the db closed?", e);
        }
    }
}
