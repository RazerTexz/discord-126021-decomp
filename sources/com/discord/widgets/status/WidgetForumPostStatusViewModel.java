package com.discord.widgets.status;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import androidx.media.AudioAttributesCompat;
import b.a.d.d0;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.app.AppFragment;
import com.discord.restapi.RestAPIParams$EmptyBody;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreForumPostMessages;
import com.discord.stores.StoreMessages;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadMessages;
import com.discord.stores.StoreThreadsJoined;
import com.discord.stores.StoreUser;
import com.discord.utilities.analytics.Traits$Location$Section;
import com.discord.utilities.guilds.MemberVerificationUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$UserReactionHandler;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumPostStatusViewModel extends d0<WidgetForumPostStatusViewModel$ViewState> {
    public static final WidgetForumPostStatusViewModel$Companion Companion = new WidgetForumPostStatusViewModel$Companion(null);
    private final AppFragment appFragment;
    private boolean followRequestInProgress;
    private final StoreChannels storeChannels;
    private final StoreChannelsSelected storeChannelsSelected;
    private final StoreEmoji storeEmoji;
    private final StoreForumPostMessages storeForumPostMessages;
    private final StoreMessages storeMessages;
    private final StorePermissions storePermissions;
    private final StoreThreadMessages storeThreadMessages;
    private final StoreThreadsJoined storeThreadsJoined;
    private final StoreUser storeUser;
    private final WidgetChatListAdapterEventsHandler$UserReactionHandler userReactionHandler;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetForumPostStatusViewModel(AppFragment appFragment, StoreUser storeUser, StoreChannels storeChannels, StoreChannelsSelected storeChannelsSelected, StoreThreadsJoined storeThreadsJoined, StoreForumPostMessages storeForumPostMessages, StoreThreadMessages storeThreadMessages, StoreMessages storeMessages, StoreEmoji storeEmoji, StorePermissions storePermissions, WidgetChatListAdapterEventsHandler$UserReactionHandler widgetChatListAdapterEventsHandler$UserReactionHandler, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreUser users = (i & 2) != 0 ? StoreStream.Companion.getUsers() : storeUser;
        StoreChannels channels = (i & 4) != 0 ? StoreStream.Companion.getChannels() : storeChannels;
        StoreChannelsSelected channelsSelected = (i & 8) != 0 ? StoreStream.Companion.getChannelsSelected() : storeChannelsSelected;
        StoreThreadsJoined threadsJoined = (i & 16) != 0 ? StoreStream.Companion.getThreadsJoined() : storeThreadsJoined;
        StoreForumPostMessages forumPostMessages = (i & 32) != 0 ? StoreStream.Companion.getForumPostMessages() : storeForumPostMessages;
        StoreThreadMessages threadMessages = (i & 64) != 0 ? StoreStream.Companion.getThreadMessages() : storeThreadMessages;
        StoreMessages messages = (i & 128) != 0 ? StoreStream.Companion.getMessages() : storeMessages;
        StoreEmoji emojis = (i & 256) != 0 ? StoreStream.Companion.getEmojis() : storeEmoji;
        StorePermissions permissions = (i & 512) != 0 ? StoreStream.Companion.getPermissions() : storePermissions;
        this(appFragment, users, channels, channelsSelected, threadsJoined, forumPostMessages, threadMessages, messages, emojis, permissions, (i & 1024) != 0 ? new WidgetChatListAdapterEventsHandler$UserReactionHandler(appFragment, messages, emojis) : widgetChatListAdapterEventsHandler$UserReactionHandler, (i & 2048) != 0 ? Companion.observeStoreState(users, channels, channelsSelected, threadsJoined, forumPostMessages, threadMessages, permissions, emojis) : observable);
    }

    public static final /* synthetic */ boolean access$getFollowRequestInProgress$p(WidgetForumPostStatusViewModel widgetForumPostStatusViewModel) {
        return widgetForumPostStatusViewModel.followRequestInProgress;
    }

    public static final /* synthetic */ WidgetChatListAdapterEventsHandler$UserReactionHandler access$getUserReactionHandler$p(WidgetForumPostStatusViewModel widgetForumPostStatusViewModel) {
        return widgetForumPostStatusViewModel.userReactionHandler;
    }

    public static final /* synthetic */ void access$setFollowRequestInProgress$p(WidgetForumPostStatusViewModel widgetForumPostStatusViewModel, boolean z2) {
        widgetForumPostStatusViewModel.followRequestInProgress = z2;
    }

    public static final /* synthetic */ void access$toggleFollowPost(WidgetForumPostStatusViewModel widgetForumPostStatusViewModel, Context context, long j, boolean z2) {
        widgetForumPostStatusViewModel.toggleFollowPost(context, j, z2);
    }

    public static final /* synthetic */ void access$updateViewState(WidgetForumPostStatusViewModel widgetForumPostStatusViewModel, WidgetForumPostStatusViewModel$ViewState widgetForumPostStatusViewModel$ViewState) {
        widgetForumPostStatusViewModel.updateViewState(widgetForumPostStatusViewModel$ViewState);
    }

    private final void doPress(Context context, FragmentManager fragmentManager, long guildId, boolean isArchivedThread, Function0<Unit> onFullMembership) {
        MemberVerificationUtils.maybeShowVerificationGate$default(MemberVerificationUtils.INSTANCE, context, fragmentManager, guildId, Traits$Location$Section.EMOJI_PICKER_POPOUT, null, null, new WidgetForumPostStatusViewModel$doPress$1(isArchivedThread, context, onFullMembership), 32, null);
    }

    private final void toggleFollowPost(Context context, long channelId, boolean isFollowedThread) {
        WidgetForumPostStatusViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetForumPostStatusViewModel$ViewState$Valid)) {
            viewState = null;
        }
        WidgetForumPostStatusViewModel$ViewState$Valid widgetForumPostStatusViewModel$ViewState$Valid = (WidgetForumPostStatusViewModel$ViewState$Valid) viewState;
        if (widgetForumPostStatusViewModel$ViewState$Valid == null || this.followRequestInProgress) {
            return;
        }
        this.followRequestInProgress = true;
        updateViewState(WidgetForumPostStatusViewModel$ViewState$Valid.copy$default(widgetForumPostStatusViewModel$ViewState$Valid, 0L, 0L, 0L, false, false, null, null, false, 0, false, true, AudioAttributesCompat.FLAG_ALL, null));
        if (isFollowedThread) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().leaveThread(channelId, "Forum Split View Toolbar"), false, 1, null), this, null, 2, null), WidgetForumPostStatusViewModel.class, context, (Function1) null, (Function1) null, (Function0) null, new WidgetForumPostStatusViewModel$toggleFollowPost$1(this, widgetForumPostStatusViewModel$ViewState$Valid), WidgetForumPostStatusViewModel$toggleFollowPost$2.INSTANCE, 28, (Object) null);
        } else {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().joinThread(channelId, "Forum Split View Toolbar", new RestAPIParams$EmptyBody()), false, 1, null), this, null, 2, null), WidgetForumPostStatusViewModel.class, context, (Function1) null, (Function1) null, (Function0) null, new WidgetForumPostStatusViewModel$toggleFollowPost$3(this, widgetForumPostStatusViewModel$ViewState$Valid), WidgetForumPostStatusViewModel$toggleFollowPost$4.INSTANCE, 28, (Object) null);
        }
    }

    public final void handleStoreState(WidgetForumPostStatusViewModel$StoreState storeState) {
        m.checkNotNullParameter(storeState, "storeState");
        if (!(storeState instanceof WidgetForumPostStatusViewModel$StoreState$Loaded)) {
            updateViewState(WidgetForumPostStatusViewModel$ViewState$Invalid.INSTANCE);
            return;
        }
        WidgetForumPostStatusViewModel$StoreState$Loaded widgetForumPostStatusViewModel$StoreState$Loaded = (WidgetForumPostStatusViewModel$StoreState$Loaded) storeState;
        long myUserId = widgetForumPostStatusViewModel$StoreState$Loaded.getMyUserId();
        long channelId = widgetForumPostStatusViewModel$StoreState$Loaded.getChannelId();
        long guildId = widgetForumPostStatusViewModel$StoreState$Loaded.getGuildId();
        boolean zIsFollowedThread = widgetForumPostStatusViewModel$StoreState$Loaded.isFollowedThread();
        boolean zIsArchivedThread = widgetForumPostStatusViewModel$StoreState$Loaded.isArchivedThread();
        Long messageId = widgetForumPostStatusViewModel$StoreState$Loaded.getMessageId();
        MessageReaction mostCommonReaction = widgetForumPostStatusViewModel$StoreState$Loaded.getMostCommonReaction();
        boolean zIsDefaultReaction = widgetForumPostStatusViewModel$StoreState$Loaded.isDefaultReaction();
        Integer messageCount = widgetForumPostStatusViewModel$StoreState$Loaded.getMessageCount();
        int iIntValue = messageCount != null ? messageCount.intValue() : 0;
        boolean hasAddReactionPermission = widgetForumPostStatusViewModel$StoreState$Loaded.getHasAddReactionPermission();
        WidgetForumPostStatusViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetForumPostStatusViewModel$ViewState$Valid)) {
            viewState = null;
        }
        WidgetForumPostStatusViewModel$ViewState$Valid widgetForumPostStatusViewModel$ViewState$Valid = (WidgetForumPostStatusViewModel$ViewState$Valid) viewState;
        updateViewState(new WidgetForumPostStatusViewModel$ViewState$Valid(myUserId, channelId, guildId, zIsFollowedThread, zIsArchivedThread, messageId, mostCommonReaction, zIsDefaultReaction, iIntValue, hasAddReactionPermission, widgetForumPostStatusViewModel$ViewState$Valid != null ? widgetForumPostStatusViewModel$ViewState$Valid.getFollowRequestInProgress() : false));
    }

    public final void onFollowPress(Context context, FragmentManager fragmentManager, long guildId, long channelId, boolean isArchivedThread, boolean isFollowedThread) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        doPress(context, fragmentManager, guildId, isArchivedThread, new WidgetForumPostStatusViewModel$onFollowPress$1(this, context, channelId, isFollowedThread));
    }

    public final void onReactionLongPress(Context context, FragmentManager fragmentManager, long messageId, long guildId, long channelId, boolean isArchivedThread, MessageReaction reaction) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(reaction, "reaction");
        doPress(context, fragmentManager, guildId, isArchivedThread, new WidgetForumPostStatusViewModel$onReactionLongPress$1(channelId, messageId, context, reaction));
    }

    public final void onReactionPress(Context context, FragmentManager fragmentManager, long myUserId, long messageId, long guildId, long channelId, boolean isArchivedThread, MessageReaction reaction, boolean hasAddReactionPermission) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(reaction, "reaction");
        doPress(context, fragmentManager, guildId, isArchivedThread, new WidgetForumPostStatusViewModel$onReactionPress$1(this, hasAddReactionPermission, myUserId, channelId, messageId, reaction));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumPostStatusViewModel(AppFragment appFragment, StoreUser storeUser, StoreChannels storeChannels, StoreChannelsSelected storeChannelsSelected, StoreThreadsJoined storeThreadsJoined, StoreForumPostMessages storeForumPostMessages, StoreThreadMessages storeThreadMessages, StoreMessages storeMessages, StoreEmoji storeEmoji, StorePermissions storePermissions, WidgetChatListAdapterEventsHandler$UserReactionHandler widgetChatListAdapterEventsHandler$UserReactionHandler, Observable<WidgetForumPostStatusViewModel$StoreState> observable) {
        super(null, 1, null);
        m.checkNotNullParameter(appFragment, "appFragment");
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        m.checkNotNullParameter(storeThreadsJoined, "storeThreadsJoined");
        m.checkNotNullParameter(storeForumPostMessages, "storeForumPostMessages");
        m.checkNotNullParameter(storeThreadMessages, "storeThreadMessages");
        m.checkNotNullParameter(storeMessages, "storeMessages");
        m.checkNotNullParameter(storeEmoji, "storeEmoji");
        m.checkNotNullParameter(storePermissions, "storePermissions");
        m.checkNotNullParameter(widgetChatListAdapterEventsHandler$UserReactionHandler, "userReactionHandler");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.appFragment = appFragment;
        this.storeUser = storeUser;
        this.storeChannels = storeChannels;
        this.storeChannelsSelected = storeChannelsSelected;
        this.storeThreadsJoined = storeThreadsJoined;
        this.storeForumPostMessages = storeForumPostMessages;
        this.storeThreadMessages = storeThreadMessages;
        this.storeMessages = storeMessages;
        this.storeEmoji = storeEmoji;
        this.storePermissions = storePermissions;
        this.userReactionHandler = widgetChatListAdapterEventsHandler$UserReactionHandler;
        Observable observableR = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null).r();
        m.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, WidgetForumPostStatusViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetForumPostStatusViewModel$1(this), 62, (Object) null);
    }
}
