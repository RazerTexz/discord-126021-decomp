package com.discord.utilities.analytics;

import com.discord.utilities.collections.CollectionExtensionsKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: AnalyticsTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnalyticsTracker$searchResultViewed$propertyProvider$1 extends AbstractC12240o implements Function0<Map<String, ? extends Object>> {
    public final /* synthetic */ Traits.Location $locationTrait;
    public final /* synthetic */ Integer $lockedResultsCount;
    public final /* synthetic */ Map $properties;
    public final /* synthetic */ SearchType $searchType;
    public final /* synthetic */ int $totalResultsCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnalyticsTracker$searchResultViewed$propertyProvider$1(SearchType searchType, int i, Integer num, Traits.Location location, Map map) {
        super(0);
        this.$searchType = searchType;
        this.$totalResultsCount = i;
        this.$lockedResultsCount = num;
        this.$locationTrait = location;
        this.$properties = map;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Map<String, ? extends Object> invoke() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("search_type", this.$searchType.name());
        linkedHashMap.put("total_results", Integer.valueOf(this.$totalResultsCount));
        Integer num = this.$lockedResultsCount;
        if (num != null) {
            linkedHashMap.put("num_results_locked", num);
        }
        Traits.Location location = this.$locationTrait;
        if (location != null) {
            location.serializeTo(linkedHashMap);
        }
        return C12136h0.plus(linkedHashMap, CollectionExtensionsKt.filterNonNullValues(this.$properties));
    }
}
