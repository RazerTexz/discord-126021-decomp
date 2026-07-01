package b.a.a.b;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PremiumActivatedDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f$a {
    public f$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final void a(FragmentManager fragmentManager, Function0<Unit> function0, boolean z2) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(function0, "onDismiss");
        f fVar = new f();
        fVar.onDismiss = function0;
        Bundle bundle = new Bundle();
        bundle.putBoolean("ARG_IS_TIER_1", z2);
        fVar.setArguments(bundle);
        fVar.show(fragmentManager, f.class.getSimpleName());
    }
}
