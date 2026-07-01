package d0.e0.p.d.m0.e.a.i0.m;

import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.j.DescriptorRenderer2;
import d0.e0.p.d.m0.j.DescriptorRenderer4;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.KotlinType6;
import d0.e0.p.d.m0.n.RawType3;
import d0.e0.p.d.m0.n.TypeProjection;
import d0.e0.p.d.m0.n.l1.KotlinTypeChecker;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import d0.e0.p.d.m0.n.o1.TypeUtils2;
import d0.g0.Strings4;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.m.g, reason: use source file name */
/* JADX INFO: compiled from: RawType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RawType2 extends KotlinType6 implements RawType3 {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.m.g$a */
    /* JADX INFO: compiled from: RawType.kt */
    public static final class a extends Lambda implements Function1<String, CharSequence> {
        public static final a j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final CharSequence invoke(String str) {
            Intrinsics3.checkNotNullParameter(str, "it");
            return Intrinsics3.stringPlus("(raw) ", str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RawType2(KotlinType4 kotlinType4, KotlinType4 kotlinType5) {
        super(kotlinType4, kotlinType5);
        Intrinsics3.checkNotNullParameter(kotlinType4, "lowerBound");
        Intrinsics3.checkNotNullParameter(kotlinType5, "upperBound");
        KotlinTypeChecker.a.isSubtypeOf(kotlinType4, kotlinType5);
    }

    public static final List<String> a(DescriptorRenderer2 descriptorRenderer2, KotlinType kotlinType) {
        List<TypeProjection> arguments = kotlinType.getArguments();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(arguments, 10));
        Iterator<T> it = arguments.iterator();
        while (it.hasNext()) {
            arrayList.add(descriptorRenderer2.renderTypeProjection((TypeProjection) it.next()));
        }
        return arrayList;
    }

    public static final String b(String str, String str2) {
        if (!Strings4.contains$default((CharSequence) str, '<', false, 2, (Object) null)) {
            return str;
        }
        return Strings4.substringBefore$default(str, '<', (String) null, 2, (Object) null) + '<' + str2 + '>' + Strings4.substringAfterLast$default(str, '>', null, 2, null);
    }

    @Override // d0.e0.p.d.m0.n.KotlinType6
    public KotlinType4 getDelegate() {
        return getLowerBound();
    }

    @Override // d0.e0.p.d.m0.n.KotlinType6, d0.e0.p.d.m0.n.KotlinType
    public MemberScope3 getMemberScope() {
        ClassifierDescriptor declarationDescriptor = getConstructor().getDeclarationDescriptor();
        ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
        if (classDescriptor == null) {
            throw new IllegalStateException(Intrinsics3.stringPlus("Incorrect classifier: ", getConstructor().getDeclarationDescriptor()).toString());
        }
        MemberScope3 memberScope = classDescriptor.getMemberScope(RawType.f3341b);
        Intrinsics3.checkNotNullExpressionValue(memberScope, "classDescriptor.getMemberScope(RawSubstitution)");
        return memberScope;
    }

    @Override // d0.e0.p.d.m0.n.KotlinType6
    public String render(DescriptorRenderer2 descriptorRenderer2, DescriptorRenderer4 descriptorRenderer4) {
        String str;
        String str2;
        Intrinsics3.checkNotNullParameter(descriptorRenderer2, "renderer");
        Intrinsics3.checkNotNullParameter(descriptorRenderer4, "options");
        String strRenderType = descriptorRenderer2.renderType(getLowerBound());
        String strRenderType2 = descriptorRenderer2.renderType(getUpperBound());
        if (descriptorRenderer4.getDebugMode()) {
            return "raw (" + strRenderType + ".." + strRenderType2 + ')';
        }
        if (getUpperBound().getArguments().isEmpty()) {
            return descriptorRenderer2.renderFlexibleType(strRenderType, strRenderType2, TypeUtils2.getBuiltIns(this));
        }
        List<String> listA = a(descriptorRenderer2, getLowerBound());
        List<String> listA2 = a(descriptorRenderer2, getUpperBound());
        String strJoinToString$default = _Collections.joinToString$default(listA, ", ", null, null, 0, null, a.j, 30, null);
        List listZip = _Collections.zip(listA, listA2);
        boolean z2 = false;
        if (!(listZip instanceof Collection) || !listZip.isEmpty()) {
            Iterator it = listZip.iterator();
            do {
                if (!it.hasNext()) {
                    z2 = true;
                    break;
                }
                Tuples2 tuples2 = (Tuples2) it.next();
                str = (String) tuples2.getFirst();
                str2 = (String) tuples2.getSecond();
            } while (Intrinsics3.areEqual(str, Strings4.removePrefix(str2, "out ")) || Intrinsics3.areEqual(str2, "*"));
        } else {
            z2 = true;
            break;
        }
        if (z2) {
            strRenderType2 = b(strRenderType2, strJoinToString$default);
        }
        String strB = b(strRenderType, strJoinToString$default);
        return Intrinsics3.areEqual(strB, strRenderType2) ? strB : descriptorRenderer2.renderFlexibleType(strB, strRenderType2, TypeUtils2.getBuiltIns(this));
    }

    @Override // d0.e0.p.d.m0.n.KotlinType3
    public RawType2 makeNullableAsSpecified(boolean z2) {
        return new RawType2(getLowerBound().makeNullableAsSpecified(z2), getUpperBound().makeNullableAsSpecified(z2));
    }

    @Override // d0.e0.p.d.m0.n.KotlinType3
    public RawType2 replaceAnnotations(Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(annotations4, "newAnnotations");
        return new RawType2(getLowerBound().replaceAnnotations(annotations4), getUpperBound().replaceAnnotations(annotations4));
    }

    public RawType2(KotlinType4 kotlinType4, KotlinType4 kotlinType5, boolean z2) {
        super(kotlinType4, kotlinType5);
        if (z2) {
            return;
        }
        KotlinTypeChecker.a.isSubtypeOf(kotlinType4, kotlinType5);
    }

    @Override // d0.e0.p.d.m0.n.KotlinType3, d0.e0.p.d.m0.n.KotlinType
    public KotlinType6 refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new RawType2((KotlinType4) kotlinTypeRefiner.refineType(getLowerBound()), (KotlinType4) kotlinTypeRefiner.refineType(getUpperBound()), true);
    }
}
