package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11291k;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.b1 */
/* JADX INFO: compiled from: TypeSubstitutor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11911b1 implements Function1<C11713b, Boolean> {
    @Override // kotlin.jvm.functions.Function1
    public Boolean invoke(C11713b c11713b) {
        if (c11713b != null) {
            return Boolean.valueOf(!c11713b.equals(C11291k.a.f22510G));
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", ModelAuditLogEntry.CHANGE_KEY_NAME, "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor$1", "invoke"));
    }
}
