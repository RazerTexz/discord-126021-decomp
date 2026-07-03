package com.discord.widgets.guildscheduledevent;

import android.content.res.Resources;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.domain.ModelInvite;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreInstantInvites;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreStageInstances;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableCombineLatestOverloadsKt;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.widgets.guilds.invite.InviteGenerator;
import com.discord.widgets.guilds.invite.WidgetInviteModel;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: WidgetGuildScheduledEventCreateSuccessViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventCreateSuccessViewModel extends AbstractC0859d0<ViewState> {
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

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccessViewModel$2 */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventCreateSuccessViewModel.kt */
    public static final /* synthetic */ class C88532 extends C12236k implements Function1<ViewState, Unit> {
        public C88532(WidgetGuildScheduledEventCreateSuccessViewModel widgetGuildScheduledEventCreateSuccessViewModel) {
            super(1, widgetGuildScheduledEventCreateSuccessViewModel, WidgetGuildScheduledEventCreateSuccessViewModel.class, "updateViewState", "updateViewState(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetGuildScheduledEventCreateSuccessViewModel) this.receiver).updateViewState(viewState);
        }
    }

    /* JADX INFO: compiled from: WidgetGuildScheduledEventCreateSuccessViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: WidgetGuildScheduledEventCreateSuccessViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final boolean showInviteSettings;
            private final WidgetInviteModel widgetInviteModel;

            public /* synthetic */ Loaded(WidgetInviteModel widgetInviteModel, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(widgetInviteModel, (i & 2) != 0 ? true : z2);
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, WidgetInviteModel widgetInviteModel, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    widgetInviteModel = loaded.widgetInviteModel;
                }
                if ((i & 2) != 0) {
                    z2 = loaded.showInviteSettings;
                }
                return loaded.copy(widgetInviteModel, z2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final WidgetInviteModel getWidgetInviteModel() {
                return this.widgetInviteModel;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getShowInviteSettings() {
                return this.showInviteSettings;
            }

            public final Loaded copy(WidgetInviteModel widgetInviteModel, boolean showInviteSettings) {
                C12238m.checkNotNullParameter(widgetInviteModel, "widgetInviteModel");
                return new Loaded(widgetInviteModel, showInviteSettings);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return C12238m.areEqual(this.widgetInviteModel, loaded.widgetInviteModel) && this.showInviteSettings == loaded.showInviteSettings;
            }

            public final boolean getShowInviteSettings() {
                return this.showInviteSettings;
            }

            public final WidgetInviteModel getWidgetInviteModel() {
                return this.widgetInviteModel;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r1v3 */
            public int hashCode() {
                WidgetInviteModel widgetInviteModel = this.widgetInviteModel;
                int iHashCode = (widgetInviteModel != null ? widgetInviteModel.hashCode() : 0) * 31;
                boolean z2 = this.showInviteSettings;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                return iHashCode + r1;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Loaded(widgetInviteModel=");
                sbM833U.append(this.widgetInviteModel);
                sbM833U.append(", showInviteSettings=");
                return C1643a.m827O(sbM833U, this.showInviteSettings, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(WidgetInviteModel widgetInviteModel, boolean z2) {
                super(null);
                C12238m.checkNotNullParameter(widgetInviteModel, "widgetInviteModel");
                this.widgetInviteModel = widgetInviteModel;
                this.showInviteSettings = z2;
            }
        }

        /* JADX INFO: compiled from: WidgetGuildScheduledEventCreateSuccessViewModel.kt */
        public static final class Uninitialized extends ViewState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccessViewModel$generateInviteLink$1 */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventCreateSuccessViewModel.kt */
    public static final class C88541 extends AbstractC12240o implements Function1<Channel, Unit> {
        public final /* synthetic */ Long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C88541(Long l) {
            super(1);
            this.$channelId = l;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Long lValueOf = this.$channelId;
            if (lValueOf == null) {
                lValueOf = channel != null ? Long.valueOf(channel.getId()) : null;
            }
            if (lValueOf != null) {
                WidgetGuildScheduledEventCreateSuccessViewModel.this.inviteGenerator.generateForAppComponent(WidgetGuildScheduledEventCreateSuccessViewModel.this, lValueOf.longValue());
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccessViewModel$observeInvite$1 */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventCreateSuccessViewModel.kt */
    public static final class C88551 extends AbstractC12240o implements Function10<ModelInvite.Settings, Map<Long, ? extends Channel>, InviteGenerator.InviteGenerationState, MeUser, List<? extends Channel>, Guild, Map<Long, ? extends StageInstance>, GuildScheduledEvent, StoreInstantInvites.InviteState, Channel, ViewState.Loaded> {
        public static final C88551 INSTANCE = new C88551();

        public C88551() {
            super(10);
        }

        @Override // kotlin.jvm.functions.Function10
        public /* bridge */ /* synthetic */ ViewState.Loaded invoke(ModelInvite.Settings settings, Map<Long, ? extends Channel> map, InviteGenerator.InviteGenerationState inviteGenerationState, MeUser meUser, List<? extends Channel> list, Guild guild, Map<Long, ? extends StageInstance> map2, GuildScheduledEvent guildScheduledEvent, StoreInstantInvites.InviteState inviteState, Channel channel) {
            return invoke2(settings, (Map<Long, Channel>) map, inviteGenerationState, meUser, (List<Channel>) list, guild, (Map<Long, StageInstance>) map2, guildScheduledEvent, inviteState, channel);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final ViewState.Loaded invoke2(ModelInvite.Settings settings, Map<Long, Channel> map, InviteGenerator.InviteGenerationState inviteGenerationState, MeUser meUser, List<Channel> list, Guild guild, Map<Long, StageInstance> map2, GuildScheduledEvent guildScheduledEvent, StoreInstantInvites.InviteState inviteState, Channel channel) {
            Long lValueOf;
            StoreInstantInvites.InviteState inviteState2 = inviteState;
            C12238m.checkNotNullParameter(settings, "settings");
            C12238m.checkNotNullParameter(map, "invitableChannels");
            C12238m.checkNotNullParameter(inviteGenerationState, "inviteGenerationState");
            C12238m.checkNotNullParameter(meUser, "me");
            C12238m.checkNotNullParameter(list, "dms");
            C12238m.checkNotNullParameter(map2, "guildStageInstances");
            C12238m.checkNotNullParameter(inviteState2, "storeInvite");
            WidgetInviteModel.Companion companion = WidgetInviteModel.INSTANCE;
            if (guildScheduledEvent == null || (lValueOf = guildScheduledEvent.getChannelId()) == null) {
                lValueOf = channel != null ? Long.valueOf(channel.getId()) : null;
            }
            if (!(inviteState2 instanceof StoreInstantInvites.InviteState.Resolved)) {
                inviteState2 = null;
            }
            StoreInstantInvites.InviteState.Resolved resolved = (StoreInstantInvites.InviteState.Resolved) inviteState2;
            WidgetInviteModel widgetInviteModelCreate = companion.create(settings, map, inviteGenerationState, lValueOf, meUser, list, guild, map2, guildScheduledEvent, resolved != null ? resolved.getInvite() : null);
            boolean z2 = true;
            if (widgetInviteModelCreate.getInvite() != null && (widgetInviteModelCreate.getInvite().isStatic() || widgetInviteModelCreate.isInviteFromStore())) {
                z2 = false;
            }
            return new ViewState.Loaded(widgetInviteModelCreate, z2);
        }
    }

    public /* synthetic */ WidgetGuildScheduledEventCreateSuccessViewModel(Long l, long j, long j2, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreInviteSettings storeInviteSettings, StoreUser storeUser, StoreStageInstances storeStageInstances, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreInstantInvites storeInstantInvites, InviteGenerator inviteGenerator, Resources resources, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(l, j, j2, (i & 8) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 16) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 32) != 0 ? StoreStream.INSTANCE.getInviteSettings() : storeInviteSettings, (i & 64) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 128) != 0 ? StoreStream.INSTANCE.getStageInstances() : storeStageInstances, (i & 256) != 0 ? StoreStream.INSTANCE.getGuildScheduledEvents() : storeGuildScheduledEvents, (i & 512) != 0 ? StoreStream.INSTANCE.getInstantInvites() : storeInstantInvites, (i & 1024) != 0 ? new InviteGenerator() : inviteGenerator, resources);
    }

    private final void generateInviteLinkFromViewState(ViewState.Loaded viewState) {
        WidgetInviteModel widgetInviteModel = viewState.getWidgetInviteModel();
        if (widgetInviteModel.isValidInvite() || widgetInviteModel.isGeneratingInvite() || widgetInviteModel.getTargetChannel() == null) {
            return;
        }
        this.inviteGenerator.generateForAppComponent(this, widgetInviteModel.getTargetChannel().getId());
    }

    private final Observable<ViewState.Loaded> observeInvite(long guildId, Long eventId, String inviteStoreKey) {
        Observable<ViewState.Loaded> observableM11112r = ObservableExtensionsKt.computationLatest(ObservableCombineLatestOverloadsKt.combineLatest(this.storeInviteSettings.getInviteSettings(), this.storeInviteSettings.getInvitableChannels(guildId), this.inviteGenerator.getGenerationState(), StoreUser.observeMe$default(this.storeUser, false, 1, null), this.storeChannels.observeDMs(), this.storeGuilds.observeGuild(guildId), this.storeStageInstances.observeStageInstancesForGuild(guildId), this.storeGuildScheduledEvents.observeGuildScheduledEvent(eventId, Long.valueOf(guildId)), this.storeInstantInvites.observeInvite(inviteStoreKey), this.storeChannels.observeDefaultChannel(guildId), C88551.INSTANCE)).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "combineLatest(\n        s…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final void generateInviteLink(Long channelId) {
        Observable<Channel> observableM11119z = this.storeChannels.observeDefaultChannel(this.guildId).m11119z();
        C12238m.checkNotNullExpressionValue(observableM11119z, "storeChannels.observeDef…tChannel(guildId).first()");
        ObservableExtensionsKt.appSubscribe(observableM11119z, (Class<?>) WidgetGuildScheduledEventCreateSuccessViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C88541(channelId));
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

    public final void updateInviteSettings(ModelInvite.Settings settings) {
        C12238m.checkNotNullParameter(settings, "settings");
        this.storeInviteSettings.setInviteSettings(settings);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventCreateSuccessViewModel(Long l, long j, long j2, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreInviteSettings storeInviteSettings, StoreUser storeUser, StoreStageInstances storeStageInstances, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreInstantInvites storeInstantInvites, InviteGenerator inviteGenerator, Resources resources) {
        super(ViewState.Uninitialized.INSTANCE);
        C12238m.checkNotNullParameter(storeChannels, "storeChannels");
        C12238m.checkNotNullParameter(storeGuilds, "storeGuilds");
        C12238m.checkNotNullParameter(storeInviteSettings, "storeInviteSettings");
        C12238m.checkNotNullParameter(storeUser, "storeUser");
        C12238m.checkNotNullParameter(storeStageInstances, "storeStageInstances");
        C12238m.checkNotNullParameter(storeGuildScheduledEvents, "storeGuildScheduledEvents");
        C12238m.checkNotNullParameter(storeInstantInvites, "storeInstantInvites");
        C12238m.checkNotNullParameter(inviteGenerator, "inviteGenerator");
        C12238m.checkNotNullParameter(resources, "resources");
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
        Observable<ViewState.Loaded> observableM11115u = observeInvite(j, Long.valueOf(j2), null).m11115u(new Action1<ViewState.Loaded>() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccessViewModel.1
            @Override // p658rx.functions.Action1
            public final void call(ViewState.Loaded loaded) {
                WidgetGuildScheduledEventCreateSuccessViewModel widgetGuildScheduledEventCreateSuccessViewModel = WidgetGuildScheduledEventCreateSuccessViewModel.this;
                C12238m.checkNotNullExpressionValue(loaded, "viewState");
                widgetGuildScheduledEventCreateSuccessViewModel.generateInviteLinkFromViewState(loaded);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11115u, "observeInvite(guildId, g…romViewState(viewState) }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableM11115u), this, null, 2, null), (Class<?>) WidgetGuildScheduledEventCreateSuccessViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C88532(this));
    }
}
