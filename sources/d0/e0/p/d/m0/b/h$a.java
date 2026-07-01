package d0.e0.p.d.m0.b;

import d0.e0.p.d.m0.c.j0;
import java.util.Arrays;
import java.util.Collection;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: KotlinBuiltIns.java */
/* JADX INFO: loaded from: classes3.dex */
public class h$a implements Function0<Collection<j0>> {
    public final /* synthetic */ h j;

    public h$a(h hVar) {
        this.j = hVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Collection<j0> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public Collection<j0> invoke2() {
        return Arrays.asList(this.j.f3211b.getPackage(k.l), this.j.f3211b.getPackage(k.n), this.j.f3211b.getPackage(k.o), this.j.f3211b.getPackage(k.m));
    }
}
