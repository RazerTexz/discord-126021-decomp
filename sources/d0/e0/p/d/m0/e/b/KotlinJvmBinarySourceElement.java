package d0.e0.p.d.m0.e.b;

import b.d.b.a.outline;
import d0.e0.p.d.m0.c.v0;
import d0.e0.p.d.m0.f.a0.b.JvmMetadataVersion;
import d0.e0.p.d.m0.l.b.IncompatibleVersionErrorData;
import d0.e0.p.d.m0.l.b.e0.DeserializedContainerSource;
import d0.e0.p.d.m0.l.b.e0.DeserializedContainerSource2;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.r, reason: use source file name */
/* JADX INFO: compiled from: KotlinJvmBinarySourceElement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KotlinJvmBinarySourceElement implements DeserializedContainerSource2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KotlinJvmBinaryClass f3381b;

    public KotlinJvmBinarySourceElement(KotlinJvmBinaryClass kotlinJvmBinaryClass, IncompatibleVersionErrorData<JvmMetadataVersion> incompatibleVersionErrorData, boolean z2, DeserializedContainerSource deserializedContainerSource) {
        Intrinsics3.checkNotNullParameter(kotlinJvmBinaryClass, "binaryClass");
        Intrinsics3.checkNotNullParameter(deserializedContainerSource, "abiStability");
        this.f3381b = kotlinJvmBinaryClass;
    }

    public final KotlinJvmBinaryClass getBinaryClass() {
        return this.f3381b;
    }

    @Override // d0.e0.p.d.m0.c.SourceElement
    public v0 getContainingFile() {
        v0 v0Var = v0.a;
        Intrinsics3.checkNotNullExpressionValue(v0Var, "NO_SOURCE_FILE");
        return v0Var;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.DeserializedContainerSource2
    public String getPresentableString() {
        StringBuilder sbU = outline.U("Class '");
        sbU.append(this.f3381b.getClassId().asSingleFqName().asString());
        sbU.append('\'');
        return sbU.toString();
    }

    public String toString() {
        return ((Object) KotlinJvmBinarySourceElement.class.getSimpleName()) + ": " + this.f3381b;
    }
}
