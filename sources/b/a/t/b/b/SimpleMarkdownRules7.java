package b.a.t.b.b;

import android.text.style.CharacterStyle;
import android.text.style.UnderlineSpan;
import d0.t.CollectionsJVM;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: b.a.t.b.b.g, reason: use source file name */
/* JADX INFO: compiled from: SimpleMarkdownRules.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SimpleMarkdownRules7 extends Lambda implements Function0<List<? extends CharacterStyle>> {
    public static final SimpleMarkdownRules7 j = new SimpleMarkdownRules7();

    public SimpleMarkdownRules7() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public List<? extends CharacterStyle> invoke() {
        return CollectionsJVM.listOf(new UnderlineSpan());
    }
}
