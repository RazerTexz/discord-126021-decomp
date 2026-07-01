package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.content.res.Resources;
import b.a.d.d0;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelInvite$Settings;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreInstantInvites;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreStageInstances;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableCombineLatestOverloadsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guilds.invite.InviteGenerator;
import com.discord.widgets.guilds.invite.WidgetInviteModel;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGuildScheduledEventCreateSuccessViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventCreateSuccessViewModel extends d0<WidgetGuildScheduledEventCreateSuccessViewModel$ViewState> {
    private final Long channelId;
    private final long guildId;
    private final long guildScheduledEventId;
    private final InviteGenerator inviteGenerator;
    private final Resources resources;
    private final StoreChannels storeChannels;
    private final StoreGuildScheduledEvents storeGuildScheduledEvents;
    private final StoreGuilds storeGuilds;
    private final StoreInstantInvites storeInstantInvites;
    private final StoreInviteSettings storeInviteSettings;
    private final StoreStageInstances storeStageInstances;
    private final StoreUser storeUser;

    public /* synthetic */ WidgetGuildScheduledEventCreateSuccessViewModel(Long l, long j, long j2, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreInviteSettings storeInviteSettings, StoreUser storeUser, StoreStageInstances storeStageInstances, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreInstantInvites storeInstantInvites, InviteGenerator inviteGenerator, Resources resources, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(l, j, j2, (i & 8) != 0 ? StoreStream.Companion.getChannels() : storeChannels, (i & 16) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds, (i & 32) != 0 ? StoreStream.Companion.getInviteSettings() : storeInviteSettings, (i & 64) != 0 ? StoreStream.Companion.getUsers() : storeUser, (i & 128) != 0 ? StoreStream.Companion.getStageInstances() : storeStageInstances, (i & 256) != 0 ? StoreStream.Companion.getGuildScheduledEvents() : storeGuildScheduledEvents, (i & 512) != 0 ? StoreStream.Companion.getInstantInvites() : storeInstantInvites, (i & 1024) != 0 ? new InviteGenerator() : inviteGenerator, resources);
    }

    public static final /* synthetic */ void access$generateInviteLinkFromViewState(WidgetGuildScheduledEventCreateSuccessViewModel widgetGuildScheduledEventCreateSuccessViewModel, WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded widgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded) {
        widgetGuildScheduledEventCreateSuccessViewModel.generateInviteLinkFromViewState(widgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded);
    }

    public static final /* synthetic */ InviteGenerator access$getInviteGenerator$p(WidgetGuildScheduledEventCreateSuccessViewModel widgetGuildScheduledEventCreateSuccessViewModel) {
        return widgetGuildScheduledEventCreateSuccessViewModel.inviteGenerator;
    }

    public static final /* synthetic */ void access$updateViewState(WidgetGuildScheduledEventCreateSuccessViewModel widgetGuildScheduledEventCreateSuccessViewModel, WidgetGuildScheduledEventCreateSuccessViewModel$ViewState widgetGuildScheduledEventCreateSuccessViewModel$ViewState) {
        widgetGuildScheduledEventCreateSuccessViewModel.updateViewState(widgetGuildScheduledEventCreateSuccessViewModel$ViewState);
    }

    private final void generateInviteLinkFromViewState(WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded viewState) {
        WidgetInviteModel widgetInviteModel = viewState.getWidgetInviteModel();
        if (widgetInviteModel.isValidInvite() || widgetInviteModel.isGeneratingInvite() || widgetInviteModel.getTargetChannel() == null) {
            return;
        }
        this.inviteGenerator.generateForAppComponent(this, widgetInviteModel.getTargetChannel().getId());
    }

    private final Observable<WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded> observeInvite(long guildId, Long eventId, String inviteStoreKey) {
        Observable<WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded> observableR = ObservableExtensionsKt.computationLatest(ObservableCombineLatestOverloadsKt.combineLatest(this.storeInviteSettings.getInviteSettings(), this.storeInviteSettings.getInvitableChannels(guildId), this.inviteGenerator.getGenerationState(), StoreUser.observeMe$default(this.storeUser, false, 1, null), this.storeChannels.observeDMs(), this.storeGuilds.observeGuild(guildId), this.storeStageInstances.observeStageInstancesForGuild(guildId), this.storeGuildScheduledEvents.observeGuildScheduledEvent(eventId, Long.valueOf(guildId)), this.storeInstantInvites.observeInvite(inviteStoreKey), this.storeChannels.observeDefaultChannel(guildId), WidgetGuildScheduledEventCreateSuccessViewModel$observeInvite$1.INSTANCE)).r();
        m.checkNotNullExpressionValue(observableR, "combineLatest(\n        s…  .distinctUntilChanged()");
        return observableR;
    }

    public final void generateInviteLink(Long channelId) {
        Observable<Channel> observableZ = this.storeChannels.observeDefaultChannel(this.guildId).z();
        m.checkNotNullExpressionValue(observableZ, "storeChannels.observeDef…tChannel(guildId).first()");
        ObservableExtensionsKt.appSubscribe$default(observableZ, WidgetGuildScheduledEventCreateSuccessViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildScheduledEventCreateSuccessViewModel$generateInviteLink$1(this, channelId), 62, (Object) null);
    }

    public final Long getChannelId() {
        return this.channelId;
    }

    public final Experiment getDefaultInviteExperiment() {
        return this.storeInviteSettings.getInviteGuildExperiment(this.guildId, true);
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final long getGuildScheduledEventId() {
        return this.guildScheduledEventId;
    }

    public final Resources getResources() {
        return this.resources;
    }

    public final StoreChannels getStoreChannels() {
        return this.storeChannels;
    }

    public final StoreGuildScheduledEvents getStoreGuildScheduledEvents() {
        return this.storeGuildScheduledEvents;
    }

    public final StoreGuilds getStoreGuilds() {
        return this.storeGuilds;
    }

    public final StoreInstantInvites getStoreInstantInvites() {
        return this.storeInstantInvites;
    }

    public final StoreInviteSettings getStoreInviteSettings() {
        return this.storeInviteSettings;
    }

    public final StoreStageInstances getStoreStageInstances() {
        return this.storeStageInstances;
    }

    public final StoreUser getStoreUser() {
        return this.storeUser;
    }

    public final void updateInviteSettings(ModelInvite$Settings settings) {
        m.checkNotNullParameter(settings, "settings");
        this.storeInviteSettings.setInviteSettings(settings);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventCreateSuccessViewModel(Long l, long j, long j2, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreInviteSettings storeInviteSettings, StoreUser storeUser, StoreStageInstances storeStageInstances, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreInstantInvites storeInstantInvites, InviteGenerator inviteGenerator, Resources resources) {
        super(WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Uninitialized.INSTANCE);
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storeInviteSettings, "storeInviteSettings");
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(storeStageInstances, "storeStageInstances");
        m.checkNotNullParameter(storeGuildScheduledEvents, "storeGuildScheduledEvents");
        m.checkNotNullParameter(storeInstantInvites, "storeInstantInvites");
        m.checkNotNullParameter(inviteGenerator, "inviteGenerator");
        m.checkNotNullParameter(resources, "resources");
        this.channelId = l;
        this.guildId = j;
        this.guildScheduledEventId = j2;
        this.storeChannels = storeChannels;
        this.storeGuilds = storeGuilds;
        this.storeInviteSettings = storeInviteSettings;
        this.storeUser = storeUser;
        this.storeStageInstances = storeStageInstances;
        this.storeGuildScheduledEvents = storeGuildScheduledEvents;
        this.storeInstantInvites = storeInstantInvites;
        this.inviteGenerator = inviteGenerator;
        this.resources = resources;
        Observable<WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded> observableU = observeInvite(j, Long.valueOf(j2), null).u(new WidgetGuildScheduledEventCreateSuccessViewModel$1(this));
        m.checkNotNullExpressionValue(observableU, "observeInvite(guildId, g…romViewState(viewState) }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableU), this, null, 2, null), WidgetGuildScheduledEventCreateSuccessViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildScheduledEventCreateSuccessViewModel$2(this), 62, (Object) null);
    }
}
