package d0.e0.p.d.m0.g;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: FqNameUnsafe.java */
/* JADX INFO: loaded from: classes3.dex */
public class c$a implements Function1<String, e> {
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ e invoke(String str) {
        return invoke2(str);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public e invoke2(String str) {
        return e.guessByFirstCharacter(str);
    }
}
