package com.discord.stores;

import com.discord.api.message.allowedmentions.MessageAllowedMentions;
import com.discord.utilities.messagesend.MessageResult;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: StoreMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessages$editMessage$1 extends o implements Function2<MessageResult, Boolean, Unit> {
    public final /* synthetic */ MessageAllowedMentions $allowedMentions;
    public final /* synthetic */ long $attemptTimestamp;
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ String $content;
    public final /* synthetic */ long $messageId;
    public final /* synthetic */ StoreMessages this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessages$editMessage$1(StoreMessages storeMessages, long j, long j2, String str, long j3, MessageAllowedMentions messageAllowedMentions) {
        super(2);
        this.this$0 = storeMessages;
        this.$channelId = j;
        this.$messageId = j2;
        this.$content = str;
        this.$attemptTimestamp = j3;
        this.$allowedMentions = messageAllowedMentions;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(MessageResult messageResult, Boolean bool) {
        invoke(messageResult, bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(MessageResult messageResult, boolean z2) {
        m.checkNotNullParameter(messageResult, "result");
        StoreMessages.access$getDispatcher$p(this.this$0).schedule(new StoreMessages$editMessage$1$1(this, messageResult));
    }
}
