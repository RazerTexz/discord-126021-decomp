package com.discord.utilities.textprocessing;

import b.a.t.b.c.a;
import com.discord.simpleast.core.node.Node;
import d0.z.d.e0;
import java.util.Collection;

/* JADX INFO: compiled from: MessagePreprocessor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessagePreprocessor$processQuoteChildren$1 implements a {
    public final /* synthetic */ MessagePreprocessor this$0;

    public MessagePreprocessor$processQuoteChildren$1(MessagePreprocessor messagePreprocessor) {
        this.this$0 = messagePreprocessor;
    }

    @Override // b.a.t.b.c.a
    public final void processNode(Node<Object> node) {
        Collection<Node<Object>> children = node.getChildren();
        if (children != null) {
            MessagePreprocessor.access$mergeConsecutiveQuoteNodes(this.this$0, e0.asMutableCollection(children));
        }
    }
}
