package com.discord.utilities.messagesend;

import com.discord.api.message.Message;
import com.discord.models.commands.ApplicationCommandLocalSendData;
import com.discord.utilities.rest.SendUtils$FileUpload;
import com.discord.utilities.rest.SendUtils$SendPayload$Preprocessing;
import com.lytefast.flexinput.model.Attachment;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: MessageQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageRequest$SendApplicationCommand extends MessageRequest {
    private final ApplicationCommandLocalSendData applicationCommandSendData;
    private final List<Attachment<?>> attachments;
    private final Message message;
    private final Function1<SendUtils$SendPayload$Preprocessing, Unit> onPreprocessing;
    private final Function1<List<SendUtils$FileUpload>, Unit> onProgress;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public MessageRequest$SendApplicationCommand(Message message, ApplicationCommandLocalSendData applicationCommandLocalSendData, List<? extends Attachment<?>> list, Function1<? super SendUtils$SendPayload$Preprocessing, Unit> function1, Function1<? super List<SendUtils$FileUpload>, Unit> function2, Function2<? super MessageResult, ? super Boolean, Unit> function3, long j) {
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(applicationCommandLocalSendData, "applicationCommandSendData");
        m.checkNotNullParameter(function1, "onPreprocessing");
        m.checkNotNullParameter(function2, "onProgress");
        m.checkNotNullParameter(function3, "onCompleted");
        String nonce = message.getNonce();
        super(nonce == null ? String.valueOf(applicationCommandLocalSendData.getNonce()) : nonce, function3, j, null);
        this.message = message;
        this.applicationCommandSendData = applicationCommandLocalSendData;
        this.attachments = list;
        this.onPreprocessing = function1;
        this.onProgress = function2;
    }

    public final ApplicationCommandLocalSendData getApplicationCommandSendData() {
        return this.applicationCommandSendData;
    }

    public final List<Attachment<?>> getAttachments() {
        return this.attachments;
    }

    public final Message getMessage() {
        return this.message;
    }

    public final Function1<SendUtils$SendPayload$Preprocessing, Unit> getOnPreprocessing() {
        return this.onPreprocessing;
    }

    public final Function1<List<SendUtils$FileUpload>, Unit> getOnProgress() {
        return this.onProgress;
    }
}
