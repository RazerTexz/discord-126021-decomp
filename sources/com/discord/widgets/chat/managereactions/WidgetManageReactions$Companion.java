package com.discord.widgets.chat.managereactions;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.message.reaction.MessageReactionEmoji;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetManageReactions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetManageReactions$Companion {
    private WidgetManageReactions$Companion() {
    }

    public static /* synthetic */ void create$default(WidgetManageReactions$Companion widgetManageReactions$Companion, long j, long j2, Context context, MessageReaction messageReaction, int i, Object obj) {
        if ((i & 8) != 0) {
            messageReaction = null;
        }
        widgetManageReactions$Companion.create(j, j2, context, messageReaction);
    }

    public final void create(long channelId, long messageId, Context context, MessageReaction targetedReaction) {
        MessageReactionEmoji emoji;
        m.checkNotNullParameter(context, "context");
        Intent intentPutExtra = new Intent().putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId).putExtra("com.discord.intent.extra.EXTRA_MESSAGE_ID", messageId).putExtra("com.discord.intent.extra.EXTRA_EMOJI_KEY", (targetedReaction == null || (emoji = targetedReaction.getEmoji()) == null) ? null : emoji.c());
        m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…eaction?.emoji?.getKey())");
        j.d(context, WidgetManageReactions.class, intentPutExtra);
    }

    public /* synthetic */ WidgetManageReactions$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
