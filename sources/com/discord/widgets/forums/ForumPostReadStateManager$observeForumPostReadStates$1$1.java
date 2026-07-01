package com.discord.widgets.forums;

import com.discord.stores.StoreMessageAck$Ack;
import d0.z.d.o;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ForumPostReadStateManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ForumPostReadStateManager$observeForumPostReadStates$1$1 extends o implements Function1<Long, ForumPostReadState> {
    public final /* synthetic */ StoreMessageAck$Ack $forumChannelAck;
    public final /* synthetic */ Set $persistedThreadIds;
    public final /* synthetic */ Set $unreadChannelIds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumPostReadStateManager$observeForumPostReadStates$1$1(StoreMessageAck$Ack storeMessageAck$Ack, Set set, Set set2) {
        super(1);
        this.$forumChannelAck = storeMessageAck$Ack;
        this.$persistedThreadIds = set;
        this.$unreadChannelIds = set2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ForumPostReadState invoke(Long l) {
        return invoke(l.longValue());
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0035  */
    public final ForumPostReadState invoke(long j) {
        boolean z2;
        if (this.$persistedThreadIds.contains(Long.valueOf(j))) {
            z2 = true;
        } else {
            StoreMessageAck$Ack storeMessageAck$Ack = this.$forumChannelAck;
            if ((storeMessageAck$Ack != null ? Long.valueOf(storeMessageAck$Ack.getMessageId()) : null) == null || ForumPostReadStateManager.access$compareChannelIds(ForumPostReadStateManager.INSTANCE, Long.valueOf(j), Long.valueOf(this.$forumChannelAck.getMessageId())) <= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        return new ForumPostReadState(j, z2, this.$unreadChannelIds.contains(Long.valueOf(j)));
    }
}
