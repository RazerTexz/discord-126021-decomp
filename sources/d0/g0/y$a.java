package d0.g0;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: _Strings.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class y$a extends d0.z.d.o implements Function1<CharSequence, String> {
    public static final y$a j = new y$a();

    public y$a() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(CharSequence charSequence) {
        return invoke2(charSequence);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(CharSequence charSequence) {
        d0.z.d.m.checkNotNullParameter(charSequence, "it");
        return charSequence.toString();
    }
}
