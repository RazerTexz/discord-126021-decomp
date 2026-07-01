package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.net.Uri;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import com.discord.api.activity.Activity;
import com.discord.api.application.Application;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.message.activity.MessageActivityType;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.sticker.BaseSticker;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppFragment;
import com.discord.models.message.Message;
import com.discord.restapi.RestAPIParams$ComponentInteractionData;
import com.discord.stores.StoreChat$InteractionState;
import com.discord.widgets.guild_automod.WidgetReportIssueWithAutoMod;
import d0.z.d.m;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: WidgetChatListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapter$EventHandler$DefaultImpls {
    public static void onBotUiComponentClicked(WidgetChatListAdapter$EventHandler widgetChatListAdapter$EventHandler, long j, Long l, long j2, long j3, Long l2, int i, RestAPIParams$ComponentInteractionData restAPIParams$ComponentInteractionData) {
        m.checkNotNullParameter(restAPIParams$ComponentInteractionData, "componentSendData");
    }

    public static void onCallMessageClicked(WidgetChatListAdapter$EventHandler widgetChatListAdapter$EventHandler, long j, WidgetChatListAdapterItemCallMessage$CallStatus widgetChatListAdapterItemCallMessage$CallStatus) {
        m.checkNotNullParameter(widgetChatListAdapterItemCallMessage$CallStatus, "callStatus");
    }

    public static void onCommandClicked(WidgetChatListAdapter$EventHandler widgetChatListAdapter$EventHandler, long j, Long l, long j2, long j3, long j4, long j5, String str) {
    }

    public static void onDismissClicked(WidgetChatListAdapter$EventHandler widgetChatListAdapter$EventHandler, Message message) {
        m.checkNotNullParameter(message, "message");
    }

    public static void onDismissLocalMessageClicked(WidgetChatListAdapter$EventHandler widgetChatListAdapter$EventHandler, Message message) {
        m.checkNotNullParameter(message, "message");
    }

    public static void onInteractionStateUpdated(WidgetChatListAdapter$EventHandler widgetChatListAdapter$EventHandler, StoreChat$InteractionState storeChat$InteractionState) {
        m.checkNotNullParameter(storeChat$InteractionState, "interactionState");
    }

    public static void onListClicked(WidgetChatListAdapter$EventHandler widgetChatListAdapter$EventHandler) {
    }

    public static void onMessageAuthorAvatarClicked(WidgetChatListAdapter$EventHandler widgetChatListAdapter$EventHandler, Message message, long j) {
        m.checkNotNullParameter(message, "message");
    }

    public static void onMessageAuthorLongClicked(WidgetChatListAdapter$EventHandler widgetChatListAdapter$EventHandler, Message message, Long l) {
        m.checkNotNullParameter(message, "message");
    }

    public static void onMessageAuthorNameClicked(WidgetChatListAdapter$EventHandler widgetChatListAdapter$EventHandler, Message message, long j) {
        m.checkNotNullParameter(message, "message");
    }

    public static void onMessageBlockedGroupClicked(WidgetChatListAdapter$EventHandler widgetChatListAdapter$EventHandler, Message message) {
        m.checkNotNullParameter(message, "message");
    }

    public static void onMessageClicked(WidgetChatListAdapter$EventHandler widgetChatListAdapter$EventHandler, Message message, boolean z2) {
        m.checkNotNullParameter(message, "message");
    }

    public static void onMessageLongClicked(WidgetChatListAdapter$EventHandler widgetChatListAdapter$EventHandler, Message message, CharSequence charSequence, boolean z2) {
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(charSequence, "formattedMessage");
    }

    public static void onOldestMessageId(WidgetChatListAdapter$EventHandler widgetChatListAdapter$EventHandler, long j, long j2) {
    }

    public static void onOpenPinsClicked(WidgetChatListAdapter$EventHandler widgetChatListAdapter$EventHandler, Message message) {
        m.checkNotNullParameter(message, "message");
    }

    public static void onQuickAddReactionClicked(WidgetChatListAdapter$EventHandler widgetChatListAdapter$EventHandler, long j, long j2, long j3, long j4) {
    }

    public static boolean onQuickDownloadClicked(WidgetChatListAdapter$EventHandler widgetChatListAdapter$EventHandler, Uri uri, String str) {
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(str, "fileName");
        return false;
    }

    public static void onReactionClicked(WidgetChatListAdapter$EventHandler widgetChatListAdapter$EventHandler, long j, long j2, long j3, long j4, MessageReaction messageReaction, boolean z2) {
        m.checkNotNullParameter(messageReaction, "reaction");
    }

    public static void onReactionLongClicked(WidgetChatListAdapter$EventHandler widgetChatListAdapter$EventHandler, long j, long j2, long j3, MessageReaction messageReaction) {
        m.checkNotNullParameter(messageReaction, "reaction");
    }

    public static void onReportIssueWithAutoMod(WidgetChatListAdapter$EventHandler widgetChatListAdapter$EventHandler, Context context, Message message) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(message, "message");
        WidgetReportIssueWithAutoMod.Companion.launch(context, message.getChannelId(), message.getId());
    }

    public static void onRoleSubscriptionPurchaseTierClick(WidgetChatListAdapter$EventHandler widgetChatListAdapter$EventHandler, long j, long j2, long j3, long j4, long j5) {
    }

    public static void onSendGreetMessageClicked(WidgetChatListAdapter$EventHandler widgetChatListAdapter$EventHandler, long j, int i, Sticker sticker) {
        m.checkNotNullParameter(sticker, "sticker");
    }

    public static void onShareButtonClick(WidgetChatListAdapter$EventHandler widgetChatListAdapter$EventHandler, GuildScheduledEvent guildScheduledEvent, WeakReference<Context> weakReference, WeakReference<AppFragment> weakReference2) {
        m.checkNotNullParameter(guildScheduledEvent, "guildEvent");
        m.checkNotNullParameter(weakReference, "weakContext");
        m.checkNotNullParameter(weakReference2, "weakFragment");
    }

    public static void onStickerClicked(WidgetChatListAdapter$EventHandler widgetChatListAdapter$EventHandler, Message message, BaseSticker baseSticker) {
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(baseSticker, "sticker");
    }

    public static void onSystemMessageCtaClicked(WidgetChatListAdapter$EventHandler widgetChatListAdapter$EventHandler, Message message, Channel channel, BaseSticker baseSticker) {
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(baseSticker, "sticker");
    }

    public static void onThreadClicked(WidgetChatListAdapter$EventHandler widgetChatListAdapter$EventHandler, Channel channel) {
        m.checkNotNullParameter(channel, "channel");
    }

    public static void onThreadLongClicked(WidgetChatListAdapter$EventHandler widgetChatListAdapter$EventHandler, Channel channel) {
        m.checkNotNullParameter(channel, "channel");
    }

    public static void onUrlLongClicked(WidgetChatListAdapter$EventHandler widgetChatListAdapter$EventHandler, String str) {
        m.checkNotNullParameter(str, "url");
    }

    public static void onUserActivityAction(WidgetChatListAdapter$EventHandler widgetChatListAdapter$EventHandler, long j, long j2, long j3, MessageActivityType messageActivityType, Activity activity, Application application) {
        m.checkNotNullParameter(messageActivityType, "messageActivityType");
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        m.checkNotNullParameter(application, "application");
    }

    public static void onUserMentionClicked(WidgetChatListAdapter$EventHandler widgetChatListAdapter$EventHandler, long j, long j2, long j3) {
    }
}
