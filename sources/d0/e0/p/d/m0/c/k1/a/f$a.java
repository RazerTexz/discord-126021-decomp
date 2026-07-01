package d0.e0.p.d.m0.c.k1.a;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ReflectKotlinClass.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f$a {
    public f$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final f create(Class<?> cls) {
        d0.z.d.m.checkNotNullParameter(cls, "klass");
        d0.e0.p.d.m0.e.b.b0.b bVar = new d0.e0.p.d.m0.e.b.b0.b();
        c.a.loadClassAnnotations(cls, bVar);
        d0.e0.p.d.m0.e.b.b0.a aVarCreateHeader = bVar.createHeader();
        if (aVarCreateHeader == null) {
            return null;
        }
        return new f(cls, aVarCreateHeader, null);
    }
}
