package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityResultContracts$RequestPermission extends ActivityResultContract<String, Boolean> {
    @Override // androidx.activity.result.contract.ActivityResultContract
    @NonNull
    public /* bridge */ /* synthetic */ Intent createIntent(@NonNull Context context, @NonNull String str) {
        return createIntent2(context, str);
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    @Nullable
    public /* bridge */ /* synthetic */ ActivityResultContract$SynchronousResult<Boolean> getSynchronousResult(@NonNull Context context, @Nullable String str) {
        return getSynchronousResult2(context, str);
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    @NonNull
    public /* bridge */ /* synthetic */ Boolean parseResult(int i, @Nullable Intent intent) {
        return parseResult(i, intent);
    }

    @NonNull
    /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
    public Intent createIntent2(@NonNull Context context, @NonNull String str) {
        return ActivityResultContracts$RequestMultiplePermissions.createIntent(new String[]{str});
    }

    @Nullable
    /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
    public ActivityResultContract$SynchronousResult<Boolean> getSynchronousResult2(@NonNull Context context, @Nullable String str) {
        if (str == null) {
            return new ActivityResultContract$SynchronousResult<>(Boolean.FALSE);
        }
        if (ContextCompat.checkSelfPermission(context, str) == 0) {
            return new ActivityResultContract$SynchronousResult<>(Boolean.TRUE);
        }
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.activity.result.contract.ActivityResultContract
    @NonNull
    public Boolean parseResult(int i, @Nullable Intent intent) {
        if (intent == null || i != -1) {
            return Boolean.FALSE;
        }
        int[] intArrayExtra = intent.getIntArrayExtra(ActivityResultContracts$RequestMultiplePermissions.EXTRA_PERMISSION_GRANT_RESULTS);
        if (intArrayExtra == null || intArrayExtra.length == 0) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf(intArrayExtra[0] == 0);
    }
}
