package com.discord.utilities.messagesend;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.rest.SendUtils$SendPayload;
import com.discord.utilities.rest.SendUtils$SendPayload$Preprocessing;
import com.discord.utilities.rest.SendUtils$SendPayload$ReadyToSendCommand;
import rx.functions.Action1;

/* JADX INFO: compiled from: MessageQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageQueue$doSendApplicationCommand$1<T> implements Action1<SendUtils$SendPayload> {
    public final /* synthetic */ MessageRequest$SendApplicationCommand $sendApplicationCommandRequest;

    public MessageQueue$doSendApplicationCommand$1(MessageRequest$SendApplicationCommand messageRequest$SendApplicationCommand) {
        this.$sendApplicationCommandRequest = messageRequest$SendApplicationCommand;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(SendUtils$SendPayload sendUtils$SendPayload) {
        call2(sendUtils$SendPayload);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(SendUtils$SendPayload sendUtils$SendPayload) {
        if (sendUtils$SendPayload instanceof SendUtils$SendPayload$Preprocessing) {
            this.$sendApplicationCommandRequest.getOnPreprocessing().invoke(sendUtils$SendPayload);
        } else if (sendUtils$SendPayload instanceof SendUtils$SendPayload$ReadyToSendCommand) {
            SendUtils$SendPayload$ReadyToSendCommand sendUtils$SendPayload$ReadyToSendCommand = (SendUtils$SendPayload$ReadyToSendCommand) sendUtils$SendPayload;
            if (!sendUtils$SendPayload$ReadyToSendCommand.getUploads().isEmpty()) {
                this.$sendApplicationCommandRequest.getOnProgress().invoke(sendUtils$SendPayload$ReadyToSendCommand.getUploads());
            }
        }
    }
}
