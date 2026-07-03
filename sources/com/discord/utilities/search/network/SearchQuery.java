package com.discord.utilities.search.network;

import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.query.node.answer.AnswerNode;
import com.discord.utilities.search.query.node.content.ContentNode;
import com.discord.utilities.search.query.node.filter.FilterNode;
import com.discord.utilities.search.validation.SearchData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: SearchQuery.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SearchQuery {
    private final boolean includeNsfw;
    private final Map<String, List<String>> params;

    /* JADX INFO: compiled from: SearchQuery.kt */
    public static final class Builder {
        private boolean includeNsfw;
        private final StringBuilder contentBuilder = new StringBuilder();
        private final HashMap<String, List<String>> paramsMap = new HashMap<>();

        private final void appendContent(CharSequence content) {
            StringBuilder sb = this.contentBuilder;
            sb.append(content);
            sb.append(' ');
        }

        public final void appendParam(String paramKey, String param) {
            C12238m.checkNotNullParameter(paramKey, "paramKey");
            C12238m.checkNotNullParameter(param, "param");
            List<String> arrayList = this.paramsMap.get(paramKey);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(param);
            this.paramsMap.put(paramKey, arrayList);
        }

        public final SearchQuery buildFrom(List<? extends QueryNode> queryNodes, SearchData searchData) {
            C12238m.checkNotNullParameter(queryNodes, "queryNodes");
            C12238m.checkNotNullParameter(searchData, "searchData");
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
                            if (!C12163u.contains(answerNode.getValidFilters(), filterType)) {
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
            C12238m.checkNotNullExpressionValue(string, "contentBuilder.toString()");
            Objects.requireNonNull(string, "null cannot be cast to non-null type kotlin.CharSequence");
            String string2 = C12106w.trim(string).toString();
            if (string2.length() > 0) {
                this.paramsMap.put("content", C12147n.mutableListOf(string2));
            }
            return new SearchQuery(this.paramsMap, this.includeNsfw);
        }

        public final Builder setIncludeNsfw(boolean includeNsfw) {
            this.includeNsfw = includeNsfw;
            return this;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SearchQuery(Map<String, ? extends List<String>> map, boolean z2) {
        C12238m.checkNotNullParameter(map, "params");
        this.params = map;
        this.includeNsfw = z2;
    }

    public final boolean getIncludeNsfw() {
        return this.includeNsfw;
    }

    public final Map<String, List<String>> getParams() {
        return this.params;
    }

    public final boolean isValid() {
        return !this.params.isEmpty();
    }
}
