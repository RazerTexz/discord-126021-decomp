package com.discord.widgets.search.suggestions;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.utilities.search.suggestion.SearchSuggestionEngine;
import com.discord.utilities.search.validation.SearchData;
import d0.t.u;
import d0.z.d.m;
import java.util.Collection;
import java.util.List;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetSearchSuggestions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchSuggestions$Model$Companion$get$1<T1, T2, T3, R> implements Func3<SearchData, List<? extends QueryNode>, Collection<? extends List<? extends QueryNode>>, WidgetSearchSuggestions$Model> {
    public final /* synthetic */ SearchStringProvider $searchStringProvider;

    public WidgetSearchSuggestions$Model$Companion$get$1(SearchStringProvider searchStringProvider) {
        this.$searchStringProvider = searchStringProvider;
    }

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetSearchSuggestions$Model call(SearchData searchData, List<? extends QueryNode> list, Collection<? extends List<? extends QueryNode>> collection) {
        return call2(searchData, list, collection);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetSearchSuggestions$Model call2(SearchData searchData, List<? extends QueryNode> list, Collection<? extends List<? extends QueryNode>> collection) {
        m.checkNotNullParameter(searchData, "searchData");
        m.checkNotNullParameter(list, "queryNodes");
        m.checkNotNullParameter(collection, "history");
        List<QueryNode> mutableList = u.toMutableList((Collection) list);
        QueryNode.Preprocessor.preprocess(mutableList, searchData);
        return new WidgetSearchSuggestions$Model(mutableList, SearchSuggestionEngine.getSuggestions(mutableList, searchData, this.$searchStringProvider, collection));
    }
}
