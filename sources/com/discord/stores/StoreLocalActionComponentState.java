package com.discord.stores;

import com.discord.api.botuikit.SelectItem;
import com.discord.stores.StoreApplicationInteractions;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;

/* JADX INFO: compiled from: StoreLocalActionComponentState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreLocalActionComponentState extends StoreV2 {
    private final Map<String, StoreApplicationInteractions.ComponentLocation> componentInteractions;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final Map<Long, Map<Integer, List<SelectItem>>> selectComponentSelections;
    private Map<Long, ? extends Map<Integer, ? extends List<SelectItem>>> selectComponentSelectionsSnapshot;

    /* JADX INFO: renamed from: com.discord.stores.StoreLocalActionComponentState$observeSelectComponentSelections$1 */
    /* JADX INFO: compiled from: StoreLocalActionComponentState.kt */
    public static final class C61431 extends AbstractC12240o implements Function0<Map<Long, ? extends Map<Integer, ? extends List<? extends SelectItem>>>> {
        public C61431() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Map<Integer, ? extends List<? extends SelectItem>>> invoke() {
            return StoreLocalActionComponentState.this.getSelectComponentSelectionsData();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreLocalActionComponentState$setSelectComponentSelection$1 */
    /* JADX INFO: compiled from: StoreLocalActionComponentState.kt */
    public static final class C61441 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ int $componentIndex;
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ List $selectedItems;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C61441(long j, List list, int i) {
            super(0);
            this.$messageId = j;
            this.$selectedItems = list;
            this.$componentIndex = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Map<Integer, List<SelectItem>> linkedHashMap;
            Map<Integer, List<SelectItem>> map = StoreLocalActionComponentState.this.getSelectComponentSelections().get(Long.valueOf(this.$messageId));
            if (map == null || (linkedHashMap = C12136h0.toMutableMap(map)) == null) {
                linkedHashMap = new LinkedHashMap<>();
            }
            linkedHashMap.put(Integer.valueOf(this.$componentIndex), this.$selectedItems);
            StoreLocalActionComponentState.this.getSelectComponentSelections().put(Long.valueOf(this.$messageId), linkedHashMap);
            StoreLocalActionComponentState.this.markChanged();
        }
    }

    public /* synthetic */ StoreLocalActionComponentState(Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    @StoreThread
    public final void clearState(long messageId, Integer componentIndex) {
        Map<Integer, List<SelectItem>> map;
        Map<Integer, List<SelectItem>> mutableMap;
        if (!this.selectComponentSelections.containsKey(Long.valueOf(messageId)) || (map = this.selectComponentSelections.get(Long.valueOf(messageId))) == null || (mutableMap = C12136h0.toMutableMap(map)) == null) {
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

    public final Map<Long, Map<Integer, List<SelectItem>>> getSelectComponentSelections() {
        return this.selectComponentSelections;
    }

    public final Map<Long, Map<Integer, List<SelectItem>>> getSelectComponentSelectionsData() {
        return this.selectComponentSelectionsSnapshot;
    }

    public final Map<Long, Map<Integer, List<SelectItem>>> getSelectComponentSelectionsSnapshot() {
        return this.selectComponentSelectionsSnapshot;
    }

    public final Observable<Map<Long, Map<Integer, List<SelectItem>>>> observeSelectComponentSelections() {
        Observable<Map<Long, Map<Integer, List<SelectItem>>>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C61431(), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    public final void setSelectComponentSelection(long messageId, int componentIndex, List<SelectItem> selectedItems) {
        C12238m.checkNotNullParameter(selectedItems, "selectedItems");
        this.dispatcher.schedule(new C61441(messageId, selectedItems, componentIndex));
    }

    public final void setSelectComponentSelectionsSnapshot(Map<Long, ? extends Map<Integer, ? extends List<SelectItem>>> map) {
        C12238m.checkNotNullParameter(map, "<set-?>");
        this.selectComponentSelectionsSnapshot = map;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        this.selectComponentSelectionsSnapshot = new HashMap(this.selectComponentSelections);
    }

    public StoreLocalActionComponentState(Dispatcher dispatcher, ObservationDeck observationDeck) {
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.componentInteractions = new LinkedHashMap();
        this.selectComponentSelections = new LinkedHashMap();
        this.selectComponentSelectionsSnapshot = C12136h0.emptyMap();
    }
}
