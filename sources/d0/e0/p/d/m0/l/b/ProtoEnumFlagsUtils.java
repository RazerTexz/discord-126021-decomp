package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.DescriptorVisibilities;
import d0.e0.p.d.m0.c.DescriptorVisibility2;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.a0, reason: use source file name */
/* JADX INFO: compiled from: ProtoEnumFlagsUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ProtoEnumFlagsUtils {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.a0$a */
    /* JADX INFO: compiled from: ProtoEnumFlagsUtils.kt */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f3482b;

        static {
            d0.e0.p.d.m0.f.j.values();
            a = new int[]{1, 2, 3, 4};
            CallableMemberDescriptor.a.values();
            d0.e0.p.d.m0.f.x.values();
            f3482b = new int[]{1, 2, 4, 5, 3, 6};
        }
    }

    public static final DescriptorVisibility2 descriptorVisibility(ProtoEnumFlags protoEnumFlags, d0.e0.p.d.m0.f.x xVar) {
        Intrinsics3.checkNotNullParameter(protoEnumFlags, "<this>");
        switch (xVar == null ? -1 : a.f3482b[xVar.ordinal()]) {
            case 1:
                DescriptorVisibility2 descriptorVisibility2 = DescriptorVisibilities.d;
                Intrinsics3.checkNotNullExpressionValue(descriptorVisibility2, "INTERNAL");
                return descriptorVisibility2;
            case 2:
                DescriptorVisibility2 descriptorVisibility3 = DescriptorVisibilities.a;
                Intrinsics3.checkNotNullExpressionValue(descriptorVisibility3, "PRIVATE");
                return descriptorVisibility3;
            case 3:
                DescriptorVisibility2 descriptorVisibility4 = DescriptorVisibilities.f3300b;
                Intrinsics3.checkNotNullExpressionValue(descriptorVisibility4, "PRIVATE_TO_THIS");
                return descriptorVisibility4;
            case 4:
                DescriptorVisibility2 descriptorVisibility5 = DescriptorVisibilities.c;
                Intrinsics3.checkNotNullExpressionValue(descriptorVisibility5, "PROTECTED");
                return descriptorVisibility5;
            case 5:
                DescriptorVisibility2 descriptorVisibility6 = DescriptorVisibilities.e;
                Intrinsics3.checkNotNullExpressionValue(descriptorVisibility6, "PUBLIC");
                return descriptorVisibility6;
            case 6:
                DescriptorVisibility2 descriptorVisibility7 = DescriptorVisibilities.f;
                Intrinsics3.checkNotNullExpressionValue(descriptorVisibility7, "LOCAL");
                return descriptorVisibility7;
            default:
                DescriptorVisibility2 descriptorVisibility8 = DescriptorVisibilities.a;
                Intrinsics3.checkNotNullExpressionValue(descriptorVisibility8, "PRIVATE");
                return descriptorVisibility8;
        }
    }

    public static final CallableMemberDescriptor.a memberKind(ProtoEnumFlags protoEnumFlags, d0.e0.p.d.m0.f.j jVar) {
        CallableMemberDescriptor.a aVar = CallableMemberDescriptor.a.DECLARATION;
        Intrinsics3.checkNotNullParameter(protoEnumFlags, "<this>");
        int i = jVar == null ? -1 : a.a[jVar.ordinal()];
        if (i == 1) {
            return aVar;
        }
        if (i == 2) {
            return CallableMemberDescriptor.a.FAKE_OVERRIDE;
        }
        if (i != 3) {
            return i != 4 ? aVar : CallableMemberDescriptor.a.SYNTHESIZED;
        }
        return CallableMemberDescriptor.a.DELEGATION;
    }
}
