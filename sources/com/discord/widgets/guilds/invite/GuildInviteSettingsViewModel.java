package com.discord.widgets.guilds.invite;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelInvite;
import com.discord.models.domain.ModelInvite$Settings;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.u;
import d0.z.d.m;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: GuildInviteSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildInviteSettingsViewModel extends d0<GuildInviteSettingsViewModel$ViewState> {
    public static final GuildInviteSettingsViewModel$Companion Companion = new GuildInviteSettingsViewModel$Companion(null);
    private final Long channelId;
    private GuildInviteSettingsViewModel$StoreState currentStoreState;
    private PublishSubject<GuildInviteSettingsViewModel$Event> eventSubject;
    private final long guildId;
    private ModelInvite$Settings inviteSettings;
    private final StoreInviteSettings storeInviteSettings;
    private Channel targetChannel;
    private final TargetChannelSelector targetChannelSelector;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GuildInviteSettingsViewModel(Long l, long j, StoreInviteSettings storeInviteSettings, TargetChannelSelector targetChannelSelector, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreInviteSettings inviteSettings = (i & 4) != 0 ? StoreStream.Companion.getInviteSettings() : storeInviteSettings;
        this(l, j, inviteSettings, (i & 8) != 0 ? new TargetChannelSelector() : targetChannelSelector, (i & 16) != 0 ? GuildInviteSettingsViewModel$Companion.access$observeStoreState(Companion, j, inviteSettings) : observable);
    }

    public static final /* synthetic */ void access$handleInviteCreationFailure(GuildInviteSettingsViewModel guildInviteSettingsViewModel) {
        guildInviteSettingsViewModel.handleInviteCreationFailure();
    }

    public static final /* synthetic */ void access$handleInviteCreationSuccess(GuildInviteSettingsViewModel guildInviteSettingsViewModel, ModelInvite modelInvite) {
        guildInviteSettingsViewModel.handleInviteCreationSuccess(modelInvite);
    }

    public static final /* synthetic */ void access$handleStoreState(GuildInviteSettingsViewModel guildInviteSettingsViewModel, GuildInviteSettingsViewModel$StoreState guildInviteSettingsViewModel$StoreState) {
        guildInviteSettingsViewModel.handleStoreState(guildInviteSettingsViewModel$StoreState);
    }

    private final void generateInviteForChannel(long targetChannelId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(StoreInviteSettings.generateInvite$default(this.storeInviteSettings, targetChannelId, null, 2, null), false, 1, null), this, null, 2, null), GuildInviteSettingsViewModel.class, (Context) null, (Function1) null, new GuildInviteSettingsViewModel$generateInviteForChannel$2(this), (Function0) null, (Function0) null, new GuildInviteSettingsViewModel$generateInviteForChannel$1(this), 54, (Object) null);
    }

    @MainThread
    private final void handleInviteCreationFailure() {
        PublishSubject<GuildInviteSettingsViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(GuildInviteSettingsViewModel$Event$InviteCreationFailure.INSTANCE);
    }

    @MainThread
    private final void handleInviteCreationSuccess(ModelInvite invite) {
        GuildInvite guildInviteCreateFromModelInvite = GuildInvite.Companion.createFromModelInvite(invite);
        PublishSubject<GuildInviteSettingsViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new GuildInviteSettingsViewModel$Event$InviteCreationSuccess(guildInviteCreateFromModelInvite));
    }

    @MainThread
    private final void handleStoreState(GuildInviteSettingsViewModel$StoreState storeState) {
        ModelInvite$Settings inviteSettings = this.inviteSettings;
        if (inviteSettings == null) {
            this.inviteSettings = storeState.getInviteSettings();
            inviteSettings = storeState.getInviteSettings();
        }
        Map<Long, Channel> invitableChannels = storeState.getInvitableChannels();
        Channel targetChannel = this.targetChannel;
        if (targetChannel == null) {
            targetChannel = this.targetChannelSelector.getTargetChannel(invitableChannels, this.channelId);
            this.targetChannel = targetChannel;
        }
        updateViewState(new GuildInviteSettingsViewModel$ViewState(u.toList(invitableChannels.values()), inviteSettings, targetChannel));
        this.currentStoreState = storeState;
    }

    public final Observable<GuildInviteSettingsViewModel$Event> observeEvents() {
        return this.eventSubject;
    }

    @MainThread
    public final void saveInviteSettings() {
        Channel channel;
        ModelInvite$Settings modelInvite$Settings = this.inviteSettings;
        if (modelInvite$Settings == null || (channel = this.targetChannel) == null) {
            return;
        }
        this.storeInviteSettings.setInviteSettings(modelInvite$Settings);
        generateInviteForChannel(channel.getId());
    }

    @MainThread
    public final void selectChannel(Channel channel) {
        GuildInviteSettingsViewModel$ViewState viewState = getViewState();
        if (viewState == null || channel == null) {
            return;
        }
        this.targetChannel = channel;
        updateViewState(GuildInviteSettingsViewModel$ViewState.copy$default(viewState, null, null, channel, 3, null));
    }

    @MainThread
    public final void updatePendingInviteSettings(ModelInvite$Settings settings) {
        m.checkNotNullParameter(settings, "settings");
        GuildInviteSettingsViewModel$ViewState viewState = getViewState();
        if (viewState != null) {
            this.inviteSettings = settings;
            updateViewState(GuildInviteSettingsViewModel$ViewState.copy$default(viewState, null, settings, null, 5, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildInviteSettingsViewModel(Long l, long j, StoreInviteSettings storeInviteSettings, TargetChannelSelector targetChannelSelector, Observable<GuildInviteSettingsViewModel$StoreState> observable) {
        super(null, 1, null);
        m.checkNotNullParameter(storeInviteSettings, "storeInviteSettings");
        m.checkNotNullParameter(targetChannelSelector, "targetChannelSelector");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = l;
        this.guildId = j;
        this.storeInviteSettings = storeInviteSettings;
        this.targetChannelSelector = targetChannelSelector;
        PublishSubject<GuildInviteSettingsViewModel$Event> publishSubjectK0 = PublishSubject.k0();
        m.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.eventSubject = publishSubjectK0;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), GuildInviteSettingsViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GuildInviteSettingsViewModel$1(this), 62, (Object) null);
    }
}
