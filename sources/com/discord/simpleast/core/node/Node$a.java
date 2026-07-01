package com.discord.simpleast.core.node;

import android.text.SpannableStringBuilder;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: Node.kt */
/* JADX INFO: loaded from: classes.dex */
public class Node$a<R> extends Node<R> {
    public Node$a(Node<R>... nodeArr) {
        m.checkNotNullParameter(nodeArr, "children");
        ArrayList arrayList = new ArrayList();
        for (Node<R> node : nodeArr) {
            if (node != null) {
                arrayList.add(node);
            }
        }
        super(u.toMutableList((Collection) arrayList));
    }

    @Override // com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder spannableStringBuilder, R r) {
        m.checkNotNullParameter(spannableStringBuilder, "builder");
        Collection<Node<R>> children = getChildren();
        if (children != null) {
            Iterator<T> it = children.iterator();
            while (it.hasNext()) {
                ((Node) it.next()).render(spannableStringBuilder, r);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" >\n");
        Collection<Node<R>> children = getChildren();
        sb.append(children != null ? u.joinToString$default(children, "\n->", ">>", "\n>|", 0, null, Node$a$a.j, 24, null) : null);
        return sb.toString();
    }
}
