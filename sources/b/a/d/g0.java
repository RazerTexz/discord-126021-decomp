package b.a.d;

import androidx.fragment.app.Fragment;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AppViewModelDelegates.kt */
/* JADX INFO: loaded from: classes.dex */
public final class g0 extends d0.z.d.o implements Function0<Fragment> {
    public final /* synthetic */ Fragment $this_appViewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(Fragment fragment) {
        super(0);
        this.$this_appViewModels = fragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public Fragment invoke() {
        return this.$this_appViewModels;
    }
}
