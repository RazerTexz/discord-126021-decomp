package com.discord.widgets.botuikit;

import com.discord.api.botuikit.SelectItem;
import com.discord.stores.StoreApplicationInteractions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p512d0.C11226f;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12150o0;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.functions.Func3;

/* JADX INFO: compiled from: ComponentChatListState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ComponentChatListState {
    public static final ComponentChatListState INSTANCE = new ComponentChatListState();

    /* JADX INFO: compiled from: ComponentChatListState.kt */
    public static final /* data */ class ComponentStoreState {
        private final boolean animateEmojis;
        private final Map<Integer, StoreApplicationInteractions.InteractionSendState> interactionState;
        private final Map<Integer, List<SelectItem>> selections;

        public ComponentStoreState() {
            this(null, null, false, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ComponentStoreState(Map<Integer, ? extends StoreApplicationInteractions.InteractionSendState> map, Map<Integer, ? extends List<SelectItem>> map2, boolean z2) {
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

        public final Map<Integer, List<SelectItem>> component2() {
            return this.selections;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getAnimateEmojis() {
            return this.animateEmojis;
        }

        public final ComponentStoreState copy(Map<Integer, ? extends StoreApplicationInteractions.InteractionSendState> interactionState, Map<Integer, ? extends List<SelectItem>> selections, boolean animateEmojis) {
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
            return C12238m.areEqual(this.interactionState, componentStoreState.interactionState) && C12238m.areEqual(this.selections, componentStoreState.selections) && this.animateEmojis == componentStoreState.animateEmojis;
        }

        public final boolean getAnimateEmojis() {
            return this.animateEmojis;
        }

        public final Map<Integer, StoreApplicationInteractions.InteractionSendState> getInteractionState() {
            return this.interactionState;
        }

        public final Map<Integer, List<SelectItem>> getSelections() {
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
            Map<Integer, List<SelectItem>> map2 = this.selections;
            int iHashCode2 = (iHashCode + (map2 != null ? map2.hashCode() : 0)) * 31;
            boolean z2 = this.animateEmojis;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode2 + r1;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ComponentStoreState(interactionState=");
            sbM833U.append(this.interactionState);
            sbM833U.append(", selections=");
            sbM833U.append(this.selections);
            sbM833U.append(", animateEmojis=");
            return C1643a.m827O(sbM833U, this.animateEmojis, ")");
        }

        public /* synthetic */ ComponentStoreState(Map map, Map map2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? C12136h0.emptyMap() : map, (i & 2) != 0 ? C12136h0.emptyMap() : map2, (i & 4) != 0 ? true : z2);
        }
    }

    private ComponentChatListState() {
    }

    public final Observable<Map<Long, ComponentStoreState>> observeChatListComponentState() {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<Map<Long, ComponentStoreState>> observableM11075i = Observable.m11075i(companion.getInteractions().observeComponentInteractionState(), companion.getLocalActionComponentState().observeSelectComponentSelections(), StoreUserSettings.observeIsAnimatedEmojisEnabled$default(companion.getUserSettings(), false, 1, null), new Func3<Map<Long, ? extends Map<Integer, ? extends StoreApplicationInteractions.InteractionSendState>>, Map<Long, ? extends Map<Integer, ? extends List<? extends SelectItem>>>, Boolean, Map<Long, ? extends ComponentStoreState>>() { // from class: com.discord.widgets.botuikit.ComponentChatListState.observeChatListComponentState.1
            @Override // p658rx.functions.Func3
            public /* bridge */ /* synthetic */ Map<Long, ? extends ComponentStoreState> call(Map<Long, ? extends Map<Integer, ? extends StoreApplicationInteractions.InteractionSendState>> map, Map<Long, ? extends Map<Integer, ? extends List<? extends SelectItem>>> map2, Boolean bool) {
                return call2(map, (Map<Long, ? extends Map<Integer, ? extends List<SelectItem>>>) map2, bool);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Map<Long, ComponentStoreState> call2(Map<Long, ? extends Map<Integer, ? extends StoreApplicationInteractions.InteractionSendState>> map, Map<Long, ? extends Map<Integer, ? extends List<SelectItem>>> map2, Boolean bool) {
                List listDistinct = C12163u.distinct(C12150o0.plus((Set) map.keySet(), (Iterable) map2.keySet()));
                LinkedHashMap linkedHashMap = new LinkedHashMap(C11226f.coerceAtLeast(C12134g0.mapCapacity(C12149o.collectionSizeOrDefault(listDistinct, 10)), 16));
                for (Object obj : listDistinct) {
                    long jLongValue = ((Number) obj).longValue();
                    Map<Integer, ? extends StoreApplicationInteractions.InteractionSendState> map3 = map.get(Long.valueOf(jLongValue));
                    Map<Integer, ? extends List<SelectItem>> map4 = map2.get(Long.valueOf(jLongValue));
                    C12238m.checkNotNullExpressionValue(bool, "animateEmojis");
                    linkedHashMap.put(obj, new ComponentStoreState(map3, map4, bool.booleanValue()));
                }
                return linkedHashMap;
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11075i, "Observable.combineLatest…s\n        )\n      }\n    }");
        return observableM11075i;
    }
}
