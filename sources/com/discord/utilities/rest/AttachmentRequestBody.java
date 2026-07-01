package com.discord.utilities.rest;

import android.content.ContentResolver;
import b.d.b.a.a;
import com.discord.app.AppLog;
import com.discord.utilities.attachments.AttachmentUtilsKt;
import com.lytefast.flexinput.model.Attachment;
import d0.y.b;
import d0.z.d.m;
import g0.n;
import g0.y;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.MediaType;
import okhttp3.MediaType$a;
import okhttp3.RequestBody;
import okio.BufferedSink;

/* JADX INFO: compiled from: AttachmentRequestBody.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AttachmentRequestBody extends RequestBody {
    private final Attachment<?> attachment;
    private final ContentResolver contentResolver;
    private final long size;

    public AttachmentRequestBody(ContentResolver contentResolver, Attachment<?> attachment) {
        m.checkNotNullParameter(contentResolver, "contentResolver");
        m.checkNotNullParameter(attachment, "attachment");
        this.contentResolver = contentResolver;
        this.attachment = attachment;
        Object data = attachment.getData();
        File file = (File) (data instanceof File ? data : null);
        this.size = file != null ? file.length() : SendUtilsKt.computeFileSizeBytes(attachment.getUri(), contentResolver);
    }

    @Override // okhttp3.RequestBody
    /* JADX INFO: renamed from: contentLength, reason: from getter */
    public long getSize() {
        return this.size;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        MediaType$a mediaType$a = MediaType.c;
        return MediaType$a.b(AttachmentUtilsKt.getMimeType(this.attachment, this.contentResolver));
    }

    public String toString() {
        StringBuilder sbU = a.U("AttachmentRequestBody(attachment=");
        sbU.append(this.attachment);
        sbU.append(", size=");
        sbU.append(this.size);
        sbU.append(')');
        return sbU.toString();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink sink) throws IOException {
        m.checkNotNullParameter(sink, "sink");
        try {
            InputStream inputStreamOpenInputStream = this.contentResolver.openInputStream(this.attachment.getUri());
            if (inputStreamOpenInputStream != null) {
                try {
                    m.checkNotNullExpressionValue(inputStreamOpenInputStream, "inputStream");
                    m.checkParameterIsNotNull(inputStreamOpenInputStream, "$this$source");
                    n nVar = new n(inputStreamOpenInputStream, new y());
                    try {
                        sink.P(nVar);
                        b.closeFinally(nVar, null);
                        b.closeFinally(inputStreamOpenInputStream, null);
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            b.closeFinally(nVar, th);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        b.closeFinally(inputStreamOpenInputStream, th3);
                        throw th4;
                    }
                }
            }
        } catch (IOException e) {
            AppLog.g.i("Could not write to sink", e);
            throw e;
        }
    }
}
