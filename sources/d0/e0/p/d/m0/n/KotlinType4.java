package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.c.g1.AnnotationDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.j.DescriptorRenderer2;
import d0.g0.StringBuilder;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.j0, reason: use source file name */
/* JADX INFO: compiled from: KotlinType.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class KotlinType4 extends KotlinType3 implements d0.e0.p.d.m0.n.n1.i, d0.e0.p.d.m0.n.n1.j {
    public KotlinType4() {
        super(null);
    }

    @Override // d0.e0.p.d.m0.n.KotlinType3
    public abstract KotlinType4 makeNullableAsSpecified(boolean z2);

    @Override // d0.e0.p.d.m0.n.KotlinType3
    public abstract KotlinType4 replaceAnnotations(Annotations4 annotations4);

    public String toString() throws IOException {
        StringBuilder sb = new StringBuilder();
        Iterator<AnnotationDescriptor> it = getAnnotations().iterator();
        while (it.hasNext()) {
            StringBuilder.append(sb, "[", DescriptorRenderer2.renderAnnotation$default(DescriptorRenderer2.c, it.next(), null, 2, null), "] ");
        }
        sb.append(getConstructor());
        if (!getArguments().isEmpty()) {
            _Collections.joinTo(getArguments(), sb, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : "<", (124 & 8) == 0 ? ">" : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null);
        }
        if (isMarkedNullable()) {
            sb.append("?");
        }
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
