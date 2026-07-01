package com.discord.simpleast.core.node;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: compiled from: Node.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Node$a$a<R> extends o implements Function1<Node<R>, CharSequence> {
    public static final Node$a$a j = new Node$a$a();

    public Node$a$a() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public CharSequence invoke(Object obj) {
        Node node = (Node) obj;
        m.checkNotNullParameter(node, "it");
        return node.toString();
    }
}
