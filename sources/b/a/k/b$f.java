package b.a.k;

import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.text.MatchResult;

/* JADX INFO: compiled from: FormatUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b$f extends o implements Function1<MatchResult, CharSequence> {
    public final /* synthetic */ Map $namedArgs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b$f(Map map) {
        super(1);
        this.$namedArgs = map;
    }

    @Override // kotlin.jvm.functions.Function1
    public CharSequence invoke(MatchResult matchResult) {
        MatchResult matchResult2 = matchResult;
        m.checkNotNullParameter(matchResult2, "matchResult");
        String str = (String) this.$namedArgs.get(matchResult2.getGroupValues().get(1));
        return str != null ? str : matchResult2.getValue();
    }
}
