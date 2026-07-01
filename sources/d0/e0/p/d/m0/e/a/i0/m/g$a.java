package d0.e0.p.d.m0.e.a.i0.m;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: RawType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g$a extends o implements Function1<String, CharSequence> {
    public static final g$a j = new g$a();

    public g$a() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(String str) {
        m.checkNotNullParameter(str, "it");
        return m.stringPlus("(raw) ", str);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(String str) {
        return invoke2(str);
    }
}
