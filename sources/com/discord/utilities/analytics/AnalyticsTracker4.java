package com.discord.utilities.analytics;

import com.discord.utilities.analytics.Traits;
import com.discord.utilities.collections.CollectionExtensions;
import d0.t.Maps6;
import d0.z.d.Lambda;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.utilities.analytics.AnalyticsTracker$searchResultsEmpty$propertyProvider$1, reason: use source file name */
/* JADX INFO: compiled from: AnalyticsTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnalyticsTracker4 extends Lambda implements Function0<Map<String, ? extends Object>> {
    public final /* synthetic */ Traits.Location $locationTrait;
    public final /* synthetic */ Map $properties;
    public final /* synthetic */ SearchType $searchType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnalyticsTracker4(SearchType searchType, Traits.Location location, Map map) {
        super(0);
        this.$searchType = searchType;
        this.$locationTrait = location;
        this.$properties = map;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Map<String, ? extends Object> invoke() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("search_type", this.$searchType.name());
        Traits.Location location = this.$locationTrait;
        if (location != null) {
            location.serializeTo(linkedHashMap);
        }
        return Maps6.plus(linkedHashMap, CollectionExtensions.filterNonNullValues(this.$properties));
    }
}
