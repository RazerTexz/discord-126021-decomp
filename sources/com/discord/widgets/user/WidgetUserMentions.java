package com.discord.widgets.user;

import android.content.Context;
import android.net.Uri;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.activity.Activity;
import com.discord.api.application.Application;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.message.MessageReference;
import com.discord.api.message.activity.MessageActivityType;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.role.GuildRole;
import com.discord.api.sticker.BaseSticker;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetUserMentionsBinding;
import com.discord.databinding.WidgetUserMentionsFilterBinding;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.SelectedChannelAnalyticsLocation;
import com.discord.stores.StoreChat;
import com.discord.stores.StoreMessageReplies;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreTabsNavigation;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.embed.InviteEmbedModel;
import com.discord.utilities.error.Error;
import com.discord.utilities.fragment.FragmentExtensionsKt;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.LeadingEdgeThrottle;
import com.discord.utilities.p501rx.ObservableCombineLatestOverloadsKt;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.ViewCoroutineScopeKt;
import com.discord.views.CheckedSetting;
import com.discord.widgets.chat.list.ThreadSpineItemDecoration;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.LoadingEntry;
import com.discord.widgets.chat.list.entries.MentionFooterEntry;
import com.discord.widgets.chat.list.entries.MessageHeaderEntry;
import com.discord.widgets.chat.list.model.WidgetChatListModelMessages;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import com.discord.widgets.tabs.NavigationTab;
import com.discord.widgets.tabs.OnTabSelectedListener;
import com.discord.widgets.tabs.WidgetTabsHost;
import com.discord.widgets.user.WidgetUserMentions;
import com.discord.widgets.user.search.WidgetGlobalSearchDismissModel;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12116o;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p643a.C12666r;
import p637j0.p653p.C12781a;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.functions.Action2;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMentions extends AppFragment implements OnTabSelectedListener {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetUserMentions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserMentionsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_IS_EMBEDDED = "EXTRA_HIDE_TITLE";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: dismissViewModel$delegate, reason: from kotlin metadata */
    private final Lazy dismissViewModel;

    /* JADX INFO: renamed from: isEmbedded$delegate, reason: from kotlin metadata */
    private final Lazy isEmbedded;
    private WidgetChatListAdapter mentionsAdapter;
    private final Model.MessageLoader mentionsLoader;
    private final StoreTabsNavigation storeTabsNavigation;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetUserMentions.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ WidgetUserMentions create$default(Companion companion, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = false;
            }
            return companion.create(z2);
        }

        public final WidgetUserMentions create(boolean isEmbedded) {
            WidgetUserMentions widgetUserMentions = new WidgetUserMentions();
            widgetUserMentions.setArguments(BundleKt.bundleOf(C12116o.m10073to(WidgetUserMentions.EXTRA_IS_EMBEDDED, Boolean.valueOf(isEmbedded))));
            return widgetUserMentions;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetUserMentions.kt */
    public static final /* data */ class Model implements WidgetChatListAdapter.Data {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean animateEmojis;
        private final long channelId;
        private final Map<Long, String> channelNames;
        private final Guild guild;
        private final long guildId;
        private final String guildName;
        private final boolean isSpoilerClickAllowed;
        private final List<ChatListEntry> list;
        private final Set<Long> myRoleIds;
        private final long newMessagesMarkerMessageId;
        private final long oldestMessageId;
        private final NavigationTab selectedTab;
        private final long userId;

        /* JADX INFO: compiled from: WidgetUserMentions.kt */
        public static final class Companion {
            private Companion() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final Observable<Model> get(MessageLoader messageLoader, final NavigationTab selectedTab) {
                C12238m.checkNotNullParameter(messageLoader, "messageLoader");
                C12238m.checkNotNullParameter(selectedTab, "selectedTab");
                Observable<R> observableM11099Y = messageLoader.getMentionsLoadingStateSubject().m11099Y(new InterfaceC12589b<MessageLoader.LoadingState, Observable<? extends Model>>() { // from class: com.discord.widgets.user.WidgetUserMentions$Model$Companion$get$1

                    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserMentions$Model$Companion$get$1$1 */
                    /* JADX INFO: compiled from: WidgetUserMentions.kt */
                    public static final class C102071 extends AbstractC12240o implements Function11<WidgetChatListModelMessages.MessagesWithMetadata, Guild, Map<Long, ? extends Channel>, Map<Long, ? extends String>, Map<Long, ? extends Guild>, Map<Long, ? extends Map<Long, ? extends GuildRole>>, Map<Long, ? extends Map<Long, ? extends GuildMember>>, Long, Boolean, Boolean, InviteEmbedModel, WidgetUserMentions.Model> {
                        public final /* synthetic */ WidgetUserMentions.Model.MessageLoader.LoadingState $loadedState;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public C102071(WidgetUserMentions.Model.MessageLoader.LoadingState loadingState) {
                            super(11);
                            this.$loadedState = loadingState;
                        }

                        @Override // kotlin.jvm.functions.Function11
                        public /* bridge */ /* synthetic */ WidgetUserMentions.Model invoke(WidgetChatListModelMessages.MessagesWithMetadata messagesWithMetadata, Guild guild, Map<Long, ? extends Channel> map, Map<Long, ? extends String> map2, Map<Long, ? extends Guild> map3, Map<Long, ? extends Map<Long, ? extends GuildRole>> map4, Map<Long, ? extends Map<Long, ? extends GuildMember>> map5, Long l, Boolean bool, Boolean bool2, InviteEmbedModel inviteEmbedModel) {
                            return invoke(messagesWithMetadata, guild, (Map<Long, Channel>) map, (Map<Long, String>) map2, (Map<Long, Guild>) map3, (Map<Long, ? extends Map<Long, GuildRole>>) map4, (Map<Long, ? extends Map<Long, GuildMember>>) map5, l.longValue(), bool.booleanValue(), bool2.booleanValue(), inviteEmbedModel);
                        }

                        public final WidgetUserMentions.Model invoke(WidgetChatListModelMessages.MessagesWithMetadata messagesWithMetadata, Guild guild, Map<Long, Channel> map, Map<Long, String> map2, Map<Long, Guild> map3, Map<Long, ? extends Map<Long, GuildRole>> map4, Map<Long, ? extends Map<Long, GuildMember>> map5, long j, boolean z2, boolean z3, InviteEmbedModel inviteEmbedModel) {
                            Map<Long, Channel> map6 = map;
                            Map<Long, ? extends Map<Long, GuildRole>> map7 = map4;
                            Map<Long, ? extends Map<Long, GuildMember>> map8 = map5;
                            C12238m.checkNotNullParameter(messagesWithMetadata, "messagesWithMetadata");
                            C12238m.checkNotNullParameter(map6, "channels");
                            C12238m.checkNotNullParameter(map2, "names");
                            C12238m.checkNotNullParameter(map3, "guilds");
                            C12238m.checkNotNullParameter(map7, "roles");
                            C12238m.checkNotNullParameter(map8, "members");
                            C12238m.checkNotNullParameter(inviteEmbedModel, "inviteEmbedModel");
                            long id2 = guild != null ? guild.getId() : 0L;
                            String name = guild != null ? guild.getName() : null;
                            long j2 = -1;
                            long j3 = -1;
                            ArrayList arrayList = new ArrayList(this.$loadedState.getMentions().size() * 2);
                            Set setEmptySet = C12148n0.emptySet();
                            Map<Long, StoreMessageReplies.MessageState> allMessageReferences = StoreStream.INSTANCE.getRepliedMessages().getAllMessageReferences();
                            for (Message message : this.$loadedState.getMentions()) {
                                Channel channel = map6.get(Long.valueOf(message.getChannelId()));
                                if (channel != null) {
                                    Map<Long, GuildMember> mapEmptyMap = map8.get(Long.valueOf(message.getChannelId()));
                                    if (mapEmptyMap == null) {
                                        mapEmptyMap = C12136h0.emptyMap();
                                    }
                                    Map<Long, GuildMember> map9 = mapEmptyMap;
                                    Object objM843c = C1643a.m843c(channel, map7);
                                    if (objM843c == null) {
                                        objM843c = C12136h0.emptyMap();
                                    }
                                    Map map10 = (Map) objM843c;
                                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                                    MessageReference messageReference = message.getMessageReference();
                                    Long messageId = messageReference != null ? messageReference.getMessageId() : null;
                                    if (messageId != null) {
                                        Object obj = (StoreMessageReplies.MessageState) allMessageReferences.get(messageId);
                                        if (obj == null) {
                                            obj = StoreMessageReplies.MessageState.Unloaded.INSTANCE;
                                        }
                                        linkedHashMap.put(messageId, obj);
                                    }
                                    arrayList.add(new MessageHeaderEntry(message, channel, (Guild) C1643a.m843c(channel, map3)));
                                    arrayList.addAll(WidgetChatListModelMessages.Companion.getMessageItems$default(WidgetChatListModelMessages.INSTANCE, channel, map9, map10, C12136h0.emptyMap(), messagesWithMetadata.getMessageThreads().get(Long.valueOf(message.getId())), messagesWithMetadata.getThreadCountsAndLatestMessages().get(Long.valueOf(message.getId())), message, messagesWithMetadata.getMessageState().get(Long.valueOf(message.getId())), linkedHashMap, false, false, null, z2, z3, StoreStream.INSTANCE.getUserSettings().getIsRenderEmbedsEnabled(), j, false, new HashMap(), inviteEmbedModel, false, GuildRoleSubscriptionsFeatureFlag.INSTANCE.getINSTANCE().canGuildSeePurchaseFeedbackLoopMessages(channel.getGuildId()), 524288, null));
                                }
                                map6 = map;
                                map7 = map4;
                                map8 = map5;
                            }
                            if (this.$loadedState.isLoading()) {
                                arrayList.add(new LoadingEntry());
                            } else if (this.$loadedState.isAllLoaded()) {
                                arrayList.add(new MentionFooterEntry());
                            }
                            return new WidgetUserMentions.Model(j, -1L, map3.get(Long.valueOf(id2)), id2, map2, j3, arrayList, setEmptySet, j2, false, z2, name, selectedTab, 512, null);
                        }
                    }

                    @Override // p637j0.p641k.InterfaceC12589b
                    public final Observable<? extends WidgetUserMentions.Model> call(WidgetUserMentions.Model.MessageLoader.LoadingState loadingState) {
                        Observable<WidgetChatListModelMessages.MessagesWithMetadata> observable = WidgetChatListModelMessages.MessagesWithMetadata.INSTANCE.get(loadingState.getMentions());
                        StoreStream.Companion companion = StoreStream.INSTANCE;
                        return ObservableCombineLatestOverloadsKt.combineLatest(observable, companion.getGuildSelected().observeSelectedGuild(), companion.getChannels().observeAllChannels(), companion.getChannels().observeNames(), companion.getGuilds().observeGuilds(), companion.getGuilds().observeRoles(), companion.getGuilds().observeComputed(), companion.getUsers().observeMeId(), StoreUserSettings.observeIsAnimatedEmojisEnabled$default(companion.getUserSettings(), false, 1, null), StoreUserSettings.observeIsAutoPlayGifsEnabled$default(companion.getUserSettings(), false, 1, null), InviteEmbedModel.Companion.observe$default(InviteEmbedModel.INSTANCE, null, null, null, null, 15, null), new C102071(loadingState));
                    }
                });
                Observable<Model> observableM11112r = Observable.m11074h0(new C12666r(observableM11099Y.f27640j, new LeadingEdgeThrottle(300L, TimeUnit.MILLISECONDS, C12781a.m10873a()))).m11112r();
                C12238m.checkNotNullExpressionValue(observableM11112r, "messageLoader\n          …  .distinctUntilChanged()");
                return observableM11112r;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX INFO: compiled from: WidgetUserMentions.kt */
        public static final class MessageLoader {
            private StoreChat.InteractionState interactionState;
            private boolean isFocused;
            private Long loadBeforeMessageId;
            private Subscription loadSubscription;
            private final BehaviorSubject<LoadingState> mentionsLoadingStateSubject;
            private Function0<Unit> retryAction;
            private final long retryDelayMs;
            private Subscription retrySubscription;
            private final ArrayList<Message> mentions = new ArrayList<>();
            private final int mentionLimit = 25;
            private LoadingState mentionsLoadingState = new LoadingState(false, false, null, 7, null);
            private Filters filters = new Filters(0, false, false, false, 15, null);

            /* JADX INFO: compiled from: WidgetUserMentions.kt */
            public static final /* data */ class Filters {
                private final boolean allGuilds;
                private final long guildId;
                private final boolean includeEveryone;
                private final boolean includeRoles;

                public Filters() {
                    this(0L, false, false, false, 15, null);
                }

                public Filters(long j, boolean z2, boolean z3, boolean z4) {
                    this.guildId = j;
                    this.allGuilds = z2;
                    this.includeEveryone = z3;
                    this.includeRoles = z4;
                }

                public static /* synthetic */ Filters copy$default(Filters filters, long j, boolean z2, boolean z3, boolean z4, int i, Object obj) {
                    if ((i & 1) != 0) {
                        j = filters.guildId;
                    }
                    long j2 = j;
                    if ((i & 2) != 0) {
                        z2 = filters.allGuilds;
                    }
                    boolean z5 = z2;
                    if ((i & 4) != 0) {
                        z3 = filters.includeEveryone;
                    }
                    boolean z6 = z3;
                    if ((i & 8) != 0) {
                        z4 = filters.includeRoles;
                    }
                    return filters.copy(j2, z5, z6, z4);
                }

                /* JADX INFO: renamed from: component1, reason: from getter */
                public final long getGuildId() {
                    return this.guildId;
                }

                /* JADX INFO: renamed from: component2, reason: from getter */
                public final boolean getAllGuilds() {
                    return this.allGuilds;
                }

                /* JADX INFO: renamed from: component3, reason: from getter */
                public final boolean getIncludeEveryone() {
                    return this.includeEveryone;
                }

                /* JADX INFO: renamed from: component4, reason: from getter */
                public final boolean getIncludeRoles() {
                    return this.includeRoles;
                }

                public final Filters copy(long guildId, boolean allGuilds, boolean includeEveryone, boolean includeRoles) {
                    return new Filters(guildId, allGuilds, includeEveryone, includeRoles);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Filters)) {
                        return false;
                    }
                    Filters filters = (Filters) other;
                    return this.guildId == filters.guildId && this.allGuilds == filters.allGuilds && this.includeEveryone == filters.includeEveryone && this.includeRoles == filters.includeRoles;
                }

                public final boolean getAllGuilds() {
                    return this.allGuilds;
                }

                public final long getGuildId() {
                    return this.guildId;
                }

                public final boolean getIncludeEveryone() {
                    return this.includeEveryone;
                }

                public final boolean getIncludeRoles() {
                    return this.includeRoles;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r0v3, types: [int] */
                /* JADX WARN: Type inference failed for: r0v5, types: [int] */
                /* JADX WARN: Type inference failed for: r0v7, types: [int] */
                /* JADX WARN: Type inference failed for: r1v1, types: [int] */
                /* JADX WARN: Type inference failed for: r1v3, types: [int] */
                /* JADX WARN: Type inference failed for: r1v5 */
                /* JADX WARN: Type inference failed for: r1v6 */
                /* JADX WARN: Type inference failed for: r1v7 */
                /* JADX WARN: Type inference failed for: r1v8 */
                /* JADX WARN: Type inference failed for: r2v0 */
                /* JADX WARN: Type inference failed for: r2v1, types: [int] */
                /* JADX WARN: Type inference failed for: r2v2 */
                public int hashCode() {
                    int iM3a = C0002b.m3a(this.guildId) * 31;
                    boolean z2 = this.allGuilds;
                    ?? r1 = z2;
                    if (z2) {
                        r1 = 1;
                    }
                    int i = (iM3a + r1) * 31;
                    boolean z3 = this.includeEveryone;
                    ?? r2 = z3;
                    if (z3) {
                        r2 = 1;
                    }
                    int i2 = (i + r2) * 31;
                    boolean z4 = this.includeRoles;
                    return i2 + (z4 ? 1 : z4);
                }

                public String toString() {
                    StringBuilder sbM833U = C1643a.m833U("Filters(guildId=");
                    sbM833U.append(this.guildId);
                    sbM833U.append(", allGuilds=");
                    sbM833U.append(this.allGuilds);
                    sbM833U.append(", includeEveryone=");
                    sbM833U.append(this.includeEveryone);
                    sbM833U.append(", includeRoles=");
                    return C1643a.m827O(sbM833U, this.includeRoles, ")");
                }

                public /* synthetic */ Filters(long j, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? true : z3, (i & 8) != 0 ? true : z4);
                }
            }

            /* JADX INFO: compiled from: WidgetUserMentions.kt */
            public static final /* data */ class LoadingState {
                private final boolean isAllLoaded;
                private final boolean isLoading;
                private final List<Message> mentions;

                public LoadingState() {
                    this(false, false, null, 7, null);
                }

                public LoadingState(boolean z2, boolean z3, List<Message> list) {
                    C12238m.checkNotNullParameter(list, "mentions");
                    this.isLoading = z2;
                    this.isAllLoaded = z3;
                    this.mentions = list;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ LoadingState copy$default(LoadingState loadingState, boolean z2, boolean z3, List list, int i, Object obj) {
                    if ((i & 1) != 0) {
                        z2 = loadingState.isLoading;
                    }
                    if ((i & 2) != 0) {
                        z3 = loadingState.isAllLoaded;
                    }
                    if ((i & 4) != 0) {
                        list = loadingState.mentions;
                    }
                    return loadingState.copy(z2, z3, list);
                }

                /* JADX INFO: renamed from: component1, reason: from getter */
                public final boolean getIsLoading() {
                    return this.isLoading;
                }

                /* JADX INFO: renamed from: component2, reason: from getter */
                public final boolean getIsAllLoaded() {
                    return this.isAllLoaded;
                }

                public final List<Message> component3() {
                    return this.mentions;
                }

                public final LoadingState copy(boolean isLoading, boolean isAllLoaded, List<Message> mentions) {
                    C12238m.checkNotNullParameter(mentions, "mentions");
                    return new LoadingState(isLoading, isAllLoaded, mentions);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof LoadingState)) {
                        return false;
                    }
                    LoadingState loadingState = (LoadingState) other;
                    return this.isLoading == loadingState.isLoading && this.isAllLoaded == loadingState.isAllLoaded && C12238m.areEqual(this.mentions, loadingState.mentions);
                }

                public final List<Message> getMentions() {
                    return this.mentions;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r0v1, types: [int] */
                /* JADX WARN: Type inference failed for: r0v3, types: [int] */
                /* JADX WARN: Type inference failed for: r0v6 */
                /* JADX WARN: Type inference failed for: r0v7 */
                /* JADX WARN: Type inference failed for: r1v0 */
                /* JADX WARN: Type inference failed for: r1v1, types: [int] */
                /* JADX WARN: Type inference failed for: r1v6 */
                public int hashCode() {
                    boolean z2 = this.isLoading;
                    ?? r0 = z2;
                    if (z2) {
                        r0 = 1;
                    }
                    int i = r0 * 31;
                    boolean z3 = this.isAllLoaded;
                    int i2 = (i + (z3 ? 1 : z3)) * 31;
                    List<Message> list = this.mentions;
                    return i2 + (list != null ? list.hashCode() : 0);
                }

                public final boolean isAllLoaded() {
                    return this.isAllLoaded;
                }

                public final boolean isLoading() {
                    return this.isLoading;
                }

                public String toString() {
                    StringBuilder sbM833U = C1643a.m833U("LoadingState(isLoading=");
                    sbM833U.append(this.isLoading);
                    sbM833U.append(", isAllLoaded=");
                    sbM833U.append(this.isAllLoaded);
                    sbM833U.append(", mentions=");
                    return C1643a.m824L(sbM833U, this.mentions, ")");
                }

                public /* synthetic */ LoadingState(boolean z2, boolean z3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? false : z3, (i & 4) != 0 ? C12147n.emptyList() : list);
                }
            }

            public MessageLoader(long j) {
                this.retryDelayMs = j;
                BehaviorSubject<LoadingState> behaviorSubjectM11130l0 = BehaviorSubject.m11130l0(this.mentionsLoadingState);
                C12238m.checkNotNullExpressionValue(behaviorSubjectM11130l0, "BehaviorSubject.create(mentionsLoadingState)");
                this.mentionsLoadingStateSubject = behaviorSubjectM11130l0;
            }

            @MainThread
            private final void handleLoadError() {
                retry(new WidgetUserMentions$Model$MessageLoader$handleLoadError$1(this));
            }

            @MainThread
            private final void handleLoaded(List<Message> messages) {
                boolean z2 = messages.isEmpty() || messages.size() < this.mentionLimit;
                Message message = (Message) C12163u.lastOrNull((List) messages);
                this.loadBeforeMessageId = message != null ? Long.valueOf(message.getId()) : null;
                this.mentions.addAll(messages);
                setMentionsLoadingState(LoadingState.copy$default(this.mentionsLoadingState, false, false, new ArrayList(this.mentions), 3, null));
                retry(new WidgetUserMentions$Model$MessageLoader$handleLoaded$1(this, z2));
            }

            private final void retry(Function0<Unit> retryAction) {
                Subscription subscription = this.retrySubscription;
                if (subscription != null) {
                    subscription.unsubscribe();
                }
                this.retryAction = retryAction;
                Observable<Long> observableM11068d0 = Observable.m11068d0(this.retryDelayMs, TimeUnit.MILLISECONDS);
                C12238m.checkNotNullExpressionValue(observableM11068d0, "Observable.timer(retryDe…s, TimeUnit.MILLISECONDS)");
                ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8518ui(observableM11068d0), (Class<?>) MessageLoader.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new WidgetUserMentions$Model$MessageLoader$retry$1(this)), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new WidgetUserMentions$Model$MessageLoader$retry$2(retryAction));
            }

            private final void setMentionsLoadingState(LoadingState loadingState) {
                if (C12238m.areEqual(this.mentionsLoadingState, loadingState)) {
                    return;
                }
                this.mentionsLoadingState = loadingState;
                this.mentionsLoadingStateSubject.onNext(loadingState);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ void tryLoad$default(MessageLoader messageLoader, Function1 function1, int i, Object obj) {
                if ((i & 1) != 0) {
                    function1 = WidgetUserMentions$Model$MessageLoader$tryLoad$1.INSTANCE;
                }
                messageLoader.tryLoad(function1);
            }

            public final Filters getFilters() {
                return this.filters;
            }

            public final BehaviorSubject<LoadingState> getMentionsLoadingStateSubject() {
                return this.mentionsLoadingStateSubject;
            }

            @MainThread
            public final void setFilters(Filters filters) {
                C12238m.checkNotNullParameter(filters, "value");
                if (!C12238m.areEqual(this.filters, filters)) {
                    this.filters = filters;
                    Subscription subscription = this.loadSubscription;
                    if (subscription != null) {
                        subscription.unsubscribe();
                    }
                    this.loadBeforeMessageId = null;
                    this.mentions.clear();
                    tryLoad(WidgetUserMentions$Model$MessageLoader$filters$1.INSTANCE);
                }
            }

            @MainThread
            public final void setInteractionState(StoreChat.InteractionState interactionState) {
                C12238m.checkNotNullParameter(interactionState, "interactionState");
                this.interactionState = interactionState;
                tryLoad$default(this, null, 1, null);
            }

            @MainThread
            public final void setIsFocused(boolean isFocused) {
                this.isFocused = isFocused;
                tryLoad$default(this, null, 1, null);
            }

            @MainThread
            public final void tryLoad(Function1<? super LoadingState, LoadingState> loadingStateUpdater) {
                StoreChat.InteractionState interactionState;
                C12238m.checkNotNullParameter(loadingStateUpdater, "loadingStateUpdater");
                setMentionsLoadingState(loadingStateUpdater.invoke(this.mentionsLoadingState));
                if (this.mentionsLoadingState.isLoading() || this.mentionsLoadingState.isAllLoaded() || (interactionState = this.interactionState) == null || !interactionState.isAtTopIgnoringTouch() || !this.isFocused) {
                    return;
                }
                setMentionsLoadingState(LoadingState.copy$default(this.mentionsLoadingState, true, false, null, 6, null));
                Observable observableM11083G = ObservableExtensionsKt.m8518ui(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getMentions(this.mentionLimit, this.filters.getIncludeRoles(), this.filters.getIncludeEveryone(), Long.valueOf(this.filters.getAllGuilds() ? 0L : this.filters.getGuildId()), this.loadBeforeMessageId), false, 1, null)).m11083G(new InterfaceC12589b<List<? extends com.discord.api.message.Message>, List<? extends Message>>() { // from class: com.discord.widgets.user.WidgetUserMentions$Model$MessageLoader$tryLoad$2
                    @Override // p637j0.p641k.InterfaceC12589b
                    public /* bridge */ /* synthetic */ List<? extends Message> call(List<? extends com.discord.api.message.Message> list) {
                        return call2((List<com.discord.api.message.Message>) list);
                    }

                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final List<Message> call2(List<com.discord.api.message.Message> list) {
                        C12238m.checkNotNullExpressionValue(list, "messages");
                        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(list, 10));
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            arrayList.add(new Message((com.discord.api.message.Message) it.next()));
                        }
                        return arrayList;
                    }
                });
                C12238m.checkNotNullExpressionValue(observableM11083G, "RestAPI\n            .api…messages.map(::Message) }");
                ObservableExtensionsKt.appSubscribe(observableM11083G, (Class<?>) MessageLoader.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new WidgetUserMentions$Model$MessageLoader$tryLoad$5(this)), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new WidgetUserMentions$Model$MessageLoader$tryLoad$3(this)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new WidgetUserMentions$Model$MessageLoader$tryLoad$4(this));
            }
        }

        public Model(long j, long j2, Guild guild, long j3, Map<Long, String> map, long j4, List<ChatListEntry> list, Set<Long> set, long j5, boolean z2, boolean z3, String str, NavigationTab navigationTab) {
            C12238m.checkNotNullParameter(map, "channelNames");
            C12238m.checkNotNullParameter(list, "list");
            C12238m.checkNotNullParameter(set, "myRoleIds");
            C12238m.checkNotNullParameter(navigationTab, "selectedTab");
            this.userId = j;
            this.channelId = j2;
            this.guild = guild;
            this.guildId = j3;
            this.channelNames = map;
            this.oldestMessageId = j4;
            this.list = list;
            this.myRoleIds = set;
            this.newMessagesMarkerMessageId = j5;
            this.isSpoilerClickAllowed = z2;
            this.animateEmojis = z3;
            this.guildName = str;
            this.selectedTab = navigationTab;
        }

        public final long component1() {
            return getUserId();
        }

        public final boolean component10() {
            return getIsSpoilerClickAllowed();
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final boolean getAnimateEmojis() {
            return this.animateEmojis;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getGuildName() {
            return this.guildName;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final NavigationTab getSelectedTab() {
            return this.selectedTab;
        }

        public final long component2() {
            return getChannelId();
        }

        public final Guild component3() {
            return getGuild();
        }

        public final long component4() {
            return getGuildId();
        }

        public final Map<Long, String> component5() {
            return getChannelNames();
        }

        public final long component6() {
            return getOldestMessageId();
        }

        public final List<ChatListEntry> component7() {
            return getList();
        }

        public final Set<Long> component8() {
            return getMyRoleIds();
        }

        public final long component9() {
            return getNewMessagesMarkerMessageId();
        }

        public final Model copy(long userId, long channelId, Guild guild, long guildId, Map<Long, String> channelNames, long oldestMessageId, List<ChatListEntry> list, Set<Long> myRoleIds, long newMessagesMarkerMessageId, boolean isSpoilerClickAllowed, boolean animateEmojis, String guildName, NavigationTab selectedTab) {
            C12238m.checkNotNullParameter(channelNames, "channelNames");
            C12238m.checkNotNullParameter(list, "list");
            C12238m.checkNotNullParameter(myRoleIds, "myRoleIds");
            C12238m.checkNotNullParameter(selectedTab, "selectedTab");
            return new Model(userId, channelId, guild, guildId, channelNames, oldestMessageId, list, myRoleIds, newMessagesMarkerMessageId, isSpoilerClickAllowed, animateEmojis, guildName, selectedTab);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return getUserId() == model.getUserId() && getChannelId() == model.getChannelId() && C12238m.areEqual(getGuild(), model.getGuild()) && getGuildId() == model.getGuildId() && C12238m.areEqual(getChannelNames(), model.getChannelNames()) && getOldestMessageId() == model.getOldestMessageId() && C12238m.areEqual(getList(), model.getList()) && C12238m.areEqual(getMyRoleIds(), model.getMyRoleIds()) && getNewMessagesMarkerMessageId() == model.getNewMessagesMarkerMessageId() && getIsSpoilerClickAllowed() == model.getIsSpoilerClickAllowed() && this.animateEmojis == model.animateEmojis && C12238m.areEqual(this.guildName, model.guildName) && C12238m.areEqual(this.selectedTab, model.selectedTab);
        }

        public final boolean getAnimateEmojis() {
            return this.animateEmojis;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public long getChannelId() {
            return this.channelId;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public Map<Long, String> getChannelNames() {
            return this.channelNames;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public Guild getGuild() {
            return this.guild;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public long getGuildId() {
            return this.guildId;
        }

        public final String getGuildName() {
            return this.guildName;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public List<ChatListEntry> getList() {
            return this.list;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public Set<Long> getMyRoleIds() {
            return this.myRoleIds;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public long getNewMessagesMarkerMessageId() {
            return this.newMessagesMarkerMessageId;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public long getOldestMessageId() {
            return this.oldestMessageId;
        }

        public final NavigationTab getSelectedTab() {
            return this.selectedTab;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public long getUserId() {
            return this.userId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v20, types: [int] */
        /* JADX WARN: Type inference failed for: r1v17, types: [int] */
        /* JADX WARN: Type inference failed for: r1v24 */
        /* JADX WARN: Type inference failed for: r1v26 */
        /* JADX WARN: Type inference failed for: r3v3 */
        /* JADX WARN: Type inference failed for: r3v4, types: [int] */
        /* JADX WARN: Type inference failed for: r3v5 */
        public int hashCode() {
            int iM3a = (C0002b.m3a(getChannelId()) + (C0002b.m3a(getUserId()) * 31)) * 31;
            Guild guild = getGuild();
            int iM3a2 = (C0002b.m3a(getGuildId()) + ((iM3a + (guild != null ? guild.hashCode() : 0)) * 31)) * 31;
            Map<Long, String> channelNames = getChannelNames();
            int iM3a3 = (C0002b.m3a(getOldestMessageId()) + ((iM3a2 + (channelNames != null ? channelNames.hashCode() : 0)) * 31)) * 31;
            List<ChatListEntry> list = getList();
            int iHashCode = (iM3a3 + (list != null ? list.hashCode() : 0)) * 31;
            Set<Long> myRoleIds = getMyRoleIds();
            int iM3a4 = (C0002b.m3a(getNewMessagesMarkerMessageId()) + ((iHashCode + (myRoleIds != null ? myRoleIds.hashCode() : 0)) * 31)) * 31;
            boolean isSpoilerClickAllowed = getIsSpoilerClickAllowed();
            ?? r1 = isSpoilerClickAllowed;
            if (isSpoilerClickAllowed) {
                r1 = 1;
            }
            int i = (iM3a4 + r1) * 31;
            boolean z2 = this.animateEmojis;
            int i2 = (i + (z2 ? 1 : z2)) * 31;
            String str = this.guildName;
            int iHashCode2 = (i2 + (str != null ? str.hashCode() : 0)) * 31;
            NavigationTab navigationTab = this.selectedTab;
            return iHashCode2 + (navigationTab != null ? navigationTab.hashCode() : 0);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        /* JADX INFO: renamed from: isSpoilerClickAllowed, reason: from getter */
        public boolean getIsSpoilerClickAllowed() {
            return this.isSpoilerClickAllowed;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Model(userId=");
            sbM833U.append(getUserId());
            sbM833U.append(", channelId=");
            sbM833U.append(getChannelId());
            sbM833U.append(", guild=");
            sbM833U.append(getGuild());
            sbM833U.append(", guildId=");
            sbM833U.append(getGuildId());
            sbM833U.append(", channelNames=");
            sbM833U.append(getChannelNames());
            sbM833U.append(", oldestMessageId=");
            sbM833U.append(getOldestMessageId());
            sbM833U.append(", list=");
            sbM833U.append(getList());
            sbM833U.append(", myRoleIds=");
            sbM833U.append(getMyRoleIds());
            sbM833U.append(", newMessagesMarkerMessageId=");
            sbM833U.append(getNewMessagesMarkerMessageId());
            sbM833U.append(", isSpoilerClickAllowed=");
            sbM833U.append(getIsSpoilerClickAllowed());
            sbM833U.append(", animateEmojis=");
            sbM833U.append(this.animateEmojis);
            sbM833U.append(", guildName=");
            sbM833U.append(this.guildName);
            sbM833U.append(", selectedTab=");
            sbM833U.append(this.selectedTab);
            sbM833U.append(")");
            return sbM833U.toString();
        }

        public /* synthetic */ Model(long j, long j2, Guild guild, long j3, Map map, long j4, List list, Set set, long j5, boolean z2, boolean z3, String str, NavigationTab navigationTab, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, j2, guild, j3, map, j4, list, set, j5, (i & 512) != 0 ? false : z2, z3, str, navigationTab);
        }
    }

    /* JADX INFO: compiled from: WidgetUserMentions.kt */
    public static final class UserMentionsAdapterEventHandler implements WidgetChatListAdapter.EventHandler {
        private final ChannelSelector channelSelector;
        private final Function1<StoreChat.InteractionState, Unit> interactionStateUpdated;
        private final boolean isEmbedded;

        /* JADX WARN: Multi-variable type inference failed */
        public UserMentionsAdapterEventHandler(boolean z2, ChannelSelector channelSelector, Function1<? super StoreChat.InteractionState, Unit> function1) {
            C12238m.checkNotNullParameter(channelSelector, "channelSelector");
            C12238m.checkNotNullParameter(function1, "interactionStateUpdated");
            this.isEmbedded = z2;
            this.channelSelector = channelSelector;
            this.interactionStateUpdated = function1;
        }

        private final void jumpToMessage(Message message) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            companion.getMessagesLoader().jumpToMessage(message.getChannelId(), message.getId());
            companion.getTabsNavigation().selectHomeTab(StoreNavigation.PanelAction.CLOSE, this.isEmbedded);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onBotUiComponentClicked(long j, Long l, long j2, long j3, Long l2, int i, RestAPIParams.ComponentInteractionData componentInteractionData) {
            C12238m.checkNotNullParameter(componentInteractionData, "componentSendData");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onBotUiComponentClicked(this, j, l, j2, j3, l2, i, componentInteractionData);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onCallMessageClicked(long voiceChannelId, WidgetChatListAdapterItemCallMessage.CallStatus callStatus) {
            C12238m.checkNotNullParameter(callStatus, "callStatus");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onCommandClicked(long j, Long l, long j2, long j3, long j4, long j5, String str) {
            WidgetChatListAdapter.EventHandler.DefaultImpls.onCommandClicked(this, j, l, j2, j3, j4, j5, str);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onDismissClicked(Message message) {
            C12238m.checkNotNullParameter(message, "message");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onDismissClicked(this, message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onDismissLocalMessageClicked(Message message) {
            C12238m.checkNotNullParameter(message, "message");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onDismissLocalMessageClicked(this, message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onInteractionStateUpdated(StoreChat.InteractionState interactionState) {
            C12238m.checkNotNullParameter(interactionState, "interactionState");
            this.interactionStateUpdated.invoke(interactionState);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onListClicked() {
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageAuthorAvatarClicked(Message message, long guildId) {
            C12238m.checkNotNullParameter(message, "message");
            jumpToMessage(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageAuthorLongClicked(Message message, Long guildId) {
            C12238m.checkNotNullParameter(message, "message");
            jumpToMessage(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageAuthorNameClicked(Message message, long guildId) {
            C12238m.checkNotNullParameter(message, "message");
            jumpToMessage(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageBlockedGroupClicked(Message message) {
            C12238m.checkNotNullParameter(message, "message");
            jumpToMessage(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageClicked(Message message, boolean isThreadStarterMessage) {
            C12238m.checkNotNullParameter(message, "message");
            jumpToMessage(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageLongClicked(Message message, CharSequence formattedMessage, boolean isThreadStarterMessage) {
            C12238m.checkNotNullParameter(message, "message");
            C12238m.checkNotNullParameter(formattedMessage, "formattedMessage");
            jumpToMessage(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onOldestMessageId(long channelId, long oldestMessageId) {
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onOpenPinsClicked(Message message) {
            C12238m.checkNotNullParameter(message, "message");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onQuickAddReactionClicked(long guildId, long myUserId, long channelId, long messageId) {
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public boolean onQuickDownloadClicked(Uri uri, String fileName) {
            C12238m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            C12238m.checkNotNullParameter(fileName, "fileName");
            return false;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onReactionClicked(long guildId, long myUserId, long channelId, long messageId, MessageReaction reaction, boolean canAddReactions) {
            C12238m.checkNotNullParameter(reaction, "reaction");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onReactionLongClicked(long guildId, long channelId, long messageId, MessageReaction reaction) {
            C12238m.checkNotNullParameter(reaction, "reaction");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onReportIssueWithAutoMod(Context context, Message message) {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(message, "message");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onReportIssueWithAutoMod(this, context, message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onRoleSubscriptionPurchaseTierClick(long j, long j2, long j3, long j4, long j5) {
            WidgetChatListAdapter.EventHandler.DefaultImpls.onRoleSubscriptionPurchaseTierClick(this, j, j2, j3, j4, j5);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onSendGreetMessageClicked(long j, int i, Sticker sticker) {
            C12238m.checkNotNullParameter(sticker, "sticker");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onSendGreetMessageClicked(this, j, i, sticker);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onShareButtonClick(GuildScheduledEvent guildScheduledEvent, WeakReference<Context> weakReference, WeakReference<AppFragment> weakReference2) {
            C12238m.checkNotNullParameter(guildScheduledEvent, "guildEvent");
            C12238m.checkNotNullParameter(weakReference, "weakContext");
            C12238m.checkNotNullParameter(weakReference2, "weakFragment");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onShareButtonClick(this, guildScheduledEvent, weakReference, weakReference2);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onStickerClicked(Message message, BaseSticker sticker) {
            C12238m.checkNotNullParameter(message, "message");
            C12238m.checkNotNullParameter(sticker, "sticker");
            StoreStream.INSTANCE.getMessagesLoader().jumpToMessage(message.getChannelId(), message.getId());
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onSystemMessageCtaClicked(Message message, Channel channel, BaseSticker baseSticker) {
            C12238m.checkNotNullParameter(message, "message");
            C12238m.checkNotNullParameter(channel, "channel");
            C12238m.checkNotNullParameter(baseSticker, "sticker");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onSystemMessageCtaClicked(this, message, channel, baseSticker);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onThreadClicked(Channel channel) {
            C12238m.checkNotNullParameter(channel, "channel");
            ChannelSelector.selectChannel$default(this.channelSelector, channel, null, SelectedChannelAnalyticsLocation.EMBED, 2, null);
            StoreStream.INSTANCE.getTabsNavigation().selectHomeTab(StoreNavigation.PanelAction.CLOSE, this.isEmbedded);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onThreadLongClicked(Channel channel) {
            C12238m.checkNotNullParameter(channel, "channel");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onThreadLongClicked(this, channel);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onUrlLongClicked(String str) {
            C12238m.checkNotNullParameter(str, "url");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onUrlLongClicked(this, str);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onUserActivityAction(long authorId, long channelId, long messageId, MessageActivityType actionType, Activity activity, Application application) {
            C12238m.checkNotNullParameter(actionType, "actionType");
            C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            C12238m.checkNotNullParameter(application, "application");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onUserMentionClicked(long j, long j2, long j3) {
            WidgetChatListAdapter.EventHandler.DefaultImpls.onUserMentionClicked(this, j, j2, j3);
        }
    }

    /* JADX INFO: compiled from: WidgetUserMentions.kt */
    public static final class WidgetUserMentionFilter extends AppBottomSheet {
        public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetUserMentionFilter.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserMentionsFilterBinding;", 0)};

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
        private final FragmentViewBindingDelegate binding;
        private Model.MessageLoader.Filters filters;
        private String guildName;
        private Function1<? super Model.MessageLoader.Filters, Unit> onFiltersUpdated;

        /* JADX INFO: compiled from: WidgetUserMentions.kt */
        public static final class Companion {
            private Companion() {
            }

            public final WidgetUserMentionFilter show(FragmentManager fragmentManager, String guildName, Model.MessageLoader.Filters filters, Function1<? super Model.MessageLoader.Filters, Unit> onFiltersUpdated) {
                C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
                C12238m.checkNotNullParameter(filters, "filters");
                C12238m.checkNotNullParameter(onFiltersUpdated, "onFiltersUpdated");
                WidgetUserMentionFilter widgetUserMentionFilter = new WidgetUserMentionFilter();
                widgetUserMentionFilter.onFiltersUpdated = onFiltersUpdated;
                widgetUserMentionFilter.filters = filters;
                widgetUserMentionFilter.guildName = guildName;
                widgetUserMentionFilter.show(fragmentManager, WidgetUserMentionFilter.class.getName());
                return widgetUserMentionFilter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public WidgetUserMentionFilter() {
            super(false, 1, null);
            this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetUserMentions$WidgetUserMentionFilter$binding$2.INSTANCE, null, 2, null);
        }

        public static final /* synthetic */ Model.MessageLoader.Filters access$getFilters$p(WidgetUserMentionFilter widgetUserMentionFilter) {
            Model.MessageLoader.Filters filters = widgetUserMentionFilter.filters;
            if (filters == null) {
                C12238m.throwUninitializedPropertyAccessException("filters");
            }
            return filters;
        }

        public static final /* synthetic */ Function1 access$getOnFiltersUpdated$p(WidgetUserMentionFilter widgetUserMentionFilter) {
            Function1<? super Model.MessageLoader.Filters, Unit> function1 = widgetUserMentionFilter.onFiltersUpdated;
            if (function1 == null) {
                C12238m.throwUninitializedPropertyAccessException("onFiltersUpdated");
            }
            return function1;
        }

        private final Job delayedDismiss() {
            CoroutineScope coroutineScope;
            View view = getView();
            if (view == null || (coroutineScope = ViewCoroutineScopeKt.getCoroutineScope(view)) == null) {
                return null;
            }
            return C3404f.m4211H0(coroutineScope, null, null, new WidgetUserMentions$WidgetUserMentionFilter$delayedDismiss$1(this, null), 3, null);
        }

        private final WidgetUserMentionsFilterBinding getBinding() {
            return (WidgetUserMentionsFilterBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
        }

        private final void updateFilters(Model.MessageLoader.Filters filters) {
            this.filters = filters;
            Function1<? super Model.MessageLoader.Filters, Unit> function1 = this.onFiltersUpdated;
            if (function1 == null) {
                C12238m.throwUninitializedPropertyAccessException("onFiltersUpdated");
            }
            function1.invoke(filters);
        }

        @Override // com.discord.app.AppBottomSheet
        public int getContentViewResId() {
            return C5419R.layout.widget_user_mentions_filter;
        }

        @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
        public void onPause() {
            dismissAllowingStateLoss();
            super.onPause();
        }

        @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
        public void onResume() {
            super.onResume();
            CheckedSetting checkedSetting = getBinding().f18339d;
            C12238m.checkNotNullExpressionValue(checkedSetting, "binding.userMentionsFilterThisServer");
            Model.MessageLoader.Filters filters = this.filters;
            if (filters == null) {
                C12238m.throwUninitializedPropertyAccessException("filters");
            }
            checkedSetting.setChecked(!filters.getAllGuilds());
            String str = this.guildName;
            if (str == null || C12103t.isBlank(str)) {
                CheckedSetting checkedSetting2 = getBinding().f18339d;
                C12238m.checkNotNullExpressionValue(checkedSetting2, "binding.userMentionsFilterThisServer");
                checkedSetting2.setVisibility(8);
            } else {
                CheckedSetting checkedSetting3 = getBinding().f18339d;
                C12238m.checkNotNullExpressionValue(checkedSetting3, "binding.userMentionsFilterThisServer");
                checkedSetting3.setVisibility(0);
                CheckedSetting checkedSetting4 = getBinding().f18339d;
                Context context = getContext();
                checkedSetting4.setText(context != null ? C1107b.m216h(context, C5419R.string.this_server_named, new Object[]{this.guildName}, null, 4) : null);
                getBinding().f18339d.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.user.WidgetUserMentions$WidgetUserMentionFilter$onResume$1
                    @Override // p658rx.functions.Action1
                    public final void call(Boolean bool) {
                        WidgetUserMentions.WidgetUserMentionFilter widgetUserMentionFilter = this.this$0;
                        WidgetUserMentions.Model.MessageLoader.Filters filtersAccess$getFilters$p = WidgetUserMentions.WidgetUserMentionFilter.access$getFilters$p(widgetUserMentionFilter);
                        CheckedSetting checkedSetting5 = this.this$0.getBinding().f18339d;
                        C12238m.checkNotNullExpressionValue(checkedSetting5, "binding.userMentionsFilterThisServer");
                        widgetUserMentionFilter.updateFilters(WidgetUserMentions.Model.MessageLoader.Filters.copy$default(filtersAccess$getFilters$p, 0L, !checkedSetting5.isChecked(), false, false, 13, null));
                        this.this$0.delayedDismiss();
                    }
                });
            }
            CheckedSetting checkedSetting5 = getBinding().f18337b;
            C12238m.checkNotNullExpressionValue(checkedSetting5, "binding.userMentionsFilterIncludeEveryone");
            Model.MessageLoader.Filters filters2 = this.filters;
            if (filters2 == null) {
                C12238m.throwUninitializedPropertyAccessException("filters");
            }
            checkedSetting5.setChecked(filters2.getIncludeEveryone());
            getBinding().f18337b.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.user.WidgetUserMentions$WidgetUserMentionFilter$onResume$2
                @Override // p658rx.functions.Action1
                public final void call(Boolean bool) {
                    WidgetUserMentions.WidgetUserMentionFilter widgetUserMentionFilter = this.this$0;
                    WidgetUserMentions.Model.MessageLoader.Filters filtersAccess$getFilters$p = WidgetUserMentions.WidgetUserMentionFilter.access$getFilters$p(widgetUserMentionFilter);
                    CheckedSetting checkedSetting6 = this.this$0.getBinding().f18337b;
                    C12238m.checkNotNullExpressionValue(checkedSetting6, "binding.userMentionsFilterIncludeEveryone");
                    widgetUserMentionFilter.updateFilters(WidgetUserMentions.Model.MessageLoader.Filters.copy$default(filtersAccess$getFilters$p, 0L, false, checkedSetting6.isChecked(), false, 11, null));
                    this.this$0.delayedDismiss();
                }
            });
            CheckedSetting checkedSetting6 = getBinding().f18338c;
            C12238m.checkNotNullExpressionValue(checkedSetting6, "binding.userMentionsFilterIncludeRoles");
            Model.MessageLoader.Filters filters3 = this.filters;
            if (filters3 == null) {
                C12238m.throwUninitializedPropertyAccessException("filters");
            }
            checkedSetting6.setChecked(filters3.getIncludeRoles());
            getBinding().f18338c.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.user.WidgetUserMentions$WidgetUserMentionFilter$onResume$3
                @Override // p658rx.functions.Action1
                public final void call(Boolean bool) {
                    WidgetUserMentions.WidgetUserMentionFilter widgetUserMentionFilter = this.this$0;
                    WidgetUserMentions.Model.MessageLoader.Filters filtersAccess$getFilters$p = WidgetUserMentions.WidgetUserMentionFilter.access$getFilters$p(widgetUserMentionFilter);
                    CheckedSetting checkedSetting7 = this.this$0.getBinding().f18338c;
                    C12238m.checkNotNullExpressionValue(checkedSetting7, "binding.userMentionsFilterIncludeRoles");
                    widgetUserMentionFilter.updateFilters(WidgetUserMentions.Model.MessageLoader.Filters.copy$default(filtersAccess$getFilters$p, 0L, false, false, checkedSetting7.isChecked(), 7, null));
                    this.this$0.delayedDismiss();
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserMentions$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetUserMentions.kt */
    public static final /* synthetic */ class C102132 extends C12236k implements Function1<StoreChat.InteractionState, Unit> {
        public C102132(Model.MessageLoader messageLoader) {
            super(1, messageLoader, Model.MessageLoader.class, "setInteractionState", "setInteractionState(Lcom/discord/stores/StoreChat$InteractionState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreChat.InteractionState interactionState) {
            invoke2(interactionState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreChat.InteractionState interactionState) {
            C12238m.checkNotNullParameter(interactionState, "p1");
            ((Model.MessageLoader) this.receiver).setInteractionState(interactionState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserMentions$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetUserMentions.kt */
    public static final class C102141 extends AbstractC12240o implements Function1<Model, Unit> {
        public C102141() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            C12238m.checkNotNullParameter(model, "it");
            WidgetUserMentions.this.configureUI(model);
        }
    }

    public WidgetUserMentions() {
        super(C5419R.layout.widget_user_mentions);
        this.isEmbedded = FragmentExtensionsKt.booleanExtra$default(this, EXTRA_IS_EMBEDDED, false, 2, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetUserMentions$binding$2.INSTANCE, null, 2, null);
        this.mentionsLoader = new Model.MessageLoader(1000L);
        this.storeTabsNavigation = StoreStream.INSTANCE.getTabsNavigation();
        this.dismissViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetGlobalSearchDismissModel.class), new WidgetUserMentions$$special$$inlined$activityViewModels$1(this), new WidgetUserMentions$$special$$inlined$activityViewModels$2(this));
        WidgetUserMentions$viewModel$2 widgetUserMentions$viewModel$2 = WidgetUserMentions$viewModel$2.INSTANCE;
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetUserMentionsViewModel.class), new WidgetUserMentions$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetUserMentions$viewModel$2));
    }

    private final void addThreadSpineItemDecoration(WidgetChatListAdapter adapter) {
        getBinding().f18335c.addItemDecoration(new ThreadSpineItemDecoration(requireContext(), adapter));
    }

    private final void configureToolbar(final String guildName) {
        AppFragment.bindToolbar$default(this, null, 1, null);
        String string = this.mentionsLoader.getFilters().getAllGuilds() ? getString(C5419R.string.all_servers) : guildName;
        if (isEmbedded()) {
            setActionBarTitle(string);
        } else {
            setActionBarSubtitle(string);
        }
        AppFragment.setActionBarOptionsMenu$default(this, C5419R.menu.menu_user_mentions, new Action2<MenuItem, Context>() { // from class: com.discord.widgets.user.WidgetUserMentions.configureToolbar.1

            /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserMentions$configureToolbar$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetUserMentions.kt */
            public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Model.MessageLoader.Filters, Unit> {
                public AnonymousClass1() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Model.MessageLoader.Filters filters) {
                    invoke2(filters);
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Model.MessageLoader.Filters filters) {
                    C12238m.checkNotNullParameter(filters, "filters");
                    WidgetUserMentions.this.mentionsLoader.setFilters(filters);
                }
            }

            @Override // p658rx.functions.Action2
            public final void call(MenuItem menuItem, Context context) {
                C12238m.checkNotNullExpressionValue(menuItem, "menuItem");
                if (menuItem.getItemId() == C5419R.id.menu_user_mentions_filter) {
                    WidgetUserMentionFilter.Companion companion = WidgetUserMentionFilter.INSTANCE;
                    FragmentManager parentFragmentManager = WidgetUserMentions.this.getParentFragmentManager();
                    C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    companion.show(parentFragmentManager, guildName, WidgetUserMentions.this.mentionsLoader.getFilters(), new AnonymousClass1());
                }
            }
        }, null, 4, null);
    }

    private final void configureUI(Model model) {
        boolean allGuilds = model.getGuildId() > 0 ? this.mentionsLoader.getFilters().getAllGuilds() : true;
        WidgetChatListAdapter widgetChatListAdapter = this.mentionsAdapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.setData(model);
        }
        Model.MessageLoader messageLoader = this.mentionsLoader;
        messageLoader.setFilters(Model.MessageLoader.Filters.copy$default(messageLoader.getFilters(), model.getGuildId(), allGuilds, false, false, 12, null));
        this.mentionsLoader.setIsFocused(model.getSelectedTab() == NavigationTab.MENTIONS);
        if (isEmbedded() || isOnMentionsTab()) {
            configureToolbar(model.getGuildName());
        }
        getViewModel().setModel$app_productionGoogleRelease(model);
    }

    private final WidgetChatListAdapter createAdapter(Function1<? super StoreChat.InteractionState, Unit> onInteractionStateUpdated) {
        RecyclerView recyclerView = getBinding().f18335c;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.userMentionsList");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetChatListAdapter widgetChatListAdapter = new WidgetChatListAdapter(recyclerView, this, parentFragmentManager, new UserMentionsAdapterEventHandler(isEmbedded(), ChannelSelector.INSTANCE.getInstance(), onInteractionStateUpdated), null, null, 48, null);
        addThreadSpineItemDecoration(widgetChatListAdapter);
        return widgetChatListAdapter;
    }

    private final WidgetUserMentionsBinding getBinding() {
        return (WidgetUserMentionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetGlobalSearchDismissModel getDismissViewModel() {
        return (WidgetGlobalSearchDismissModel) this.dismissViewModel.getValue();
    }

    private final WidgetUserMentionsViewModel getViewModel() {
        return (WidgetUserMentionsViewModel) this.viewModel.getValue();
    }

    private final boolean isEmbedded() {
        return ((Boolean) this.isEmbedded.getValue()).booleanValue();
    }

    private final boolean isOnMentionsTab() {
        return this.storeTabsNavigation.getSelectedTab() == NavigationTab.MENTIONS;
    }

    private final Observable<Model> observeModel() {
        if (isEmbedded()) {
            return Model.INSTANCE.get(this.mentionsLoader, NavigationTab.MENTIONS);
        }
        Observable observableM11099Y = StoreStream.INSTANCE.getTabsNavigation().observeSelectedTab().m11099Y(new InterfaceC12589b<NavigationTab, Observable<? extends Model>>() { // from class: com.discord.widgets.user.WidgetUserMentions.observeModel.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends Model> call(NavigationTab navigationTab) {
                if (navigationTab == NavigationTab.MENTIONS) {
                    return Model.INSTANCE.get(WidgetUserMentions.this.mentionsLoader, navigationTab);
                }
                Model.Companion companion = Model.INSTANCE;
                Model.MessageLoader messageLoader = WidgetUserMentions.this.mentionsLoader;
                C12238m.checkNotNullExpressionValue(navigationTab, "selectedTab");
                return companion.get(messageLoader, navigationTab).m11100Z(1);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11099Y, "StoreStream.getTabsNavig…          }\n            }");
        return observableM11099Y;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        WidgetChatListAdapter widgetChatListAdapter = this.mentionsAdapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.dispose();
        }
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        WidgetChatListAdapter widgetChatListAdapter = this.mentionsAdapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.disposeHandlers();
        }
    }

    @Override // com.discord.widgets.tabs.OnTabSelectedListener
    public void onTabSelected() {
        Model model$app_productionGoogleRelease = getViewModel().getModel();
        if (model$app_productionGoogleRelease != null) {
            configureToolbar(model$app_productionGoogleRelease.getGuildName());
        }
        setActionBarTitleAccessibilityViewFocused();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        LinearLayoutManager layoutManager;
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        if (isEmbedded()) {
            onTabSelected();
            AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
            getBinding().f18334b.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.WidgetUserMentions.onViewBound.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    WidgetUserMentions.this.getDismissViewModel().dismiss();
                }
            });
        } else {
            setActionBarTitle(C5419R.string.recent_mentions);
        }
        WidgetChatListAdapter widgetChatListAdapter = (WidgetChatListAdapter) MGRecyclerAdapter.INSTANCE.configure(createAdapter(new C102132(this.mentionsLoader)));
        this.mentionsAdapter = widgetChatListAdapter;
        if (widgetChatListAdapter != null && (layoutManager = widgetChatListAdapter.getLayoutManager()) != null) {
            layoutManager.setSmoothScrollbarEnabled(true);
        }
        WidgetChatListAdapter widgetChatListAdapter2 = this.mentionsAdapter;
        if (widgetChatListAdapter2 != null) {
            widgetChatListAdapter2.setMentionMeMessageLevelHighlighting(false);
        }
        Fragment parentFragment = getParentFragment();
        WidgetTabsHost widgetTabsHost = (WidgetTabsHost) (parentFragment instanceof WidgetTabsHost ? parentFragment : null);
        if (widgetTabsHost != null) {
            widgetTabsHost.registerTabSelectionListener(NavigationTab.MENTIONS, this);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observeModel()), this, null, 2, null), (Class<?>) WidgetUserMentions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C102141());
        WidgetChatListAdapter widgetChatListAdapter = this.mentionsAdapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.setHandlers();
        }
        Model.MessageLoader.tryLoad$default(this.mentionsLoader, null, 1, null);
    }
}
