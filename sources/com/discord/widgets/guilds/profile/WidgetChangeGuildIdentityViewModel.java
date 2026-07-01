package com.discord.widgets.guilds.profile;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.api.guildmember.PatchGuildMemberBody;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.nullserializable.NullSerializable;
import com.discord.nullserializable.NullSerializable$a;
import com.discord.nullserializable.NullSerializable$b;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetChangeGuildIdentityViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeGuildIdentityViewModel extends d0<WidgetChangeGuildIdentityViewModel$ViewState> {
    public static final WidgetChangeGuildIdentityViewModel$Companion Companion = new WidgetChangeGuildIdentityViewModel$Companion(null);
    private final PublishSubject<WidgetChangeGuildIdentityViewModel$Event> eventSubject;
    private final long guildId;
    private final RestAPI restAPI;
    private final String sourceSection;
    private boolean trackedModalOpen;
    private boolean trackedUpsell;

    public /* synthetic */ WidgetChangeGuildIdentityViewModel(long j, String str, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, (i & 4) != 0 ? RestAPI.Companion.getApi() : restAPI);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(WidgetChangeGuildIdentityViewModel widgetChangeGuildIdentityViewModel) {
        return widgetChangeGuildIdentityViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetChangeGuildIdentityViewModel widgetChangeGuildIdentityViewModel, WidgetChangeGuildIdentityViewModel$StoreState widgetChangeGuildIdentityViewModel$StoreState) {
        widgetChangeGuildIdentityViewModel.handleStoreState(widgetChangeGuildIdentityViewModel$StoreState);
    }

    public static final /* synthetic */ void access$updateViewState(WidgetChangeGuildIdentityViewModel widgetChangeGuildIdentityViewModel, WidgetChangeGuildIdentityViewModel$ViewState widgetChangeGuildIdentityViewModel$ViewState) {
        widgetChangeGuildIdentityViewModel.updateViewState(widgetChangeGuildIdentityViewModel$ViewState);
    }

    @MainThread
    private final void handleStoreState(WidgetChangeGuildIdentityViewModel$StoreState storeState) {
        String nick;
        NullSerializable<String> currentAvatar;
        Guild guild = storeState.getGuild();
        GuildMember member = storeState.getMember();
        MeUser meUser = storeState.getMeUser();
        GuildChannelsInfo guildChannelsInfo = storeState.getGuildChannelsInfo();
        if (guild == null || member == null) {
            return;
        }
        WidgetChangeGuildIdentityViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetChangeGuildIdentityViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetChangeGuildIdentityViewModel$ViewState$Loaded widgetChangeGuildIdentityViewModel$ViewState$Loaded = (WidgetChangeGuildIdentityViewModel$ViewState$Loaded) viewState;
        if (widgetChangeGuildIdentityViewModel$ViewState$Loaded == null || (nick = widgetChangeGuildIdentityViewModel$ViewState$Loaded.getCurrentNickname()) == null) {
            nick = member.getNick();
        }
        String str = nick;
        WidgetChangeGuildIdentityViewModel$ViewState viewState2 = getViewState();
        if (!(viewState2 instanceof WidgetChangeGuildIdentityViewModel$ViewState$Loaded)) {
            viewState2 = null;
        }
        WidgetChangeGuildIdentityViewModel$ViewState$Loaded widgetChangeGuildIdentityViewModel$ViewState$Loaded2 = (WidgetChangeGuildIdentityViewModel$ViewState$Loaded) viewState2;
        updateViewState(new WidgetChangeGuildIdentityViewModel$ViewState$Loaded(guild, meUser, member, guildChannelsInfo.getCanChangeNickname(), str, (widgetChangeGuildIdentityViewModel$ViewState$Loaded2 == null || (currentAvatar = widgetChangeGuildIdentityViewModel$ViewState$Loaded2.getCurrentAvatar()) == null) ? null : currentAvatar, false, 64, null));
    }

    @MainThread
    public final void clearStatus() {
        WidgetChangeGuildIdentityViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetChangeGuildIdentityViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetChangeGuildIdentityViewModel$ViewState$Loaded widgetChangeGuildIdentityViewModel$ViewState$Loaded = (WidgetChangeGuildIdentityViewModel$ViewState$Loaded) viewState;
        if (widgetChangeGuildIdentityViewModel$ViewState$Loaded != null) {
            updateViewState(WidgetChangeGuildIdentityViewModel$ViewState$Loaded.copy$default(widgetChangeGuildIdentityViewModel$ViewState$Loaded, null, null, null, false, "", null, false, 111, null));
        }
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final String getSourceSection() {
        return this.sourceSection;
    }

    public final boolean getTrackedModalOpen() {
        return this.trackedModalOpen;
    }

    public final boolean getTrackedUpsell() {
        return this.trackedUpsell;
    }

    public final Observable<WidgetChangeGuildIdentityViewModel$Event> observeEvents() {
        return this.eventSubject;
    }

    @MainThread
    public final void saveMemberChanges(Context context) {
        m.checkNotNullParameter(context, "context");
        WidgetChangeGuildIdentityViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetChangeGuildIdentityViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetChangeGuildIdentityViewModel$ViewState$Loaded widgetChangeGuildIdentityViewModel$ViewState$Loaded = (WidgetChangeGuildIdentityViewModel$ViewState$Loaded) viewState;
        if (widgetChangeGuildIdentityViewModel$ViewState$Loaded != null) {
            updateViewState(WidgetChangeGuildIdentityViewModel$ViewState$Loaded.copy$default(widgetChangeGuildIdentityViewModel$ViewState$Loaded, null, null, null, false, null, null, true, 63, null));
            RestAPI restAPI = this.restAPI;
            long id2 = widgetChangeGuildIdentityViewModel$ViewState$Loaded.getGuild().getId();
            String currentNickname = widgetChangeGuildIdentityViewModel$ViewState$Loaded.getCurrentNickname();
            String nick = widgetChangeGuildIdentityViewModel$ViewState$Loaded.getMember().getNick();
            if (nick == null) {
                nick = "";
            }
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(restAPI.updateMeGuildMember(id2, new PatchGuildMemberBody(m.areEqual(currentNickname, nick) ^ true ? widgetChangeGuildIdentityViewModel$ViewState$Loaded.getCurrentNickname() : null, widgetChangeGuildIdentityViewModel$ViewState$Loaded.getCurrentAvatar(), null, null, 12)), false, 1, null), this, null, 2, null), WidgetChangeGuildIdentityViewModel.class, context, (Function1) null, new WidgetChangeGuildIdentityViewModel$saveMemberChanges$1(this, widgetChangeGuildIdentityViewModel$ViewState$Loaded), (Function0) null, (Function0) null, new WidgetChangeGuildIdentityViewModel$saveMemberChanges$2(this, widgetChangeGuildIdentityViewModel$ViewState$Loaded), 52, (Object) null);
        }
    }

    public final void setTrackedModalOpen(boolean z2) {
        this.trackedModalOpen = z2;
    }

    public final void setTrackedUpsell(boolean z2) {
        this.trackedUpsell = z2;
    }

    @MainThread
    public final void updateAvatar(String dataUrl) {
        WidgetChangeGuildIdentityViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetChangeGuildIdentityViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetChangeGuildIdentityViewModel$ViewState$Loaded widgetChangeGuildIdentityViewModel$ViewState$Loaded = (WidgetChangeGuildIdentityViewModel$ViewState$Loaded) viewState;
        if (widgetChangeGuildIdentityViewModel$ViewState$Loaded != null) {
            updateViewState(WidgetChangeGuildIdentityViewModel$ViewState$Loaded.copy$default(widgetChangeGuildIdentityViewModel$ViewState$Loaded, null, null, null, false, null, dataUrl != null ? new NullSerializable$b(dataUrl) : new NullSerializable$a(null, 1), false, 95, null));
        }
    }

    @MainThread
    public final void updateNickname(String nickname) {
        m.checkNotNullParameter(nickname, "nickname");
        WidgetChangeGuildIdentityViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetChangeGuildIdentityViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetChangeGuildIdentityViewModel$ViewState$Loaded widgetChangeGuildIdentityViewModel$ViewState$Loaded = (WidgetChangeGuildIdentityViewModel$ViewState$Loaded) viewState;
        if (widgetChangeGuildIdentityViewModel$ViewState$Loaded == null || !(!m.areEqual(nickname, widgetChangeGuildIdentityViewModel$ViewState$Loaded.getCurrentNickname()))) {
            return;
        }
        updateViewState(WidgetChangeGuildIdentityViewModel$ViewState$Loaded.copy$default(widgetChangeGuildIdentityViewModel$ViewState$Loaded, null, null, null, false, nickname, null, false, 111, null));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChangeGuildIdentityViewModel(long j, String str, RestAPI restAPI) {
        super(WidgetChangeGuildIdentityViewModel$ViewState$Loading.INSTANCE);
        m.checkNotNullParameter(str, "sourceSection");
        m.checkNotNullParameter(restAPI, "restAPI");
        this.guildId = j;
        this.sourceSection = str;
        this.restAPI = restAPI;
        PublishSubject<WidgetChangeGuildIdentityViewModel$Event> publishSubjectK0 = PublishSubject.k0();
        m.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.eventSubject = publishSubjectK0;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(WidgetChangeGuildIdentityViewModel$Companion.observeStoreState$default(Companion, j, null, null, 6, null)), this, null, 2, null), WidgetChangeGuildIdentityViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChangeGuildIdentityViewModel$1(this), 62, (Object) null);
    }
}
