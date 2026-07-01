package com.discord.stores;

import com.discord.models.message.Message;
import d0.t.n;
import d0.z.d.o;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StorePinnedMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StorePinnedMessages$observePinnedMessage$1 extends o implements Function0<Message> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ long $messageId;
    public final /* synthetic */ StorePinnedMessages this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StorePinnedMessages$observePinnedMessage$1(StorePinnedMessages storePinnedMessages, long j, long j2) {
        super(0);
        this.this$0 = storePinnedMessages;
        this.$channelId = j;
        this.$messageId = j2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Message invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Message invoke() {
        List listEmptyList = (List) StorePinnedMessages.access$getPinnedMessages$p(this.this$0).get(Long.valueOf(this.$channelId));
        if (listEmptyList == null) {
            listEmptyList = n.emptyList();
        }
        return StorePinnedMessages$Companion.access$getMessage(StorePinnedMessages.Companion, listEmptyList, this.$messageId);
    }
}
