package com.discord.widgets.guilds.profile;

import android.content.Context;
import androidx.fragment.app.Fragment;
import b.a.d.d0;
import com.discord.api.emoji.GuildEmoji;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guild.preview.GuildPreview;
import com.discord.app.AppActivity;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams$Nick;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreGuildProfiles$FetchStates;
import com.discord.stores.StoreGuildProfiles$GuildProfileData;
import com.discord.stores.StoreLurking;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.utilities.guilds.GuildUtilsKt;
import com.discord.utilities.permissions.ManageGuildContext;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import d0.t.n;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetGuildProfileSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildProfileSheetViewModel extends d0<WidgetGuildProfileSheetViewModel$ViewState> {
    public static final WidgetGuildProfileSheetViewModel$Companion Companion = new WidgetGuildProfileSheetViewModel$Companion(null);
    private final PublishSubject<WidgetGuildProfileSheetViewModel$Event> eventSubject;
    private final long guildId;
    private boolean isEmojiSectionExpanded;
    private final RestAPI restAPI;
    private final StoreLurking storeLurking;
    private final StoreUserGuildSettings storeUserGuildSettings;
    private final StoreUserSettings storeUserSettings;
    private final boolean viewingGuild;

    public /* synthetic */ WidgetGuildProfileSheetViewModel(StoreUserSettings storeUserSettings, StoreUserGuildSettings storeUserGuildSettings, boolean z2, RestAPI restAPI, StoreLurking storeLurking, StoreAnalytics storeAnalytics, long j, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.Companion.getUserSettings() : storeUserSettings, (i & 2) != 0 ? StoreStream.Companion.getUserGuildSettings() : storeUserGuildSettings, z2, (i & 8) != 0 ? RestAPI.Companion.getApi() : restAPI, (i & 16) != 0 ? StoreStream.Companion.getLurking() : storeLurking, (i & 32) != 0 ? StoreStream.Companion.getAnalytics() : storeAnalytics, j, (i & 128) != 0 ? Companion.observeStores(j) : observable);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(WidgetGuildProfileSheetViewModel widgetGuildProfileSheetViewModel) {
        return widgetGuildProfileSheetViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetGuildProfileSheetViewModel widgetGuildProfileSheetViewModel, WidgetGuildProfileSheetViewModel$StoreState widgetGuildProfileSheetViewModel$StoreState) {
        widgetGuildProfileSheetViewModel.handleStoreState(widgetGuildProfileSheetViewModel$StoreState);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0044  */
    /* JADX WARN: Code duplicated, block: B:13:0x0057  */
    /* JADX WARN: Code duplicated, block: B:16:0x005b  */
    /* JADX WARN: Code duplicated, block: B:18:0x006b  */
    /* JADX WARN: Code duplicated, block: B:19:0x0072  */
    /* JADX WARN: Code duplicated, block: B:22:0x0096  */
    /* JADX WARN: Code duplicated, block: B:23:0x009d  */
    /* JADX WARN: Code duplicated, block: B:25:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:27:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:34:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:35:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:41:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:44:0x0112  */
    /* JADX WARN: Code duplicated, block: B:45:0x0119  */
    /* JADX WARN: Code duplicated, block: B:47:0x011d  */
    /* JADX WARN: Code duplicated, block: B:51:0x0132  */
    private final void handleLoadedGuild(Guild guild, GuildPreview guildPreview, GuildChannelsInfo guildChannelsInfo, MeUser me2, GuildMember computedMe, List<Long> restrictedGuildIds, boolean isDeveloper, List<? extends Emoji> emojis, boolean isLurking, boolean isUnread) {
        Integer num;
        int i;
        ManageGuildContext manageGuildContext;
        WidgetGuildProfileSheetViewModel$TabItems widgetGuildProfileSheetViewModel$TabItems;
        WidgetGuildProfileSheetViewModel$Actions widgetGuildProfileSheetViewModel$Actions;
        List<? extends Emoji> listEmptyList;
        boolean z2;
        Integer approximatePresenceCount;
        List<GuildEmoji> listD;
        String nick;
        String avatarHash;
        if (!guild.getFeatures().contains(GuildFeature.VERIFIED)) {
            if (guild.getFeatures().contains(GuildFeature.PARTNERED)) {
                i = 2131231995;
            } else {
                num = null;
            }
            WidgetGuildProfileSheetViewModel$Banner widgetGuildProfileSheetViewModel$Banner = new WidgetGuildProfileSheetViewModel$Banner(guild.getId(), guild.getBanner(), WidgetGuildProfileSheetViewModel$Banner$Type.BANNER);
            manageGuildContext = guildChannelsInfo.getManageGuildContext();
            if (isLurking) {
                widgetGuildProfileSheetViewModel$TabItems = null;
            } else {
                widgetGuildProfileSheetViewModel$TabItems = new WidgetGuildProfileSheetViewModel$TabItems(manageGuildContext.canManage(), guildChannelsInfo.getAbleToInstantInvite(), guild.getPremiumSubscriptionCount());
            }
            if (isLurking) {
                widgetGuildProfileSheetViewModel$Actions = null;
            } else {
                boolean canManageChannels = manageGuildContext.getCanManageChannels();
                boolean canManageEvents = manageGuildContext.getCanManageEvents();
                boolean canChangeNickname = guildChannelsInfo.getCanChangeNickname();
                if (computedMe != null) {
                    nick = computedMe.getNick();
                } else {
                    nick = null;
                }
                boolean z3 = !restrictedGuildIds.contains(Long.valueOf(guild.getId()));
                boolean hideMutedChannels = guildChannelsInfo.getHideMutedChannels();
                boolean z4 = !guild.isOwner(me2.getId());
                if (computedMe != null) {
                    avatarHash = computedMe.getAvatarHash();
                } else {
                    avatarHash = null;
                }
                widgetGuildProfileSheetViewModel$Actions = new WidgetGuildProfileSheetViewModel$Actions(isUnread, canManageChannels, canManageEvents, canChangeNickname, nick, avatarHash, z3, hideMutedChannels, z4, isDeveloper, me2.getUsername());
            }
            if (isLurking) {
                listEmptyList = emojis;
            } else if (guildPreview != null || (listD = guildPreview.d()) == null) {
                listEmptyList = null;
            } else {
                listEmptyList = new ArrayList<>(o.collectionSizeOrDefault(listD, 10));
                Iterator<T> it = listD.iterator();
                while (it.hasNext()) {
                    listEmptyList.add(new ModelEmojiCustom((GuildEmoji) it.next(), guildPreview.getId()));
                }
            }
            if (isLurking && manageGuildContext.getCanManageEmojisAndStickers()) {
                z2 = true;
            } else {
                z2 = false;
            }
            WidgetGuildProfileSheetViewModel$BottomActions widgetGuildProfileSheetViewModel$BottomActions = new WidgetGuildProfileSheetViewModel$BottomActions(z2, isLurking, true ^ this.viewingGuild);
            long id2 = guild.getId();
            String name = guild.getName();
            String shortName = guild.getShortName();
            String icon = guild.getIcon();
            String description = guild.getDescription();
            if (guildPreview != null) {
                approximatePresenceCount = guildPreview.getApproximatePresenceCount();
            } else {
                approximatePresenceCount = null;
            }
            Integer approximateMemberCount = guildPreview != null ? guildPreview.getApproximateMemberCount() : null;
            WidgetGuildProfileSheetViewModel$TabItems widgetGuildProfileSheetViewModel$TabItems2 = widgetGuildProfileSheetViewModel$TabItems;
            boolean zIsPremium = UserUtils.INSTANCE.isPremium(me2);
            boolean z5 = this.isEmojiSectionExpanded;
            if (listEmptyList == null) {
                listEmptyList = n.emptyList();
            }
            updateViewState(new WidgetGuildProfileSheetViewModel$ViewState$Loaded(id2, name, shortName, icon, description, num, widgetGuildProfileSheetViewModel$Banner, approximatePresenceCount, approximateMemberCount, widgetGuildProfileSheetViewModel$TabItems2, widgetGuildProfileSheetViewModel$Actions, new WidgetGuildProfileSheetViewModel$EmojisData(zIsPremium, z5, listEmptyList), widgetGuildProfileSheetViewModel$BottomActions, guild.isHub(), me2));
        }
        i = 2131232241;
        num = i;
        WidgetGuildProfileSheetViewModel$Banner widgetGuildProfileSheetViewModel$Banner2 = new WidgetGuildProfileSheetViewModel$Banner(guild.getId(), guild.getBanner(), WidgetGuildProfileSheetViewModel$Banner$Type.BANNER);
        manageGuildContext = guildChannelsInfo.getManageGuildContext();
        if (isLurking) {
            widgetGuildProfileSheetViewModel$TabItems = new WidgetGuildProfileSheetViewModel$TabItems(manageGuildContext.canManage(), guildChannelsInfo.getAbleToInstantInvite(), guild.getPremiumSubscriptionCount());
        } else {
            widgetGuildProfileSheetViewModel$TabItems = null;
        }
        if (isLurking) {
            boolean canManageChannels2 = manageGuildContext.getCanManageChannels();
            boolean canManageEvents2 = manageGuildContext.getCanManageEvents();
            boolean canChangeNickname2 = guildChannelsInfo.getCanChangeNickname();
            if (computedMe != null) {
                nick = computedMe.getNick();
            } else {
                nick = null;
            }
            boolean z6 = !restrictedGuildIds.contains(Long.valueOf(guild.getId()));
            boolean hideMutedChannels2 = guildChannelsInfo.getHideMutedChannels();
            boolean z7 = !guild.isOwner(me2.getId());
            if (computedMe != null) {
                avatarHash = computedMe.getAvatarHash();
            } else {
                avatarHash = null;
            }
            widgetGuildProfileSheetViewModel$Actions = new WidgetGuildProfileSheetViewModel$Actions(isUnread, canManageChannels2, canManageEvents2, canChangeNickname2, nick, avatarHash, z6, hideMutedChannels2, z7, isDeveloper, me2.getUsername());
        } else {
            widgetGuildProfileSheetViewModel$Actions = null;
        }
        if (isLurking) {
            listEmptyList = emojis;
        } else if (guildPreview != null) {
            listEmptyList = null;
        } else {
            listEmptyList = null;
        }
        if (isLurking) {
            z2 = false;
        } else {
            z2 = false;
        }
        WidgetGuildProfileSheetViewModel$BottomActions widgetGuildProfileSheetViewModel$BottomActions2 = new WidgetGuildProfileSheetViewModel$BottomActions(z2, isLurking, true ^ this.viewingGuild);
        long id3 = guild.getId();
        String name2 = guild.getName();
        String shortName2 = guild.getShortName();
        String icon2 = guild.getIcon();
        String description2 = guild.getDescription();
        if (guildPreview != null) {
            approximatePresenceCount = guildPreview.getApproximatePresenceCount();
        } else {
            approximatePresenceCount = null;
        }
        if (guildPreview != null) {
        }
        WidgetGuildProfileSheetViewModel$TabItems widgetGuildProfileSheetViewModel$TabItems3 = widgetGuildProfileSheetViewModel$TabItems;
        boolean zIsPremium2 = UserUtils.INSTANCE.isPremium(me2);
        boolean z8 = this.isEmojiSectionExpanded;
        if (listEmptyList == null) {
            listEmptyList = n.emptyList();
        }
        updateViewState(new WidgetGuildProfileSheetViewModel$ViewState$Loaded(id3, name2, shortName2, icon2, description2, num, widgetGuildProfileSheetViewModel$Banner2, approximatePresenceCount, approximateMemberCount, widgetGuildProfileSheetViewModel$TabItems3, widgetGuildProfileSheetViewModel$Actions, new WidgetGuildProfileSheetViewModel$EmojisData(zIsPremium2, z8, listEmptyList), widgetGuildProfileSheetViewModel$BottomActions2, guild.isHub(), me2));
    }

    private final void handleLoadedGuildPreview(GuildPreview guildPreview, MeUser meUser) {
        Integer num;
        if (guildPreview.f().contains(GuildFeature.VERIFIED)) {
            num = 2131232241;
        } else {
            num = guildPreview.f().contains(GuildFeature.PARTNERED) ? 2131231995 : null;
        }
        Integer num2 = num;
        WidgetGuildProfileSheetViewModel$Banner widgetGuildProfileSheetViewModel$Banner = new WidgetGuildProfileSheetViewModel$Banner(guildPreview.getId(), guildPreview.getSplash(), WidgetGuildProfileSheetViewModel$Banner$Type.SPLASH);
        WidgetGuildProfileSheetViewModel$BottomActions widgetGuildProfileSheetViewModel$BottomActions = new WidgetGuildProfileSheetViewModel$BottomActions(false, true, !this.viewingGuild);
        long id2 = guildPreview.getId();
        String name = guildPreview.getName();
        String strComputeShortName = GuildUtilsKt.computeShortName(guildPreview.getName());
        String icon = guildPreview.getIcon();
        String description = guildPreview.getDescription();
        Integer approximatePresenceCount = guildPreview.getApproximatePresenceCount();
        Integer approximateMemberCount = guildPreview.getApproximateMemberCount();
        boolean zIsPremium = UserUtils.INSTANCE.isPremium(meUser);
        boolean z2 = this.isEmojiSectionExpanded;
        List<GuildEmoji> listD = guildPreview.d();
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(listD, 10));
        Iterator it = listD.iterator();
        while (it.hasNext()) {
            arrayList.add(new ModelEmojiCustom((GuildEmoji) it.next(), guildPreview.getId()));
            it = it;
            approximatePresenceCount = approximatePresenceCount;
            approximateMemberCount = approximateMemberCount;
        }
        updateViewState(new WidgetGuildProfileSheetViewModel$ViewState$Loaded(id2, name, strComputeShortName, icon, description, num2, widgetGuildProfileSheetViewModel$Banner, approximatePresenceCount, approximateMemberCount, null, null, new WidgetGuildProfileSheetViewModel$EmojisData(zIsPremium, z2, arrayList), widgetGuildProfileSheetViewModel$BottomActions, guildPreview.f().contains(GuildFeature.HUB), meUser));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void handleStoreState(WidgetGuildProfileSheetViewModel$StoreState storeState) {
        Guild guild = storeState.getGuild();
        StoreGuildProfiles$GuildProfileData guildProfile = storeState.getGuildProfile();
        GuildChannelsInfo guildChannelsInfo = storeState.getGuildChannelsInfo();
        MeUser me2 = storeState.getMe();
        GuildMember computedMe = storeState.getComputedMe();
        List<Long> listComponent6 = storeState.component6();
        boolean isDeveloper = storeState.getIsDeveloper();
        List<? extends Emoji> listComponent8 = storeState.component8();
        boolean isLurking = storeState.getIsLurking();
        boolean isUnread = storeState.getIsUnread();
        if (guild != null) {
            handleLoadedGuild(guild, guildProfile != null ? guildProfile.getData() : null, guildChannelsInfo, me2, computedMe, listComponent6, isDeveloper, listComponent8, isLurking, isUnread);
            return;
        }
        Object fetchState = guildProfile != null ? guildProfile.getFetchState() : null;
        Object obj = StoreGuildProfiles$FetchStates.SUCCEEDED;
        if (fetchState == obj && guildProfile.getData() != null) {
            handleLoadedGuildPreview(guildProfile.getData(), me2);
            return;
        }
        if ((guildProfile != null ? guildProfile.getFetchState() : null) != StoreGuildProfiles$FetchStates.FAILED) {
            if ((guildProfile != null ? guildProfile.getFetchState() : null) != obj || guildProfile.getData() != null) {
                updateViewState(WidgetGuildProfileSheetViewModel$ViewState$Loading.INSTANCE);
                return;
            }
        }
        updateViewState(WidgetGuildProfileSheetViewModel$ViewState$Invalid.INSTANCE);
    }

    public final Observable<WidgetGuildProfileSheetViewModel$Event> observeEvents() {
        PublishSubject<WidgetGuildProfileSheetViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onClickEmoji() {
        WidgetGuildProfileSheetViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetGuildProfileSheetViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetGuildProfileSheetViewModel$ViewState$Loaded widgetGuildProfileSheetViewModel$ViewState$Loaded = (WidgetGuildProfileSheetViewModel$ViewState$Loaded) viewState;
        if (widgetGuildProfileSheetViewModel$ViewState$Loaded == null || this.isEmojiSectionExpanded) {
            return;
        }
        this.isEmojiSectionExpanded = true;
        updateViewState(WidgetGuildProfileSheetViewModel$ViewState$Loaded.copy$default(widgetGuildProfileSheetViewModel$ViewState$Loaded, 0L, null, null, null, null, null, null, null, null, null, null, WidgetGuildProfileSheetViewModel$EmojisData.copy$default(widgetGuildProfileSheetViewModel$ViewState$Loaded.getEmojisData(), false, this.isEmojiSectionExpanded, null, 5, null), null, false, null, 30719, null));
    }

    public final void onClickJoinServer(long guildId, Fragment fragment) {
        m.checkNotNullParameter(fragment, "fragment");
        Context context = fragment.getContext();
        if (context != null) {
            StoreLurking storeLurking = this.storeLurking;
            m.checkNotNullExpressionValue(context, "it");
            storeLurking.postJoinGuildAsMember(guildId, context);
        }
    }

    public final void onClickLeaveServer(long guildId, Function0<Unit> onSuccess) {
        m.checkNotNullParameter(onSuccess, "onSuccess");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.leaveGuild(guildId), false, 1, null), this, null, 2, null), WidgetGuildProfileSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildProfileSheetViewModel$onClickLeaveServer$1(onSuccess), 62, (Object) null);
    }

    public final void onClickMarkAsRead(long guildId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.ackGuild(guildId), false, 1, null), this, null, 2, null), WidgetGuildProfileSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildProfileSheetViewModel$onClickMarkAsRead$1(this), 62, (Object) null);
    }

    public final void onClickResetNickname(long guildId, Function0<Unit> onSuccess) {
        m.checkNotNullParameter(onSuccess, "onSuccess");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.changeGuildNickname(guildId, new RestAPIParams$Nick("")), false, 1, null), this, null, 2, null), WidgetGuildProfileSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildProfileSheetViewModel$onClickResetNickname$1(onSuccess), 62, (Object) null);
    }

    public final void onClickSaveNickname(long guildId, String nick, Function0<Unit> onSuccess) {
        m.checkNotNullParameter(nick, ModelAuditLogEntry.CHANGE_KEY_NICK);
        m.checkNotNullParameter(onSuccess, "onSuccess");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.changeGuildNickname(guildId, new RestAPIParams$Nick(nick)), false, 1, null), this, null, 2, null), WidgetGuildProfileSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildProfileSheetViewModel$onClickSaveNickname$1(onSuccess), 62, (Object) null);
    }

    public final void onClickViewServer(long guildId, Long channelId) {
        StoreLurking.startLurkingAndNavigate$default(this.storeLurking, guildId, channelId, null, 4, null);
    }

    public final void setAllowDM(AppActivity appActivity, long guildId, boolean allow) {
        this.storeUserSettings.setRestrictedGuildId(appActivity, guildId, !allow);
    }

    public final void setHideMutedChannels(long guildId, boolean hide) {
        this.storeUserGuildSettings.setHideMutedChannels(guildId, hide);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildProfileSheetViewModel(StoreUserSettings storeUserSettings, StoreUserGuildSettings storeUserGuildSettings, boolean z2, RestAPI restAPI, StoreLurking storeLurking, StoreAnalytics storeAnalytics, long j, Observable<WidgetGuildProfileSheetViewModel$StoreState> observable) {
        super(WidgetGuildProfileSheetViewModel$ViewState$Loading.INSTANCE);
        m.checkNotNullParameter(storeUserSettings, "storeUserSettings");
        m.checkNotNullParameter(storeUserGuildSettings, "storeUserGuildSettings");
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(storeLurking, "storeLurking");
        m.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        m.checkNotNullParameter(observable, "storeObservable");
        this.storeUserSettings = storeUserSettings;
        this.storeUserGuildSettings = storeUserGuildSettings;
        this.viewingGuild = z2;
        this.restAPI = restAPI;
        this.storeLurking = storeLurking;
        this.guildId = j;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), WidgetGuildProfileSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildProfileSheetViewModel$1(this), 62, (Object) null);
        storeAnalytics.trackGuildProfileOpened(j);
    }
}
