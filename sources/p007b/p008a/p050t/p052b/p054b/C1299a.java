package p007b.p008a.p050t.p052b.p054b;

import android.text.style.CharacterStyle;
import android.text.style.StyleSpan;
import java.util.List;
import kotlin.jvm.functions.Function0;
import p507d0.p580t.C12145m;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: b.a.t.b.b.a */
/* JADX INFO: compiled from: SimpleMarkdownRules.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1299a extends AbstractC12240o implements Function0<List<? extends CharacterStyle>> {

    /* JADX INFO: renamed from: j */
    public static final C1299a f1980j = new C1299a();

    public C1299a() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public List<? extends CharacterStyle> invoke() {
        return C12145m.listOf(new StyleSpan(1));
    }
}
