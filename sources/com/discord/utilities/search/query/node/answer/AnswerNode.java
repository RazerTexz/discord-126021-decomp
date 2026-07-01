package com.discord.utilities.search.query.node.answer;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.discord.utilities.search.network.SearchQuery$Builder;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.validation.SearchData;
import d0.z.d.m;
import java.util.Set;

/* JADX INFO: compiled from: AnswerNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AnswerNode extends QueryNode {
    public abstract Set<FilterType> getValidFilters();

    public abstract boolean isValid(SearchData searchData);

    @Override // com.discord.simpleast.core.node.Node
    public /* bridge */ /* synthetic */ void render(SpannableStringBuilder spannableStringBuilder, Context context) {
        render2(spannableStringBuilder, context);
    }

    public abstract void updateQuery(SearchQuery$Builder queryBuilder, SearchData searchData, FilterType filterType);

    /* JADX INFO: renamed from: render, reason: avoid collision after fix types in other method */
    public void render2(SpannableStringBuilder builder, Context renderContext) {
        m.checkNotNullParameter(builder, "builder");
        m.checkNotNullParameter(renderContext, "renderContext");
        builder.append(getText()).append(' ');
    }
}
