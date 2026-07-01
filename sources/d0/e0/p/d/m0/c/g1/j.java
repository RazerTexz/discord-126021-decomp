package d0.e0.p.d.m0.c.g1;

import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.n.c0;
import java.util.Map;
import kotlin.Lazy;

/* JADX INFO: compiled from: BuiltInAnnotationDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements c {
    public final d0.e0.p.d.m0.b.h a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.g.b f3252b;
    public final Map<d0.e0.p.d.m0.g.e, d0.e0.p.d.m0.k.v.g<?>> c;
    public final Lazy d;

    /* JADX WARN: Multi-variable type inference failed */
    public j(d0.e0.p.d.m0.b.h hVar, d0.e0.p.d.m0.g.b bVar, Map<d0.e0.p.d.m0.g.e, ? extends d0.e0.p.d.m0.k.v.g<?>> map) {
        d0.z.d.m.checkNotNullParameter(hVar, "builtIns");
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        d0.z.d.m.checkNotNullParameter(map, "allValueArguments");
        this.a = hVar;
        this.f3252b = bVar;
        this.c = map;
        this.d = d0.g.lazy(d0.i.PUBLICATION, new j$a(this));
    }

    public static final /* synthetic */ d0.e0.p.d.m0.b.h access$getBuiltIns$p(j jVar) {
        return jVar.a;
    }

    @Override // d0.e0.p.d.m0.c.g1.c
    public Map<d0.e0.p.d.m0.g.e, d0.e0.p.d.m0.k.v.g<?>> getAllValueArguments() {
        return this.c;
    }

    @Override // d0.e0.p.d.m0.c.g1.c
    public d0.e0.p.d.m0.g.b getFqName() {
        return this.f3252b;
    }

    @Override // d0.e0.p.d.m0.c.g1.c
    public u0 getSource() {
        u0 u0Var = u0.a;
        d0.z.d.m.checkNotNullExpressionValue(u0Var, "NO_SOURCE");
        return u0Var;
    }

    @Override // d0.e0.p.d.m0.c.g1.c
    public c0 getType() {
        Object value = this.d.getValue();
        d0.z.d.m.checkNotNullExpressionValue(value, "pyright 2010-2017 JetBrains s.r.o.\n *\n * Licensed under the Apache License, Version 2.0 (the \"License\");\n * you may not use this file except in compliance with the License.\n * You may obtain a copy of the License at\n *\n * http://www.apache.org/licenses/LICENSE-2.0\n *\n * Unless required by applicable law or agreed to in writing, software\n * distributed under the License is distributed on an \"AS IS\" BASIS,\n * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n * See the License for the specific language governing permissions and\n * limitations under the License.\n */\n\npackage org.jetbrains.kotlin.descriptors.annotations\n\nimport org.jetbrains.kotlin.builtins.KotlinBuiltIns\nimport org.jetbrains.kotlin.descriptors.SourceElement\nimport org.jetbrains.kotlin.name.FqName\nimport org.jetbrains.kotlin.name.Name\nimport org.jetbrains.kotlin.resolve.constants.ConstantValue\nimport org.jetbrains.kotlin.types.KotlinType\nimport kotlin.LazyThreadSafetyMode.PUBLICATION\n\nclass BuiltInAnnotationDescriptor(\n        private val builtIns: KotlinBuiltIns,\n        override val fqName: FqName,\n        override val allValueArguments: Map<Name, ConstantValue<*>>\n) : AnnotationDescriptor {\n    override val type: KotlinType by lazy(PUBLICATION) {\n        builtIns.getBuiltInClassByFqName(fqName).defaultType\n    }");
        return (c0) value;
    }
}
