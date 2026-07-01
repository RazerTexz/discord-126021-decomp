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
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: WidgetChatListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface WidgetChatListAdapter$EventHandler {
    void onBotUiComponentClicked(long applicationId, Long guildId, long channelId, long messageId, Long messageFlags, int componentIndex, RestAPIParams$ComponentInteractionData componentSendData);

    void onCallMessageClicked(long voiceChannelId, WidgetChatListAdapterItemCallMessage$CallStatus callStatus);

    void onCommandClicked(long interactionId, Long guildId, long channelId, long messageId, long interactionUserId, long applicationId, String messageNonce);

    void onDismissClicked(Message message);

    void onDismissLocalMessageClicked(Message message);

    void onInteractionStateUpdated(StoreChat$InteractionState interactionState);

    void onListClicked();

    void onMessageAuthorAvatarClicked(Message message, long guildId);

    void onMessageAuthorLongClicked(Message message, Long guildId);

    void onMessageAuthorNameClicked(Message message, long guildId);

    void onMessageBlockedGroupClicked(Message message);

    void onMessageClicked(Message message, boolean isThreadStarterMessage);

    void onMessageLongClicked(Message message, CharSequence formattedMessage, boolean isThreadStarterMessage);

    void onOldestMessageId(long channelId, long oldestMessageId);

    void onOpenPinsClicked(Message message);

    void onQuickAddReactionClicked(long guildId, long myUserId, long channelId, long messageId);

    boolean onQuickDownloadClicked(Uri uri, String fileName);

    void onReactionClicked(long guildId, long myUserId, long channelId, long messageId, MessageReaction reaction, boolean canAddReactions);

    void onReactionLongClicked(long guildId, long channelId, long messageId, MessageReaction reaction);

    void onReportIssueWithAutoMod(Context context, Message message);

    void onRoleSubscriptionPurchaseTierClick(long roleSubscriptionListingId, long guildId, long userId, long channelId, long messageId);

    void onSendGreetMessageClicked(long channelId, int channelType, Sticker sticker);

    void onShareButtonClick(GuildScheduledEvent guildEvent, WeakReference<Context> weakContext, WeakReference<AppFragment> weakFragment);

    void onStickerClicked(Message message, BaseSticker sticker);

    void onSystemMessageCtaClicked(Message message, Channel channel, BaseSticker sticker);

    void onThreadClicked(Channel channel);

    void onThreadLongClicked(Channel channel);

    void onUrlLongClicked(String url);

    void onUserActivityAction(long authorId, long channelId, long messageId, MessageActivityType messageActivityType, Activity activity, Application application);

    void onUserMentionClicked(long userId, long channelId, long guildId);
}
