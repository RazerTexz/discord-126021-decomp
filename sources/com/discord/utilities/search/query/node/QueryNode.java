package com.discord.utilities.search.query.node;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.search.query.node.answer.AnswerNode;
import com.discord.utilities.search.query.node.content.ContentNode;
import com.discord.utilities.search.validation.SearchData;
import d0.g0.Strings4;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: QueryNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class QueryNode extends Node<Context> {

    /* JADX INFO: renamed from: Preprocessor, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.discord.utilities.search.query.node.QueryNode$Preprocessor, reason: from kotlin metadata */
    /* JADX INFO: compiled from: QueryNode.kt */
    public static final class Companion {
        private Companion() {
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
                    if (Strings4.trim(((ContentNode) queryNode3).getContent()).length() == 0) {
                        list.remove(size);
                    }
                }
            }
        }

        public final void preprocess(List<QueryNode> list, SearchData searchData) {
            Intrinsics3.checkNotNullParameter(list, "$this$preprocess");
            Intrinsics3.checkNotNullParameter(searchData, "searchData");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
            for (QueryNode contentNode : list) {
                if ((contentNode instanceof AnswerNode) && !((AnswerNode) contentNode).isValid(searchData)) {
                    contentNode = new ContentNode(contentNode.getText());
                }
                arrayList.add(contentNode);
            }
            QueryNode.INSTANCE.consolidateContentNodes(list);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public QueryNode() {
        super(null, 1, null);
    }

    public abstract CharSequence getText();
}
