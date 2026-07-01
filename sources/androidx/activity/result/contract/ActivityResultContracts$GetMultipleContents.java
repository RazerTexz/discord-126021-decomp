package androidx.activity.result.contract;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(18)
public class ActivityResultContracts$GetMultipleContents extends ActivityResultContract<String, List<Uri>> {
    @NonNull
    public static List<Uri> getClipDataUris(@NonNull Intent intent) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (intent.getData() != null) {
            linkedHashSet.add(intent.getData());
        }
        ClipData clipData = intent.getClipData();
        if (clipData == null && linkedHashSet.isEmpty()) {
            return Collections.emptyList();
        }
        if (clipData != null) {
            for (int i = 0; i < clipData.getItemCount(); i++) {
                Uri uri = clipData.getItemAt(i).getUri();
                if (uri != null) {
                    linkedHashSet.add(uri);
                }
            }
        }
        return new ArrayList(linkedHashSet);
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    @NonNull
    @CallSuper
    public /* bridge */ /* synthetic */ Intent createIntent(@NonNull Context context, @NonNull String str) {
        return createIntent2(context, str);
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    @Nullable
    public /* bridge */ /* synthetic */ ActivityResultContract$SynchronousResult<List<Uri>> getSynchronousResult(@NonNull Context context, @NonNull String str) {
        return getSynchronousResult2(context, str);
    }

    @Nullable
    /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
    public final ActivityResultContract$SynchronousResult<List<Uri>> getSynchronousResult2(@NonNull Context context, @NonNull String str) {
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
    public Intent createIntent2(@NonNull Context context, @NonNull String str) {
        return new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(str).putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    @NonNull
    /* JADX INFO: renamed from: parseResult, reason: avoid collision after fix types in other method */
    public final List<Uri> parseResult2(int i, @Nullable Intent intent) {
        return (intent == null || i != -1) ? Collections.emptyList() : getClipDataUris(intent);
    }
}
