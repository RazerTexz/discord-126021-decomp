package d0.e0.p.d.m0.l.b.e0;

import d0.e0.p.d.m0.c.g1.AnnotationDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.m.storage5;
import d0.e0.p.d.m0.m.storage7;
import d0.z.d.Intrinsics3;
import d0.z.d.PropertyReference1Impl;
import d0.z.d.Reflection2;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.a, reason: use source file name */
/* JADX INFO: compiled from: DeserializedAnnotations.kt */
/* JADX INFO: loaded from: classes3.dex */
public class DeserializedAnnotations implements Annotations4 {
    public static final /* synthetic */ KProperty<Object>[] j = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DeserializedAnnotations.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    public final storage5 k;

    public DeserializedAnnotations(StorageManager storageManager, Function0<? extends List<? extends AnnotationDescriptor>> function0) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(function0, "compute");
        this.k = storageManager.createLazyValue(function0);
    }

    @Override // d0.e0.p.d.m0.c.g1.Annotations4
    public AnnotationDescriptor findAnnotation(FqName fqName) {
        return Annotations4.b.findAnnotation(this, fqName);
    }

    @Override // d0.e0.p.d.m0.c.g1.Annotations4
    public boolean hasAnnotation(FqName fqName) {
        return Annotations4.b.hasAnnotation(this, fqName);
    }

    @Override // d0.e0.p.d.m0.c.g1.Annotations4
    public boolean isEmpty() {
        return ((List) storage7.getValue(this.k, this, (KProperty<?>) j[0])).isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<AnnotationDescriptor> iterator() {
        return ((List) storage7.getValue(this.k, this, (KProperty<?>) j[0])).iterator();
    }
}
