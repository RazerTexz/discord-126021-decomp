package d0.e0.p.d.m0.f.z;

import d0.e0.p.d.m0.i.GeneratedMessageLite;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.e, reason: use source file name */
/* JADX INFO: compiled from: ProtoBufUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ProtoBufUtil {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <M extends GeneratedMessageLite.d<M>, T> T getExtensionOrNull(GeneratedMessageLite.d<M> dVar, GeneratedMessageLite.f<M, T> fVar) {
        Intrinsics3.checkNotNullParameter(dVar, "<this>");
        Intrinsics3.checkNotNullParameter(fVar, "extension");
        if (dVar.hasExtension(fVar)) {
            return (T) dVar.getExtension(fVar);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <M extends GeneratedMessageLite.d<M>, T> T getExtensionOrNull(GeneratedMessageLite.d<M> dVar, GeneratedMessageLite.f<M, List<T>> fVar, int i) {
        Intrinsics3.checkNotNullParameter(dVar, "<this>");
        Intrinsics3.checkNotNullParameter(fVar, "extension");
        if (i < dVar.getExtensionCount(fVar)) {
            return (T) dVar.getExtension(fVar, i);
        }
        return null;
    }
}
