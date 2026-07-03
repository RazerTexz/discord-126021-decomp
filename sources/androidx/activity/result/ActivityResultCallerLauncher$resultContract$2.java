package androidx.activity.result;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ActivityResultCaller.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityResultCallerLauncher$resultContract$2 extends AbstractC12240o implements Function0<C00451> {
    public final /* synthetic */ ActivityResultCallerLauncher this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityResultCallerLauncher$resultContract$2(ActivityResultCallerLauncher activityResultCallerLauncher) {
        super(0);
        this.this$0 = activityResultCallerLauncher;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.activity.result.ActivityResultCallerLauncher$resultContract$2$1] */
    @Override // kotlin.jvm.functions.Function0
    public final C00451 invoke() {
        return new ActivityResultContract<Unit, O>() { // from class: androidx.activity.result.ActivityResultCallerLauncher$resultContract$2.1
            @Override // androidx.activity.result.contract.ActivityResultContract
            public O parseResult(int resultCode, Intent intent) {
                return (O) ActivityResultCallerLauncher$resultContract$2.this.this$0.getCallerContract().parseResult(resultCode, intent);
            }

            @Override // androidx.activity.result.contract.ActivityResultContract
            public Intent createIntent(Context context, Unit unit) {
                C12238m.checkNotNullParameter(context, "context");
                Intent intentCreateIntent = ActivityResultCallerLauncher$resultContract$2.this.this$0.getCallerContract().createIntent(context, ActivityResultCallerLauncher$resultContract$2.this.this$0.getInput());
                C12238m.checkNotNullExpressionValue(intentCreateIntent, "callerContract.createIntent(context, input)");
                return intentCreateIntent;
            }
        };
    }
}
