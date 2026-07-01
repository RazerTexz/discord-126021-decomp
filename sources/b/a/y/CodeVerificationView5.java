package b.a.y;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.a.y.e, reason: use source file name */
/* JADX INFO: compiled from: CodeVerificationView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CodeVerificationView5 extends Lambda implements Function1<String, Unit> {
    public static final CodeVerificationView5 j = new CodeVerificationView5();

    public CodeVerificationView5() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(String str) {
        Intrinsics3.checkNotNullParameter(str, "it");
        return Unit.a;
    }
}
