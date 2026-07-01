package d0.g0;

import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Strings.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class v extends d0.z.d.o implements Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {
    public final /* synthetic */ List $delimitersList;
    public final /* synthetic */ boolean $ignoreCase;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(List list, boolean z2) {
        super(2);
        this.$delimitersList = list;
        this.$ignoreCase = z2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
        return invoke(charSequence, num.intValue());
    }

    public final Pair<Integer, Integer> invoke(CharSequence charSequence, int i) {
        d0.z.d.m.checkNotNullParameter(charSequence, "$receiver");
        Pair pairAccess$findAnyOf = w.access$findAnyOf(charSequence, this.$delimitersList, i, this.$ignoreCase, false);
        if (pairAccess$findAnyOf != null) {
            return d0.o.to(pairAccess$findAnyOf.getFirst(), Integer.valueOf(((String) pairAccess$findAnyOf.getSecond()).length()));
        }
        return null;
    }
}
