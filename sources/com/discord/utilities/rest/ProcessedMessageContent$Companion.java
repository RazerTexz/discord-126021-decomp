package com.discord.utilities.rest;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import com.discord.utilities.attachments.AttachmentUtilsKt;
import com.lytefast.flexinput.model.Attachment;
import d0.t.u;
import d0.y.b;
import d0.z.d.m;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SendUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ProcessedMessageContent$Companion {
    private ProcessedMessageContent$Companion() {
    }

    private final boolean isUriValid(Uri uri, ContentResolver contentResolver) {
        try {
            InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
            if (inputStreamOpenInputStream != null) {
                b.closeFinally(inputStreamOpenInputStream, null);
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final ProcessedMessageContent fromAttachments(List<? extends Attachment<?>> attachments, String content, Context context) {
        m.checkNotNullParameter(attachments, "attachments");
        m.checkNotNullParameter(content, "content");
        m.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ContentResolver contentResolver = context.getContentResolver();
        m.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
        List<Attachment<?>> listExtractLinks = AttachmentUtilsKt.extractLinks(attachments, contentResolver);
        String strAppendLinks = AttachmentUtilsKt.appendLinks(content, listExtractLinks);
        for (Attachment attachment : u.minus((Iterable) attachments, (Iterable) listExtractLinks)) {
            Uri uri = attachment.getUri();
            ContentResolver contentResolver2 = context.getContentResolver();
            m.checkNotNullExpressionValue(contentResolver2, "context.contentResolver");
            if (isUriValid(uri, contentResolver2)) {
                arrayList.add(attachment);
            } else {
                arrayList2.add(attachment);
            }
        }
        return new ProcessedMessageContent(arrayList, arrayList2, strAppendLinks);
    }

    public /* synthetic */ ProcessedMessageContent$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
