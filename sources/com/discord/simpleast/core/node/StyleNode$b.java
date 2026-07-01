package com.discord.simpleast.core.node;

import android.text.SpannableStringBuilder;
import b.a.t.b.a.a;
import d0.z.d.m;
import java.util.Iterator;

/* JADX INFO: compiled from: StyleNode.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StyleNode$b<RC> extends a<RC> {
    public final StyleNode$a<RC> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StyleNode$b(String str, StyleNode$a<RC> styleNode$a) {
        super(str);
        m.checkNotNullParameter(str, "content");
        m.checkNotNullParameter(styleNode$a, "stylesProvider");
        this.a = styleNode$a;
    }

    @Override // b.a.t.b.a.a, com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder spannableStringBuilder, RC rc) {
        m.checkNotNullParameter(spannableStringBuilder, "builder");
        int length = spannableStringBuilder.length();
        super.render(spannableStringBuilder, rc);
        Iterator<?> it = this.a.get(rc).iterator();
        while (it.hasNext()) {
            spannableStringBuilder.setSpan(it.next(), length, spannableStringBuilder.length(), 33);
        }
    }
}
