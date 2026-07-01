package d0.e0.p.d.m0.l.b.e0;

import d0.e0.p.d.m0.c.g1.AnnotationDescriptor;
import d0.e0.p.d.m0.m.StorageManager;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.n, reason: use source file name */
/* JADX INFO: compiled from: DeserializedAnnotations.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DeserializedAnnotations2 extends DeserializedAnnotations {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedAnnotations2(StorageManager storageManager, Function0<? extends List<? extends AnnotationDescriptor>> function0) {
        super(storageManager, function0);
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(function0, "compute");
    }

    @Override // d0.e0.p.d.m0.l.b.e0.DeserializedAnnotations, d0.e0.p.d.m0.c.g1.Annotations4
    public boolean isEmpty() {
        return false;
    }
}
