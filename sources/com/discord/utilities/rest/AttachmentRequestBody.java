package com.discord.utilities.rest;

import android.content.ContentResolver;
import com.discord.app.AppLog;
import com.discord.utilities.attachments.AttachmentUtilsKt;
import com.lytefast.flexinput.model.Attachment;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p591y.C12201b;
import p507d0.p592z.p594d.C12238m;
import p615g0.C12397n;
import p615g0.C12408y;

/* JADX INFO: compiled from: AttachmentRequestBody.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AttachmentRequestBody extends RequestBody {
    private final Attachment<?> attachment;
    private final ContentResolver contentResolver;
    private final long size;

    public AttachmentRequestBody(ContentResolver contentResolver, Attachment<?> attachment) {
        C12238m.checkNotNullParameter(contentResolver, "contentResolver");
        C12238m.checkNotNullParameter(attachment, "attachment");
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
        MediaType.Companion companion = MediaType.INSTANCE;
        return MediaType.Companion.m10968b(AttachmentUtilsKt.getMimeType(this.attachment, this.contentResolver));
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("AttachmentRequestBody(attachment=");
        sbM833U.append(this.attachment);
        sbM833U.append(", size=");
        sbM833U.append(this.size);
        sbM833U.append(')');
        return sbM833U.toString();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink sink) throws IOException {
        C12238m.checkNotNullParameter(sink, "sink");
        try {
            InputStream inputStreamOpenInputStream = this.contentResolver.openInputStream(this.attachment.getUri());
            if (inputStreamOpenInputStream != null) {
                try {
                    C12238m.checkNotNullExpressionValue(inputStreamOpenInputStream, "inputStream");
                    C12238m.checkParameterIsNotNull(inputStreamOpenInputStream, "$this$source");
                    C12397n c12397n = new C12397n(inputStreamOpenInputStream, new C12408y());
                    try {
                        sink.mo10440P(c12397n);
                        C12201b.closeFinally(c12397n, null);
                        C12201b.closeFinally(inputStreamOpenInputStream, null);
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            C12201b.closeFinally(c12397n, th);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        C12201b.closeFinally(inputStreamOpenInputStream, th3);
                        throw th4;
                    }
                }
            }
        } catch (IOException e) {
            AppLog.f14950g.mo8367i("Could not write to sink", e);
            throw e;
        }
    }
}
