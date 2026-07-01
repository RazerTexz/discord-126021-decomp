package com.discord.widgets.settings.profile;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.api.guildmember.PatchGuildMemberBody;
import com.discord.api.user.PatchUserBody;
import com.discord.api.user.UserProfile;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.nullserializable.NullSerializable;
import com.discord.nullserializable.NullSerializable$a;
import com.discord.nullserializable.NullSerializable$b;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserProfile;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessagePreprocessor;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import com.discord.widgets.user.profile.UserProfileHeaderViewModel$ViewState;
import d0.z.d.m;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: EditUserOrGuildMemberProfileViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsUserProfileViewModel extends d0<SettingsUserProfileViewModel$ViewState> {
    public static final SettingsUserProfileViewModel$Companion Companion = new SettingsUserProfileViewModel$Companion(null);
    private final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> bioParser;
    private final PublishSubject<SettingsUserProfileViewModel$Event> eventSubject;
    private final Long guildId;
    private final RestAPI restAPI;
    private final Set<Integer> revealedBioIndices;
    private final StoreGuilds storeGuilds;
    private final StoreUserProfile storeUserProfile;

    public /* synthetic */ SettingsUserProfileViewModel(Long l, StoreUser storeUser, StoreUserProfile storeUserProfile, StoreGuilds storeGuilds, RestAPI restAPI, Parser parser, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(l, (i & 2) != 0 ? StoreStream.Companion.getUsers() : storeUser, (i & 4) != 0 ? StoreStream.Companion.getUserProfile() : storeUserProfile, (i & 8) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds, (i & 16) != 0 ? RestAPI.Companion.getApi() : restAPI, (i & 32) != 0 ? DiscordParser.createParser$default(false, false, false, false, false, 28, null) : parser, (i & 64) != 0 ? SettingsUserProfileViewModel$Companion.observeStoreState$default(Companion, l, null, null, null, 14, null) : observable);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(SettingsUserProfileViewModel settingsUserProfileViewModel) {
        return settingsUserProfileViewModel.eventSubject;
    }

    public static final /* synthetic */ Long access$getGuildId$p(SettingsUserProfileViewModel settingsUserProfileViewModel) {
        return settingsUserProfileViewModel.guildId;
    }

    public static final /* synthetic */ StoreGuilds access$getStoreGuilds$p(SettingsUserProfileViewModel settingsUserProfileViewModel) {
        return settingsUserProfileViewModel.storeGuilds;
    }

    public static final /* synthetic */ StoreUserProfile access$getStoreUserProfile$p(SettingsUserProfileViewModel settingsUserProfileViewModel) {
        return settingsUserProfileViewModel.storeUserProfile;
    }

    public static final /* synthetic */ void access$handleStoreState(SettingsUserProfileViewModel settingsUserProfileViewModel, SettingsUserProfileViewModel$StoreState settingsUserProfileViewModel$StoreState) {
        settingsUserProfileViewModel.handleStoreState(settingsUserProfileViewModel$StoreState);
    }

    public static final /* synthetic */ void access$updateViewState(SettingsUserProfileViewModel settingsUserProfileViewModel, SettingsUserProfileViewModel$ViewState settingsUserProfileViewModel$ViewState) {
        settingsUserProfileViewModel.updateViewState(settingsUserProfileViewModel$ViewState);
    }

    private final List<Node<MessageRenderContext>> createAndProcessBioAstFromText(String bio) {
        List<Node<MessageRenderContext>> bio2 = parseBio(bio);
        createMessagePreprocessor().process(bio2);
        return bio2;
    }

    private final MessagePreprocessor createMessagePreprocessor() {
        return new MessagePreprocessor(-1L, this.revealedBioIndices, null, false, null, 28, null);
    }

    @MainThread
    private final void handleStoreState(SettingsUserProfileViewModel$StoreState storeState) {
        String bio;
        String str;
        MeUser user = storeState.getUser();
        SettingsUserProfileViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof SettingsUserProfileViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        SettingsUserProfileViewModel$ViewState$Loaded settingsUserProfileViewModel$ViewState$Loaded = (SettingsUserProfileViewModel$ViewState$Loaded) viewState;
        if (settingsUserProfileViewModel$ViewState$Loaded == null || (bio = settingsUserProfileViewModel$ViewState$Loaded.getCurrentBio()) == null) {
            GuildMember meMember = storeState.getMeMember();
            if (meMember != null) {
                bio = meMember.getBio();
                if (bio == null) {
                    bio = "";
                }
            } else {
                bio = null;
            }
        }
        if (bio == null) {
            bio = user.getBio();
        }
        String str2 = bio;
        List<Node<MessageRenderContext>> listCreateAndProcessBioAstFromText = str2 != null ? createAndProcessBioAstFromText(str2) : null;
        SettingsUserProfileViewModel$ViewState viewState2 = getViewState();
        if (!(viewState2 instanceof SettingsUserProfileViewModel$ViewState$Loaded)) {
            viewState2 = null;
        }
        SettingsUserProfileViewModel$ViewState$Loaded settingsUserProfileViewModel$ViewState$Loaded2 = (SettingsUserProfileViewModel$ViewState$Loaded) viewState2;
        if (settingsUserProfileViewModel$ViewState$Loaded2 == null || (nick = settingsUserProfileViewModel$ViewState$Loaded2.getCurrentNickname()) == null) {
            GuildMember meMember2 = storeState.getMeMember();
            if (meMember2 != null) {
                String nick = meMember2.getNick();
                str = nick;
            } else {
                str = null;
            }
        } else {
            str = nick;
        }
        Guild guild = storeState.getGuild();
        UserProfile userProfile = storeState.getUserProfile();
        SettingsUserProfileViewModel$ViewState viewState3 = getViewState();
        SettingsUserProfileViewModel$ViewState$Loaded settingsUserProfileViewModel$ViewState$Loaded3 = (SettingsUserProfileViewModel$ViewState$Loaded) (viewState3 instanceof SettingsUserProfileViewModel$ViewState$Loaded ? viewState3 : null);
        updateViewState(new SettingsUserProfileViewModel$ViewState$Loaded(user, guild, storeState.getMeMember(), userProfile, null, null, null, str, str2, listCreateAndProcessBioAstFromText, settingsUserProfileViewModel$ViewState$Loaded3 != null ? settingsUserProfileViewModel$ViewState$Loaded3.isEditingBio() : false, storeState.getGuildChannelsInfo().getCanChangeNickname(), 112, null));
    }

    private final List<Node<MessageRenderContext>> parseBio(String bio) {
        return Parser.parse$default(this.bioParser, bio, MessageParseState.Companion.getInitialState(), null, 4, null);
    }

    @MainThread
    private final void saveGuildMemberChanges(Context context) {
        Long l;
        SettingsUserProfileViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof SettingsUserProfileViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        SettingsUserProfileViewModel$ViewState$Loaded settingsUserProfileViewModel$ViewState$Loaded = (SettingsUserProfileViewModel$ViewState$Loaded) viewState;
        if (settingsUserProfileViewModel$ViewState$Loaded == null || (l = this.guildId) == null) {
            return;
        }
        l.longValue();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.updateMeGuildMember(this.guildId.longValue(), new PatchGuildMemberBody(settingsUserProfileViewModel$ViewState$Loaded.getCurrentNickname(), settingsUserProfileViewModel$ViewState$Loaded.getCurrentAvatar(), settingsUserProfileViewModel$ViewState$Loaded.getCurrentBannerImage(), settingsUserProfileViewModel$ViewState$Loaded.getCurrentBio())), false, 1, null), this, null, 2, null), SettingsUserProfileViewModel.class, context, (Function1) null, new SettingsUserProfileViewModel$saveGuildMemberChanges$1(this), (Function0) null, (Function0) null, new SettingsUserProfileViewModel$saveGuildMemberChanges$2(this, settingsUserProfileViewModel$ViewState$Loaded), 52, (Object) null);
    }

    @MainThread
    private final void saveUserChanges(Context context) {
        NullSerializable nullSerializable$b;
        SettingsUserProfileViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof SettingsUserProfileViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        SettingsUserProfileViewModel$ViewState$Loaded settingsUserProfileViewModel$ViewState$Loaded = (SettingsUserProfileViewModel$ViewState$Loaded) viewState;
        if (settingsUserProfileViewModel$ViewState$Loaded != null) {
            MeUser user = settingsUserProfileViewModel$ViewState$Loaded.getUser();
            String currentBio = settingsUserProfileViewModel$ViewState$Loaded.getCurrentBio();
            if (settingsUserProfileViewModel$ViewState$Loaded.getIsBioChanged()) {
                nullSerializable$b = currentBio != null ? new NullSerializable$b(currentBio) : new NullSerializable$a(null, 1);
            } else {
                nullSerializable$b = null;
            }
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.patchUser(new PatchUserBody(settingsUserProfileViewModel$ViewState$Loaded.getCurrentAvatar(), settingsUserProfileViewModel$ViewState$Loaded.getCurrentBannerImage(), settingsUserProfileViewModel$ViewState$Loaded.getCurrentBannerColorHex(), nullSerializable$b)), false, 1, null), this, null, 2, null), SettingsUserProfileViewModel.class, context, (Function1) null, new SettingsUserProfileViewModel$saveUserChanges$1(this), (Function0) null, (Function0) null, new SettingsUserProfileViewModel$saveUserChanges$2(this, user, settingsUserProfileViewModel$ViewState$Loaded), 52, (Object) null);
        }
    }

    @MainThread
    public final void handleBioIndexClicked(SpoilerNode<?> spoilerNode) {
        String currentBio;
        m.checkNotNullParameter(spoilerNode, "spoilerNode");
        SettingsUserProfileViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof SettingsUserProfileViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        SettingsUserProfileViewModel$ViewState$Loaded settingsUserProfileViewModel$ViewState$Loaded = (SettingsUserProfileViewModel$ViewState$Loaded) viewState;
        if (settingsUserProfileViewModel$ViewState$Loaded == null || (currentBio = settingsUserProfileViewModel$ViewState$Loaded.getCurrentBio()) == null) {
            return;
        }
        this.revealedBioIndices.add(Integer.valueOf(spoilerNode.getId()));
        updateViewState(SettingsUserProfileViewModel$ViewState$Loaded.copy$default(settingsUserProfileViewModel$ViewState$Loaded, null, null, null, null, null, null, null, null, null, createAndProcessBioAstFromText(currentBio), false, false, 3583, null));
    }

    public final Observable<SettingsUserProfileViewModel$Event> observeEvents() {
        PublishSubject<SettingsUserProfileViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final Observable<UserProfileHeaderViewModel$ViewState> observeHeaderViewState() {
        Observable<UserProfileHeaderViewModel$ViewState> observableR = observeViewState().G(SettingsUserProfileViewModel$observeHeaderViewState$1.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "observeViewState().map {… }.distinctUntilChanged()");
        return observableR;
    }

    @MainThread
    public final void saveChanges(Context context) {
        m.checkNotNullParameter(context, "context");
        if (this.guildId != null) {
            saveGuildMemberChanges(context);
        } else {
            saveUserChanges(context);
        }
    }

    @MainThread
    public final void updateAvatar(String dataUrl) {
        SettingsUserProfileViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof SettingsUserProfileViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        SettingsUserProfileViewModel$ViewState$Loaded settingsUserProfileViewModel$ViewState$Loaded = (SettingsUserProfileViewModel$ViewState$Loaded) viewState;
        if (settingsUserProfileViewModel$ViewState$Loaded != null) {
            updateViewState(SettingsUserProfileViewModel$ViewState$Loaded.copy$default(settingsUserProfileViewModel$ViewState$Loaded, null, null, null, null, dataUrl != null ? new NullSerializable$b(dataUrl) : new NullSerializable$a(null, 1), null, null, null, null, null, false, false, 4079, null));
        }
    }

    @MainThread
    public final void updateBannerColor(String colorHex) {
        SettingsUserProfileViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof SettingsUserProfileViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        SettingsUserProfileViewModel$ViewState$Loaded settingsUserProfileViewModel$ViewState$Loaded = (SettingsUserProfileViewModel$ViewState$Loaded) viewState;
        if (settingsUserProfileViewModel$ViewState$Loaded != null) {
            updateViewState(SettingsUserProfileViewModel$ViewState$Loaded.copy$default(settingsUserProfileViewModel$ViewState$Loaded, null, null, null, null, null, null, colorHex != null ? new NullSerializable$b(colorHex) : new NullSerializable$a(null, 1), null, null, null, false, false, 4031, null));
        }
    }

    @MainThread
    public final void updateBannerImage(String dataUrl) {
        SettingsUserProfileViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof SettingsUserProfileViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        SettingsUserProfileViewModel$ViewState$Loaded settingsUserProfileViewModel$ViewState$Loaded = (SettingsUserProfileViewModel$ViewState$Loaded) viewState;
        if (settingsUserProfileViewModel$ViewState$Loaded != null) {
            updateViewState(SettingsUserProfileViewModel$ViewState$Loaded.copy$default(settingsUserProfileViewModel$ViewState$Loaded, null, null, null, null, null, dataUrl != null ? new NullSerializable$b(dataUrl) : new NullSerializable$a(null, 1), null, null, null, null, false, false, 4063, null));
        }
    }

    @MainThread
    public final void updateBio(String bio) {
        m.checkNotNullParameter(bio, "bio");
        SettingsUserProfileViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof SettingsUserProfileViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        SettingsUserProfileViewModel$ViewState$Loaded settingsUserProfileViewModel$ViewState$Loaded = (SettingsUserProfileViewModel$ViewState$Loaded) viewState;
        if (settingsUserProfileViewModel$ViewState$Loaded != null && (!m.areEqual(bio, settingsUserProfileViewModel$ViewState$Loaded.getCurrentBio()))) {
            updateViewState(SettingsUserProfileViewModel$ViewState$Loaded.copy$default(settingsUserProfileViewModel$ViewState$Loaded, null, null, null, null, null, null, null, null, bio, createAndProcessBioAstFromText(bio), false, false, 3327, null));
        }
    }

    @MainThread
    public final void updateIsEditingBio(boolean isEditing) {
        SettingsUserProfileViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof SettingsUserProfileViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        SettingsUserProfileViewModel$ViewState$Loaded settingsUserProfileViewModel$ViewState$Loaded = (SettingsUserProfileViewModel$ViewState$Loaded) viewState;
        if (settingsUserProfileViewModel$ViewState$Loaded != null) {
            updateViewState(SettingsUserProfileViewModel$ViewState$Loaded.copy$default(settingsUserProfileViewModel$ViewState$Loaded, null, null, null, null, null, null, null, null, null, null, isEditing, false, 3071, null));
        }
    }

    @MainThread
    public final void updateNickname(String nick) {
        m.checkNotNullParameter(nick, ModelAuditLogEntry.CHANGE_KEY_NICK);
        SettingsUserProfileViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof SettingsUserProfileViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        SettingsUserProfileViewModel$ViewState$Loaded settingsUserProfileViewModel$ViewState$Loaded = (SettingsUserProfileViewModel$ViewState$Loaded) viewState;
        if (settingsUserProfileViewModel$ViewState$Loaded != null) {
            updateViewState(SettingsUserProfileViewModel$ViewState$Loaded.copy$default(settingsUserProfileViewModel$ViewState$Loaded, null, null, null, null, null, null, null, nick, null, null, false, false, 3967, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsUserProfileViewModel(Long l, StoreUser storeUser, StoreUserProfile storeUserProfile, StoreGuilds storeGuilds, RestAPI restAPI, Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> parser, Observable<SettingsUserProfileViewModel$StoreState> observable) {
        super(null);
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(storeUserProfile, "storeUserProfile");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(parser, "bioParser");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = l;
        this.storeUserProfile = storeUserProfile;
        this.storeGuilds = storeGuilds;
        this.restAPI = restAPI;
        this.bioParser = parser;
        this.eventSubject = PublishSubject.k0();
        Observable observableZ = ObservableExtensionsKt.computationLatest(storeUser.observeMe(false)).Z(1);
        m.checkNotNullExpressionValue(observableZ, "storeUser.observeMe(emit…Latest()\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableZ, this, null, 2, null), SettingsUserProfileViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new SettingsUserProfileViewModel$1(this), 62, (Object) null);
        Observable<SettingsUserProfileViewModel$StoreState> observableR = observable.r();
        m.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), SettingsUserProfileViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new SettingsUserProfileViewModel$2(this), 62, (Object) null);
        this.revealedBioIndices = new LinkedHashSet();
    }
}
