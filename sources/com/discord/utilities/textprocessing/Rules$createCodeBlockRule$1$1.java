package com.discord.utilities.textprocessing;

import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import com.discord.simpleast.code.CodeNode;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.Node$a;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.textprocessing.node.BasicRenderContext;
import d0.z.d.m;

/* JADX INFO: Add missing generic type declarations: [RC] */
/* JADX INFO: compiled from: Rules.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Rules$createCodeBlockRule$1$1<RC> extends Node$a<RC> {
    public final /* synthetic */ CodeNode $codeNode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Rules$createCodeBlockRule$1$1(CodeNode codeNode, Node[] nodeArr) {
        super(nodeArr);
        this.$codeNode = codeNode;
    }

    @Override // com.discord.simpleast.core.node.Node$a, com.discord.simpleast.core.node.Node
    public /* bridge */ /* synthetic */ void render(SpannableStringBuilder spannableStringBuilder, Object obj) {
        render(spannableStringBuilder, (BasicRenderContext) obj);
    }

    /* JADX WARN: Incorrect types in method signature: (Landroid/text/SpannableStringBuilder;TRC;)V */
    public void render(SpannableStringBuilder builder, BasicRenderContext renderContext) {
        m.checkNotNullParameter(builder, "builder");
        m.checkNotNullParameter(renderContext, "renderContext");
        int length = builder.length();
        super.render(builder, renderContext);
        builder.setSpan(new BackgroundColorSpan(ColorCompat.getThemedColor(renderContext.getContext(), 2130970275)), length, builder.length(), 33);
    }
}
