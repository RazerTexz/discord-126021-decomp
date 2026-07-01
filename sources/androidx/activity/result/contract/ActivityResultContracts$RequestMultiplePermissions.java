package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityResultContracts$RequestMultiplePermissions extends ActivityResultContract<String[], Map<String, Boolean>> {
    public static final String ACTION_REQUEST_PERMISSIONS = "androidx.activity.result.contract.action.REQUEST_PERMISSIONS";
    public static final String EXTRA_PERMISSIONS = "androidx.activity.result.contract.extra.PERMISSIONS";
    public static final String EXTRA_PERMISSION_GRANT_RESULTS = "androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS";

    @Override // androidx.activity.result.contract.ActivityResultContract
    @NonNull
    public /* bridge */ /* synthetic */ Intent createIntent(@NonNull Context context, @NonNull String[] strArr) {
        return createIntent2(context, strArr);
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    @Nullable
    public /* bridge */ /* synthetic */ ActivityResultContract$SynchronousResult<Map<String, Boolean>> getSynchronousResult(@NonNull Context context, @Nullable String[] strArr) {
        return getSynchronousResult2(context, strArr);
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    @NonNull
    public /* bridge */ /* synthetic */ Map<String, Boolean> parseResult(int i, @Nullable Intent intent) {
        return parseResult2(i, intent);
    }

    @NonNull
    /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
    public Intent createIntent2(@NonNull Context context, @NonNull String[] strArr) {
        return createIntent(strArr);
    }

    @Nullable
    /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
    public ActivityResultContract$SynchronousResult<Map<String, Boolean>> getSynchronousResult2(@NonNull Context context, @Nullable String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new ActivityResultContract$SynchronousResult<>(Collections.emptyMap());
        }
        ArrayMap arrayMap = new ArrayMap();
        boolean z2 = true;
        for (String str : strArr) {
            boolean z3 = ContextCompat.checkSelfPermission(context, str) == 0;
            arrayMap.put(str, Boolean.valueOf(z3));
            if (!z3) {
                z2 = false;
            }
        }
        if (z2) {
            return new ActivityResultContract$SynchronousResult<>(arrayMap);
        }
        return null;
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    @NonNull
    /* JADX INFO: renamed from: parseResult, reason: avoid collision after fix types in other method */
    public Map<String, Boolean> parseResult2(int i, @Nullable Intent intent) {
        if (i != -1) {
            return Collections.emptyMap();
        }
        if (intent == null) {
            return Collections.emptyMap();
        }
        String[] stringArrayExtra = intent.getStringArrayExtra(EXTRA_PERMISSIONS);
        int[] intArrayExtra = intent.getIntArrayExtra(EXTRA_PERMISSION_GRANT_RESULTS);
        if (intArrayExtra == null || stringArrayExtra == null) {
            return Collections.emptyMap();
        }
        HashMap map = new HashMap();
        int length = stringArrayExtra.length;
        for (int i2 = 0; i2 < length; i2++) {
            map.put(stringArrayExtra[i2], Boolean.valueOf(intArrayExtra[i2] == 0));
        }
        return map;
    }

    @NonNull
    public static Intent createIntent(@NonNull String[] strArr) {
        return new Intent(ACTION_REQUEST_PERMISSIONS).putExtra(EXTRA_PERMISSIONS, strArr);
    }
}
