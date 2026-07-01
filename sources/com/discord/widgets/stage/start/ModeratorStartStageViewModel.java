package com.discord.widgets.stage.start;

import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.api.permission.Permission;
import com.discord.models.guild.UserGuildMember;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.error.Error;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities5;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.stage.start.ModeratorStartStageItem;
import com.discord.widgets.stage.start.ModeratorStartStageViewModel;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.u.a;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func3;

/* JADX INFO: compiled from: ModeratorStartStageViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ModeratorStartStageViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int MAX_DISPLAY_WAITING_USERS = 3;
    private final long channelId;
    private final StoreChannels channelsStore;
    private final StoreGuildScheduledEvents guildScheduledEventsStore;
    private final StorePermissions permissionsStore;
    private final StoreVoiceChannelSelected selectedVoiceChannelStore;
    private final StoreVoiceParticipants voiceParticipants;

    /* JADX INFO: renamed from: com.discord.widgets.stage.start.ModeratorStartStageViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: ModeratorStartStageViewModel.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public AnonymousClass1(ModeratorStartStageViewModel moderatorStartStageViewModel) {
            super(1, moderatorStartStageViewModel, ModeratorStartStageViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/stage/start/ModeratorStartStageViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            ((ModeratorStartStageViewModel) this.receiver).handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: ModeratorStartStageViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStores(final long channelId, StoreChannels channelStore, final StoreGuildScheduledEvents guildScheduledEventsStore, final StorePermissions permissionsStore, final StoreVoiceParticipants voiceParticipantsStore) {
            Observable<R> observableG = channelStore.observeChannel(channelId).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
            Observable<StoreState> observableY = observableG.Y(new Func1<Channel, Observable<? extends StoreState>>() { // from class: com.discord.widgets.stage.start.ModeratorStartStageViewModel$Companion$observeStores$1
                @Override // j0.k.Func1
                public final Observable<? extends ModeratorStartStageViewModel.StoreState> call(Channel channel) {
                    return Observable.i(ObservableExtensionsKt.leadingEdgeThrottle(voiceParticipantsStore.get(channel.getId()), 250L, TimeUnit.MILLISECONDS), StoreGuildScheduledEvents.observeGuildScheduledEvents$default(guildScheduledEventsStore, channel.getGuildId(), false, 2, null), permissionsStore.observePermissionsForChannel(channel.getId()), new Func3<Map<Long, ? extends StoreVoiceParticipants.VoiceUser>, List<? extends GuildScheduledEvent>, Long, ModeratorStartStageViewModel.StoreState>() { // from class: com.discord.widgets.stage.start.ModeratorStartStageViewModel$Companion$observeStores$1.1
                        @Override // rx.functions.Func3
                        public /* bridge */ /* synthetic */ ModeratorStartStageViewModel.StoreState call(Map<Long, ? extends StoreVoiceParticipants.VoiceUser> map, List<? extends GuildScheduledEvent> list, Long l) {
                            return call2((Map<Long, StoreVoiceParticipants.VoiceUser>) map, (List<GuildScheduledEvent>) list, l);
                        }

                        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                        public final ModeratorStartStageViewModel.StoreState call2(Map<Long, StoreVoiceParticipants.VoiceUser> map, List<GuildScheduledEvent> list, Long l) {
                            ArrayList arrayListA0 = outline.a0(list, "guildScheduledEvents");
                            Iterator<T> it = list.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                T next = it.next();
                                Long channelId2 = ((GuildScheduledEvent) next).getChannelId();
                                if (channelId2 != null && channelId2.longValue() == channelId) {
                                    arrayListA0.add(next);
                                }
                            }
                            List listSortedWith = _Collections.sortedWith(arrayListA0, new Comparator() { // from class: com.discord.widgets.stage.start.ModeratorStartStageViewModel$Companion$observeStores$1$1$$special$$inlined$sortedBy$1
                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // java.util.Comparator
                                public final int compare(T t, T t2) {
                                    return a.compareValues(((GuildScheduledEvent) t).getScheduledStartTime(), ((GuildScheduledEvent) t2).getScheduledStartTime());
                                }
                            });
                            Collection<StoreVoiceParticipants.VoiceUser> collectionValues = map.values();
                            ArrayList<StoreVoiceParticipants.VoiceUser> arrayList = new ArrayList();
                            for (T t : collectionValues) {
                                if (!((StoreVoiceParticipants.VoiceUser) t).isMe()) {
                                    arrayList.add(t);
                                }
                            }
                            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
                            for (StoreVoiceParticipants.VoiceUser voiceUser : arrayList) {
                                arrayList2.add(new UserGuildMember(voiceUser.getUser(), voiceUser.getGuildMember()));
                            }
                            return new ModeratorStartStageViewModel.StoreState(listSortedWith, arrayList2, PermissionUtils.can(Permission.START_STAGE_EVENT, l));
                        }
                    });
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableY, "channelStore.observeChan…  )\n          }\n        }");
            return observableY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: ModeratorStartStageViewModel.kt */
    public static final /* data */ class StoreState {
        private final boolean canStartEvent;
        private final List<GuildScheduledEvent> channelEvents;
        private final List<UserGuildMember> voiceParticipants;

        public StoreState(List<GuildScheduledEvent> list, List<UserGuildMember> list2, boolean z2) {
            Intrinsics3.checkNotNullParameter(list, "channelEvents");
            Intrinsics3.checkNotNullParameter(list2, "voiceParticipants");
            this.channelEvents = list;
            this.voiceParticipants = list2;
            this.canStartEvent = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, List list, List list2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = storeState.channelEvents;
            }
            if ((i & 2) != 0) {
                list2 = storeState.voiceParticipants;
            }
            if ((i & 4) != 0) {
                z2 = storeState.canStartEvent;
            }
            return storeState.copy(list, list2, z2);
        }

        public final List<GuildScheduledEvent> component1() {
            return this.channelEvents;
        }

        public final List<UserGuildMember> component2() {
            return this.voiceParticipants;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getCanStartEvent() {
            return this.canStartEvent;
        }

        public final StoreState copy(List<GuildScheduledEvent> channelEvents, List<UserGuildMember> voiceParticipants, boolean canStartEvent) {
            Intrinsics3.checkNotNullParameter(channelEvents, "channelEvents");
            Intrinsics3.checkNotNullParameter(voiceParticipants, "voiceParticipants");
            return new StoreState(channelEvents, voiceParticipants, canStartEvent);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.channelEvents, storeState.channelEvents) && Intrinsics3.areEqual(this.voiceParticipants, storeState.voiceParticipants) && this.canStartEvent == storeState.canStartEvent;
        }

        public final boolean getCanStartEvent() {
            return this.canStartEvent;
        }

        public final List<GuildScheduledEvent> getChannelEvents() {
            return this.channelEvents;
        }

        public final List<UserGuildMember> getVoiceParticipants() {
            return this.voiceParticipants;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            List<GuildScheduledEvent> list = this.channelEvents;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            List<UserGuildMember> list2 = this.voiceParticipants;
            int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
            boolean z2 = this.canStartEvent;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode2 + r1;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(channelEvents=");
            sbU.append(this.channelEvents);
            sbU.append(", voiceParticipants=");
            sbU.append(this.voiceParticipants);
            sbU.append(", canStartEvent=");
            return outline.O(sbU, this.canStartEvent, ")");
        }
    }

    /* JADX INFO: compiled from: ModeratorStartStageViewModel.kt */
    public static final /* data */ class ViewState {
        private final boolean channelEventActive;
        private final List<GuildScheduledEvent> channelEvents;
        private final List<ModeratorStartStageItem> items;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(List<GuildScheduledEvent> list, List<? extends ModeratorStartStageItem> list2, boolean z2) {
            Intrinsics3.checkNotNullParameter(list, "channelEvents");
            Intrinsics3.checkNotNullParameter(list2, "items");
            this.channelEvents = list;
            this.items = list2;
            this.channelEventActive = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, List list, List list2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = viewState.channelEvents;
            }
            if ((i & 2) != 0) {
                list2 = viewState.items;
            }
            if ((i & 4) != 0) {
                z2 = viewState.channelEventActive;
            }
            return viewState.copy(list, list2, z2);
        }

        public final List<GuildScheduledEvent> component1() {
            return this.channelEvents;
        }

        public final List<ModeratorStartStageItem> component2() {
            return this.items;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getChannelEventActive() {
            return this.channelEventActive;
        }

        public final ViewState copy(List<GuildScheduledEvent> channelEvents, List<? extends ModeratorStartStageItem> items, boolean channelEventActive) {
            Intrinsics3.checkNotNullParameter(channelEvents, "channelEvents");
            Intrinsics3.checkNotNullParameter(items, "items");
            return new ViewState(channelEvents, items, channelEventActive);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics3.areEqual(this.channelEvents, viewState.channelEvents) && Intrinsics3.areEqual(this.items, viewState.items) && this.channelEventActive == viewState.channelEventActive;
        }

        public final boolean getChannelEventActive() {
            return this.channelEventActive;
        }

        public final List<GuildScheduledEvent> getChannelEvents() {
            return this.channelEvents;
        }

        public final List<ModeratorStartStageItem> getItems() {
            return this.items;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            List<GuildScheduledEvent> list = this.channelEvents;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            List<ModeratorStartStageItem> list2 = this.items;
            int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
            boolean z2 = this.channelEventActive;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode2 + r1;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(channelEvents=");
            sbU.append(this.channelEvents);
            sbU.append(", items=");
            sbU.append(this.items);
            sbU.append(", channelEventActive=");
            return outline.O(sbU, this.channelEventActive, ")");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ModeratorStartStageViewModel(long j, StoreChannels storeChannels, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreVoiceChannelSelected storeVoiceChannelSelected, StorePermissions storePermissions, StoreVoiceParticipants storeVoiceParticipants, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreChannels channels = (i & 2) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StoreGuildScheduledEvents guildScheduledEvents = (i & 4) != 0 ? StoreStream.INSTANCE.getGuildScheduledEvents() : storeGuildScheduledEvents;
        StoreVoiceChannelSelected voiceChannelSelected = (i & 8) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected;
        StorePermissions permissions = (i & 16) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions;
        StoreVoiceParticipants voiceParticipants = (i & 32) != 0 ? StoreStream.INSTANCE.getVoiceParticipants() : storeVoiceParticipants;
        this(j, channels, guildScheduledEvents, voiceChannelSelected, permissions, voiceParticipants, (i & 64) != 0 ? INSTANCE.observeStores(j, channels, guildScheduledEvents, permissions, voiceParticipants) : observable);
    }

    private final void handleStoreState(StoreState storeState) {
        Object next;
        Object obj = null;
        List listMutableListOf = Collections2.mutableListOf(new ModeratorStartStageItem.Header(0, null, 3, null));
        if (storeState.getCanStartEvent()) {
            Iterator<T> it = storeState.getChannelEvents().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!GuildScheduledEventUtilities5.getEventTiming((GuildScheduledEvent) next).isStartable());
            GuildScheduledEvent guildScheduledEvent = (GuildScheduledEvent) next;
            if (guildScheduledEvent != null) {
                listMutableListOf.add(new ModeratorStartStageItem.ListItem.Event(guildScheduledEvent));
            }
        }
        listMutableListOf.add(new ModeratorStartStageItem.ListItem.StaticOption.StartStage(null, 1, null));
        if (storeState.getCanStartEvent()) {
            listMutableListOf.add(new ModeratorStartStageItem.ListItem.StaticOption.ScheduleEvent(null, 1, null));
        }
        listMutableListOf.add(new ModeratorStartStageItem.Continue(0, null, 3, null));
        if (!storeState.getVoiceParticipants().isEmpty()) {
            listMutableListOf.add(new ModeratorStartStageItem.Waiting(0, null, _Collections.take(storeState.getVoiceParticipants(), 3), 3, null));
        }
        List<GuildScheduledEvent> channelEvents = storeState.getChannelEvents();
        for (Object obj2 : storeState.getChannelEvents()) {
            if (((GuildScheduledEvent) obj2).getStatus() == GuildScheduledEventStatus.ACTIVE) {
                obj = obj2;
                break;
            }
        }
        updateViewState(new ViewState(channelEvents, listMutableListOf, obj != null));
    }

    public final void disconnectFromStage() {
        this.selectedVoiceChannelStore.clear();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModeratorStartStageViewModel(long j, StoreChannels storeChannels, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreVoiceChannelSelected storeVoiceChannelSelected, StorePermissions storePermissions, StoreVoiceParticipants storeVoiceParticipants, Observable<StoreState> observable) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(storeChannels, "channelsStore");
        Intrinsics3.checkNotNullParameter(storeGuildScheduledEvents, "guildScheduledEventsStore");
        Intrinsics3.checkNotNullParameter(storeVoiceChannelSelected, "selectedVoiceChannelStore");
        Intrinsics3.checkNotNullParameter(storePermissions, "permissionsStore");
        Intrinsics3.checkNotNullParameter(storeVoiceParticipants, "voiceParticipants");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = j;
        this.channelsStore = storeChannels;
        this.guildScheduledEventsStore = storeGuildScheduledEvents;
        this.selectedVoiceChannelStore = storeVoiceChannelSelected;
        this.permissionsStore = storePermissions;
        this.voiceParticipants = storeVoiceParticipants;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) ModeratorStartStageViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }
}
