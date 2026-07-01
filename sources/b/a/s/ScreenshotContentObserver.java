package b.a.s;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.chat.input.MentionUtils;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t._ArraysJvm;
import d0.y.Closeable;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.Locale;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: b.a.s.b, reason: use source file name */
/* JADX INFO: compiled from: ScreenshotContentObserver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ScreenshotContentObserver extends ContentObserver {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f285b;
    public final Logger c;
    public final ContentResolver d;
    public final Clock e;
    public final Function2<Uri, String, Unit> f;

    /* JADX INFO: renamed from: b.a.s.b$a */
    /* JADX INFO: compiled from: ScreenshotContentObserver.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: b.a.s.b$b */
    /* JADX INFO: compiled from: ScreenshotContentObserver.kt */
    public static final class b {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f286b;
        public final String c;
        public final String d;
        public final Uri e;
        public final long f;

        public b(long j, String str, String str2, Uri uri, long j2) {
            Intrinsics3.checkNotNullParameter(str, "fileName");
            Intrinsics3.checkNotNullParameter(str2, "relativePath");
            Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            this.f286b = j;
            this.c = str;
            this.d = str2;
            this.e = uri;
            this.f = j2;
            this.a = str2 + MentionUtils.SLASH_CHAR + str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f286b == bVar.f286b && Intrinsics3.areEqual(this.c, bVar.c) && Intrinsics3.areEqual(this.d, bVar.d) && Intrinsics3.areEqual(this.e, bVar.e) && this.f == bVar.f;
        }

        public int hashCode() {
            int iA = a0.a.a.b.a(this.f286b) * 31;
            String str = this.c;
            int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.d;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Uri uri = this.e;
            return a0.a.a.b.a(this.f) + ((iHashCode2 + (uri != null ? uri.hashCode() : 0)) * 31);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ScreenshotData(id=");
            sbU.append(this.f286b);
            sbU.append(", fileName=");
            sbU.append(this.c);
            sbU.append(", relativePath=");
            sbU.append(this.d);
            sbU.append(", uri=");
            sbU.append(this.e);
            sbU.append(", dateAdded=");
            return outline.C(sbU, this.f, ")");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenshotContentObserver(Logger logger, ContentResolver contentResolver, Clock clock, Function2 function2, int i) {
        super(null);
        Clock clock2 = (i & 4) != 0 ? ClockFactory.get() : null;
        Intrinsics3.checkNotNullParameter(logger, "logger");
        Intrinsics3.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics3.checkNotNullParameter(clock2, "clock");
        Intrinsics3.checkNotNullParameter(function2, "onScreenshot");
        this.c = logger;
        this.d = contentResolver;
        this.e = clock2;
        this.f = function2;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00bc  */
    public final void a(Uri uri) throws IOException {
        String strSubstringBeforeLast$default;
        b bVar;
        ContentResolver contentResolver = this.d;
        int i = Build.VERSION.SDK_INT;
        Cursor cursorQuery = contentResolver.query(uri, (String[]) _ArraysJvm.plus(_ArraysJvm.plus(new String[]{"_display_name", "date_added", "_id"}, i >= 29 ? new String[]{"is_pending", "relative_path"} : new String[0]), i >= 29 ? new String[]{"relative_path"} : new String[]{"_data"}), null, null, "date_added DESC");
        if (cursorQuery != null) {
            try {
                if (!cursorQuery.moveToFirst()) {
                    Closeable.closeFinally(cursorQuery, null);
                } else if (i < 29 || cursorQuery.getInt(cursorQuery.getColumnIndex("is_pending")) != 1) {
                    if (i >= 29) {
                        strSubstringBeforeLast$default = cursorQuery.getString(cursorQuery.getColumnIndex("relative_path"));
                    } else {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                        Intrinsics3.checkNotNullExpressionValue(string, "cursor.getString(cursor.…mages.ImageColumns.DATA))");
                        strSubstringBeforeLast$default = Strings4.substringBeforeLast$default(string, MentionUtils.SLASH_CHAR, (String) null, 2, (Object) null);
                    }
                    long j = cursorQuery.getLong(cursorQuery.getColumnIndex("_id"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
                    Intrinsics3.checkNotNullExpressionValue(string2, "cursor.getString(cursor.…ages.Media.DISPLAY_NAME))");
                    Intrinsics3.checkNotNullExpressionValue(strSubstringBeforeLast$default, "relativePath");
                    bVar = new b(j, string2, strSubstringBeforeLast$default, uri, cursorQuery.getLong(cursorQuery.getColumnIndex("date_added")));
                    Closeable.closeFinally(cursorQuery, null);
                } else {
                    Closeable.closeFinally(cursorQuery, null);
                }
                bVar = null;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    Closeable.closeFinally(cursorQuery, th);
                    throw th2;
                }
            }
        } else {
            Closeable.closeFinally(cursorQuery, null);
            bVar = null;
        }
        if (bVar != null) {
            String str = this.f285b;
            if (str == null || !StringsJVM.equals$default(str, bVar.a, false, 2, null)) {
                String str2 = bVar.a;
                Locale locale = Locale.getDefault();
                Intrinsics3.checkNotNullExpressionValue(locale, "Locale.getDefault()");
                Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = str2.toLowerCase(locale);
                Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (Strings4.contains$default((CharSequence) lowerCase, (CharSequence) "screenshots/", false, 2, (Object) null)) {
                    if (Math.abs((this.e.currentTimeMillis() / ((long) 1000)) - bVar.f) <= 10) {
                        this.f285b = bVar.a;
                        this.f.invoke(bVar.e, bVar.c);
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
            Intrinsics3.checkNotNullExpressionValue(string, "uri.toString()");
            String string2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();
            Intrinsics3.checkNotNullExpressionValue(string2, "MediaStore.Images.Media.…AL_CONTENT_URI.toString()");
            if (StringsJVM.startsWith$default(string, string2, false, 2, null)) {
                try {
                    a(uri);
                } catch (Exception e) {
                    Logger.e$default(this.c, "Error processing screenshot", e, null, 4, null);
                }
            }
        }
    }
}
