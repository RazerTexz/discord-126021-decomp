package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.stageinstance.RecommendedStageInstance;
import com.discord.api.stageinstance.StageInstance;
import com.discord.databinding.WidgetChatListAdapterItemStageInviteBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.models.user.CoreUser;
import com.discord.models.user.User;
import com.discord.stores.StoreAccessibility;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreInstantInvites;
import com.discord.stores.StoreRequestedStageChannels;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreStageInstances;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.guilds.GuildUtilsKt;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.stages.StageCardSpeakersView;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.StageInviteEntry;
import com.discord.widgets.stage.StageCardSpeaker;
import com.discord.widgets.stage.StageChannelJoinHelper;
import com.discord.widgets.stage.StageRoles;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Job;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p062y.p068o0.AbstractC1367d;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12113l;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetChatListAdapterItemStageInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemStageInvite extends WidgetChatListAdapterItemInviteBase {
    private final WidgetChatListAdapterItemStageInviteBinding binding;
    private String iconUrl;
    private Job inviteJoinJob;
    private StageInviteEntry item;
    private Subscription subscription;

    /* JADX INFO: compiled from: WidgetChatListAdapterItemStageInvite.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final User authorUser;
        private final Channel channel;
        private final ModelInvite invite;
        private final Integer listenersCount;
        private final long meId;
        private final boolean shouldAnimateGuildIcon;
        private final List<StageCardSpeaker> speakers;
        private final StageInstance stageInstance;

        /* JADX INFO: compiled from: WidgetChatListAdapterItemStageInvite.kt */
        public static final class Companion {
            private Companion() {
            }

            public static /* synthetic */ Observable observe$default(Companion companion, StageInviteEntry stageInviteEntry, StoreUser storeUser, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreAccessibility storeAccessibility, StoreStageInstances storeStageInstances, StoreRequestedStageChannels storeRequestedStageChannels, StoreStageChannels storeStageChannels, ObservationDeck observationDeck, int i, Object obj) {
                return companion.observe(stageInviteEntry, (i & 2) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 4) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 8) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 16) != 0 ? StoreStream.INSTANCE.getAccessibility() : storeAccessibility, (i & 32) != 0 ? StoreStream.INSTANCE.getStageInstances() : storeStageInstances, (i & 64) != 0 ? StoreStream.INSTANCE.getRequestedStageChannels() : storeRequestedStageChannels, (i & 128) != 0 ? StoreStream.INSTANCE.getStageChannels() : storeStageChannels, (i & 256) != 0 ? ObservationDeckProvider.get() : observationDeck);
            }

            private final List<StageCardSpeaker> speakersFromLocalStore(StoreGuilds guildStore, StoreUser userStore, StoreStageChannels stageChannelStore, long channelId, long guildId) {
                User user;
                Map<Long, StageRoles> channelRoles = stageChannelStore.getChannelRoles(channelId);
                if (channelRoles == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<Long, StageRoles> entry : channelRoles.entrySet()) {
                    long jLongValue = entry.getKey().longValue();
                    StageCardSpeaker stageCardSpeaker = (!StageRoles.m11410isSpeakerimpl(entry.getValue().m11412unboximpl()) || (user = userStore.getUsers().get(Long.valueOf(jLongValue))) == null) ? null : Model.INSTANCE.toStageCardSpeaker(user, guildStore.getMember(guildId, jLongValue));
                    if (stageCardSpeaker != null) {
                        arrayList.add(stageCardSpeaker);
                    }
                }
                return arrayList;
            }

            private final List<StageCardSpeaker> speakersFromRequest(StoreRequestedStageChannels.StageInstanceState stageInstanceState) {
                RecommendedStageInstance stageInstance;
                if (stageInstanceState == null || (stageInstance = stageInstanceState.getStageInstance()) == null) {
                    return null;
                }
                List<GuildMember> listM8219c = stageInstance.m8219c();
                ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listM8219c, 10));
                for (GuildMember guildMember : listM8219c) {
                    arrayList.add(new StageCardSpeaker(new CoreUser(guildMember.getUser()), com.discord.models.member.GuildMember.INSTANCE.from(guildMember, guildMember.getGuildId(), (8 & 4) != 0 ? null : null, (8 & 8) != 0 ? null : StoreStream.INSTANCE.getGuilds())));
                }
                return arrayList;
            }

            private final StageCardSpeaker toStageCardSpeaker(User user, com.discord.models.member.GuildMember guildMember) {
                return new StageCardSpeaker(user, guildMember);
            }

            public final Observable<Model> observe(StageInviteEntry item, StoreUser userStore, StoreChannels channelStore, StoreGuilds guildStore, StoreAccessibility accessibilityStore, StoreStageInstances stageInstanceStore, StoreRequestedStageChannels requestedInstanceStore, StoreStageChannels stageChannelStore, ObservationDeck observationDeck) {
                C12238m.checkNotNullParameter(item, "item");
                C12238m.checkNotNullParameter(userStore, "userStore");
                C12238m.checkNotNullParameter(channelStore, "channelStore");
                C12238m.checkNotNullParameter(guildStore, "guildStore");
                C12238m.checkNotNullParameter(accessibilityStore, "accessibilityStore");
                C12238m.checkNotNullParameter(stageInstanceStore, "stageInstanceStore");
                C12238m.checkNotNullParameter(requestedInstanceStore, "requestedInstanceStore");
                C12238m.checkNotNullParameter(stageChannelStore, "stageChannelStore");
                C12238m.checkNotNullParameter(observationDeck, "observationDeck");
                return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{userStore, channelStore, guildStore, accessibilityStore, stageInstanceStore, requestedInstanceStore, stageChannelStore}, false, null, null, new WidgetChatListAdapterItemStageInvite$Model$Companion$observe$1(userStore, item, channelStore, accessibilityStore, stageInstanceStore, requestedInstanceStore, stageChannelStore, guildStore), 14, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(ModelInvite modelInvite, long j, User user, Channel channel, boolean z2, StageInstance stageInstance, List<StageCardSpeaker> list, Integer num) {
            C12238m.checkNotNullParameter(modelInvite, "invite");
            C12238m.checkNotNullParameter(list, "speakers");
            this.invite = modelInvite;
            this.meId = j;
            this.authorUser = user;
            this.channel = channel;
            this.shouldAnimateGuildIcon = z2;
            this.stageInstance = stageInstance;
            this.speakers = list;
            this.listenersCount = num;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ModelInvite getInvite() {
            return this.invite;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getMeId() {
            return this.meId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final User getAuthorUser() {
            return this.authorUser;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getShouldAnimateGuildIcon() {
            return this.shouldAnimateGuildIcon;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final StageInstance getStageInstance() {
            return this.stageInstance;
        }

        public final List<StageCardSpeaker> component7() {
            return this.speakers;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Integer getListenersCount() {
            return this.listenersCount;
        }

        public final Model copy(ModelInvite invite, long meId, User authorUser, Channel channel, boolean shouldAnimateGuildIcon, StageInstance stageInstance, List<StageCardSpeaker> speakers, Integer listenersCount) {
            C12238m.checkNotNullParameter(invite, "invite");
            C12238m.checkNotNullParameter(speakers, "speakers");
            return new Model(invite, meId, authorUser, channel, shouldAnimateGuildIcon, stageInstance, speakers, listenersCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return C12238m.areEqual(this.invite, model.invite) && this.meId == model.meId && C12238m.areEqual(this.authorUser, model.authorUser) && C12238m.areEqual(this.channel, model.channel) && this.shouldAnimateGuildIcon == model.shouldAnimateGuildIcon && C12238m.areEqual(this.stageInstance, model.stageInstance) && C12238m.areEqual(this.speakers, model.speakers) && C12238m.areEqual(this.listenersCount, model.listenersCount);
        }

        public final User getAuthorUser() {
            return this.authorUser;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final ModelInvite getInvite() {
            return this.invite;
        }

        public final Integer getListenersCount() {
            return this.listenersCount;
        }

        public final long getMeId() {
            return this.meId;
        }

        public final boolean getShouldAnimateGuildIcon() {
            return this.shouldAnimateGuildIcon;
        }

        public final List<StageCardSpeaker> getSpeakers() {
            return this.speakers;
        }

        public final StageInstance getStageInstance() {
            return this.stageInstance;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11, types: [int] */
        /* JADX WARN: Type inference failed for: r0v21 */
        /* JADX WARN: Type inference failed for: r0v25 */
        /* JADX WARN: Type inference failed for: r2v8, types: [int] */
        public int hashCode() {
            ModelInvite modelInvite = this.invite;
            int iM3a = (C0002b.m3a(this.meId) + ((modelInvite != null ? modelInvite.hashCode() : 0) * 31)) * 31;
            User user = this.authorUser;
            int iHashCode = (iM3a + (user != null ? user.hashCode() : 0)) * 31;
            Channel channel = this.channel;
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            boolean z2 = this.shouldAnimateGuildIcon;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = (iHashCode2 + r0) * 31;
            StageInstance stageInstance = this.stageInstance;
            int iHashCode3 = (i + (stageInstance != null ? stageInstance.hashCode() : 0)) * 31;
            List<StageCardSpeaker> list = this.speakers;
            int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
            Integer num = this.listenersCount;
            return iHashCode4 + (num != null ? num.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Model(invite=");
            sbM833U.append(this.invite);
            sbM833U.append(", meId=");
            sbM833U.append(this.meId);
            sbM833U.append(", authorUser=");
            sbM833U.append(this.authorUser);
            sbM833U.append(", channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", shouldAnimateGuildIcon=");
            sbM833U.append(this.shouldAnimateGuildIcon);
            sbM833U.append(", stageInstance=");
            sbM833U.append(this.stageInstance);
            sbM833U.append(", speakers=");
            sbM833U.append(this.speakers);
            sbM833U.append(", listenersCount=");
            return C1643a.m818F(sbM833U, this.listenersCount, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStageInvite$onConfigure$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemStageInvite.kt */
    public static final /* synthetic */ class C81211 extends C12236k implements Function1<Model, Unit> {
        public C81211(WidgetChatListAdapterItemStageInvite widgetChatListAdapterItemStageInvite) {
            super(1, widgetChatListAdapterItemStageInvite, WidgetChatListAdapterItemStageInvite.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemStageInvite$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            C12238m.checkNotNullParameter(model, "p1");
            ((WidgetChatListAdapterItemStageInvite) this.receiver).configureUI(model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStageInvite$onConfigure$2 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemStageInvite.kt */
    public static final class C81222 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C81222() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, "it");
            WidgetChatListAdapterItemStageInvite.this.subscription = subscription;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemStageInvite(WidgetChatListAdapter widgetChatListAdapter) {
        super(C5419R.layout.widget_chat_list_adapter_item_stage_invite, widgetChatListAdapter);
        C12238m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = C5419R.id.item_invite_channel_topic;
        TextView textView = (TextView) view.findViewById(C5419R.id.item_invite_channel_topic);
        if (textView != null) {
            i = C5419R.id.item_invite_guild_name;
            TextView textView2 = (TextView) view.findViewById(C5419R.id.item_invite_guild_name);
            if (textView2 != null) {
                i = C5419R.id.item_invite_header;
                TextView textView3 = (TextView) view.findViewById(C5419R.id.item_invite_header);
                if (textView3 != null) {
                    i = C5419R.id.item_invite_image;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.item_invite_image);
                    if (simpleDraweeView != null) {
                        i = C5419R.id.item_invite_image_text;
                        TextView textView4 = (TextView) view.findViewById(C5419R.id.item_invite_image_text);
                        if (textView4 != null) {
                            i = C5419R.id.item_invite_join_button;
                            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.item_invite_join_button);
                            if (materialButton != null) {
                                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                i = C5419R.id.item_listeners_count;
                                TextView textView5 = (TextView) view.findViewById(C5419R.id.item_listeners_count);
                                if (textView5 != null) {
                                    i = C5419R.id.stage_discovery_speakers_view;
                                    StageCardSpeakersView stageCardSpeakersView = (StageCardSpeakersView) view.findViewById(C5419R.id.stage_discovery_speakers_view);
                                    if (stageCardSpeakersView != null) {
                                        WidgetChatListAdapterItemStageInviteBinding widgetChatListAdapterItemStageInviteBinding = new WidgetChatListAdapterItemStageInviteBinding(constraintLayout, textView, textView2, textView3, simpleDraweeView, textView4, materialButton, constraintLayout, textView5, stageCardSpeakersView);
                                        C12238m.checkNotNullExpressionValue(widgetChatListAdapterItemStageInviteBinding, "WidgetChatListAdapterIte…iteBinding.bind(itemView)");
                                        this.binding = widgetChatListAdapterItemStageInviteBinding;
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemStageInvite widgetChatListAdapterItemStageInvite) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemStageInvite.adapter;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x005c  */
    private final void configureUI(final Model model) {
        boolean z2;
        Guild guild;
        String name;
        String name2;
        String topic;
        String icon;
        View view = this.itemView;
        C12238m.checkNotNullExpressionValue(view, "itemView");
        final Context context = view.getContext();
        Guild guild2 = model.getInvite().guild;
        Long lValueOf = guild2 != null ? Long.valueOf(guild2.getId()) : null;
        Guild guild3 = model.getInvite().guild;
        updateIconUrlIfChanged(IconUtils.getForGuild$default(lValueOf, guild3 != null ? guild3.getIcon() : null, IconUtils.DEFAULT_ICON_BLURPLE, model.getShouldAnimateGuildIcon(), null, 16, null));
        Guild guild4 = model.getInvite().guild;
        int i = 0;
        if (guild4 == null || (icon = guild4.getIcon()) == null) {
            z2 = false;
        } else if (icon.length() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        TextView textView = this.binding.f16286e;
        C12238m.checkNotNullExpressionValue(textView, "binding.itemInviteImageText");
        ViewExtensions.setTextAndVisibilityBy(textView, (z2 || (guild = model.getInvite().guild) == null || (name = guild.getName()) == null) ? null : GuildUtilsKt.computeShortName(name));
        TextView textView2 = this.binding.f16284c;
        C12238m.checkNotNullExpressionValue(textView2, "binding.itemInviteGuildName");
        Guild guild5 = model.getInvite().guild;
        if (guild5 == null || (name2 = guild5.getName()) == null) {
            Channel channel = model.getChannel();
            name2 = channel != null ? channel.getName() : null;
        }
        ViewExtensions.setTextAndVisibilityBy(textView2, name2);
        TextView textView3 = this.binding.f16283b;
        C12238m.checkNotNullExpressionValue(textView3, "binding.itemInviteChannelTopic");
        StageInstance stageInstance = model.getStageInstance();
        if (stageInstance == null || (topic = stageInstance.getTopic()) == null) {
            Channel channel2 = model.getChannel();
            topic = channel2 != null ? channel2.getTopic() : null;
        }
        if (topic == null) {
            Channel channel3 = model.getChannel();
            topic = channel3 != null ? channel3.getName() : null;
        }
        ViewExtensions.setTextAndVisibilityBy(textView3, topic);
        TextView textView4 = this.binding.f16288g;
        C12238m.checkNotNullExpressionValue(textView4, "binding.itemListenersCount");
        Integer listenersCount = model.getListenersCount();
        ViewExtensions.setTextAndVisibilityBy(textView4, listenersCount != null ? String.valueOf(listenersCount.intValue()) : null);
        StageCardSpeakersView stageCardSpeakersView = this.binding.f16289h;
        List<StageCardSpeaker> speakers = model.getSpeakers();
        RecyclerView.ItemDecoration itemDecoration = StageCardSpeakersView.f19290j;
        int size = speakers.size();
        Objects.requireNonNull(stageCardSpeakersView);
        C12238m.checkNotNullParameter(speakers, "speakers");
        List listTake = C12163u.take(speakers, 3);
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listTake, 10));
        for (Object obj : listTake) {
            int i2 = i + 1;
            if (i < 0) {
                C12147n.throwIndexOverflow();
            }
            StageCardSpeaker stageCardSpeaker = (StageCardSpeaker) obj;
            User user = stageCardSpeaker.getUser();
            com.discord.models.member.GuildMember guildMember = stageCardSpeaker.getGuildMember();
            String displayName = stageCardSpeaker.getDisplayName();
            StringBuilder sb = new StringBuilder();
            sb.append(size);
            sb.append('-');
            sb.append(i);
            arrayList.add(new AbstractC1367d.a(user, guildMember, displayName, sb.toString()));
            i = i2;
        }
        int size2 = size - arrayList.size();
        C12238m.checkNotNullParameter(arrayList, "speakersToDisplay");
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(arrayList);
        if (size2 > 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(size);
            sb2.append('-');
            sb2.append(arrayList.size() + 1);
            arrayList2.add(new AbstractC1367d.b(size2, sb2.toString()));
        }
        stageCardSpeakersView.speakersAdapter.setData(arrayList2);
        this.binding.f16287f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStageInvite.configureUI.2

            /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStageInvite$configureUI$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetChatListAdapterItemStageInvite.kt */
            @InterfaceC12188e(m10084c = "com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStageInvite$configureUI$2$1", m10085f = "WidgetChatListAdapterItemStageInvite.kt", m10086l = {121}, m10087m = "invokeSuspend")
            public static final class AnonymousClass1 extends AbstractC12194k implements Function2<ModelInvite, Continuation<? super Unit>, Object> {
                public final /* synthetic */ long $channelId;
                public final /* synthetic */ long $guildId;
                public int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(long j, long j2, Continuation continuation) {
                    super(2, continuation);
                    this.$guildId = j;
                    this.$channelId = j2;
                }

                @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C12238m.checkNotNullParameter(continuation, "completion");
                    return ViewOnClickListenerC81202.this.new AnonymousClass1(this.$guildId, this.$channelId, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(ModelInvite modelInvite, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(modelInvite, continuation)).invokeSuspend(Unit.f27425a);
                }

                @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        C12113l.throwOnFailure(obj);
                        StageChannelJoinHelper stageChannelJoinHelper = StageChannelJoinHelper.INSTANCE;
                        Context context = context;
                        C12238m.checkNotNullExpressionValue(context, "context");
                        FragmentManager fragmentManager = WidgetChatListAdapterItemStageInvite.access$getAdapter$p(WidgetChatListAdapterItemStageInvite.this).getFragmentManager();
                        long j = this.$guildId;
                        long j2 = this.$channelId;
                        this.label = 1;
                        if (stageChannelJoinHelper.lurkAndJoinStageAsync(context, fragmentManager, j, j2, (224 & 16) != 0 ? false : true, (224 & 32) != 0 ? StoreStream.INSTANCE.getGuilds() : null, (224 & 64) != 0 ? StoreStream.INSTANCE.getLurking() : null, (224 & 128) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : null, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        C12113l.throwOnFailure(obj);
                    }
                    return Unit.f27425a;
                }
            }

            /* JADX WARN: Code duplicated, block: B:11:0x0023  */
            /* JADX WARN: Code duplicated, block: B:13:0x002f  */
            /* JADX WARN: Code duplicated, block: B:20:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:21:? A[RETURN, SYNTHETIC] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Long lValueOf2;
                long guildId;
                long jLongValue;
                Channel channel4;
                Job job;
                Guild guild6 = model.getInvite().guild;
                if (guild6 == null) {
                    Channel channel5 = model.getChannel();
                    if (channel5 != null) {
                        guildId = channel5.getGuildId();
                    } else {
                        lValueOf2 = null;
                    }
                    if (lValueOf2 != null) {
                        jLongValue = lValueOf2.longValue();
                        channel4 = model.getChannel();
                        if (channel4 != null) {
                            long id2 = channel4.getId();
                            job = WidgetChatListAdapterItemStageInvite.this.inviteJoinJob;
                            if (job == null && job.mo10910a()) {
                                return;
                            }
                            WidgetChatListAdapterItemStageInvite widgetChatListAdapterItemStageInvite = WidgetChatListAdapterItemStageInvite.this;
                            widgetChatListAdapterItemStageInvite.inviteJoinJob = WidgetChatListAdapterItemInviteBase.joinServerOrDM$default(widgetChatListAdapterItemStageInvite, widgetChatListAdapterItemStageInvite.getClass(), model.getInvite(), new AnonymousClass1(jLongValue, id2, null), null, 8, null);
                        }
                    }
                }
                guildId = guild6.getId();
                lValueOf2 = Long.valueOf(guildId);
                if (lValueOf2 != null) {
                    jLongValue = lValueOf2.longValue();
                    channel4 = model.getChannel();
                    if (channel4 != null) {
                        long id3 = channel4.getId();
                        job = WidgetChatListAdapterItemStageInvite.this.inviteJoinJob;
                        if (job == null) {
                        }
                        WidgetChatListAdapterItemStageInvite widgetChatListAdapterItemStageInvite2 = WidgetChatListAdapterItemStageInvite.this;
                        widgetChatListAdapterItemStageInvite2.inviteJoinJob = WidgetChatListAdapterItemInviteBase.joinServerOrDM$default(widgetChatListAdapterItemStageInvite2, widgetChatListAdapterItemStageInvite2.getClass(), model.getInvite(), new AnonymousClass1(jLongValue, id3, null), null, 8, null);
                    }
                }
            }
        });
    }

    private final void updateIconUrlIfChanged(String iconUrl) {
        if (!C12238m.areEqual(this.iconUrl, iconUrl)) {
            SimpleDraweeView simpleDraweeView = this.binding.f16285d;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.itemInviteImage");
            IconUtils.setIcon$default(simpleDraweeView, iconUrl, C5419R.dimen.avatar_size_large, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
            this.iconUrl = iconUrl;
        }
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.subscription;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, ChatListEntry data) {
        C12238m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        this.item = (StageInviteEntry) data;
        StoreInstantInvites instantInvites = StoreStream.INSTANCE.getInstantInvites();
        StageInviteEntry stageInviteEntry = this.item;
        if (stageInviteEntry == null) {
            C12238m.throwUninitializedPropertyAccessException("item");
        }
        instantInvites.fetchInviteIfNotLoaded(stageInviteEntry.getInviteCode(), (24 & 2) != 0 ? null : null, (24 & 4) != 0 ? null : "Invite Button Embed", (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null);
        Model.Companion companion = Model.INSTANCE;
        StageInviteEntry stageInviteEntry2 = this.item;
        if (stageInviteEntry2 == null) {
            C12238m.throwUninitializedPropertyAccessException("item");
        }
        Observable observableM11083G = ObservableExtensionsKt.m8518ui(Model.Companion.observe$default(companion, stageInviteEntry2, null, null, null, null, null, null, null, null, 510, null)).m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
        C12238m.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
        ObservableExtensionsKt.appSubscribe(observableM11083G, (Class<?>) WidgetChatListAdapterItemStageInvite.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C81222()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C81211(this));
    }
}
