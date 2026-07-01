package com.discord.stores;

import com.discord.api.botuikit.SelectItem;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import d0.t.h0;
import d0.z.d.m;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreLocalActionComponentState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreLocalActionComponentState extends StoreV2 {
    private final Map<String, StoreApplicationInteractions$ComponentLocation> componentInteractions;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final Map<Long, Map<Integer, List<SelectItem>>> selectComponentSelections;
    private Map<Long, ? extends Map<Integer, ? extends List<SelectItem>>> selectComponentSelectionsSnapshot;

    public /* synthetic */ StoreLocalActionComponentState(Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    @StoreThread
    public final void clearState(long messageId, Integer componentIndex) {
        Map<Integer, List<SelectItem>> map;
        Map<Integer, List<SelectItem>> mutableMap;
        if (!this.selectComponentSelections.containsKey(Long.valueOf(messageId)) || (map = this.selectComponentSelections.get(Long.valueOf(messageId))) == null || (mutableMap = h0.toMutableMap(map)) == null) {
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

    public final Map<String, StoreApplicationInteractions$ComponentLocation> getComponentInteractions() {
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
        Observable<Map<Long, Map<Integer, List<SelectItem>>>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreLocalActionComponentState$observeSelectComponentSelections$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final void setSelectComponentSelection(long messageId, int componentIndex, List<SelectItem> selectedItems) {
        m.checkNotNullParameter(selectedItems, "selectedItems");
        this.dispatcher.schedule(new StoreLocalActionComponentState$setSelectComponentSelection$1(this, messageId, selectedItems, componentIndex));
    }

    public final void setSelectComponentSelectionsSnapshot(Map<Long, ? extends Map<Integer, ? extends List<SelectItem>>> map) {
        m.checkNotNullParameter(map, "<set-?>");
        this.selectComponentSelectionsSnapshot = map;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        this.selectComponentSelectionsSnapshot = new HashMap(this.selectComponentSelections);
    }

    public StoreLocalActionComponentState(Dispatcher dispatcher, ObservationDeck observationDeck) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.componentInteractions = new LinkedHashMap();
        this.selectComponentSelections = new LinkedHashMap();
        this.selectComponentSelectionsSnapshot = h0.emptyMap();
    }
}
