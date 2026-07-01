package androidx.fragment.app;

import androidx.activity.result.ActivityResultRegistry;
import androidx.arch.core.util.Function;

/* JADX INFO: loaded from: classes.dex */
public class Fragment$7 implements Function<Void, ActivityResultRegistry> {
    public final /* synthetic */ Fragment this$0;
    public final /* synthetic */ ActivityResultRegistry val$registry;

    public Fragment$7(Fragment fragment, ActivityResultRegistry activityResultRegistry) {
        this.this$0 = fragment;
        this.val$registry = activityResultRegistry;
    }

    @Override // androidx.arch.core.util.Function
    public /* bridge */ /* synthetic */ ActivityResultRegistry apply(Void r1) {
        return apply2(r1);
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public ActivityResultRegistry apply2(Void r1) {
        return this.val$registry;
    }
}
