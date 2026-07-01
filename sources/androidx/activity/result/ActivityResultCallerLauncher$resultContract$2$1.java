package androidx.activity.result;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import d0.z.d.m;
import kotlin.Unit;

/* JADX INFO: Add missing generic type declarations: [O] */
/* JADX INFO: compiled from: ActivityResultCaller.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityResultCallerLauncher$resultContract$2$1<O> extends ActivityResultContract<Unit, O> {
    public final /* synthetic */ ActivityResultCallerLauncher$resultContract$2 this$0;

    public ActivityResultCallerLauncher$resultContract$2$1(ActivityResultCallerLauncher$resultContract$2 activityResultCallerLauncher$resultContract$2) {
        this.this$0 = activityResultCallerLauncher$resultContract$2;
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    public /* bridge */ /* synthetic */ Intent createIntent(Context context, Unit unit) {
        return createIntent2(context, unit);
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    public O parseResult(int resultCode, Intent intent) {
        return (O) this.this$0.this$0.getCallerContract().parseResult(resultCode, intent);
    }

    /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
    public Intent createIntent2(Context context, Unit unit) {
        m.checkNotNullParameter(context, "context");
        Intent intentCreateIntent = this.this$0.this$0.getCallerContract().createIntent(context, this.this$0.this$0.getInput());
        m.checkNotNullExpressionValue(intentCreateIntent, "callerContract.createIntent(context, input)");
        return intentCreateIntent;
    }
}
