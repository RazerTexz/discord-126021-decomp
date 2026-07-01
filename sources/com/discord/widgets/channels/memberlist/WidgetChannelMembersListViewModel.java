package com.discord.widgets.channels.memberlist;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.user.User;
import com.discord.restapi.RestAPIParams$EmptyBody;
import com.discord.stores.StoreEmojiCustom;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreNavigation$PanelAction;
import com.discord.stores.StoreStream;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelMembersListViewModel extends d0<WidgetChannelMembersListViewModel$ViewState> {
    public static final WidgetChannelMembersListViewModel$Companion Companion = new WidgetChannelMembersListViewModel$Companion(null);
    private final PublishSubject<WidgetChannelMembersListViewModel$Event> eventSubject;
    private final WidgetChannelMembersListViewModel$GuildChannelSubscriber guildChannelSubscriber;
    private final StoreEmojiCustom storeCustomEmojis;
    private final StoreGuilds storeGuilds;

    public WidgetChannelMembersListViewModel() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetChannelMembersListViewModel(WidgetChannelMembersListViewModel$GuildChannelSubscriber widgetChannelMembersListViewModel$GuildChannelSubscriber, StoreGuilds storeGuilds, StoreEmojiCustom storeEmojiCustom, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableObserveStoreState$default;
        StoreEmojiCustom storeEmojiCustom2;
        WidgetChannelMembersListViewModel$GuildChannelSubscriber widgetChannelMembersListViewModel$1 = (i & 1) != 0 ? new WidgetChannelMembersListViewModel$1() : widgetChannelMembersListViewModel$GuildChannelSubscriber;
        StoreGuilds guilds = (i & 2) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds;
        StoreEmojiCustom customEmojis = (i & 4) != 0 ? StoreStream.Companion.getCustomEmojis() : storeEmojiCustom;
        if ((i & 8) != 0) {
            observableObserveStoreState$default = WidgetChannelMembersListViewModel$Companion.observeStoreState$default(Companion, guilds, null, null, null, null, null, null, null, null, null, null, null, null, 8190, null);
            storeEmojiCustom2 = customEmojis;
        } else {
            observableObserveStoreState$default = observable;
            storeEmojiCustom2 = customEmojis;
        }
        this(widgetChannelMembersListViewModel$1, guilds, storeEmojiCustom2, observableObserveStoreState$default);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(WidgetChannelMembersListViewModel widgetChannelMembersListViewModel) {
        return widgetChannelMembersListViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetChannelMembersListViewModel widgetChannelMembersListViewModel, WidgetChannelMembersListViewModel$StoreState widgetChannelMembersListViewModel$StoreState) {
        widgetChannelMembersListViewModel.handleStoreState(widgetChannelMembersListViewModel$StoreState);
    }

    @MainThread
    private final void handleStoreState(WidgetChannelMembersListViewModel$StoreState storeState) {
        WidgetChannelMembersListViewModel$MemberList widgetChannelMembersListViewModel$MemberListGenerateThreadMemberListItems;
        if (storeState instanceof WidgetChannelMembersListViewModel$StoreState$None) {
            updateViewState(WidgetChannelMembersListViewModel$ViewState$Empty.INSTANCE);
            return;
        }
        boolean z2 = false;
        if (storeState instanceof WidgetChannelMembersListViewModel$StoreState$Guild) {
            WidgetChannelMembersListViewModel$StoreState$Guild widgetChannelMembersListViewModel$StoreState$Guild = (WidgetChannelMembersListViewModel$StoreState$Guild) storeState;
            widgetChannelMembersListViewModel$MemberListGenerateThreadMemberListItems = GuildMemberListItemGeneratorKt.generateGuildMemberListItems(widgetChannelMembersListViewModel$StoreState$Guild.getChannelMembers(), widgetChannelMembersListViewModel$StoreState$Guild.getGuild(), widgetChannelMembersListViewModel$StoreState$Guild.getChannel(), widgetChannelMembersListViewModel$StoreState$Guild.getGuildRoles(), PermissionUtils.can(1L, widgetChannelMembersListViewModel$StoreState$Guild.getChannelPermissions()), false, this.storeGuilds, this.storeCustomEmojis);
        } else if (storeState instanceof WidgetChannelMembersListViewModel$StoreState$Private) {
            WidgetChannelMembersListViewModel$StoreState$Private widgetChannelMembersListViewModel$StoreState$Private = (WidgetChannelMembersListViewModel$StoreState$Private) storeState;
            Map<Long, Integer> relationships = widgetChannelMembersListViewModel$StoreState$Private.getRelationships();
            User userA = ChannelUtils.a(widgetChannelMembersListViewModel$StoreState$Private.getChannel());
            widgetChannelMembersListViewModel$MemberListGenerateThreadMemberListItems = PrivateChannelMemberListItemGeneratorKt.generateGroupDmMemberListItems(widgetChannelMembersListViewModel$StoreState$Private.getChannel(), widgetChannelMembersListViewModel$StoreState$Private.getUsers(), widgetChannelMembersListViewModel$StoreState$Private.getPresences(), widgetChannelMembersListViewModel$StoreState$Private.getApplicationStreams(), ChannelUtils.p(widgetChannelMembersListViewModel$StoreState$Private.getChannel()) || ModelUserRelationship.isType(relationships.get(userA != null ? Long.valueOf(userA.getId()) : null), 1));
        } else {
            if (!(storeState instanceof WidgetChannelMembersListViewModel$StoreState$Thread)) {
                throw new NoWhenBranchMatchedException();
            }
            WidgetChannelMembersListViewModel$StoreState$Thread widgetChannelMembersListViewModel$StoreState$Thread = (WidgetChannelMembersListViewModel$StoreState$Thread) storeState;
            widgetChannelMembersListViewModel$MemberListGenerateThreadMemberListItems = ThreadMemberListItemGeneratorKt.generateThreadMemberListItems(widgetChannelMembersListViewModel$StoreState$Thread.getChannel(), widgetChannelMembersListViewModel$StoreState$Thread.getRoles(), widgetChannelMembersListViewModel$StoreState$Thread.getGuild(), widgetChannelMembersListViewModel$StoreState$Thread.getGuildMembers(), widgetChannelMembersListViewModel$StoreState$Thread.getUsers(), widgetChannelMembersListViewModel$StoreState$Thread.getPresences(), widgetChannelMembersListViewModel$StoreState$Thread.getStreams(), widgetChannelMembersListViewModel$StoreState$Thread.getThreadMembers(), widgetChannelMembersListViewModel$StoreState$Thread.getJoinedThread(), this.storeGuilds, this.storeCustomEmojis);
        }
        WidgetChannelMembersListViewModel$ViewState viewState = getViewState();
        boolean isPanelOpen = storeState.getIsPanelOpen();
        Channel channel = storeState.getChannel();
        if ((storeState instanceof WidgetChannelMembersListViewModel$StoreState$Thread) && ((WidgetChannelMembersListViewModel$StoreState$Thread) storeState).getJoinedThread() != null) {
            z2 = true;
        }
        WidgetChannelMembersListViewModel$ViewState$Loaded widgetChannelMembersListViewModel$ViewState$Loaded = new WidgetChannelMembersListViewModel$ViewState$Loaded(widgetChannelMembersListViewModel$MemberListGenerateThreadMemberListItems, isPanelOpen, channel, z2);
        updateViewState(widgetChannelMembersListViewModel$ViewState$Loaded);
        updateSubscriptions(viewState, widgetChannelMembersListViewModel$ViewState$Loaded, storeState);
    }

    public final Observable<WidgetChannelMembersListViewModel$Event> observeEvents() {
        PublishSubject<WidgetChannelMembersListViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onThreadJoinLeaveClicked(long channelId, boolean isThreadJoined) {
        if (isThreadJoined) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().leaveThread(channelId, "Thread Member List"), false, 1, null), this, null, 2, null), WidgetChannelMembersListViewModel.class, (Context) null, (Function1) null, new WidgetChannelMembersListViewModel$onThreadJoinLeaveClicked$1(this), (Function0) null, (Function0) null, WidgetChannelMembersListViewModel$onThreadJoinLeaveClicked$2.INSTANCE, 54, (Object) null);
            StoreNavigation.setNavigationPanelAction$default(StoreStream.Companion.getNavigation(), StoreNavigation$PanelAction.CLOSE, null, 2, null);
        } else {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().joinThread(channelId, "Thread Member List", new RestAPIParams$EmptyBody()), false, 1, null), WidgetChannelMembersListViewModel.class, (Context) null, (Function1) null, new WidgetChannelMembersListViewModel$onThreadJoinLeaveClicked$3(this), (Function0) null, (Function0) null, WidgetChannelMembersListViewModel$onThreadJoinLeaveClicked$4.INSTANCE, 54, (Object) null);
            StoreNavigation.setNavigationPanelAction$default(StoreStream.Companion.getNavigation(), StoreNavigation$PanelAction.CLOSE, null, 2, null);
        }
    }

    public final void updateSubscriptions(WidgetChannelMembersListViewModel$ViewState prevViewState, WidgetChannelMembersListViewModel$ViewState$Loaded newViewState, WidgetChannelMembersListViewModel$StoreState storeState) {
        m.checkNotNullParameter(newViewState, "newViewState");
        m.checkNotNullParameter(storeState, "storeState");
        boolean z2 = (m.areEqual(prevViewState != null ? prevViewState.getListId() : null, newViewState.getListId()) ^ true) && storeState.getIsPanelOpen();
        Channel channel = newViewState.getChannel();
        if (channel != null && ChannelUtils.H(channel)) {
            if (z2) {
                this.eventSubject.k.onNext(WidgetChannelMembersListViewModel$Event$ScrollToTop.INSTANCE);
                updateSubscriptionsForThread(newViewState.getChannel());
                return;
            } else {
                if ((prevViewState instanceof WidgetChannelMembersListViewModel$ViewState$Loaded) && !((WidgetChannelMembersListViewModel$ViewState$Loaded) prevViewState).isOpen() && newViewState.isOpen()) {
                    updateSubscriptionsForThread(newViewState.getChannel());
                    return;
                }
                return;
            }
        }
        if (z2) {
            this.eventSubject.k.onNext(WidgetChannelMembersListViewModel$Event$ScrollToTop.INSTANCE);
            updateSubscriptionsForChannel(new IntRange(0, 99));
        } else if ((prevViewState instanceof WidgetChannelMembersListViewModel$ViewState$Loaded) && !((WidgetChannelMembersListViewModel$ViewState$Loaded) prevViewState).isOpen() && newViewState.isOpen()) {
            this.eventSubject.k.onNext(WidgetChannelMembersListViewModel$Event$UpdateRanges.INSTANCE);
        }
    }

    @MainThread
    public final void updateSubscriptionsForChannel(IntRange range) {
        m.checkNotNullParameter(range, "range");
        WidgetChannelMembersListViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetChannelMembersListViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetChannelMembersListViewModel$ViewState$Loaded widgetChannelMembersListViewModel$ViewState$Loaded = (WidgetChannelMembersListViewModel$ViewState$Loaded) viewState;
        if (widgetChannelMembersListViewModel$ViewState$Loaded == null || widgetChannelMembersListViewModel$ViewState$Loaded.getChannel() == null || !widgetChannelMembersListViewModel$ViewState$Loaded.isOpen()) {
            return;
        }
        this.guildChannelSubscriber.subscribeToChannelRange(widgetChannelMembersListViewModel$ViewState$Loaded.getChannel(), range);
    }

    public final void updateSubscriptionsForThread(Channel channel) {
        if (channel == null || ChannelUtils.j(channel)) {
            return;
        }
        m.checkNotNullParameter(channel, "$this$isAnnouncementThread");
        if (channel.getType() == 10) {
            return;
        }
        this.guildChannelSubscriber.subscribeToThread(channel);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelMembersListViewModel(WidgetChannelMembersListViewModel$GuildChannelSubscriber widgetChannelMembersListViewModel$GuildChannelSubscriber, StoreGuilds storeGuilds, StoreEmojiCustom storeEmojiCustom, Observable<WidgetChannelMembersListViewModel$StoreState> observable) {
        super(WidgetChannelMembersListViewModel$ViewState$Empty.INSTANCE);
        m.checkNotNullParameter(widgetChannelMembersListViewModel$GuildChannelSubscriber, "guildChannelSubscriber");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storeEmojiCustom, "storeCustomEmojis");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.guildChannelSubscriber = widgetChannelMembersListViewModel$GuildChannelSubscriber;
        this.storeGuilds = storeGuilds;
        this.storeCustomEmojis = storeEmojiCustom;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), WidgetChannelMembersListViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChannelMembersListViewModel$2(this), 62, (Object) null);
    }
}
