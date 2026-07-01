package com.discord.widgets.user;

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
import com.discord.stores.SelectedChannelAnalyticsLocation;
import com.discord.stores.StoreChat$InteractionState;
import com.discord.stores.StoreNavigation$PanelAction;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler$DefaultImpls;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage$CallStatus;
import d0.z.d.m;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMentions$UserMentionsAdapterEventHandler implements WidgetChatListAdapter$EventHandler {
    private final ChannelSelector channelSelector;
    private final Function1<StoreChat$InteractionState, Unit> interactionStateUpdated;
    private final boolean isEmbedded;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetUserMentions$UserMentionsAdapterEventHandler(boolean z2, ChannelSelector channelSelector, Function1<? super StoreChat$InteractionState, Unit> function1) {
        m.checkNotNullParameter(channelSelector, "channelSelector");
        m.checkNotNullParameter(function1, "interactionStateUpdated");
        this.isEmbedded = z2;
        this.channelSelector = channelSelector;
        this.interactionStateUpdated = function1;
    }

    private final void jumpToMessage(Message message) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        storeStream$Companion.getMessagesLoader().jumpToMessage(message.getChannelId(), message.getId());
        storeStream$Companion.getTabsNavigation().selectHomeTab(StoreNavigation$PanelAction.CLOSE, this.isEmbedded);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onBotUiComponentClicked(long j, Long l, long j2, long j3, Long l2, int i, RestAPIParams$ComponentInteractionData restAPIParams$ComponentInteractionData) {
        m.checkNotNullParameter(restAPIParams$ComponentInteractionData, "componentSendData");
        WidgetChatListAdapter$EventHandler$DefaultImpls.onBotUiComponentClicked(this, j, l, j2, j3, l2, i, restAPIParams$ComponentInteractionData);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onCallMessageClicked(long voiceChannelId, WidgetChatListAdapterItemCallMessage$CallStatus callStatus) {
        m.checkNotNullParameter(callStatus, "callStatus");
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
    public void onInteractionStateUpdated(StoreChat$InteractionState interactionState) {
        m.checkNotNullParameter(interactionState, "interactionState");
        this.interactionStateUpdated.invoke(interactionState);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onListClicked() {
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onMessageAuthorAvatarClicked(Message message, long guildId) {
        m.checkNotNullParameter(message, "message");
        jumpToMessage(message);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onMessageAuthorLongClicked(Message message, Long guildId) {
        m.checkNotNullParameter(message, "message");
        jumpToMessage(message);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onMessageAuthorNameClicked(Message message, long guildId) {
        m.checkNotNullParameter(message, "message");
        jumpToMessage(message);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onMessageBlockedGroupClicked(Message message) {
        m.checkNotNullParameter(message, "message");
        jumpToMessage(message);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onMessageClicked(Message message, boolean isThreadStarterMessage) {
        m.checkNotNullParameter(message, "message");
        jumpToMessage(message);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onMessageLongClicked(Message message, CharSequence formattedMessage, boolean isThreadStarterMessage) {
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(formattedMessage, "formattedMessage");
        jumpToMessage(message);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onOldestMessageId(long channelId, long oldestMessageId) {
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onOpenPinsClicked(Message message) {
        m.checkNotNullParameter(message, "message");
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onQuickAddReactionClicked(long guildId, long myUserId, long channelId, long messageId) {
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public boolean onQuickDownloadClicked(Uri uri, String fileName) {
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(fileName, "fileName");
        return false;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onReactionClicked(long guildId, long myUserId, long channelId, long messageId, MessageReaction reaction, boolean canAddReactions) {
        m.checkNotNullParameter(reaction, "reaction");
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onReactionLongClicked(long guildId, long channelId, long messageId, MessageReaction reaction) {
        m.checkNotNullParameter(reaction, "reaction");
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
        StoreStream.Companion.getTabsNavigation().selectHomeTab(StoreNavigation$PanelAction.CLOSE, this.isEmbedded);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onThreadLongClicked(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        WidgetChatListAdapter$EventHandler$DefaultImpls.onThreadLongClicked(this, channel);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onUrlLongClicked(String str) {
        m.checkNotNullParameter(str, "url");
        WidgetChatListAdapter$EventHandler$DefaultImpls.onUrlLongClicked(this, str);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onUserActivityAction(long authorId, long channelId, long messageId, MessageActivityType actionType, Activity activity, Application application) {
        m.checkNotNullParameter(actionType, "actionType");
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        m.checkNotNullParameter(application, "application");
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onUserMentionClicked(long j, long j2, long j3) {
        WidgetChatListAdapter$EventHandler$DefaultImpls.onUserMentionClicked(this, j, j2, j3);
    }
}
