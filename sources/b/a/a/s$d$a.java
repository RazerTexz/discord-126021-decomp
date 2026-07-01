package b.a.a;

import com.discord.api.auth.mfa.EnableMfaResponse;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class s$d$a extends d0.z.d.o implements Function1<EnableMfaResponse, Unit> {
    public static final s$d$a j = new s$d$a();

    public s$d$a() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(EnableMfaResponse enableMfaResponse) {
        d0.z.d.m.checkNotNullParameter(enableMfaResponse, "it");
        return Unit.a;
    }
}
