package com.lytefast.flexinput.model;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import androidx.annotation.CallSuper;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import androidx.exifinterface.media.ExifInterface;
import b.c.a.a0.d;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
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
    public static final Attachment$Companion Companion = new Attachment$Companion(null);
    public static final Parcelable$Creator<Attachment<?>> CREATOR = new Attachment$a();

    public Attachment(long j, Uri uri, String str, T t, boolean z2) {
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(str, "displayName");
        this.id = j;
        this.uri = uri;
        this.displayName = str;
        this.data = t;
        this.spoiler = z2;
    }

    public static final Attachment<Uri> toAttachment(Uri uri, ContentResolver contentResolver) {
        return Companion.b(uri, contentResolver);
    }

    public static final Attachment<InputContentInfoCompat> toAttachment(InputContentInfoCompat inputContentInfoCompat, ContentResolver contentResolver, boolean z2, String str) {
        return Companion.c(inputContentInfoCompat, contentResolver, z2, str);
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
        return this.id == attachment.id && m.areEqual(this.uri, attachment.uri) && this.spoiler == attachment.spoiler;
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
        return d.K0(Long.valueOf(this.id), this.uri);
    }

    public final void setSpoiler(boolean z2) {
        this.spoiler = z2;
    }

    @Override // android.os.Parcelable
    @CallSuper
    public void writeToParcel(Parcel dest, int flags) {
        m.checkNotNullParameter(dest, "dest");
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
        m.checkNotNullParameter(parcel, "parcelIn");
        long j = parcel.readLong();
        Uri uri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        if (uri == null) {
            uri = Uri.EMPTY;
            m.checkNotNullExpressionValue(uri, "Uri.EMPTY");
        }
        Uri uri2 = uri;
        String string = parcel.readString();
        String str = string == null ? "" : string;
        m.checkNotNullExpressionValue(str, "parcelIn.readString() ?: \"\"");
        this(j, uri2, str, null, parcel.readInt() == 1);
    }
}
