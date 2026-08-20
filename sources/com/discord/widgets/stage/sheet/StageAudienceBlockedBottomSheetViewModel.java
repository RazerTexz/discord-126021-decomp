package com.discord.widgets.stage.sheet;

import com.discord.api.channel.Channel;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserRelationships;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.voice.model.CallModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func3;

/* JADX INFO: compiled from: StageAudienceBlockedBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageAudienceBlockedBottomSheetViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.StageAudienceBlockedBottomSheetViewModel$1 */
    /* JADX INFO: compiled from: StageAudienceBlockedBottomSheetViewModel.kt */
    public static final /* synthetic */ class C100161 extends C12236k implements Function1<StoreState, Unit> {
        public C100161(StageAudienceBlockedBottomSheetViewModel stageAudienceBlockedBottomSheetViewModel) {
            super(1, stageAudienceBlockedBottomSheetViewModel, StageAudienceBlockedBottomSheetViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            C12238m.checkNotNullParameter(storeState, "p1");
            ((StageAudienceBlockedBottomSheetViewModel) this.receiver).handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: StageAudienceBlockedBottomSheetViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStores(final long channelId, StoreUserRelationships userRelationshipsStore, StoreStageChannels stageStore) {
            Observable<StoreState> observableM11075i = Observable.m11075i(CallModel.INSTANCE.get(channelId), userRelationshipsStore.observeForType(2), stageStore.observeStageRolesByChannel(channelId), new Func3<CallModel, Map<Long, ? extends Integer>, Map<Long, ? extends StageRoles>, StoreState>() { // from class: com.discord.widgets.stage.sheet.StageAudienceBlockedBottomSheetViewModel$Companion$observeStores$1
                @Override // p658rx.functions.Func3
                public /* bridge */ /* synthetic */ StageAudienceBlockedBottomSheetViewModel.StoreState call(CallModel callModel, Map<Long, ? extends Integer> map, Map<Long, ? extends StageRoles> map2) {
                    return call2(callModel, (Map<Long, Integer>) map, (Map<Long, StageRoles>) map2);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final StageAudienceBlockedBottomSheetViewModel.StoreState call2(CallModel callModel, Map<Long, Integer> map, Map<Long, StageRoles> map2) {
                    long j = channelId;
                    Set<Long> setKeySet = map.keySet();
                    if (map2 == null) {
                        map2 = C12136h0.emptyMap();
                    }
                    return new StageAudienceBlockedBottomSheetViewModel.StoreState(j, callModel, setKeySet, map2);
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11075i, "Observable.combineLatest… emptyMap()\n      )\n    }");
            return observableM11075i;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: StageAudienceBlockedBottomSheetViewModel.kt */
    public static final /* data */ class StoreState {
        private final Set<Long> blockedUsers;
        private final CallModel callModel;
        private final long channelId;
        private final Map<Long, StageRoles> stageRoles;

        public StoreState(long j, CallModel callModel, Set<Long> set, Map<Long, StageRoles> map) {
            C12238m.checkNotNullParameter(set, "blockedUsers");
            C12238m.checkNotNullParameter(map, "stageRoles");
            this.channelId = j;
            this.callModel = callModel;
            this.blockedUsers = set;
            this.stageRoles = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, long j, CallModel callModel, Set set, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                j = storeState.channelId;
            }
            long j2 = j;
            if ((i & 2) != 0) {
                callModel = storeState.callModel;
            }
            CallModel callModel2 = callModel;
            if ((i & 4) != 0) {
                set = storeState.blockedUsers;
            }
            Set set2 = set;
            if ((i & 8) != 0) {
                map = storeState.stageRoles;
            }
            return storeState.copy(j2, callModel2, set2, map);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final CallModel getCallModel() {
            return this.callModel;
        }

        public final Set<Long> component3() {
            return this.blockedUsers;
        }

        public final Map<Long, StageRoles> component4() {
            return this.stageRoles;
        }

        public final StoreState copy(long channelId, CallModel callModel, Set<Long> blockedUsers, Map<Long, StageRoles> stageRoles) {
            C12238m.checkNotNullParameter(blockedUsers, "blockedUsers");
            C12238m.checkNotNullParameter(stageRoles, "stageRoles");
            return new StoreState(channelId, callModel, blockedUsers, stageRoles);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return this.channelId == storeState.channelId && C12238m.areEqual(this.callModel, storeState.callModel) && C12238m.areEqual(this.blockedUsers, storeState.blockedUsers) && C12238m.areEqual(this.stageRoles, storeState.stageRoles);
        }

        public final Set<Long> getBlockedUsers() {
            return this.blockedUsers;
        }

        public final CallModel getCallModel() {
            return this.callModel;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final Map<Long, StageRoles> getStageRoles() {
            return this.stageRoles;
        }

        public int hashCode() {
            int iM3a = C0002b.m3a(this.channelId) * 31;
            CallModel callModel = this.callModel;
            int iHashCode = (iM3a + (callModel != null ? callModel.hashCode() : 0)) * 31;
            Set<Long> set = this.blockedUsers;
            int iHashCode2 = (iHashCode + (set != null ? set.hashCode() : 0)) * 31;
            Map<Long, StageRoles> map = this.stageRoles;
            return iHashCode2 + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StoreState(channelId=");
            sbM833U.append(this.channelId);
            sbM833U.append(", callModel=");
            sbM833U.append(this.callModel);
            sbM833U.append(", blockedUsers=");
            sbM833U.append(this.blockedUsers);
            sbM833U.append(", stageRoles=");
            return C1643a.m825M(sbM833U, this.stageRoles, ")");
        }
    }

    /* JADX INFO: compiled from: StageAudienceBlockedBottomSheetViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: StageAudienceBlockedBottomSheetViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StageAudienceBlockedBottomSheetViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final Channel channel;
            private final List<MGRecyclerDataPayload> listItems;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(Channel channel, List<? extends MGRecyclerDataPayload> list) {
                super(null);
                C12238m.checkNotNullParameter(channel, "channel");
                C12238m.checkNotNullParameter(list, "listItems");
                this.channel = channel;
                this.listItems = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, Channel channel, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = loaded.channel;
                }
                if ((i & 2) != 0) {
                    list = loaded.listItems;
                }
                return loaded.copy(channel, list);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            public final List<MGRecyclerDataPayload> component2() {
                return this.listItems;
            }

            public final Loaded copy(Channel channel, List<? extends MGRecyclerDataPayload> listItems) {
                C12238m.checkNotNullParameter(channel, "channel");
                C12238m.checkNotNullParameter(listItems, "listItems");
                return new Loaded(channel, listItems);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return C12238m.areEqual(this.channel, loaded.channel) && C12238m.areEqual(this.listItems, loaded.listItems);
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final List<MGRecyclerDataPayload> getListItems() {
                return this.listItems;
            }

            public int hashCode() {
                Channel channel = this.channel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                List<MGRecyclerDataPayload> list = this.listItems;
                return iHashCode + (list != null ? list.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Loaded(channel=");
                sbM833U.append(this.channel);
                sbM833U.append(", listItems=");
                return C1643a.m824L(sbM833U, this.listItems, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ StageAudienceBlockedBottomSheetViewModel(long j, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0) {
            Companion companion = INSTANCE;
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observable = companion.observeStores(j, companion2.getUserRelationships(), companion2.getStageChannels());
        }
        this(j, observable);
    }

    private final void handleStoreState(StoreState storeState) {
        ViewState loaded;
        CallModel callModel = storeState.getCallModel();
        if (callModel != null) {
            Map<Long, StoreVoiceParticipants.VoiceUser> participants = callModel.getParticipants();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<Map.Entry<Long, StoreVoiceParticipants.VoiceUser>> it = participants.entrySet().iterator();
            while (true) {
                boolean z2 = false;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Long, StoreVoiceParticipants.VoiceUser> next = it.next();
                long jLongValue = next.getKey().longValue();
                if (next.getValue().isConnected() && storeState.getBlockedUsers().contains(Long.valueOf(jLongValue))) {
                    z2 = true;
                }
                if (z2) {
                    linkedHashMap.put(next.getKey(), next.getValue());
                }
            }
            ArrayList arrayList = new ArrayList(linkedHashMap.size());
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                long jLongValue2 = ((Number) entry.getKey()).longValue();
                StoreVoiceParticipants.VoiceUser voiceUser = (StoreVoiceParticipants.VoiceUser) entry.getValue();
                StageRoles stageRoles = storeState.getStageRoles().get(Long.valueOf(jLongValue2));
                arrayList.add(new StageAudienceBlockedBottomSheetAdapter.ListItem.Participant(voiceUser, stageRoles != null && StageRoles.m11410isSpeakerimpl(stageRoles.m11412unboximpl())));
            }
            Channel channel = callModel.getChannel();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new StageAudienceBlockedBottomSheetAdapter.ListItem.Header(arrayList.size()));
            arrayList2.addAll(arrayList);
            loaded = new ViewState.Loaded(channel, arrayList2);
        } else {
            loaded = ViewState.Invalid.INSTANCE;
        }
        updateViewState(loaded);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageAudienceBlockedBottomSheetViewModel(long j, Observable<StoreState> observable) {
        super(null, 1, null);
        C12238m.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = j;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) StageAudienceBlockedBottomSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C100161(this));
    }
}
