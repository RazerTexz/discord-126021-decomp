package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import b.i.a.f.e.o.f;
import com.discord.R$layout;
import com.discord.api.activity.Activity;
import com.discord.api.application.Application;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.message.activity.MessageActivityType;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.sticker.BaseSticker;
import com.discord.app.AppFragment;
import com.discord.app.AppPermissionsRequests;
import com.discord.models.guild.Guild;
import com.discord.models.message.Message;
import com.discord.restapi.RestAPIParams$ComponentInteractionData;
import com.discord.stores.StoreChat$InteractionState;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.botuikit.ComponentProvider;
import com.discord.widgets.chat.input.AppFlexInputViewModel;
import com.discord.widgets.chat.list.FragmentLifecycleListener;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.model.WidgetChatListModel;
import d0.z.d.m;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Job;
import rx.functions.Action0;

/* JADX INFO: compiled from: WidgetChatListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapter extends MGRecyclerAdapterSimple<ChatListEntry> {
    public static final WidgetChatListAdapter$Companion Companion = new WidgetChatListAdapter$Companion(null);
    private static final int NEW_MESSAGES_MAX_SCROLLBACK_COUNT = 30;
    private static final int NEW_MESSAGES_MIN_SCROLLBACK_COUNT = 10;
    private final AppPermissionsRequests appPermissionsRequests;
    private final ComponentProvider botUiComponentProvider;
    private final Clock clock;
    private WidgetChatListAdapter$Data data;
    private final WidgetChatListAdapter$EventHandler eventHandler;
    private final AppFlexInputViewModel flexInputViewModel;
    private FragmentManager fragmentManager;
    private final WidgetChatListAdapter$HandlerOfScrolls handlerOfScrolls;
    private final WidgetChatListAdapter$HandlerOfTouches handlerOfTouches;
    private final WidgetChatListAdapter$HandlerOfUpdates handlerOfUpdates;
    private boolean isTouchedSinceLastJump;
    private Job lastUpdateJob;
    private boolean mentionMeMessageLevelHighlighting;
    private WidgetChatListAdapter$ScrollToWithHighlight scrollToWithHighlight;

    public WidgetChatListAdapter(RecyclerView recyclerView, AppPermissionsRequests appPermissionsRequests, FragmentManager fragmentManager, WidgetChatListAdapter$EventHandler widgetChatListAdapter$EventHandler) {
        this(recyclerView, appPermissionsRequests, fragmentManager, widgetChatListAdapter$EventHandler, null, null, 48, null);
    }

    public WidgetChatListAdapter(RecyclerView recyclerView, AppPermissionsRequests appPermissionsRequests, FragmentManager fragmentManager, WidgetChatListAdapter$EventHandler widgetChatListAdapter$EventHandler, AppFlexInputViewModel appFlexInputViewModel) {
        this(recyclerView, appPermissionsRequests, fragmentManager, widgetChatListAdapter$EventHandler, appFlexInputViewModel, null, 32, null);
    }

    public /* synthetic */ WidgetChatListAdapter(RecyclerView recyclerView, AppPermissionsRequests appPermissionsRequests, FragmentManager fragmentManager, WidgetChatListAdapter$EventHandler widgetChatListAdapter$EventHandler, AppFlexInputViewModel appFlexInputViewModel, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(recyclerView, appPermissionsRequests, fragmentManager, widgetChatListAdapter$EventHandler, (i & 16) != 0 ? null : appFlexInputViewModel, (i & 32) != 0 ? ClockFactory.get() : clock);
    }

    public static final /* synthetic */ WidgetChatListAdapter$HandlerOfScrolls access$getHandlerOfScrolls$p(WidgetChatListAdapter widgetChatListAdapter) {
        return widgetChatListAdapter.handlerOfScrolls;
    }

    public static final /* synthetic */ WidgetChatListAdapter$HandlerOfTouches access$getHandlerOfTouches$p(WidgetChatListAdapter widgetChatListAdapter) {
        return widgetChatListAdapter.handlerOfTouches;
    }

    public static final /* synthetic */ WidgetChatListAdapter$HandlerOfUpdates access$getHandlerOfUpdates$p(WidgetChatListAdapter widgetChatListAdapter) {
        return widgetChatListAdapter.handlerOfUpdates;
    }

    public static final /* synthetic */ Job access$getLastUpdateJob$p(WidgetChatListAdapter widgetChatListAdapter) {
        return widgetChatListAdapter.lastUpdateJob;
    }

    public static final /* synthetic */ WidgetChatListAdapter$ScrollToWithHighlight access$getScrollToWithHighlight$p(WidgetChatListAdapter widgetChatListAdapter) {
        return widgetChatListAdapter.scrollToWithHighlight;
    }

    public static final /* synthetic */ boolean access$isTouchedSinceLastJump$p(WidgetChatListAdapter widgetChatListAdapter) {
        return widgetChatListAdapter.isTouchedSinceLastJump;
    }

    public static final /* synthetic */ void access$publishInteractionState(WidgetChatListAdapter widgetChatListAdapter) {
        widgetChatListAdapter.publishInteractionState();
    }

    public static final /* synthetic */ void access$setLastUpdateJob$p(WidgetChatListAdapter widgetChatListAdapter, Job job) {
        widgetChatListAdapter.lastUpdateJob = job;
    }

    public static final /* synthetic */ void access$setScrollToWithHighlight$p(WidgetChatListAdapter widgetChatListAdapter, WidgetChatListAdapter$ScrollToWithHighlight widgetChatListAdapter$ScrollToWithHighlight) {
        widgetChatListAdapter.scrollToWithHighlight = widgetChatListAdapter$ScrollToWithHighlight;
    }

    public static final /* synthetic */ void access$setTouchedSinceLastJump$p(WidgetChatListAdapter widgetChatListAdapter, boolean z2) {
        widgetChatListAdapter.isTouchedSinceLastJump = z2;
    }

    private final void publishInteractionState() {
        WidgetChatListAdapter$Data widgetChatListAdapter$Data = this.data;
        if (!(widgetChatListAdapter$Data instanceof WidgetChatListModel)) {
            widgetChatListAdapter$Data = null;
        }
        WidgetChatListModel widgetChatListModel = (WidgetChatListModel) widgetChatListAdapter$Data;
        this.eventHandler.onInteractionStateUpdated(new StoreChat$InteractionState(this.data.getChannelId(), widgetChatListModel != null ? widgetChatListModel.getNewestKnownMessageId() : 0L, this.isTouchedSinceLastJump, getLayoutManager()));
    }

    public final void disposeHandlers() {
        setOnUpdated(WidgetChatListAdapter$disposeHandlers$1.INSTANCE);
        Job job = this.lastUpdateJob;
        if (job != null) {
            f.t(job, null, 1, null);
        }
        getRecycler().setOnTouchListener(null);
        getRecycler().removeOnScrollListener(this.handlerOfScrolls);
        this.eventHandler.onInteractionStateUpdated(new StoreChat$InteractionState(this.data.getChannelId(), 0L, this.isTouchedSinceLastJump, (LinearLayoutManager) null));
    }

    public final AppPermissionsRequests getAppPermissionsRequests() {
        return this.appPermissionsRequests;
    }

    public final ComponentProvider getBotUiComponentProvider() {
        return this.botUiComponentProvider;
    }

    public final Clock getClock() {
        return this.clock;
    }

    public final WidgetChatListAdapter$Data getData() {
        return this.data;
    }

    public final WidgetChatListAdapter$EventHandler getEventHandler() {
        return this.eventHandler;
    }

    public final AppFlexInputViewModel getFlexInputViewModel() {
        return this.flexInputViewModel;
    }

    public final FragmentManager getFragmentManager() {
        return this.fragmentManager;
    }

    public final LinearLayoutManager getLayoutManager() {
        RecyclerView$LayoutManager layoutManager = getRecycler().getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            layoutManager = null;
        }
        return (LinearLayoutManager) layoutManager;
    }

    public final boolean getMentionMeMessageLevelHighlighting() {
        return this.mentionMeMessageLevelHighlighting;
    }

    public final void onBotUiComponentClicked(long applicationId, long messageId, Long messageFlags, int componentIndex, RestAPIParams$ComponentInteractionData componentSendData) {
        m.checkNotNullParameter(componentSendData, "componentSendData");
        WidgetChatListAdapter$EventHandler widgetChatListAdapter$EventHandler = this.eventHandler;
        Guild guild = this.data.getGuild();
        widgetChatListAdapter$EventHandler.onBotUiComponentClicked(applicationId, guild != null ? Long.valueOf(guild.getId()) : null, this.data.getChannelId(), messageId, messageFlags, componentIndex, componentSendData);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void onPause() {
        int childCount = getRecycler().getChildCount();
        for (int i = 0; i < childCount; i++) {
            Object childViewHolder = getRecycler().getChildViewHolder(getRecycler().getChildAt(i));
            if (childViewHolder instanceof FragmentLifecycleListener) {
                ((FragmentLifecycleListener) childViewHolder).onPause();
            }
        }
    }

    public final void onQuickAddReactionClicked(long messageId) {
        this.eventHandler.onQuickAddReactionClicked(this.data.getGuildId(), this.data.getUserId(), this.data.getChannelId(), messageId);
    }

    public final void onReactionClicked(long messageId, MessageReaction reaction, boolean canAddReactions) {
        m.checkNotNullParameter(reaction, "reaction");
        this.eventHandler.onReactionClicked(this.data.getGuildId(), this.data.getUserId(), this.data.getChannelId(), messageId, reaction, canAddReactions);
    }

    public final void onReactionLongClicked(long messageId, MessageReaction reaction) {
        m.checkNotNullParameter(reaction, "reaction");
        this.eventHandler.onReactionLongClicked(this.data.getGuildId(), this.data.getChannelId(), messageId, reaction);
    }

    public final void onResume() {
        int childCount = getRecycler().getChildCount();
        for (int i = 0; i < childCount; i++) {
            Object childViewHolder = getRecycler().getChildViewHolder(getRecycler().getChildAt(i));
            if (childViewHolder instanceof FragmentLifecycleListener) {
                ((FragmentLifecycleListener) childViewHolder).onResume();
            }
        }
    }

    public final void onRoleSubscriptionPurchaseSystemMessageClicked(long roleSubscriptionListingId, long messageId) {
        this.eventHandler.onRoleSubscriptionPurchaseTierClick(roleSubscriptionListingId, this.data.getGuildId(), this.data.getUserId(), this.data.getChannelId(), messageId);
    }

    public final void onShareButtonClick(GuildScheduledEvent guildEvent, WeakReference<Context> weakContext, WeakReference<AppFragment> weakFragment) {
        m.checkNotNullParameter(guildEvent, "guildEvent");
        m.checkNotNullParameter(weakContext, "weakContext");
        m.checkNotNullParameter(weakFragment, "weakFragment");
        this.eventHandler.onShareButtonClick(guildEvent, weakContext, weakFragment);
    }

    public final void onStickerClicked(Message message, BaseSticker sticker) {
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(sticker, "sticker");
        this.eventHandler.onStickerClicked(message, sticker);
    }

    public final void onThreadClicked(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        this.eventHandler.onThreadClicked(channel);
    }

    public final void onThreadLongClicked(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        this.eventHandler.onThreadLongClicked(channel);
    }

    public final void onUserActivityAction(long authorId, long messageId, MessageActivityType messageActivityType, Activity activity, Application application) {
        m.checkNotNullParameter(messageActivityType, "messageActivityType");
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        m.checkNotNullParameter(application, "application");
        this.eventHandler.onUserActivityAction(authorId, this.data.getChannelId(), messageId, messageActivityType, activity, application);
    }

    public final void scrollToMessageId(long messageId, Action0 onCompleted) {
        m.checkNotNullParameter(onCompleted, "onCompleted");
        WidgetChatListAdapter$ScrollToWithHighlight widgetChatListAdapter$ScrollToWithHighlight = this.scrollToWithHighlight;
        if (widgetChatListAdapter$ScrollToWithHighlight != null && widgetChatListAdapter$ScrollToWithHighlight.getMessageId() > 0 && messageId <= 0) {
            onCompleted.call();
            return;
        }
        this.isTouchedSinceLastJump = false;
        WidgetChatListAdapter$ScrollToWithHighlight widgetChatListAdapter$ScrollToWithHighlight2 = this.scrollToWithHighlight;
        if (widgetChatListAdapter$ScrollToWithHighlight2 != null) {
            widgetChatListAdapter$ScrollToWithHighlight2.cancel();
        }
        this.scrollToWithHighlight = new WidgetChatListAdapter$ScrollToWithHighlight(this, messageId, new WidgetChatListAdapter$scrollToMessageId$1(this, onCompleted));
    }

    public final void setData(WidgetChatListAdapter$Data widgetChatListAdapter$Data) {
        m.checkNotNullParameter(widgetChatListAdapter$Data, "value");
        this.data = widgetChatListAdapter$Data;
        setData(widgetChatListAdapter$Data.getList());
    }

    public final void setFragmentManager(FragmentManager fragmentManager) {
        m.checkNotNullParameter(fragmentManager, "<set-?>");
        this.fragmentManager = fragmentManager;
    }

    public final void setHandlers() {
        setOnUpdated(new WidgetChatListAdapter$setHandlers$1(this));
    }

    public final void setMentionMeMessageLevelHighlighting(boolean z2) {
        this.mentionMeMessageLevelHighlighting = z2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapter(RecyclerView recyclerView, AppPermissionsRequests appPermissionsRequests, FragmentManager fragmentManager, WidgetChatListAdapter$EventHandler widgetChatListAdapter$EventHandler, AppFlexInputViewModel appFlexInputViewModel, Clock clock) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        m.checkNotNullParameter(appPermissionsRequests, "appPermissionsRequests");
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(widgetChatListAdapter$EventHandler, "eventHandler");
        m.checkNotNullParameter(clock, "clock");
        this.appPermissionsRequests = appPermissionsRequests;
        this.fragmentManager = fragmentManager;
        this.eventHandler = widgetChatListAdapter$EventHandler;
        this.flexInputViewModel = appFlexInputViewModel;
        this.clock = clock;
        Context context = recyclerView.getContext();
        m.checkNotNullExpressionValue(context, "recycler.context");
        this.botUiComponentProvider = new ComponentProvider(context);
        this.data = new WidgetChatListAdapter$EmptyData();
        this.mentionMeMessageLevelHighlighting = true;
        this.handlerOfTouches = new WidgetChatListAdapter$HandlerOfTouches(this);
        this.handlerOfScrolls = new WidgetChatListAdapter$HandlerOfScrolls(this);
        this.handlerOfUpdates = new WidgetChatListAdapter$HandlerOfUpdates(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<WidgetChatListAdapter, ChatListEntry> onCreateViewHolder(ViewGroup parent, int viewType) {
        MGRecyclerViewHolder<WidgetChatListAdapter, ChatListEntry> widgetChatListAdapterItemGuildWelcome;
        m.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 0:
            case 32:
                return new WidgetChatListAdapterItemMessage(R$layout.widget_chat_list_adapter_item_text, this);
            case 1:
                return new WidgetChatListAdapterItemMessage(R$layout.widget_chat_list_adapter_item_minimal, this);
            case 2:
                return new WidgetChatListItem(R$layout.widget_chat_list_adapter_item_loading, this);
            case 3:
                return new WidgetChatListAdapterItemStart(this);
            case 4:
                return new WidgetChatListAdapterItemReactions(this);
            case 5:
                return new WidgetChatListAdapterItemSystemMessage(this);
            case 6:
                return new WidgetChatListAdapterItemUploadProgress(this);
            case 7:
                return new WidgetChatListItem(R$layout.widget_chat_list_adapter_item_spacer, this);
            case 8:
                return new WidgetChatListAdapterItemNewMessages(this);
            case 9:
                return new WidgetChatListAdapterItemTimestamp(this);
            case 10:
                return new WidgetChatListAdapterItemBlocked(this);
            case 11:
                return new WidgetChatListAdapterItemSearchResultCount(this);
            case 12:
                return new MGRecyclerViewHolder<>(R$layout.widget_chat_list_adapter_item_search_indexing, this);
            case 13:
                return new MGRecyclerViewHolder<>(R$layout.widget_chat_list_adapter_item_search_empty, this);
            case 14:
                return new MGRecyclerViewHolder<>(R$layout.widget_chat_list_adapter_item_search_error, this);
            case 15:
                return new MGRecyclerViewHolder<>(R$layout.widget_chat_list_adapter_item_divider, this);
            case 16:
                return new WidgetChatListAdapterItemEmptyPins(this);
            case 17:
                return new WidgetChatListAdapterItemMessageHeader(this);
            case 18:
                return new WidgetChatListAdapterItemMentionFooter(this);
            case 19:
                return new WidgetChatListAdapterItemCallMessage(this);
            case 20:
                return new WidgetChatListAdapterItemMessage(R$layout.widget_chat_list_adapter_item_failed, this);
            case 21:
                return new WidgetChatListAdapterItemEmbed(this);
            case 22:
                return new WidgetChatListAdapterItemGameInvite(this);
            case 23:
                return new WidgetChatListAdapterItemSpotifyListenTogether(this);
            case 24:
                return new WidgetChatListAdapterItemInvite(this);
            case 25:
                widgetChatListAdapterItemGuildWelcome = new WidgetChatListAdapterItemGuildWelcome(this, null, 2, null);
                break;
            case 26:
                return new WidgetChatListAdapterItemGift(this);
            case 27:
            default:
                throw invalidViewTypeException(viewType);
            case 28:
                return new WidgetChatListAdapterItemAttachment(this);
            case 29:
                return new WidgetChatListAdapterItemPrivateChannelStart(this);
            case 30:
                return new WidgetChatListAdapterItemGuildTemplate(this);
            case 31:
                return new WidgetChatListAdapterItemSticker(this);
            case 33:
                return new WidgetChatListAdapterItemApplicationCommand(this);
            case 34:
                return new WidgetChatListAdapterItemEphemeralMessage(this);
            case 35:
                return new WidgetChatListAdapterItemThreadEmbed(this);
            case 36:
                return new WidgetChatListAdapterItemBotComponentRow(this);
            case 37:
                return new WidgetChatListAdapterItemThreadDraftForm(this, this.flexInputViewModel);
            case 38:
                return new WidgetChatListAdapterItemGuildInviteReminder(this);
            case 39:
                return new WidgetChatListAdapterItemStageInvite(this);
            case 40:
                return new MGRecyclerViewHolder<>(R$layout.widget_chat_list_adapter_item_thread_starter_divider, this);
            case 41:
                return new WidgetChatListAdapterItemStickerGreet(this);
            case 42:
                return new WidgetChatListAdapterItemStickerGreetCompact(this);
            case 43:
                widgetChatListAdapterItemGuildWelcome = new WidgetChatListAdapterItemGuildScheduledEventInvite(this, null, 2, null);
                break;
            case 44:
                return new WidgetChatListAdapterItemAutoModBlocked(this);
            case 45:
                return new WidgetChatListAdapterItemAutoModSystemMessageEmbed(this);
        }
        return widgetChatListAdapterItemGuildWelcome;
    }
}
