package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ActivityResultCaller.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityResultCallerKt {
    public static final <I, O> ActivityResultLauncher<Unit> registerForActivityResult(ActivityResultCaller activityResultCaller, ActivityResultContract<I, O> activityResultContract, I i, ActivityResultRegistry activityResultRegistry, final Function1<? super O, Unit> function1) {
        C12238m.checkNotNullParameter(activityResultCaller, "$this$registerForActivityResult");
        C12238m.checkNotNullParameter(activityResultContract, "contract");
        C12238m.checkNotNullParameter(activityResultRegistry, "registry");
        C12238m.checkNotNullParameter(function1, "callback");
        ActivityResultLauncher<I> activityResultLauncherRegisterForActivityResult = activityResultCaller.registerForActivityResult(activityResultContract, activityResultRegistry, new ActivityResultCallback<O>() { // from class: androidx.activity.result.ActivityResultCallerKt$registerForActivityResult$resultLauncher$1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(O o) {
                function1.invoke(o);
            }
        });
        C12238m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…egistry) { callback(it) }");
        return new ActivityResultCallerLauncher(activityResultLauncherRegisterForActivityResult, activityResultContract, i);
    }

    public static final <I, O> ActivityResultLauncher<Unit> registerForActivityResult(ActivityResultCaller activityResultCaller, ActivityResultContract<I, O> activityResultContract, I i, final Function1<? super O, Unit> function1) {
        C12238m.checkNotNullParameter(activityResultCaller, "$this$registerForActivityResult");
        C12238m.checkNotNullParameter(activityResultContract, "contract");
        C12238m.checkNotNullParameter(function1, "callback");
        ActivityResultLauncher<I> activityResultLauncherRegisterForActivityResult = activityResultCaller.registerForActivityResult(activityResultContract, new ActivityResultCallback<O>() { // from class: androidx.activity.result.ActivityResultCallerKt$registerForActivityResult$resultLauncher$2
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(O o) {
                function1.invoke(o);
            }
        });
        C12238m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…ontract) { callback(it) }");
        return new ActivityResultCallerLauncher(activityResultLauncherRegisterForActivityResult, activityResultContract, i);
    }
}
