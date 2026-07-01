package b.a.r;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.discord.samsung.SamsungConnectActivity;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.a.r.c, reason: use source file name */
/* JADX INFO: compiled from: SamsungConnectActivity.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SamsungConnectActivity2<O> implements ActivityResultCallback<ActivityResult> {
    public final /* synthetic */ Function1 a;

    public SamsungConnectActivity2(Function1 function1) {
        this.a = function1;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(ActivityResult activityResult) {
        ActivityResult activityResult2 = activityResult;
        Intrinsics3.checkNotNullExpressionValue(activityResult2, "activityResult");
        if (activityResult2.getResultCode() == 500) {
            Function1 function1 = this.a;
            Intent data = activityResult2.getData();
            function1.invoke(new SamsungConnectActivity.Result.Failure(true, data != null ? data.getIntExtra("com.discord.samsung.intent.extra.ATTEMPT_COUNT", 0) : 0));
            return;
        }
        Intent data2 = activityResult2.getData();
        if (data2 == null) {
            this.a.invoke(new SamsungConnectActivity.Result.Failure(false, 0, 2));
            return;
        }
        Function1 function2 = this.a;
        String stringExtra = data2.getStringExtra("com.discord.samsung.intent.extra.AUTH_CODE");
        if (stringExtra == null) {
            stringExtra = "";
        }
        String stringExtra2 = data2.getStringExtra("com.discord.samsung.intent.extra.SERVER_URL");
        function2.invoke(new SamsungConnectActivity.Result.Success(stringExtra, stringExtra2 != null ? stringExtra2 : ""));
    }
}
