package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.lang.annotation.Annotation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11566b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.d */
/* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11425d implements InterfaceC11566b {

    /* JADX INFO: renamed from: a */
    public static final a f23039a = new a(null);

    /* JADX INFO: renamed from: b */
    public final C11716e f23040b;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.d$a */
    /* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final AbstractC11425d create(Object obj, C11716e c11716e) {
            C12238m.checkNotNullParameter(obj, "value");
            if (C11423b.isEnumClassOrSpecializedEnumEntryClass(obj.getClass())) {
                return new C11436o(c11716e, (Enum) obj);
            }
            if (obj instanceof Annotation) {
                return new C11426e(c11716e, (Annotation) obj);
            }
            if (obj instanceof Object[]) {
                return new C11429h(c11716e, (Object[]) obj);
            }
            return obj instanceof Class ? new C11432k(c11716e, (Class) obj) : new C11438q(c11716e, obj);
        }
    }

    public AbstractC11425d(C11716e c11716e) {
        this.f23040b = c11716e;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11566b
    public C11716e getName() {
        return this.f23040b;
    }
}
