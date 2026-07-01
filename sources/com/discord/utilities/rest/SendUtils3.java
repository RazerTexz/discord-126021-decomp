package com.discord.utilities.rest;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.utilities.attachments.AttachmentUtils;
import com.lytefast.flexinput.model.Attachment;
import d0.t._Collections;
import d0.y.Closeable;
import d0.z.d.Intrinsics3;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.utilities.rest.ProcessedMessageContent, reason: use source file name */
/* JADX INFO: compiled from: SendUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SendUtils3 {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String content;
    private final List<Attachment<?>> invalidAttachments;
    private final List<Attachment<?>> validAttachments;

    /* JADX INFO: renamed from: com.discord.utilities.rest.ProcessedMessageContent$Companion, reason: from kotlin metadata */
    /* JADX INFO: compiled from: SendUtils.kt */
    public static final class Companion {
        private Companion() {
        }

        private final boolean isUriValid(Uri uri, ContentResolver contentResolver) {
            try {
                InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
                if (inputStreamOpenInputStream != null) {
                    Closeable.closeFinally(inputStreamOpenInputStream, null);
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public final SendUtils3 fromAttachments(List<? extends Attachment<?>> attachments, String content, Context context) {
            Intrinsics3.checkNotNullParameter(attachments, "attachments");
            Intrinsics3.checkNotNullParameter(content, "content");
            Intrinsics3.checkNotNullParameter(context, "context");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ContentResolver contentResolver = context.getContentResolver();
            Intrinsics3.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
            List<Attachment<?>> listExtractLinks = AttachmentUtils.extractLinks(attachments, contentResolver);
            String strAppendLinks = AttachmentUtils.appendLinks(content, listExtractLinks);
            for (Attachment attachment : _Collections.minus((Iterable) attachments, (Iterable) listExtractLinks)) {
                Uri uri = attachment.getUri();
                ContentResolver contentResolver2 = context.getContentResolver();
                Intrinsics3.checkNotNullExpressionValue(contentResolver2, "context.contentResolver");
                if (isUriValid(uri, contentResolver2)) {
                    arrayList.add(attachment);
                } else {
                    arrayList2.add(attachment);
                }
            }
            return new SendUtils3(arrayList, arrayList2, strAppendLinks);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SendUtils3(List<? extends Attachment<?>> list, List<? extends Attachment<?>> list2, String str) {
        Intrinsics3.checkNotNullParameter(list, "validAttachments");
        Intrinsics3.checkNotNullParameter(list2, "invalidAttachments");
        Intrinsics3.checkNotNullParameter(str, "content");
        this.validAttachments = list;
        this.invalidAttachments = list2;
        this.content = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SendUtils3 copy$default(SendUtils3 sendUtils3, List list, List list2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = sendUtils3.validAttachments;
        }
        if ((i & 2) != 0) {
            list2 = sendUtils3.invalidAttachments;
        }
        if ((i & 4) != 0) {
            str = sendUtils3.content;
        }
        return sendUtils3.copy(list, list2, str);
    }

    public final List<Attachment<?>> component1() {
        return this.validAttachments;
    }

    public final List<Attachment<?>> component2() {
        return this.invalidAttachments;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    public final SendUtils3 copy(List<? extends Attachment<?>> validAttachments, List<? extends Attachment<?>> invalidAttachments, String content) {
        Intrinsics3.checkNotNullParameter(validAttachments, "validAttachments");
        Intrinsics3.checkNotNullParameter(invalidAttachments, "invalidAttachments");
        Intrinsics3.checkNotNullParameter(content, "content");
        return new SendUtils3(validAttachments, invalidAttachments, content);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SendUtils3)) {
            return false;
        }
        SendUtils3 sendUtils3 = (SendUtils3) other;
        return Intrinsics3.areEqual(this.validAttachments, sendUtils3.validAttachments) && Intrinsics3.areEqual(this.invalidAttachments, sendUtils3.invalidAttachments) && Intrinsics3.areEqual(this.content, sendUtils3.content);
    }

    public final String getContent() {
        return this.content;
    }

    public final List<Attachment<?>> getInvalidAttachments() {
        return this.invalidAttachments;
    }

    public final List<Attachment<?>> getValidAttachments() {
        return this.validAttachments;
    }

    public int hashCode() {
        List<Attachment<?>> list = this.validAttachments;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<Attachment<?>> list2 = this.invalidAttachments;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        String str = this.content;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ProcessedMessageContent(validAttachments=");
        sbU.append(this.validAttachments);
        sbU.append(", invalidAttachments=");
        sbU.append(this.invalidAttachments);
        sbU.append(", content=");
        return outline.J(sbU, this.content, ")");
    }
}
