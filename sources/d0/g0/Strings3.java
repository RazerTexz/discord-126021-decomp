package d0.g0;

import d0.Tuples;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: d0.g0.v, reason: use source file name */
/* JADX INFO: compiled from: Strings.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Strings3 extends Lambda implements Function2<CharSequence, Integer, Tuples2<? extends Integer, ? extends Integer>> {
    public final /* synthetic */ List $delimitersList;
    public final /* synthetic */ boolean $ignoreCase;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Strings3(List list, boolean z2) {
        super(2);
        this.$delimitersList = list;
        this.$ignoreCase = z2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Tuples2<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
        return invoke(charSequence, num.intValue());
    }

    public final Tuples2<Integer, Integer> invoke(CharSequence charSequence, int i) {
        Intrinsics3.checkNotNullParameter(charSequence, "$receiver");
        Tuples2 tuples2Access$findAnyOf = Strings4.access$findAnyOf(charSequence, this.$delimitersList, i, this.$ignoreCase, false);
        if (tuples2Access$findAnyOf != null) {
            return Tuples.to(tuples2Access$findAnyOf.getFirst(), Integer.valueOf(((String) tuples2Access$findAnyOf.getSecond()).length()));
        }
        return null;
    }
}
