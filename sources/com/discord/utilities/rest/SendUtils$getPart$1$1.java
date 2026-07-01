package com.discord.utilities.rest;

import android.graphics.Bitmap$CompressFormat;
import com.discord.restapi.utils.CountingRequestBody;
import com.discord.utilities.attachments.AttachmentUtilsKt;
import com.lytefast.flexinput.model.Attachment;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function3;
import okhttp3.MultipartBody$Part;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: SendUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SendUtils$getPart$1$1 extends o implements Function3<RequestBody, String, Bitmap$CompressFormat, SendUtils$FileUpload> {
    public final /* synthetic */ SendUtils$getPart$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendUtils$getPart$1$1(SendUtils$getPart$1 sendUtils$getPart$1) {
        super(3);
        this.this$0 = sendUtils$getPart$1;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ SendUtils$FileUpload invoke(RequestBody requestBody, String str, Bitmap$CompressFormat bitmap$CompressFormat) {
        return invoke2(requestBody, str, bitmap$CompressFormat);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final SendUtils$FileUpload invoke2(RequestBody requestBody, String str, Bitmap$CompressFormat bitmap$CompressFormat) {
        m.checkNotNullParameter(requestBody, "requestBody");
        m.checkNotNullParameter(str, "mimeType");
        CountingRequestBody countingRequestBody = new CountingRequestBody(requestBody, 0);
        String sanitizedFileName = AttachmentUtilsKt.getSanitizedFileName(Attachment.Companion.a(this.this$0.$this_getPart), bitmap$CompressFormat);
        return new SendUtils$FileUpload(sanitizedFileName, countingRequestBody.getEstimatedContentLength(), MultipartBody$Part.b(this.this$0.$name, sanitizedFileName, countingRequestBody), str, countingRequestBody.getBytesWrittenObservable());
    }
}
