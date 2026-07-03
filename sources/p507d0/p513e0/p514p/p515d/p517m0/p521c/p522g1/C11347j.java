package p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1;

import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import p507d0.C12083g;
import p507d0.EnumC12110i;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.j */
/* JADX INFO: compiled from: BuiltInAnnotationDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11347j implements InterfaceC11340c {

    /* JADX INFO: renamed from: a */
    public final AbstractC11288h f22739a;

    /* JADX INFO: renamed from: b */
    public final C11713b f22740b;

    /* JADX INFO: renamed from: c */
    public final Map<C11716e, AbstractC11815g<?>> f22741c;

    /* JADX INFO: renamed from: d */
    public final Lazy f22742d;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.j$a */
    /* JADX INFO: compiled from: BuiltInAnnotationDescriptor.kt */
    public static final class a extends AbstractC12240o implements Function0<AbstractC11934j0> {
        public a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AbstractC11934j0 invoke() {
            return C11347j.this.f22739a.getBuiltInClassByFqName(C11347j.this.getFqName()).getDefaultType();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C11347j(AbstractC11288h abstractC11288h, C11713b c11713b, Map<C11716e, ? extends AbstractC11815g<?>> map) {
        C12238m.checkNotNullParameter(abstractC11288h, "builtIns");
        C12238m.checkNotNullParameter(c11713b, "fqName");
        C12238m.checkNotNullParameter(map, "allValueArguments");
        this.f22739a = abstractC11288h;
        this.f22740b = c11713b;
        this.f22741c = map;
        this.f22742d = C12083g.lazy(EnumC12110i.PUBLICATION, new a());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11340c
    public Map<C11716e, AbstractC11815g<?>> getAllValueArguments() {
        return this.f22741c;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11340c
    public C11713b getFqName() {
        return this.f22740b;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11340c
    public InterfaceC11467u0 getSource() {
        InterfaceC11467u0 interfaceC11467u0 = InterfaceC11467u0.f23099a;
        C12238m.checkNotNullExpressionValue(interfaceC11467u0, "NO_SOURCE");
        return interfaceC11467u0;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11340c
    public AbstractC11913c0 getType() {
        Object value = this.f22742d.getValue();
        C12238m.checkNotNullExpressionValue(value, "pyright 2010-2017 JetBrains s.r.o.\n *\n * Licensed under the Apache License, Version 2.0 (the \"License\");\n * you may not use this file except in compliance with the License.\n * You may obtain a copy of the License at\n *\n * http://www.apache.org/licenses/LICENSE-2.0\n *\n * Unless required by applicable law or agreed to in writing, software\n * distributed under the License is distributed on an \"AS IS\" BASIS,\n * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n * See the License for the specific language governing permissions and\n * limitations under the License.\n */\n\npackage org.jetbrains.kotlin.descriptors.annotations\n\nimport org.jetbrains.kotlin.builtins.KotlinBuiltIns\nimport org.jetbrains.kotlin.descriptors.SourceElement\nimport org.jetbrains.kotlin.name.FqName\nimport org.jetbrains.kotlin.name.Name\nimport org.jetbrains.kotlin.resolve.constants.ConstantValue\nimport org.jetbrains.kotlin.types.KotlinType\nimport kotlin.LazyThreadSafetyMode.PUBLICATION\n\nclass BuiltInAnnotationDescriptor(\n        private val builtIns: KotlinBuiltIns,\n        override val fqName: FqName,\n        override val allValueArguments: Map<Name, ConstantValue<*>>\n) : AnnotationDescriptor {\n    override val type: KotlinType by lazy(PUBLICATION) {\n        builtIns.getBuiltInClassByFqName(fqName).defaultType\n    }");
        return (AbstractC11913c0) value;
    }
}
