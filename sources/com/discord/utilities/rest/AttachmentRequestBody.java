package com.discord.utilities.rest;

import android.content.ContentResolver;
import b.d.b.a.outline;
import com.discord.app.AppLog;
import com.discord.utilities.attachments.AttachmentUtils;
import com.lytefast.flexinput.model.Attachment;
import d0.y.Closeable;
import d0.z.d.Intrinsics3;
import g0.JvmOkio;
import g0.Timeout2;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

/* JADX INFO: compiled from: AttachmentRequestBody.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AttachmentRequestBody extends RequestBody {
    private final Attachment<?> attachment;
    private final ContentResolver contentResolver;
    private final long size;

    public AttachmentRequestBody(ContentResolver contentResolver, Attachment<?> attachment) {
        Intrinsics3.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics3.checkNotNullParameter(attachment, "attachment");
        this.contentResolver = contentResolver;
        this.attachment = attachment;
        Object data = attachment.getData();
        File file = (File) (data instanceof File ? data : null);
        this.size = file != null ? file.length() : SendUtils5.computeFileSizeBytes(attachment.getUri(), contentResolver);
    }

    @Override // okhttp3.RequestBody
    /* JADX INFO: renamed from: contentLength, reason: from getter */
    public long getSize() {
        return this.size;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        MediaType.Companion companion = MediaType.INSTANCE;
        return MediaType.Companion.b(AttachmentUtils.getMimeType(this.attachment, this.contentResolver));
    }

    public String toString() {
        StringBuilder sbU = outline.U("AttachmentRequestBody(attachment=");
        sbU.append(this.attachment);
        sbU.append(", size=");
        sbU.append(this.size);
        sbU.append(')');
        return sbU.toString();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink sink) throws IOException {
        Intrinsics3.checkNotNullParameter(sink, "sink");
        try {
            InputStream inputStreamOpenInputStream = this.contentResolver.openInputStream(this.attachment.getUri());
            if (inputStreamOpenInputStream != null) {
                try {
                    Intrinsics3.checkNotNullExpressionValue(inputStreamOpenInputStream, "inputStream");
                    Intrinsics3.checkParameterIsNotNull(inputStreamOpenInputStream, "$this$source");
                    JvmOkio jvmOkio = new JvmOkio(inputStreamOpenInputStream, new Timeout2());
                    try {
                        sink.P(jvmOkio);
                        Closeable.closeFinally(jvmOkio, null);
                        Closeable.closeFinally(inputStreamOpenInputStream, null);
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            Closeable.closeFinally(jvmOkio, th);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        Closeable.closeFinally(inputStreamOpenInputStream, th3);
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
