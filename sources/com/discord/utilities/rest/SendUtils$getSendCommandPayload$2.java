package com.discord.utilities.rest;

import androidx.core.app.NotificationCompat;
import com.discord.models.commands.ApplicationCommandLocalSendData;
import d0.z.d.m;
import j0.k.b;
import java.util.List;

/* JADX INFO: compiled from: SendUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SendUtils$getSendCommandPayload$2<T, R> implements b<List<SendUtils$FileUpload>, SendUtils$SendPayload$ReadyToSendCommand> {
    public final /* synthetic */ ApplicationCommandLocalSendData $attachmentCorrectedMessage;

    public SendUtils$getSendCommandPayload$2(ApplicationCommandLocalSendData applicationCommandLocalSendData) {
        this.$attachmentCorrectedMessage = applicationCommandLocalSendData;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ SendUtils$SendPayload$ReadyToSendCommand call(List<SendUtils$FileUpload> list) {
        return call2(list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final SendUtils$SendPayload$ReadyToSendCommand call2(List<SendUtils$FileUpload> list) {
        ApplicationCommandLocalSendData applicationCommandLocalSendData = this.$attachmentCorrectedMessage;
        m.checkNotNullExpressionValue(list, "attachmentParts");
        return new SendUtils$SendPayload$ReadyToSendCommand(applicationCommandLocalSendData, list);
    }
}
