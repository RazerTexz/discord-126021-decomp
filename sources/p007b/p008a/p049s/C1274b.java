package p007b.p008a.p049s;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.core.app.NotificationCompat;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.chat.input.MentionUtilsKt;
import java.io.IOException;
import java.util.Locale;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12103t;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12139j;
import p507d0.p591y.C12201b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.s.b */
/* JADX INFO: compiled from: ScreenshotContentObserver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1274b extends ContentObserver {

    /* JADX INFO: renamed from: a */
    public static final a f1879a = new a(null);

    /* JADX INFO: renamed from: b */
    public String f1880b;

    /* JADX INFO: renamed from: c */
    public final Logger f1881c;

    /* JADX INFO: renamed from: d */
    public final ContentResolver f1882d;

    /* JADX INFO: renamed from: e */
    public final Clock f1883e;

    /* JADX INFO: renamed from: f */
    public final Function2<Uri, String, Unit> f1884f;

    /* JADX INFO: renamed from: b.a.s.b$a */
    /* JADX INFO: compiled from: ScreenshotContentObserver.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: b.a.s.b$b */
    /* JADX INFO: compiled from: ScreenshotContentObserver.kt */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final String f1885a;

        /* JADX INFO: renamed from: b */
        public final long f1886b;

        /* JADX INFO: renamed from: c */
        public final String f1887c;

        /* JADX INFO: renamed from: d */
        public final String f1888d;

        /* JADX INFO: renamed from: e */
        public final Uri f1889e;

        /* JADX INFO: renamed from: f */
        public final long f1890f;

        public b(long j, String str, String str2, Uri uri, long j2) {
            C12238m.checkNotNullParameter(str, "fileName");
            C12238m.checkNotNullParameter(str2, "relativePath");
            C12238m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            this.f1886b = j;
            this.f1887c = str;
            this.f1888d = str2;
            this.f1889e = uri;
            this.f1890f = j2;
            this.f1885a = str2 + MentionUtilsKt.SLASH_CHAR + str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f1886b == bVar.f1886b && C12238m.areEqual(this.f1887c, bVar.f1887c) && C12238m.areEqual(this.f1888d, bVar.f1888d) && C12238m.areEqual(this.f1889e, bVar.f1889e) && this.f1890f == bVar.f1890f;
        }

        public int hashCode() {
            int iM3a = C0002b.m3a(this.f1886b) * 31;
            String str = this.f1887c;
            int iHashCode = (iM3a + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f1888d;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Uri uri = this.f1889e;
            return C0002b.m3a(this.f1890f) + ((iHashCode2 + (uri != null ? uri.hashCode() : 0)) * 31);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ScreenshotData(id=");
            sbM833U.append(this.f1886b);
            sbM833U.append(", fileName=");
            sbM833U.append(this.f1887c);
            sbM833U.append(", relativePath=");
            sbM833U.append(this.f1888d);
            sbM833U.append(", uri=");
            sbM833U.append(this.f1889e);
            sbM833U.append(", dateAdded=");
            return C1643a.m815C(sbM833U, this.f1890f, ")");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1274b(Logger logger, ContentResolver contentResolver, Clock clock, Function2 function2, int i) {
        super(null);
        Clock clock2 = (i & 4) != 0 ? ClockFactory.get() : null;
        C12238m.checkNotNullParameter(logger, "logger");
        C12238m.checkNotNullParameter(contentResolver, "contentResolver");
        C12238m.checkNotNullParameter(clock2, "clock");
        C12238m.checkNotNullParameter(function2, "onScreenshot");
        this.f1881c = logger;
        this.f1882d = contentResolver;
        this.f1883e = clock2;
        this.f1884f = function2;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00bc  */
    /* JADX INFO: renamed from: a */
    public final void m365a(Uri uri) throws IOException {
        String strSubstringBeforeLast$default;
        b bVar;
        ContentResolver contentResolver = this.f1882d;
        int i = Build.VERSION.SDK_INT;
        Cursor cursorQuery = contentResolver.query(uri, (String[]) C12139j.plus(C12139j.plus(new String[]{"_display_name", "date_added", "_id"}, i >= 29 ? new String[]{"is_pending", "relative_path"} : new String[0]), i >= 29 ? new String[]{"relative_path"} : new String[]{"_data"}), null, null, "date_added DESC");
        if (cursorQuery != null) {
            try {
                if (!cursorQuery.moveToFirst()) {
                    C12201b.closeFinally(cursorQuery, null);
                } else if (i < 29 || cursorQuery.getInt(cursorQuery.getColumnIndex("is_pending")) != 1) {
                    if (i >= 29) {
                        strSubstringBeforeLast$default = cursorQuery.getString(cursorQuery.getColumnIndex("relative_path"));
                    } else {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                        C12238m.checkNotNullExpressionValue(string, "cursor.getString(cursor.…mages.ImageColumns.DATA))");
                        strSubstringBeforeLast$default = C12106w.substringBeforeLast$default(string, MentionUtilsKt.SLASH_CHAR, (String) null, 2, (Object) null);
                    }
                    long j = cursorQuery.getLong(cursorQuery.getColumnIndex("_id"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
                    C12238m.checkNotNullExpressionValue(string2, "cursor.getString(cursor.…ages.Media.DISPLAY_NAME))");
                    C12238m.checkNotNullExpressionValue(strSubstringBeforeLast$default, "relativePath");
                    bVar = new b(j, string2, strSubstringBeforeLast$default, uri, cursorQuery.getLong(cursorQuery.getColumnIndex("date_added")));
                    C12201b.closeFinally(cursorQuery, null);
                } else {
                    C12201b.closeFinally(cursorQuery, null);
                }
                bVar = null;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    C12201b.closeFinally(cursorQuery, th);
                    throw th2;
                }
            }
        } else {
            C12201b.closeFinally(cursorQuery, null);
            bVar = null;
        }
        if (bVar != null) {
            String str = this.f1880b;
            if (str == null || !C12103t.equals$default(str, bVar.f1885a, false, 2, null)) {
                String str2 = bVar.f1885a;
                Locale locale = Locale.getDefault();
                C12238m.checkNotNullExpressionValue(locale, "Locale.getDefault()");
                Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = str2.toLowerCase(locale);
                C12238m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (C12106w.contains$default((CharSequence) lowerCase, (CharSequence) "screenshots/", false, 2, (Object) null)) {
                    if (Math.abs((this.f1883e.currentTimeMillis() / ((long) 1000)) - bVar.f1890f) <= 10) {
                        this.f1880b = bVar.f1885a;
                        this.f1884f.invoke(bVar.f1889e, bVar.f1887c);
                    }
                }
            }
        }
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z2, Uri uri) {
        super.onChange(z2, uri);
        if (uri != null) {
            String string = uri.toString();
            C12238m.checkNotNullExpressionValue(string, "uri.toString()");
            String string2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();
            C12238m.checkNotNullExpressionValue(string2, "MediaStore.Images.Media.…AL_CONTENT_URI.toString()");
            if (C12103t.startsWith$default(string, string2, false, 2, null)) {
                try {
                    m365a(uri);
                } catch (Exception e) {
                    Logger.e$default(this.f1881c, "Error processing screenshot", e, null, 4, null);
                }
            }
        }
    }
}
