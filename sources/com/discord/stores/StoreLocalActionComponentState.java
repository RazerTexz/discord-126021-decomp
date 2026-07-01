package com.discord.stores;

import com.discord.api.botuikit.SelectComponent2;
import com.discord.stores.StoreApplicationInteractions;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreLocalActionComponentState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreLocalActionComponentState extends StoreV2 {
    private final Map<String, StoreApplicationInteractions.ComponentLocation> componentInteractions;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final Map<Long, Map<Integer, List<SelectComponent2>>> selectComponentSelections;
    private Map<Long, ? extends Map<Integer, ? extends List<SelectComponent2>>> selectComponentSelectionsSnapshot;

    /* JADX INFO: renamed from: com.discord.stores.StoreLocalActionComponentState$observeSelectComponentSelections$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreLocalActionComponentState.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Map<Integer, ? extends List<? extends SelectComponent2>>>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Map<Integer, ? extends List<? extends SelectComponent2>>> invoke() {
            return StoreLocalActionComponentState.this.getSelectComponentSelectionsData();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreLocalActionComponentState$setSelectComponentSelection$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreLocalActionComponentState.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int $componentIndex;
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ List $selectedItems;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, List list, int i) {
            super(0);
            this.$messageId = j;
            this.$selectedItems = list;
            this.$componentIndex = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Map<Integer, List<SelectComponent2>> linkedHashMap;
            Map<Integer, List<SelectComponent2>> map = StoreLocalActionComponentState.this.getSelectComponentSelections().get(Long.valueOf(this.$messageId));
            if (map == null || (linkedHashMap = Maps6.toMutableMap(map)) == null) {
                linkedHashMap = new LinkedHashMap<>();
            }
            linkedHashMap.put(Integer.valueOf(this.$componentIndex), this.$selectedItems);
            StoreLocalActionComponentState.this.getSelectComponentSelections().put(Long.valueOf(this.$messageId), linkedHashMap);
            StoreLocalActionComponentState.this.markChanged();
        }
    }

    public /* synthetic */ StoreLocalActionComponentState(Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    @Store3
    public final void clearState(long messageId, Integer componentIndex) {
        Map<Integer, List<SelectComponent2>> map;
        Map<Integer, List<SelectComponent2>> mutableMap;
        if (!this.selectComponentSelections.containsKey(Long.valueOf(messageId)) || (map = this.selectComponentSelections.get(Long.valueOf(messageId))) == null || (mutableMap = Maps6.toMutableMap(map)) == null) {
            return;
        }
        if (componentIndex != null && mutableMap.containsKey(componentIndex)) {
            mutableMap.remove(componentIndex);
            this.selectComponentSelections.put(Long.valueOf(messageId), mutableMap);
            markChanged();
        } else if (componentIndex == null) {
            this.selectComponentSelections.remove(Long.valueOf(messageId));
            markChanged();
        }
    }

    public final Map<String, StoreApplicationInteractions.ComponentLocation> getComponentInteractions() {
        return this.componentInteractions;
    }

    public final Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final Map<Long, Map<Integer, List<SelectComponent2>>> getSelectComponentSelections() {
        return this.selectComponentSelections;
    }

    public final Map<Long, Map<Integer, List<SelectComponent2>>> getSelectComponentSelectionsData() {
        return this.selectComponentSelectionsSnapshot;
    }

    public final Map<Long, Map<Integer, List<SelectComponent2>>> getSelectComponentSelectionsSnapshot() {
        return this.selectComponentSelectionsSnapshot;
    }

    public final Observable<Map<Long, Map<Integer, List<SelectComponent2>>>> observeSelectComponentSelections() {
        Observable<Map<Long, Map<Integer, List<SelectComponent2>>>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final void setSelectComponentSelection(long messageId, int componentIndex, List<SelectComponent2> selectedItems) {
        Intrinsics3.checkNotNullParameter(selectedItems, "selectedItems");
        this.dispatcher.schedule(new AnonymousClass1(messageId, selectedItems, componentIndex));
    }

    public final void setSelectComponentSelectionsSnapshot(Map<Long, ? extends Map<Integer, ? extends List<SelectComponent2>>> map) {
        Intrinsics3.checkNotNullParameter(map, "<set-?>");
        this.selectComponentSelectionsSnapshot = map;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        this.selectComponentSelectionsSnapshot = new HashMap(this.selectComponentSelections);
    }

    public StoreLocalActionComponentState(Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.componentInteractions = new LinkedHashMap();
        this.selectComponentSelections = new LinkedHashMap();
        this.selectComponentSelectionsSnapshot = Maps6.emptyMap();
    }
}
