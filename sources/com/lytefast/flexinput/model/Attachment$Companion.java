package com.lytefast.flexinput.model;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import b.d.b.a.a;
import com.discord.api.message.attachment.MessageAttachment;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.g0.w;
import d0.y.b;
import d0.z.d.m;
import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Attachment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Attachment$Companion {
    public Attachment$Companion() {
    }

    public final String a(Attachment<?> attachment) {
        m.checkNotNullParameter(attachment, "$this$getSendName");
        if (!attachment.getSpoiler()) {
            return attachment.getDisplayName();
        }
        StringBuilder sbU = a.U(MessageAttachment.SPOILER_PREFIX);
        sbU.append(attachment.getDisplayName());
        return sbU.toString();
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00a3  */
    public final Attachment<Uri> b(Uri uri, ContentResolver contentResolver) throws IOException {
        String lastPathSegment;
        int columnIndex;
        m.checkNotNullParameter(uri, "$this$toAttachment");
        m.checkNotNullParameter(contentResolver, "resolver");
        m.checkNotNullParameter(uri, "$this$getFileName");
        m.checkNotNullParameter(contentResolver, "contentResolver");
        String scheme = uri.getScheme();
        if (scheme == null) {
            lastPathSegment = uri.getLastPathSegment();
        } else {
            int iHashCode = scheme.hashCode();
            lastPathSegment = null;
            if (iHashCode != 3143036) {
                if (iHashCode == 951530617 && scheme.equals("content")) {
                    try {
                        Cursor cursorQuery = contentResolver.query(uri, null, null, null, null);
                        if (cursorQuery != null) {
                            try {
                                if (!cursorQuery.moveToFirst() || (columnIndex = cursorQuery.getColumnIndex("_display_name")) < 0) {
                                    b.closeFinally(cursorQuery, null);
                                    lastPathSegment = uri.getLastPathSegment();
                                } else {
                                    String string = cursorQuery.getString(columnIndex);
                                    if (string == null) {
                                        string = uri.getLastPathSegment();
                                    }
                                    b.closeFinally(cursorQuery, null);
                                    lastPathSegment = string;
                                }
                            } catch (Throwable th) {
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    b.closeFinally(cursorQuery, th);
                                    throw th2;
                                }
                            }
                        } else {
                            lastPathSegment = uri.getLastPathSegment();
                        }
                    } catch (NullPointerException e) {
                        StringBuilder sbU = a.U("Error getting file name for: ");
                        sbU.append(uri.getPath());
                        Log.e("FileUtils", sbU.toString(), e);
                        lastPathSegment = uri.getLastPathSegment();
                    }
                } else {
                    lastPathSegment = uri.getLastPathSegment();
                }
            } else if (scheme.equals("file")) {
                String path = uri.getPath();
                if (path != null) {
                    lastPathSegment = new File(path).getName();
                }
            } else {
                lastPathSegment = uri.getLastPathSegment();
            }
        }
        if (lastPathSegment == null) {
            lastPathSegment = String.valueOf(uri.hashCode());
        }
        return new Attachment<>(uri.hashCode(), uri, lastPathSegment, null, false, 16, null);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x006c  */
    public final Attachment<InputContentInfoCompat> c(InputContentInfoCompat inputContentInfoCompat, ContentResolver contentResolver, boolean z2, String str) {
        String str2;
        m.checkNotNullParameter(inputContentInfoCompat, "$this$toAttachment");
        m.checkNotNullParameter(contentResolver, "resolver");
        m.checkNotNullParameter(str, "defaultName");
        String queryParameter = inputContentInfoCompat.getContentUri().getQueryParameter("fileName");
        if (queryParameter != null) {
            str = queryParameter;
        }
        m.checkNotNullExpressionValue(str, "contentUri.getQueryParam…fileName\") ?: defaultName");
        String strSubstringAfterLast$default = w.substringAfterLast$default(str, File.separatorChar, null, 2, null);
        if (z2) {
            String mimeType = inputContentInfoCompat.getDescription().getMimeType(0);
            if (mimeType == null) {
                mimeType = inputContentInfoCompat.getContentUri().getQueryParameter("mimeType");
            }
            if (mimeType == null) {
                mimeType = contentResolver.getType(inputContentInfoCompat.getContentUri());
            }
            if (mimeType != null) {
                String str3 = strSubstringAfterLast$default + '.' + w.substringAfterLast$default(mimeType, MentionUtilsKt.SLASH_CHAR, null, 2, null);
                if (str3 != null) {
                    str2 = str3;
                } else {
                    str2 = strSubstringAfterLast$default;
                }
            } else {
                str2 = strSubstringAfterLast$default;
            }
        } else {
            str2 = strSubstringAfterLast$default;
        }
        long jHashCode = inputContentInfoCompat.getContentUri().hashCode();
        Uri contentUri = inputContentInfoCompat.getContentUri();
        m.checkNotNullExpressionValue(contentUri, "contentUri");
        return new Attachment<>(jHashCode, contentUri, str2, inputContentInfoCompat, false, 16, null);
    }

    public Attachment$Companion(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
