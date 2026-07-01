package com.discord.samsung;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import b.a.r.SamsungConnectActivity3;
import b.d.b.a.outline;
import b.n.a.a.ISACallback;
import b.n.a.a.ISAService;
import com.discord.BuildConfig;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SamsungConnectActivity.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SamsungConnectActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public ISACallback samsungAccountServiceCallback;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public boolean serviceBound;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final a serviceConnection = new a();

    /* JADX INFO: compiled from: SamsungConnectActivity.kt */
    public static abstract class Result {

        /* JADX INFO: compiled from: SamsungConnectActivity.kt */
        public static final /* data */ class Failure extends Result {

            /* JADX INFO: renamed from: a, reason: from kotlin metadata */
            public final boolean isRetryAllowed;

            /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
            public final int attemptCount;

            public Failure(boolean z2, int i) {
                super(null);
                this.isRetryAllowed = z2;
                this.attemptCount = i;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Failure)) {
                    return false;
                }
                Failure failure = (Failure) other;
                return this.isRetryAllowed == failure.isRetryAllowed && this.attemptCount == failure.attemptCount;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v4 */
            /* JADX WARN: Type inference failed for: r0v5 */
            public int hashCode() {
                boolean z2 = this.isRetryAllowed;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                return (r0 * 31) + this.attemptCount;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Failure(isRetryAllowed=");
                sbU.append(this.isRetryAllowed);
                sbU.append(", attemptCount=");
                return outline.B(sbU, this.attemptCount, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Failure(boolean z2, int i, int i2) {
                super(null);
                i = (i2 & 2) != 0 ? 0 : i;
                this.isRetryAllowed = z2;
                this.attemptCount = i;
            }
        }

        /* JADX INFO: compiled from: SamsungConnectActivity.kt */
        public static final /* data */ class Success extends Result {

            /* JADX INFO: renamed from: a, reason: from kotlin metadata */
            public final String authCode;

            /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
            public final String serverUrl;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Success(String str, String str2) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "authCode");
                Intrinsics3.checkNotNullParameter(str2, "serverUrl");
                this.authCode = str;
                this.serverUrl = str2;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Success)) {
                    return false;
                }
                Success success = (Success) other;
                return Intrinsics3.areEqual(this.authCode, success.authCode) && Intrinsics3.areEqual(this.serverUrl, success.serverUrl);
            }

            public int hashCode() {
                String str = this.authCode;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.serverUrl;
                return iHashCode + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Success(authCode=");
                sbU.append(this.authCode);
                sbU.append(", serverUrl=");
                return outline.J(sbU, this.serverUrl, ")");
            }
        }

        public Result() {
        }

        public Result(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: compiled from: SamsungConnectActivity.kt */
    public static final class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ISAService c0058a;
            SamsungConnectActivity.this.serviceBound = true;
            int i = ISAService.a.a;
            if (iBinder == null) {
                c0058a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.msc.sa.aidl.ISAService");
                c0058a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ISAService)) ? new ISAService.a.C0058a(iBinder) : (ISAService) iInterfaceQueryLocalInterface;
            }
            Log.i("Discord", "Samsung Account service connection established");
            try {
                ISACallback iSACallback = SamsungConnectActivity.this.samsungAccountServiceCallback;
                if (iSACallback == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("samsungAccountServiceCallback");
                }
                String strQ = c0058a.Q("97t47j218f", "dummy", BuildConfig.APPLICATION_ID, iSACallback);
                Log.i("Discord", "Samsung Account service connection established: " + strQ);
                if (strQ == null) {
                    SamsungConnectActivity samsungConnectActivity = SamsungConnectActivity.this;
                    samsungConnectActivity.setResult(500, new Intent().putExtra("com.discord.samsung.intent.extra.ATTEMPT_COUNT", samsungConnectActivity.getIntent().getIntExtra("com.discord.samsung.intent.extra.ATTEMPT_COUNT", 0) + 1));
                    samsungConnectActivity.finish();
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putStringArray("additional", new String[]{"api_server_url", "auth_server_url"});
                boolean zH0 = c0058a.h0(1221, strQ, bundle);
                Log.i("Discord", "Samsung Account service connection established: isReqSucc? " + zH0);
                if (!zH0) {
                    throw new Exception("Call Samsung.requestAuthCode failed");
                }
            } catch (Throwable th) {
                Log.e("Discord", "Unable to connect to Samsung", th);
                SamsungConnectActivity.a(SamsungConnectActivity.this, null, null);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.i("Discord", "Samsung Account service connection unbound");
            SamsungConnectActivity samsungConnectActivity = SamsungConnectActivity.this;
            samsungConnectActivity.serviceBound = false;
            samsungConnectActivity.finish();
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0034  */
    public static final void a(SamsungConnectActivity samsungConnectActivity, String str, String str2) {
        Objects.requireNonNull(samsungConnectActivity);
        boolean z2 = true;
        if (str == null || StringsJVM.isBlank(str)) {
            samsungConnectActivity.setResult(0);
        } else {
            if (str2 != null && !StringsJVM.isBlank(str2)) {
                z2 = false;
            }
            if (z2) {
                samsungConnectActivity.setResult(0);
            } else {
                Intent intent = new Intent();
                intent.putExtra("com.discord.samsung.intent.extra.AUTH_CODE", str);
                intent.putExtra("com.discord.samsung.intent.extra.SERVER_URL", str2);
                samsungConnectActivity.setResult(-1, intent);
            }
        }
        samsungConnectActivity.finish();
    }

    public static final void b(Context context, ActivityResultLauncher<Intent> activityResultLauncher, int i) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(activityResultLauncher, "launcher");
        Intent intentAddFlags = new Intent(context, (Class<?>) SamsungConnectActivity.class).putExtra("com.discord.samsung.intent.extra.ATTEMPT_COUNT", i).addFlags(65536);
        Intrinsics3.checkNotNullExpressionValue(intentAddFlags, "Intent(context, SamsungC…AG_ACTIVITY_NO_ANIMATION)");
        activityResultLauncher.launch(intentAddFlags);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.samsungAccountServiceCallback = new SamsungConnectActivity3(this);
        Intent intent = new Intent("com.msc.action.samsungaccount.REQUEST_SERVICE").setPackage("com.osp.app.signin");
        Intrinsics3.checkNotNullExpressionValue(intent, "Intent(SA_ACCOUNT_ACTION…ckage(SA_ACCOUNT_SERVICE)");
        Log.i("Discord", "Samsung starting SA Service");
        if (startService(intent) == null) {
            Log.e("Discord", "Samsung Account service could not be started");
        } else {
            if (bindService(intent, this.serviceConnection, 1)) {
                return;
            }
            Log.e("Discord", "Samsung Account service could not be bound");
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        if (this.serviceBound) {
            unbindService(this.serviceConnection);
            this.serviceBound = false;
        }
        super.onStop();
    }
}
