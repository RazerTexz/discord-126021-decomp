package com.discord.utilities.file;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.DrawableRes;
import androidx.core.app.NotificationCompat;
import androidx.core.net.UriKt;
import com.discord.C5419R;
import com.discord.utilities.drawable.DrawableCompat;
import org.webrtc.MediaStreamTrack;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12103t;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: FileUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FileUtilsKt {
    public static final Long getFileSizeBytes(Context context, Uri uri) {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        if (Build.VERSION.SDK_INT < 26) {
            try {
                return Long.valueOf(UriKt.toFile(uri).length());
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        Cursor cursorQuery = context.getContentResolver().query(uri, null, null, null);
        if (cursorQuery != null) {
            cursorQuery.moveToFirst();
        }
        Long lValueOf = cursorQuery != null ? Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex("_size"))) : null;
        if (cursorQuery == null) {
            return lValueOf;
        }
        cursorQuery.close();
        return lValueOf;
    }

    private static final String getHumanReadableByteCount(long j) {
        if (j < 1024) {
            return j + " B";
        }
        double d = j;
        double d2 = 1024;
        int iLog = (int) (Math.log(d) / Math.log(d2));
        return C1643a.m828P(new Object[]{Double.valueOf(d / Math.pow(d2, iLog)), Character.valueOf("KMGTPE".charAt(iLog - 1))}, 2, "%.1f %sB", "java.lang.String.format(format, *args)");
    }

    @DrawableRes
    public static final int getIconForFiletype(Context context, String str) {
        int i;
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(str, "mimeType");
        if (C12103t.startsWith$default(str, "image", false, 2, null)) {
            i = C5419R.attr.ic_uploads_image;
        } else {
            i = C12103t.startsWith$default(str, MediaStreamTrack.VIDEO_TRACK_KIND, false, 2, null) ? C5419R.attr.ic_uploads_video : C5419R.attr.ic_uploads_file;
        }
        return DrawableCompat.getThemedDrawableRes$default(context, i, 0, 2, (Object) null);
    }

    public static final String getSizeSubtitle(long j) {
        if (j != -1) {
            return getHumanReadableByteCount(j);
        }
        return null;
    }
}
