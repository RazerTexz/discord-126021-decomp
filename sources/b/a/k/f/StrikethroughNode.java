package b.a.k.f;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import com.discord.i18n.RenderContext;
import com.discord.simpleast.core.node.Node;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: b.a.k.f.d, reason: use source file name */
/* JADX INFO: compiled from: StrikethroughNode.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StrikethroughNode extends Node.a<RenderContext> {
    public StrikethroughNode() {
        super(new Node[0]);
    }

    @Override // com.discord.simpleast.core.node.Node.a, com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder spannableStringBuilder, Object obj) {
        RenderContext renderContext = (RenderContext) obj;
        Intrinsics3.checkNotNullParameter(spannableStringBuilder, "builder");
        Intrinsics3.checkNotNullParameter(renderContext, "renderContext");
        int length = spannableStringBuilder.length();
        super.render(spannableStringBuilder, renderContext);
        spannableStringBuilder.setSpan(new StrikethroughSpan(), length, spannableStringBuilder.length(), 33);
        Integer num = renderContext.strikethroughColor;
        if (num != null) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(num.intValue()), length, spannableStringBuilder.length(), 33);
        }
    }
}
