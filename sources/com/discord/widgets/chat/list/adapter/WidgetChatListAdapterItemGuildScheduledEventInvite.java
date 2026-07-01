package com.discord.widgets.chat.list.adapter;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.ViewKt;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.databinding.WidgetChatListAdapterItemGuildScheduledEventInviteBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.models.guild.Guild;
import com.discord.models.guild.UserGuildMember;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.GuildScheduledEventInviteEntry;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventItemView;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.lang.ref.WeakReference;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Job;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGuildScheduledEventInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGuildScheduledEventInvite extends WidgetChatListAdapterItemInviteBase {
    private final WidgetChatListAdapterItemGuildScheduledEventInviteBinding binding;
    private final StoreGuildScheduledEvents guildScheduledEventStore;
    private Job inviteJoinJob;
    private Subscription subscription;

    /* JADX INFO: compiled from: WidgetChatListAdapterItemGuildScheduledEventInvite.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean canConnect;
        private final boolean canShare;
        private final Channel channel;
        private final UserGuildMember creator;
        private final Guild guild;
        private final GuildScheduledEvent guildScheduledEvent;
        private final ModelInvite invite;
        private final boolean isInGuild;
        private final boolean isRsvped;
        private final Long selectedVoiceChannelId;

        /* JADX INFO: compiled from: WidgetChatListAdapterItemGuildScheduledEventInvite.kt */
        public static final class Companion {
            private Companion() {
            }

            public static /* synthetic */ Observable observe$default(Companion companion, GuildScheduledEventInviteEntry guildScheduledEventInviteEntry, StoreGuilds storeGuilds, StoreUser storeUser, StoreChannels storeChannels, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreVoiceChannelSelected storeVoiceChannelSelected, StorePermissions storePermissions, int i, Object obj) {
                return companion.observe(guildScheduledEventInviteEntry, (i & 2) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 4) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 8) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 16) != 0 ? StoreStream.INSTANCE.getGuildScheduledEvents() : storeGuildScheduledEvents, (i & 32) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected, (i & 64) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions);
            }

            public final Observable<Model> observe(GuildScheduledEventInviteEntry item, StoreGuilds guildStore, StoreUser userStore, StoreChannels channelStore, StoreGuildScheduledEvents guildScheduledEventStore, StoreVoiceChannelSelected voiceChannelSelectedStore, StorePermissions permissionStore) {
                Intrinsics3.checkNotNullParameter(item, "item");
                Intrinsics3.checkNotNullParameter(guildStore, "guildStore");
                Intrinsics3.checkNotNullParameter(userStore, "userStore");
                Intrinsics3.checkNotNullParameter(channelStore, "channelStore");
                Intrinsics3.checkNotNullParameter(guildScheduledEventStore, "guildScheduledEventStore");
                Intrinsics3.checkNotNullParameter(voiceChannelSelectedStore, "voiceChannelSelectedStore");
                Intrinsics3.checkNotNullParameter(permissionStore, "permissionStore");
                return ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{guildStore, userStore, guildScheduledEventStore, voiceChannelSelectedStore, permissionStore}, false, null, null, new WidgetChatListAdapterItemGuildScheduledEventInvite2(item, guildStore, userStore, guildScheduledEventStore, channelStore, voiceChannelSelectedStore, permissionStore), 14, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(ModelInvite modelInvite, boolean z2, boolean z3, GuildScheduledEvent guildScheduledEvent, Channel channel, Guild guild, UserGuildMember userGuildMember, Long l, boolean z4, boolean z5) {
            Intrinsics3.checkNotNullParameter(modelInvite, "invite");
            Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
            this.invite = modelInvite;
            this.isInGuild = z2;
            this.isRsvped = z3;
            this.guildScheduledEvent = guildScheduledEvent;
            this.channel = channel;
            this.guild = guild;
            this.creator = userGuildMember;
            this.selectedVoiceChannelId = l;
            this.canConnect = z4;
            this.canShare = z5;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ModelInvite getInvite() {
            return this.invite;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final boolean getCanShare() {
            return this.canShare;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsInGuild() {
            return this.isInGuild;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsRsvped() {
            return this.isRsvped;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final GuildScheduledEvent getGuildScheduledEvent() {
            return this.guildScheduledEvent;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final UserGuildMember getCreator() {
            return this.creator;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Long getSelectedVoiceChannelId() {
            return this.selectedVoiceChannelId;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final boolean getCanConnect() {
            return this.canConnect;
        }

        public final Model copy(ModelInvite invite, boolean isInGuild, boolean isRsvped, GuildScheduledEvent guildScheduledEvent, Channel channel, Guild guild, UserGuildMember creator, Long selectedVoiceChannelId, boolean canConnect, boolean canShare) {
            Intrinsics3.checkNotNullParameter(invite, "invite");
            Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
            return new Model(invite, isInGuild, isRsvped, guildScheduledEvent, channel, guild, creator, selectedVoiceChannelId, canConnect, canShare);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.invite, model.invite) && this.isInGuild == model.isInGuild && this.isRsvped == model.isRsvped && Intrinsics3.areEqual(this.guildScheduledEvent, model.guildScheduledEvent) && Intrinsics3.areEqual(this.channel, model.channel) && Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.creator, model.creator) && Intrinsics3.areEqual(this.selectedVoiceChannelId, model.selectedVoiceChannelId) && this.canConnect == model.canConnect && this.canShare == model.canShare;
        }

        public final boolean getCanConnect() {
            return this.canConnect;
        }

        public final boolean getCanShare() {
            return this.canShare;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final UserGuildMember getCreator() {
            return this.creator;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final GuildScheduledEvent getGuildScheduledEvent() {
            return this.guildScheduledEvent;
        }

        public final ModelInvite getInvite() {
            return this.invite;
        }

        public final Long getSelectedVoiceChannelId() {
            return this.selectedVoiceChannelId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v18, types: [int] */
        /* JADX WARN: Type inference failed for: r0v20, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v21 */
        /* JADX WARN: Type inference failed for: r2v22 */
        /* JADX WARN: Type inference failed for: r2v23 */
        /* JADX WARN: Type inference failed for: r2v24 */
        /* JADX WARN: Type inference failed for: r2v3, types: [int] */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public int hashCode() {
            ModelInvite modelInvite = this.invite;
            int iHashCode = (modelInvite != null ? modelInvite.hashCode() : 0) * 31;
            boolean z2 = this.isInGuild;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode + r2) * 31;
            boolean z3 = this.isRsvped;
            ?? r3 = z3;
            if (z3) {
                r3 = 1;
            }
            int i2 = (i + r3) * 31;
            GuildScheduledEvent guildScheduledEvent = this.guildScheduledEvent;
            int iHashCode2 = (i2 + (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0)) * 31;
            Channel channel = this.channel;
            int iHashCode3 = (iHashCode2 + (channel != null ? channel.hashCode() : 0)) * 31;
            Guild guild = this.guild;
            int iHashCode4 = (iHashCode3 + (guild != null ? guild.hashCode() : 0)) * 31;
            UserGuildMember userGuildMember = this.creator;
            int iHashCode5 = (iHashCode4 + (userGuildMember != null ? userGuildMember.hashCode() : 0)) * 31;
            Long l = this.selectedVoiceChannelId;
            int iHashCode6 = (iHashCode5 + (l != null ? l.hashCode() : 0)) * 31;
            boolean z4 = this.canConnect;
            ?? r1 = z4;
            if (z4) {
                r1 = 1;
            }
            int i3 = (iHashCode6 + r1) * 31;
            boolean z5 = this.canShare;
            return i3 + (z5 ? 1 : z5);
        }

        public final boolean isInGuild() {
            return this.isInGuild;
        }

        public final boolean isRsvped() {
            return this.isRsvped;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(invite=");
            sbU.append(this.invite);
            sbU.append(", isInGuild=");
            sbU.append(this.isInGuild);
            sbU.append(", isRsvped=");
            sbU.append(this.isRsvped);
            sbU.append(", guildScheduledEvent=");
            sbU.append(this.guildScheduledEvent);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", creator=");
            sbU.append(this.creator);
            sbU.append(", selectedVoiceChannelId=");
            sbU.append(this.selectedVoiceChannelId);
            sbU.append(", canConnect=");
            sbU.append(this.canConnect);
            sbU.append(", canShare=");
            return outline.O(sbU, this.canShare, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildScheduledEventInvite$onConfigure$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemGuildScheduledEventInvite.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetChatListAdapterItemGuildScheduledEventInvite widgetChatListAdapterItemGuildScheduledEventInvite) {
            super(1, widgetChatListAdapterItemGuildScheduledEventInvite, WidgetChatListAdapterItemGuildScheduledEventInvite.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildScheduledEventInvite$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "p1");
            ((WidgetChatListAdapterItemGuildScheduledEventInvite) this.receiver).configureUI(model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildScheduledEventInvite$onConfigure$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemGuildScheduledEventInvite.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            WidgetChatListAdapterItemGuildScheduledEventInvite.this.subscription = subscription;
        }
    }

    public /* synthetic */ WidgetChatListAdapterItemGuildScheduledEventInvite(WidgetChatListAdapter widgetChatListAdapter, StoreGuildScheduledEvents storeGuildScheduledEvents, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(widgetChatListAdapter, (i & 2) != 0 ? StoreStream.INSTANCE.getGuildScheduledEvents() : storeGuildScheduledEvents);
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemGuildScheduledEventInvite widgetChatListAdapterItemGuildScheduledEventInvite) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemGuildScheduledEventInvite.adapter;
    }

    private final void configureUI(final Model model) {
        GuildScheduledEventItemView guildScheduledEventItemView = this.binding.f2322b;
        Intrinsics3.checkNotNullExpressionValue(guildScheduledEventItemView, "binding.guildScheduledEventInviteContainer");
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
        guildScheduledEventItemView2.configureInChatList(guildScheduledEvent, channel, guild, creator, zIsInGuild, zIsRsvped, z2, model.getCanConnect(), new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildScheduledEventInvite.configureUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (model.isInGuild()) {
                    WidgetGuildScheduledEventDetailsBottomSheet.INSTANCE.showForGuild(WidgetChatListAdapterItemGuildScheduledEventInvite.access$getAdapter$p(WidgetChatListAdapterItemGuildScheduledEventInvite.this).getFragmentManager(), model.getGuildScheduledEvent().getId());
                } else {
                    WidgetChatListAdapterItemInviteBase.joinServerOrDM$default(WidgetChatListAdapterItemGuildScheduledEventInvite.this, WidgetChatListAdapterItemGuildScheduledEventInvite.class, model.getInvite(), null, null, 12, null);
                }
            }
        }, new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildScheduledEventInvite.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatListAdapterItemGuildScheduledEventInvite.this.guildScheduledEventStore.toggleMeRsvpForEvent(model.getGuildScheduledEvent());
            }
        }, new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildScheduledEventInvite.configureUI.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Job job = WidgetChatListAdapterItemGuildScheduledEventInvite.this.inviteJoinJob;
                if (job == null || !job.a()) {
                    WidgetChatListAdapterItemGuildScheduledEventInvite widgetChatListAdapterItemGuildScheduledEventInvite = WidgetChatListAdapterItemGuildScheduledEventInvite.this;
                    widgetChatListAdapterItemGuildScheduledEventInvite.inviteJoinJob = WidgetChatListAdapterItemInviteBase.joinServerOrDM$default(widgetChatListAdapterItemGuildScheduledEventInvite, widgetChatListAdapterItemGuildScheduledEventInvite.getClass(), model.getInvite(), null, null, 12, null);
                }
            }
        }, new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildScheduledEventInvite.configureUI.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatListAdapterItemGuildScheduledEventInvite.access$getAdapter$p(WidgetChatListAdapterItemGuildScheduledEventInvite.this).onShareButtonClick(model.getGuildScheduledEvent(), new WeakReference<>(WidgetChatListAdapterItemGuildScheduledEventInvite.access$getAdapter$p(WidgetChatListAdapterItemGuildScheduledEventInvite.this).getContext()), new WeakReference<>(ViewKt.findFragment(WidgetChatListAdapterItemGuildScheduledEventInvite.access$getAdapter$p(WidgetChatListAdapterItemGuildScheduledEventInvite.this).getRecycler())));
            }
        });
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.subscription;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemGuildScheduledEventInvite(WidgetChatListAdapter widgetChatListAdapter, StoreGuildScheduledEvents storeGuildScheduledEvents) {
        super(R.layout.widget_chat_list_adapter_item_guild_scheduled_event_invite, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        Intrinsics3.checkNotNullParameter(storeGuildScheduledEvents, "guildScheduledEventStore");
        this.guildScheduledEventStore = storeGuildScheduledEvents;
        View view = this.itemView;
        Objects.requireNonNull(view, "rootView");
        GuildScheduledEventItemView guildScheduledEventItemView = (GuildScheduledEventItemView) view;
        WidgetChatListAdapterItemGuildScheduledEventInviteBinding widgetChatListAdapterItemGuildScheduledEventInviteBinding = new WidgetChatListAdapterItemGuildScheduledEventInviteBinding(guildScheduledEventItemView, guildScheduledEventItemView);
        Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemGuildScheduledEventInviteBinding, "WidgetChatListAdapterIte…iteBinding.bind(itemView)");
        this.binding = widgetChatListAdapterItemGuildScheduledEventInviteBinding;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui(Model.Companion.observe$default(Model.INSTANCE, (GuildScheduledEventInviteEntry) data, null, null, null, null, null, null, 126, null)), (Class<?>) WidgetChatListAdapterItemGuildScheduledEventInvite.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass2()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }
}
