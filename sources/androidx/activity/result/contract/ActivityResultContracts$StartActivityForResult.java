package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityResultContracts$StartActivityForResult extends ActivityResultContract<Intent, ActivityResult> {
    public static final String EXTRA_ACTIVITY_OPTIONS_BUNDLE = "androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE";

    @NonNull
    /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
    public Intent createIntent2(@NonNull Context context, @NonNull Intent intent) {
        return intent;
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    @NonNull
    public /* bridge */ /* synthetic */ Intent createIntent(@NonNull Context context, @NonNull Intent intent) {
        return createIntent2(context, intent);
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    @NonNull
    public /* bridge */ /* synthetic */ ActivityResult parseResult(int i, @Nullable Intent intent) {
        return parseResult(i, intent);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.activity.result.contract.ActivityResultContract
    @NonNull
    public ActivityResult parseResult(int i, @Nullable Intent intent) {
        return new ActivityResult(i, intent);
    }
}
