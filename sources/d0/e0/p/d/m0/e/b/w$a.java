package d0.e0.p.d.m0.e.b;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SignatureBuildingComponents.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class w$a extends d0.z.d.o implements Function1<String, CharSequence> {
    public final /* synthetic */ w this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w$a(w wVar) {
        super(1);
        this.this$0 = wVar;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(String str) {
        d0.z.d.m.checkNotNullParameter(str, "it");
        return w.access$escapeClassName(this.this$0, str);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(String str) {
        return invoke2(str);
    }
}
