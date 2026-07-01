package b.a.t.b.b;

import android.text.style.CharacterStyle;
import android.text.style.StyleSpan;
import d0.t.m;
import d0.z.d.o;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: SimpleMarkdownRules.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a extends o implements Function0<List<? extends CharacterStyle>> {
    public static final a j = new a();

    public a() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public List<? extends CharacterStyle> invoke() {
        return m.listOf(new StyleSpan(1));
    }
}
