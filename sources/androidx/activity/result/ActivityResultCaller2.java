package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: androidx.activity.result.ActivityResultCallerKt, reason: use source file name */
/* JADX INFO: compiled from: ActivityResultCaller.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityResultCaller2 {
    public static final <I, O> ActivityResultLauncher<Unit> registerForActivityResult(ActivityResultCaller activityResultCaller, ActivityResultContract<I, O> activityResultContract, I i, ActivityResultRegistry activityResultRegistry, final Function1<? super O, Unit> function1) {
        Intrinsics3.checkNotNullParameter(activityResultCaller, "$this$registerForActivityResult");
        Intrinsics3.checkNotNullParameter(activityResultContract, "contract");
        Intrinsics3.checkNotNullParameter(activityResultRegistry, "registry");
        Intrinsics3.checkNotNullParameter(function1, "callback");
        ActivityResultLauncher<I> activityResultLauncherRegisterForActivityResult = activityResultCaller.registerForActivityResult(activityResultContract, activityResultRegistry, new ActivityResultCallback<O>() { // from class: androidx.activity.result.ActivityResultCallerKt$registerForActivityResult$resultLauncher$1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(O o) {
                function1.invoke(o);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…egistry) { callback(it) }");
        return new ActivityResultCaller5(activityResultLauncherRegisterForActivityResult, activityResultContract, i);
    }

    public static final <I, O> ActivityResultLauncher<Unit> registerForActivityResult(ActivityResultCaller activityResultCaller, ActivityResultContract<I, O> activityResultContract, I i, final Function1<? super O, Unit> function1) {
        Intrinsics3.checkNotNullParameter(activityResultCaller, "$this$registerForActivityResult");
        Intrinsics3.checkNotNullParameter(activityResultContract, "contract");
        Intrinsics3.checkNotNullParameter(function1, "callback");
        ActivityResultLauncher<I> activityResultLauncherRegisterForActivityResult = activityResultCaller.registerForActivityResult(activityResultContract, new ActivityResultCallback<O>() { // from class: androidx.activity.result.ActivityResultCallerKt$registerForActivityResult$resultLauncher$2
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(O o) {
                function1.invoke(o);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…ontract) { callback(it) }");
        return new ActivityResultCaller5(activityResultLauncherRegisterForActivityResult, activityResultContract, i);
    }
}
