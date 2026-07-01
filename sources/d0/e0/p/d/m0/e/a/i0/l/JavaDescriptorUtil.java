package d0.e0.p.d.m0.e.a.i0.l;

import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.c, reason: use source file name */
/* JADX INFO: compiled from: JavaDescriptorUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JavaDescriptorUtil {
    public static final boolean isJavaField(PropertyDescriptor propertyDescriptor) {
        Intrinsics3.checkNotNullParameter(propertyDescriptor, "<this>");
        return propertyDescriptor.getGetter() == null;
    }
}
