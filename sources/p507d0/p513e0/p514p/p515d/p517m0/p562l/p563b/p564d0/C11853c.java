package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p564d0;

import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.InterfaceC11282b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11688m;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p546y.C11700a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.AbstractC11879o;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p591y.C12201b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.d0.c */
/* JADX INFO: compiled from: BuiltInsPackageFragmentImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11853c extends AbstractC11879o implements InterfaceC11282b {

    /* JADX INFO: renamed from: v */
    public static final a f24517v = new a(null);

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.d0.c$a */
    /* JADX INFO: compiled from: BuiltInsPackageFragmentImpl.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final C11853c create(C11713b c11713b, InterfaceC11905o interfaceC11905o, InterfaceC11325c0 interfaceC11325c0, InputStream inputStream, boolean z2) throws IOException {
            C12238m.checkNotNullParameter(c11713b, "fqName");
            C12238m.checkNotNullParameter(interfaceC11905o, "storageManager");
            C12238m.checkNotNullParameter(interfaceC11325c0, "module");
            C12238m.checkNotNullParameter(inputStream, "inputStream");
            try {
                C11700a from = C11700a.f23998f.readFrom(inputStream);
                if (from == null) {
                    C12238m.throwUninitializedPropertyAccessException("version");
                    throw null;
                }
                if (from.isCompatible()) {
                    C11688m from2 = C11688m.parseFrom(inputStream, C11851a.f24515m.getExtensionRegistry());
                    C12201b.closeFinally(inputStream, null);
                    C12238m.checkNotNullExpressionValue(from2, "proto");
                    return new C11853c(c11713b, interfaceC11905o, interfaceC11325c0, from2, from, z2, null);
                }
                throw new UnsupportedOperationException("Kotlin built-in definition format version is not supported: expected " + C11700a.f23999g + ", actual " + from + ". Please update Kotlin");
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    C12201b.closeFinally(inputStream, th);
                    throw th2;
                }
            }
        }
    }

    public C11853c(C11713b c11713b, InterfaceC11905o interfaceC11905o, InterfaceC11325c0 interfaceC11325c0, C11688m c11688m, C11700a c11700a, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        super(c11713b, interfaceC11905o, interfaceC11325c0, c11688m, c11700a, null);
    }
}
