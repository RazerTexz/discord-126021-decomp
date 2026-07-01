package d0.e0.p.d;

import b.d.b.a.outline;
import d0.e0.p.d.RuntimeTypeMapper;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.DescriptorVisibilities;
import d0.e0.p.d.m0.c.PackageFragmentDescriptor;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.k1.b.reflectClassUtil;
import d0.e0.p.d.m0.e.a.JvmAbi;
import d0.e0.p.d.m0.e.b.JvmPackagePartSource;
import d0.e0.p.d.m0.f.a0.JvmProtoBuf;
import d0.e0.p.d.m0.f.a0.b.JvmMemberSignature;
import d0.e0.p.d.m0.f.a0.b.JvmProtoBufUtil;
import d0.e0.p.d.m0.f.z.NameResolver;
import d0.e0.p.d.m0.f.z.ProtoBufUtil;
import d0.e0.p.d.m0.f.z.TypeTable;
import d0.e0.p.d.m0.g.NameUtils;
import d0.e0.p.d.m0.i.GeneratedMessageLite;
import d0.e0.p.d.m0.l.b.e0.DeserializedClassDescriptor;
import d0.e0.p.d.m0.l.b.e0.DeserializedContainerSource2;
import d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor4;
import d0.z.d.Intrinsics3;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.e, reason: use source file name */
/* JADX INFO: compiled from: RuntimeTypeMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class RuntimeTypeMapper2 {

    /* JADX INFO: renamed from: d0.e0.p.d.e$a */
    /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
    public static final class a extends RuntimeTypeMapper2 {
        public final Field a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Field field) {
            super(null);
            Intrinsics3.checkNotNullParameter(field, "field");
            this.a = field;
        }

        @Override // d0.e0.p.d.RuntimeTypeMapper2
        public String asString() {
            StringBuilder sb = new StringBuilder();
            String name = this.a.getName();
            Intrinsics3.checkNotNullExpressionValue(name, "field.name");
            sb.append(JvmAbi.getterName(name));
            sb.append("()");
            Class<?> type = this.a.getType();
            Intrinsics3.checkNotNullExpressionValue(type, "field.type");
            sb.append(reflectClassUtil.getDesc(type));
            return sb.toString();
        }

        public final Field getField() {
            return this.a;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.e$b */
    /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
    public static final class b extends RuntimeTypeMapper2 {
        public final Method a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f3194b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Method method, Method method2) {
            super(null);
            Intrinsics3.checkNotNullParameter(method, "getterMethod");
            this.a = method;
            this.f3194b = method2;
        }

        @Override // d0.e0.p.d.RuntimeTypeMapper2
        public String asString() {
            return RuntimeTypeMapper5.access$getSignature$p(this.a);
        }

        public final Method getGetterMethod() {
            return this.a;
        }

        public final Method getSetterMethod() {
            return this.f3194b;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.e$c */
    /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
    public static final class c extends RuntimeTypeMapper2 {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final PropertyDescriptor f3195b;
        public final d0.e0.p.d.m0.f.n c;
        public final JvmProtoBuf.d d;
        public final NameResolver e;
        public final TypeTable f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Code duplicated, block: B:27:0x0109  */
        public c(PropertyDescriptor propertyDescriptor, d0.e0.p.d.m0.f.n nVar, JvmProtoBuf.d dVar, NameResolver nameResolver, TypeTable typeTable) {
            String string;
            String strK;
            super(null);
            Intrinsics3.checkNotNullParameter(propertyDescriptor, "descriptor");
            Intrinsics3.checkNotNullParameter(nVar, "proto");
            Intrinsics3.checkNotNullParameter(dVar, "signature");
            Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
            Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
            this.f3195b = propertyDescriptor;
            this.c = nVar;
            this.d = dVar;
            this.e = nameResolver;
            this.f = typeTable;
            if (dVar.hasGetter()) {
                StringBuilder sb = new StringBuilder();
                JvmProtoBuf.c getter = dVar.getGetter();
                Intrinsics3.checkNotNullExpressionValue(getter, "signature.getter");
                sb.append(nameResolver.getString(getter.getName()));
                JvmProtoBuf.c getter2 = dVar.getGetter();
                Intrinsics3.checkNotNullExpressionValue(getter2, "signature.getter");
                sb.append(nameResolver.getString(getter2.getDesc()));
                strK = sb.toString();
            } else {
                JvmMemberSignature.a jvmFieldSignature$default = JvmProtoBufUtil.getJvmFieldSignature$default(JvmProtoBufUtil.a, nVar, nameResolver, typeTable, false, 8, null);
                if (jvmFieldSignature$default == null) {
                    throw new KotlinReflectionInternalError("No field signature for property: " + propertyDescriptor);
                }
                String strComponent1 = jvmFieldSignature$default.component1();
                String strComponent2 = jvmFieldSignature$default.component2();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(JvmAbi.getterName(strComponent1));
                DeclarationDescriptor containingDeclaration = propertyDescriptor.getContainingDeclaration();
                Intrinsics3.checkNotNullExpressionValue(containingDeclaration, "descriptor.containingDeclaration");
                if (Intrinsics3.areEqual(propertyDescriptor.getVisibility(), DescriptorVisibilities.d) && (containingDeclaration instanceof DeserializedClassDescriptor)) {
                    d0.e0.p.d.m0.f.c classProto = ((DeserializedClassDescriptor) containingDeclaration).getClassProto();
                    GeneratedMessageLite.f<d0.e0.p.d.m0.f.c, Integer> fVar = JvmProtoBuf.i;
                    Intrinsics3.checkNotNullExpressionValue(fVar, "JvmProtoBuf.classModuleName");
                    Integer num = (Integer) ProtoBufUtil.getExtensionOrNull(classProto, fVar);
                    String string2 = (num == null || (string2 = nameResolver.getString(num.intValue())) == null) ? "main" : string2;
                    StringBuilder sbU = outline.U("$");
                    sbU.append(NameUtils.sanitizeAsJavaIdentifier(string2));
                    string = sbU.toString();
                } else if (Intrinsics3.areEqual(propertyDescriptor.getVisibility(), DescriptorVisibilities.a) && (containingDeclaration instanceof PackageFragmentDescriptor)) {
                    Objects.requireNonNull(propertyDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedPropertyDescriptor");
                    DeserializedContainerSource2 containerSource = ((DeserializedMemberDescriptor4) propertyDescriptor).getContainerSource();
                    if (containerSource instanceof JvmPackagePartSource) {
                        JvmPackagePartSource jvmPackagePartSource = (JvmPackagePartSource) containerSource;
                        if (jvmPackagePartSource.getFacadeClassName() != null) {
                            StringBuilder sbU2 = outline.U("$");
                            sbU2.append(jvmPackagePartSource.getSimpleName().asString());
                            string = sbU2.toString();
                        } else {
                            string = "";
                        }
                    } else {
                        string = "";
                    }
                } else {
                    string = "";
                }
                strK = outline.K(sb2, string, "()", strComponent2);
            }
            this.a = strK;
        }

        @Override // d0.e0.p.d.RuntimeTypeMapper2
        public String asString() {
            return this.a;
        }

        public final PropertyDescriptor getDescriptor() {
            return this.f3195b;
        }

        public final NameResolver getNameResolver() {
            return this.e;
        }

        public final d0.e0.p.d.m0.f.n getProto() {
            return this.c;
        }

        public final JvmProtoBuf.d getSignature() {
            return this.d;
        }

        public final TypeTable getTypeTable() {
            return this.f;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.e$d */
    /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
    public static final class d extends RuntimeTypeMapper2 {
        public final RuntimeTypeMapper.e a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RuntimeTypeMapper.e f3196b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(RuntimeTypeMapper.e eVar, RuntimeTypeMapper.e eVar2) {
            super(null);
            Intrinsics3.checkNotNullParameter(eVar, "getterSignature");
            this.a = eVar;
            this.f3196b = eVar2;
        }

        @Override // d0.e0.p.d.RuntimeTypeMapper2
        public String asString() {
            return this.a.asString();
        }

        public final RuntimeTypeMapper.e getGetterSignature() {
            return this.a;
        }

        public final RuntimeTypeMapper.e getSetterSignature() {
            return this.f3196b;
        }
    }

    public RuntimeTypeMapper2(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public abstract String asString();
}
