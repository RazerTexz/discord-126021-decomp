package com.discord.simpleast.core.node;

import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Node.kt */
/* JADX INFO: loaded from: classes.dex */
public class Node<R> {
    private Collection<Node<R>> children;

    /* JADX INFO: renamed from: com.discord.simpleast.core.node.Node$a */
    /* JADX INFO: compiled from: Node.kt */
    public static class C5655a<R> extends Node<R> {

        /* JADX INFO: renamed from: com.discord.simpleast.core.node.Node$a$a */
        /* JADX INFO: compiled from: Node.kt */
        public static final class a extends AbstractC12240o implements Function1<Node<R>, CharSequence> {

            /* JADX INFO: renamed from: j */
            public static final a f18951j = new a();

            public a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public CharSequence invoke(Object obj) {
                Node node = (Node) obj;
                C12238m.checkNotNullParameter(node, "it");
                return node.toString();
            }
        }

        public C5655a(Node<R>... nodeArr) {
            C12238m.checkNotNullParameter(nodeArr, "children");
            ArrayList arrayList = new ArrayList();
            for (Node<R> node : nodeArr) {
                if (node != null) {
                    arrayList.add(node);
                }
            }
            super(C12163u.toMutableList((Collection) arrayList));
        }

        @Override // com.discord.simpleast.core.node.Node
        public void render(SpannableStringBuilder spannableStringBuilder, R r) {
            C12238m.checkNotNullParameter(spannableStringBuilder, "builder");
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
            sb.append(children != null ? C12163u.joinToString$default(children, "\n->", ">>", "\n>|", 0, null, a.f18951j, 24, null) : null);
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
        C12238m.checkNotNullParameter(child, "child");
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
        C12238m.checkNotNullParameter(builder, "builder");
    }

    public /* synthetic */ Node(Collection collection, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : collection);
    }
}
