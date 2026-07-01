package com.discord.widgets.guilds;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import j0.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: compiled from: WidgetGuildSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildSelector$get$1<T, R> implements b<LinkedHashMap<Long, Guild>, List<? extends WidgetGuildSelector$Item>> {
    public final /* synthetic */ WidgetGuildSelector$FilterFunction $filterFunction;
    public final /* synthetic */ boolean $includeNoGuild;

    public WidgetGuildSelector$get$1(WidgetGuildSelector$FilterFunction widgetGuildSelector$FilterFunction, boolean z2) {
        this.$filterFunction = widgetGuildSelector$FilterFunction;
        this.$includeNoGuild = z2;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ List<? extends WidgetGuildSelector$Item> call(LinkedHashMap<Long, Guild> linkedHashMap) {
        return call2(linkedHashMap);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<WidgetGuildSelector$Item> call2(LinkedHashMap<Long, Guild> linkedHashMap) {
        Collection<Guild> collectionValues = linkedHashMap.values();
        m.checkNotNullExpressionValue(collectionValues, "guilds.values");
        WidgetGuildSelector$FilterFunction widgetGuildSelector$FilterFunction = this.$filterFunction;
        ArrayList arrayList = new ArrayList();
        for (T t : collectionValues) {
            if (widgetGuildSelector$FilterFunction.includeGuild((Guild) t)) {
                arrayList.add(t);
            }
        }
        List listListOf = this.$includeNoGuild ? d0.t.m.listOf(new WidgetGuildSelector$Item(null)) : n.emptyList();
        ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(arrayList, 10));
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new WidgetGuildSelector$Item((Guild) it.next()));
        }
        return u.plus((Collection) listListOf, (Iterable) arrayList2);
    }
}
