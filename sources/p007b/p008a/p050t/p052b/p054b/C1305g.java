package p007b.p008a.p050t.p052b.p054b;

import android.text.style.CharacterStyle;
import android.text.style.UnderlineSpan;
import java.util.List;
import kotlin.jvm.functions.Function0;
import p507d0.p580t.C12145m;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: b.a.t.b.b.g */
/* JADX INFO: compiled from: SimpleMarkdownRules.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1305g extends AbstractC12240o implements Function0<List<? extends CharacterStyle>> {

    /* JADX INFO: renamed from: j */
    public static final C1305g f1991j = new C1305g();

    public C1305g() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public List<? extends CharacterStyle> invoke() {
        return C12145m.listOf(new UnderlineSpan());
    }
}
