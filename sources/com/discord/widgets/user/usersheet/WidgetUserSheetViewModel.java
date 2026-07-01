package com.discord.widgets.user.usersheet;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.api.user.UserProfile;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelUserNote;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.CoreUser;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.nullserializable.NullSerializable;
import com.discord.restapi.RestAPIParams$GuildMember;
import com.discord.restapi.RestAPIParams$GuildMemberDisconnect;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.stores.StoreApplicationStreamPreviews;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StoreMediaSettings$SelfMuteFailure;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserNotes;
import com.discord.stores.StoreUserNotes$UserNoteState;
import com.discord.stores.StoreUserNotes$UserNoteState$Empty;
import com.discord.stores.StoreUserNotes$UserNoteState$Loaded;
import com.discord.stores.StoreUserNotes$UserNoteState$Loading;
import com.discord.stores.StoreUserProfile;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.permissions.ManageUserContext;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.streams.StreamContext$Joinability;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessagePreprocessor;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import com.discord.utilities.voice.PerceptualVolumeUtils;
import com.discord.widgets.stage.StageChannelAPI;
import com.discord.widgets.stage.usersheet.UserProfileStageActionsView$ViewState;
import com.discord.widgets.user.profile.UserProfileAdminView$ViewState;
import com.discord.widgets.user.profile.UserProfileConnectionsView$ConnectedAccountItem;
import com.discord.widgets.user.profile.UserProfileConnectionsView$ViewState;
import d0.g0.t;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheetViewModel extends d0<WidgetUserSheetViewModel$ViewState> {
    public static final WidgetUserSheetViewModel$Companion Companion = new WidgetUserSheetViewModel$Companion(null);
    public static final String LOCATION = "User Profile";
    private final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> bioParser;
    private final long channelId;
    private final PublishSubject<WidgetUserSheetViewModel$Event> eventSubject;
    private Set<String> fetchedPreviews;
    private final String friendToken;
    private final Long guildId;
    private final boolean isVoiceContext;
    private WidgetUserSheetViewModel$StoreState mostRecentStoreState;
    private boolean openPopoutLogged;
    private final RestAPI restAPI;
    private final RestAPI restAPISerializeNulls;
    private final Set<Integer> revealedBioIndices;
    private final StoreApplicationStreamPreviews storeApplicationStreamPreviews;
    private final StoreApplicationStreaming storeApplicationStreaming;
    private final StoreMediaSettings storeMediaSettings;
    private final StoreUserNotes storeUserNotes;
    private final StoreUserProfile storeUserProfile;
    private final WidgetUserSheet$StreamPreviewClickBehavior streamPreviewClickBehavior;
    private final long userId;

    public /* synthetic */ WidgetUserSheetViewModel(long j, long j2, Long l, String str, boolean z2, Observable observable, WidgetUserSheet$StreamPreviewClickBehavior widgetUserSheet$StreamPreviewClickBehavior, StoreMediaSettings storeMediaSettings, StoreApplicationStreaming storeApplicationStreaming, StoreUserNotes storeUserNotes, StoreUserProfile storeUserProfile, RestAPI restAPI, RestAPI restAPI2, StoreApplicationStreamPreviews storeApplicationStreamPreviews, Parser parser, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, l, str, z2, (i & 32) != 0 ? WidgetUserSheetViewModelStoreState.observeStoreState$default(WidgetUserSheetViewModelStoreState.INSTANCE, j, Long.valueOf(j2), l, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131064, null) : observable, widgetUserSheet$StreamPreviewClickBehavior, (i & 128) != 0 ? StoreStream.Companion.getMediaSettings() : storeMediaSettings, (i & 256) != 0 ? StoreStream.Companion.getApplicationStreaming() : storeApplicationStreaming, (i & 512) != 0 ? StoreStream.Companion.getUsersNotes() : storeUserNotes, (i & 1024) != 0 ? StoreStream.Companion.getUserProfile() : storeUserProfile, (i & 2048) != 0 ? RestAPI.Companion.getApi() : restAPI, (i & 4096) != 0 ? RestAPI.Companion.getApiSerializeNulls() : restAPI2, (i & 8192) != 0 ? StoreStream.Companion.getApplicationStreamPreviews() : storeApplicationStreamPreviews, (i & 16384) != 0 ? DiscordParser.createParser$default(false, false, false, false, false, 28, null) : parser);
    }

    public static final /* synthetic */ void access$emitDismissSheetEvent(WidgetUserSheetViewModel widgetUserSheetViewModel) {
        widgetUserSheetViewModel.emitDismissSheetEvent();
    }

    public static final /* synthetic */ void access$emitLaunchVideoCallEvent(WidgetUserSheetViewModel widgetUserSheetViewModel, long j) {
        widgetUserSheetViewModel.emitLaunchVideoCallEvent(j);
    }

    public static final /* synthetic */ void access$emitLaunchVoiceCallEvent(WidgetUserSheetViewModel widgetUserSheetViewModel, long j) {
        widgetUserSheetViewModel.emitLaunchVoiceCallEvent(j);
    }

    public static final /* synthetic */ void access$emitShowFriendRequestAbortToast(WidgetUserSheetViewModel widgetUserSheetViewModel, int i, String str) {
        widgetUserSheetViewModel.emitShowFriendRequestAbortToast(i, str);
    }

    public static final /* synthetic */ void access$emitShowToastEvent(WidgetUserSheetViewModel widgetUserSheetViewModel, int i) {
        widgetUserSheetViewModel.emitShowToastEvent(i);
    }

    public static final /* synthetic */ WidgetUserSheetViewModel$ViewState access$getViewState$p(WidgetUserSheetViewModel widgetUserSheetViewModel) {
        return widgetUserSheetViewModel.getViewState();
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetUserSheetViewModel widgetUserSheetViewModel, WidgetUserSheetViewModel$StoreState widgetUserSheetViewModel$StoreState) {
        widgetUserSheetViewModel.handleStoreState(widgetUserSheetViewModel$StoreState);
    }

    public static final /* synthetic */ void access$updateViewState(WidgetUserSheetViewModel widgetUserSheetViewModel, WidgetUserSheetViewModel$ViewState widgetUserSheetViewModel$ViewState) {
        widgetUserSheetViewModel.updateViewState(widgetUserSheetViewModel$ViewState);
    }

    public static /* synthetic */ void addRelationship$default(WidgetUserSheetViewModel widgetUserSheetViewModel, Integer num, String str, int i, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            captchaHelper$CaptchaPayload = null;
        }
        widgetUserSheetViewModel.addRelationship(num, str, i, captchaHelper$CaptchaPayload);
    }

    private final UserProfileAdminView$ViewState createAdminViewState(Channel channel, boolean isChannelOwner, boolean isMe, ManageUserContext manageUserContext, VoiceState channelVoiceState, boolean canDisableCommunication, boolean isCommunicationDisabled) {
        boolean z2;
        if (channel == null) {
            return null;
        }
        boolean z3 = manageUserContext != null && (manageUserContext.getCanChangeNickname() || manageUserContext.getCanManageRoles());
        boolean z4 = !ChannelUtils.z(channel) ? manageUserContext == null || !manageUserContext.getCanKick() : ChannelUtils.y(channel) || !isChannelOwner || isMe;
        boolean z5 = canDisableCommunication && manageUserContext != null && manageUserContext.getCanDisableCommunication() && !isMe;
        boolean z6 = ChannelUtils.z(channel);
        boolean z7 = manageUserContext != null && manageUserContext.getCanBan();
        boolean z8 = (channelVoiceState == null || manageUserContext == null || !manageUserContext.getCanMute() || ChannelUtils.D(channel)) ? false : true;
        boolean z9 = channelVoiceState != null && channelVoiceState.getMute();
        boolean z10 = (channelVoiceState == null || manageUserContext == null || !manageUserContext.getCanDeafen()) ? false : true;
        boolean z11 = channelVoiceState != null && channelVoiceState.getDeaf();
        boolean z12 = (channelVoiceState == null || manageUserContext == null || !manageUserContext.getCanMove()) ? false : true;
        Boolean[] boolArr = {Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z7), Boolean.valueOf(z5), Boolean.valueOf(z8), Boolean.valueOf(z10), Boolean.valueOf(z12)};
        for (int i = 0; i < 7; i++) {
            if (boolArr[i].booleanValue()) {
                z2 = true;
                return new UserProfileAdminView$ViewState(z3, z4, z5, z6, z7, z8, z9, z10, z11, z12, z2, isMe, isCommunicationDisabled);
            }
        }
        z2 = false;
        return new UserProfileAdminView$ViewState(z3, z4, z5, z6, z7, z8, z9, z10, z11, z12, z2, isMe, isCommunicationDisabled);
    }

    private final List<Node<MessageRenderContext>> createAndProcessBioAstFromText(String bio) {
        if (bio == null || t.isBlank(bio)) {
            return null;
        }
        List<Node<MessageRenderContext>> listGenerateAst = generateAst(bio);
        createMessagePreprocessor().process(listGenerateAst);
        return listGenerateAst;
    }

    private final UserProfileConnectionsView$ViewState createConnectionsViewState(UserProfile userProfile, boolean isMe, boolean isSystemUser) {
        List<ConnectedAccount> listB = userProfile.b();
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(listB, 10));
        Iterator<T> it = listB.iterator();
        while (it.hasNext()) {
            arrayList.add(new UserProfileConnectionsView$ConnectedAccountItem((ConnectedAccount) it.next()));
        }
        boolean z2 = (isMe || isSystemUser) ? false : true;
        return new UserProfileConnectionsView$ViewState(z2 || (arrayList.isEmpty() ^ true), z2, arrayList);
    }

    private final MessagePreprocessor createMessagePreprocessor() {
        return new MessagePreprocessor(-1L, this.revealedBioIndices, null, false, null, 28, null);
    }

    private final Observable<Channel> createPrivateChannelWithUser(long userId) {
        return this.restAPI.createOrFetchDM(userId);
    }

    public static /* synthetic */ void disconnectUser$default(WidgetUserSheetViewModel widgetUserSheetViewModel, Channel channel, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = null;
        }
        widgetUserSheetViewModel.disconnectUser(channel);
    }

    private final void emitDismissSheetEvent() {
        PublishSubject<WidgetUserSheetViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(WidgetUserSheetViewModel$Event$DismissSheet.INSTANCE);
    }

    private final void emitLaunchSpectateEvent(ModelApplicationStream stream) {
        PublishSubject<WidgetUserSheetViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new WidgetUserSheetViewModel$Event$LaunchSpectate(stream));
    }

    private final void emitLaunchVideoCallEvent(long channelId) {
        PublishSubject<WidgetUserSheetViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new WidgetUserSheetViewModel$Event$LaunchVideoCall(channelId));
    }

    private final void emitLaunchVoiceCallEvent(long channelId) {
        PublishSubject<WidgetUserSheetViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new WidgetUserSheetViewModel$Event$LaunchVoiceCall(channelId));
    }

    private final void emitRequestStreamPermissionsEvent(ModelApplicationStream stream) {
        PublishSubject<WidgetUserSheetViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new WidgetUserSheetViewModel$Event$RequestPermissionsForSpectateStream(stream));
    }

    private final void emitShowFriendRequestAbortToast(int abortCode, String username) {
        PublishSubject<WidgetUserSheetViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new WidgetUserSheetViewModel$Event$ShowFriendRequestErrorToast(abortCode, username));
    }

    private final void emitShowToastEvent(@StringRes int stringRes) {
        PublishSubject<WidgetUserSheetViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new WidgetUserSheetViewModel$Event$ShowToast(stringRes));
    }

    private final List<Node<MessageRenderContext>> generateAst(CharSequence text) {
        return Parser.parse$default(this.bioParser, text, MessageParseState.Companion.getInitialState(), null, 4, null);
    }

    /* JADX WARN: Code duplicated, block: B:103:0x023a  */
    /* JADX WARN: Code duplicated, block: B:23:0x0091  */
    /* JADX WARN: Code duplicated, block: B:88:0x01f9  */
    private final void handleStoreState(WidgetUserSheetViewModel$StoreState storeState) {
        List listEmptyList;
        String strC;
        Float fValueOf;
        boolean z2;
        User user;
        ModelUserNote note;
        String bio;
        User userMerge;
        ModelApplicationStream stream;
        String name;
        List<Long> roles;
        if (storeState == null) {
            this.eventSubject.k.onNext(WidgetUserSheetViewModel$Event$UserNotFound.INSTANCE);
            return;
        }
        User user2 = storeState.getUser();
        MeUser me2 = storeState.getMe();
        Channel channel = storeState.getChannel();
        Map<Long, GuildMember> computedMembers = storeState.getComputedMembers();
        Map<Long, GuildRole> guildRoles = storeState.getGuildRoles();
        Guild guild = storeState.getGuild();
        boolean z3 = false;
        boolean z4 = me2.getId() == user2.getId();
        boolean isSystemUser = user2.getIsSystemUser();
        GuildMember guildMember = (GuildMember) a.f(user2, computedMembers);
        GuildMember guildMember2 = computedMembers.get(Long.valueOf(me2.getId()));
        if (guildMember == null || (roles = guildMember.getRoles()) == null) {
            listEmptyList = n.emptyList();
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = roles.iterator();
            while (it.hasNext()) {
                GuildRole guildRole = guildRoles.get(Long.valueOf(((Number) it.next()).longValue()));
                if (guildRole != null) {
                    arrayList.add(guildRole);
                }
            }
            listEmptyList = u.sortedWith(arrayList, RoleUtils.getROLE_COMPARATOR());
            if (listEmptyList == null) {
                listEmptyList = n.emptyList();
            }
        }
        List list = listEmptyList;
        ManageUserContext manageUserContextFrom = (guildMember == null || guildMember2 == null || guild == null) ? null : ManageUserContext.Companion.from(guild, me2, user2, guildMember2.getRoles(), guildMember.getRoles(), storeState.getPermissions(), guildRoles);
        boolean zIsCommunicationDisabled = guildMember != null ? guildMember.isCommunicationDisabled() : false;
        boolean z5 = channel != null && channel.getOwnerId() == me2.getId();
        int type = ModelUserRelationship.getType(storeState.getUserRelationshipType());
        VoiceState voiceState = (VoiceState) a.f(user2, storeState.getMySelectedVoiceChannelVoiceStates());
        VoiceState voiceState2 = storeState.getMySelectedVoiceChannelVoiceStates().get(Long.valueOf(me2.getId()));
        boolean zIsInSameVoiceChannel = isInSameVoiceChannel(voiceState2, voiceState);
        boolean z6 = this.isVoiceContext || zIsInSameVoiceChannel;
        boolean selfMuted = z4 ? storeState.getSelfMuted() : storeState.getMuted();
        Boolean boolValueOf = z4 ? Boolean.valueOf(storeState.getSelfDeafened()) : null;
        if (z4) {
            strC = null;
            fValueOf = null;
        } else {
            strC = null;
            fValueOf = Float.valueOf(PerceptualVolumeUtils.amplitudeToPerceptual$default(PerceptualVolumeUtils.INSTANCE, storeState.getOutputVolume(), 0.0f, 2, null));
        }
        UserProfileVoiceSettingsView$ViewState userProfileVoiceSettingsView$ViewState = new UserProfileVoiceSettingsView$ViewState(selfMuted, boolValueOf, fValueOf);
        VoiceState voiceState3 = (VoiceState) a.f(user2, storeState.getCurrentChannelVoiceStates());
        if (channel != null && ChannelUtils.z(channel)) {
            strC = ChannelUtils.c(channel);
        }
        String str = (guild == null || (name = guild.getName()) == null) ? strC : name;
        boolean z7 = z4;
        UserProfileAdminView$ViewState userProfileAdminView$ViewStateCreateAdminViewState = createAdminViewState(channel, z5, z4, manageUserContextFrom, voiceState3, storeState.getCanDisableCommunication(), zIsCommunicationDisabled);
        UserProfile userProfile = storeState.getUserProfile();
        UserProfileConnectionsView$ViewState userProfileConnectionsView$ViewStateCreateConnectionsViewState = createConnectionsViewState(userProfile, z7, isSystemUser);
        StreamContext streamContext = storeState.getStreamContext();
        String encodedStreamKey = (streamContext == null || (stream = streamContext.getStream()) == null) ? null : stream.getEncodedStreamKey();
        if (encodedStreamKey != null && !this.fetchedPreviews.contains(encodedStreamKey)) {
            this.storeApplicationStreamPreviews.fetchStreamPreviewIfNotFetching(streamContext);
            this.fetchedPreviews.add(encodedStreamKey);
        }
        UserProfileStageActionsView$ViewState userProfileStageActionsView$ViewState = new UserProfileStageActionsView$ViewState(z7, storeState.getStageChannel(), storeState.m60getUserStageRolestwRsX0(), storeState.getUserRequestToSpeakState(), isInSameVoiceChannel(voiceState2, voiceState), PermissionUtils.can(Permission.MUTE_MEMBERS, storeState.getPermissions()), false, false, Opcodes.CHECKCAST, null);
        Long l = this.guildId;
        if (l == null || (l != null && l.longValue() == 0)) {
            z2 = true;
        } else {
            if ((guildMember != null ? guildMember.getBio() : null) != null) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        boolean z8 = (m.areEqual(userProfile, StoreUserProfile.Companion.getEMPTY_PROFILE()) ^ true) && z2;
        if (z8) {
            if (user2 instanceof MeUser) {
                userMerge = MeUser.Companion.merge((MeUser) user2, userProfile.getUser());
            } else if (user2 instanceof CoreUser) {
                userMerge = CoreUser.Companion.merge((CoreUser) user2, userProfile.getUser());
            } else {
                user = user2;
            }
            user = userMerge;
        } else {
            user = user2;
        }
        List<Node<MessageRenderContext>> listCreateAndProcessBioAstFromText = (guildMember == null || (bio = guildMember.getBio()) == null || !(t.isBlank(bio) ^ true)) ? null : createAndProcessBioAstFromText(bio);
        if (listCreateAndProcessBioAstFromText == null) {
            String bio2 = user.getBio();
            listCreateAndProcessBioAstFromText = bio2 != null ? createAndProcessBioAstFromText(bio2) : null;
        }
        List<Node<MessageRenderContext>> list2 = listCreateAndProcessBioAstFromText;
        StoreUserNotes$UserNoteState userNoteFetchState = storeState.getUserNoteFetchState();
        if (!(userNoteFetchState instanceof StoreUserNotes$UserNoteState$Loaded)) {
            userNoteFetchState = null;
        }
        StoreUserNotes$UserNoteState$Loaded storeUserNotes$UserNoteState$Loaded = (StoreUserNotes$UserNoteState$Loaded) userNoteFetchState;
        String note2 = (storeUserNotes$UserNoteState$Loaded == null || (note = storeUserNotes$UserNoteState$Loaded.getNote()) == null) ? null : note.getNote();
        WidgetUserSheetViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetUserSheetViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetUserSheetViewModel$ViewState$Loaded widgetUserSheetViewModel$ViewState$Loaded = (WidgetUserSheetViewModel$ViewState$Loaded) viewState;
        boolean z9 = ((widgetUserSheetViewModel$ViewState$Loaded != null ? widgetUserSheetViewModel$ViewState$Loaded.getUserNoteFetchState() : null) instanceof StoreUserNotes$UserNoteState$Loading) && !(storeState.getUserNoteFetchState() instanceof StoreUserNotes$UserNoteState$Loading);
        if (getViewState() instanceof WidgetUserSheetViewModel$ViewState$Uninitialized) {
            if (!(note2 == null || note2.length() == 0)) {
                z3 = true;
            }
        }
        if (!z9 && !z3) {
            note2 = null;
        } else if (note2 == null) {
            note2 = "";
        }
        updateViewState(new WidgetUserSheetViewModel$ViewState$Loaded(user, z7, z6, userProfileVoiceSettingsView$ViewState, voiceState3, storeState.getRichPresence(), str, list, userProfileAdminView$ViewStateCreateAdminViewState, userProfileStageActionsView$ViewState, channel, streamContext, guild != null ? guild.getName() : null, guild != null ? guild.getIcon() : null, type, userProfileConnectionsView$ViewStateCreateConnectionsViewState, storeState.getUserNoteFetchState(), note2, zIsInSameVoiceChannel, list2, z8, this.guildId, guildMember, storeState.getUserProfile()));
        this.mostRecentStoreState = storeState;
    }

    private final boolean isInSameVoiceChannel(VoiceState myVoiceState, VoiceState userVoiceState) {
        Long channelId = userVoiceState != null ? userVoiceState.getChannelId() : null;
        Long channelId2 = myVoiceState != null ? myVoiceState.getChannelId() : null;
        if (channelId == null || channelId2 == null) {
            return false;
        }
        return m.areEqual(channelId, channelId2);
    }

    public final void addRelationship(Integer type, String username, @StringRes int successMessageStringRes, CaptchaHelper$CaptchaPayload captchaPayload) {
        m.checkNotNullParameter(username, "username");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.addRelationship("User Profile", this.userId, type, this.friendToken, captchaPayload), false, 1, null), this, null, 2, null), WidgetUserSheetViewModel.class, (Context) null, (Function1) null, new WidgetUserSheetViewModel$addRelationship$2(this, type, username, successMessageStringRes), (Function0) null, (Function0) null, new WidgetUserSheetViewModel$addRelationship$1(this, successMessageStringRes), 54, (Object) null);
    }

    public final void banUser() {
        Channel channel;
        WidgetUserSheetViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetUserSheetViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetUserSheetViewModel$ViewState$Loaded widgetUserSheetViewModel$ViewState$Loaded = (WidgetUserSheetViewModel$ViewState$Loaded) viewState;
        if (widgetUserSheetViewModel$ViewState$Loaded == null || (channel = widgetUserSheetViewModel$ViewState$Loaded.getChannel()) == null) {
            return;
        }
        User user = widgetUserSheetViewModel$ViewState$Loaded.getUser();
        this.eventSubject.k.onNext(new WidgetUserSheetViewModel$Event$LaunchBanUser(user.getUsername(), channel.getGuildId(), user.getId()));
    }

    public final void disableCommunication() {
        Channel channel;
        WidgetUserSheetViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetUserSheetViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetUserSheetViewModel$ViewState$Loaded widgetUserSheetViewModel$ViewState$Loaded = (WidgetUserSheetViewModel$ViewState$Loaded) viewState;
        if (widgetUserSheetViewModel$ViewState$Loaded == null || (channel = widgetUserSheetViewModel$ViewState$Loaded.getChannel()) == null) {
            return;
        }
        User user = widgetUserSheetViewModel$ViewState$Loaded.getUser();
        GuildMember guildMember = widgetUserSheetViewModel$ViewState$Loaded.getGuildMember();
        if (guildMember != null ? guildMember.isCommunicationDisabled() : false) {
            this.eventSubject.k.onNext(new WidgetUserSheetViewModel$Event$LaunchEnableCommunication(user.getId(), channel.getGuildId()));
        } else {
            this.eventSubject.k.onNext(new WidgetUserSheetViewModel$Event$LaunchDisableCommunication(user.getId(), channel.getGuildId()));
        }
    }

    public final void disconnectUser(Channel channel) {
        WidgetUserSheetViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetUserSheetViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetUserSheetViewModel$ViewState$Loaded widgetUserSheetViewModel$ViewState$Loaded = (WidgetUserSheetViewModel$ViewState$Loaded) viewState;
        if (widgetUserSheetViewModel$ViewState$Loaded != null) {
            if (channel == null) {
                channel = widgetUserSheetViewModel$ViewState$Loaded.getChannel();
            }
            if (channel != null) {
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPISerializeNulls.disconnectGuildMember(channel.getGuildId(), widgetUserSheetViewModel$ViewState$Loaded.getUser().getId(), new RestAPIParams$GuildMemberDisconnect(null, 1, null)), false, 1, null), this, null, 2, null), WidgetUserSheetViewModel.class, (Context) null, (Function1) null, new WidgetUserSheetViewModel$disconnectUser$2(this), (Function0) null, (Function0) null, new WidgetUserSheetViewModel$disconnectUser$1(this), 54, (Object) null);
            }
        }
    }

    public final void editMember() {
        Channel channel;
        WidgetUserSheetViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetUserSheetViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetUserSheetViewModel$ViewState$Loaded widgetUserSheetViewModel$ViewState$Loaded = (WidgetUserSheetViewModel$ViewState$Loaded) viewState;
        if (widgetUserSheetViewModel$ViewState$Loaded == null || (channel = widgetUserSheetViewModel$ViewState$Loaded.getChannel()) == null) {
            return;
        }
        this.eventSubject.k.onNext(new WidgetUserSheetViewModel$Event$LaunchEditMember(channel.getGuildId(), this.userId));
    }

    public final boolean getOpenPopoutLogged() {
        return this.openPopoutLogged;
    }

    public final void guildDeafenUser() {
        WidgetUserSheetViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetUserSheetViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetUserSheetViewModel$ViewState$Loaded widgetUserSheetViewModel$ViewState$Loaded = (WidgetUserSheetViewModel$ViewState$Loaded) viewState;
        if (widgetUserSheetViewModel$ViewState$Loaded != null) {
            Channel channel = widgetUserSheetViewModel$ViewState$Loaded.getChannel();
            User user = widgetUserSheetViewModel$ViewState$Loaded.getUser();
            UserProfileAdminView$ViewState adminViewState = widgetUserSheetViewModel$ViewState$Loaded.getAdminViewState();
            if (channel == null || adminViewState == null) {
                return;
            }
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.changeGuildMember(channel.getGuildId(), user.getId(), RestAPIParams$GuildMember.Companion.createWithDeaf(!adminViewState.isServerDeafened())), false, 1, null), this, null, 2, null), WidgetUserSheetViewModel.class, (Context) null, (Function1) null, new WidgetUserSheetViewModel$guildDeafenUser$2(this), (Function0) null, (Function0) null, WidgetUserSheetViewModel$guildDeafenUser$1.INSTANCE, 54, (Object) null);
        }
    }

    public final void guildMoveForUser() {
        Channel channel;
        WidgetUserSheetViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetUserSheetViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetUserSheetViewModel$ViewState$Loaded widgetUserSheetViewModel$ViewState$Loaded = (WidgetUserSheetViewModel$ViewState$Loaded) viewState;
        if (widgetUserSheetViewModel$ViewState$Loaded == null || (channel = widgetUserSheetViewModel$ViewState$Loaded.getChannel()) == null) {
            return;
        }
        this.eventSubject.k.onNext(new WidgetUserSheetViewModel$Event$LaunchMoveUser(channel.getGuildId()));
    }

    public final void guildMuteUser() {
        WidgetUserSheetViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetUserSheetViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetUserSheetViewModel$ViewState$Loaded widgetUserSheetViewModel$ViewState$Loaded = (WidgetUserSheetViewModel$ViewState$Loaded) viewState;
        if (widgetUserSheetViewModel$ViewState$Loaded != null) {
            Channel channel = widgetUserSheetViewModel$ViewState$Loaded.getChannel();
            UserProfileAdminView$ViewState adminViewState = widgetUserSheetViewModel$ViewState$Loaded.getAdminViewState();
            User user = widgetUserSheetViewModel$ViewState$Loaded.getUser();
            if (channel == null || adminViewState == null) {
                return;
            }
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.changeGuildMember(channel.getGuildId(), user.getId(), RestAPIParams$GuildMember.Companion.createWithMute(!widgetUserSheetViewModel$ViewState$Loaded.getAdminViewState().isServerMuted())), false, 1, null), this, null, 2, null), WidgetUserSheetViewModel.class, (Context) null, (Function1) null, new WidgetUserSheetViewModel$guildMuteUser$2(this), (Function0) null, (Function0) null, WidgetUserSheetViewModel$guildMuteUser$1.INSTANCE, 54, (Object) null);
        }
    }

    @MainThread
    public final void handleBioIndexClicked(SpoilerNode<?> spoilerNode) {
        WidgetUserSheetViewModel$StoreState widgetUserSheetViewModel$StoreState;
        UserProfile userProfile;
        com.discord.api.user.User user;
        NullSerializable<String> nullSerializableD;
        String strA;
        m.checkNotNullParameter(spoilerNode, "spoilerNode");
        WidgetUserSheetViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetUserSheetViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetUserSheetViewModel$ViewState$Loaded widgetUserSheetViewModel$ViewState$Loaded = (WidgetUserSheetViewModel$ViewState$Loaded) viewState;
        if (widgetUserSheetViewModel$ViewState$Loaded == null || (widgetUserSheetViewModel$StoreState = this.mostRecentStoreState) == null || (userProfile = widgetUserSheetViewModel$StoreState.getUserProfile()) == null || (user = userProfile.getUser()) == null || (nullSerializableD = user.d()) == null || (strA = nullSerializableD.a()) == null) {
            return;
        }
        this.revealedBioIndices.add(Integer.valueOf(spoilerNode.getId()));
        updateViewState(WidgetUserSheetViewModel$ViewState$Loaded.copy$default(widgetUserSheetViewModel$ViewState$Loaded, null, false, false, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, false, createAndProcessBioAstFromText(strA), false, null, null, null, 16252927, null));
    }

    public final void inviteUserToSpeak() {
        Channel channel;
        WidgetUserSheetViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetUserSheetViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetUserSheetViewModel$ViewState$Loaded widgetUserSheetViewModel$ViewState$Loaded = (WidgetUserSheetViewModel$ViewState$Loaded) viewState;
        if (widgetUserSheetViewModel$ViewState$Loaded == null || (channel = widgetUserSheetViewModel$ViewState$Loaded.getStageViewState().getChannel()) == null) {
            return;
        }
        long id2 = widgetUserSheetViewModel$ViewState$Loaded.getUser().getId();
        updateViewState(WidgetUserSheetViewModel$ViewState$Loaded.copy$default(widgetUserSheetViewModel$ViewState$Loaded, null, false, false, null, null, null, null, null, null, UserProfileStageActionsView$ViewState.m51copyam1GJgw$default(widgetUserSheetViewModel$ViewState$Loaded.getStageViewState(), false, null, null, null, false, false, false, true, Opcodes.LAND, null), null, null, null, null, 0, null, null, null, false, null, false, null, null, null, 16776703, null));
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(StageChannelAPI.setUserSuppressedInChannel$default(StageChannelAPI.INSTANCE, channel, id2, false, 0L, 8, null), false, 1, null), this, null, 2, null), WidgetUserSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetUserSheetViewModel$inviteUserToSpeak$1(this), 62, (Object) null);
    }

    public final void kickUser() {
        Channel channel;
        WidgetUserSheetViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetUserSheetViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetUserSheetViewModel$ViewState$Loaded widgetUserSheetViewModel$ViewState$Loaded = (WidgetUserSheetViewModel$ViewState$Loaded) viewState;
        if (widgetUserSheetViewModel$ViewState$Loaded == null || (channel = widgetUserSheetViewModel$ViewState$Loaded.getChannel()) == null) {
            return;
        }
        User user = widgetUserSheetViewModel$ViewState$Loaded.getUser();
        if (ChannelUtils.z(channel)) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().removeChannelRecipient(channel.getId(), user.getId()), false, 1, null), 0L, false, 1, null), this, null, 2, null), (Context) null, "REST: remove group member", (Function1) null, new WidgetUserSheetViewModel$kickUser$1(this), (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
        } else {
            this.eventSubject.k.onNext(new WidgetUserSheetViewModel$Event$LaunchKickUser(user.getUsername(), channel.getGuildId(), user.getId()));
        }
    }

    public final void launchVideoCall() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(createPrivateChannelWithUser(this.userId), false, 1, null), this, null, 2, null), WidgetUserSheetViewModel.class, (Context) null, (Function1) null, new WidgetUserSheetViewModel$launchVideoCall$2(this), (Function0) null, (Function0) null, new WidgetUserSheetViewModel$launchVideoCall$1(this), 54, (Object) null);
    }

    public final void launchVoiceCall() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(createPrivateChannelWithUser(this.userId), false, 1, null), this, null, 2, null), WidgetUserSheetViewModel.class, (Context) null, (Function1) null, new WidgetUserSheetViewModel$launchVoiceCall$2(this), (Function0) null, (Function0) null, new WidgetUserSheetViewModel$launchVoiceCall$1(this), 54, (Object) null);
    }

    public final void moveUserToChannel(long channelId) {
        WidgetUserSheetViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetUserSheetViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetUserSheetViewModel$ViewState$Loaded widgetUserSheetViewModel$ViewState$Loaded = (WidgetUserSheetViewModel$ViewState$Loaded) viewState;
        if (widgetUserSheetViewModel$ViewState$Loaded != null) {
            Channel channel = widgetUserSheetViewModel$ViewState$Loaded.getChannel();
            User user = widgetUserSheetViewModel$ViewState$Loaded.getUser();
            if (channel != null) {
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.changeGuildMember(channel.getGuildId(), user.getId(), RestAPIParams$GuildMember.Companion.createWithChannelId(channelId)), false, 1, null), this, null, 2, null), WidgetUserSheetViewModel.class, (Context) null, (Function1) null, new WidgetUserSheetViewModel$moveUserToChannel$2(this), (Function0) null, (Function0) null, new WidgetUserSheetViewModel$moveUserToChannel$1(this), 54, (Object) null);
            }
        }
    }

    public final Observable<WidgetUserSheetViewModel$Event> observeEvents() {
        PublishSubject<WidgetUserSheetViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onActivityCustomButtonClicked(Context applicationContext, long userId, String sessionId, long applicationId, int buttonIndex) {
        m.checkNotNullParameter(applicationContext, "applicationContext");
        m.checkNotNullParameter(sessionId, "sessionId");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getActivityMetadata(userId, sessionId, applicationId), false, 1, null), this, null, 2, null), (Context) null, "REST: Custom Button GetActivityMetadata", (Function1) null, new WidgetUserSheetViewModel$onActivityCustomButtonClicked$1(buttonIndex, applicationContext), (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
    }

    @MainThread
    public final void onSpectatePermissionsGranted(ModelApplicationStream stream) {
        m.checkNotNullParameter(stream, "stream");
        StoreApplicationStreaming.targetStream$default(this.storeApplicationStreaming, stream.getEncodedStreamKey(), false, 2, null);
        int iOrdinal = this.streamPreviewClickBehavior.ordinal();
        if (iOrdinal == 0) {
            emitLaunchSpectateEvent(stream);
        } else {
            if (iOrdinal != 1) {
                return;
            }
            emitDismissSheetEvent();
        }
    }

    public final void onStreamPreviewClicked(StreamContext streamContext) {
        m.checkNotNullParameter(streamContext, "streamContext");
        if (streamContext.getJoinability() == StreamContext$Joinability.MISSING_PERMISSIONS) {
            emitShowToastEvent(2131887549);
        } else {
            emitRequestStreamPermissionsEvent(streamContext.getStream());
        }
    }

    public final void removeRelationship(@StringRes int successMessageStringRes) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.removeRelationship("User Profile", this.userId), false, 1, null), this, null, 2, null), WidgetUserSheetViewModel.class, (Context) null, (Function1) null, new WidgetUserSheetViewModel$removeRelationship$2(this), (Function0) null, (Function0) null, new WidgetUserSheetViewModel$removeRelationship$1(this, successMessageStringRes), 54, (Object) null);
    }

    public final void saveUserNote(Context context, String noteText) {
        m.checkNotNullParameter(noteText, "noteText");
        WidgetUserSheetViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetUserSheetViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetUserSheetViewModel$ViewState$Loaded widgetUserSheetViewModel$ViewState$Loaded = (WidgetUserSheetViewModel$ViewState$Loaded) viewState;
        if (widgetUserSheetViewModel$ViewState$Loaded != null) {
            boolean z2 = true;
            if ((!(widgetUserSheetViewModel$ViewState$Loaded.getUserNoteFetchState() instanceof StoreUserNotes$UserNoteState$Empty) || !(!m.areEqual(noteText, ""))) && (!(widgetUserSheetViewModel$ViewState$Loaded.getUserNoteFetchState() instanceof StoreUserNotes$UserNoteState$Loaded) || !(!m.areEqual(((StoreUserNotes$UserNoteState$Loaded) widgetUserSheetViewModel$ViewState$Loaded.getUserNoteFetchState()).getNote().getNote(), noteText)))) {
                z2 = false;
            }
            if (z2) {
                this.storeUserNotes.saveNote(context, this.userId, noteText);
            }
        }
    }

    public final void setOpenPopoutLogged(boolean z2) {
        this.openPopoutLogged = z2;
    }

    public final void setUserOutputVolume(float volume) {
        this.storeMediaSettings.setUserOutputVolume(this.userId, PerceptualVolumeUtils.perceptualToAmplitude$default(PerceptualVolumeUtils.INSTANCE, volume, 0.0f, 2, null));
    }

    public final void setUserSuppressedInChannel(boolean isSuppressed) {
        Channel channel;
        WidgetUserSheetViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetUserSheetViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetUserSheetViewModel$ViewState$Loaded widgetUserSheetViewModel$ViewState$Loaded = (WidgetUserSheetViewModel$ViewState$Loaded) viewState;
        if (widgetUserSheetViewModel$ViewState$Loaded == null || (channel = widgetUserSheetViewModel$ViewState$Loaded.getStageViewState().getChannel()) == null) {
            return;
        }
        long id2 = widgetUserSheetViewModel$ViewState$Loaded.getUser().getId();
        updateViewState(WidgetUserSheetViewModel$ViewState$Loaded.copy$default(widgetUserSheetViewModel$ViewState$Loaded, null, false, false, null, null, null, null, null, null, UserProfileStageActionsView$ViewState.m51copyam1GJgw$default(widgetUserSheetViewModel$ViewState$Loaded.getStageViewState(), false, null, null, null, false, false, true, false, Opcodes.ATHROW, null), null, null, null, null, 0, null, null, null, false, null, false, null, null, null, 16776703, null));
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(StageChannelAPI.setUserSuppressedInChannel$default(StageChannelAPI.INSTANCE, channel, id2, isSuppressed, 0L, 8, null), false, 1, null), this, null, 2, null), WidgetUserSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetUserSheetViewModel$setUserSuppressedInChannel$1(this), 62, (Object) null);
    }

    public final void toggleDeafen(boolean isChecked) {
        WidgetUserSheetViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetUserSheetViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetUserSheetViewModel$ViewState$Loaded widgetUserSheetViewModel$ViewState$Loaded = (WidgetUserSheetViewModel$ViewState$Loaded) viewState;
        if (widgetUserSheetViewModel$ViewState$Loaded != null && widgetUserSheetViewModel$ViewState$Loaded.isMe() && (!m.areEqual(widgetUserSheetViewModel$ViewState$Loaded.getVoiceSettingsViewState().isDeafened(), Boolean.valueOf(isChecked)))) {
            this.storeMediaSettings.toggleSelfDeafened();
        }
    }

    public final void toggleMute(boolean isChecked) {
        WidgetUserSheetViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetUserSheetViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetUserSheetViewModel$ViewState$Loaded widgetUserSheetViewModel$ViewState$Loaded = (WidgetUserSheetViewModel$ViewState$Loaded) viewState;
        if (widgetUserSheetViewModel$ViewState$Loaded == null || widgetUserSheetViewModel$ViewState$Loaded.getVoiceSettingsViewState().isMuted() == isChecked) {
            return;
        }
        if (!widgetUserSheetViewModel$ViewState$Loaded.isMe()) {
            this.storeMediaSettings.toggleUserMuted(this.userId);
            return;
        }
        StoreMediaSettings$SelfMuteFailure storeMediaSettings$SelfMuteFailure = this.storeMediaSettings.toggleSelfMuted();
        if (storeMediaSettings$SelfMuteFailure == null || storeMediaSettings$SelfMuteFailure.ordinal() != 0) {
            return;
        }
        emitShowToastEvent(2131897019);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserSheetViewModel(long j, long j2, Long l, String str, boolean z2, Observable<WidgetUserSheetViewModel$StoreState> observable, WidgetUserSheet$StreamPreviewClickBehavior widgetUserSheet$StreamPreviewClickBehavior, StoreMediaSettings storeMediaSettings, StoreApplicationStreaming storeApplicationStreaming, StoreUserNotes storeUserNotes, StoreUserProfile storeUserProfile, RestAPI restAPI, RestAPI restAPI2, StoreApplicationStreamPreviews storeApplicationStreamPreviews, Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> parser) {
        super(WidgetUserSheetViewModel$ViewState$Uninitialized.INSTANCE);
        m.checkNotNullParameter(observable, "storeObservable");
        m.checkNotNullParameter(widgetUserSheet$StreamPreviewClickBehavior, "streamPreviewClickBehavior");
        m.checkNotNullParameter(storeMediaSettings, "storeMediaSettings");
        m.checkNotNullParameter(storeApplicationStreaming, "storeApplicationStreaming");
        m.checkNotNullParameter(storeUserNotes, "storeUserNotes");
        m.checkNotNullParameter(storeUserProfile, "storeUserProfile");
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(restAPI2, "restAPISerializeNulls");
        m.checkNotNullParameter(storeApplicationStreamPreviews, "storeApplicationStreamPreviews");
        m.checkNotNullParameter(parser, "bioParser");
        this.userId = j;
        this.channelId = j2;
        this.guildId = l;
        this.friendToken = str;
        this.isVoiceContext = z2;
        this.streamPreviewClickBehavior = widgetUserSheet$StreamPreviewClickBehavior;
        this.storeMediaSettings = storeMediaSettings;
        this.storeApplicationStreaming = storeApplicationStreaming;
        this.storeUserNotes = storeUserNotes;
        this.storeUserProfile = storeUserProfile;
        this.restAPI = restAPI;
        this.restAPISerializeNulls = restAPI2;
        this.storeApplicationStreamPreviews = storeApplicationStreamPreviews;
        this.bioParser = parser;
        this.eventSubject = PublishSubject.k0();
        this.fetchedPreviews = new LinkedHashSet();
        this.revealedBioIndices = new LinkedHashSet();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), WidgetUserSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetUserSheetViewModel$1(this), 62, (Object) null);
        storeUserNotes.loadNote(j);
        StoreUserProfile.fetchProfile$default(storeUserProfile, j, l, false, null, 12, null);
    }
}
