package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: WidgetChatListAdapterItemStageInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemStageInvite$configureUI$2 implements View$OnClickListener {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ WidgetChatListAdapterItemStageInvite$Model $model;
    public final /* synthetic */ WidgetChatListAdapterItemStageInvite this$0;

    public WidgetChatListAdapterItemStageInvite$configureUI$2(WidgetChatListAdapterItemStageInvite widgetChatListAdapterItemStageInvite, WidgetChatListAdapterItemStageInvite$Model widgetChatListAdapterItemStageInvite$Model, Context context) {
        this.this$0 = widgetChatListAdapterItemStageInvite;
        this.$model = widgetChatListAdapterItemStageInvite$Model;
        this.$context = context;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0023  */
    /* JADX WARN: Code duplicated, block: B:13:0x002f  */
    /* JADX WARN: Code duplicated, block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:21:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Long lValueOf;
        long guildId;
        long jLongValue;
        Channel channel;
        Job jobAccess$getInviteJoinJob$p;
        Guild guild = this.$model.getInvite().guild;
        if (guild == null) {
            Channel channel2 = this.$model.getChannel();
            if (channel2 != null) {
                guildId = channel2.getGuildId();
            } else {
                lValueOf = null;
            }
            if (lValueOf != null) {
                jLongValue = lValueOf.longValue();
                channel = this.$model.getChannel();
                if (channel != null) {
                    long id2 = channel.getId();
                    jobAccess$getInviteJoinJob$p = WidgetChatListAdapterItemStageInvite.access$getInviteJoinJob$p(this.this$0);
                    if (jobAccess$getInviteJoinJob$p == null && jobAccess$getInviteJoinJob$p.a()) {
                        return;
                    }
                    WidgetChatListAdapterItemStageInvite widgetChatListAdapterItemStageInvite = this.this$0;
                    WidgetChatListAdapterItemStageInvite.access$setInviteJoinJob$p(widgetChatListAdapterItemStageInvite, WidgetChatListAdapterItemInviteBase.joinServerOrDM$default(widgetChatListAdapterItemStageInvite, widgetChatListAdapterItemStageInvite.getClass(), this.$model.getInvite(), new WidgetChatListAdapterItemStageInvite$configureUI$2$1(this, jLongValue, id2, null), null, 8, null));
                }
            }
        }
        guildId = guild.getId();
        lValueOf = Long.valueOf(guildId);
        if (lValueOf != null) {
            jLongValue = lValueOf.longValue();
            channel = this.$model.getChannel();
            if (channel != null) {
                long id3 = channel.getId();
                jobAccess$getInviteJoinJob$p = WidgetChatListAdapterItemStageInvite.access$getInviteJoinJob$p(this.this$0);
                if (jobAccess$getInviteJoinJob$p == null) {
                }
                WidgetChatListAdapterItemStageInvite widgetChatListAdapterItemStageInvite2 = this.this$0;
                WidgetChatListAdapterItemStageInvite.access$setInviteJoinJob$p(widgetChatListAdapterItemStageInvite2, WidgetChatListAdapterItemInviteBase.joinServerOrDM$default(widgetChatListAdapterItemStageInvite2, widgetChatListAdapterItemStageInvite2.getClass(), this.$model.getInvite(), new WidgetChatListAdapterItemStageInvite$configureUI$2$1(this, jLongValue, id3, null), null, 8, null));
            }
        }
    }
}
