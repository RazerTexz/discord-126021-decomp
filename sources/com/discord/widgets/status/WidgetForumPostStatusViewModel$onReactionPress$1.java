package com.discord.widgets.status;

import com.discord.api.message.reaction.MessageReaction;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumPostStatusViewModel$onReactionPress$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ boolean $hasAddReactionPermission;
    public final /* synthetic */ long $messageId;
    public final /* synthetic */ long $myUserId;
    public final /* synthetic */ MessageReaction $reaction;
    public final /* synthetic */ WidgetForumPostStatusViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumPostStatusViewModel$onReactionPress$1(WidgetForumPostStatusViewModel widgetForumPostStatusViewModel, boolean z2, long j, long j2, long j3, MessageReaction messageReaction) {
        super(0);
        this.this$0 = widgetForumPostStatusViewModel;
        this.$hasAddReactionPermission = z2;
        this.$myUserId = j;
        this.$channelId = j2;
        this.$messageId = j3;
        this.$reaction = messageReaction;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.$hasAddReactionPermission) {
            WidgetForumPostStatusViewModel.access$getUserReactionHandler$p(this.this$0).toggleReaction(this.$myUserId, this.$channelId, this.$messageId, this.$reaction);
        }
    }
}
