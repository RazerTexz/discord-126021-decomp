package com.discord.simpleast.core.node;

import android.text.SpannableStringBuilder;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Node.kt */
/* JADX INFO: loaded from: classes.dex */
public class Node<R> {
    private Collection<Node<R>> children;

    public Node() {
        this(null, 1, null);
    }

    public Node(Collection<Node<R>> collection) {
        this.children = collection;
    }

    public final void addChild(Node<R> child) {
        m.checkNotNullParameter(child, "child");
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
        m.checkNotNullParameter(builder, "builder");
    }

    public /* synthetic */ Node(Collection collection, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : collection);
    }
}
