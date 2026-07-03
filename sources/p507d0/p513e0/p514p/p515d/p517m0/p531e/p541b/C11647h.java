package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p537m.C11559g;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11692q;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.C11667a;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11881q;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11916d0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12005t;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.h */
/* JADX INFO: compiled from: JavaFlexibleTypeDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11647h implements InterfaceC11881q {

    /* JADX INFO: renamed from: a */
    public static final C11647h f23613a = new C11647h();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11881q
    public AbstractC11913c0 create(C11692q c11692q, String str, AbstractC11934j0 abstractC11934j0, AbstractC11934j0 abstractC11934j1) {
        C12238m.checkNotNullParameter(c11692q, "proto");
        C12238m.checkNotNullParameter(str, "flexibleId");
        C12238m.checkNotNullParameter(abstractC11934j0, "lowerBound");
        C12238m.checkNotNullParameter(abstractC11934j1, "upperBound");
        if (C12238m.areEqual(str, "kotlin.jvm.PlatformType")) {
            if (c11692q.hasExtension(C11667a.f23657g)) {
                return new C11559g(abstractC11934j0, abstractC11934j1);
            }
            C11916d0 c11916d0 = C11916d0.f24748a;
            return C11916d0.flexibleType(abstractC11934j0, abstractC11934j1);
        }
        AbstractC11934j0 abstractC11934j0CreateErrorType = C12005t.createErrorType("Error java flexible type with id: " + str + ". (" + abstractC11934j0 + ".." + abstractC11934j1 + ')');
        C12238m.checkNotNullExpressionValue(abstractC11934j0CreateErrorType, "createErrorType(\"Error java flexible type with id: $flexibleId. ($lowerBound..$upperBound)\")");
        return abstractC11934j0CreateErrorType;
    }
}
