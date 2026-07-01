package b.a.t.b.a;

import android.text.SpannableStringBuilder;
import com.discord.simpleast.core.node.Node;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: b.a.t.b.a.a, reason: use source file name */
/* JADX INFO: compiled from: TextNode.kt */
/* JADX INFO: loaded from: classes.dex */
public class TextNode<R> extends Node<R> {
    private final String content;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TextNode(String str) {
        super(null, 1, 0 == true ? 1 : 0);
        Intrinsics3.checkNotNullParameter(str, "content");
        this.content = str;
    }

    public final String getContent() {
        return this.content;
    }

    @Override // com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder spannableStringBuilder, R r) {
        Intrinsics3.checkNotNullParameter(spannableStringBuilder, "builder");
        spannableStringBuilder.append((CharSequence) this.content);
    }

    public String toString() {
        return getClass().getSimpleName() + ": " + this.content;
    }
}
