package d0.g0;

import d0.Tuples;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: d0.g0.u, reason: use source file name */
/* JADX INFO: compiled from: Strings.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Strings2 extends Lambda implements Function2<CharSequence, Integer, Tuples2<? extends Integer, ? extends Integer>> {
    public final /* synthetic */ char[] $delimiters;
    public final /* synthetic */ boolean $ignoreCase;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Strings2(char[] cArr, boolean z2) {
        super(2);
        this.$delimiters = cArr;
        this.$ignoreCase = z2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Tuples2<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
        return invoke(charSequence, num.intValue());
    }

    public final Tuples2<Integer, Integer> invoke(CharSequence charSequence, int i) {
        Intrinsics3.checkNotNullParameter(charSequence, "$receiver");
        int iIndexOfAny = Strings4.indexOfAny(charSequence, this.$delimiters, i, this.$ignoreCase);
        if (iIndexOfAny < 0) {
            return null;
        }
        return Tuples.to(Integer.valueOf(iIndexOfAny), 1);
    }
}
