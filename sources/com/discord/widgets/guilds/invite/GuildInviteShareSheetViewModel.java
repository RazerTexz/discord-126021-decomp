package com.discord.widgets.guilds.invite;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.BuildConfig;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.stageinstance.StageInstance;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelInvite;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreMessages;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.guilds.GuildUtilsKt;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.recycler.DiffKeyProvider;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.g0.t;
import d0.g0.w;
import d0.t.h0;
import d0.t.m;
import d0.t.n0;
import d0.t.o;
import d0.t.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: GuildInviteShareSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildInviteShareSheetViewModel extends d0<GuildInviteShareSheetViewModel$ViewState> {
    public static final GuildInviteShareSheetViewModel$Companion Companion = new GuildInviteShareSheetViewModel$Companion(null);
    private final Long channelId;
    private GuildInviteShareSheetViewModel$StoreState currentStoreState;
    private final long guildId;
    private boolean hasTrackedSuggestionsViewed;
    private GuildInvite invite;
    private final Logger logger;
    private String searchQuery;
    private BehaviorSubject<String> searchQuerySubject;
    private Map<String, ? extends Set<Long>> sentInvites;
    private final StoreAnalytics storeAnalytics;
    private final StoreInviteSettings storeInviteSettings;
    private final StoreMessages storeMessages;
    private Channel targetChannel;
    private final TargetChannelSelector targetChannelSelector;

    public /* synthetic */ GuildInviteShareSheetViewModel(Long l, long j, StoreInviteSettings storeInviteSettings, StoreAnalytics storeAnalytics, StoreMessages storeMessages, TargetChannelSelector targetChannelSelector, Logger logger, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableAccess$observeStoreState;
        StoreInviteSettings inviteSettings = (i & 4) != 0 ? StoreStream.Companion.getInviteSettings() : storeInviteSettings;
        StoreAnalytics analytics = (i & 8) != 0 ? StoreStream.Companion.getAnalytics() : storeAnalytics;
        StoreMessages messages = (i & 16) != 0 ? StoreStream.Companion.getMessages() : storeMessages;
        TargetChannelSelector targetChannelSelector2 = (i & 32) != 0 ? new TargetChannelSelector() : targetChannelSelector;
        Logger logger2 = (i & 64) != 0 ? AppLog.g : logger;
        if ((i & 128) != 0) {
            GuildInviteShareSheetViewModel$Companion guildInviteShareSheetViewModel$Companion = Companion;
            InviteSuggestionsManager inviteSuggestionsManager = new InviteSuggestionsManager(null, null, null, null, null, 31, null);
            StoreStream$Companion storeStream$Companion = StoreStream.Companion;
            observableAccess$observeStoreState = GuildInviteShareSheetViewModel$Companion.access$observeStoreState(guildInviteShareSheetViewModel$Companion, j, inviteSuggestionsManager, storeStream$Companion.getInviteSettings(), storeStream$Companion.getUsers(), storeStream$Companion.getChannels(), storeStream$Companion.getGuilds(), storeStream$Companion.getStageInstances());
        } else {
            observableAccess$observeStoreState = observable;
        }
        this(l, j, inviteSettings, analytics, messages, targetChannelSelector2, logger2, observableAccess$observeStoreState);
    }

    public static final /* synthetic */ StoreAnalytics access$getStoreAnalytics$p(GuildInviteShareSheetViewModel guildInviteShareSheetViewModel) {
        return guildInviteShareSheetViewModel.storeAnalytics;
    }

    public static final /* synthetic */ void access$handleInviteCreationFailure(GuildInviteShareSheetViewModel guildInviteShareSheetViewModel) {
        guildInviteShareSheetViewModel.handleInviteCreationFailure();
    }

    public static final /* synthetic */ void access$handleInviteCreationSuccess(GuildInviteShareSheetViewModel guildInviteShareSheetViewModel, ModelInvite modelInvite) {
        guildInviteShareSheetViewModel.handleInviteCreationSuccess(modelInvite);
    }

    public static final /* synthetic */ void access$handleStoreState(GuildInviteShareSheetViewModel guildInviteShareSheetViewModel, GuildInviteShareSheetViewModel$StoreState guildInviteShareSheetViewModel$StoreState) {
        guildInviteShareSheetViewModel.handleStoreState(guildInviteShareSheetViewModel$StoreState);
    }

    public static final /* synthetic */ void access$sendInviteToChannel(GuildInviteShareSheetViewModel guildInviteShareSheetViewModel, long j) {
        guildInviteShareSheetViewModel.sendInviteToChannel(j);
    }

    public static final /* synthetic */ void access$updateSearchQuery(GuildInviteShareSheetViewModel guildInviteShareSheetViewModel, String str) {
        guildInviteShareSheetViewModel.updateSearchQuery(str);
    }

    public static final /* synthetic */ void access$updateSentInvites(GuildInviteShareSheetViewModel guildInviteShareSheetViewModel, Map map) {
        guildInviteShareSheetViewModel.updateSentInvites(map);
    }

    private final GuildInviteShareSheetViewModel$ViewState createViewState(String searchQuery, Map<String, ? extends Set<Long>> sentInvites, GuildInviteShareSheetViewModel$StoreState$Valid storeState, GuildInvite generatedInvite) {
        String link;
        List arrayList;
        DiffKeyProvider inviteSuggestionItemV2$UserItem;
        boolean zContains;
        Collections.sort(new ArrayList(storeState.getInvitableChannels().values()), ChannelUtils.h(Channel.Companion));
        if (generatedInvite == null || (link = generatedInvite.toLink()) == null) {
            link = BuildConfig.HOST_INVITE;
        }
        Set<Long> setEmptySet = sentInvites.get(link);
        if (setEmptySet == null) {
            setEmptySet = n0.emptySet();
        }
        Set<Long> set = setEmptySet;
        List<InviteSuggestion> inviteSuggestions = storeState.getInviteSuggestions();
        if (!t.isBlank(searchQuery)) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : inviteSuggestions) {
                InviteSuggestion inviteSuggestion = (InviteSuggestion) obj;
                if (inviteSuggestion instanceof InviteSuggestion$ChannelItem) {
                    zContains = w.contains((CharSequence) ChannelUtils.c(((InviteSuggestion$ChannelItem) inviteSuggestion).getChannel()), (CharSequence) searchQuery, true);
                } else {
                    if (!(inviteSuggestion instanceof InviteSuggestion$UserSuggestion)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    zContains = w.contains((CharSequence) ((InviteSuggestion$UserSuggestion) inviteSuggestion).getUser().getUsername(), (CharSequence) searchQuery, true);
                }
                if (zContains) {
                    arrayList2.add(obj);
                }
            }
            inviteSuggestions = arrayList2;
        }
        List<Channel> dms = storeState.getDms();
        ArrayList arrayList3 = new ArrayList(o.collectionSizeOrDefault(dms, 10));
        Iterator<T> it = dms.iterator();
        while (true) {
            Long lValueOf = null;
            if (!it.hasNext()) {
                break;
            }
            Channel channel = (Channel) it.next();
            User userA = ChannelUtils.a(channel);
            if (userA != null) {
                lValueOf = Long.valueOf(userA.getId());
            }
            arrayList3.add(d0.o.to(lValueOf, Long.valueOf(channel.getId())));
        }
        Map map = h0.toMap(arrayList3);
        if ((!inviteSuggestions.isEmpty()) || t.isBlank(searchQuery)) {
            arrayList = new ArrayList(o.collectionSizeOrDefault(inviteSuggestions, 10));
            for (InviteSuggestion inviteSuggestion2 : inviteSuggestions) {
                if (inviteSuggestion2 instanceof InviteSuggestion$ChannelItem) {
                    InviteSuggestion$ChannelItem inviteSuggestion$ChannelItem = (InviteSuggestion$ChannelItem) inviteSuggestion2;
                    inviteSuggestionItemV2$UserItem = new InviteSuggestionItemV2$ChannelItem(inviteSuggestion$ChannelItem.getChannel(), set.contains(Long.valueOf(inviteSuggestion$ChannelItem.getChannel().getId())), searchQuery);
                } else {
                    if (!(inviteSuggestion2 instanceof InviteSuggestion$UserSuggestion)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    InviteSuggestion$UserSuggestion inviteSuggestion$UserSuggestion = (InviteSuggestion$UserSuggestion) inviteSuggestion2;
                    inviteSuggestionItemV2$UserItem = new InviteSuggestionItemV2$UserItem(inviteSuggestion$UserSuggestion.getUser(), u.contains(set, map.get(Long.valueOf(inviteSuggestion$UserSuggestion.getUser().getId()))), searchQuery);
                }
                arrayList.add(inviteSuggestionItemV2$UserItem);
            }
        } else {
            arrayList = m.listOf(InviteSuggestionItemV2$SearchNoResultsItem.INSTANCE);
        }
        return new GuildInviteShareSheetViewModel$ViewState(generatedInvite, storeState.getInviteSettings(), arrayList, storeState.getInvitableChannels().get(generatedInvite != null ? generatedInvite.getChannelId() : null), searchQuery, sentInvites, generatedInvite != null ? !generatedInvite.isStaticInvite() : true, storeState.getGuild().getId());
    }

    private final void generateInviteForChannel(long targetChannelId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(StoreInviteSettings.generateInvite$default(this.storeInviteSettings, targetChannelId, null, 2, null), false, 1, null), this, null, 2, null), GuildInviteShareSheetViewModel.class, (Context) null, (Function1) null, new GuildInviteShareSheetViewModel$generateInviteForChannel$2(this), (Function0) null, (Function0) null, new GuildInviteShareSheetViewModel$generateInviteForChannel$1(this), 54, (Object) null);
    }

    @MainThread
    private final void handleInviteCreationFailure() {
        Guild guild;
        String vanityUrlCode;
        GuildInviteShareSheetViewModel$StoreState guildInviteShareSheetViewModel$StoreState = this.currentStoreState;
        if (!(guildInviteShareSheetViewModel$StoreState instanceof GuildInviteShareSheetViewModel$StoreState$Valid)) {
            guildInviteShareSheetViewModel$StoreState = null;
        }
        GuildInviteShareSheetViewModel$StoreState$Valid guildInviteShareSheetViewModel$StoreState$Valid = (GuildInviteShareSheetViewModel$StoreState$Valid) guildInviteShareSheetViewModel$StoreState;
        if (guildInviteShareSheetViewModel$StoreState$Valid == null || (vanityUrlCode = (guild = guildInviteShareSheetViewModel$StoreState$Valid.getGuild()).getVanityUrlCode()) == null) {
            return;
        }
        ModelInvite modelInviteCreateForStaticUrl = ModelInvite.createForStaticUrl(vanityUrlCode, GuildUtilsKt.createApiGuild(guild));
        GuildInvite$Companion guildInvite$Companion = GuildInvite.Companion;
        d0.z.d.m.checkNotNullExpressionValue(modelInviteCreateForStaticUrl, "vanityUrlInvite");
        GuildInvite guildInviteCreateFromModelInvite = guildInvite$Companion.createFromModelInvite(modelInviteCreateForStaticUrl);
        this.invite = guildInviteCreateFromModelInvite;
        updateViewState2(createViewState(this.searchQuery, this.sentInvites, guildInviteShareSheetViewModel$StoreState$Valid, guildInviteCreateFromModelInvite));
    }

    @MainThread
    private final void handleInviteCreationSuccess(ModelInvite invite) {
        GuildInvite guildInviteCreateFromModelInvite = GuildInvite.Companion.createFromModelInvite(invite);
        this.invite = guildInviteCreateFromModelInvite;
        GuildInviteShareSheetViewModel$StoreState guildInviteShareSheetViewModel$StoreState = this.currentStoreState;
        if (!(guildInviteShareSheetViewModel$StoreState instanceof GuildInviteShareSheetViewModel$StoreState$Valid)) {
            guildInviteShareSheetViewModel$StoreState = null;
        }
        GuildInviteShareSheetViewModel$StoreState$Valid guildInviteShareSheetViewModel$StoreState$Valid = (GuildInviteShareSheetViewModel$StoreState$Valid) guildInviteShareSheetViewModel$StoreState;
        if (guildInviteShareSheetViewModel$StoreState$Valid != null) {
            updateViewState2(createViewState(this.searchQuery, this.sentInvites, guildInviteShareSheetViewModel$StoreState$Valid, guildInviteCreateFromModelInvite));
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x008f  */
    /* JADX WARN: Code duplicated, block: B:30:0x009b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:31:0x009d  */
    @MainThread
    private final void handleStoreState(GuildInviteShareSheetViewModel$StoreState storeState) {
        GuildInviteShareSheetViewModel$StoreState guildInviteShareSheetViewModel$StoreState = this.currentStoreState;
        if (d0.z.d.m.areEqual(storeState, GuildInviteShareSheetViewModel$StoreState$Invalid.INSTANCE)) {
            Logger logger = this.logger;
            StringBuilder sbU = a.U("invalid StoreState in ");
            sbU.append(GuildInviteShareSheetViewModel.class.getSimpleName());
            Logger.e$default(logger, sbU.toString(), null, null, 6, null);
            return;
        }
        if (storeState instanceof GuildInviteShareSheetViewModel$StoreState$Valid) {
            Channel channel = this.targetChannel;
            GuildInviteShareSheetViewModel$StoreState$Valid guildInviteShareSheetViewModel$StoreState$Valid = (GuildInviteShareSheetViewModel$StoreState$Valid) storeState;
            Channel targetChannel = this.targetChannelSelector.getTargetChannel(guildInviteShareSheetViewModel$StoreState$Valid.getInvitableChannels(), this.channelId);
            Guild guild = guildInviteShareSheetViewModel$StoreState$Valid.getGuild();
            String vanityUrlCode = guildInviteShareSheetViewModel$StoreState$Valid.getGuild().getVanityUrlCode();
            StageInstance stageInstance = guildInviteShareSheetViewModel$StoreState$Valid.getGuildStageInstances().get(this.channelId);
            String inviteCode = stageInstance != null ? stageInstance.getInviteCode() : null;
            if (this.invite == null) {
                boolean z2 = true;
                boolean z3 = this.channelId == null;
                if (guildInviteShareSheetViewModel$StoreState == null) {
                    if (vanityUrlCode != null && vanityUrlCode.length() != 0) {
                        z2 = false;
                    }
                    if (!z2 && z3) {
                        ModelInvite modelInviteCreateForStaticUrl = ModelInvite.createForStaticUrl(vanityUrlCode, GuildUtilsKt.createApiGuild(guild));
                        GuildInvite$Companion guildInvite$Companion = GuildInvite.Companion;
                        d0.z.d.m.checkNotNullExpressionValue(modelInviteCreateForStaticUrl, "vanityUrlInvite");
                        this.invite = guildInvite$Companion.createFromModelInvite(modelInviteCreateForStaticUrl);
                    } else if (channel != null) {
                        if (inviteCode != null) {
                            ModelInvite modelInviteCreateForStaticUrl2 = ModelInvite.createForStaticUrl(inviteCode, GuildUtilsKt.createApiGuild(guild));
                            GuildInvite$Companion guildInvite$Companion2 = GuildInvite.Companion;
                            d0.z.d.m.checkNotNullExpressionValue(modelInviteCreateForStaticUrl2, "stageInstanceInvite");
                            this.invite = guildInvite$Companion2.createFromModelInvite(modelInviteCreateForStaticUrl2);
                        }
                    } else if (inviteCode != null) {
                        ModelInvite modelInviteCreateForStaticUrl3 = ModelInvite.createForStaticUrl(inviteCode, GuildUtilsKt.createApiGuild(guild));
                        GuildInvite$Companion guildInvite$Companion3 = GuildInvite.Companion;
                        d0.z.d.m.checkNotNullExpressionValue(modelInviteCreateForStaticUrl3, "stageInstanceInvite");
                        this.invite = guildInvite$Companion3.createFromModelInvite(modelInviteCreateForStaticUrl3);
                    }
                } else if (channel != null && targetChannel != null) {
                    generateInviteForChannel(targetChannel.getId());
                } else if (inviteCode != null) {
                    ModelInvite modelInviteCreateForStaticUrl4 = ModelInvite.createForStaticUrl(inviteCode, GuildUtilsKt.createApiGuild(guild));
                    GuildInvite$Companion guildInvite$Companion4 = GuildInvite.Companion;
                    d0.z.d.m.checkNotNullExpressionValue(modelInviteCreateForStaticUrl4, "stageInstanceInvite");
                    this.invite = guildInvite$Companion4.createFromModelInvite(modelInviteCreateForStaticUrl4);
                }
            }
            this.targetChannel = targetChannel;
            updateViewState2(createViewState(this.searchQuery, this.sentInvites, guildInviteShareSheetViewModel$StoreState$Valid, this.invite));
        }
        this.currentStoreState = storeState;
    }

    @MainThread
    private final void sendInviteToChannel(long channelId) {
        GuildInviteShareSheetViewModel$ViewState viewState;
        GuildInvite guildInvite;
        GuildInviteShareSheetViewModel$StoreState guildInviteShareSheetViewModel$StoreState = this.currentStoreState;
        if (!(guildInviteShareSheetViewModel$StoreState instanceof GuildInviteShareSheetViewModel$StoreState$Valid)) {
            guildInviteShareSheetViewModel$StoreState = null;
        }
        GuildInviteShareSheetViewModel$StoreState$Valid guildInviteShareSheetViewModel$StoreState$Valid = (GuildInviteShareSheetViewModel$StoreState$Valid) guildInviteShareSheetViewModel$StoreState;
        if (guildInviteShareSheetViewModel$StoreState$Valid == null || (viewState = getViewState()) == null || (guildInvite = this.invite) == null) {
            return;
        }
        String link = guildInvite.toLink();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreMessages.sendMessage$default(this.storeMessages, channelId, guildInviteShareSheetViewModel$StoreState$Valid.getMe(), link, null, null, null, null, null, null, null, null, null, null, null, null, 32736, null), this, null, 2, null), GuildInviteShareSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GuildInviteShareSheetViewModel$sendInviteToChannel$1(this, guildInvite, viewState, link), 62, (Object) null);
    }

    private final void sendInviteToUser(long userId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().createOrFetchDM(userId), false, 1, null), this, null, 2, null), GuildInviteShareSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GuildInviteShareSheetViewModel$sendInviteToUser$1(this), 62, (Object) null);
    }

    @MainThread
    private final void updateSearchQuery(String searchQuery) {
        GuildInviteShareSheetViewModel$StoreState guildInviteShareSheetViewModel$StoreState = this.currentStoreState;
        if (!(guildInviteShareSheetViewModel$StoreState instanceof GuildInviteShareSheetViewModel$StoreState$Valid)) {
            guildInviteShareSheetViewModel$StoreState = null;
        }
        GuildInviteShareSheetViewModel$StoreState$Valid guildInviteShareSheetViewModel$StoreState$Valid = (GuildInviteShareSheetViewModel$StoreState$Valid) guildInviteShareSheetViewModel$StoreState;
        if (guildInviteShareSheetViewModel$StoreState$Valid == null || d0.z.d.m.areEqual(searchQuery, this.searchQuery)) {
            return;
        }
        this.searchQuery = searchQuery;
        updateViewState2(createViewState(searchQuery, this.sentInvites, guildInviteShareSheetViewModel$StoreState$Valid, this.invite));
    }

    @MainThread
    private final void updateSentInvites(Map<String, ? extends Set<Long>> sentInvites) {
        this.sentInvites = sentInvites;
        GuildInviteShareSheetViewModel$StoreState guildInviteShareSheetViewModel$StoreState = this.currentStoreState;
        if (!(guildInviteShareSheetViewModel$StoreState instanceof GuildInviteShareSheetViewModel$StoreState$Valid)) {
            guildInviteShareSheetViewModel$StoreState = null;
        }
        GuildInviteShareSheetViewModel$StoreState$Valid guildInviteShareSheetViewModel$StoreState$Valid = (GuildInviteShareSheetViewModel$StoreState$Valid) guildInviteShareSheetViewModel$StoreState;
        if (guildInviteShareSheetViewModel$StoreState$Valid != null) {
            updateViewState2(createViewState(this.searchQuery, sentInvites, guildInviteShareSheetViewModel$StoreState$Valid, this.invite));
        }
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final void onSearchTextChanged(String searchQuery) {
        d0.z.d.m.checkNotNullParameter(searchQuery, "searchQuery");
        this.searchQuerySubject.onNext(searchQuery);
    }

    @MainThread
    public final void sendInvite(InviteSuggestionItemV2 item) {
        d0.z.d.m.checkNotNullParameter(item, "item");
        if (item instanceof InviteSuggestionItemV2$ChannelItem) {
            sendInviteToChannel(((InviteSuggestionItemV2$ChannelItem) item).getChannel().getId());
        } else if (item instanceof InviteSuggestionItemV2$UserItem) {
            sendInviteToUser(((InviteSuggestionItemV2$UserItem) item).getUser().getId());
        }
    }

    @MainThread
    public final void updateInvite(GuildInvite invite) {
        d0.z.d.m.checkNotNullParameter(invite, "invite");
        this.invite = invite;
        GuildInviteShareSheetViewModel$ViewState viewState = getViewState();
        if (viewState != null) {
            GuildInviteShareSheetViewModel$StoreState guildInviteShareSheetViewModel$StoreState = this.currentStoreState;
            if (!(guildInviteShareSheetViewModel$StoreState instanceof GuildInviteShareSheetViewModel$StoreState$Valid)) {
                guildInviteShareSheetViewModel$StoreState = null;
            }
            GuildInviteShareSheetViewModel$StoreState$Valid guildInviteShareSheetViewModel$StoreState$Valid = (GuildInviteShareSheetViewModel$StoreState$Valid) guildInviteShareSheetViewModel$StoreState;
            if (guildInviteShareSheetViewModel$StoreState$Valid != null) {
                updateViewState2(GuildInviteShareSheetViewModel$ViewState.copy$default(viewState, invite, null, null, guildInviteShareSheetViewModel$StoreState$Valid.getInvitableChannels().get(invite.getChannelId()), null, null, false, 0L, 246, null));
            }
        }
    }

    @Override // b.a.d.d0
    public /* bridge */ /* synthetic */ void updateViewState(GuildInviteShareSheetViewModel$ViewState guildInviteShareSheetViewModel$ViewState) {
        updateViewState2(guildInviteShareSheetViewModel$ViewState);
    }

    @MainThread
    /* JADX INFO: renamed from: updateViewState, reason: avoid collision after fix types in other method */
    public void updateViewState2(GuildInviteShareSheetViewModel$ViewState viewState) {
        d0.z.d.m.checkNotNullParameter(viewState, "viewState");
        super.updateViewState(viewState);
        if (!viewState.getHasSearchResults() || this.hasTrackedSuggestionsViewed) {
            return;
        }
        long guildId = viewState.getGuildId();
        List<InviteSuggestionItemV2> inviteSuggestionItems = viewState.getInviteSuggestionItems();
        StoreAnalytics storeAnalytics = this.storeAnalytics;
        ArrayList arrayList = new ArrayList();
        for (Object obj : inviteSuggestionItems) {
            if (obj instanceof InviteSuggestionItemV2$ChannelItem) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((InviteSuggestionItemV2$ChannelItem) it.next()).getChannel());
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : inviteSuggestionItems) {
            if (obj2 instanceof InviteSuggestionItemV2$UserItem) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = new ArrayList(o.collectionSizeOrDefault(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(((InviteSuggestionItemV2$UserItem) it2.next()).getUser());
        }
        storeAnalytics.inviteSuggestionOpened(guildId, arrayList2, arrayList4);
        this.hasTrackedSuggestionsViewed = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildInviteShareSheetViewModel(Long l, long j, StoreInviteSettings storeInviteSettings, StoreAnalytics storeAnalytics, StoreMessages storeMessages, TargetChannelSelector targetChannelSelector, Logger logger, Observable<GuildInviteShareSheetViewModel$StoreState> observable) {
        super(null, 1, null);
        d0.z.d.m.checkNotNullParameter(storeInviteSettings, "storeInviteSettings");
        d0.z.d.m.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        d0.z.d.m.checkNotNullParameter(storeMessages, "storeMessages");
        d0.z.d.m.checkNotNullParameter(targetChannelSelector, "targetChannelSelector");
        d0.z.d.m.checkNotNullParameter(logger, "logger");
        d0.z.d.m.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = l;
        this.guildId = j;
        this.storeInviteSettings = storeInviteSettings;
        this.storeAnalytics = storeAnalytics;
        this.storeMessages = storeMessages;
        this.targetChannelSelector = targetChannelSelector;
        this.logger = logger;
        BehaviorSubject<String> behaviorSubjectL0 = BehaviorSubject.l0("");
        d0.z.d.m.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(\"\")");
        this.searchQuerySubject = behaviorSubjectL0;
        this.searchQuery = "";
        this.sentInvites = h0.emptyMap();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), GuildInviteShareSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GuildInviteShareSheetViewModel$1(this), 62, (Object) null);
        Observable<String> observableP = this.searchQuerySubject.p(250L, TimeUnit.MILLISECONDS);
        d0.z.d.m.checkNotNullExpressionValue(observableP, "searchQuerySubject\n     …0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableP, this, null, 2, null), GuildInviteShareSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GuildInviteShareSheetViewModel$2(this), 62, (Object) null);
    }
}
