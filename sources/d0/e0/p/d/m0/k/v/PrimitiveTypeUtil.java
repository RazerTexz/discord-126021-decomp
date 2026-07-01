package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.Collection;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.u, reason: use source file name */
/* JADX INFO: compiled from: PrimitiveTypeUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PrimitiveTypeUtil {
    public static final Collection<KotlinType> getAllSignedLiteralTypes(ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "<this>");
        return Collections2.listOf((Object[]) new KotlinType4[]{moduleDescriptor2.getBuiltIns().getIntType(), moduleDescriptor2.getBuiltIns().getLongType(), moduleDescriptor2.getBuiltIns().getByteType(), moduleDescriptor2.getBuiltIns().getShortType()});
    }
}
