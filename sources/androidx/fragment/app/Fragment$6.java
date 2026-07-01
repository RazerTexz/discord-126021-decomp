package androidx.fragment.app;

import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.arch.core.util.Function;

/* JADX INFO: loaded from: classes.dex */
public class Fragment$6 implements Function<Void, ActivityResultRegistry> {
    public final /* synthetic */ Fragment this$0;

    public Fragment$6(Fragment fragment) {
        this.this$0 = fragment;
    }

    @Override // androidx.arch.core.util.Function
    public /* bridge */ /* synthetic */ ActivityResultRegistry apply(Void r1) {
        return apply2(r1);
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public ActivityResultRegistry apply2(Void r3) {
        Fragment fragment = this.this$0;
        Object obj = fragment.mHost;
        return obj instanceof ActivityResultRegistryOwner ? ((ActivityResultRegistryOwner) obj).getActivityResultRegistry() : fragment.requireActivity().getActivityResultRegistry();
    }
}
