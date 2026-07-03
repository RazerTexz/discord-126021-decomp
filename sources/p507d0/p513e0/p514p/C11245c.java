package p507d0.p513e0.p514p;

import java.io.IOException;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import p507d0.InterfaceC11213c;
import p507d0.p513e0.p514p.p515d.C11248b;
import p507d0.p513e0.p514p.p515d.C11264j;
import p507d0.p513e0.p514p.p515d.C11265j0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11465t0;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11684i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11695t;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.C11673f;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.C11674g;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.C11675h;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11708g;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.C11885u;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12235j;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.c */
/* JADX INFO: compiled from: reflectLambda.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11245c {

    /* JADX INFO: renamed from: d0.e0.p.c$a */
    /* JADX INFO: compiled from: reflectLambda.kt */
    public static final /* synthetic */ class a extends C12235j implements Function2<C11885u, C11684i, InterfaceC11465t0> {

        /* JADX INFO: renamed from: j */
        public static final a f22318j = new a();

        public a() {
            super(2);
        }

        @Override // p507d0.p592z.p594d.AbstractC12221d, kotlin.reflect.KCallable
        public final String getName() {
            return "loadFunction";
        }

        @Override // p507d0.p592z.p594d.AbstractC12221d
        public final KDeclarationContainer getOwner() {
            return C12216a0.getOrCreateKotlinClass(C11885u.class);
        }

        @Override // p507d0.p592z.p594d.AbstractC12221d
        public final String getSignature() {
            return "loadFunction(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Function;)Lorg/jetbrains/kotlin/descriptors/SimpleFunctionDescriptor;";
        }

        @Override // kotlin.jvm.functions.Function2
        public final InterfaceC11465t0 invoke(C11885u c11885u, C11684i c11684i) {
            C12238m.checkNotNullParameter(c11885u, "p1");
            C12238m.checkNotNullParameter(c11684i, "p2");
            return c11885u.loadFunction(c11684i);
        }
    }

    public static final <R> KFunction<R> reflect(InterfaceC11213c<? extends R> interfaceC11213c) throws IOException {
        C12238m.checkNotNullParameter(interfaceC11213c, "$this$reflect");
        Metadata metadata = (Metadata) interfaceC11213c.getClass().getAnnotation(Metadata.class);
        if (metadata != null) {
            String[] strArrM10883d1 = metadata.m10883d1();
            if (strArrM10883d1.length == 0) {
                strArrM10883d1 = null;
            }
            if (strArrM10883d1 != null) {
                Pair<C11674g, C11684i> functionDataFrom = C11675h.readFunctionDataFrom(strArrM10883d1, metadata.m10884d2());
                C11674g c11674gComponent1 = functionDataFrom.component1();
                C11684i c11684iComponent2 = functionDataFrom.component2();
                C11673f c11673f = new C11673f(metadata.m10886mv(), (metadata.m10888xi() & 8) != 0);
                Class<?> cls = interfaceC11213c.getClass();
                C11695t typeTable = c11684iComponent2.getTypeTable();
                C12238m.checkNotNullExpressionValue(typeTable, "proto.typeTable");
                InterfaceC11465t0 interfaceC11465t0 = (InterfaceC11465t0) C11265j0.deserializeToDescriptor(cls, c11684iComponent2, c11674gComponent1, new C11708g(typeTable), c11673f, a.f22318j);
                if (interfaceC11465t0 != null) {
                    return new C11264j(C11248b.f22320m, interfaceC11465t0);
                }
            }
        }
        return null;
    }
}
