package com.lytefast.flexinput.model;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.core.app.NotificationCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import androidx.exifinterface.media.ExifInterface;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtils;
import d0.g0.Strings4;
import d0.y.Closeable;
import d0.z.d.Intrinsics3;
import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Attachment.kt */
/* JADX INFO: loaded from: classes3.dex */
public class Attachment<T> implements Parcelable {
    private static final String SPOILER_PREFIX = "SPOILER_";
    private final T data;
    private final String displayName;
    private final long id;
    private boolean spoiler;
    private final Uri uri;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<Attachment<?>> CREATOR = new a();

    /* JADX INFO: compiled from: Attachment.kt */
    public static final class Companion {
        public Companion() {
        }

        public final String a(Attachment<?> attachment) {
            Intrinsics3.checkNotNullParameter(attachment, "$this$getSendName");
            if (!attachment.getSpoiler()) {
                return attachment.getDisplayName();
            }
            StringBuilder sbU = outline.U("SPOILER_");
            sbU.append(attachment.getDisplayName());
            return sbU.toString();
        }

        /* JADX WARN: Code duplicated, block: B:39:0x00a3  */
        public final Attachment<Uri> b(Uri uri, ContentResolver contentResolver) throws IOException {
            String lastPathSegment;
            int columnIndex;
            Intrinsics3.checkNotNullParameter(uri, "$this$toAttachment");
            Intrinsics3.checkNotNullParameter(contentResolver, "resolver");
            Intrinsics3.checkNotNullParameter(uri, "$this$getFileName");
            Intrinsics3.checkNotNullParameter(contentResolver, "contentResolver");
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
                                        Closeable.closeFinally(cursorQuery, null);
                                        lastPathSegment = uri.getLastPathSegment();
                                    } else {
                                        String string = cursorQuery.getString(columnIndex);
                                        if (string == null) {
                                            string = uri.getLastPathSegment();
                                        }
                                        Closeable.closeFinally(cursorQuery, null);
                                        lastPathSegment = string;
                                    }
                                } catch (Throwable th) {
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        Closeable.closeFinally(cursorQuery, th);
                                        throw th2;
                                    }
                                }
                            } else {
                                lastPathSegment = uri.getLastPathSegment();
                            }
                        } catch (NullPointerException e) {
                            StringBuilder sbU = outline.U("Error getting file name for: ");
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
            Intrinsics3.checkNotNullParameter(inputContentInfoCompat, "$this$toAttachment");
            Intrinsics3.checkNotNullParameter(contentResolver, "resolver");
            Intrinsics3.checkNotNullParameter(str, "defaultName");
            String queryParameter = inputContentInfoCompat.getContentUri().getQueryParameter("fileName");
            if (queryParameter != null) {
                str = queryParameter;
            }
            Intrinsics3.checkNotNullExpressionValue(str, "contentUri.getQueryParam…fileName\") ?: defaultName");
            String strSubstringAfterLast$default = Strings4.substringAfterLast$default(str, File.separatorChar, null, 2, null);
            if (z2) {
                String mimeType = inputContentInfoCompat.getDescription().getMimeType(0);
                if (mimeType == null) {
                    mimeType = inputContentInfoCompat.getContentUri().getQueryParameter("mimeType");
                }
                if (mimeType == null) {
                    mimeType = contentResolver.getType(inputContentInfoCompat.getContentUri());
                }
                if (mimeType != null) {
                    String str3 = strSubstringAfterLast$default + '.' + Strings4.substringAfterLast$default(mimeType, MentionUtils.SLASH_CHAR, null, 2, null);
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
            Intrinsics3.checkNotNullExpressionValue(contentUri, "contentUri");
            return new Attachment<>(jHashCode, contentUri, str2, inputContentInfoCompat, false, 16, null);
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: compiled from: Attachment.kt */
    public static final class a implements Parcelable.Creator<Attachment<?>> {
        @Override // android.os.Parcelable.Creator
        public Attachment<?> createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "parcelIn");
            return new Attachment<>(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Attachment<?>[] newArray(int i) {
            return new Attachment[i];
        }
    }

    public Attachment(long j, Uri uri, String str, T t, boolean z2) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(str, "displayName");
        this.id = j;
        this.uri = uri;
        this.displayName = str;
        this.data = t;
        this.spoiler = z2;
    }

    public static final Attachment<Uri> toAttachment(Uri uri, ContentResolver contentResolver) {
        return INSTANCE.b(uri, contentResolver);
    }

    public static final Attachment<InputContentInfoCompat> toAttachment(InputContentInfoCompat inputContentInfoCompat, ContentResolver contentResolver, boolean z2, String str) {
        return INSTANCE.c(inputContentInfoCompat, contentResolver, z2, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (other == null || !(other instanceof Attachment)) {
            return false;
        }
        Attachment attachment = (Attachment) other;
        return this.id == attachment.id && Intrinsics3.areEqual(this.uri, attachment.uri) && this.spoiler == attachment.spoiler;
    }

    public final T getData() {
        return this.data;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final long getId() {
        return this.id;
    }

    public final boolean getSpoiler() {
        return this.spoiler;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public int hashCode() {
        return AnimatableValueParser.K0(Long.valueOf(this.id), this.uri);
    }

    public final void setSpoiler(boolean z2) {
        this.spoiler = z2;
    }

    @Override // android.os.Parcelable
    @CallSuper
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics3.checkNotNullParameter(dest, "dest");
        dest.writeLong(this.id);
        dest.writeParcelable(this.uri, flags);
        dest.writeString(this.displayName);
        dest.writeInt(this.spoiler ? 1 : 0);
    }

    public /* synthetic */ Attachment(long j, Uri uri, String str, Object obj, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, uri, str, (i & 8) != 0 ? null : obj, (i & 16) != 0 ? false : z2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Attachment(Parcel parcel) {
        Intrinsics3.checkNotNullParameter(parcel, "parcelIn");
        long j = parcel.readLong();
        Uri uri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        if (uri == null) {
            uri = Uri.EMPTY;
            Intrinsics3.checkNotNullExpressionValue(uri, "Uri.EMPTY");
        }
        Uri uri2 = uri;
        String string = parcel.readString();
        String str = string == null ? "" : string;
        Intrinsics3.checkNotNullExpressionValue(str, "parcelIn.readString() ?: \"\"");
        this(j, uri2, str, null, parcel.readInt() == 1);
    }
}
