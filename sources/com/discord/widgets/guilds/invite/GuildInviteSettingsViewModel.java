package com.discord.widgets.guilds.invite;

import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelInvite;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guilds.invite.GuildInviteSettingsViewModel;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: GuildInviteSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildInviteSettingsViewModel extends AppViewModel<ViewState> {

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

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.GuildInviteSettingsViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: GuildInviteSettingsViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            GuildInviteSettingsViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: GuildInviteSettingsViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(long guildId, StoreInviteSettings storeInviteSettings) {
            Observable<StoreState> observableJ = Observable.j(storeInviteSettings.getInviteSettings(), storeInviteSettings.getInvitableChannels(guildId), new Func2<ModelInvite.Settings, Map<Long, ? extends Channel>, StoreState>() { // from class: com.discord.widgets.guilds.invite.GuildInviteSettingsViewModel$Companion$observeStoreState$1
                @Override // rx.functions.Func2
                public /* bridge */ /* synthetic */ GuildInviteSettingsViewModel.StoreState call(ModelInvite.Settings settings, Map<Long, ? extends Channel> map) {
                    return call2(settings, (Map<Long, Channel>) map);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final GuildInviteSettingsViewModel.StoreState call2(ModelInvite.Settings settings, Map<Long, Channel> map) {
                    Intrinsics3.checkNotNullExpressionValue(settings, "inviteSettings");
                    Intrinsics3.checkNotNullExpressionValue(map, "invitableChannels");
                    return new GuildInviteSettingsViewModel.StoreState(settings, map);
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…hannels\n        )\n      }");
            return observableJ;
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
                Intrinsics3.checkNotNullParameter(guildInvite, "invite");
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
                Intrinsics3.checkNotNullParameter(invite, "invite");
                return new InviteCreationSuccess(invite);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof InviteCreationSuccess) && Intrinsics3.areEqual(this.invite, ((InviteCreationSuccess) other).invite);
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
                StringBuilder sbU = outline.U("InviteCreationSuccess(invite=");
                sbU.append(this.invite);
                sbU.append(")");
                return sbU.toString();
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
            Intrinsics3.checkNotNullParameter(settings, "inviteSettings");
            Intrinsics3.checkNotNullParameter(map, "invitableChannels");
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
            Intrinsics3.checkNotNullParameter(inviteSettings, "inviteSettings");
            Intrinsics3.checkNotNullParameter(invitableChannels, "invitableChannels");
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
            return Intrinsics3.areEqual(this.inviteSettings, storeState.inviteSettings) && Intrinsics3.areEqual(this.invitableChannels, storeState.invitableChannels);
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
            StringBuilder sbU = outline.U("StoreState(inviteSettings=");
            sbU.append(this.inviteSettings);
            sbU.append(", invitableChannels=");
            return outline.M(sbU, this.invitableChannels, ")");
        }
    }

    /* JADX INFO: compiled from: GuildInviteSettingsViewModel.kt */
    public static final /* data */ class ViewState {
        private final List<Channel> invitableChannels;
        private final ModelInvite.Settings inviteSettings;
        private final Channel targetChannel;

        public ViewState(List<Channel> list, ModelInvite.Settings settings, Channel channel) {
            Intrinsics3.checkNotNullParameter(list, "invitableChannels");
            Intrinsics3.checkNotNullParameter(settings, "inviteSettings");
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
            Intrinsics3.checkNotNullParameter(invitableChannels, "invitableChannels");
            Intrinsics3.checkNotNullParameter(inviteSettings, "inviteSettings");
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
            return Intrinsics3.areEqual(this.invitableChannels, viewState.invitableChannels) && Intrinsics3.areEqual(this.inviteSettings, viewState.inviteSettings) && Intrinsics3.areEqual(this.targetChannel, viewState.targetChannel);
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
            StringBuilder sbU = outline.U("ViewState(invitableChannels=");
            sbU.append(this.invitableChannels);
            sbU.append(", inviteSettings=");
            sbU.append(this.inviteSettings);
            sbU.append(", targetChannel=");
            sbU.append(this.targetChannel);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.GuildInviteSettingsViewModel$generateInviteForChannel$1, reason: invalid class name */
    /* JADX INFO: compiled from: GuildInviteSettingsViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelInvite, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
            invoke2(modelInvite);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelInvite modelInvite) {
            Intrinsics3.checkNotNullParameter(modelInvite, "invite");
            GuildInviteSettingsViewModel.this.handleInviteCreationSuccess(modelInvite);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.GuildInviteSettingsViewModel$generateInviteForChannel$2, reason: invalid class name */
    /* JADX INFO: compiled from: GuildInviteSettingsViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            GuildInviteSettingsViewModel.this.handleInviteCreationFailure();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GuildInviteSettingsViewModel(Long l, long j, StoreInviteSettings storeInviteSettings, TargetChannelSelector targetChannelSelector, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreInviteSettings inviteSettings = (i & 4) != 0 ? StoreStream.INSTANCE.getInviteSettings() : storeInviteSettings;
        this(l, j, inviteSettings, (i & 8) != 0 ? new TargetChannelSelector() : targetChannelSelector, (i & 16) != 0 ? INSTANCE.observeStoreState(j, inviteSettings) : observable);
    }

    private final void generateInviteForChannel(long targetChannelId) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(StoreInviteSettings.generateInvite$default(this.storeInviteSettings, targetChannelId, null, 2, null), false, 1, null), this, null, 2, null), (Class<?>) GuildInviteSettingsViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    @MainThread
    private final void handleInviteCreationFailure() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.InviteCreationFailure.INSTANCE);
    }

    @MainThread
    private final void handleInviteCreationSuccess(ModelInvite invite) {
        GuildInvite guildInviteCreateFromModelInvite = GuildInvite.INSTANCE.createFromModelInvite(invite);
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.InviteCreationSuccess(guildInviteCreateFromModelInvite));
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
        updateViewState(new ViewState(_Collections.toList(invitableChannels.values()), inviteSettings, targetChannel));
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
        Intrinsics3.checkNotNullParameter(settings, "settings");
        ViewState viewState = getViewState();
        if (viewState != null) {
            this.inviteSettings = settings;
            updateViewState(ViewState.copy$default(viewState, null, settings, null, 5, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildInviteSettingsViewModel(Long l, long j, StoreInviteSettings storeInviteSettings, TargetChannelSelector targetChannelSelector, Observable<StoreState> observable) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(storeInviteSettings, "storeInviteSettings");
        Intrinsics3.checkNotNullParameter(targetChannelSelector, "targetChannelSelector");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = l;
        this.guildId = j;
        this.storeInviteSettings = storeInviteSettings;
        this.targetChannelSelector = targetChannelSelector;
        PublishSubject<Event> publishSubjectK0 = PublishSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.eventSubject = publishSubjectK0;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) GuildInviteSettingsViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
