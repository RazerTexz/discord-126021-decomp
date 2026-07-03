package androidx.room.util;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.sqlite.p006db.SupportSQLiteDatabase;
import androidx.sqlite.p006db.SupportSQLiteQuery;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class DBUtil {
    private DBUtil() {
    }

    @Nullable
    public static CancellationSignal createCancellationSignal() {
        return new CancellationSignal();
    }

    public static void dropFtsSyncTriggers(SupportSQLiteDatabase supportSQLiteDatabase) {
        ArrayList<String> arrayList = new ArrayList();
        Cursor cursorQuery = supportSQLiteDatabase.query("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (cursorQuery.moveToNext()) {
            try {
                arrayList.add(cursorQuery.getString(0));
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }
        cursorQuery.close();
        for (String str : arrayList) {
            if (str.startsWith("room_fts_content_sync_")) {
                supportSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS " + str);
            }
        }
    }

    @NonNull
    @Deprecated
    public static Cursor query(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, boolean z2) {
        return query(roomDatabase, supportSQLiteQuery, z2, null);
    }

    public static int readVersion(@NonNull File file) throws IOException {
        FileChannel fileChannel = null;
        try {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            FileChannel channel = new FileInputStream(file).getChannel();
            channel.tryLock(60L, 4L, true);
            channel.position(60L);
            if (channel.read(byteBufferAllocate) != 4) {
                throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
            }
            byteBufferAllocate.rewind();
            int i = byteBufferAllocate.getInt();
            channel.close();
            return i;
        } catch (Throwable th) {
            if (0 != 0) {
                fileChannel.close();
            }
            throw th;
        }
    }

    @NonNull
    public static Cursor query(@NonNull RoomDatabase roomDatabase, @NonNull SupportSQLiteQuery supportSQLiteQuery, boolean z2, @Nullable CancellationSignal cancellationSignal) {
        Cursor cursorQuery = roomDatabase.query(supportSQLiteQuery, cancellationSignal);
        if (!z2 || !(cursorQuery instanceof AbstractWindowedCursor)) {
            return cursorQuery;
        }
        AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) cursorQuery;
        int count = abstractWindowedCursor.getCount();
        return (Build.VERSION.SDK_INT < 23 || (abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count) ? CursorUtil.copyAndClose(abstractWindowedCursor) : cursorQuery;
    }
}
