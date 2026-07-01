package d0.e0.p.d.m0.l.b.d0;

import d0.z.d.a0;
import d0.z.d.j;
import d0.z.d.m;
import java.io.InputStream;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: compiled from: BuiltInsLoaderImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public /* synthetic */ class b$a extends j implements Function1<String, InputStream> {
    public b$a(d dVar) {
        super(1, dVar);
    }

    @Override // d0.z.d.d, kotlin.reflect.KCallable
    public final String getName() {
        return "loadResource";
    }

    @Override // d0.z.d.d
    public final KDeclarationContainer getOwner() {
        return a0.getOrCreateKotlinClass(d.class);
    }

    @Override // d0.z.d.d
    public final String getSignature() {
        return "loadResource(Ljava/lang/String;)Ljava/io/InputStream;";
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final InputStream invoke2(String str) {
        m.checkNotNullParameter(str, "p0");
        return ((d) this.receiver).loadResource(str);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ InputStream invoke(String str) {
        return invoke2(str);
    }
}
