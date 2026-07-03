package p007b.p008a.p027k.p029f;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import com.discord.i18n.RenderContext;
import com.discord.simpleast.core.node.Node;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.k.f.d */
/* JADX INFO: compiled from: StrikethroughNode.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1114d extends Node.C5655a<RenderContext> {
    public C1114d() {
        super(new Node[0]);
    }

    @Override // com.discord.simpleast.core.node.Node.C5655a, com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder spannableStringBuilder, Object obj) {
        RenderContext renderContext = (RenderContext) obj;
        C12238m.checkNotNullParameter(spannableStringBuilder, "builder");
        C12238m.checkNotNullParameter(renderContext, "renderContext");
        int length = spannableStringBuilder.length();
        super.render(spannableStringBuilder, renderContext);
        spannableStringBuilder.setSpan(new StrikethroughSpan(), length, spannableStringBuilder.length(), 33);
        Integer num = renderContext.strikethroughColor;
        if (num != null) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(num.intValue()), length, spannableStringBuilder.length(), 33);
        }
    }
}
