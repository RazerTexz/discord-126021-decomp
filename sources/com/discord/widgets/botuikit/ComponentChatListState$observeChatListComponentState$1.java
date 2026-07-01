package com.discord.widgets.botuikit;

import androidx.core.app.NotificationCompat;
import com.discord.api.botuikit.SelectItem;
import com.discord.stores.StoreApplicationInteractions$InteractionSendState;
import d0.d0.f;
import d0.t.g0;
import d0.t.o;
import d0.t.o0;
import d0.t.u;
import d0.z.d.m;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import rx.functions.Func3;

/* JADX INFO: compiled from: ComponentChatListState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ComponentChatListState$observeChatListComponentState$1<T1, T2, T3, R> implements Func3<Map<Long, ? extends Map<Integer, ? extends StoreApplicationInteractions$InteractionSendState>>, Map<Long, ? extends Map<Integer, ? extends List<? extends SelectItem>>>, Boolean, Map<Long, ? extends ComponentChatListState$ComponentStoreState>> {
    public static final ComponentChatListState$observeChatListComponentState$1 INSTANCE = new ComponentChatListState$observeChatListComponentState$1();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ Map<Long, ? extends ComponentChatListState$ComponentStoreState> call(Map<Long, ? extends Map<Integer, ? extends StoreApplicationInteractions$InteractionSendState>> map, Map<Long, ? extends Map<Integer, ? extends List<? extends SelectItem>>> map2, Boolean bool) {
        return call2(map, (Map<Long, ? extends Map<Integer, ? extends List<SelectItem>>>) map2, bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Map<Long, ComponentChatListState$ComponentStoreState> call2(Map<Long, ? extends Map<Integer, ? extends StoreApplicationInteractions$InteractionSendState>> map, Map<Long, ? extends Map<Integer, ? extends List<SelectItem>>> map2, Boolean bool) {
        List listDistinct = u.distinct(o0.plus((Set) map.keySet(), (Iterable) map2.keySet()));
        LinkedHashMap linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(o.collectionSizeOrDefault(listDistinct, 10)), 16));
        for (Object obj : listDistinct) {
            long jLongValue = ((Number) obj).longValue();
            Map<Integer, ? extends StoreApplicationInteractions$InteractionSendState> map3 = map.get(Long.valueOf(jLongValue));
            Map<Integer, ? extends List<SelectItem>> map4 = map2.get(Long.valueOf(jLongValue));
            m.checkNotNullExpressionValue(bool, "animateEmojis");
            linkedHashMap.put(obj, new ComponentChatListState$ComponentStoreState(map3, map4, bool.booleanValue()));
        }
        return linkedHashMap;
    }
}
