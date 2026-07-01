package com.discord.simpleast.core.node;

import android.text.SpannableStringBuilder;
import androidx.exifinterface.media.ExifInterface;
import b.a.t.b.a.a;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: StyleNode.kt */
/* JADX INFO: loaded from: classes.dex */
public class StyleNode<RC, T> extends Node$a<RC> {
    public static final StyleNode$Companion Companion = new StyleNode$Companion(null);
    private final List<T> styles;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StyleNode(List<? extends T> list) {
        super(new Node[0]);
        m.checkNotNullParameter(list, "styles");
        this.styles = list;
    }

    public static final <RC, T> StyleNode<RC, T> wrapText(String str, List<? extends T> list) {
        Objects.requireNonNull(Companion);
        m.checkNotNullParameter(str, "content");
        m.checkNotNullParameter(list, "styles");
        StyleNode<RC, T> styleNode = new StyleNode<>(list);
        styleNode.addChild(new a(str));
        return styleNode;
    }

    public final List<T> getStyles() {
        return this.styles;
    }

    @Override // com.discord.simpleast.core.node.Node$a, com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder builder, RC renderContext) {
        m.checkNotNullParameter(builder, "builder");
        int length = builder.length();
        super.render(builder, renderContext);
        Iterator<T> it = this.styles.iterator();
        while (it.hasNext()) {
            builder.setSpan(it.next(), length, builder.length(), 33);
        }
    }
}
