package d0.e0.p.d.m0.o;

import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.c.ReceiverParameterDescriptor;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.o1.TypeUtils2;
import d0.e0.p.d.m0.o.f;
import d0.e0.p.d.m0.o.k;
import d0.e0.p.d.m0.o.l;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends d0.e0.p.d.m0.o.a {
    public static final i a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<d> f3550b;

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class a extends Lambda implements Function1<FunctionDescriptor, String> {
        public static final a j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(FunctionDescriptor functionDescriptor) {
            Boolean boolValueOf;
            Intrinsics3.checkNotNullParameter(functionDescriptor, "<this>");
            List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
            Intrinsics3.checkNotNullExpressionValue(valueParameters, "valueParameters");
            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) _Collections.lastOrNull((List) valueParameters);
            if (valueParameterDescriptor == null) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(!DescriptorUtils2.declaresOrInheritsDefaultValue(valueParameterDescriptor) && valueParameterDescriptor.getVarargElementType() == null);
            }
            boolean zAreEqual = Intrinsics3.areEqual(boolValueOf, Boolean.TRUE);
            i iVar = i.a;
            if (zAreEqual) {
                return null;
            }
            return "last parameter should not have a default value or be a vararg";
        }
    }

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class b extends Lambda implements Function1<FunctionDescriptor, String> {
        public static final b j = new b();

        public b() {
            super(1);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x0062  */
        @Override // kotlin.jvm.functions.Function1
        public final String invoke(FunctionDescriptor functionDescriptor) {
            boolean z2;
            boolean z3;
            Intrinsics3.checkNotNullParameter(functionDescriptor, "<this>");
            i iVar = i.a;
            DeclarationDescriptor containingDeclaration = functionDescriptor.getContainingDeclaration();
            Intrinsics3.checkNotNullExpressionValue(containingDeclaration, "containingDeclaration");
            if (!((containingDeclaration instanceof ClassDescriptor) && KotlinBuiltIns.isAny((ClassDescriptor) containingDeclaration))) {
                Collection<? extends FunctionDescriptor> overriddenDescriptors = functionDescriptor.getOverriddenDescriptors();
                Intrinsics3.checkNotNullExpressionValue(overriddenDescriptors, "overriddenDescriptors");
                if (!overriddenDescriptors.isEmpty()) {
                    Iterator<T> it = overriddenDescriptors.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z3 = false;
                            break;
                        }
                        DeclarationDescriptor containingDeclaration2 = ((FunctionDescriptor) it.next()).getContainingDeclaration();
                        Intrinsics3.checkNotNullExpressionValue(containingDeclaration2, "it.containingDeclaration");
                        if ((containingDeclaration2 instanceof ClassDescriptor) && KotlinBuiltIns.isAny((ClassDescriptor) containingDeclaration2)) {
                            z3 = true;
                            break;
                        }
                    }
                } else {
                    z3 = false;
                    break;
                }
                z2 = z3;
            }
            if (z2) {
                return null;
            }
            return "must override ''equals()'' in Any";
        }
    }

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class c extends Lambda implements Function1<FunctionDescriptor, String> {
        public static final c j = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(FunctionDescriptor functionDescriptor) {
            boolean zIsSubtypeOf;
            Intrinsics3.checkNotNullParameter(functionDescriptor, "<this>");
            ReceiverParameterDescriptor dispatchReceiverParameter = functionDescriptor.getDispatchReceiverParameter();
            if (dispatchReceiverParameter == null) {
                dispatchReceiverParameter = functionDescriptor.getExtensionReceiverParameter();
            }
            i iVar = i.a;
            boolean z2 = false;
            if (dispatchReceiverParameter != null) {
                KotlinType returnType = functionDescriptor.getReturnType();
                if (returnType == null) {
                    zIsSubtypeOf = false;
                } else {
                    KotlinType type = dispatchReceiverParameter.getType();
                    Intrinsics3.checkNotNullExpressionValue(type, "receiver.type");
                    zIsSubtypeOf = TypeUtils2.isSubtypeOf(returnType, type);
                }
                if (zIsSubtypeOf) {
                    z2 = true;
                }
            }
            if (z2) {
                return null;
            }
            return "receiver must be a supertype of the return type";
        }
    }

    static {
        Name name = OperatorNameConventions.i;
        f.b bVar = f.b.f3549b;
        d0.e0.p.d.m0.o.b[] bVarArr = {bVar, new l.a(1)};
        Name name2 = OperatorNameConventions.j;
        d0.e0.p.d.m0.o.b[] bVarArr2 = {bVar, new l.a(2)};
        Name name3 = OperatorNameConventions.a;
        h hVar = h.a;
        e eVar = e.a;
        Name name4 = OperatorNameConventions.f;
        l.d dVar = l.d.f3560b;
        k.a aVar = k.a.d;
        Name name5 = OperatorNameConventions.h;
        l.c cVar = l.c.f3559b;
        f3550b = Collections2.listOf((Object[]) new d[]{new d(name, bVarArr, (Function1) null, 4, (DefaultConstructorMarker) null), new d(name2, bVarArr2, a.j), new d(name3, new d0.e0.p.d.m0.o.b[]{bVar, hVar, new l.a(2), eVar}, (Function1) null, 4, (DefaultConstructorMarker) null), new d(OperatorNameConventions.f3551b, new d0.e0.p.d.m0.o.b[]{bVar, hVar, new l.a(3), eVar}, (Function1) null, 4, (DefaultConstructorMarker) null), new d(OperatorNameConventions.c, new d0.e0.p.d.m0.o.b[]{bVar, hVar, new l.b(2), eVar}, (Function1) null, 4, (DefaultConstructorMarker) null), new d(OperatorNameConventions.g, new d0.e0.p.d.m0.o.b[]{bVar}, (Function1) null, 4, (DefaultConstructorMarker) null), new d(name4, new d0.e0.p.d.m0.o.b[]{bVar, dVar, hVar, aVar}, (Function1) null, 4, (DefaultConstructorMarker) null), new d(name5, new d0.e0.p.d.m0.o.b[]{bVar, cVar}, (Function1) null, 4, (DefaultConstructorMarker) null), new d(OperatorNameConventions.k, new d0.e0.p.d.m0.o.b[]{bVar, cVar}, (Function1) null, 4, (DefaultConstructorMarker) null), new d(OperatorNameConventions.l, new d0.e0.p.d.m0.o.b[]{bVar, cVar, aVar}, (Function1) null, 4, (DefaultConstructorMarker) null), new d(OperatorNameConventions.f3554y, new d0.e0.p.d.m0.o.b[]{bVar, dVar, hVar}, (Function1) null, 4, (DefaultConstructorMarker) null), new d(OperatorNameConventions.d, new d0.e0.p.d.m0.o.b[]{f.a.f3548b}, b.j), new d(OperatorNameConventions.e, new d0.e0.p.d.m0.o.b[]{bVar, k.b.d, dVar, hVar}, (Function1) null, 4, (DefaultConstructorMarker) null), new d(OperatorNameConventions.G, new d0.e0.p.d.m0.o.b[]{bVar, dVar, hVar}, (Function1) null, 4, (DefaultConstructorMarker) null), new d(OperatorNameConventions.F, new d0.e0.p.d.m0.o.b[]{bVar, cVar}, (Function1) null, 4, (DefaultConstructorMarker) null), new d(Collections2.listOf((Object[]) new Name[]{OperatorNameConventions.n, OperatorNameConventions.o}), new d0.e0.p.d.m0.o.b[]{bVar}, c.j), new d(OperatorNameConventions.H, new d0.e0.p.d.m0.o.b[]{bVar, k.c.d, dVar, hVar}, (Function1) null, 4, (DefaultConstructorMarker) null), new d(OperatorNameConventions.m, new d0.e0.p.d.m0.o.b[]{bVar, cVar}, (Function1) null, 4, (DefaultConstructorMarker) null)});
    }

    @Override // d0.e0.p.d.m0.o.a
    public List<d> getChecks$descriptors() {
        return f3550b;
    }
}
