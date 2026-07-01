package b.a.t.b.a;

import android.text.SpannableStringBuilder;
import com.discord.simpleast.core.node.Node;
import d0.z.d.m;

/* JADX INFO: compiled from: TextNode.kt */
/* JADX INFO: loaded from: classes.dex */
public class a<R> extends Node<R> {
    private final String content;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String str) {
        super(null, 1, null);
        m.checkNotNullParameter(str, "content");
        this.content = str;
    }

    public final String getContent() {
        return this.content;
    }

    @Override // com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder spannableStringBuilder, R r) {
        m.checkNotNullParameter(spannableStringBuilder, "builder");
        spannableStringBuilder.append((CharSequence) this.content);
    }

    public String toString() {
        return getClass().getSimpleName() + ": " + this.content;
    }
}
