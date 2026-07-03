package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a;

import java.io.InputStream;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11291k;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11653n;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p564d0.C11851a;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p564d0.C11854d;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.a.g */
/* JADX INFO: compiled from: ReflectKotlinClassFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11414g implements InterfaceC11653n {

    /* JADX INFO: renamed from: a */
    public final ClassLoader f23018a;

    /* JADX INFO: renamed from: b */
    public final C11854d f23019b;

    public C11414g(ClassLoader classLoader) {
        C12238m.checkNotNullParameter(classLoader, "classLoader");
        this.f23018a = classLoader;
        this.f23019b = new C11854d();
    }

    /* JADX INFO: renamed from: a */
    public final InterfaceC11653n.a m9435a(String str) {
        C11413f c11413fCreate;
        Class<?> clsTryLoadClass = C11412e.tryLoadClass(this.f23018a, str);
        if (clsTryLoadClass == null || (c11413fCreate = C11413f.f23015a.create(clsTryLoadClass)) == null) {
            return null;
        }
        return new InterfaceC11653n.a.b(c11413fCreate, null, 2, null);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11883s
    public InputStream findBuiltInsData(C11713b c11713b) {
        C12238m.checkNotNullParameter(c11713b, "packageFqName");
        if (c11713b.startsWith(C11291k.f22498k)) {
            return this.f23019b.loadResource(C11851a.f24515m.getBuiltInsFilePath(c11713b));
        }
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11653n
    public InterfaceC11653n.a findKotlinClassOrContent(C11712a c11712a) {
        C12238m.checkNotNullParameter(c11712a, "classId");
        return m9435a(C11415h.access$toRuntimeFqName(c11712a));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11653n
    public InterfaceC11653n.a findKotlinClassOrContent(InterfaceC11574g interfaceC11574g) {
        C12238m.checkNotNullParameter(interfaceC11574g, "javaClass");
        C11713b fqName = interfaceC11574g.getFqName();
        String strAsString = fqName == null ? null : fqName.asString();
        if (strAsString == null) {
            return null;
        }
        return m9435a(strAsString);
    }
}
