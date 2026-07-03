package p007b.p008a.p050t.p052b.p053a;

import android.text.SpannableStringBuilder;
import com.discord.simpleast.core.node.Node;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.t.b.a.a */
/* JADX INFO: compiled from: TextNode.kt */
/* JADX INFO: loaded from: classes.dex */
public class C1298a<R> extends Node<R> {
    private final String content;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public C1298a(String str) {
        super(null, 1, 0 == true ? 1 : 0);
        C12238m.checkNotNullParameter(str, "content");
        this.content = str;
    }

    public final String getContent() {
        return this.content;
    }

    @Override // com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder spannableStringBuilder, R r) {
        C12238m.checkNotNullParameter(spannableStringBuilder, "builder");
        spannableStringBuilder.append((CharSequence) this.content);
    }

    public String toString() {
        return getClass().getSimpleName() + ": " + this.content;
    }
}
