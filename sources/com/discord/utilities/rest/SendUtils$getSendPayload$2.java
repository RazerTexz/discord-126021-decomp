package com.discord.utilities.rest;

import androidx.core.app.NotificationCompat;
import com.discord.restapi.RestAPIParams$Message;
import d0.z.d.m;
import j0.k.b;
import java.util.List;

/* JADX INFO: compiled from: SendUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SendUtils$getSendPayload$2<T, R> implements b<List<SendUtils$FileUpload>, SendUtils$SendPayload$ReadyToSend> {
    public final /* synthetic */ RestAPIParams$Message $sanitizedApiParamMessage;

    public SendUtils$getSendPayload$2(RestAPIParams$Message restAPIParams$Message) {
        this.$sanitizedApiParamMessage = restAPIParams$Message;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ SendUtils$SendPayload$ReadyToSend call(List<SendUtils$FileUpload> list) {
        return call2(list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final SendUtils$SendPayload$ReadyToSend call2(List<SendUtils$FileUpload> list) {
        RestAPIParams$Message restAPIParams$Message = this.$sanitizedApiParamMessage;
        m.checkNotNullExpressionValue(list, "attachmentParts");
        return new SendUtils$SendPayload$ReadyToSend(restAPIParams$Message, list);
    }
}
