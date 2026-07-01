package com.discord.utilities.analytics;

import com.discord.utilities.collections.CollectionExtensionsKt;
import d0.t.h0;
import d0.z.d.o;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AnalyticsTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnalyticsTracker$searchResultViewed$propertyProvider$1 extends o implements Function0<Map<String, ? extends Object>> {
    public final /* synthetic */ Traits$Location $locationTrait;
    public final /* synthetic */ Integer $lockedResultsCount;
    public final /* synthetic */ Map $properties;
    public final /* synthetic */ SearchType $searchType;
    public final /* synthetic */ int $totalResultsCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnalyticsTracker$searchResultViewed$propertyProvider$1(SearchType searchType, int i, Integer num, Traits$Location traits$Location, Map map) {
        super(0);
        this.$searchType = searchType;
        this.$totalResultsCount = i;
        this.$lockedResultsCount = num;
        this.$locationTrait = traits$Location;
        this.$properties = map;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<String, ? extends Object> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<String, ? extends Object> invoke2() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("search_type", this.$searchType.name());
        linkedHashMap.put("total_results", Integer.valueOf(this.$totalResultsCount));
        Integer num = this.$lockedResultsCount;
        if (num != null) {
            linkedHashMap.put("num_results_locked", num);
        }
        Traits$Location traits$Location = this.$locationTrait;
        if (traits$Location != null) {
            traits$Location.serializeTo(linkedHashMap);
        }
        return h0.plus(linkedHashMap, CollectionExtensionsKt.filterNonNullValues(this.$properties));
    }
}
