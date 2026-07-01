package b.a.t.a;

import android.text.SpannableStringBuilder;
import com.discord.simpleast.code.CodeNode;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.Node$a;
import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: compiled from: CodeRules.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c$a<R> extends Node$a<R> {
    public final /* synthetic */ c a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c$a(c cVar, CodeNode codeNode, Node[] nodeArr) {
        super(nodeArr);
        this.a = cVar;
    }

    @Override // com.discord.simpleast.core.node.Node$a, com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder spannableStringBuilder, R r) {
        d0.z.d.m.checkNotNullParameter(spannableStringBuilder, "builder");
        int length = spannableStringBuilder.length();
        super.render(spannableStringBuilder, r);
        Iterator<?> it = this.a.f288b.get(r).iterator();
        while (it.hasNext()) {
            spannableStringBuilder.setSpan(it.next(), length, spannableStringBuilder.length(), 33);
        }
    }
}
