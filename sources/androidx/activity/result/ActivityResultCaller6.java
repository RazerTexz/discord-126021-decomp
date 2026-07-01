package androidx.activity.result;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: androidx.activity.result.ActivityResultCallerLauncher$resultContract$2, reason: use source file name */
/* JADX INFO: compiled from: ActivityResultCaller.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityResultCaller6 extends Lambda implements Function0<AnonymousClass1> {
    public final /* synthetic */ ActivityResultCaller5 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityResultCaller6(ActivityResultCaller5 activityResultCaller5) {
        super(0);
        this.this$0 = activityResultCaller5;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.activity.result.ActivityResultCallerLauncher$resultContract$2$1] */
    @Override // kotlin.jvm.functions.Function0
    public final AnonymousClass1 invoke() {
        return new ActivityResultContract<Unit, O>() { // from class: androidx.activity.result.ActivityResultCallerLauncher$resultContract$2.1
            @Override // androidx.activity.result.contract.ActivityResultContract
            public O parseResult(int resultCode, Intent intent) {
                return (O) ActivityResultCaller6.this.this$0.getCallerContract().parseResult(resultCode, intent);
            }

            @Override // androidx.activity.result.contract.ActivityResultContract
            public Intent createIntent(Context context, Unit unit) {
                Intrinsics3.checkNotNullParameter(context, "context");
                Intent intentCreateIntent = ActivityResultCaller6.this.this$0.getCallerContract().createIntent(context, ActivityResultCaller6.this.this$0.getInput());
                Intrinsics3.checkNotNullExpressionValue(intentCreateIntent, "callerContract.createIntent(context, input)");
                return intentCreateIntent;
            }
        };
    }
}
