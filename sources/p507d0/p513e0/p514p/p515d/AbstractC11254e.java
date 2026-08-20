package p507d0.p513e0.p514p.p515d;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11464t;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11331e0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.C11423b;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.C11632z;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.C11649j;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11678c;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11689n;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.C11667a;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.AbstractC11672e;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.C11675h;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11706e;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11708g;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.InterfaceC11704c;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11717f;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.C11859d;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.C11865j;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.InterfaceC11861f;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.e */
/* JADX INFO: compiled from: RuntimeTypeMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11254e {

    /* JADX INFO: renamed from: d0.e0.p.d.e$a */
    /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
    public static final class a extends AbstractC11254e {

        /* JADX INFO: renamed from: a */
        public final Field f22337a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Field field) {
            super(null);
            C12238m.checkNotNullParameter(field, "field");
            this.f22337a = field;
        }

        @Override // p507d0.p513e0.p514p.p515d.AbstractC11254e
        public String asString() {
            StringBuilder sb = new StringBuilder();
            String name = this.f22337a.getName();
            C12238m.checkNotNullExpressionValue(name, "field.name");
            sb.append(C11632z.getterName(name));
            sb.append("()");
            Class<?> type = this.f22337a.getType();
            C12238m.checkNotNullExpressionValue(type, "field.type");
            sb.append(C11423b.getDesc(type));
            return sb.toString();
        }

        public final Field getField() {
            return this.f22337a;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.e$b */
    /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
    public static final class b extends AbstractC11254e {

        /* JADX INFO: renamed from: a */
        public final Method f22338a;

        /* JADX INFO: renamed from: b */
        public final Method f22339b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Method method, Method method2) {
            super(null);
            C12238m.checkNotNullParameter(method, "getterMethod");
            this.f22338a = method;
            this.f22339b = method2;
        }

        @Override // p507d0.p513e0.p514p.p515d.AbstractC11254e
        public String asString() {
            return C11261h0.access$getSignature$p(this.f22338a);
        }

        public final Method getGetterMethod() {
            return this.f22338a;
        }

        public final Method getSetterMethod() {
            return this.f22339b;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.e$c */
    /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
    public static final class c extends AbstractC11254e {

        /* JADX INFO: renamed from: a */
        public final String f22340a;

        /* JADX INFO: renamed from: b */
        public final InterfaceC11453n0 f22341b;

        /* JADX INFO: renamed from: c */
        public final C11689n f22342c;

        /* JADX INFO: renamed from: d */
        public final C11667a.d f22343d;

        /* JADX INFO: renamed from: e */
        public final InterfaceC11704c f22344e;

        /* JADX INFO: renamed from: f */
        public final C11708g f22345f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Code duplicated, block: B:27:0x0109  */
        public c(InterfaceC11453n0 interfaceC11453n0, C11689n c11689n, C11667a.d dVar, InterfaceC11704c interfaceC11704c, C11708g c11708g) {
            String string;
            String strM823K;
            super(null);
            C12238m.checkNotNullParameter(interfaceC11453n0, "descriptor");
            C12238m.checkNotNullParameter(c11689n, "proto");
            C12238m.checkNotNullParameter(dVar, "signature");
            C12238m.checkNotNullParameter(interfaceC11704c, "nameResolver");
            C12238m.checkNotNullParameter(c11708g, "typeTable");
            this.f22341b = interfaceC11453n0;
            this.f22342c = c11689n;
            this.f22343d = dVar;
            this.f22344e = interfaceC11704c;
            this.f22345f = c11708g;
            if (dVar.hasGetter()) {
                StringBuilder sb = new StringBuilder();
                C11667a.c getter = dVar.getGetter();
                C12238m.checkNotNullExpressionValue(getter, "signature.getter");
                sb.append(interfaceC11704c.getString(getter.getName()));
                C11667a.c getter2 = dVar.getGetter();
                C12238m.checkNotNullExpressionValue(getter2, "signature.getter");
                sb.append(interfaceC11704c.getString(getter2.getDesc()));
                strM823K = sb.toString();
            } else {
                AbstractC11672e.a jvmFieldSignature$default = C11675h.getJvmFieldSignature$default(C11675h.f23720a, c11689n, interfaceC11704c, c11708g, false, 8, null);
                if (jvmFieldSignature$default == null) {
                    throw new C11247a0("No field signature for property: " + interfaceC11453n0);
                }
                String strComponent1 = jvmFieldSignature$default.component1();
                String strComponent2 = jvmFieldSignature$default.component2();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(C11632z.getterName(strComponent1));
                InterfaceC11450m containingDeclaration = interfaceC11453n0.getContainingDeclaration();
                C12238m.checkNotNullExpressionValue(containingDeclaration, "descriptor.containingDeclaration");
                if (C12238m.areEqual(interfaceC11453n0.getVisibility(), C11464t.f23086d) && (containingDeclaration instanceof C11859d)) {
                    C11678c classProto = ((C11859d) containingDeclaration).getClassProto();
                    AbstractC11727g.f<C11678c, Integer> fVar = C11667a.f23659i;
                    C12238m.checkNotNullExpressionValue(fVar, "JvmProtoBuf.classModuleName");
                    Integer num = (Integer) C11706e.getExtensionOrNull(classProto, fVar);
                    String string2 = (num == null || (string2 = interfaceC11704c.getString(num.intValue())) == null) ? "main" : string2;
                    StringBuilder sbM833U = C1643a.m833U("$");
                    sbM833U.append(C11717f.sanitizeAsJavaIdentifier(string2));
                    string = sbM833U.toString();
                } else if (C12238m.areEqual(interfaceC11453n0.getVisibility(), C11464t.f23083a) && (containingDeclaration instanceof InterfaceC11331e0)) {
                    Objects.requireNonNull(interfaceC11453n0, "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedPropertyDescriptor");
                    InterfaceC11861f containerSource = ((C11865j) interfaceC11453n0).getContainerSource();
                    if (containerSource instanceof C11649j) {
                        C11649j c11649j = (C11649j) containerSource;
                        if (c11649j.getFacadeClassName() != null) {
                            StringBuilder sbM833U2 = C1643a.m833U("$");
                            sbM833U2.append(c11649j.getSimpleName().asString());
                            string = sbM833U2.toString();
                        } else {
                            string = "";
                        }
                    } else {
                        string = "";
                    }
                } else {
                    string = "";
                }
                strM823K = C1643a.m823K(sb2, string, "()", strComponent2);
            }
            this.f22340a = strM823K;
        }

        @Override // p507d0.p513e0.p514p.p515d.AbstractC11254e
        public String asString() {
            return this.f22340a;
        }

        public final InterfaceC11453n0 getDescriptor() {
            return this.f22341b;
        }

        public final InterfaceC11704c getNameResolver() {
            return this.f22344e;
        }

        public final C11689n getProto() {
            return this.f22342c;
        }

        public final C11667a.d getSignature() {
            return this.f22343d;
        }

        public final C11708g getTypeTable() {
            return this.f22345f;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.e$d */
    /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
    public static final class d extends AbstractC11254e {

        /* JADX INFO: renamed from: a */
        public final AbstractC11252d.e f22346a;

        /* JADX INFO: renamed from: b */
        public final AbstractC11252d.e f22347b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AbstractC11252d.e eVar, AbstractC11252d.e eVar2) {
            super(null);
            C12238m.checkNotNullParameter(eVar, "getterSignature");
            this.f22346a = eVar;
            this.f22347b = eVar2;
        }

        @Override // p507d0.p513e0.p514p.p515d.AbstractC11254e
        public String asString() {
            return this.f22346a.asString();
        }

        public final AbstractC11252d.e getGetterSignature() {
            return this.f22346a;
        }

        public final AbstractC11252d.e getSetterSignature() {
            return this.f22347b;
        }
    }

    public AbstractC11254e(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public abstract String asString();
}
