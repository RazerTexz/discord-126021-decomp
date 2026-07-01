package com.discord.widgets.chat.input;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Parcel;
import androidx.annotation.CallSuper;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.lytefast.flexinput.model.Attachment;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: SourcedAttachment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SourcedAttachment<T> extends Attachment<T> {
    private final String source;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SourcedAttachment(long j, Uri uri, String str, T t, String str2) {
        super(j, uri, str, t, false, 16, null);
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(str, "displayName");
        Intrinsics3.checkNotNullParameter(str2, "source");
        this.source = str2;
    }

    public final String getSource() {
        return this.source;
    }

    public String toString() {
        StringBuilder sbU = outline.U("SourcedAttachment(uri=");
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
        Intrinsics3.checkNotNullParameter(dest, "dest");
        super.writeToParcel(dest, flags);
        dest.writeString(this.source);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SourcedAttachment(Attachment<? extends T> attachment, String str) {
        this(attachment.getId(), attachment.getUri(), attachment.getDisplayName(), attachment.getData(), str);
        Intrinsics3.checkNotNullParameter(attachment, "attachment");
        Intrinsics3.checkNotNullParameter(str, "source");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SourcedAttachment(Parcel parcel) {
        Intrinsics3.checkNotNullParameter(parcel, "parcelIn");
        long j = parcel.readLong();
        Uri uri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        if (uri == null) {
            uri = Uri.EMPTY;
            Intrinsics3.checkNotNullExpressionValue(uri, "Uri.EMPTY");
        }
        Uri uri2 = uri;
        String string = parcel.readString();
        String str = string != null ? string : "";
        Intrinsics3.checkNotNullExpressionValue(str, "parcelIn.readString() ?: \"\"");
        String string2 = parcel.readString();
        String str2 = string2 != null ? string2 : "";
        Intrinsics3.checkNotNullExpressionValue(str2, "parcelIn.readString() ?: \"\"");
        this(j, uri2, str, null, str2);
    }
}
