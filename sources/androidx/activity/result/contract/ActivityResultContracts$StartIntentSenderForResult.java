package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityResultContracts$StartIntentSenderForResult extends ActivityResultContract<IntentSenderRequest, ActivityResult> {
    public static final String ACTION_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.action.INTENT_SENDER_REQUEST";
    public static final String EXTRA_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST";
    public static final String EXTRA_SEND_INTENT_EXCEPTION = "androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION";

    @Override // androidx.activity.result.contract.ActivityResultContract
    @NonNull
    public /* bridge */ /* synthetic */ Intent createIntent(@NonNull Context context, @NonNull IntentSenderRequest intentSenderRequest) {
        return createIntent2(context, intentSenderRequest);
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    @NonNull
    public /* bridge */ /* synthetic */ ActivityResult parseResult(int i, @Nullable Intent intent) {
        return parseResult(i, intent);
    }

    @NonNull
    /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
    public Intent createIntent2(@NonNull Context context, @NonNull IntentSenderRequest intentSenderRequest) {
        return new Intent(ACTION_INTENT_SENDER_REQUEST).putExtra(EXTRA_INTENT_SENDER_REQUEST, intentSenderRequest);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.activity.result.contract.ActivityResultContract
    @NonNull
    public ActivityResult parseResult(int i, @Nullable Intent intent) {
        return new ActivityResult(i, intent);
    }
}
