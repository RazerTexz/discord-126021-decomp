package com.discord.widgets.channels.list;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.R$layout;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.channels.list.items.ChannelListBottomNavSpaceItem;
import com.discord.widgets.channels.list.items.ChannelListItem;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter extends MGRecyclerAdapterSimple<ChannelListItem> {
    private int bottomNavHeight;
    private final FragmentManager fragmentManager;
    private Function0<Unit> onAddServer;
    private Function1<? super Channel, Unit> onCallChannel;
    private Function2<? super Channel, ? super Boolean, Unit> onCollapseCategory;
    private Function1<? super Channel, Unit> onSelectChannel;
    private Function1<? super Channel, Unit> onSelectChannelOptions;
    private Function1<? super Channel, Unit> onSelectGuildRoleSubscriptionLockedChannel;
    private Function1<? super View, Unit> onSelectInvite;
    private Function2<? super User, ? super Channel, Unit> onSelectUserOptions;
    private Function0<Unit> onViewGuildRoleSubscriptions;
    private Function1<? super Guild, Unit> onViewGuildScheduledEvents;
    private long selectedGuildId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsListAdapter(RecyclerView recyclerView, FragmentManager fragmentManager) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        this.fragmentManager = fragmentManager;
        this.onSelectChannel = WidgetChannelsListAdapter$onSelectChannel$1.INSTANCE;
        this.onSelectChannelOptions = WidgetChannelsListAdapter$onSelectChannelOptions$1.INSTANCE;
        this.onSelectUserOptions = WidgetChannelsListAdapter$onSelectUserOptions$1.INSTANCE;
        this.onSelectInvite = WidgetChannelsListAdapter$onSelectInvite$1.INSTANCE;
        this.onSelectGuildRoleSubscriptionLockedChannel = WidgetChannelsListAdapter$onSelectGuildRoleSubscriptionLockedChannel$1.INSTANCE;
        this.onCallChannel = WidgetChannelsListAdapter$onCallChannel$1.INSTANCE;
        this.onViewGuildScheduledEvents = WidgetChannelsListAdapter$onViewGuildScheduledEvents$1.INSTANCE;
        this.onViewGuildRoleSubscriptions = WidgetChannelsListAdapter$onViewGuildRoleSubscriptions$1.INSTANCE;
        this.onCollapseCategory = WidgetChannelsListAdapter$onCollapseCategory$1.INSTANCE;
        this.onAddServer = WidgetChannelsListAdapter$onAddServer$1.INSTANCE;
    }

    public static final /* synthetic */ int access$getBottomNavHeight$p(WidgetChannelsListAdapter widgetChannelsListAdapter) {
        return widgetChannelsListAdapter.bottomNavHeight;
    }

    public static final /* synthetic */ FragmentManager access$getFragmentManager$p(WidgetChannelsListAdapter widgetChannelsListAdapter) {
        return widgetChannelsListAdapter.fragmentManager;
    }

    public static final /* synthetic */ void access$setBottomNavHeight$p(WidgetChannelsListAdapter widgetChannelsListAdapter, int i) {
        widgetChannelsListAdapter.bottomNavHeight = i;
    }

    public final Function0<Unit> getOnAddServer() {
        return this.onAddServer;
    }

    public final Function1<Channel, Unit> getOnCallChannel() {
        return this.onCallChannel;
    }

    public final Function2<Channel, Boolean, Unit> getOnCollapseCategory() {
        return this.onCollapseCategory;
    }

    public final Function1<Channel, Unit> getOnSelectChannel() {
        return this.onSelectChannel;
    }

    public final Function1<Channel, Unit> getOnSelectChannelOptions() {
        return this.onSelectChannelOptions;
    }

    public final Function1<Channel, Unit> getOnSelectGuildRoleSubscriptionLockedChannel() {
        return this.onSelectGuildRoleSubscriptionLockedChannel;
    }

    public final Function1<View, Unit> getOnSelectInvite() {
        return this.onSelectInvite;
    }

    public final Function2<User, Channel, Unit> getOnSelectUserOptions() {
        return this.onSelectUserOptions;
    }

    public final Function0<Unit> getOnViewGuildRoleSubscriptions() {
        return this.onViewGuildRoleSubscriptions;
    }

    public final Function1<Guild, Unit> getOnViewGuildScheduledEvents() {
        return this.onViewGuildScheduledEvents;
    }

    public final long getSelectedGuildId() {
        return this.selectedGuildId;
    }

    public final void handleBottomNavHeight(int height) {
        this.bottomNavHeight = height;
        notifyItemChanged(getInternalData().lastIndexOf(new ChannelListBottomNavSpaceItem(this.selectedGuildId)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnAddServer(Function0<Unit> function0) {
        m.checkNotNullParameter(function0, "<set-?>");
        this.onAddServer = function0;
    }

    public final void setOnCallChannel(Function1<? super Channel, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onCallChannel = function1;
    }

    public final void setOnCollapseCategory(Function2<? super Channel, ? super Boolean, Unit> function2) {
        m.checkNotNullParameter(function2, "<set-?>");
        this.onCollapseCategory = function2;
    }

    public final void setOnSelectChannel(Function1<? super Channel, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onSelectChannel = function1;
    }

    public final void setOnSelectChannelOptions(Function1<? super Channel, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onSelectChannelOptions = function1;
    }

    public final void setOnSelectGuildRoleSubscriptionLockedChannel(Function1<? super Channel, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onSelectGuildRoleSubscriptionLockedChannel = function1;
    }

    public final void setOnSelectInvite(Function1<? super View, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onSelectInvite = function1;
    }

    public final void setOnSelectUserOptions(Function2<? super User, ? super Channel, Unit> function2) {
        m.checkNotNullParameter(function2, "<set-?>");
        this.onSelectUserOptions = function2;
    }

    public final void setOnViewGuildRoleSubscriptions(Function0<Unit> function0) {
        m.checkNotNullParameter(function0, "<set-?>");
        this.onViewGuildRoleSubscriptions = function0;
    }

    public final void setOnViewGuildScheduledEvents(Function1<? super Guild, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onViewGuildScheduledEvents = function1;
    }

    public final void setSelectedGuildId(long j) {
        this.selectedGuildId = j;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<?, ChannelListItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        MGRecyclerViewHolder<?, ChannelListItem> widgetChannelsListAdapter$ItemChannelDirectory;
        m.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 0:
                return new WidgetChannelsListAdapter$ItemChannelText(R$layout.widget_channels_list_item_channel, this);
            case 1:
                return new WidgetChannelsListAdapter$ItemChannelVoice(R$layout.widget_channels_list_item_channel_voice, this);
            case 2:
                return new WidgetChannelsListAdapter$ItemVoiceUser(R$layout.widget_channels_list_item_voice_user, this);
            case 3:
                return new WidgetChannelsListAdapter$ItemChannelPrivate(R$layout.widget_channels_list_item_channel_private, this);
            case 4:
            case 5:
            case 10:
            default:
                throw invalidViewTypeException(viewType);
            case 6:
                return new WidgetChannelsListAdapter$ItemHeader(R$layout.widget_channels_list_item_header, this);
            case 7:
                return new WidgetChannelsListAdapter$ItemMFA(R$layout.widget_channels_list_item_mfa, this);
            case 8:
                return new WidgetChannelsListAdapter$ItemChannelCategory(R$layout.widget_channels_list_item_category, this);
            case 9:
                return new WidgetChannelsListAdapter$ItemInvite(R$layout.widget_channels_list_item_invite, this);
            case 11:
                return new WidgetChannelsListAdapter$ItemSpace(R$layout.recycler_item_bottom_nav_space, this);
            case 12:
                return new WidgetChannelsListAdapter$ItemChannelThread(R$layout.widget_channels_list_item_thread, this);
            case 13:
                return new WidgetChannelsListAdapter$ItemChannelStageVoice(R$layout.widget_channels_list_item_channel_stage_voice, this);
            case 14:
                return new MGRecyclerViewHolder<>(R$layout.widget_channels_list_item_stage_events_separator, this);
            case 15:
                return new WidgetChannelsListAdapter$ItemStageActiveEvent(R$layout.widget_channels_list_item_active_event, this);
            case 16:
                return new WidgetChannelsListAdapter$ItemStageChannelAudienceCount(R$layout.widget_channels_list_item_audience_count, this);
            case 17:
                widgetChannelsListAdapter$ItemChannelDirectory = new WidgetChannelsListAdapter$ItemChannelDirectory(R$layout.widget_channels_list_item_directory, this);
                break;
            case 18:
                widgetChannelsListAdapter$ItemChannelDirectory = new WidgetChannelsListAdapter$ItemChannelAddServer(R$layout.widget_channels_list_item_directory, this);
                break;
            case 19:
                return new WidgetChannelsListAdapter$ItemGuildScheduledEvents(R$layout.widget_channels_list_item_guild_scheduled_events, this);
            case 20:
                widgetChannelsListAdapter$ItemChannelDirectory = new WidgetChannelsListAdapter$ItemInvite(R$layout.widget_channels_list_item_directory, this);
                break;
            case 21:
                return new WidgetChannelsListAdapter$ItemGuildRoleSubscriptionsOverview(R$layout.widget_channels_list_item_guild_role_subs, this);
            case 22:
                return new WidgetChannelsListAdapter$ItemGuildJoinRequest(R$layout.widget_channels_list_item_guild_join_request, this);
        }
        return widgetChannelsListAdapter$ItemChannelDirectory;
    }
}
