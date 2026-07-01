package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class ActivityResultContracts$TakePicturePreview extends ActivityResultContract<Void, Bitmap> {
    @Override // androidx.activity.result.contract.ActivityResultContract
    @NonNull
    @CallSuper
    public /* bridge */ /* synthetic */ Intent createIntent(@NonNull Context context, @Nullable Void r2) {
        return createIntent2(context, r2);
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    @Nullable
    public /* bridge */ /* synthetic */ ActivityResultContract$SynchronousResult<Bitmap> getSynchronousResult(@NonNull Context context, @Nullable Void r2) {
        return getSynchronousResult2(context, r2);
    }

    @Nullable
    /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
    public final ActivityResultContract$SynchronousResult<Bitmap> getSynchronousResult2(@NonNull Context context, @Nullable Void r2) {
        return null;
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    @Nullable
    public /* bridge */ /* synthetic */ Bitmap parseResult(int i, @Nullable Intent intent) {
        return parseResult(i, intent);
    }

    @NonNull
    @CallSuper
    /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
    public Intent createIntent2(@NonNull Context context, @Nullable Void r2) {
        return new Intent("android.media.action.IMAGE_CAPTURE");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.activity.result.contract.ActivityResultContract
    @Nullable
    public final Bitmap parseResult(int i, @Nullable Intent intent) {
        if (intent == null || i != -1) {
            return null;
        }
        return (Bitmap) intent.getParcelableExtra("data");
    }
}
