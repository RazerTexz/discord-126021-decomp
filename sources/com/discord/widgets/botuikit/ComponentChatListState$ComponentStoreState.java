package com.discord.widgets.botuikit;

import b.d.b.a.a;
import com.discord.api.botuikit.SelectItem;
import com.discord.stores.StoreApplicationInteractions$InteractionSendState;
import d0.t.h0;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ComponentChatListState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ComponentChatListState$ComponentStoreState {
    private final boolean animateEmojis;
    private final Map<Integer, StoreApplicationInteractions$InteractionSendState> interactionState;
    private final Map<Integer, List<SelectItem>> selections;

    public ComponentChatListState$ComponentStoreState() {
        this(null, null, false, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ComponentChatListState$ComponentStoreState(Map<Integer, ? extends StoreApplicationInteractions$InteractionSendState> map, Map<Integer, ? extends List<SelectItem>> map2, boolean z2) {
        this.interactionState = map;
        this.selections = map2;
        this.animateEmojis = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ComponentChatListState$ComponentStoreState copy$default(ComponentChatListState$ComponentStoreState componentChatListState$ComponentStoreState, Map map, Map map2, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            map = componentChatListState$ComponentStoreState.interactionState;
        }
        if ((i & 2) != 0) {
            map2 = componentChatListState$ComponentStoreState.selections;
        }
        if ((i & 4) != 0) {
            z2 = componentChatListState$ComponentStoreState.animateEmojis;
        }
        return componentChatListState$ComponentStoreState.copy(map, map2, z2);
    }

    public final Map<Integer, StoreApplicationInteractions$InteractionSendState> component1() {
        return this.interactionState;
    }

    public final Map<Integer, List<SelectItem>> component2() {
        return this.selections;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getAnimateEmojis() {
        return this.animateEmojis;
    }

    public final ComponentChatListState$ComponentStoreState copy(Map<Integer, ? extends StoreApplicationInteractions$InteractionSendState> interactionState, Map<Integer, ? extends List<SelectItem>> selections, boolean animateEmojis) {
        return new ComponentChatListState$ComponentStoreState(interactionState, selections, animateEmojis);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ComponentChatListState$ComponentStoreState)) {
            return false;
        }
        ComponentChatListState$ComponentStoreState componentChatListState$ComponentStoreState = (ComponentChatListState$ComponentStoreState) other;
        return m.areEqual(this.interactionState, componentChatListState$ComponentStoreState.interactionState) && m.areEqual(this.selections, componentChatListState$ComponentStoreState.selections) && this.animateEmojis == componentChatListState$ComponentStoreState.animateEmojis;
    }

    public final boolean getAnimateEmojis() {
        return this.animateEmojis;
    }

    public final Map<Integer, StoreApplicationInteractions$InteractionSendState> getInteractionState() {
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
        Map<Integer, StoreApplicationInteractions$InteractionSendState> map = this.interactionState;
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
        StringBuilder sbU = a.U("ComponentStoreState(interactionState=");
        sbU.append(this.interactionState);
        sbU.append(", selections=");
        sbU.append(this.selections);
        sbU.append(", animateEmojis=");
        return a.O(sbU, this.animateEmojis, ")");
    }

    public /* synthetic */ ComponentChatListState$ComponentStoreState(Map map, Map map2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? h0.emptyMap() : map, (i & 2) != 0 ? h0.emptyMap() : map2, (i & 4) != 0 ? true : z2);
    }
}
