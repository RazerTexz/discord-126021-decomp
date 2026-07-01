package d0.e0.p.d.m0.n;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.b.StandardNames;
import d0.e0.p.d.m0.g.FqName;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.b1, reason: use source file name */
/* JADX INFO: compiled from: TypeSubstitutor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TypeSubstitutor implements Function1<FqName, Boolean> {
    @Override // kotlin.jvm.functions.Function1
    public Boolean invoke(FqName fqName) {
        if (fqName != null) {
            return Boolean.valueOf(!fqName.equals(StandardNames.a.G));
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", ModelAuditLogEntry.CHANGE_KEY_NAME, "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor$1", "invoke"));
    }
}
