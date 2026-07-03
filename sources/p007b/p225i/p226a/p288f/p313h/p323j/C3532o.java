package p007b.p225i.p226a.p288f.p313h.p323j;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildWelcomeKt;
import java.io.Closeable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p291b.C3180f;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;
import p007b.p225i.p226a.p288f.p299e.p308o.C3403e;

/* JADX INFO: renamed from: b.i.a.f.h.j.o */
/* JADX INFO: loaded from: classes3.dex */
public final class C3532o extends AbstractC3509e implements Closeable {

    /* JADX INFO: renamed from: l */
    public static final String f9768l = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", "hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id");

    /* JADX INFO: renamed from: m */
    public static final String f9769m = String.format("SELECT MAX(%s) FROM %s WHERE 1;", "hit_time", "hits2");

    /* JADX INFO: renamed from: n */
    public final C3534p f9770n;

    /* JADX INFO: renamed from: o */
    public final C3553y0 f9771o;

    /* JADX INFO: renamed from: p */
    public final C3553y0 f9772p;

    public C3532o(C3515g c3515g) {
        super(c3515g);
        this.f9771o = new C3553y0(this.f9684j.f9724d);
        this.f9772p = new C3553y0(this.f9684j.f9724d);
        this.f9770n = new C3534p(this, c3515g.f9722b, "google_analytics_v4.db");
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p323j.AbstractC3509e
    /* JADX INFO: renamed from: L */
    public final void mo4414L() {
    }

    /* JADX INFO: renamed from: O */
    public final SQLiteDatabase m4468O() {
        try {
            return this.f9770n.getWritableDatabase();
        } catch (SQLiteException e) {
            m4439x("Error opening database", e);
            throw e;
        }
    }

    /* JADX INFO: renamed from: R */
    public final boolean m4469R() {
        C3180f.m3967b();
        m4444N();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = m4468O().rawQuery("SELECT COUNT(*) FROM hits2", null);
                if (!cursorRawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j == 0;
            } catch (SQLiteException e) {
                m4440y("Database error", "SELECT COUNT(*) FROM hits2", e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: S */
    public final void m4470S(List<Long> list) {
        C3180f.m3967b();
        m4444N();
        if (list.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder("hit_id");
        sb.append(" in (");
        for (int i = 0; i < list.size(); i++) {
            Long l = list.get(i);
            if (l == null || l.longValue() == 0) {
                throw new SQLiteException("Invalid hit id");
            }
            if (i > 0) {
                sb.append(",");
            }
            sb.append(l);
        }
        sb.append(")");
        String string = sb.toString();
        try {
            SQLiteDatabase sQLiteDatabaseM4468O = m4468O();
            m4431b("Deleting dispatched hits. count", Integer.valueOf(list.size()));
            int iDelete = sQLiteDatabaseM4468O.delete("hits2", string, null);
            if (iDelete != list.size()) {
                m4430a(5, "Deleted fewer hits then expected", Integer.valueOf(list.size()), Integer.valueOf(iDelete), string);
            }
        } catch (SQLiteException e) {
            m4426A("Error deleting hits", e);
            throw e;
        }
    }

    /* JADX INFO: renamed from: T */
    public final List<C3523j0> m4471T(long j) {
        C1460d.m539l(j >= 0);
        C3180f.m3967b();
        m4444N();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = m4468O().query("hits2", new String[]{"hit_id", "hit_time", "hit_string", "hit_url", "hit_app_id"}, null, null, null, null, String.format("%s ASC", "hit_id"), Long.toString(j));
                ArrayList arrayList = new ArrayList();
                if (cursorQuery.moveToFirst()) {
                    do {
                        long j2 = cursorQuery.getLong(0);
                        long j3 = cursorQuery.getLong(1);
                        String string = cursorQuery.getString(2);
                        String string2 = cursorQuery.getString(3);
                        arrayList.add(new C3523j0(this, m4475X(string), j3, TextUtils.isEmpty(string2) || !string2.startsWith("http:"), j2, cursorQuery.getInt(4)));
                    } while (cursorQuery.moveToNext());
                }
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e) {
                m4426A("Error loading hits from the database", e);
                throw e;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: U */
    public final int m4472U() {
        C3180f.m3967b();
        m4444N();
        if (!this.f9771o.m4507b(86400000L)) {
            return 0;
        }
        this.f9771o.m4506a();
        m4427C("Deleting stale hits (if any)");
        SQLiteDatabase sQLiteDatabaseM4468O = m4468O();
        Objects.requireNonNull((C3401c) this.f9684j.f9724d);
        int iDelete = sQLiteDatabaseM4468O.delete("hits2", "hit_time < ?", new String[]{Long.toString(System.currentTimeMillis() - WidgetChatListAdapterItemGuildWelcomeKt.OLD_GUILD_AGE_THRESHOLD)});
        m4431b("Deleted stale hits, count", Integer.valueOf(iDelete));
        return iDelete;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0026 */
    /* JADX INFO: renamed from: V */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long m4473V() {
        C3180f.m3967b();
        m4444N();
        String str = f9769m;
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = m4468O().rawQuery(str, null);
            if (!cursorRawQuery.moveToFirst()) {
                cursorRawQuery.close();
                return 0L;
            }
            long j = cursorRawQuery.getLong(0);
            cursorRawQuery.close();
            return j;
        } catch (SQLiteException e) {
            m4440y("Database error", str, e);
            throw e;
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        throw th;
    }

    /* JADX INFO: renamed from: W */
    public final void m4474W(long j) {
        C3180f.m3967b();
        m4444N();
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Long.valueOf(j));
        m4431b("Deleting hit, id", Long.valueOf(j));
        m4470S(arrayList);
    }

    /* JADX INFO: renamed from: X */
    public final Map<String, String> m4475X(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            if (!str.startsWith("?")) {
                str = str.length() != 0 ? "?".concat(str) : new String("?");
            }
            return C3403e.m4188a(new URI(str), Constants.ENCODING);
        } catch (URISyntaxException e) {
            m4426A("Error parsing hit parameters", e);
            return new HashMap(0);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            this.f9770n.close();
        } catch (SQLiteException e) {
            m4426A("Sql error closing database", e);
        } catch (IllegalStateException e2) {
            m4426A("Error closing database", e2);
        }
    }

    public final void endTransaction() {
        m4444N();
        m4468O().endTransaction();
    }

    public final void setTransactionSuccessful() {
        m4444N();
        m4468O().setTransactionSuccessful();
    }
}
