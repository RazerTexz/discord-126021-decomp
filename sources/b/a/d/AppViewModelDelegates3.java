package b.a.d;

import androidx.fragment.app.Fragment;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: b.a.d.g0, reason: use source file name */
/* JADX INFO: compiled from: AppViewModelDelegates.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppViewModelDelegates3 extends Lambda implements Function0<Fragment> {
    public final /* synthetic */ Fragment $this_appViewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppViewModelDelegates3(Fragment fragment) {
        super(0);
        this.$this_appViewModels = fragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public Fragment invoke() {
        return this.$this_appViewModels;
    }
}
