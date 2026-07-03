package com.discord.utilities.rest;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.core.app.NotificationCompat;
import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import p507d0.p591y.C12201b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: SendUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SendUtilsKt {
    public static final long computeFileSizeBytes(Uri uri, ContentResolver contentResolver) {
        long jLongValue;
        Long lValueOf;
        C12238m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        C12238m.checkNotNullParameter(contentResolver, "contentResolver");
        try {
            Cursor cursorQuery = contentResolver.query(uri, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    int columnIndex = cursorQuery.getColumnIndex("_size");
                    cursorQuery.moveToFirst();
                    lValueOf = Long.valueOf(cursorQuery.getLong(columnIndex));
                } catch (Exception unused) {
                    jLongValue = -1;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        C12201b.closeFinally(cursorQuery, th);
                        throw th2;
                    }
                }
            } else {
                lValueOf = null;
            }
            if (lValueOf != null && lValueOf.longValue() > 0) {
                jLongValue = lValueOf.longValue();
                C12201b.closeFinally(cursorQuery, null);
                return jLongValue;
            }
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(uri, "r");
            Long lValueOf2 = parcelFileDescriptorOpenFileDescriptor != null ? Long.valueOf(parcelFileDescriptorOpenFileDescriptor.getStatSize()) : null;
            if (parcelFileDescriptorOpenFileDescriptor != null) {
                parcelFileDescriptorOpenFileDescriptor.close();
            }
            long jLongValue2 = lValueOf2 != null ? lValueOf2.longValue() : -1L;
            C12201b.closeFinally(cursorQuery, null);
            return jLongValue2;
        } catch (Exception e) {
            Logger.e$default(AppLog.f14950g, "Failed querying size of file " + uri, e, null, 4, null);
            return -1L;
        }
    }

    public static final float computeFileSizeMegabytes(Uri uri, ContentResolver contentResolver) {
        C12238m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        C12238m.checkNotNullParameter(contentResolver, "contentResolver");
        return computeFileSizeBytes(uri, contentResolver) / 1048576;
    }
}
