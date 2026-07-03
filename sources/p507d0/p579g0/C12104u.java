package p507d0.p579g0;

import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import p507d0.C12116o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.g0.u */
/* JADX INFO: compiled from: Strings.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12104u extends AbstractC12240o implements Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {
    public final /* synthetic */ char[] $delimiters;
    public final /* synthetic */ boolean $ignoreCase;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12104u(char[] cArr, boolean z2) {
        super(2);
        this.$delimiters = cArr;
        this.$ignoreCase = z2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
        return invoke(charSequence, num.intValue());
    }

    public final Pair<Integer, Integer> invoke(CharSequence charSequence, int i) {
        C12238m.checkNotNullParameter(charSequence, "$receiver");
        int iIndexOfAny = C12106w.indexOfAny(charSequence, this.$delimiters, i, this.$ignoreCase);
        if (iIndexOfAny < 0) {
            return null;
        }
        return C12116o.m10073to(Integer.valueOf(iIndexOfAny), 1);
    }
}
