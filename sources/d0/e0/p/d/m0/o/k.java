package d0.e0.p.d.m0.o;

import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.o.b;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k implements d0.e0.p.d.m0.o.b {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<KotlinBuiltIns, KotlinType> f3556b;
    public final String c;

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class a extends k {
        public static final a d = new a();

        /* JADX INFO: renamed from: d0.e0.p.d.m0.o.k$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: modifierChecks.kt */
        public static final class C0417a extends Lambda implements Function1<KotlinBuiltIns, KotlinType> {
            public static final C0417a j = new C0417a();

            public C0417a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final KotlinType invoke(KotlinBuiltIns kotlinBuiltIns) {
                Intrinsics3.checkNotNullParameter(kotlinBuiltIns, "<this>");
                KotlinType4 booleanType = kotlinBuiltIns.getBooleanType();
                Intrinsics3.checkNotNullExpressionValue(booleanType, "booleanType");
                return booleanType;
            }
        }

        public a() {
            super("Boolean", C0417a.j, null);
        }
    }

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class b extends k {
        public static final b d = new b();

        /* JADX INFO: compiled from: modifierChecks.kt */
        public static final class a extends Lambda implements Function1<KotlinBuiltIns, KotlinType> {
            public static final a j = new a();

            public a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final KotlinType invoke(KotlinBuiltIns kotlinBuiltIns) {
                Intrinsics3.checkNotNullParameter(kotlinBuiltIns, "<this>");
                KotlinType4 intType = kotlinBuiltIns.getIntType();
                Intrinsics3.checkNotNullExpressionValue(intType, "intType");
                return intType;
            }
        }

        public b() {
            super("Int", a.j, null);
        }
    }

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class c extends k {
        public static final c d = new c();

        /* JADX INFO: compiled from: modifierChecks.kt */
        public static final class a extends Lambda implements Function1<KotlinBuiltIns, KotlinType> {
            public static final a j = new a();

            public a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final KotlinType invoke(KotlinBuiltIns kotlinBuiltIns) {
                Intrinsics3.checkNotNullParameter(kotlinBuiltIns, "<this>");
                KotlinType4 unitType = kotlinBuiltIns.getUnitType();
                Intrinsics3.checkNotNullExpressionValue(unitType, "unitType");
                return unitType;
            }
        }

        public c() {
            super("Unit", a.j, null);
        }
    }

    public k(String str, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this.a = str;
        this.f3556b = function1;
        this.c = Intrinsics3.stringPlus("must return ", str);
    }

    @Override // d0.e0.p.d.m0.o.b
    public boolean check(FunctionDescriptor functionDescriptor) {
        Intrinsics3.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        return Intrinsics3.areEqual(functionDescriptor.getReturnType(), this.f3556b.invoke(DescriptorUtils2.getBuiltIns(functionDescriptor)));
    }

    @Override // d0.e0.p.d.m0.o.b
    public String getDescription() {
        return this.c;
    }

    @Override // d0.e0.p.d.m0.o.b
    public String invoke(FunctionDescriptor functionDescriptor) {
        return b.a.invoke(this, functionDescriptor);
    }
}
