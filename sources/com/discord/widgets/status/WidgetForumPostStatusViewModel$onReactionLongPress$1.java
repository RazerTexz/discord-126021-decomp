package com.discord.widgets.status;

import android.content.Context;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.widgets.chat.managereactions.WidgetManageReactions;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumPostStatusViewModel$onReactionLongPress$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ long $messageId;
    public final /* synthetic */ MessageReaction $reaction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumPostStatusViewModel$onReactionLongPress$1(long j, long j2, Context context, MessageReaction messageReaction) {
        super(0);
        this.$channelId = j;
        this.$messageId = j2;
        this.$context = context;
        this.$reaction = messageReaction;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetManageReactions.Companion.create(this.$channelId, this.$messageId, this.$context, this.$reaction);
    }
}
