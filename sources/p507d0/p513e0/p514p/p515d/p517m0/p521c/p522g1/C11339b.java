package p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.b */
/* JADX INFO: compiled from: AnnotatedImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11339b implements InterfaceC11338a {

    /* JADX INFO: renamed from: j */
    public final InterfaceC11344g f22716j;

    public C11339b(InterfaceC11344g interfaceC11344g) {
        if (interfaceC11344g != null) {
            this.f22716j = interfaceC11344g;
        } else {
            m9384a(0);
            throw null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9384a(int i) {
        String str = i != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 1 ? 3 : 2];
        if (i != 1) {
            objArr[0] = "annotations";
        } else {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        }
        if (i != 1) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        } else {
            objArr[1] = "getAnnotations";
        }
        if (i != 1) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i == 1) {
            throw new IllegalStateException(str2);
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11338a
    public InterfaceC11344g getAnnotations() {
        InterfaceC11344g interfaceC11344g = this.f22716j;
        if (interfaceC11344g != null) {
            return interfaceC11344g;
        }
        m9384a(1);
        throw null;
    }
}
