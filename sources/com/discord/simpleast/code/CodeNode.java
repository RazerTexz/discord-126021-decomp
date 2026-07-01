package com.discord.simpleast.code;

import android.text.SpannableStringBuilder;
import b.a.t.a.CodeStyleProviders;
import b.a.t.b.a.TextNode;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CodeNode.kt */
/* JADX INFO: loaded from: classes.dex */
public class CodeNode<RC> extends TextNode<RC> {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final String language;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final StyleNode.a<RC> stylesProvider;

    /* JADX INFO: compiled from: CodeNode.kt */
    public static abstract class a {
        public final String a;

        /* JADX INFO: renamed from: com.discord.simpleast.code.CodeNode$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CodeNode.kt */
        public static final class C0068a<RC> extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final List<Node<RC>> f2807b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0068a(String str, List<? extends Node<RC>> list) {
                super(str, null);
                Intrinsics3.checkNotNullParameter(str, "raw");
                Intrinsics3.checkNotNullParameter(list, "children");
                this.f2807b = list;
            }
        }

        /* JADX INFO: compiled from: CodeNode.kt */
        public static final class b extends a {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(str, null);
                Intrinsics3.checkNotNullParameter(str, "body");
            }
        }

        public a(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this.a = str;
        }
    }

    /* JADX INFO: compiled from: CodeNode.kt */
    public static final class b<RC> extends Node.a<RC> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, CodeStyleProviders<RC> codeStyleProviders) {
            super(new StyleNode.b(str, codeStyleProviders.d), new StyleNode.b(str2, codeStyleProviders.f));
            Intrinsics3.checkNotNullParameter(str, "pre");
            Intrinsics3.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CodeNode(a aVar, String str, StyleNode.a<RC> aVar2) {
        super(aVar.a);
        Intrinsics3.checkNotNullParameter(aVar, "content");
        Intrinsics3.checkNotNullParameter(aVar2, "stylesProvider");
        this.language = str;
        this.stylesProvider = aVar2;
        if (aVar instanceof a.C0068a) {
            Iterator<T> it = ((a.C0068a) aVar).f2807b.iterator();
            while (it.hasNext()) {
                Node<R> node = (Node) it.next();
                Objects.requireNonNull(node, "null cannot be cast to non-null type com.discord.simpleast.core.node.Node<RC>");
                addChild(node);
            }
        }
    }

    public boolean equals(Object other) {
        if (other instanceof CodeNode) {
            CodeNode codeNode = (CodeNode) other;
            if (Intrinsics3.areEqual(codeNode.language, this.language) && Intrinsics3.areEqual(codeNode.getContent(), getContent())) {
                return true;
            }
        }
        return false;
    }

    @Override // b.a.t.b.a.TextNode, com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder builder, RC renderContext) {
        Intrinsics3.checkNotNullParameter(builder, "builder");
        Iterable<?> iterable = this.stylesProvider.get(renderContext);
        if (!hasChildren()) {
            int length = builder.length();
            builder.append(getContent());
            Iterator<?> it = iterable.iterator();
            while (it.hasNext()) {
                builder.setSpan(it.next(), length, builder.length(), 17);
            }
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<?> it2 = iterable.iterator();
        while (it2.hasNext()) {
            spannableStringBuilder.setSpan(it2.next(), 0, 0, 18);
        }
        Collection<Node<RC>> children = getChildren();
        if (children != null) {
            Iterator<T> it3 = children.iterator();
            while (it3.hasNext()) {
                ((Node) it3.next()).render(spannableStringBuilder, renderContext);
            }
        }
        builder.append((char) 8202);
        builder.insert(builder.length() - 1, (CharSequence) spannableStringBuilder);
    }
}
