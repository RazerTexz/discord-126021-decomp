package d0.e0.p.d;

import com.discord.widgets.chat.input.MentionUtilsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: KPackageImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n$a$d extends d0.z.d.o implements Function0<Class<?>> {
    public final /* synthetic */ n$a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n$a$d(n$a n_a) {
        super(0);
        this.this$0 = n_a;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Class<?> invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Class<?> invoke() {
        d0.e0.p.d.m0.e.b.b0.a classHeader;
        d0.e0.p.d.m0.c.k1.a.f fVarAccess$getKotlinClass$p = n$a.access$getKotlinClass$p(this.this$0);
        String multifileClassName = (fVarAccess$getKotlinClass$p == null || (classHeader = fVarAccess$getKotlinClass$p.getClassHeader()) == null) ? null : classHeader.getMultifileClassName();
        if (multifileClassName == null) {
            return null;
        }
        if (multifileClassName.length() > 0) {
            return this.this$0.i.getJClass().getClassLoader().loadClass(d0.g0.t.replace$default(multifileClassName, MentionUtilsKt.SLASH_CHAR, '.', false, 4, (Object) null));
        }
        return null;
    }
}
