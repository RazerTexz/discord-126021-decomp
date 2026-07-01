package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.discord.R$layout;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.databinding.WidgetChatListAdapterItemGuildScheduledEventInviteBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.guild.UserGuildMember;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.Traits$Payment$Type;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.GuildScheduledEventInviteEntry;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventItemView;
import d0.z.d.m;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Job;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGuildScheduledEventInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGuildScheduledEventInvite extends WidgetChatListAdapterItemInviteBase {
    private final WidgetChatListAdapterItemGuildScheduledEventInviteBinding binding;
    private final StoreGuildScheduledEvents guildScheduledEventStore;
    private Job inviteJoinJob;
    private Subscription subscription;

    public /* synthetic */ WidgetChatListAdapterItemGuildScheduledEventInvite(WidgetChatListAdapter widgetChatListAdapter, StoreGuildScheduledEvents storeGuildScheduledEvents, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(widgetChatListAdapter, (i & 2) != 0 ? StoreStream.Companion.getGuildScheduledEvents() : storeGuildScheduledEvents);
    }

    public static final /* synthetic */ void access$configureUI(WidgetChatListAdapterItemGuildScheduledEventInvite widgetChatListAdapterItemGuildScheduledEventInvite, WidgetChatListAdapterItemGuildScheduledEventInvite$Model widgetChatListAdapterItemGuildScheduledEventInvite$Model) {
        widgetChatListAdapterItemGuildScheduledEventInvite.configureUI(widgetChatListAdapterItemGuildScheduledEventInvite$Model);
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemGuildScheduledEventInvite widgetChatListAdapterItemGuildScheduledEventInvite) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemGuildScheduledEventInvite.adapter;
    }

    public static final /* synthetic */ StoreGuildScheduledEvents access$getGuildScheduledEventStore$p(WidgetChatListAdapterItemGuildScheduledEventInvite widgetChatListAdapterItemGuildScheduledEventInvite) {
        return widgetChatListAdapterItemGuildScheduledEventInvite.guildScheduledEventStore;
    }

    public static final /* synthetic */ Job access$getInviteJoinJob$p(WidgetChatListAdapterItemGuildScheduledEventInvite widgetChatListAdapterItemGuildScheduledEventInvite) {
        return widgetChatListAdapterItemGuildScheduledEventInvite.inviteJoinJob;
    }

    public static final /* synthetic */ Subscription access$getSubscription$p(WidgetChatListAdapterItemGuildScheduledEventInvite widgetChatListAdapterItemGuildScheduledEventInvite) {
        return widgetChatListAdapterItemGuildScheduledEventInvite.subscription;
    }

    public static final /* synthetic */ void access$setInviteJoinJob$p(WidgetChatListAdapterItemGuildScheduledEventInvite widgetChatListAdapterItemGuildScheduledEventInvite, Job job) {
        widgetChatListAdapterItemGuildScheduledEventInvite.inviteJoinJob = job;
    }

    public static final /* synthetic */ void access$setSubscription$p(WidgetChatListAdapterItemGuildScheduledEventInvite widgetChatListAdapterItemGuildScheduledEventInvite, Subscription subscription) {
        widgetChatListAdapterItemGuildScheduledEventInvite.subscription = subscription;
    }

    private final void configureUI(WidgetChatListAdapterItemGuildScheduledEventInvite$Model model) {
        GuildScheduledEventItemView guildScheduledEventItemView = this.binding.f2322b;
        m.checkNotNullExpressionValue(guildScheduledEventItemView, "binding.guildScheduledEventInviteContainer");
        guildScheduledEventItemView.setBackground(null);
        GuildScheduledEventItemView guildScheduledEventItemView2 = this.binding.f2322b;
        GuildScheduledEvent guildScheduledEvent = model.getGuildScheduledEvent();
        Channel channel = model.getChannel();
        Guild guild = model.getGuild();
        UserGuildMember creator = model.getCreator();
        boolean zIsInGuild = model.isInGuild();
        boolean zIsRsvped = model.isRsvped();
        Long channelId = model.getGuildScheduledEvent().getChannelId();
        boolean z2 = false;
        if (channelId != null) {
            long jLongValue = channelId.longValue();
            Long selectedVoiceChannelId = model.getSelectedVoiceChannelId();
            if (selectedVoiceChannelId != null && jLongValue == selectedVoiceChannelId.longValue()) {
                z2 = true;
            }
        }
        guildScheduledEventItemView2.configureInChatList(guildScheduledEvent, channel, guild, creator, zIsInGuild, zIsRsvped, z2, model.getCanConnect(), new WidgetChatListAdapterItemGuildScheduledEventInvite$configureUI$2(this, model), new WidgetChatListAdapterItemGuildScheduledEventInvite$configureUI$3(this, model), new WidgetChatListAdapterItemGuildScheduledEventInvite$configureUI$4(this, model), new WidgetChatListAdapterItemGuildScheduledEventInvite$configureUI$5(this, model));
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.subscription;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemGuildScheduledEventInvite(WidgetChatListAdapter widgetChatListAdapter, StoreGuildScheduledEvents storeGuildScheduledEvents) {
        super(R$layout.widget_chat_list_adapter_item_guild_scheduled_event_invite, widgetChatListAdapter);
        m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        m.checkNotNullParameter(storeGuildScheduledEvents, "guildScheduledEventStore");
        this.guildScheduledEventStore = storeGuildScheduledEvents;
        View view = this.itemView;
        Objects.requireNonNull(view, "rootView");
        GuildScheduledEventItemView guildScheduledEventItemView = (GuildScheduledEventItemView) view;
        WidgetChatListAdapterItemGuildScheduledEventInviteBinding widgetChatListAdapterItemGuildScheduledEventInviteBinding = new WidgetChatListAdapterItemGuildScheduledEventInviteBinding(guildScheduledEventItemView, guildScheduledEventItemView);
        m.checkNotNullExpressionValue(widgetChatListAdapterItemGuildScheduledEventInviteBinding, "WidgetChatListAdapterIte…iteBinding.bind(itemView)");
        this.binding = widgetChatListAdapterItemGuildScheduledEventInviteBinding;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(WidgetChatListAdapterItemGuildScheduledEventInvite$Model$Companion.observe$default(WidgetChatListAdapterItemGuildScheduledEventInvite$Model.Companion, (GuildScheduledEventInviteEntry) data, null, null, null, null, null, null, 126, null)), WidgetChatListAdapterItemGuildScheduledEventInvite.class, (Context) null, new WidgetChatListAdapterItemGuildScheduledEventInvite$onConfigure$2(this), (Function1) null, (Function0) null, (Function0) null, new WidgetChatListAdapterItemGuildScheduledEventInvite$onConfigure$1(this), 58, (Object) null);
    }
}
