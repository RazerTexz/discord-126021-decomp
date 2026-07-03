package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.v0 */
/* JADX INFO: compiled from: TypeSubstitution.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12010v0 extends AbstractC12018z0 {

    /* JADX INFO: renamed from: b */
    public static final a f24889b = new a(null);

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.v0$a */
    /* JADX INFO: compiled from: TypeSubstitution.kt */
    public static final class a {

        /* JADX INFO: renamed from: d0.e0.p.d.m0.n.v0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: TypeSubstitution.kt */
        public static final class C13339a extends AbstractC12010v0 {

            /* JADX INFO: renamed from: c */
            public final /* synthetic */ Map<InterfaceC12008u0, InterfaceC12012w0> f24890c;

            /* JADX INFO: renamed from: d */
            public final /* synthetic */ boolean f24891d;

            /* JADX WARN: Multi-variable type inference failed */
            public C13339a(Map<InterfaceC12008u0, ? extends InterfaceC12012w0> map, boolean z2) {
                this.f24890c = map;
                this.f24891d = z2;
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12018z0
            public boolean approximateCapturedTypes() {
                return this.f24891d;
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12010v0
            public InterfaceC12012w0 get(InterfaceC12008u0 interfaceC12008u0) {
                C12238m.checkNotNullParameter(interfaceC12008u0, "key");
                return this.f24890c.get(interfaceC12008u0);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12018z0
            public boolean isEmpty() {
                return this.f24890c.isEmpty();
            }
        }

        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static /* synthetic */ AbstractC12010v0 createByConstructorsMap$default(a aVar, Map map, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                z2 = false;
            }
            return aVar.createByConstructorsMap(map, z2);
        }

        public final AbstractC12018z0 create(AbstractC11913c0 abstractC11913c0) {
            C12238m.checkNotNullParameter(abstractC11913c0, "kotlinType");
            return create(abstractC11913c0.getConstructor(), abstractC11913c0.getArguments());
        }

        public final AbstractC12010v0 createByConstructorsMap(Map<InterfaceC12008u0, ? extends InterfaceC12012w0> map) {
            C12238m.checkNotNullParameter(map, "map");
            return createByConstructorsMap$default(this, map, false, 2, null);
        }

        public final AbstractC12010v0 createByConstructorsMap(Map<InterfaceC12008u0, ? extends InterfaceC12012w0> map, boolean z2) {
            C12238m.checkNotNullParameter(map, "map");
            return new C13339a(map, z2);
        }

        public final AbstractC12018z0 create(InterfaceC12008u0 interfaceC12008u0, List<? extends InterfaceC12012w0> list) {
            C12238m.checkNotNullParameter(interfaceC12008u0, "typeConstructor");
            C12238m.checkNotNullParameter(list, "arguments");
            List<InterfaceC11477z0> parameters = interfaceC12008u0.getParameters();
            C12238m.checkNotNullExpressionValue(parameters, "typeConstructor.parameters");
            InterfaceC11477z0 interfaceC11477z0 = (InterfaceC11477z0) C12163u.lastOrNull((List) parameters);
            if (!C12238m.areEqual(interfaceC11477z0 == null ? null : Boolean.valueOf(interfaceC11477z0.isCapturedFromOuterDeclaration()), Boolean.TRUE)) {
                return new C12017z(parameters, list);
            }
            List<InterfaceC11477z0> parameters2 = interfaceC12008u0.getParameters();
            C12238m.checkNotNullExpressionValue(parameters2, "typeConstructor.parameters");
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(parameters2, 10));
            Iterator<T> it = parameters2.iterator();
            while (it.hasNext()) {
                arrayList.add(((InterfaceC11477z0) it.next()).getTypeConstructor());
            }
            return createByConstructorsMap$default(this, C12136h0.toMap(C12163u.zip(arrayList, list)), false, 2, null);
        }
    }

    public static final AbstractC12018z0 create(InterfaceC12008u0 interfaceC12008u0, List<? extends InterfaceC12012w0> list) {
        return f24889b.create(interfaceC12008u0, list);
    }

    public static final AbstractC12010v0 createByConstructorsMap(Map<InterfaceC12008u0, ? extends InterfaceC12012w0> map) {
        return f24889b.createByConstructorsMap(map);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12018z0
    public InterfaceC12012w0 get(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "key");
        return get(abstractC11913c0.getConstructor());
    }

    public abstract InterfaceC12012w0 get(InterfaceC12008u0 interfaceC12008u0);
}
