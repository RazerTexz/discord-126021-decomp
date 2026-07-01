package d0.e0.p.d.m0.c.g1;

import d0.Lazy5;
import d0.LazyJVM;
import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.j, reason: use source file name */
/* JADX INFO: compiled from: BuiltInAnnotationDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class BuiltInAnnotationDescriptor implements AnnotationDescriptor {
    public final KotlinBuiltIns a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FqName f3252b;
    public final Map<Name, d0.e0.p.d.m0.k.v.g<?>> c;
    public final Lazy d;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.j$a */
    /* JADX INFO: compiled from: BuiltInAnnotationDescriptor.kt */
    public static final class a extends Lambda implements Function0<KotlinType4> {
        public a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final KotlinType4 invoke() {
            return BuiltInAnnotationDescriptor.this.a.getBuiltInClassByFqName(BuiltInAnnotationDescriptor.this.getFqName()).getDefaultType();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BuiltInAnnotationDescriptor(KotlinBuiltIns kotlinBuiltIns, FqName fqName, Map<Name, ? extends d0.e0.p.d.m0.k.v.g<?>> map) {
        Intrinsics3.checkNotNullParameter(kotlinBuiltIns, "builtIns");
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        Intrinsics3.checkNotNullParameter(map, "allValueArguments");
        this.a = kotlinBuiltIns;
        this.f3252b = fqName;
        this.c = map;
        this.d = LazyJVM.lazy(Lazy5.PUBLICATION, new a());
    }

    @Override // d0.e0.p.d.m0.c.g1.AnnotationDescriptor
    public Map<Name, d0.e0.p.d.m0.k.v.g<?>> getAllValueArguments() {
        return this.c;
    }

    @Override // d0.e0.p.d.m0.c.g1.AnnotationDescriptor
    public FqName getFqName() {
        return this.f3252b;
    }

    @Override // d0.e0.p.d.m0.c.g1.AnnotationDescriptor
    public SourceElement getSource() {
        SourceElement sourceElement = SourceElement.a;
        Intrinsics3.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
        return sourceElement;
    }

    @Override // d0.e0.p.d.m0.c.g1.AnnotationDescriptor
    public KotlinType getType() {
        Object value = this.d.getValue();
        Intrinsics3.checkNotNullExpressionValue(value, "pyright 2010-2017 JetBrains s.r.o.\n *\n * Licensed under the Apache License, Version 2.0 (the \"License\");\n * you may not use this file except in compliance with the License.\n * You may obtain a copy of the License at\n *\n * http://www.apache.org/licenses/LICENSE-2.0\n *\n * Unless required by applicable law or agreed to in writing, software\n * distributed under the License is distributed on an \"AS IS\" BASIS,\n * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n * See the License for the specific language governing permissions and\n * limitations under the License.\n */\n\npackage org.jetbrains.kotlin.descriptors.annotations\n\nimport org.jetbrains.kotlin.builtins.KotlinBuiltIns\nimport org.jetbrains.kotlin.descriptors.SourceElement\nimport org.jetbrains.kotlin.name.FqName\nimport org.jetbrains.kotlin.name.Name\nimport org.jetbrains.kotlin.resolve.constants.ConstantValue\nimport org.jetbrains.kotlin.types.KotlinType\nimport kotlin.LazyThreadSafetyMode.PUBLICATION\n\nclass BuiltInAnnotationDescriptor(\n        private val builtIns: KotlinBuiltIns,\n        override val fqName: FqName,\n        override val allValueArguments: Map<Name, ConstantValue<*>>\n) : AnnotationDescriptor {\n    override val type: KotlinType by lazy(PUBLICATION) {\n        builtIns.getBuiltInClassByFqName(fqName).defaultType\n    }");
        return (KotlinType) value;
    }
}
