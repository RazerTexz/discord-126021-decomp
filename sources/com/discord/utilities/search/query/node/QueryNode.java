package com.discord.utilities.search.query.node;

import android.content.Context;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import com.discord.simpleast.core.node.Node;

/* JADX INFO: compiled from: QueryNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class QueryNode extends Node<Context> {
    public static final QueryNode$Preprocessor Preprocessor = new QueryNode$Preprocessor(null);

    public QueryNode() {
        super(null, 1, null);
    }

    public abstract CharSequence getText();
}
