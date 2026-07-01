package com.discord.simpleast.core.node;

import android.text.SpannableStringBuilder;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Node.kt */
/* JADX INFO: loaded from: classes.dex */
public class Node<R> {
    private Collection<Node<R>> children;

    /* JADX INFO: compiled from: Node.kt */
    public static class a<R> extends Node<R> {

        /* JADX INFO: renamed from: com.discord.simpleast.core.node.Node$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Node.kt */
        public static final class C0069a extends Lambda implements Function1<Node<R>, CharSequence> {
            public static final C0069a j = new C0069a();

            public C0069a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public CharSequence invoke(Object obj) {
                Node node = (Node) obj;
                Intrinsics3.checkNotNullParameter(node, "it");
                return node.toString();
            }
        }

        public a(Node<R>... nodeArr) {
            Intrinsics3.checkNotNullParameter(nodeArr, "children");
            ArrayList arrayList = new ArrayList();
            for (Node<R> node : nodeArr) {
                if (node != null) {
                    arrayList.add(node);
                }
            }
            super(_Collections.toMutableList((Collection) arrayList));
        }

        @Override // com.discord.simpleast.core.node.Node
        public void render(SpannableStringBuilder spannableStringBuilder, R r) {
            Intrinsics3.checkNotNullParameter(spannableStringBuilder, "builder");
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
            sb.append(children != null ? _Collections.joinToString$default(children, "\n->", ">>", "\n>|", 0, null, C0069a.j, 24, null) : null);
            return sb.toString();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Node() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public Node(Collection<Node<R>> collection) {
        this.children = collection;
    }

    public final void addChild(Node<R> child) {
        Intrinsics3.checkNotNullParameter(child, "child");
        Collection<Node<R>> arrayList = this.children;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(child);
        this.children = arrayList;
    }

    public final Collection<Node<R>> getChildren() {
        return this.children;
    }

    public final boolean hasChildren() {
        Collection<Node<R>> collection = this.children;
        return collection != null && (collection.isEmpty() ^ true);
    }

    public void render(SpannableStringBuilder builder, R renderContext) {
        Intrinsics3.checkNotNullParameter(builder, "builder");
    }

    public /* synthetic */ Node(Collection collection, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : collection);
    }
}
