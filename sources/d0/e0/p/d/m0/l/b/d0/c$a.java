package d0.e0.p.d.m0.l.b.d0;

import d0.e0.p.d.m0.c.c0;
import d0.e0.p.d.m0.m.o;
import d0.z.d.m;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: BuiltInsPackageFragmentImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c$a {
    public c$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final c create(d0.e0.p.d.m0.g.b bVar, o oVar, c0 c0Var, InputStream inputStream, boolean z2) throws IOException {
        m.checkNotNullParameter(bVar, "fqName");
        m.checkNotNullParameter(oVar, "storageManager");
        m.checkNotNullParameter(c0Var, "module");
        m.checkNotNullParameter(inputStream, "inputStream");
        try {
            d0.e0.p.d.m0.f.y.a from = d0.e0.p.d.m0.f.y.a.f.readFrom(inputStream);
            if (from == null) {
                m.throwUninitializedPropertyAccessException("version");
                throw null;
            }
            if (from.isCompatible()) {
                d0.e0.p.d.m0.f.m from2 = d0.e0.p.d.m0.f.m.parseFrom(inputStream, a.m.getExtensionRegistry());
                d0.y.b.closeFinally(inputStream, null);
                m.checkNotNullExpressionValue(from2, "proto");
                return new c(bVar, oVar, c0Var, from2, from, z2, null);
            }
            throw new UnsupportedOperationException("Kotlin built-in definition format version is not supported: expected " + d0.e0.p.d.m0.f.y.a.g + ", actual " + from + ". Please update Kotlin");
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                d0.y.b.closeFinally(inputStream, th);
                throw th2;
            }
        }
    }
}
