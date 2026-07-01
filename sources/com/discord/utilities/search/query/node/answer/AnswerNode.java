package com.discord.utilities.search.query.node.answer;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.discord.utilities.search.network.SearchQuery;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.validation.SearchData;
import d0.z.d.Intrinsics3;
import java.util.Set;

/* JADX INFO: compiled from: AnswerNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AnswerNode extends QueryNode {
    public abstract Set<FilterType> getValidFilters();

    public abstract boolean isValid(SearchData searchData);

    public abstract void updateQuery(SearchQuery.Builder queryBuilder, SearchData searchData, FilterType filterType);

    @Override // com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder builder, Context renderContext) {
        Intrinsics3.checkNotNullParameter(builder, "builder");
        Intrinsics3.checkNotNullParameter(renderContext, "renderContext");
        builder.append(getText()).append(' ');
    }
}
