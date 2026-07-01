package com.discord.widgets.announcements;

import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import com.discord.app.AppComponent;
import com.discord.models.guild.Guild;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func5;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetChannelFollowSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelFollowSheetViewModel extends AppViewModel<ViewState> implements AppComponent {
    private final PublishSubject<Event> eventSubject;
    private final BehaviorSubject<Long> selectedChannelSubject;
    private final BehaviorSubject<Long> selectedGuildSubject;
    private final long sourceChannelId;
    private final long sourceGuildId;
    private final StoreChannels storeChannels;
    private final StoreGuilds storeGuilds;
    private final StorePermissions storePermissions;

    /* JADX INFO: renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheetViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelFollowSheetViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ViewState.Loaded, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewState.Loaded loaded) {
            invoke2(loaded);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewState.Loaded loaded) {
            Intrinsics3.checkNotNullParameter(loaded, "viewState");
            WidgetChannelFollowSheetViewModel.this.updateViewState(loaded);
        }
    }

    /* JADX INFO: compiled from: WidgetChannelFollowSheetViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: WidgetChannelFollowSheetViewModel.kt */
        public static final class FollowSuccess extends Event {
            public static final FollowSuccess INSTANCE = new FollowSuccess();

            private FollowSuccess() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetChannelFollowSheetViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: WidgetChannelFollowSheetViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final Set<Long> availableChannels;
            private final Set<Long> availableGuilds;
            private final Integer errorTextRes;
            private final Channel selectedChannel;
            private final Guild selectedGuild;
            private final Channel sourceChannel;
            private final Guild sourceGuild;

            public /* synthetic */ Loaded(Channel channel, Guild guild, Guild guild2, Channel channel2, Set set, Set set2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(channel, guild, guild2, channel2, set, set2, (i & 64) != 0 ? null : num);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, Channel channel, Guild guild, Guild guild2, Channel channel2, Set set, Set set2, Integer num, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = loaded.sourceChannel;
                }
                if ((i & 2) != 0) {
                    guild = loaded.sourceGuild;
                }
                Guild guild3 = guild;
                if ((i & 4) != 0) {
                    guild2 = loaded.selectedGuild;
                }
                Guild guild4 = guild2;
                if ((i & 8) != 0) {
                    channel2 = loaded.selectedChannel;
                }
                Channel channel3 = channel2;
                if ((i & 16) != 0) {
                    set = loaded.availableGuilds;
                }
                Set set3 = set;
                if ((i & 32) != 0) {
                    set2 = loaded.availableChannels;
                }
                Set set4 = set2;
                if ((i & 64) != 0) {
                    num = loaded.errorTextRes;
                }
                return loaded.copy(channel, guild3, guild4, channel3, set3, set4, num);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Channel getSourceChannel() {
                return this.sourceChannel;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Guild getSourceGuild() {
                return this.sourceGuild;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final Guild getSelectedGuild() {
                return this.selectedGuild;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final Channel getSelectedChannel() {
                return this.selectedChannel;
            }

            public final Set<Long> component5() {
                return this.availableGuilds;
            }

            public final Set<Long> component6() {
                return this.availableChannels;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final Integer getErrorTextRes() {
                return this.errorTextRes;
            }

            public final Loaded copy(Channel sourceChannel, Guild sourceGuild, Guild selectedGuild, Channel selectedChannel, Set<Long> availableGuilds, Set<Long> availableChannels, Integer errorTextRes) {
                Intrinsics3.checkNotNullParameter(availableGuilds, "availableGuilds");
                Intrinsics3.checkNotNullParameter(availableChannels, "availableChannels");
                return new Loaded(sourceChannel, sourceGuild, selectedGuild, selectedChannel, availableGuilds, availableChannels, errorTextRes);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.sourceChannel, loaded.sourceChannel) && Intrinsics3.areEqual(this.sourceGuild, loaded.sourceGuild) && Intrinsics3.areEqual(this.selectedGuild, loaded.selectedGuild) && Intrinsics3.areEqual(this.selectedChannel, loaded.selectedChannel) && Intrinsics3.areEqual(this.availableGuilds, loaded.availableGuilds) && Intrinsics3.areEqual(this.availableChannels, loaded.availableChannels) && Intrinsics3.areEqual(this.errorTextRes, loaded.errorTextRes);
            }

            public final Set<Long> getAvailableChannels() {
                return this.availableChannels;
            }

            public final Set<Long> getAvailableGuilds() {
                return this.availableGuilds;
            }

            public final Integer getErrorTextRes() {
                return this.errorTextRes;
            }

            public final Channel getSelectedChannel() {
                return this.selectedChannel;
            }

            public final Guild getSelectedGuild() {
                return this.selectedGuild;
            }

            public final Channel getSourceChannel() {
                return this.sourceChannel;
            }

            public final Guild getSourceGuild() {
                return this.sourceGuild;
            }

            public int hashCode() {
                Channel channel = this.sourceChannel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                Guild guild = this.sourceGuild;
                int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
                Guild guild2 = this.selectedGuild;
                int iHashCode3 = (iHashCode2 + (guild2 != null ? guild2.hashCode() : 0)) * 31;
                Channel channel2 = this.selectedChannel;
                int iHashCode4 = (iHashCode3 + (channel2 != null ? channel2.hashCode() : 0)) * 31;
                Set<Long> set = this.availableGuilds;
                int iHashCode5 = (iHashCode4 + (set != null ? set.hashCode() : 0)) * 31;
                Set<Long> set2 = this.availableChannels;
                int iHashCode6 = (iHashCode5 + (set2 != null ? set2.hashCode() : 0)) * 31;
                Integer num = this.errorTextRes;
                return iHashCode6 + (num != null ? num.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(sourceChannel=");
                sbU.append(this.sourceChannel);
                sbU.append(", sourceGuild=");
                sbU.append(this.sourceGuild);
                sbU.append(", selectedGuild=");
                sbU.append(this.selectedGuild);
                sbU.append(", selectedChannel=");
                sbU.append(this.selectedChannel);
                sbU.append(", availableGuilds=");
                sbU.append(this.availableGuilds);
                sbU.append(", availableChannels=");
                sbU.append(this.availableChannels);
                sbU.append(", errorTextRes=");
                return outline.F(sbU, this.errorTextRes, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(Channel channel, Guild guild, Guild guild2, Channel channel2, Set<Long> set, Set<Long> set2, Integer num) {
                super(null);
                Intrinsics3.checkNotNullParameter(set, "availableGuilds");
                Intrinsics3.checkNotNullParameter(set2, "availableChannels");
                this.sourceChannel = channel;
                this.sourceGuild = guild;
                this.selectedGuild = guild2;
                this.selectedChannel = channel2;
                this.availableGuilds = set;
                this.availableChannels = set2;
                this.errorTextRes = num;
            }
        }

        /* JADX INFO: compiled from: WidgetChannelFollowSheetViewModel.kt */
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

    /* JADX INFO: renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheetViewModel$followChannel$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelFollowSheetViewModel.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Error, Unit> {
        public AnonymousClass1(WidgetChannelFollowSheetViewModel widgetChannelFollowSheetViewModel) {
            super(1, widgetChannelFollowSheetViewModel, WidgetChannelFollowSheetViewModel.class, "handleChannelFollowError", "handleChannelFollowError(Lcom/discord/utilities/error/Error;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "p1");
            ((WidgetChannelFollowSheetViewModel) this.receiver).handleChannelFollowError(error);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheetViewModel$followChannel$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelFollowSheetViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            WidgetChannelFollowSheetViewModel.this.eventSubject.k.onNext((T) Event.FollowSuccess.INSTANCE);
        }
    }

    public /* synthetic */ WidgetChannelFollowSheetViewModel(long j, long j2, StoreGuilds storeGuilds, StoreChannels storeChannels, StorePermissions storePermissions, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, (i & 4) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 8) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 16) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions);
    }

    private final Observable<Map<Long, List<Channel>>> calculateChannelsWithPermissions() {
        return this.storePermissions.observePermissionsForAllChannels().r().Y(new Func1<Map<Long, ? extends Long>, Observable<? extends Map<Long, ? extends List<? extends Channel>>>>() { // from class: com.discord.widgets.announcements.WidgetChannelFollowSheetViewModel.calculateChannelsWithPermissions.1
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Observable<? extends Map<Long, ? extends List<? extends Channel>>> call(Map<Long, ? extends Long> map) {
                return call2((Map<Long, Long>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends Map<Long, List<Channel>>> call2(final Map<Long, Long> map) {
                return WidgetChannelFollowSheetViewModel.this.getStoreChannels().observeGuildAndPrivateChannels().r().G(new Func1<Map<Long, ? extends Channel>, Map<Long, ? extends List<? extends Channel>>>() { // from class: com.discord.widgets.announcements.WidgetChannelFollowSheetViewModel.calculateChannelsWithPermissions.1.1
                    @Override // j0.k.Func1
                    public /* bridge */ /* synthetic */ Map<Long, ? extends List<? extends Channel>> call(Map<Long, ? extends Channel> map2) {
                        return call2((Map<Long, Channel>) map2);
                    }

                    /* JADX WARN: Code duplicated, block: B:16:0x005f  */
                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final Map<Long, List<Channel>> call2(Map<Long, Channel> map2) {
                        boolean z2;
                        Intrinsics3.checkNotNullExpressionValue(map2, "it");
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        for (Map.Entry<Long, Channel> entry : map2.entrySet()) {
                            long jLongValue = entry.getKey().longValue();
                            Channel value = entry.getValue();
                            if (value.getType() == 5 || value.getType() == 0) {
                                Long l = (Long) map.get(Long.valueOf(jLongValue));
                                if (PermissionUtils.can(Permission.MANAGE_WEBHOOKS, Long.valueOf(l != null ? l.longValue() : 0L))) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                linkedHashMap.put(entry.getKey(), entry.getValue());
                            }
                        }
                        Collection collectionValues = linkedHashMap.values();
                        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                        for (T t : collectionValues) {
                            Long lValueOf = Long.valueOf(((Channel) t).getGuildId());
                            Object arrayList = linkedHashMap2.get(lValueOf);
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                linkedHashMap2.put(lValueOf, arrayList);
                            }
                            ((List) arrayList).add(t);
                        }
                        return linkedHashMap2;
                    }
                });
            }
        });
    }

    private final void handleChannelFollowError(Error error) {
        Error.Response response = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response, "error.response");
        int i = response.getCode() != 30007 ? R.string.follow_modal_fail : R.string.follow_modal_too_many_webhooks;
        ViewState viewState = getViewState();
        Objects.requireNonNull(viewState, "null cannot be cast to non-null type com.discord.widgets.announcements.WidgetChannelFollowSheetViewModel.ViewState.Loaded");
        updateViewState(ViewState.Loaded.copy$default((ViewState.Loaded) viewState, null, null, null, null, null, null, Integer.valueOf(i), 63, null));
    }

    private final Observable<ViewState.Loaded> observeViewStateFromStores() {
        Observable<ViewState.Loaded> observableG = Observable.g(this.storeGuilds.observeGuild(this.sourceGuildId), this.storeChannels.observeChannel(this.sourceChannelId), calculateChannelsWithPermissions(), this.selectedGuildSubject.Y(new Func1<Long, Observable<? extends Guild>>() { // from class: com.discord.widgets.announcements.WidgetChannelFollowSheetViewModel.observeViewStateFromStores.1
            @Override // j0.k.Func1
            public final Observable<? extends Guild> call(Long l) {
                if (l != null) {
                    Observable<Guild> observableObserveGuild = WidgetChannelFollowSheetViewModel.this.getStoreGuilds().observeGuild(l.longValue());
                    if (observableObserveGuild != null) {
                        return observableObserveGuild;
                    }
                }
                return new ScalarSynchronousObservable(null);
            }
        }), this.selectedChannelSubject.Y(new Func1<Long, Observable<? extends Channel>>() { // from class: com.discord.widgets.announcements.WidgetChannelFollowSheetViewModel.observeViewStateFromStores.2
            @Override // j0.k.Func1
            public final Observable<? extends Channel> call(Long l) {
                if (l != null) {
                    Observable<Channel> observableObserveChannel = WidgetChannelFollowSheetViewModel.this.getStoreChannels().observeChannel(l.longValue());
                    if (observableObserveChannel != null) {
                        return observableObserveChannel;
                    }
                }
                return new ScalarSynchronousObservable(null);
            }
        }), new Func5<Guild, Channel, Map<Long, ? extends List<? extends Channel>>, Guild, Channel, ViewState.Loaded>() { // from class: com.discord.widgets.announcements.WidgetChannelFollowSheetViewModel.observeViewStateFromStores.3
            @Override // rx.functions.Func5
            public /* bridge */ /* synthetic */ ViewState.Loaded call(Guild guild, Channel channel, Map<Long, ? extends List<? extends Channel>> map, Guild guild2, Channel channel2) {
                return call2(guild, channel, (Map<Long, ? extends List<Channel>>) map, guild2, channel2);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final ViewState.Loaded call2(Guild guild, Channel channel, Map<Long, ? extends List<Channel>> map, Guild guild2, Channel channel2) {
                Set<Long> setKeySet = map.keySet();
                List listFlatten = Iterables2.flatten(map.values());
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listFlatten, 10));
                Iterator it = listFlatten.iterator();
                while (it.hasNext()) {
                    arrayList.add(Long.valueOf(((Channel) it.next()).getId()));
                }
                return new ViewState.Loaded(channel, guild, guild2, channel2, setKeySet, _Collections.toSet(arrayList), null, 64, null);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "Observable.combineLatest…  )\n\n      expected\n    }");
        return observableG;
    }

    public final void followChannel(long webhookChannelId) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().createChannelFollower(this.sourceChannelId, new RestAPIParams.ChannelFollowerPost(webhookChannelId)), false, 1, null), this, null, 2, null), (Class<?>) WidgetChannelFollowSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass1(this)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }

    public final StoreChannels getStoreChannels() {
        return this.storeChannels;
    }

    public final StoreGuilds getStoreGuilds() {
        return this.storeGuilds;
    }

    public final StorePermissions getStorePermissions() {
        return this.storePermissions;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void selectChannel(long channelId) {
        this.selectedChannelSubject.onNext(Long.valueOf(channelId));
    }

    public final void selectGuild(long guildId) {
        this.selectedGuildSubject.onNext(Long.valueOf(guildId));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelFollowSheetViewModel(long j, long j2, StoreGuilds storeGuilds, StoreChannels storeChannels, StorePermissions storePermissions) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
        this.sourceGuildId = j;
        this.sourceChannelId = j2;
        this.storeGuilds = storeGuilds;
        this.storeChannels = storeChannels;
        this.storePermissions = storePermissions;
        this.selectedGuildSubject = BehaviorSubject.l0(null);
        this.selectedChannelSubject = BehaviorSubject.l0(null);
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observeViewStateFromStores()), this, null, 2, null), (Class<?>) WidgetChannelFollowSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
