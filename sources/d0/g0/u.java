package d0.g0;

import kotlin.Pair;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Strings.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u extends d0.z.d.o implements Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {
    public final /* synthetic */ char[] $delimiters;
    public final /* synthetic */ boolean $ignoreCase;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(char[] cArr, boolean z2) {
        super(2);
        this.$delimiters = cArr;
        this.$ignoreCase = z2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
        return invoke(charSequence, num.intValue());
    }

    public final Pair<Integer, Integer> invoke(CharSequence charSequence, int i) {
        d0.z.d.m.checkNotNullParameter(charSequence, "$receiver");
        int iIndexOfAny = w.indexOfAny(charSequence, this.$delimiters, i, this.$ignoreCase);
        if (iIndexOfAny < 0) {
            return null;
        }
        return d0.o.to(Integer.valueOf(iIndexOfAny), 1);
    }
}
