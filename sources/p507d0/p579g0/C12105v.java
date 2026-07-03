package p507d0.p579g0;

import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import p507d0.C12116o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.g0.v */
/* JADX INFO: compiled from: Strings.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12105v extends AbstractC12240o implements Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {
    public final /* synthetic */ List $delimitersList;
    public final /* synthetic */ boolean $ignoreCase;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12105v(List list, boolean z2) {
        super(2);
        this.$delimitersList = list;
        this.$ignoreCase = z2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
        return invoke(charSequence, num.intValue());
    }

    public final Pair<Integer, Integer> invoke(CharSequence charSequence, int i) {
        C12238m.checkNotNullParameter(charSequence, "$receiver");
        Pair pairAccess$findAnyOf = C12106w.access$findAnyOf(charSequence, this.$delimitersList, i, this.$ignoreCase, false);
        if (pairAccess$findAnyOf != null) {
            return C12116o.m10073to(pairAccess$findAnyOf.getFirst(), Integer.valueOf(((String) pairAccess$findAnyOf.getSecond()).length()));
        }
        return null;
    }
}
