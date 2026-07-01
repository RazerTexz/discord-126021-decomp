package androidx.activity.result.contract;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(19)
public class ActivityResultContracts$OpenMultipleDocuments extends ActivityResultContract<String[], List<Uri>> {
    @Override // androidx.activity.result.contract.ActivityResultContract
    @NonNull
    @CallSuper
    public /* bridge */ /* synthetic */ Intent createIntent(@NonNull Context context, @NonNull String[] strArr) {
        return createIntent2(context, strArr);
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    @Nullable
    public /* bridge */ /* synthetic */ ActivityResultContract$SynchronousResult<List<Uri>> getSynchronousResult(@NonNull Context context, @NonNull String[] strArr) {
        return getSynchronousResult2(context, strArr);
    }

    @Nullable
    /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
    public final ActivityResultContract$SynchronousResult<List<Uri>> getSynchronousResult2(@NonNull Context context, @NonNull String[] strArr) {
        return null;
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    @NonNull
    public /* bridge */ /* synthetic */ List<Uri> parseResult(int i, @Nullable Intent intent) {
        return parseResult2(i, intent);
    }

    @NonNull
    @CallSuper
    /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
    public Intent createIntent2(@NonNull Context context, @NonNull String[] strArr) {
        return new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", strArr).putExtra("android.intent.extra.ALLOW_MULTIPLE", true).setType("*/*");
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    @NonNull
    /* JADX INFO: renamed from: parseResult, reason: avoid collision after fix types in other method */
    public final List<Uri> parseResult2(int i, @Nullable Intent intent) {
        return (i != -1 || intent == null) ? Collections.emptyList() : ActivityResultContracts$GetMultipleContents.getClipDataUris(intent);
    }
}
