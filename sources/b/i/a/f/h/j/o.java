package b.i.a.f.h.j;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import b.c.a.a0.AnimatableValueParser;
import com.adjust.sdk.Constants;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildWelcome2;
import java.io.Closeable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends e implements Closeable {
    public static final String l = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", "hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id");
    public static final String m = String.format("SELECT MAX(%s) FROM %s WHERE 1;", "hit_time", "hits2");
    public final p n;
    public final y0 o;
    public final y0 p;

    public o(g gVar) {
        super(gVar);
        this.o = new y0(this.j.d);
        this.p = new y0(this.j.d);
        this.n = new p(this, gVar.f1417b, "google_analytics_v4.db");
    }

    @Override // b.i.a.f.h.j.e
    public final void L() {
    }

    public final SQLiteDatabase O() {
        try {
            return this.n.getWritableDatabase();
        } catch (SQLiteException e) {
            x("Error opening database", e);
            throw e;
        }
    }

    public final boolean R() {
        b.i.a.f.b.f.b();
        N();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = O().rawQuery("SELECT COUNT(*) FROM hits2", null);
                if (!cursorRawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j == 0;
            } catch (SQLiteException e) {
                y("Database error", "SELECT COUNT(*) FROM hits2", e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void S(List<Long> list) {
        b.i.a.f.b.f.b();
        N();
        if (list.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder("hit_id");
        sb.append(" in (");
        for (int i = 0; i < list.size(); i++) {
            Long l2 = list.get(i);
            if (l2 == null || l2.longValue() == 0) {
                throw new SQLiteException("Invalid hit id");
            }
            if (i > 0) {
                sb.append(",");
            }
            sb.append(l2);
        }
        sb.append(")");
        String string = sb.toString();
        try {
            SQLiteDatabase sQLiteDatabaseO = O();
            b("Deleting dispatched hits. count", Integer.valueOf(list.size()));
            int iDelete = sQLiteDatabaseO.delete("hits2", string, null);
            if (iDelete != list.size()) {
                a(5, "Deleted fewer hits then expected", Integer.valueOf(list.size()), Integer.valueOf(iDelete), string);
            }
        } catch (SQLiteException e) {
            A("Error deleting hits", e);
            throw e;
        }
    }

    public final List<j0> T(long j) {
        AnimatableValueParser.l(j >= 0);
        b.i.a.f.b.f.b();
        N();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = O().query("hits2", new String[]{"hit_id", "hit_time", "hit_string", "hit_url", "hit_app_id"}, null, null, null, null, String.format("%s ASC", "hit_id"), Long.toString(j));
                ArrayList arrayList = new ArrayList();
                if (cursorQuery.moveToFirst()) {
                    do {
                        long j2 = cursorQuery.getLong(0);
                        long j3 = cursorQuery.getLong(1);
                        String string = cursorQuery.getString(2);
                        String string2 = cursorQuery.getString(3);
                        arrayList.add(new j0(this, X(string), j3, TextUtils.isEmpty(string2) || !string2.startsWith("http:"), j2, cursorQuery.getInt(4)));
                    } while (cursorQuery.moveToNext());
                }
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e) {
                A("Error loading hits from the database", e);
                throw e;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public final int U() {
        b.i.a.f.b.f.b();
        N();
        if (!this.o.b(86400000L)) {
            return 0;
        }
        this.o.a();
        C("Deleting stale hits (if any)");
        SQLiteDatabase sQLiteDatabaseO = O();
        Objects.requireNonNull((b.i.a.f.e.o.c) this.j.d);
        int iDelete = sQLiteDatabaseO.delete("hits2", "hit_time < ?", new String[]{Long.toString(System.currentTimeMillis() - WidgetChatListAdapterItemGuildWelcome2.OLD_GUILD_AGE_THRESHOLD)});
        b("Deleted stale hits, count", Integer.valueOf(iDelete));
        return iDelete;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0026 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long V() {
        b.i.a.f.b.f.b();
        N();
        String str = m;
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = O().rawQuery(str, null);
            if (!cursorRawQuery.moveToFirst()) {
                cursorRawQuery.close();
                return 0L;
            }
            long j = cursorRawQuery.getLong(0);
            cursorRawQuery.close();
            return j;
        } catch (SQLiteException e) {
            y("Database error", str, e);
            throw e;
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        throw th;
    }

    public final void W(long j) {
        b.i.a.f.b.f.b();
        N();
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Long.valueOf(j));
        b("Deleting hit, id", Long.valueOf(j));
        S(arrayList);
    }

    public final Map<String, String> X(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            if (!str.startsWith("?")) {
                str = str.length() != 0 ? "?".concat(str) : new String("?");
            }
            return b.i.a.f.e.o.e.a(new URI(str), Constants.ENCODING);
        } catch (URISyntaxException e) {
            A("Error parsing hit parameters", e);
            return new HashMap(0);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            this.n.close();
        } catch (SQLiteException e) {
            A("Sql error closing database", e);
        } catch (IllegalStateException e2) {
            A("Error closing database", e2);
        }
    }

    public final void endTransaction() {
        N();
        O().endTransaction();
    }

    public final void setTransactionSuccessful() {
        N();
        O().setTransactionSuccessful();
    }
}
