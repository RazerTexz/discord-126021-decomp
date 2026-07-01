package com.discord.widgets.botuikit;

import b.d.b.a.outline;
import com.discord.api.botuikit.SelectComponent2;
import com.discord.stores.StoreApplicationInteractions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import d0.d0._Ranges;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t._Collections;
import d0.t._Sets;
import d0.z.d.Intrinsics3;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func3;

/* JADX INFO: compiled from: ComponentChatListState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ComponentChatListState {
    public static final ComponentChatListState INSTANCE = new ComponentChatListState();

    /* JADX INFO: compiled from: ComponentChatListState.kt */
    public static final /* data */ class ComponentStoreState {
        private final boolean animateEmojis;
        private final Map<Integer, StoreApplicationInteractions.InteractionSendState> interactionState;
        private final Map<Integer, List<SelectComponent2>> selections;

        public ComponentStoreState() {
            this(null, null, false, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ComponentStoreState(Map<Integer, ? extends StoreApplicationInteractions.InteractionSendState> map, Map<Integer, ? extends List<SelectComponent2>> map2, boolean z2) {
            this.interactionState = map;
            this.selections = map2;
            this.animateEmojis = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ComponentStoreState copy$default(ComponentStoreState componentStoreState, Map map, Map map2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                map = componentStoreState.interactionState;
            }
            if ((i & 2) != 0) {
                map2 = componentStoreState.selections;
            }
            if ((i & 4) != 0) {
                z2 = componentStoreState.animateEmojis;
            }
            return componentStoreState.copy(map, map2, z2);
        }

        public final Map<Integer, StoreApplicationInteractions.InteractionSendState> component1() {
            return this.interactionState;
        }

        public final Map<Integer, List<SelectComponent2>> component2() {
            return this.selections;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getAnimateEmojis() {
            return this.animateEmojis;
        }

        public final ComponentStoreState copy(Map<Integer, ? extends StoreApplicationInteractions.InteractionSendState> interactionState, Map<Integer, ? extends List<SelectComponent2>> selections, boolean animateEmojis) {
            return new ComponentStoreState(interactionState, selections, animateEmojis);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ComponentStoreState)) {
                return false;
            }
            ComponentStoreState componentStoreState = (ComponentStoreState) other;
            return Intrinsics3.areEqual(this.interactionState, componentStoreState.interactionState) && Intrinsics3.areEqual(this.selections, componentStoreState.selections) && this.animateEmojis == componentStoreState.animateEmojis;
        }

        public final boolean getAnimateEmojis() {
            return this.animateEmojis;
        }

        public final Map<Integer, StoreApplicationInteractions.InteractionSendState> getInteractionState() {
            return this.interactionState;
        }

        public final Map<Integer, List<SelectComponent2>> getSelections() {
            return this.selections;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            Map<Integer, StoreApplicationInteractions.InteractionSendState> map = this.interactionState;
            int iHashCode = (map != null ? map.hashCode() : 0) * 31;
            Map<Integer, List<SelectComponent2>> map2 = this.selections;
            int iHashCode2 = (iHashCode + (map2 != null ? map2.hashCode() : 0)) * 31;
            boolean z2 = this.animateEmojis;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode2 + r1;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ComponentStoreState(interactionState=");
            sbU.append(this.interactionState);
            sbU.append(", selections=");
            sbU.append(this.selections);
            sbU.append(", animateEmojis=");
            return outline.O(sbU, this.animateEmojis, ")");
        }

        public /* synthetic */ ComponentStoreState(Map map, Map map2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Maps6.emptyMap() : map, (i & 2) != 0 ? Maps6.emptyMap() : map2, (i & 4) != 0 ? true : z2);
        }
    }

    private ComponentChatListState() {
    }

    public final Observable<Map<Long, ComponentStoreState>> observeChatListComponentState() {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<Map<Long, ComponentStoreState>> observableI = Observable.i(companion.getInteractions().observeComponentInteractionState(), companion.getLocalActionComponentState().observeSelectComponentSelections(), StoreUserSettings.observeIsAnimatedEmojisEnabled$default(companion.getUserSettings(), false, 1, null), new Func3<Map<Long, ? extends Map<Integer, ? extends StoreApplicationInteractions.InteractionSendState>>, Map<Long, ? extends Map<Integer, ? extends List<? extends SelectComponent2>>>, Boolean, Map<Long, ? extends ComponentStoreState>>() { // from class: com.discord.widgets.botuikit.ComponentChatListState.observeChatListComponentState.1
            @Override // rx.functions.Func3
            public /* bridge */ /* synthetic */ Map<Long, ? extends ComponentStoreState> call(Map<Long, ? extends Map<Integer, ? extends StoreApplicationInteractions.InteractionSendState>> map, Map<Long, ? extends Map<Integer, ? extends List<? extends SelectComponent2>>> map2, Boolean bool) {
                return call2(map, (Map<Long, ? extends Map<Integer, ? extends List<SelectComponent2>>>) map2, bool);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Map<Long, ComponentStoreState> call2(Map<Long, ? extends Map<Integer, ? extends StoreApplicationInteractions.InteractionSendState>> map, Map<Long, ? extends Map<Integer, ? extends List<SelectComponent2>>> map2, Boolean bool) {
                List listDistinct = _Collections.distinct(_Sets.plus((Set) map.keySet(), (Iterable) map2.keySet()));
                LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(listDistinct, 10)), 16));
                for (Object obj : listDistinct) {
                    long jLongValue = ((Number) obj).longValue();
                    Map<Integer, ? extends StoreApplicationInteractions.InteractionSendState> map3 = map.get(Long.valueOf(jLongValue));
                    Map<Integer, ? extends List<SelectComponent2>> map4 = map2.get(Long.valueOf(jLongValue));
                    Intrinsics3.checkNotNullExpressionValue(bool, "animateEmojis");
                    linkedHashMap.put(obj, new ComponentStoreState(map3, map4, bool.booleanValue()));
                }
                return linkedHashMap;
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableI, "Observable.combineLatest…s\n        )\n      }\n    }");
        return observableI;
    }
}
