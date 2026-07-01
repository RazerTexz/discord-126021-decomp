package b.a.k.f;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import com.discord.i18n.RenderContext;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.Node$a;
import d0.z.d.m;

/* JADX INFO: compiled from: BoldNode.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a extends Node$a<RenderContext> {
    public a() {
        super(new Node[0]);
    }

    @Override // com.discord.simpleast.core.node.Node$a, com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder spannableStringBuilder, Object obj) {
        RenderContext renderContext = (RenderContext) obj;
        m.checkNotNullParameter(spannableStringBuilder, "builder");
        m.checkNotNullParameter(renderContext, "renderContext");
        int length = spannableStringBuilder.length();
        super.render(spannableStringBuilder, renderContext);
        spannableStringBuilder.setSpan(new StyleSpan(1), length, spannableStringBuilder.length(), 33);
        Integer num = renderContext.boldColor;
        if (num != null) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(num.intValue()), length, spannableStringBuilder.length(), 33);
        }
    }
}
