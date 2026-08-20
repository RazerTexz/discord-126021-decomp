package com.discord.widgets.chat.pins;

import android.content.Context;
import android.content.Intent;
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
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.message.activity.MessageActivityType;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.role.GuildRole;
import com.discord.api.sticker.BaseSticker;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChannelPinnedMessagesBinding;
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
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.chat.WidgetUrlActions;
import com.discord.widgets.chat.list.ThreadSpineItemDecoration;
import com.discord.widgets.chat.list.actions.WidgetChatListActions;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.DividerEntry;
import com.discord.widgets.chat.list.entries.EmptyPinsEntry;
import com.discord.widgets.chat.list.entries.LoadingEntry;
import com.discord.widgets.chat.list.model.WidgetChatListModelMessages;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
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
import p507d0.p580t.C12145m;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetChannelPinnedMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelPinnedMessages extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetChannelPinnedMessages.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelPinnedMessagesBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";
    private WidgetChatListAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetChannelPinnedMessages.kt */
    public static final class ChannelPinnedMessagesAdapterEventHandler implements WidgetChatListAdapter.EventHandler {
        private final ChannelSelector channelSelector;
        private final Context context;
        private final FragmentManager fragmentManager;

        public ChannelPinnedMessagesAdapterEventHandler(Context context, FragmentManager fragmentManager, ChannelSelector channelSelector) {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(channelSelector, "channelSelector");
            this.context = context;
            this.fragmentManager = fragmentManager;
            this.channelSelector = channelSelector;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onBotUiComponentClicked(long j, Long l, long j2, long j3, Long l2, int i, RestAPIParams.ComponentInteractionData componentInteractionData) {
            C12238m.checkNotNullParameter(componentInteractionData, "componentSendData");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onBotUiComponentClicked(this, j, l, j2, j3, l2, i, componentInteractionData);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onCallMessageClicked(long j, WidgetChatListAdapterItemCallMessage.CallStatus callStatus) {
            C12238m.checkNotNullParameter(callStatus, "callStatus");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onCallMessageClicked(this, j, callStatus);
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
            WidgetChatListAdapter.EventHandler.DefaultImpls.onInteractionStateUpdated(this, interactionState);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onListClicked() {
            WidgetChatListAdapter.EventHandler.DefaultImpls.onListClicked(this);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageAuthorAvatarClicked(Message message, long j) {
            C12238m.checkNotNullParameter(message, "message");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onMessageAuthorAvatarClicked(this, message, j);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageAuthorLongClicked(Message message, Long l) {
            C12238m.checkNotNullParameter(message, "message");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onMessageAuthorLongClicked(this, message, l);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageAuthorNameClicked(Message message, long j) {
            C12238m.checkNotNullParameter(message, "message");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onMessageAuthorNameClicked(this, message, j);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageBlockedGroupClicked(Message message) {
            C12238m.checkNotNullParameter(message, "message");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onMessageBlockedGroupClicked(this, message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageClicked(Message message, boolean isThreadStarterMessage) {
            C12238m.checkNotNullParameter(message, "message");
            StoreStream.INSTANCE.getMessagesLoader().jumpToMessage(message.getChannelId(), message.getId());
            C0870j.m155c(this.context, false, null, 6);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageLongClicked(Message message, CharSequence formattedMessage, boolean isThreadStarterMessage) {
            C12238m.checkNotNullParameter(message, "message");
            C12238m.checkNotNullParameter(formattedMessage, "formattedMessage");
            WidgetChatListActions.INSTANCE.showForPin(this.fragmentManager, message.getChannelId(), message.getId(), formattedMessage);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onOldestMessageId(long j, long j2) {
            WidgetChatListAdapter.EventHandler.DefaultImpls.onOldestMessageId(this, j, j2);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onOpenPinsClicked(Message message) {
            C12238m.checkNotNullParameter(message, "message");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onOpenPinsClicked(this, message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onQuickAddReactionClicked(long j, long j2, long j3, long j4) {
            WidgetChatListAdapter.EventHandler.DefaultImpls.onQuickAddReactionClicked(this, j, j2, j3, j4);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public boolean onQuickDownloadClicked(Uri uri, String str) {
            C12238m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            C12238m.checkNotNullParameter(str, "fileName");
            return WidgetChatListAdapter.EventHandler.DefaultImpls.onQuickDownloadClicked(this, uri, str);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onReactionClicked(long j, long j2, long j3, long j4, MessageReaction messageReaction, boolean z2) {
            C12238m.checkNotNullParameter(messageReaction, "reaction");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onReactionClicked(this, j, j2, j3, j4, messageReaction, z2);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onReactionLongClicked(long j, long j2, long j3, MessageReaction messageReaction) {
            C12238m.checkNotNullParameter(messageReaction, "reaction");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onReactionLongClicked(this, j, j2, j3, messageReaction);
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
            C0870j.m155c(this.context, false, null, 6);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onThreadLongClicked(Channel channel) {
            C12238m.checkNotNullParameter(channel, "channel");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onThreadLongClicked(this, channel);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onUrlLongClicked(String url) {
            C12238m.checkNotNullParameter(url, "url");
            WidgetUrlActions.INSTANCE.launch(this.fragmentManager, url);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onUserActivityAction(long j, long j2, long j3, MessageActivityType messageActivityType, Activity activity, Application application) {
            C12238m.checkNotNullParameter(messageActivityType, "messageActivityType");
            C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            C12238m.checkNotNullParameter(application, "application");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onUserActivityAction(this, j, j2, j3, messageActivityType, activity, application);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onUserMentionClicked(long j, long j2, long j3) {
            WidgetChatListAdapter.EventHandler.DefaultImpls.onUserMentionClicked(this, j, j2, j3);
        }
    }

    /* JADX INFO: compiled from: WidgetChannelPinnedMessages.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context, long channelId) {
            C12238m.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra(WidgetChannelPinnedMessages.INTENT_EXTRA_CHANNEL_ID, channelId);
            C0870j.m156d(context, WidgetChannelPinnedMessages.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetChannelPinnedMessages.kt */
    public static final /* data */ class Model implements WidgetChatListAdapter.Data {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Channel channel;
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

        /* JADX INFO: compiled from: WidgetChannelPinnedMessages.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(final Context context, long channelId) {
                C12238m.checkNotNullParameter(context, "context");
                StoreStream.Companion companion = StoreStream.INSTANCE;
                final Channel channelFindChannelById = companion.getChannels().findChannelById(channelId);
                if (channelFindChannelById != null) {
                    Observable observableM11099Y = companion.getPinnedMessages().observeForChannel(channelId).m11099Y(new InterfaceC12589b<List<? extends Message>, Observable<? extends Model>>() { // from class: com.discord.widgets.chat.pins.WidgetChannelPinnedMessages$Model$Companion$get$1

                        /* JADX INFO: renamed from: com.discord.widgets.chat.pins.WidgetChannelPinnedMessages$Model$Companion$get$1$1 */
                        /* JADX INFO: compiled from: WidgetChannelPinnedMessages.kt */
                        public static final class C82011 extends AbstractC12240o implements Function10<Long, WidgetChatListModelMessages.MessagesWithMetadata, Map<Long, ? extends GuildRole>, Map<Long, ? extends GuildMember>, Map<Long, ? extends String>, Boolean, Boolean, Guild, InviteEmbedModel, Boolean, WidgetChannelPinnedMessages.Model> {
                            public final /* synthetic */ List $pinnedMessages;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public C82011(List list) {
                                super(10);
                                this.$pinnedMessages = list;
                            }

                            @Override // kotlin.jvm.functions.Function10
                            public /* bridge */ /* synthetic */ WidgetChannelPinnedMessages.Model invoke(Long l, WidgetChatListModelMessages.MessagesWithMetadata messagesWithMetadata, Map<Long, ? extends GuildRole> map, Map<Long, ? extends GuildMember> map2, Map<Long, ? extends String> map3, Boolean bool, Boolean bool2, Guild guild, InviteEmbedModel inviteEmbedModel, Boolean bool3) {
                                return invoke(l.longValue(), messagesWithMetadata, (Map<Long, GuildRole>) map, (Map<Long, GuildMember>) map2, (Map<Long, String>) map3, bool.booleanValue(), bool2.booleanValue(), guild, inviteEmbedModel, bool3.booleanValue());
                            }

                            /* JADX WARN: Code duplicated, block: B:27:0x0141  */
                            public final WidgetChannelPinnedMessages.Model invoke(long j, WidgetChatListModelMessages.MessagesWithMetadata messagesWithMetadata, Map<Long, GuildRole> map, Map<Long, GuildMember> map2, Map<Long, String> map3, boolean z2, boolean z3, Guild guild, InviteEmbedModel inviteEmbedModel, boolean z4) {
                                List list;
                                List listListOf;
                                GuildMember guildMember;
                                Set setEmptySet;
                                List<Long> roles;
                                C12238m.checkNotNullParameter(messagesWithMetadata, "messagesWithMetadata");
                                C12238m.checkNotNullParameter(map, "guildRoles");
                                C12238m.checkNotNullParameter(map2, "guildMembers");
                                C12238m.checkNotNullParameter(map3, "channelNames");
                                C12238m.checkNotNullParameter(inviteEmbedModel, "inviteEmbedModel");
                                List list2 = this.$pinnedMessages;
                                if (list2 != null) {
                                    if (list2.isEmpty()) {
                                        WidgetChannelPinnedMessages$Model$Companion$get$1 widgetChannelPinnedMessages$Model$Companion$get$1 = WidgetChannelPinnedMessages$Model$Companion$get$1.this;
                                        String string = context.getString(ChannelUtils.m7667B(channelFindChannelById) ? C5419R.string.no_pins_in_dm : C5419R.string.no_pins_in_channel);
                                        C12238m.checkNotNullExpressionValue(string, "context.getString(\n     …                        )");
                                        listListOf = C12145m.listOf(new EmptyPinsEntry(string));
                                    } else {
                                        ArrayList arrayList = new ArrayList();
                                        int size = this.$pinnedMessages.size();
                                        int i = 0;
                                        while (i < size) {
                                            Message message = (Message) this.$pinnedMessages.get(i);
                                            int i2 = i;
                                            int i3 = size;
                                            ArrayList arrayList2 = arrayList;
                                            arrayList2.addAll(WidgetChatListModelMessages.Companion.getMessageItems$default(WidgetChatListModelMessages.INSTANCE, channelFindChannelById, map2, map, new HashMap(), messagesWithMetadata.getMessageThreads().get(Long.valueOf(message.getId())), messagesWithMetadata.getThreadCountsAndLatestMessages().get(Long.valueOf(message.getId())), message, messagesWithMetadata.getMessageState().get(Long.valueOf(message.getId())), new HashMap(), false, false, null, z2, z3, StoreStream.INSTANCE.getUserSettings().getIsRenderEmbedsEnabled(), j, false, new HashMap(), inviteEmbedModel, false, z4, 524288, null));
                                            if (i2 < this.$pinnedMessages.size() - 1) {
                                                arrayList2.add(new DividerEntry());
                                            }
                                            i = i2 + 1;
                                            arrayList = arrayList2;
                                            size = i3;
                                        }
                                        list = arrayList;
                                    }
                                    guildMember = map2.get(Long.valueOf(j));
                                    if (guildMember != null || (roles = guildMember.getRoles()) == null || (setEmptySet = C12163u.toHashSet(roles)) == null) {
                                        setEmptySet = C12148n0.emptySet();
                                    }
                                    return new WidgetChannelPinnedMessages.Model(channelFindChannelById, guild, j, map3, list, setEmptySet, 0L, 0L, 0L, 0L, false, 1984, null);
                                }
                                listListOf = C12145m.listOf(new LoadingEntry());
                                list = listListOf;
                                guildMember = map2.get(Long.valueOf(j));
                                if (guildMember != null) {
                                    setEmptySet = C12148n0.emptySet();
                                } else {
                                    setEmptySet = C12148n0.emptySet();
                                }
                                return new WidgetChannelPinnedMessages.Model(channelFindChannelById, guild, j, map3, list, setEmptySet, 0L, 0L, 0L, 0L, false, 1984, null);
                            }
                        }

                        @Override // p637j0.p641k.InterfaceC12589b
                        public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelPinnedMessages.Model> call(List<? extends Message> list) {
                            return call2((List<Message>) list);
                        }

                        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                        public final Observable<? extends WidgetChannelPinnedMessages.Model> call2(List<Message> list) {
                            StoreStream.Companion companion2 = StoreStream.INSTANCE;
                            Observable<Long> observableObserveMeId = companion2.getUsers().observeMeId();
                            WidgetChatListModelMessages.MessagesWithMetadata.Companion companion3 = WidgetChatListModelMessages.MessagesWithMetadata.INSTANCE;
                            C12238m.checkNotNullExpressionValue(list, "pinnedMessages");
                            return ObservableCombineLatestOverloadsKt.combineLatest(observableObserveMeId, companion3.get(list), companion2.getGuilds().observeRoles(channelFindChannelById.getGuildId()), companion2.getGuilds().observeComputed(channelFindChannelById.getGuildId()), companion2.getChannels().observeNames(), StoreUserSettings.observeIsAnimatedEmojisEnabled$default(companion2.getUserSettings(), false, 1, null), StoreUserSettings.observeIsAutoPlayGifsEnabled$default(companion2.getUserSettings(), false, 1, null), companion2.getGuilds().observeGuild(channelFindChannelById.getGuildId()), InviteEmbedModel.Companion.observe$default(InviteEmbedModel.INSTANCE, null, null, null, null, 15, null), GuildRoleSubscriptionsFeatureFlag.INSTANCE.getINSTANCE().observeCanGuildSeePurchaseFeedbackLoopSystemMessages(Long.valueOf(channelFindChannelById.getGuildId())), new C82011(list));
                        }
                    });
                    C12238m.checkNotNullExpressionValue(observableM11099Y, "getPinnedMessages().obse…              }\n        }");
                    return observableM11099Y;
                }
                C12721k c12721k = new C12721k(null);
                C12238m.checkNotNullExpressionValue(c12721k, "Observable.just(null)");
                return c12721k;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Model(Channel channel, Guild guild, long j, Map<Long, String> map, List<? extends ChatListEntry> list, Set<Long> set, long j2, long j3, long j4, long j5, boolean z2) {
            C12238m.checkNotNullParameter(channel, "channel");
            C12238m.checkNotNullParameter(map, "channelNames");
            C12238m.checkNotNullParameter(list, "list");
            C12238m.checkNotNullParameter(set, "myRoleIds");
            this.channel = channel;
            this.guild = guild;
            this.userId = j;
            this.channelNames = map;
            this.list = list;
            this.myRoleIds = set;
            this.channelId = j2;
            this.guildId = j3;
            this.oldestMessageId = j4;
            this.newMessagesMarkerMessageId = j5;
            this.isSpoilerClickAllowed = z2;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        public final long component10() {
            return getNewMessagesMarkerMessageId();
        }

        public final boolean component11() {
            return getIsSpoilerClickAllowed();
        }

        public final Guild component2() {
            return getGuild();
        }

        public final long component3() {
            return getUserId();
        }

        public final Map<Long, String> component4() {
            return getChannelNames();
        }

        public final List<ChatListEntry> component5() {
            return getList();
        }

        public final Set<Long> component6() {
            return getMyRoleIds();
        }

        public final long component7() {
            return getChannelId();
        }

        public final long component8() {
            return getGuildId();
        }

        public final long component9() {
            return getOldestMessageId();
        }

        public final Model copy(Channel channel, Guild guild, long userId, Map<Long, String> channelNames, List<? extends ChatListEntry> list, Set<Long> myRoleIds, long channelId, long guildId, long oldestMessageId, long newMessagesMarkerMessageId, boolean isSpoilerClickAllowed) {
            C12238m.checkNotNullParameter(channel, "channel");
            C12238m.checkNotNullParameter(channelNames, "channelNames");
            C12238m.checkNotNullParameter(list, "list");
            C12238m.checkNotNullParameter(myRoleIds, "myRoleIds");
            return new Model(channel, guild, userId, channelNames, list, myRoleIds, channelId, guildId, oldestMessageId, newMessagesMarkerMessageId, isSpoilerClickAllowed);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return C12238m.areEqual(this.channel, model.channel) && C12238m.areEqual(getGuild(), model.getGuild()) && getUserId() == model.getUserId() && C12238m.areEqual(getChannelNames(), model.getChannelNames()) && C12238m.areEqual(getList(), model.getList()) && C12238m.areEqual(getMyRoleIds(), model.getMyRoleIds()) && getChannelId() == model.getChannelId() && getGuildId() == model.getGuildId() && getOldestMessageId() == model.getOldestMessageId() && getNewMessagesMarkerMessageId() == model.getNewMessagesMarkerMessageId() && getIsSpoilerClickAllowed() == model.getIsSpoilerClickAllowed();
        }

        public final Channel getChannel() {
            return this.channel;
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

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v21, types: [int] */
        /* JADX WARN: Type inference failed for: r0v22 */
        /* JADX WARN: Type inference failed for: r0v26 */
        /* JADX WARN: Type inference failed for: r1v10, types: [int] */
        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            Guild guild = getGuild();
            int iM3a = (C0002b.m3a(getUserId()) + ((iHashCode + (guild != null ? guild.hashCode() : 0)) * 31)) * 31;
            Map<Long, String> channelNames = getChannelNames();
            int iHashCode2 = (iM3a + (channelNames != null ? channelNames.hashCode() : 0)) * 31;
            List<ChatListEntry> list = getList();
            int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
            Set<Long> myRoleIds = getMyRoleIds();
            int iM3a2 = (C0002b.m3a(getNewMessagesMarkerMessageId()) + ((C0002b.m3a(getOldestMessageId()) + ((C0002b.m3a(getGuildId()) + ((C0002b.m3a(getChannelId()) + ((iHashCode3 + (myRoleIds != null ? myRoleIds.hashCode() : 0)) * 31)) * 31)) * 31)) * 31)) * 31;
            boolean isSpoilerClickAllowed = getIsSpoilerClickAllowed();
            ?? r0 = isSpoilerClickAllowed;
            if (isSpoilerClickAllowed) {
                r0 = 1;
            }
            return iM3a2 + r0;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        /* JADX INFO: renamed from: isSpoilerClickAllowed, reason: from getter */
        public boolean getIsSpoilerClickAllowed() {
            return this.isSpoilerClickAllowed;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Model(channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", guild=");
            sbM833U.append(getGuild());
            sbM833U.append(", userId=");
            sbM833U.append(getUserId());
            sbM833U.append(", channelNames=");
            sbM833U.append(getChannelNames());
            sbM833U.append(", list=");
            sbM833U.append(getList());
            sbM833U.append(", myRoleIds=");
            sbM833U.append(getMyRoleIds());
            sbM833U.append(", channelId=");
            sbM833U.append(getChannelId());
            sbM833U.append(", guildId=");
            sbM833U.append(getGuildId());
            sbM833U.append(", oldestMessageId=");
            sbM833U.append(getOldestMessageId());
            sbM833U.append(", newMessagesMarkerMessageId=");
            sbM833U.append(getNewMessagesMarkerMessageId());
            sbM833U.append(", isSpoilerClickAllowed=");
            sbM833U.append(getIsSpoilerClickAllowed());
            sbM833U.append(")");
            return sbM833U.toString();
        }

        public /* synthetic */ Model(Channel channel, Guild guild, long j, Map map, List list, Set set, long j2, long j3, long j4, long j5, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(channel, guild, j, map, list, set, (i & 64) != 0 ? channel.getId() : j2, (i & 128) != 0 ? channel.getGuildId() : j3, (i & 256) != 0 ? 0L : j4, (i & 512) != 0 ? 0L : j5, (i & 1024) != 0 ? false : z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.pins.WidgetChannelPinnedMessages$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetChannelPinnedMessages.kt */
    public static final class C82021 extends AbstractC12240o implements Function1<Model, Unit> {
        public C82021() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetChannelPinnedMessages.this.configureUI(model);
        }
    }

    public WidgetChannelPinnedMessages() {
        super(C5419R.layout.widget_channel_pinned_messages);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChannelPinnedMessages$binding$2.INSTANCE, null, 2, null);
    }

    private final void addThreadSpineItemDecoration(WidgetChatListAdapter adapter) {
        getBinding().f15888b.addItemDecoration(new ThreadSpineItemDecoration(requireContext(), adapter));
    }

    private final void configureUI(Model model) {
        if (model == null) {
            requireActivity().finish();
            return;
        }
        setActionBarSubtitle(ChannelUtils.m7681e(model.getChannel(), requireContext(), false, 2));
        WidgetChatListAdapter widgetChatListAdapter = this.adapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.setData(model);
        }
    }

    private final WidgetChannelPinnedMessagesBinding getBinding() {
        return (WidgetChannelPinnedMessagesBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
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
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(C5419R.string.pinned_messages);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f15888b;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.channelPinnedMessagesRecycler");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        FragmentManager parentFragmentManager2 = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
        WidgetChatListAdapter widgetChatListAdapter = (WidgetChatListAdapter) companion.configure(new WidgetChatListAdapter(recyclerView, this, parentFragmentManager, new ChannelPinnedMessagesAdapterEventHandler(contextRequireContext, parentFragmentManager2, ChannelSelector.INSTANCE.getInstance()), null, null, 48, null));
        addThreadSpineItemDecoration(widgetChatListAdapter);
        this.adapter = widgetChatListAdapter;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<Model> observableM11112r = Model.INSTANCE.get(requireContext(), getMostRecentIntent().getLongExtra(INTENT_EXTRA_CHANNEL_ID, 0L)).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "Model\n        .get(requi…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableM11112r), this, null, 2, null), (Class<?>) WidgetChannelPinnedMessages.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C82021());
        WidgetChatListAdapter widgetChatListAdapter = this.adapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.setHandlers();
        }
    }
}
