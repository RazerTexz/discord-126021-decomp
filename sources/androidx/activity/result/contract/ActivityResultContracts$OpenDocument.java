package androidx.activity.result.contract;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(19)
public class ActivityResultContracts$OpenDocument extends ActivityResultContract<String[], Uri> {
    @Override // androidx.activity.result.contract.ActivityResultContract
    @NonNull
    @CallSuper
    public /* bridge */ /* synthetic */ Intent createIntent(@NonNull Context context, @NonNull String[] strArr) {
        return createIntent2(context, strArr);
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    @Nullable
    public /* bridge */ /* synthetic */ ActivityResultContract$SynchronousResult<Uri> getSynchronousResult(@NonNull Context context, @NonNull String[] strArr) {
        return getSynchronousResult2(context, strArr);
    }

    @Nullable
    /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
    public final ActivityResultContract$SynchronousResult<Uri> getSynchronousResult2(@NonNull Context context, @NonNull String[] strArr) {
        return null;
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    @Nullable
    public /* bridge */ /* synthetic */ Uri parseResult(int i, @Nullable Intent intent) {
        return parseResult(i, intent);
    }

    @NonNull
    @CallSuper
    /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
    public Intent createIntent2(@NonNull Context context, @NonNull String[] strArr) {
        return new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", strArr).setType("*/*");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.activity.result.contract.ActivityResultContract
    @Nullable
    public final Uri parseResult(int i, @Nullable Intent intent) {
        if (intent == null || i != -1) {
            return null;
        }
        return intent.getData();
    }
}
