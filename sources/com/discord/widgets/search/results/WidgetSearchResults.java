package com.discord.widgets.search.results;

import a0.a.a.b;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.d.b.a.outline;
import com.discord.R;
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
import com.discord.stores.StoreChannelsSelected3;
import com.discord.stores.StoreChat;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.embed.InviteEmbedModel;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableCombineLatestOverloads2;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.search.network.state.QueryFetchState;
import com.discord.utilities.search.network.state.SearchState;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
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
import com.discord.widgets.search.results.WidgetSearchResults;
import d0.t.Collections2;
import d0.t.Maps6;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
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
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetSearchResults.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchResults extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSearchResults.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSearchResultsBinding;", 0)};
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
                Observable observableR = StoreStream.INSTANCE.getSearch().getStoreSearchQuery().getState().Y(new Func1<SearchState, Observable<? extends Model>>() { // from class: com.discord.widgets.search.results.WidgetSearchResults$Model$Companion$get$1

                    /* JADX INFO: renamed from: com.discord.widgets.search.results.WidgetSearchResults$Model$Companion$get$1$1, reason: invalid class name */
                    /* JADX INFO: compiled from: WidgetSearchResults.kt */
                    public static final class AnonymousClass1 extends Lambda implements Function10<WidgetChatListModelMessages.MessagesWithMetadata, Long, Map<Long, ? extends String>, Map<Long, ? extends Guild>, Map<Long, ? extends Map<Long, ? extends GuildMember>>, Map<Long, ? extends Map<Long, ? extends GuildRole>>, Map<Long, ? extends Channel>, Boolean, Boolean, InviteEmbedModel, WidgetSearchResults.Model> {
                        public final /* synthetic */ SearchState $searchState;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(SearchState searchState) {
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
                            Intrinsics3.checkNotNullParameter(messagesWithMetadata, "messagesWithMetadata");
                            Intrinsics3.checkNotNullParameter(map, "channelNames");
                            Intrinsics3.checkNotNullParameter(map6, "guilds");
                            Intrinsics3.checkNotNullParameter(map7, "members");
                            Intrinsics3.checkNotNullParameter(map8, "roles");
                            Intrinsics3.checkNotNullParameter(map5, "channels");
                            Intrinsics3.checkNotNullParameter(inviteEmbedModel, "inviteEmbedModel");
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
                                        Map mapEmptyMap = (Map) outline.c(channel, map7);
                                        if (mapEmptyMap == null) {
                                            mapEmptyMap = Maps6.emptyMap();
                                        }
                                        Map map9 = mapEmptyMap;
                                        GuildMember guildMember = (GuildMember) map9.get(Long.valueOf(j));
                                        List<Long> roles = guildMember != null ? guildMember.getRoles() : null;
                                        if (roles == null) {
                                            roles = Collections2.emptyList();
                                        }
                                        hashSet.addAll(roles);
                                        arrayList.add(new MessageHeaderEntry(message, channel, (Guild) outline.c(channel, map6)));
                                        Map<Long, GuildRole> mapEmptyMap2 = map8.get(Long.valueOf(channel.getGuildId()));
                                        if (mapEmptyMap2 == null) {
                                            mapEmptyMap2 = Maps6.emptyMap();
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

                    @Override // j0.k.Func1
                    public final Observable<? extends WidgetSearchResults.Model> call(SearchState searchState) {
                        WidgetChatListModelMessages.MessagesWithMetadata.Companion companion = WidgetChatListModelMessages.MessagesWithMetadata.INSTANCE;
                        List<Message> hits = searchState.getHits();
                        if (hits == null) {
                            hits = new ArrayList<>();
                        }
                        Observable<WidgetChatListModelMessages.MessagesWithMetadata> observable = companion.get(hits);
                        StoreStream.Companion companion2 = StoreStream.INSTANCE;
                        return ObservableCombineLatestOverloads2.combineLatest(observable, companion2.getUsers().observeMeId(), companion2.getChannels().observeNames(), companion2.getGuilds().observeGuilds(), companion2.getGuilds().observeComputed(), companion2.getGuilds().observeRoles(), companion2.getChannels().observeAllChannels(), StoreUserSettings.observeIsAnimatedEmojisEnabled$default(companion2.getUserSettings(), false, 1, null), StoreUserSettings.observeIsAutoPlayGifsEnabled$default(companion2.getUserSettings(), false, 1, null), InviteEmbedModel.Companion.observe$default(InviteEmbedModel.INSTANCE, null, null, null, null, 15, null), new AnonymousClass1(searchState));
                    }
                }).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream\n            …  .distinctUntilChanged()");
                return ObservableExtensionsKt.computationLatest(observableR);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Model(List<? extends ChatListEntry> list, long j, Map<Long, String> map, long j2, Set<Long> set) {
            Intrinsics3.checkNotNullParameter(list, "list");
            Intrinsics3.checkNotNullParameter(map, "channelNames");
            Intrinsics3.checkNotNullParameter(set, "myRoleIds");
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
            Intrinsics3.checkNotNullParameter(list, "list");
            Intrinsics3.checkNotNullParameter(channelNames, "channelNames");
            Intrinsics3.checkNotNullParameter(myRoleIds, "myRoleIds");
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
            return Intrinsics3.areEqual(getList(), model.getList()) && getUserId() == model.getUserId() && Intrinsics3.areEqual(getChannelNames(), model.getChannelNames()) && getOldestMessageId() == model.getOldestMessageId() && Intrinsics3.areEqual(getMyRoleIds(), model.getMyRoleIds());
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
            int iA = (b.a(getUserId()) + ((list != null ? list.hashCode() : 0) * 31)) * 31;
            Map<Long, String> channelNames = getChannelNames();
            int iA2 = (b.a(getOldestMessageId()) + ((iA + (channelNames != null ? channelNames.hashCode() : 0)) * 31)) * 31;
            Set<Long> myRoleIds = getMyRoleIds();
            return iA2 + (myRoleIds != null ? myRoleIds.hashCode() : 0);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        /* JADX INFO: renamed from: isSpoilerClickAllowed, reason: from getter */
        public boolean getIsSpoilerClickAllowed() {
            return this.isSpoilerClickAllowed;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(list=");
            sbU.append(getList());
            sbU.append(", userId=");
            sbU.append(getUserId());
            sbU.append(", channelNames=");
            sbU.append(getChannelNames());
            sbU.append(", oldestMessageId=");
            sbU.append(getOldestMessageId());
            sbU.append(", myRoleIds=");
            sbU.append(getMyRoleIds());
            sbU.append(")");
            return sbU.toString();
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
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(channelSelector, "channelSelector");
            this.context = context;
            this.fragmentManager = fragmentManager;
            this.channelSelector = channelSelector;
        }

        private final void jumpToChat(Message message) {
            StoreStream.INSTANCE.getMessagesLoader().jumpToMessage(message.getChannelId(), message.getId());
            AppScreen2.c(this.context, false, null, 6);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onBotUiComponentClicked(long applicationId, Long guildId, long channelId, long messageId, Long messageFlags, int componentIndex, RestAPIParams.ComponentInteractionData componentSendData) {
            Intrinsics3.checkNotNullParameter(componentSendData, "componentSendData");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onCallMessageClicked(long voiceChannelId, WidgetChatListAdapterItemCallMessage.CallStatus callStatus) {
            Intrinsics3.checkNotNullParameter(callStatus, "callStatus");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onCommandClicked(long interactionId, Long guildId, long channelId, long messageId, long interactionUserId, long applicationId, String messageNonce) {
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onDismissClicked(Message message) {
            Intrinsics3.checkNotNullParameter(message, "message");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onDismissLocalMessageClicked(Message message) {
            Intrinsics3.checkNotNullParameter(message, "message");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onDismissLocalMessageClicked(this, message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onInteractionStateUpdated(StoreChat.InteractionState interactionState) {
            Intrinsics3.checkNotNullParameter(interactionState, "interactionState");
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
            Intrinsics3.checkNotNullParameter(message, "message");
            jumpToChat(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageAuthorLongClicked(Message message, Long guildId) {
            Intrinsics3.checkNotNullParameter(message, "message");
            jumpToChat(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageAuthorNameClicked(Message message, long guildId) {
            Intrinsics3.checkNotNullParameter(message, "message");
            jumpToChat(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageBlockedGroupClicked(Message message) {
            Intrinsics3.checkNotNullParameter(message, "message");
            jumpToChat(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageClicked(Message message, boolean isThreadStarterMessage) {
            Intrinsics3.checkNotNullParameter(message, "message");
            jumpToChat(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageLongClicked(Message message, CharSequence formattedMessage, boolean isThreadStarterMessage) {
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(formattedMessage, "formattedMessage");
            jumpToChat(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onOldestMessageId(long channelId, long oldestMessageId) {
            this.oldestMessageId = oldestMessageId;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onOpenPinsClicked(Message message) {
            Intrinsics3.checkNotNullParameter(message, "message");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onQuickAddReactionClicked(long guildId, long myUserId, long channelId, long messageId) {
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public boolean onQuickDownloadClicked(Uri uri, String fileName) {
            Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            Intrinsics3.checkNotNullParameter(fileName, "fileName");
            return false;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onReactionClicked(long guildId, long myUserId, long channelId, long messageId, MessageReaction reaction, boolean canAddReactions) {
            Intrinsics3.checkNotNullParameter(reaction, "reaction");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onReactionLongClicked(long guildId, long channelId, long messageId, MessageReaction reaction) {
            Intrinsics3.checkNotNullParameter(reaction, "reaction");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onReportIssueWithAutoMod(Context context, Message message) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(message, "message");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onReportIssueWithAutoMod(this, context, message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onRoleSubscriptionPurchaseTierClick(long j, long j2, long j3, long j4, long j5) {
            WidgetChatListAdapter.EventHandler.DefaultImpls.onRoleSubscriptionPurchaseTierClick(this, j, j2, j3, j4, j5);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onSendGreetMessageClicked(long j, int i, Sticker sticker) {
            Intrinsics3.checkNotNullParameter(sticker, "sticker");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onSendGreetMessageClicked(this, j, i, sticker);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onShareButtonClick(GuildScheduledEvent guildScheduledEvent, WeakReference<Context> weakReference, WeakReference<AppFragment> weakReference2) {
            Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildEvent");
            Intrinsics3.checkNotNullParameter(weakReference, "weakContext");
            Intrinsics3.checkNotNullParameter(weakReference2, "weakFragment");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onShareButtonClick(this, guildScheduledEvent, weakReference, weakReference2);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onStickerClicked(Message message, BaseSticker sticker) {
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(sticker, "sticker");
            jumpToChat(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onSystemMessageCtaClicked(Message message, Channel channel, BaseSticker baseSticker) {
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(baseSticker, "sticker");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onSystemMessageCtaClicked(this, message, channel, baseSticker);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onThreadClicked(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            ChannelSelector.selectChannel$default(this.channelSelector, channel, null, StoreChannelsSelected3.EMBED, 2, null);
            AppScreen2.c(this.context, false, null, 6);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onThreadLongClicked(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onUrlLongClicked(String url) {
            Intrinsics3.checkNotNullParameter(url, "url");
            WidgetUrlActions.INSTANCE.launch(this.fragmentManager, url);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onUserActivityAction(long authorId, long channelId, long messageId, MessageActivityType actionType, Activity activity, Application application) {
            Intrinsics3.checkNotNullParameter(actionType, "actionType");
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            Intrinsics3.checkNotNullParameter(application, "application");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onUserMentionClicked(long userId, long channelId, long guildId) {
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.search.results.WidgetSearchResults$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSearchResults.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetSearchResults widgetSearchResults) {
            super(1, widgetSearchResults, WidgetSearchResults.class, "configureUI", "configureUI(Lcom/discord/widgets/search/results/WidgetSearchResults$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "p1");
            ((WidgetSearchResults) this.receiver).configureUI(model);
        }
    }

    public WidgetSearchResults() {
        super(R.layout.widget_search_results);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSearchResults3.INSTANCE, null, 2, null);
    }

    private final void addThreadSpineItemDecoration(WidgetChatListAdapter adapter) {
        getBinding().f2523b.addItemDecoration(new ThreadSpineItemDecoration(requireContext(), adapter));
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
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f2523b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.searchResultsList");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "view.context");
        FragmentManager parentFragmentManager2 = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
        WidgetChatListAdapter widgetChatListAdapter = (WidgetChatListAdapter) companion.configure(new WidgetChatListAdapter(recyclerView, this, parentFragmentManager, new SearchResultAdapterEventHandler(context, parentFragmentManager2, ChannelSelector.INSTANCE.getInstance()), null, null, 48, null));
        addThreadSpineItemDecoration(widgetChatListAdapter);
        this.adapter = widgetChatListAdapter;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(), this, null, 2, null), (Class<?>) WidgetSearchResults.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
        WidgetChatListAdapter widgetChatListAdapter = this.adapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.setHandlers();
        }
    }
}
