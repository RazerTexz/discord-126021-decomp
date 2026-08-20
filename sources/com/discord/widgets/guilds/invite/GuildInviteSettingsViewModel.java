package com.discord.widgets.guilds.invite;

import androidx.annotation.MainThread;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelInvite;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: GuildInviteSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildInviteSettingsViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Long channelId;
    private StoreState currentStoreState;
    private PublishSubject<Event> eventSubject;
    private final long guildId;
    private ModelInvite.Settings inviteSettings;
    private final StoreInviteSettings storeInviteSettings;
    private Channel targetChannel;
    private final TargetChannelSelector targetChannelSelector;

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.GuildInviteSettingsViewModel$1 */
    /* JADX INFO: compiled from: GuildInviteSettingsViewModel.kt */
    public static final class C86171 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C86171() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            C12238m.checkNotNullParameter(storeState, "storeState");
            GuildInviteSettingsViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: GuildInviteSettingsViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(long guildId, StoreInviteSettings storeInviteSettings) {
            Observable<StoreState> observableM11076j = Observable.m11076j(storeInviteSettings.getInviteSettings(), storeInviteSettings.getInvitableChannels(guildId), new Func2<ModelInvite.Settings, Map<Long, ? extends Channel>, StoreState>() { // from class: com.discord.widgets.guilds.invite.GuildInviteSettingsViewModel$Companion$observeStoreState$1
                @Override // p658rx.functions.Func2
                public /* bridge */ /* synthetic */ GuildInviteSettingsViewModel.StoreState call(ModelInvite.Settings settings, Map<Long, ? extends Channel> map) {
                    return call2(settings, (Map<Long, Channel>) map);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final GuildInviteSettingsViewModel.StoreState call2(ModelInvite.Settings settings, Map<Long, Channel> map) {
                    C12238m.checkNotNullExpressionValue(settings, "inviteSettings");
                    C12238m.checkNotNullExpressionValue(map, "invitableChannels");
                    return new GuildInviteSettingsViewModel.StoreState(settings, map);
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest…hannels\n        )\n      }");
            return observableM11076j;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: GuildInviteSettingsViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: GuildInviteSettingsViewModel.kt */
        public static final class InviteCreationFailure extends Event {
            public static final InviteCreationFailure INSTANCE = new InviteCreationFailure();

            private InviteCreationFailure() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: GuildInviteSettingsViewModel.kt */
        public static final /* data */ class InviteCreationSuccess extends Event {
            private final GuildInvite invite;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public InviteCreationSuccess(GuildInvite guildInvite) {
                super(null);
                C12238m.checkNotNullParameter(guildInvite, "invite");
                this.invite = guildInvite;
            }

            public static /* synthetic */ InviteCreationSuccess copy$default(InviteCreationSuccess inviteCreationSuccess, GuildInvite guildInvite, int i, Object obj) {
                if ((i & 1) != 0) {
                    guildInvite = inviteCreationSuccess.invite;
                }
                return inviteCreationSuccess.copy(guildInvite);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final GuildInvite getInvite() {
                return this.invite;
            }

            public final InviteCreationSuccess copy(GuildInvite invite) {
                C12238m.checkNotNullParameter(invite, "invite");
                return new InviteCreationSuccess(invite);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof InviteCreationSuccess) && C12238m.areEqual(this.invite, ((InviteCreationSuccess) other).invite);
                }
                return true;
            }

            public final GuildInvite getInvite() {
                return this.invite;
            }

            public int hashCode() {
                GuildInvite guildInvite = this.invite;
                if (guildInvite != null) {
                    return guildInvite.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("InviteCreationSuccess(invite=");
                sbM833U.append(this.invite);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: GuildInviteSettingsViewModel.kt */
    public static final /* data */ class StoreState {
        private final Map<Long, Channel> invitableChannels;
        private final ModelInvite.Settings inviteSettings;

        public StoreState(ModelInvite.Settings settings, Map<Long, Channel> map) {
            C12238m.checkNotNullParameter(settings, "inviteSettings");
            C12238m.checkNotNullParameter(map, "invitableChannels");
            this.inviteSettings = settings;
            this.invitableChannels = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, ModelInvite.Settings settings, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                settings = storeState.inviteSettings;
            }
            if ((i & 2) != 0) {
                map = storeState.invitableChannels;
            }
            return storeState.copy(settings, map);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ModelInvite.Settings getInviteSettings() {
            return this.inviteSettings;
        }

        public final Map<Long, Channel> component2() {
            return this.invitableChannels;
        }

        public final StoreState copy(ModelInvite.Settings inviteSettings, Map<Long, Channel> invitableChannels) {
            C12238m.checkNotNullParameter(inviteSettings, "inviteSettings");
            C12238m.checkNotNullParameter(invitableChannels, "invitableChannels");
            return new StoreState(inviteSettings, invitableChannels);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return C12238m.areEqual(this.inviteSettings, storeState.inviteSettings) && C12238m.areEqual(this.invitableChannels, storeState.invitableChannels);
        }

        public final Map<Long, Channel> getInvitableChannels() {
            return this.invitableChannels;
        }

        public final ModelInvite.Settings getInviteSettings() {
            return this.inviteSettings;
        }

        public int hashCode() {
            ModelInvite.Settings settings = this.inviteSettings;
            int iHashCode = (settings != null ? settings.hashCode() : 0) * 31;
            Map<Long, Channel> map = this.invitableChannels;
            return iHashCode + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StoreState(inviteSettings=");
            sbM833U.append(this.inviteSettings);
            sbM833U.append(", invitableChannels=");
            return C1643a.m825M(sbM833U, this.invitableChannels, ")");
        }
    }

    /* JADX INFO: compiled from: GuildInviteSettingsViewModel.kt */
    public static final /* data */ class ViewState {
        private final List<Channel> invitableChannels;
        private final ModelInvite.Settings inviteSettings;
        private final Channel targetChannel;

        public ViewState(List<Channel> list, ModelInvite.Settings settings, Channel channel) {
            C12238m.checkNotNullParameter(list, "invitableChannels");
            C12238m.checkNotNullParameter(settings, "inviteSettings");
            this.invitableChannels = list;
            this.inviteSettings = settings;
            this.targetChannel = channel;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, List list, ModelInvite.Settings settings, Channel channel, int i, Object obj) {
            if ((i & 1) != 0) {
                list = viewState.invitableChannels;
            }
            if ((i & 2) != 0) {
                settings = viewState.inviteSettings;
            }
            if ((i & 4) != 0) {
                channel = viewState.targetChannel;
            }
            return viewState.copy(list, settings, channel);
        }

        public final List<Channel> component1() {
            return this.invitableChannels;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ModelInvite.Settings getInviteSettings() {
            return this.inviteSettings;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Channel getTargetChannel() {
            return this.targetChannel;
        }

        public final ViewState copy(List<Channel> invitableChannels, ModelInvite.Settings inviteSettings, Channel targetChannel) {
            C12238m.checkNotNullParameter(invitableChannels, "invitableChannels");
            C12238m.checkNotNullParameter(inviteSettings, "inviteSettings");
            return new ViewState(invitableChannels, inviteSettings, targetChannel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return C12238m.areEqual(this.invitableChannels, viewState.invitableChannels) && C12238m.areEqual(this.inviteSettings, viewState.inviteSettings) && C12238m.areEqual(this.targetChannel, viewState.targetChannel);
        }

        public final List<Channel> getInvitableChannels() {
            return this.invitableChannels;
        }

        public final ModelInvite.Settings getInviteSettings() {
            return this.inviteSettings;
        }

        public final Channel getTargetChannel() {
            return this.targetChannel;
        }

        public int hashCode() {
            List<Channel> list = this.invitableChannels;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            ModelInvite.Settings settings = this.inviteSettings;
            int iHashCode2 = (iHashCode + (settings != null ? settings.hashCode() : 0)) * 31;
            Channel channel = this.targetChannel;
            return iHashCode2 + (channel != null ? channel.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ViewState(invitableChannels=");
            sbM833U.append(this.invitableChannels);
            sbM833U.append(", inviteSettings=");
            sbM833U.append(this.inviteSettings);
            sbM833U.append(", targetChannel=");
            sbM833U.append(this.targetChannel);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.GuildInviteSettingsViewModel$generateInviteForChannel$1 */
    /* JADX INFO: compiled from: GuildInviteSettingsViewModel.kt */
    public static final class C86181 extends AbstractC12240o implements Function1<ModelInvite, Unit> {
        public C86181() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
            invoke2(modelInvite);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelInvite modelInvite) {
            C12238m.checkNotNullParameter(modelInvite, "invite");
            GuildInviteSettingsViewModel.this.handleInviteCreationSuccess(modelInvite);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.GuildInviteSettingsViewModel$generateInviteForChannel$2 */
    /* JADX INFO: compiled from: GuildInviteSettingsViewModel.kt */
    public static final class C86192 extends AbstractC12240o implements Function1<Error, Unit> {
        public C86192() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            GuildInviteSettingsViewModel.this.handleInviteCreationFailure();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GuildInviteSettingsViewModel(Long l, long j, StoreInviteSettings storeInviteSettings, TargetChannelSelector targetChannelSelector, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreInviteSettings inviteSettings = (i & 4) != 0 ? StoreStream.INSTANCE.getInviteSettings() : storeInviteSettings;
        this(l, j, inviteSettings, (i & 8) != 0 ? new TargetChannelSelector() : targetChannelSelector, (i & 16) != 0 ? INSTANCE.observeStoreState(j, inviteSettings) : observable);
    }

    private final void generateInviteForChannel(long targetChannelId) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(StoreInviteSettings.generateInvite$default(this.storeInviteSettings, targetChannelId, null, 2, null), false, 1, null), this, null, 2, null), (Class<?>) GuildInviteSettingsViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C86192()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C86181());
    }

    @MainThread
    private final void handleInviteCreationFailure() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(Event.InviteCreationFailure.INSTANCE);
    }

    @MainThread
    private final void handleInviteCreationSuccess(ModelInvite invite) {
        GuildInvite guildInviteCreateFromModelInvite = GuildInvite.INSTANCE.createFromModelInvite(invite);
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(new Event.InviteCreationSuccess(guildInviteCreateFromModelInvite));
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        ModelInvite.Settings inviteSettings = this.inviteSettings;
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
        updateViewState(new ViewState(C12163u.toList(invitableChannels.values()), inviteSettings, targetChannel));
        this.currentStoreState = storeState;
    }

    public final Observable<Event> observeEvents() {
        return this.eventSubject;
    }

    @MainThread
    public final void saveInviteSettings() {
        Channel channel;
        ModelInvite.Settings settings = this.inviteSettings;
        if (settings == null || (channel = this.targetChannel) == null) {
            return;
        }
        this.storeInviteSettings.setInviteSettings(settings);
        generateInviteForChannel(channel.getId());
    }

    @MainThread
    public final void selectChannel(Channel channel) {
        ViewState viewState = getViewState();
        if (viewState == null || channel == null) {
            return;
        }
        this.targetChannel = channel;
        updateViewState(ViewState.copy$default(viewState, null, null, channel, 3, null));
    }

    @MainThread
    public final void updatePendingInviteSettings(ModelInvite.Settings settings) {
        C12238m.checkNotNullParameter(settings, "settings");
        ViewState viewState = getViewState();
        if (viewState != null) {
            this.inviteSettings = settings;
            updateViewState(ViewState.copy$default(viewState, null, settings, null, 5, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildInviteSettingsViewModel(Long l, long j, StoreInviteSettings storeInviteSettings, TargetChannelSelector targetChannelSelector, Observable<StoreState> observable) {
        super(null, 1, null);
        C12238m.checkNotNullParameter(storeInviteSettings, "storeInviteSettings");
        C12238m.checkNotNullParameter(targetChannelSelector, "targetChannelSelector");
        C12238m.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = l;
        this.guildId = j;
        this.storeInviteSettings = storeInviteSettings;
        this.targetChannelSelector = targetChannelSelector;
        PublishSubject<Event> publishSubjectM11133k0 = PublishSubject.m11133k0();
        C12238m.checkNotNullExpressionValue(publishSubjectM11133k0, "PublishSubject.create()");
        this.eventSubject = publishSubjectM11133k0;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) GuildInviteSettingsViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C86171());
    }
}
