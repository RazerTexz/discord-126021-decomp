package androidx.activity;

import android.content.Intent;
import android.content.IntentSender$SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContract$SynchronousResult;
import androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions;
import androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult;
import androidx.activity.result.contract.ActivityResultContracts$StartIntentSenderForResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ComponentActivity$2 extends ActivityResultRegistry {
    public final /* synthetic */ ComponentActivity this$0;

    public ComponentActivity$2(ComponentActivity componentActivity) {
        this.this$0 = componentActivity;
    }

    @Override // androidx.activity.result.ActivityResultRegistry
    public <I, O> void onLaunch(int i, @NonNull ActivityResultContract<I, O> activityResultContract, I i2, @Nullable ActivityOptionsCompat activityOptionsCompat) {
        ComponentActivity componentActivity = this.this$0;
        ActivityResultContract$SynchronousResult<O> synchronousResult = activityResultContract.getSynchronousResult(componentActivity, i2);
        if (synchronousResult != null) {
            new Handler(Looper.getMainLooper()).post(new ComponentActivity$2$1(this, i, synchronousResult));
            return;
        }
        Intent intentCreateIntent = activityResultContract.createIntent(componentActivity, i2);
        Bundle bundle = null;
        if (intentCreateIntent.hasExtra(ActivityResultContracts$StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE)) {
            bundle = intentCreateIntent.getBundleExtra(ActivityResultContracts$StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
            intentCreateIntent.removeExtra(ActivityResultContracts$StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
        } else if (activityOptionsCompat != null) {
            bundle = activityOptionsCompat.toBundle();
        }
        Bundle bundle2 = bundle;
        if (!ActivityResultContracts$RequestMultiplePermissions.ACTION_REQUEST_PERMISSIONS.equals(intentCreateIntent.getAction())) {
            if (!ActivityResultContracts$StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST.equals(intentCreateIntent.getAction())) {
                ActivityCompat.startActivityForResult(componentActivity, intentCreateIntent, i, bundle2);
                return;
            }
            IntentSenderRequest intentSenderRequest = (IntentSenderRequest) intentCreateIntent.getParcelableExtra(ActivityResultContracts$StartIntentSenderForResult.EXTRA_INTENT_SENDER_REQUEST);
            try {
                ActivityCompat.startIntentSenderForResult(componentActivity, intentSenderRequest.getIntentSender(), i, intentSenderRequest.getFillInIntent(), intentSenderRequest.getFlagsMask(), intentSenderRequest.getFlagsValues(), 0, bundle2);
                return;
            } catch (IntentSender$SendIntentException e) {
                new Handler(Looper.getMainLooper()).post(new ComponentActivity$2$2(this, i, e));
                return;
            }
        }
        String[] stringArrayExtra = intentCreateIntent.getStringArrayExtra(ActivityResultContracts$RequestMultiplePermissions.EXTRA_PERMISSIONS);
        if (stringArrayExtra == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : stringArrayExtra) {
            if (this.this$0.checkPermission(str, Process.myPid(), Process.myUid()) != 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        ActivityCompat.requestPermissions(componentActivity, (String[]) arrayList.toArray(new String[0]), i);
    }
}
