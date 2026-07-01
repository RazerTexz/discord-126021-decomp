package com.discord.widgets.chat.pins;

import android.content.Context;
import android.net.Uri;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import androidx.fragment.app.FragmentManager;
import b.a.d.j;
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
import com.discord.stores.SelectedChannelAnalyticsLocation;
import com.discord.stores.StoreChat$InteractionState;
import com.discord.stores.StoreStream;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.widgets.chat.WidgetUrlActions;
import com.discord.widgets.chat.list.actions.WidgetChatListActions;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler$DefaultImpls;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage$CallStatus;
import d0.z.d.m;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: WidgetChannelPinnedMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelPinnedMessages$ChannelPinnedMessagesAdapterEventHandler implements WidgetChatListAdapter$EventHandler {
    private final ChannelSelector channelSelector;
    private final Context context;
    private final FragmentManager fragmentManager;

    public WidgetChannelPinnedMessages$ChannelPinnedMessagesAdapterEventHandler(Context context, FragmentManager fragmentManager, ChannelSelector channelSelector) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(channelSelector, "channelSelector");
        this.context = context;
        this.fragmentManager = fragmentManager;
        this.channelSelector = channelSelector;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onBotUiComponentClicked(long j, Long l, long j2, long j3, Long l2, int i, RestAPIParams$ComponentInteractionData restAPIParams$ComponentInteractionData) {
        m.checkNotNullParameter(restAPIParams$ComponentInteractionData, "componentSendData");
        WidgetChatListAdapter$EventHandler$DefaultImpls.onBotUiComponentClicked(this, j, l, j2, j3, l2, i, restAPIParams$ComponentInteractionData);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onCallMessageClicked(long j, WidgetChatListAdapterItemCallMessage$CallStatus widgetChatListAdapterItemCallMessage$CallStatus) {
        m.checkNotNullParameter(widgetChatListAdapterItemCallMessage$CallStatus, "callStatus");
        WidgetChatListAdapter$EventHandler$DefaultImpls.onCallMessageClicked(this, j, widgetChatListAdapterItemCallMessage$CallStatus);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onCommandClicked(long j, Long l, long j2, long j3, long j4, long j5, String str) {
        WidgetChatListAdapter$EventHandler$DefaultImpls.onCommandClicked(this, j, l, j2, j3, j4, j5, str);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onDismissClicked(Message message) {
        m.checkNotNullParameter(message, "message");
        WidgetChatListAdapter$EventHandler$DefaultImpls.onDismissClicked(this, message);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onDismissLocalMessageClicked(Message message) {
        m.checkNotNullParameter(message, "message");
        WidgetChatListAdapter$EventHandler$DefaultImpls.onDismissLocalMessageClicked(this, message);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onInteractionStateUpdated(StoreChat$InteractionState storeChat$InteractionState) {
        m.checkNotNullParameter(storeChat$InteractionState, "interactionState");
        WidgetChatListAdapter$EventHandler$DefaultImpls.onInteractionStateUpdated(this, storeChat$InteractionState);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onListClicked() {
        WidgetChatListAdapter$EventHandler$DefaultImpls.onListClicked(this);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onMessageAuthorAvatarClicked(Message message, long j) {
        m.checkNotNullParameter(message, "message");
        WidgetChatListAdapter$EventHandler$DefaultImpls.onMessageAuthorAvatarClicked(this, message, j);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onMessageAuthorLongClicked(Message message, Long l) {
        m.checkNotNullParameter(message, "message");
        WidgetChatListAdapter$EventHandler$DefaultImpls.onMessageAuthorLongClicked(this, message, l);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onMessageAuthorNameClicked(Message message, long j) {
        m.checkNotNullParameter(message, "message");
        WidgetChatListAdapter$EventHandler$DefaultImpls.onMessageAuthorNameClicked(this, message, j);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onMessageBlockedGroupClicked(Message message) {
        m.checkNotNullParameter(message, "message");
        WidgetChatListAdapter$EventHandler$DefaultImpls.onMessageBlockedGroupClicked(this, message);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onMessageClicked(Message message, boolean isThreadStarterMessage) {
        m.checkNotNullParameter(message, "message");
        StoreStream.Companion.getMessagesLoader().jumpToMessage(message.getChannelId(), message.getId());
        j.c(this.context, false, null, 6);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onMessageLongClicked(Message message, CharSequence formattedMessage, boolean isThreadStarterMessage) {
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(formattedMessage, "formattedMessage");
        WidgetChatListActions.Companion.showForPin(this.fragmentManager, message.getChannelId(), message.getId(), formattedMessage);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onOldestMessageId(long j, long j2) {
        WidgetChatListAdapter$EventHandler$DefaultImpls.onOldestMessageId(this, j, j2);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onOpenPinsClicked(Message message) {
        m.checkNotNullParameter(message, "message");
        WidgetChatListAdapter$EventHandler$DefaultImpls.onOpenPinsClicked(this, message);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onQuickAddReactionClicked(long j, long j2, long j3, long j4) {
        WidgetChatListAdapter$EventHandler$DefaultImpls.onQuickAddReactionClicked(this, j, j2, j3, j4);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public boolean onQuickDownloadClicked(Uri uri, String str) {
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(str, "fileName");
        return WidgetChatListAdapter$EventHandler$DefaultImpls.onQuickDownloadClicked(this, uri, str);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onReactionClicked(long j, long j2, long j3, long j4, MessageReaction messageReaction, boolean z2) {
        m.checkNotNullParameter(messageReaction, "reaction");
        WidgetChatListAdapter$EventHandler$DefaultImpls.onReactionClicked(this, j, j2, j3, j4, messageReaction, z2);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onReactionLongClicked(long j, long j2, long j3, MessageReaction messageReaction) {
        m.checkNotNullParameter(messageReaction, "reaction");
        WidgetChatListAdapter$EventHandler$DefaultImpls.onReactionLongClicked(this, j, j2, j3, messageReaction);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onReportIssueWithAutoMod(Context context, Message message) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(message, "message");
        WidgetChatListAdapter$EventHandler$DefaultImpls.onReportIssueWithAutoMod(this, context, message);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onRoleSubscriptionPurchaseTierClick(long j, long j2, long j3, long j4, long j5) {
        WidgetChatListAdapter$EventHandler$DefaultImpls.onRoleSubscriptionPurchaseTierClick(this, j, j2, j3, j4, j5);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onSendGreetMessageClicked(long j, int i, Sticker sticker) {
        m.checkNotNullParameter(sticker, "sticker");
        WidgetChatListAdapter$EventHandler$DefaultImpls.onSendGreetMessageClicked(this, j, i, sticker);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onShareButtonClick(GuildScheduledEvent guildScheduledEvent, WeakReference<Context> weakReference, WeakReference<AppFragment> weakReference2) {
        m.checkNotNullParameter(guildScheduledEvent, "guildEvent");
        m.checkNotNullParameter(weakReference, "weakContext");
        m.checkNotNullParameter(weakReference2, "weakFragment");
        WidgetChatListAdapter$EventHandler$DefaultImpls.onShareButtonClick(this, guildScheduledEvent, weakReference, weakReference2);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onStickerClicked(Message message, BaseSticker sticker) {
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(sticker, "sticker");
        StoreStream.Companion.getMessagesLoader().jumpToMessage(message.getChannelId(), message.getId());
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onSystemMessageCtaClicked(Message message, Channel channel, BaseSticker baseSticker) {
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(baseSticker, "sticker");
        WidgetChatListAdapter$EventHandler$DefaultImpls.onSystemMessageCtaClicked(this, message, channel, baseSticker);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onThreadClicked(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        ChannelSelector.selectChannel$default(this.channelSelector, channel, null, SelectedChannelAnalyticsLocation.EMBED, 2, null);
        j.c(this.context, false, null, 6);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onThreadLongClicked(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        WidgetChatListAdapter$EventHandler$DefaultImpls.onThreadLongClicked(this, channel);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onUrlLongClicked(String url) {
        m.checkNotNullParameter(url, "url");
        WidgetUrlActions.Companion.launch(this.fragmentManager, url);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onUserActivityAction(long j, long j2, long j3, MessageActivityType messageActivityType, Activity activity, Application application) {
        m.checkNotNullParameter(messageActivityType, "messageActivityType");
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        m.checkNotNullParameter(application, "application");
        WidgetChatListAdapter$EventHandler$DefaultImpls.onUserActivityAction(this, j, j2, j3, messageActivityType, activity, application);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onUserMentionClicked(long j, long j2, long j3) {
        WidgetChatListAdapter$EventHandler$DefaultImpls.onUserMentionClicked(this, j, j2, j3);
    }
}
