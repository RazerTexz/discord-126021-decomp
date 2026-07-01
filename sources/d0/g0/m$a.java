package d0.g0;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Indent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m$a extends d0.z.d.o implements Function1<String, String> {
    public static final m$a j = new m$a();

    public m$a() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(String str) {
        return invoke2(str);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(String str) {
        d0.z.d.m.checkNotNullParameter(str, "line");
        return str;
    }
}
