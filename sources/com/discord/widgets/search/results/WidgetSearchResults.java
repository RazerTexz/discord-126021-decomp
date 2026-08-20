package com.discord.widgets.search.results;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.activity.Activity;
import com.discord.api.application.Application;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.message.activity.MessageActivityType;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.role.GuildRole;
import com.discord.api.sticker.BaseSticker;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSearchResultsBinding;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.SelectedChannelAnalyticsLocation;
import com.discord.stores.StoreChat;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.embed.InviteEmbedModel;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableCombineLatestOverloadsKt;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.search.network.state.QueryFetchState;
import com.discord.utilities.search.network.state.SearchState;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.chat.WidgetUrlActions;
import com.discord.widgets.chat.list.ThreadSpineItemDecoration;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.LoadingEntry;
import com.discord.widgets.chat.list.entries.MessageHeaderEntry;
import com.discord.widgets.chat.list.entries.SearchEmptyEntry;
import com.discord.widgets.chat.list.entries.SearchErrorEntry;
import com.discord.widgets.chat.list.entries.SearchIndexingEntry;
import com.discord.widgets.chat.list.entries.SearchResultCountEntry;
import com.discord.widgets.chat.list.model.WidgetChatListModelMessages;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.C0870j;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetSearchResults.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchResults extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetSearchResults.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSearchResultsBinding;", 0)};
    private WidgetChatListAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetSearchResults.kt */
    public static final /* data */ class Model implements WidgetChatListAdapter.Data {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long channelId;
        private final Map<Long, String> channelNames;
        private final Guild guild;
        private final long guildId;
        private final boolean isSpoilerClickAllowed;
        private final List<ChatListEntry> list;
        private final Set<Long> myRoleIds;
        private final long newMessagesMarkerMessageId;
        private final long oldestMessageId;
        private final long userId;

        /* JADX INFO: compiled from: WidgetSearchResults.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get() {
                Observable observableM11112r = StoreStream.INSTANCE.getSearch().getStoreSearchQuery().getState().m11099Y(new InterfaceC12589b<SearchState, Observable<? extends Model>>() { // from class: com.discord.widgets.search.results.WidgetSearchResults$Model$Companion$get$1

                    /* JADX INFO: renamed from: com.discord.widgets.search.results.WidgetSearchResults$Model$Companion$get$1$1 */
                    /* JADX INFO: compiled from: WidgetSearchResults.kt */
                    public static final class C91341 extends AbstractC12240o implements Function10<WidgetChatListModelMessages.MessagesWithMetadata, Long, Map<Long, ? extends String>, Map<Long, ? extends Guild>, Map<Long, ? extends Map<Long, ? extends GuildMember>>, Map<Long, ? extends Map<Long, ? extends GuildRole>>, Map<Long, ? extends Channel>, Boolean, Boolean, InviteEmbedModel, WidgetSearchResults.Model> {
                        public final /* synthetic */ SearchState $searchState;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public C91341(SearchState searchState) {
                            super(10);
                            this.$searchState = searchState;
                        }

                        @Override // kotlin.jvm.functions.Function10
                        public /* bridge */ /* synthetic */ WidgetSearchResults.Model invoke(WidgetChatListModelMessages.MessagesWithMetadata messagesWithMetadata, Long l, Map<Long, ? extends String> map, Map<Long, ? extends Guild> map2, Map<Long, ? extends Map<Long, ? extends GuildMember>> map3, Map<Long, ? extends Map<Long, ? extends GuildRole>> map4, Map<Long, ? extends Channel> map5, Boolean bool, Boolean bool2, InviteEmbedModel inviteEmbedModel) {
                            return invoke(messagesWithMetadata, l.longValue(), (Map<Long, String>) map, (Map<Long, Guild>) map2, (Map<Long, ? extends Map<Long, GuildMember>>) map3, (Map<Long, ? extends Map<Long, GuildRole>>) map4, (Map<Long, Channel>) map5, bool.booleanValue(), bool2.booleanValue(), inviteEmbedModel);
                        }

                        public final WidgetSearchResults.Model invoke(WidgetChatListModelMessages.MessagesWithMetadata messagesWithMetadata, long j, Map<Long, String> map, Map<Long, Guild> map2, Map<Long, ? extends Map<Long, GuildMember>> map3, Map<Long, ? extends Map<Long, GuildRole>> map4, Map<Long, Channel> map5, boolean z2, boolean z3, InviteEmbedModel inviteEmbedModel) {
                            Long l;
                            Map<Long, Guild> map6 = map2;
                            Map<Long, ? extends Map<Long, GuildMember>> map7 = map3;
                            Map<Long, ? extends Map<Long, GuildRole>> map8 = map4;
                            C12238m.checkNotNullParameter(messagesWithMetadata, "messagesWithMetadata");
                            C12238m.checkNotNullParameter(map, "channelNames");
                            C12238m.checkNotNullParameter(map6, "guilds");
                            C12238m.checkNotNullParameter(map7, "members");
                            C12238m.checkNotNullParameter(map8, "roles");
                            C12238m.checkNotNullParameter(map5, "channels");
                            C12238m.checkNotNullParameter(inviteEmbedModel, "inviteEmbedModel");
                            ArrayList arrayList = new ArrayList();
                            HashSet hashSet = new HashSet();
                            Long l2 = null;
                            if (this.$searchState.getQueryFetchState() == QueryFetchState.COMPLETED || this.$searchState.getQueryFetchState() == QueryFetchState.LOADING_MORE) {
                                List<Message> messages = messagesWithMetadata.getMessages();
                                if (!messages.isEmpty()) {
                                    Long lValueOf = Long.valueOf(messages.get(messages.size() - 1).getId());
                                    arrayList.add(new SearchResultCountEntry(this.$searchState.getTotalResults()));
                                    l = lValueOf;
                                } else {
                                    l = null;
                                }
                                for (Message message : messages) {
                                    Channel channel = map5.get(Long.valueOf(message.getChannelId()));
                                    if (channel != null) {
                                        Map mapEmptyMap = (Map) C1643a.m843c(channel, map7);
                                        if (mapEmptyMap == null) {
                                            mapEmptyMap = C12136h0.emptyMap();
                                        }
                                        Map map9 = mapEmptyMap;
                                        GuildMember guildMember = (GuildMember) map9.get(Long.valueOf(j));
                                        List<Long> roles = guildMember != null ? guildMember.getRoles() : null;
                                        if (roles == null) {
                                            roles = C12147n.emptyList();
                                        }
                                        hashSet.addAll(roles);
                                        arrayList.add(new MessageHeaderEntry(message, channel, (Guild) C1643a.m843c(channel, map6)));
                                        Map<Long, GuildRole> mapEmptyMap2 = map8.get(Long.valueOf(channel.getGuildId()));
                                        if (mapEmptyMap2 == null) {
                                            mapEmptyMap2 = C12136h0.emptyMap();
                                        }
                                        arrayList.addAll(WidgetChatListModelMessages.Companion.getMessageItems$default(WidgetChatListModelMessages.INSTANCE, channel, map9, mapEmptyMap2, new HashMap(), messagesWithMetadata.getMessageThreads().get(Long.valueOf(message.getId())), messagesWithMetadata.getThreadCountsAndLatestMessages().get(Long.valueOf(message.getId())), message, messagesWithMetadata.getMessageState().get(Long.valueOf(message.getId())), new HashMap(), false, false, null, z2, z3, StoreStream.INSTANCE.getUserSettings().getIsRenderEmbedsEnabled(), j, false, new HashMap(), inviteEmbedModel, false, GuildRoleSubscriptionsFeatureFlag.INSTANCE.getINSTANCE().canGuildSeePurchaseFeedbackLoopMessages(channel.getGuildId()), 524288, null));
                                    }
                                    map6 = map2;
                                    map7 = map3;
                                    map8 = map4;
                                }
                                if (this.$searchState.getQueryFetchState() == QueryFetchState.LOADING_MORE) {
                                    arrayList.add(new LoadingEntry());
                                } else if (arrayList.isEmpty()) {
                                    arrayList.add(new SearchEmptyEntry());
                                }
                                l2 = l;
                            } else if (this.$searchState.getQueryFetchState() == QueryFetchState.IN_PROGRESS) {
                                arrayList.add(new LoadingEntry());
                            } else if (this.$searchState.getQueryFetchState() == QueryFetchState.INDEXING) {
                                arrayList.add(new SearchIndexingEntry());
                            } else if (this.$searchState.getQueryFetchState() == QueryFetchState.FAILED) {
                                arrayList.add(new SearchErrorEntry());
                            }
                            return new WidgetSearchResults.Model(arrayList, j, map, l2 != null ? l2.longValue() : 0L, hashSet);
                        }
                    }

                    @Override // p637j0.p641k.InterfaceC12589b
                    public final Observable<? extends WidgetSearchResults.Model> call(SearchState searchState) {
                        WidgetChatListModelMessages.MessagesWithMetadata.Companion companion = WidgetChatListModelMessages.MessagesWithMetadata.INSTANCE;
                        List<Message> hits = searchState.getHits();
                        if (hits == null) {
                            hits = new ArrayList<>();
                        }
                        Observable<WidgetChatListModelMessages.MessagesWithMetadata> observable = companion.get(hits);
                        StoreStream.Companion companion2 = StoreStream.INSTANCE;
                        return ObservableCombineLatestOverloadsKt.combineLatest(observable, companion2.getUsers().observeMeId(), companion2.getChannels().observeNames(), companion2.getGuilds().observeGuilds(), companion2.getGuilds().observeComputed(), companion2.getGuilds().observeRoles(), companion2.getChannels().observeAllChannels(), StoreUserSettings.observeIsAnimatedEmojisEnabled$default(companion2.getUserSettings(), false, 1, null), StoreUserSettings.observeIsAutoPlayGifsEnabled$default(companion2.getUserSettings(), false, 1, null), InviteEmbedModel.Companion.observe$default(InviteEmbedModel.INSTANCE, null, null, null, null, 15, null), new C91341(searchState));
                    }
                }).m11112r();
                C12238m.checkNotNullExpressionValue(observableM11112r, "StoreStream\n            …  .distinctUntilChanged()");
                return ObservableExtensionsKt.computationLatest(observableM11112r);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Model(List<? extends ChatListEntry> list, long j, Map<Long, String> map, long j2, Set<Long> set) {
            C12238m.checkNotNullParameter(list, "list");
            C12238m.checkNotNullParameter(map, "channelNames");
            C12238m.checkNotNullParameter(set, "myRoleIds");
            this.list = list;
            this.userId = j;
            this.channelNames = map;
            this.oldestMessageId = j2;
            this.myRoleIds = set;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Model copy$default(Model model, List list, long j, Map map, long j2, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                list = model.getList();
            }
            if ((i & 2) != 0) {
                j = model.getUserId();
            }
            long j3 = j;
            if ((i & 4) != 0) {
                map = model.getChannelNames();
            }
            Map map2 = map;
            if ((i & 8) != 0) {
                j2 = model.getOldestMessageId();
            }
            long j4 = j2;
            if ((i & 16) != 0) {
                set = model.getMyRoleIds();
            }
            return model.copy(list, j3, map2, j4, set);
        }

        public final List<ChatListEntry> component1() {
            return getList();
        }

        public final long component2() {
            return getUserId();
        }

        public final Map<Long, String> component3() {
            return getChannelNames();
        }

        public final long component4() {
            return getOldestMessageId();
        }

        public final Set<Long> component5() {
            return getMyRoleIds();
        }

        public final Model copy(List<? extends ChatListEntry> list, long userId, Map<Long, String> channelNames, long oldestMessageId, Set<Long> myRoleIds) {
            C12238m.checkNotNullParameter(list, "list");
            C12238m.checkNotNullParameter(channelNames, "channelNames");
            C12238m.checkNotNullParameter(myRoleIds, "myRoleIds");
            return new Model(list, userId, channelNames, oldestMessageId, myRoleIds);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return C12238m.areEqual(getList(), model.getList()) && getUserId() == model.getUserId() && C12238m.areEqual(getChannelNames(), model.getChannelNames()) && getOldestMessageId() == model.getOldestMessageId() && C12238m.areEqual(getMyRoleIds(), model.getMyRoleIds());
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

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public long getUserId() {
            return this.userId;
        }

        public int hashCode() {
            List<ChatListEntry> list = getList();
            int iM3a = (C0002b.m3a(getUserId()) + ((list != null ? list.hashCode() : 0) * 31)) * 31;
            Map<Long, String> channelNames = getChannelNames();
            int iM3a2 = (C0002b.m3a(getOldestMessageId()) + ((iM3a + (channelNames != null ? channelNames.hashCode() : 0)) * 31)) * 31;
            Set<Long> myRoleIds = getMyRoleIds();
            return iM3a2 + (myRoleIds != null ? myRoleIds.hashCode() : 0);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        /* JADX INFO: renamed from: isSpoilerClickAllowed, reason: from getter */
        public boolean getIsSpoilerClickAllowed() {
            return this.isSpoilerClickAllowed;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Model(list=");
            sbM833U.append(getList());
            sbM833U.append(", userId=");
            sbM833U.append(getUserId());
            sbM833U.append(", channelNames=");
            sbM833U.append(getChannelNames());
            sbM833U.append(", oldestMessageId=");
            sbM833U.append(getOldestMessageId());
            sbM833U.append(", myRoleIds=");
            sbM833U.append(getMyRoleIds());
            sbM833U.append(")");
            return sbM833U.toString();
        }

        public /* synthetic */ Model(List list, long j, Map map, long j2, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i & 2) != 0 ? 0L : j, map, j2, set);
        }
    }

    /* JADX INFO: compiled from: WidgetSearchResults.kt */
    public static final class SearchResultAdapterEventHandler implements WidgetChatListAdapter.EventHandler {
        private final ChannelSelector channelSelector;
        private final Context context;
        private final FragmentManager fragmentManager;
        private long oldestMessageId;

        public SearchResultAdapterEventHandler(Context context, FragmentManager fragmentManager, ChannelSelector channelSelector) {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(channelSelector, "channelSelector");
            this.context = context;
            this.fragmentManager = fragmentManager;
            this.channelSelector = channelSelector;
        }

        private final void jumpToChat(Message message) {
            StoreStream.INSTANCE.getMessagesLoader().jumpToMessage(message.getChannelId(), message.getId());
            C0870j.m155c(this.context, false, null, 6);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onBotUiComponentClicked(long applicationId, Long guildId, long channelId, long messageId, Long messageFlags, int componentIndex, RestAPIParams.ComponentInteractionData componentSendData) {
            C12238m.checkNotNullParameter(componentSendData, "componentSendData");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onCallMessageClicked(long voiceChannelId, WidgetChatListAdapterItemCallMessage.CallStatus callStatus) {
            C12238m.checkNotNullParameter(callStatus, "callStatus");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onCommandClicked(long interactionId, Long guildId, long channelId, long messageId, long interactionUserId, long applicationId, String messageNonce) {
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onDismissClicked(Message message) {
            C12238m.checkNotNullParameter(message, "message");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onDismissLocalMessageClicked(Message message) {
            C12238m.checkNotNullParameter(message, "message");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onDismissLocalMessageClicked(this, message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onInteractionStateUpdated(StoreChat.InteractionState interactionState) {
            C12238m.checkNotNullParameter(interactionState, "interactionState");
            if (!interactionState.getIsAtTop() || this.oldestMessageId == RecyclerView.FOREVER_NS) {
                return;
            }
            StoreStream.INSTANCE.getSearch().loadMore(this.oldestMessageId);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onListClicked() {
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageAuthorAvatarClicked(Message message, long guildId) {
            C12238m.checkNotNullParameter(message, "message");
            jumpToChat(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageAuthorLongClicked(Message message, Long guildId) {
            C12238m.checkNotNullParameter(message, "message");
            jumpToChat(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageAuthorNameClicked(Message message, long guildId) {
            C12238m.checkNotNullParameter(message, "message");
            jumpToChat(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageBlockedGroupClicked(Message message) {
            C12238m.checkNotNullParameter(message, "message");
            jumpToChat(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageClicked(Message message, boolean isThreadStarterMessage) {
            C12238m.checkNotNullParameter(message, "message");
            jumpToChat(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageLongClicked(Message message, CharSequence formattedMessage, boolean isThreadStarterMessage) {
            C12238m.checkNotNullParameter(message, "message");
            C12238m.checkNotNullParameter(formattedMessage, "formattedMessage");
            jumpToChat(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onOldestMessageId(long channelId, long oldestMessageId) {
            this.oldestMessageId = oldestMessageId;
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
            jumpToChat(message);
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
            C0870j.m155c(this.context, false, null, 6);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onThreadLongClicked(Channel channel) {
            C12238m.checkNotNullParameter(channel, "channel");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onUrlLongClicked(String url) {
            C12238m.checkNotNullParameter(url, "url");
            WidgetUrlActions.INSTANCE.launch(this.fragmentManager, url);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onUserActivityAction(long authorId, long channelId, long messageId, MessageActivityType actionType, Activity activity, Application application) {
            C12238m.checkNotNullParameter(actionType, "actionType");
            C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            C12238m.checkNotNullParameter(application, "application");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onUserMentionClicked(long userId, long channelId, long guildId) {
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.search.results.WidgetSearchResults$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetSearchResults.kt */
    public static final /* synthetic */ class C91351 extends C12236k implements Function1<Model, Unit> {
        public C91351(WidgetSearchResults widgetSearchResults) {
            super(1, widgetSearchResults, WidgetSearchResults.class, "configureUI", "configureUI(Lcom/discord/widgets/search/results/WidgetSearchResults$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            C12238m.checkNotNullParameter(model, "p1");
            ((WidgetSearchResults) this.receiver).configureUI(model);
        }
    }

    public WidgetSearchResults() {
        super(C5419R.layout.widget_search_results);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSearchResults$binding$2.INSTANCE, null, 2, null);
    }

    private final void addThreadSpineItemDecoration(WidgetChatListAdapter adapter) {
        getBinding().f17425b.addItemDecoration(new ThreadSpineItemDecoration(requireContext(), adapter));
    }

    private final void configureUI(Model model) {
        WidgetChatListAdapter widgetChatListAdapter = this.adapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.setData(model);
        }
    }

    private final WidgetSearchResultsBinding getBinding() {
        return (WidgetSearchResultsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        WidgetChatListAdapter widgetChatListAdapter = this.adapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.dispose();
        }
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        WidgetChatListAdapter widgetChatListAdapter = this.adapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.disposeHandlers();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f17425b;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.searchResultsList");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context context = view.getContext();
        C12238m.checkNotNullExpressionValue(context, "view.context");
        FragmentManager parentFragmentManager2 = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
        WidgetChatListAdapter widgetChatListAdapter = (WidgetChatListAdapter) companion.configure(new WidgetChatListAdapter(recyclerView, this, parentFragmentManager, new SearchResultAdapterEventHandler(context, parentFragmentManager2, ChannelSelector.INSTANCE.getInstance()), null, null, 48, null));
        addThreadSpineItemDecoration(widgetChatListAdapter);
        this.adapter = widgetChatListAdapter;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(), this, null, 2, null), (Class<?>) WidgetSearchResults.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C91351(this));
        WidgetChatListAdapter widgetChatListAdapter = this.adapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.setHandlers();
        }
    }
}
