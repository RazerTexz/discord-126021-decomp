package com.discord.simpleast.code;

import android.text.SpannableStringBuilder;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p050t.p051a.C1280f;
import p007b.p008a.p050t.p052b.p053a.C1298a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: CodeNode.kt */
/* JADX INFO: loaded from: classes.dex */
public class CodeNode<RC> extends C1298a<RC> {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final String language;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final StyleNode.InterfaceC5656a<RC> stylesProvider;

    /* JADX INFO: renamed from: com.discord.simpleast.code.CodeNode$a */
    /* JADX INFO: compiled from: CodeNode.kt */
    public static abstract class AbstractC5653a {

        /* JADX INFO: renamed from: a */
        public final String f18949a;

        /* JADX INFO: renamed from: com.discord.simpleast.code.CodeNode$a$a */
        /* JADX INFO: compiled from: CodeNode.kt */
        public static final class a<RC> extends AbstractC5653a {

            /* JADX INFO: renamed from: b */
            public final List<Node<RC>> f18950b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(String str, List<? extends Node<RC>> list) {
                super(str, null);
                C12238m.checkNotNullParameter(str, "raw");
                C12238m.checkNotNullParameter(list, "children");
                this.f18950b = list;
            }
        }

        /* JADX INFO: renamed from: com.discord.simpleast.code.CodeNode$a$b */
        /* JADX INFO: compiled from: CodeNode.kt */
        public static final class b extends AbstractC5653a {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(str, null);
                C12238m.checkNotNullParameter(str, "body");
            }
        }

        public AbstractC5653a(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this.f18949a = str;
        }
    }

    /* JADX INFO: renamed from: com.discord.simpleast.code.CodeNode$b */
    /* JADX INFO: compiled from: CodeNode.kt */
    public static final class C5654b<RC> extends Node.C5655a<RC> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C5654b(String str, String str2, C1280f<RC> c1280f) {
            super(new StyleNode.C5657b(str, c1280f.f1909d), new StyleNode.C5657b(str2, c1280f.f1911f));
            C12238m.checkNotNullParameter(str, "pre");
            C12238m.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkNotNullParameter(c1280f, "codeStyleProviders");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CodeNode(AbstractC5653a abstractC5653a, String str, StyleNode.InterfaceC5656a<RC> interfaceC5656a) {
        super(abstractC5653a.f18949a);
        C12238m.checkNotNullParameter(abstractC5653a, "content");
        C12238m.checkNotNullParameter(interfaceC5656a, "stylesProvider");
        this.language = str;
        this.stylesProvider = interfaceC5656a;
        if (abstractC5653a instanceof AbstractC5653a.a) {
            Iterator<T> it = ((AbstractC5653a.a) abstractC5653a).f18950b.iterator();
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
            if (C12238m.areEqual(codeNode.language, this.language) && C12238m.areEqual(codeNode.getContent(), getContent())) {
                return true;
            }
        }
        return false;
    }

    @Override // p007b.p008a.p050t.p052b.p053a.C1298a, com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder builder, RC renderContext) {
        C12238m.checkNotNullParameter(builder, "builder");
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
