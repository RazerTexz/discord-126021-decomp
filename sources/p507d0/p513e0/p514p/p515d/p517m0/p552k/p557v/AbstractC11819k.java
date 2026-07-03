package p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v;

import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12005t;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.k */
/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11819k extends AbstractC11815g<Unit> {

    /* JADX INFO: renamed from: b */
    public static final a f24442b = new a(null);

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.k$a */
    /* JADX INFO: compiled from: constantValues.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final AbstractC11819k create(String str) {
            C12238m.checkNotNullParameter(str, "message");
            return new b(str);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.k$b */
    /* JADX INFO: compiled from: constantValues.kt */
    public static final class b extends AbstractC11819k {

        /* JADX INFO: renamed from: c */
        public final String f24443c;

        public b(String str) {
            C12238m.checkNotNullParameter(str, "message");
            this.f24443c = str;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
        public String toString() {
            return this.f24443c;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
        public AbstractC11934j0 getType(InterfaceC11325c0 interfaceC11325c0) {
            C12238m.checkNotNullParameter(interfaceC11325c0, "module");
            AbstractC11934j0 abstractC11934j0CreateErrorType = C12005t.createErrorType(this.f24443c);
            C12238m.checkNotNullExpressionValue(abstractC11934j0CreateErrorType, "createErrorType(message)");
            return abstractC11934j0CreateErrorType;
        }
    }

    public AbstractC11819k() {
        super(Unit.f27425a);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
    public Unit getValue() {
        throw new UnsupportedOperationException();
    }
}
