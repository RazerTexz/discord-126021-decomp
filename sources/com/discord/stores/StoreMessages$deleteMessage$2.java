package com.discord.stores;

import com.discord.models.domain.ModelMessageDelete;
import com.discord.models.message.Message;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessages$deleteMessage$2 extends o implements Function0<Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ Message $message;
    public final /* synthetic */ long $messageId;
    public final /* synthetic */ StoreMessages this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessages$deleteMessage$2(StoreMessages storeMessages, Message message, long j, long j2) {
        super(0);
        this.this$0 = storeMessages;
        this.$message = message;
        this.$channelId = j;
        this.$messageId = j2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.$message.isLocal()) {
            String nonce = this.$message.getNonce();
            if (nonce != null) {
                StoreMessages.access$getOrCreateMessageQueue(this.this$0, this.$channelId).cancel(nonce);
            }
            StoreMessages.access$handleLocalMessageDelete(this.this$0, this.$message);
            Integer type = this.$message.getType();
            if (type != null && type.intValue() == -2) {
                StoreMessages.access$trackFailedLocalMessageResolved(this.this$0, this.$message, FailedMessageResolutionType.DELETED);
            }
        } else if (this.$message.isEphemeralMessage()) {
            this.this$0.handleMessageDelete(new ModelMessageDelete(this.$channelId, this.$messageId));
        }
        StoreMessages.access$getStream$p(this.this$0).handleLocalMessageDelete(this.$message);
    }
}
