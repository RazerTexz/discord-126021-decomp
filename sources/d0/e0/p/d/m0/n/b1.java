package d0.e0.p.d.m0.n;

import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: TypeSubstitutor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b1 implements Function1<d0.e0.p.d.m0.g.b, Boolean> {
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(d0.e0.p.d.m0.g.b bVar) {
        return invoke2(bVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public Boolean invoke2(d0.e0.p.d.m0.g.b bVar) {
        if (bVar != null) {
            return Boolean.valueOf(!bVar.equals(d0.e0.p.d.m0.b.k$a.G));
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", ModelAuditLogEntry.CHANGE_KEY_NAME, "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor$1", "invoke"));
    }
}
