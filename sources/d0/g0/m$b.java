package d0.g0;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Indent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m$b extends d0.z.d.o implements Function1<String, String> {
    public final /* synthetic */ String $indent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m$b(String str) {
        super(1);
        this.$indent = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(String str) {
        return invoke2(str);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(String str) {
        d0.z.d.m.checkNotNullParameter(str, "line");
        return b.d.b.a.a.J(new StringBuilder(), this.$indent, str);
    }
}
