package com.discord.widgets.chat.input;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Parcel;
import androidx.annotation.CallSuper;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import com.lytefast.flexinput.model.Attachment;
import d0.z.d.m;

/* JADX INFO: compiled from: SourcedAttachment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SourcedAttachment<T> extends Attachment<T> {
    private final String source;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SourcedAttachment(long j, Uri uri, String str, T t, String str2) {
        super(j, uri, str, t, false, 16, null);
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(str, "displayName");
        m.checkNotNullParameter(str2, "source");
        this.source = str2;
    }

    public final String getSource() {
        return this.source;
    }

    public String toString() {
        StringBuilder sbU = a.U("SourcedAttachment(uri=");
        sbU.append(getUri());
        sbU.append(", data=");
        sbU.append(getData());
        sbU.append(')');
        return sbU.toString();
    }

    @Override // com.lytefast.flexinput.model.Attachment, android.os.Parcelable
    @SuppressLint({"MissingSuperCall"})
    @CallSuper
    public void writeToParcel(Parcel dest, int flags) {
        m.checkNotNullParameter(dest, "dest");
        super.writeToParcel(dest, flags);
        dest.writeString(this.source);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SourcedAttachment(Attachment<? extends T> attachment, String str) {
        this(attachment.getId(), attachment.getUri(), attachment.getDisplayName(), attachment.getData(), str);
        m.checkNotNullParameter(attachment, "attachment");
        m.checkNotNullParameter(str, "source");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SourcedAttachment(Parcel parcel) {
        m.checkNotNullParameter(parcel, "parcelIn");
        long j = parcel.readLong();
        Uri uri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        if (uri == null) {
            uri = Uri.EMPTY;
            m.checkNotNullExpressionValue(uri, "Uri.EMPTY");
        }
        Uri uri2 = uri;
        String string = parcel.readString();
        String str = string != null ? string : "";
        m.checkNotNullExpressionValue(str, "parcelIn.readString() ?: \"\"");
        String string2 = parcel.readString();
        String str2 = string2 != null ? string2 : "";
        m.checkNotNullExpressionValue(str2, "parcelIn.readString() ?: \"\"");
        this(j, uri2, str, null, str2);
    }
}
