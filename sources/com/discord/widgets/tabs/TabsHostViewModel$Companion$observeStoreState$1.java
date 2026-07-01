package com.discord.widgets.tabs;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import com.discord.panels.PanelState;
import d0.z.d.m;
import java.util.Map;
import rx.functions.Func6;

/* JADX INFO: compiled from: TabsHostViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TabsHostViewModel$Companion$observeStoreState$1<T1, T2, T3, T4, T5, T6, R> implements Func6<PanelState, NavigationTab, Long, Map<Long, ? extends Guild>, Integer, Map<Long, ? extends Integer>, TabsHostViewModel$StoreState> {
    public static final TabsHostViewModel$Companion$observeStoreState$1 INSTANCE = new TabsHostViewModel$Companion$observeStoreState$1();

    @Override // rx.functions.Func6
    public /* bridge */ /* synthetic */ TabsHostViewModel$StoreState call(PanelState panelState, NavigationTab navigationTab, Long l, Map<Long, ? extends Guild> map, Integer num, Map<Long, ? extends Integer> map2) {
        return call2(panelState, navigationTab, l, (Map<Long, Guild>) map, num, (Map<Long, Integer>) map2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final TabsHostViewModel$StoreState call2(PanelState panelState, NavigationTab navigationTab, Long l, Map<Long, Guild> map, Integer num, Map<Long, Integer> map2) {
        m.checkNotNullExpressionValue(panelState, "leftPanelState");
        m.checkNotNullExpressionValue(navigationTab, "selectedTab");
        m.checkNotNullExpressionValue(l, "myUserId");
        long jLongValue = l.longValue();
        m.checkNotNullExpressionValue(map, "guildIdToGuildMap");
        m.checkNotNullExpressionValue(num, "numTotalMentions");
        int iIntValue = num.intValue();
        m.checkNotNullExpressionValue(map2, "userRelationships");
        return new TabsHostViewModel$StoreState(panelState, navigationTab, jLongValue, map, iIntValue, map2);
    }
}
