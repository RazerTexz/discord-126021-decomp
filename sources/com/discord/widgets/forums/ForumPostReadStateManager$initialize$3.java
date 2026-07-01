package com.discord.widgets.forums;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel;
import com.discord.stores.StoreMessageAck$Ack;
import d0.z.d.o;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ForumPostReadStateManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ForumPostReadStateManager$initialize$3 extends o implements Function1<ForumPostReadStateManager$ManagerInitializeState, Unit> {
    public static final ForumPostReadStateManager$initialize$3 INSTANCE = new ForumPostReadStateManager$initialize$3();

    public ForumPostReadStateManager$initialize$3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ForumPostReadStateManager$ManagerInitializeState forumPostReadStateManager$ManagerInitializeState) {
        invoke2(forumPostReadStateManager$ManagerInitializeState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ForumPostReadStateManager$ManagerInitializeState forumPostReadStateManager$ManagerInitializeState) {
        Map<Long, StoreMessageAck$Ack> mapComponent1 = forumPostReadStateManager$ManagerInitializeState.component1();
        StoreChannelsSelected$ResolvedSelectedChannel resolvedSelectedChannel = forumPostReadStateManager$ManagerInitializeState.getResolvedSelectedChannel();
        Set<Long> setComponent3 = forumPostReadStateManager$ManagerInitializeState.component3();
        Channel maybeChannel = resolvedSelectedChannel.getMaybeChannel();
        if (maybeChannel == null || !ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, maybeChannel.getGuildId(), null, 2, null)) {
            return;
        }
        boolean z2 = setComponent3.contains(Long.valueOf(maybeChannel.getGuildId())) && maybeChannel.getGuildId() != ForumPostReadStateManager.access$getLastSyncedGuildId$p(ForumPostReadStateManager.INSTANCE);
        boolean z3 = ChannelUtils.q(maybeChannel) && maybeChannel.getId() != ForumPostReadStateManager.access$getLastSelectedChannelId$p(ForumPostReadStateManager.INSTANCE);
        if (z2) {
            ForumPostReadStateManager forumPostReadStateManager = ForumPostReadStateManager.INSTANCE;
            ForumPostReadStateManager.access$setInternalMessageAcks$p(forumPostReadStateManager, mapComponent1);
            ForumPostReadStateManager.access$setLastSyncedGuildId$p(forumPostReadStateManager, maybeChannel.getGuildId());
        }
        if (z3 || z2) {
            ForumPostReadStateManager forumPostReadStateManager2 = ForumPostReadStateManager.INSTANCE;
            ForumPostReadStateManager.access$getForumChannelAckBeforeChannelSelect$p(forumPostReadStateManager2).onNext(ForumPostReadStateManager.access$getInternalMessageAcks$p(forumPostReadStateManager2).get(Long.valueOf(maybeChannel.getId())));
        }
        ForumPostReadStateManager forumPostReadStateManager3 = ForumPostReadStateManager.INSTANCE;
        ForumPostReadStateManager.access$setLastSelectedChannelId$p(forumPostReadStateManager3, resolvedSelectedChannel.getId());
        ForumPostReadStateManager.access$setInternalMessageAcks$p(forumPostReadStateManager3, mapComponent1);
    }
}
