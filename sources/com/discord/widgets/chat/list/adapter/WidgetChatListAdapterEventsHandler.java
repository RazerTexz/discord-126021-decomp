package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.net.Uri;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import androidx.fragment.app.FragmentManager;
import b.c.a.a0.d;
import com.discord.analytics.generated.events.TrackRoleSubscriptionPurchaseSystemMessageClicked;
import com.discord.analytics.generated.events.TrackRoleSubscriptionPurchaseSystemMessageCtaClicked;
import com.discord.analytics.generated.events.TrackWelcomeCtaClicked;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.api.activity.Activity;
import com.discord.api.application.Application;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.message.MessageReference;
import com.discord.api.message.activity.MessageActivityType;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.sticker.BaseSticker;
import com.discord.api.sticker.Sticker;
import com.discord.api.user.User;
import com.discord.app.AppFragment;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.message.Message;
import com.discord.models.user.CoreUser;
import com.discord.restapi.RestAPIParams$ComponentInteractionData;
import com.discord.restapi.RestAPIParams$GreetMessage;
import com.discord.stores.SelectedChannelAnalyticsLocation;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChat;
import com.discord.stores.StoreChat$InteractionState;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreMessages;
import com.discord.stores.StorePendingReplies;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.AnalyticsUtils$Tracker;
import com.discord.utilities.analytics.Traits$Location$Section;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.guilds.MemberVerificationUtils;
import com.discord.utilities.guilds.PublicGuildUtils;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities$Companion;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions;
import com.discord.widgets.chat.MessageManager;
import com.discord.widgets.chat.WidgetUrlActions;
import com.discord.widgets.chat.input.AppFlexInputViewModel;
import com.discord.widgets.chat.list.actions.WidgetChatListActions;
import com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheet;
import com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheet$Companion;
import com.discord.widgets.chat.pins.WidgetChannelPinnedMessages;
import com.discord.widgets.guild_automod.WidgetReportIssueWithAutoMod;
import com.discord.widgets.guild_role_subscriptions.entrypoint.WidgetGuildRoleSubscriptionEntryPoint;
import com.discord.widgets.guilds.profile.WidgetGuildProfileSheet;
import com.discord.widgets.guilds.profile.WidgetGuildProfileSheet$Companion;
import com.discord.widgets.guilds.profile.WidgetPublicAnnouncementProfileSheet;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventUrlUtils;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.discord.widgets.user.usersheet.WidgetUserSheet$Companion;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$Companion;
import com.discord.widgets.voice.fullscreen.WidgetStartCallSheet;
import d0.o;
import d0.t.h0;
import d0.z.d.m;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterEventsHandler implements WidgetChatListAdapter$EventHandler {
    private final AnalyticsUtils$Tracker analyticsTracker;
    private final ChannelSelector channelSelector;
    private final StoreChannels channelStore;
    private final AppFlexInputViewModel flexInputViewModel;
    private final AppFragment host;
    private final MessageManager messageManager;
    private final StoreChat storeChat;
    private final StoreEmoji storeEmoji;
    private final StoreMessages storeMessages;
    private final StorePendingReplies storePendingReplies;
    private final StoreUser storeUser;
    private final WidgetChatListAdapterEventsHandler$UserReactionHandler userReactionHandler;

    public WidgetChatListAdapterEventsHandler(AppFragment appFragment, AppFlexInputViewModel appFlexInputViewModel, StoreChat storeChat, StoreMessages storeMessages, StorePendingReplies storePendingReplies, StoreUser storeUser, StoreEmoji storeEmoji, MessageManager messageManager, ChannelSelector channelSelector, WidgetChatListAdapterEventsHandler$UserReactionHandler widgetChatListAdapterEventsHandler$UserReactionHandler, StoreChannels storeChannels, AnalyticsUtils$Tracker analyticsUtils$Tracker) {
        m.checkNotNullParameter(appFragment, "host");
        m.checkNotNullParameter(appFlexInputViewModel, "flexInputViewModel");
        m.checkNotNullParameter(storeChat, "storeChat");
        m.checkNotNullParameter(storeMessages, "storeMessages");
        m.checkNotNullParameter(storePendingReplies, "storePendingReplies");
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(storeEmoji, "storeEmoji");
        m.checkNotNullParameter(messageManager, "messageManager");
        m.checkNotNullParameter(channelSelector, "channelSelector");
        m.checkNotNullParameter(widgetChatListAdapterEventsHandler$UserReactionHandler, "userReactionHandler");
        m.checkNotNullParameter(storeChannels, "channelStore");
        m.checkNotNullParameter(analyticsUtils$Tracker, "analyticsTracker");
        this.host = appFragment;
        this.flexInputViewModel = appFlexInputViewModel;
        this.storeChat = storeChat;
        this.storeMessages = storeMessages;
        this.storePendingReplies = storePendingReplies;
        this.storeUser = storeUser;
        this.storeEmoji = storeEmoji;
        this.messageManager = messageManager;
        this.channelSelector = channelSelector;
        this.userReactionHandler = widgetChatListAdapterEventsHandler$UserReactionHandler;
        this.channelStore = storeChannels;
        this.analyticsTracker = analyticsUtils$Tracker;
    }

    public static final /* synthetic */ Context access$getContext$p(WidgetChatListAdapterEventsHandler widgetChatListAdapterEventsHandler) {
        return widgetChatListAdapterEventsHandler.getContext();
    }

    public static final /* synthetic */ FragmentManager access$getFragmentManager$p(WidgetChatListAdapterEventsHandler widgetChatListAdapterEventsHandler) {
        return widgetChatListAdapterEventsHandler.getFragmentManager();
    }

    public static final /* synthetic */ WidgetChatListAdapterEventsHandler$UserReactionHandler access$getUserReactionHandler$p(WidgetChatListAdapterEventsHandler widgetChatListAdapterEventsHandler) {
        return widgetChatListAdapterEventsHandler.userReactionHandler;
    }

    private final Context getContext() {
        return this.host.requireContext();
    }

    private final FragmentManager getFragmentManager() {
        FragmentManager parentFragmentManager = this.host.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "host.parentFragmentManager");
        return parentFragmentManager;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onBotUiComponentClicked(long applicationId, Long guildId, long channelId, long messageId, Long messageFlags, int componentIndex, RestAPIParams$ComponentInteractionData componentSendData) {
        m.checkNotNullParameter(componentSendData, "componentSendData");
        StoreStream.Companion.getInteractions().sendComponentInteraction(applicationId, guildId, channelId, messageId, componentIndex, componentSendData, messageFlags);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onCallMessageClicked(long voiceChannelId, WidgetChatListAdapterItemCallMessage$CallStatus callStatus) {
        m.checkNotNullParameter(callStatus, "callStatus");
        int iOrdinal = callStatus.ordinal();
        if (iOrdinal == 0) {
            d.S1(this.host, null, new WidgetChatListAdapterEventsHandler$onCallMessageClicked$1(this, voiceChannelId), 1, null);
        } else if (iOrdinal != 1) {
            WidgetStartCallSheet.Companion.show(voiceChannelId, getFragmentManager());
        } else {
            WidgetCallFullscreen$Companion.launch$default(WidgetCallFullscreen.Companion, getContext(), voiceChannelId, false, null, null, 28, null);
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onCommandClicked(long interactionId, Long guildId, long channelId, long messageId, long interactionUserId, long applicationId, String messageNonce) {
        WidgetApplicationCommandBottomSheet$Companion widgetApplicationCommandBottomSheet$Companion = WidgetApplicationCommandBottomSheet.Companion;
        FragmentManager childFragmentManager = this.host.getChildFragmentManager();
        m.checkNotNullExpressionValue(childFragmentManager, "host.childFragmentManager");
        widgetApplicationCommandBottomSheet$Companion.show(childFragmentManager, interactionId, messageId, channelId, guildId, interactionUserId, applicationId, messageNonce);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onDismissClicked(Message message) {
        m.checkNotNullParameter(message, "message");
        this.storeMessages.deleteMessage(message);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onDismissLocalMessageClicked(Message message) {
        m.checkNotNullParameter(message, "message");
        String nonce = message.getNonce();
        if (nonce != null) {
            this.storeMessages.deleteLocalMessage(message.getChannelId(), nonce);
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onInteractionStateUpdated(StoreChat$InteractionState interactionState) {
        m.checkNotNullParameter(interactionState, "interactionState");
        this.storeChat.setInteractionState(interactionState);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onListClicked() {
        AppFragment.hideKeyboard$default(this.host, null, 1, null);
        this.flexInputViewModel.hideExpressionTray();
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onMessageAuthorAvatarClicked(Message message, long guildId) {
        m.checkNotNullParameter(message, "message");
        if (PublicGuildUtils.INSTANCE.isPublicGuildSystemMessage(message) || message.isCrosspost()) {
            onMessageAuthorNameClicked(message, guildId);
            return;
        }
        User author = message.getAuthor();
        if (author != null) {
            WidgetUserSheet$Companion.show$default(WidgetUserSheet.Companion, author.getId(), Long.valueOf(message.getChannelId()), getFragmentManager(), Long.valueOf(guildId), null, null, null, 112, null);
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onMessageAuthorLongClicked(Message message, Long guildId) {
        m.checkNotNullParameter(message, "message");
        if (message.isWebhook()) {
            b.a.d.m.g(getContext(), 2131896780, 0, null, 8);
            return;
        }
        User author = message.getAuthor();
        if (author != null) {
            WidgetUserSheet$Companion.show$default(WidgetUserSheet.Companion, author.getId(), Long.valueOf(message.getChannelId()), getFragmentManager(), guildId, null, null, null, 112, null);
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onMessageAuthorNameClicked(Message message, long guildId) {
        m.checkNotNullParameter(message, "message");
        if (PublicGuildUtils.INSTANCE.isPublicGuildSystemMessage(message)) {
            WidgetPublicAnnouncementProfileSheet.Companion.show(getFragmentManager());
            return;
        }
        if (!message.isCrosspost() || message.getMessageReference() == null) {
            StoreChat storeChat = this.storeChat;
            User author = message.getAuthor();
            m.checkNotNull(author);
            storeChat.appendMention(new CoreUser(author), guildId);
            return;
        }
        MessageReference messageReference = message.getMessageReference();
        Long channelId = messageReference != null ? messageReference.getChannelId() : null;
        MessageReference messageReference2 = message.getMessageReference();
        Long guildId2 = messageReference2 != null ? messageReference2.getGuildId() : null;
        if (guildId2 == null || channelId == null) {
            return;
        }
        WidgetGuildProfileSheet$Companion.show$default(WidgetGuildProfileSheet.Companion, getFragmentManager(), false, guildId2.longValue(), channelId.longValue(), false, 16, null);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onMessageBlockedGroupClicked(Message message) {
        m.checkNotNullParameter(message, "message");
        this.storeChat.toggleBlockedMessageGroup(message.getId());
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onMessageClicked(Message message, boolean isThreadStarterMessage) {
        m.checkNotNullParameter(message, "message");
        if (isThreadStarterMessage) {
            StoreStream.Companion.getMessagesLoader().jumpToMessage(message.getChannelId(), message.getId());
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onMessageLongClicked(Message message, CharSequence formattedMessage, boolean isThreadStarterMessage) {
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(formattedMessage, "formattedMessage");
        if (isThreadStarterMessage) {
            return;
        }
        WidgetChatListActions.Companion.showForChat(getFragmentManager(), message.getChannelId(), message.getId(), formattedMessage);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onOldestMessageId(long channelId, long oldestMessageId) {
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onOpenPinsClicked(Message message) {
        m.checkNotNullParameter(message, "message");
        WidgetChannelPinnedMessages.Companion.show(getContext(), message.getChannelId());
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onQuickAddReactionClicked(long guildId, long myUserId, long channelId, long messageId) {
        MemberVerificationUtils.maybeShowVerificationGate$default(MemberVerificationUtils.INSTANCE, getContext(), getFragmentManager(), guildId, Traits$Location$Section.EMOJI_PICKER_POPOUT, null, null, new WidgetChatListAdapterEventsHandler$onQuickAddReactionClicked$1(this, channelId, messageId), 32, null);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public boolean onQuickDownloadClicked(Uri uri, String fileName) {
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(fileName, "fileName");
        this.host.requestMediaDownload(new WidgetChatListAdapterEventsHandler$onQuickDownloadClicked$1(this, uri, fileName, new WeakReference(getContext())));
        return true;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onReactionClicked(long guildId, long myUserId, long channelId, long messageId, MessageReaction reaction, boolean canAddReactions) {
        m.checkNotNullParameter(reaction, "reaction");
        if (canAddReactions) {
            MemberVerificationUtils.maybeShowVerificationGate$default(MemberVerificationUtils.INSTANCE, getContext(), getFragmentManager(), guildId, Traits$Location$Section.EMOJI_PICKER_POPOUT, null, null, new WidgetChatListAdapterEventsHandler$onReactionClicked$1(this, myUserId, channelId, messageId, reaction), 32, null);
        } else {
            b.a.d.m.g(getContext(), 2131886865, 0, null, 8);
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onReactionLongClicked(long guildId, long channelId, long messageId, MessageReaction reaction) {
        m.checkNotNullParameter(reaction, "reaction");
        MemberVerificationUtils.maybeShowVerificationGate$default(MemberVerificationUtils.INSTANCE, getContext(), getFragmentManager(), guildId, Traits$Location$Section.EMOJI_PICKER_POPOUT, null, null, new WidgetChatListAdapterEventsHandler$onReactionLongClicked$1(this, channelId, messageId, reaction), 32, null);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onReportIssueWithAutoMod(Context context, Message message) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(message, "message");
        WidgetReportIssueWithAutoMod.Companion.launch(context, message.getChannelId(), message.getId());
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onRoleSubscriptionPurchaseTierClick(long roleSubscriptionListingId, long guildId, long userId, long channelId, long messageId) {
        WidgetGuildRoleSubscriptionEntryPoint.Companion.launch(getContext(), guildId, "Role Subscriptions Tab");
        AnalyticsUtils$Tracker analyticsUtils$Tracker = this.analyticsTracker;
        TrackRoleSubscriptionPurchaseSystemMessageClicked trackRoleSubscriptionPurchaseSystemMessageClicked = new TrackRoleSubscriptionPurchaseSystemMessageClicked(Long.valueOf(messageId), Long.valueOf(roleSubscriptionListingId));
        trackRoleSubscriptionPurchaseSystemMessageClicked.f(new TrackChannel(Long.valueOf(channelId), null, null, null, null, null, 62));
        trackRoleSubscriptionPurchaseSystemMessageClicked.c(new TrackGuild(Long.valueOf(guildId), null, null, null, null, null, null, null, null, null, null, null, 4094));
        trackRoleSubscriptionPurchaseSystemMessageClicked.e(new TrackBase(null, null, null, null, null, Long.valueOf(userId), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -33, -1, 2047));
        analyticsUtils$Tracker.track(trackRoleSubscriptionPurchaseSystemMessageClicked);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onSendGreetMessageClicked(long channelId, int channelType, Sticker sticker) {
        m.checkNotNullParameter(sticker, "sticker");
        AnalyticsTracker.INSTANCE.getTracker().track("dm_empty_action", h0.mutableMapOf(o.to(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID, Long.valueOf(channelId)), o.to("channel_type", Integer.valueOf(channelType)), o.to("source", "Wave"), o.to("type", "Send wave")));
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().sendGreetMessage(channelId, new RestAPIParams$GreetMessage(d0.t.m.listOf(Long.valueOf(sticker.getId())))), false, 1, null), this.host, null, 2, null), this.host.getClass(), this.host.getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, WidgetChatListAdapterEventsHandler$onSendGreetMessageClicked$1.INSTANCE, 60, (Object) null);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onShareButtonClick(GuildScheduledEvent guildScheduledEvent, WeakReference<Context> weakContext, WeakReference<AppFragment> weakFragment) {
        Channel channel;
        m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        m.checkNotNullParameter(weakContext, "weakContext");
        m.checkNotNullParameter(weakFragment, "weakFragment");
        long guildId = guildScheduledEvent.getGuildId();
        long id2 = guildScheduledEvent.getId();
        Long channelId = guildScheduledEvent.getChannelId();
        boolean zCanShareEvent$default = GuildScheduledEventUtilities$Companion.canShareEvent$default(GuildScheduledEventUtilities.Companion, channelId, guildId, null, null, null, null, 60, null);
        if (channelId != null) {
            channel = this.channelStore.getChannel(channelId.longValue());
        } else {
            channel = null;
        }
        if (zCanShareEvent$default) {
            Observable<Channel> observableZ = StoreStream.Companion.getChannels().observeDefaultChannel(guildId).z();
            m.checkNotNullExpressionValue(observableZ, "StoreStream.getChannels(…ildId)\n          .first()");
            ObservableExtensionsKt.appSubscribe$default(observableZ, WidgetChatListAdapterEventsHandler.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChatListAdapterEventsHandler$onShareButtonClick$1(weakFragment, channel, id2), 62, (Object) null);
        } else {
            Context context = weakContext.get();
            if (context != null) {
                CharSequence eventDetailsUrl = GuildScheduledEventUrlUtils.INSTANCE.getEventDetailsUrl(guildId, id2);
                m.checkNotNullExpressionValue(context, "context");
                b.a.d.m.c(context, eventDetailsUrl, 0, 4);
            }
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onStickerClicked(Message message, BaseSticker sticker) {
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(sticker, "sticker");
        WidgetChatListAdapterEventsHandler$onStickerClicked$1 widgetChatListAdapterEventsHandler$onStickerClicked$1 = new WidgetChatListAdapterEventsHandler$onStickerClicked$1(this, sticker, message);
        this.flexInputViewModel.hideKeyboard();
        if (sticker instanceof Sticker) {
            widgetChatListAdapterEventsHandler$onStickerClicked$1.invoke2(sticker);
        } else {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StickerUtils.INSTANCE.getGuildOrStandardSticker(sticker.getId(), true), this.host, null, 2, null), WidgetChatListAdapterEventsHandler.class, (Context) null, (Function1) null, new WidgetChatListAdapterEventsHandler$onStickerClicked$2(this, sticker), (Function0) null, (Function0) null, new WidgetChatListAdapterEventsHandler$onStickerClicked$3(widgetChatListAdapterEventsHandler$onStickerClicked$1), 54, (Object) null);
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onSystemMessageCtaClicked(Message message, Channel channel, BaseSticker sticker) {
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(sticker, "sticker");
        this.storePendingReplies.onCreatePendingReply(channel, message, true, true);
        MessageManager.sendMessage$default(this.messageManager, null, null, null, null, d0.t.m.listOf(sticker), false, null, null, null, 495, null);
        Integer type = message.getType();
        if (type != null && type.intValue() == 7) {
            AnalyticsUtils$Tracker analyticsUtils$Tracker = this.analyticsTracker;
            Boolean bool = Boolean.TRUE;
            String strValueOf = String.valueOf(sticker.getId());
            User author = message.getAuthor();
            analyticsUtils$Tracker.track(new TrackWelcomeCtaClicked(bool, strValueOf, author != null ? Long.valueOf(author.getId()) : null, Long.valueOf(this.storeUser.getMeSnapshot().getId())));
            return;
        }
        if (type != null && type.intValue() == 25) {
            AnalyticsUtils$Tracker analyticsUtils$Tracker2 = this.analyticsTracker;
            String strValueOf2 = String.valueOf(sticker.getId());
            User author2 = message.getAuthor();
            TrackRoleSubscriptionPurchaseSystemMessageCtaClicked trackRoleSubscriptionPurchaseSystemMessageCtaClicked = new TrackRoleSubscriptionPurchaseSystemMessageCtaClicked(Long.valueOf(message.getId()), strValueOf2, author2 != null ? Long.valueOf(author2.getId()) : null, Long.valueOf(this.storeUser.getMeSnapshot().getId()));
            trackRoleSubscriptionPurchaseSystemMessageCtaClicked.c(new TrackGuild(Long.valueOf(channel.getGuildId()), null, null, null, null, null, null, null, null, null, null, null, 4094));
            trackRoleSubscriptionPurchaseSystemMessageCtaClicked.e(new TrackChannel(Long.valueOf(channel.getId()), null, null, null, null, null, 62));
            analyticsUtils$Tracker2.track(trackRoleSubscriptionPurchaseSystemMessageCtaClicked);
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onThreadClicked(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        this.channelSelector.selectChannel(channel, Long.valueOf(channel.getParentId()), SelectedChannelAnalyticsLocation.EMBED);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onThreadLongClicked(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        WidgetChannelsListItemThreadActions.Companion.show(getFragmentManager(), channel.getId());
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onUrlLongClicked(String url) {
        m.checkNotNullParameter(url, "url");
        WidgetUrlActions.Companion.launch(getFragmentManager(), url);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onUserActivityAction(long authorId, long channelId, long messageId, MessageActivityType actionType, Activity activity, Application application) {
        m.checkNotNullParameter(actionType, "actionType");
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        m.checkNotNullParameter(application, "application");
        Long applicationId = activity.getApplicationId();
        String sessionId = activity.getSessionId();
        if (applicationId == null || sessionId == null || actionType != MessageActivityType.JOIN) {
            return;
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().userActivityActionJoin(authorId, applicationId.longValue(), sessionId, Long.valueOf(channelId), Long.valueOf(messageId)), false, 1, null), this.host, null, 2, null), WidgetChatListAdapterEventsHandler.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChatListAdapterEventsHandler$onUserActivityAction$1(this, application), 62, (Object) null);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$EventHandler
    public void onUserMentionClicked(long userId, long channelId, long guildId) {
        WidgetUserSheet$Companion.show$default(WidgetUserSheet.Companion, userId, Long.valueOf(channelId), getFragmentManager(), Long.valueOf(guildId), null, null, null, 112, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetChatListAdapterEventsHandler(AppFragment appFragment, AppFlexInputViewModel appFlexInputViewModel, StoreChat storeChat, StoreMessages storeMessages, StorePendingReplies storePendingReplies, StoreUser storeUser, StoreEmoji storeEmoji, MessageManager messageManager, ChannelSelector channelSelector, WidgetChatListAdapterEventsHandler$UserReactionHandler widgetChatListAdapterEventsHandler$UserReactionHandler, StoreChannels storeChannels, AnalyticsUtils$Tracker analyticsUtils$Tracker, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreChat chat = (i & 4) != 0 ? StoreStream.Companion.getChat() : storeChat;
        StoreMessages messages = (i & 8) != 0 ? StoreStream.Companion.getMessages() : storeMessages;
        StorePendingReplies pendingReplies = (i & 16) != 0 ? StoreStream.Companion.getPendingReplies() : storePendingReplies;
        StoreUser users = (i & 32) != 0 ? StoreStream.Companion.getUsers() : storeUser;
        StoreEmoji emojis = (i & 64) != 0 ? StoreStream.Companion.getEmojis() : storeEmoji;
        this(appFragment, appFlexInputViewModel, chat, messages, pendingReplies, users, emojis, (i & 128) != 0 ? new MessageManager(appFragment.requireContext(), null, null, null, null, null, null, null, null, 510, null) : messageManager, (i & 256) != 0 ? ChannelSelector.Companion.getInstance() : channelSelector, (i & 512) != 0 ? new WidgetChatListAdapterEventsHandler$UserReactionHandler(appFragment, messages, emojis) : widgetChatListAdapterEventsHandler$UserReactionHandler, (i & 1024) != 0 ? StoreStream.Companion.getChannels() : storeChannels, (i & 2048) != 0 ? AnalyticsUtils$Tracker.Companion.getInstance() : analyticsUtils$Tracker);
    }
}
