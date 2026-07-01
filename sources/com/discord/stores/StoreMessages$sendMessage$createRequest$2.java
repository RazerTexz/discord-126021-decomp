package com.discord.stores;

import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.commands.ApplicationCommandLocalSendData;
import com.discord.models.message.Message;
import com.discord.utilities.messagesend.MessageRequest$SendApplicationCommand;
import com.discord.utilities.messagesend.MessageResult;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.jvm.functions.Function1;
import rx.Emitter;

/* JADX INFO: compiled from: StoreMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessages$sendMessage$createRequest$2 extends o implements Function1<Emitter<MessageResult>, MessageRequest$SendApplicationCommand> {
    public final /* synthetic */ ApplicationCommandLocalSendData $applicationCommandLocalSendData;
    public final /* synthetic */ List $attachments;
    public final /* synthetic */ Message $message;
    public final /* synthetic */ StoreMessages this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessages$sendMessage$createRequest$2(StoreMessages storeMessages, Message message, ApplicationCommandLocalSendData applicationCommandLocalSendData, List list) {
        super(1);
        this.this$0 = storeMessages;
        this.$message = message;
        this.$applicationCommandLocalSendData = applicationCommandLocalSendData;
        this.$attachments = list;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ MessageRequest$SendApplicationCommand invoke(Emitter<MessageResult> emitter) {
        return invoke2(emitter);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final MessageRequest$SendApplicationCommand invoke2(Emitter<MessageResult> emitter) {
        m.checkNotNullParameter(emitter, "emitter");
        com.discord.api.message.Message messageSynthesizeApiMessage = this.$message.synthesizeApiMessage();
        ApplicationCommandLocalSendData applicationCommandLocalSendData = this.$applicationCommandLocalSendData;
        UtcDateTime timestamp = this.$message.getTimestamp();
        return new MessageRequest$SendApplicationCommand(messageSynthesizeApiMessage, applicationCommandLocalSendData, this.$attachments, new StoreMessages$sendMessage$createRequest$2$2(this), new StoreMessages$sendMessage$createRequest$2$3(this), new StoreMessages$sendMessage$createRequest$2$1(this, emitter), timestamp != null ? timestamp.getDateTimeMillis() : 0L);
    }
}
