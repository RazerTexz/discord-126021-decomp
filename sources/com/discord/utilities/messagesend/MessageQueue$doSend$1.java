package com.discord.utilities.messagesend;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.rest.SendUtils$SendPayload;
import com.discord.utilities.rest.SendUtils$SendPayload$Preprocessing;
import com.discord.utilities.rest.SendUtils$SendPayload$ReadyToSend;
import rx.functions.Action1;

/* JADX INFO: compiled from: MessageQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageQueue$doSend$1<T> implements Action1<SendUtils$SendPayload> {
    public final /* synthetic */ MessageRequest$Send $request;

    public MessageQueue$doSend$1(MessageRequest$Send messageRequest$Send) {
        this.$request = messageRequest$Send;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(SendUtils$SendPayload sendUtils$SendPayload) {
        call2(sendUtils$SendPayload);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(SendUtils$SendPayload sendUtils$SendPayload) {
        if (sendUtils$SendPayload instanceof SendUtils$SendPayload$Preprocessing) {
            this.$request.getOnPreprocessing().invoke(sendUtils$SendPayload);
        } else if (sendUtils$SendPayload instanceof SendUtils$SendPayload$ReadyToSend) {
            SendUtils$SendPayload$ReadyToSend sendUtils$SendPayload$ReadyToSend = (SendUtils$SendPayload$ReadyToSend) sendUtils$SendPayload;
            if (!sendUtils$SendPayload$ReadyToSend.getUploads().isEmpty()) {
                this.$request.getOnProgress().invoke(sendUtils$SendPayload$ReadyToSend.getUploads());
            }
        }
    }
}
