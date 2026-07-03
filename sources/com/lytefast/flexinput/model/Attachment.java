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
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtilsKt;
import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12106w;
import p507d0.p591y.C12201b;
import p507d0.p592z.p594d.C12238m;

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
    public static final Parcelable.Creator<Attachment<?>> CREATOR = new C11189a();

    /* JADX INFO: compiled from: Attachment.kt */
    public static final class Companion {
        public Companion() {
        }

        /* JADX INFO: renamed from: a */
        public final String m9295a(Attachment<?> attachment) {
            C12238m.checkNotNullParameter(attachment, "$this$getSendName");
            if (!attachment.getSpoiler()) {
                return attachment.getDisplayName();
            }
            StringBuilder sbM833U = C1643a.m833U("SPOILER_");
            sbM833U.append(attachment.getDisplayName());
            return sbM833U.toString();
        }

        /* JADX WARN: Code duplicated, block: B:39:0x00a3  */
        /* JADX INFO: renamed from: b */
        public final Attachment<Uri> m9296b(Uri uri, ContentResolver contentResolver) throws IOException {
            String lastPathSegment;
            int columnIndex;
            C12238m.checkNotNullParameter(uri, "$this$toAttachment");
            C12238m.checkNotNullParameter(contentResolver, "resolver");
            C12238m.checkNotNullParameter(uri, "$this$getFileName");
            C12238m.checkNotNullParameter(contentResolver, "contentResolver");
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
                                        C12201b.closeFinally(cursorQuery, null);
                                        lastPathSegment = uri.getLastPathSegment();
                                    } else {
                                        String string = cursorQuery.getString(columnIndex);
                                        if (string == null) {
                                            string = uri.getLastPathSegment();
                                        }
                                        C12201b.closeFinally(cursorQuery, null);
                                        lastPathSegment = string;
                                    }
                                } catch (Throwable th) {
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        C12201b.closeFinally(cursorQuery, th);
                                        throw th2;
                                    }
                                }
                            } else {
                                lastPathSegment = uri.getLastPathSegment();
                            }
                        } catch (NullPointerException e) {
                            StringBuilder sbM833U = C1643a.m833U("Error getting file name for: ");
                            sbM833U.append(uri.getPath());
                            Log.e("FileUtils", sbM833U.toString(), e);
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
        /* JADX INFO: renamed from: c */
        public final Attachment<InputContentInfoCompat> m9297c(InputContentInfoCompat inputContentInfoCompat, ContentResolver contentResolver, boolean z2, String str) {
            String str2;
            C12238m.checkNotNullParameter(inputContentInfoCompat, "$this$toAttachment");
            C12238m.checkNotNullParameter(contentResolver, "resolver");
            C12238m.checkNotNullParameter(str, "defaultName");
            String queryParameter = inputContentInfoCompat.getContentUri().getQueryParameter("fileName");
            if (queryParameter != null) {
                str = queryParameter;
            }
            C12238m.checkNotNullExpressionValue(str, "contentUri.getQueryParam…fileName\") ?: defaultName");
            String strSubstringAfterLast$default = C12106w.substringAfterLast$default(str, File.separatorChar, null, 2, null);
            if (z2) {
                String mimeType = inputContentInfoCompat.getDescription().getMimeType(0);
                if (mimeType == null) {
                    mimeType = inputContentInfoCompat.getContentUri().getQueryParameter("mimeType");
                }
                if (mimeType == null) {
                    mimeType = contentResolver.getType(inputContentInfoCompat.getContentUri());
                }
                if (mimeType != null) {
                    String str3 = strSubstringAfterLast$default + '.' + C12106w.substringAfterLast$default(mimeType, MentionUtilsKt.SLASH_CHAR, null, 2, null);
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
            C12238m.checkNotNullExpressionValue(contentUri, "contentUri");
            return new Attachment<>(jHashCode, contentUri, str2, inputContentInfoCompat, false, 16, null);
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: com.lytefast.flexinput.model.Attachment$a */
    /* JADX INFO: compiled from: Attachment.kt */
    public static final class C11189a implements Parcelable.Creator<Attachment<?>> {
        @Override // android.os.Parcelable.Creator
        public Attachment<?> createFromParcel(Parcel parcel) {
            C12238m.checkNotNullParameter(parcel, "parcelIn");
            return new Attachment<>(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Attachment<?>[] newArray(int i) {
            return new Attachment[i];
        }
    }

    public Attachment(long j, Uri uri, String str, T t, boolean z2) {
        C12238m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        C12238m.checkNotNullParameter(str, "displayName");
        this.id = j;
        this.uri = uri;
        this.displayName = str;
        this.data = t;
        this.spoiler = z2;
    }

    public static final Attachment<Uri> toAttachment(Uri uri, ContentResolver contentResolver) {
        return INSTANCE.m9296b(uri, contentResolver);
    }

    public static final Attachment<InputContentInfoCompat> toAttachment(InputContentInfoCompat inputContentInfoCompat, ContentResolver contentResolver, boolean z2, String str) {
        return INSTANCE.m9297c(inputContentInfoCompat, contentResolver, z2, str);
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
        return this.id == attachment.id && C12238m.areEqual(this.uri, attachment.uri) && this.spoiler == attachment.spoiler;
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
        return C1460d.m448K0(Long.valueOf(this.id), this.uri);
    }

    public final void setSpoiler(boolean z2) {
        this.spoiler = z2;
    }

    @Override // android.os.Parcelable
    @CallSuper
    public void writeToParcel(Parcel dest, int flags) {
        C12238m.checkNotNullParameter(dest, "dest");
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
        C12238m.checkNotNullParameter(parcel, "parcelIn");
        long j = parcel.readLong();
        Uri uri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        if (uri == null) {
            uri = Uri.EMPTY;
            C12238m.checkNotNullExpressionValue(uri, "Uri.EMPTY");
        }
        Uri uri2 = uri;
        String string = parcel.readString();
        String str = string == null ? "" : string;
        C12238m.checkNotNullExpressionValue(str, "parcelIn.readString() ?: \"\"");
        this(j, uri2, str, null, parcel.readInt() == 1);
    }
}
