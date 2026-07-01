package com.discord.utilities.search.query.node;

import com.discord.utilities.search.query.node.answer.AnswerNode;
import com.discord.utilities.search.query.node.content.ContentNode;
import com.discord.utilities.search.validation.SearchData;
import d0.g0.w;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: QueryNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class QueryNode$Preprocessor {
    private QueryNode$Preprocessor() {
    }

    private final void consolidateContentNodes(List<QueryNode> list) {
        int i = 1;
        while (i < list.size()) {
            int i2 = i - 1;
            QueryNode queryNode = list.get(i2);
            QueryNode queryNode2 = list.get(i);
            if ((queryNode instanceof ContentNode) && (queryNode2 instanceof ContentNode)) {
                list.set(i2, new ContentNode((ContentNode) queryNode, (ContentNode) queryNode2));
                list.remove(i);
                i--;
            }
            i++;
        }
        if (!list.isEmpty()) {
            int size = list.size() - 1;
            QueryNode queryNode3 = list.get(size);
            if (queryNode3 instanceof ContentNode) {
                if (w.trim(((ContentNode) queryNode3).getContent()).length() == 0) {
                    list.remove(size);
                }
            }
        }
    }

    public final void preprocess(List<QueryNode> list, SearchData searchData) {
        m.checkNotNullParameter(list, "$this$preprocess");
        m.checkNotNullParameter(searchData, "searchData");
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(list, 10));
        for (QueryNode contentNode : list) {
            if ((contentNode instanceof AnswerNode) && !((AnswerNode) contentNode).isValid(searchData)) {
                contentNode = new ContentNode(contentNode.getText());
            }
            arrayList.add(contentNode);
        }
        QueryNode.Preprocessor.consolidateContentNodes(list);
    }

    public /* synthetic */ QueryNode$Preprocessor(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
