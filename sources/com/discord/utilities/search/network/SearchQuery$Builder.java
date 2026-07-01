package com.discord.utilities.search.network;

import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.query.node.answer.AnswerNode;
import com.discord.utilities.search.query.node.content.ContentNode;
import com.discord.utilities.search.query.node.filter.FilterNode;
import com.discord.utilities.search.validation.SearchData;
import d0.g0.w;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: SearchQuery.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SearchQuery$Builder {
    private boolean includeNsfw;
    private final StringBuilder contentBuilder = new StringBuilder();
    private final HashMap<String, List<String>> paramsMap = new HashMap<>();

    private final void appendContent(CharSequence content) {
        StringBuilder sb = this.contentBuilder;
        sb.append(content);
        sb.append(' ');
    }

    public final void appendParam(String paramKey, String param) {
        m.checkNotNullParameter(paramKey, "paramKey");
        m.checkNotNullParameter(param, "param");
        List<String> arrayList = this.paramsMap.get(paramKey);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(param);
        this.paramsMap.put(paramKey, arrayList);
    }

    public final SearchQuery buildFrom(List<? extends QueryNode> queryNodes, SearchData searchData) {
        m.checkNotNullParameter(queryNodes, "queryNodes");
        m.checkNotNullParameter(searchData, "searchData");
        Iterator<T> it = queryNodes.iterator();
        loop0: while (true) {
            FilterType filterType = null;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                QueryNode queryNode = (QueryNode) it.next();
                if (queryNode instanceof FilterNode) {
                    filterType = ((FilterNode) queryNode).getFilterType();
                } else {
                    if (queryNode instanceof AnswerNode) {
                        AnswerNode answerNode = (AnswerNode) queryNode;
                        if (!u.contains(answerNode.getValidFilters(), filterType)) {
                            appendContent(queryNode.getText());
                            break;
                        }
                        answerNode.updateQuery(this, searchData, filterType);
                        break;
                    }
                    if (queryNode instanceof ContentNode) {
                        appendContent(((ContentNode) queryNode).getText());
                        break;
                    }
                }
            }
        }
        String string = this.contentBuilder.toString();
        m.checkNotNullExpressionValue(string, "contentBuilder.toString()");
        Objects.requireNonNull(string, "null cannot be cast to non-null type kotlin.CharSequence");
        String string2 = w.trim(string).toString();
        if (string2.length() > 0) {
            this.paramsMap.put("content", n.mutableListOf(string2));
        }
        return new SearchQuery(this.paramsMap, this.includeNsfw);
    }

    public final SearchQuery$Builder setIncludeNsfw(boolean includeNsfw) {
        this.includeNsfw = includeNsfw;
        return this;
    }
}
