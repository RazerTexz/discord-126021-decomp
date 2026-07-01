package com.discord.stores;

import com.discord.api.activity.Activity;
import com.discord.models.message.Message;
import com.discord.utilities.messagesend.MessageRequest$Send;
import com.discord.utilities.messagesend.MessageResult;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.Emitter;

/* JADX INFO: compiled from: StoreMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessages$sendMessage$createRequest$1 extends o implements Function1<Emitter<MessageResult>, MessageRequest$Send> {
    public final /* synthetic */ Activity $activity;
    public final /* synthetic */ long $attemptTimestamp;
    public final /* synthetic */ Message $localMessage;
    public final /* synthetic */ Ref$ObjectRef $validAttachments;
    public final /* synthetic */ StoreMessages this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessages$sendMessage$createRequest$1(StoreMessages storeMessages, Message message, Ref$ObjectRef ref$ObjectRef, Activity activity, long j) {
        super(1);
        this.this$0 = storeMessages;
        this.$localMessage = message;
        this.$validAttachments = ref$ObjectRef;
        this.$activity = activity;
        this.$attemptTimestamp = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ MessageRequest$Send invoke(Emitter<MessageResult> emitter) {
        return invoke2(emitter);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final MessageRequest$Send invoke2(Emitter<MessageResult> emitter) {
        m.checkNotNullParameter(emitter, "emitter");
        Message message = this.$localMessage;
        List list = (List) this.$validAttachments.element;
        return new MessageRequest$Send(message, this.$activity, list, new StoreMessages$sendMessage$createRequest$1$1(this, emitter), new StoreMessages$sendMessage$createRequest$1$2(this), new StoreMessages$sendMessage$createRequest$1$3(this), this.$attemptTimestamp);
    }
}
