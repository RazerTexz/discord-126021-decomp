package com.discord.simpleast.code;

import android.text.SpannableStringBuilder;
import b.a.t.b.a.a;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode$a;
import d0.z.d.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: CodeNode.kt */
/* JADX INFO: loaded from: classes.dex */
public class CodeNode<RC> extends a<RC> {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final String language;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final StyleNode$a<RC> stylesProvider;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CodeNode(CodeNode$a codeNode$a, String str, StyleNode$a<RC> styleNode$a) {
        super(codeNode$a.a);
        m.checkNotNullParameter(codeNode$a, "content");
        m.checkNotNullParameter(styleNode$a, "stylesProvider");
        this.language = str;
        this.stylesProvider = styleNode$a;
        if (codeNode$a instanceof CodeNode$a$a) {
            Iterator<T> it = ((CodeNode$a$a) codeNode$a).f2807b.iterator();
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
            if (m.areEqual(codeNode.language, this.language) && m.areEqual(codeNode.getContent(), getContent())) {
                return true;
            }
        }
        return false;
    }

    @Override // b.a.t.b.a.a, com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder builder, RC renderContext) {
        m.checkNotNullParameter(builder, "builder");
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
