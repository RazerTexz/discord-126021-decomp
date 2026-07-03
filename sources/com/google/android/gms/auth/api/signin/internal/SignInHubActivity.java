package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import java.util.Objects;
import java.util.Set;
import p007b.p225i.p226a.p288f.p292c.p293a.p296f.p297b.C3201d;
import p007b.p225i.p226a.p288f.p292c.p293a.p296f.p297b.C3210m;
import p007b.p225i.p226a.p288f.p292c.p293a.p296f.p297b.C3217t;
import p007b.p225i.p226a.p288f.p299e.p300h.AbstractC3268c;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@KeepName
public class SignInHubActivity extends FragmentActivity {

    /* JADX INFO: renamed from: j */
    public static boolean f20463j = false;

    /* JADX INFO: renamed from: k */
    public boolean f20464k = false;

    /* JADX INFO: renamed from: l */
    public SignInConfiguration f20465l;

    /* JADX INFO: renamed from: m */
    public boolean f20466m;

    /* JADX INFO: renamed from: n */
    public int f20467n;

    /* JADX INFO: renamed from: o */
    public Intent f20468o;

    /* JADX INFO: renamed from: com.google.android.gms.auth.api.signin.internal.SignInHubActivity$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
    public class C10795a implements LoaderManager.LoaderCallbacks<Void> {
        public C10795a(C3217t c3217t) {
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public final Loader<Void> onCreateLoader(int i, Bundle bundle) {
            SignInHubActivity signInHubActivity = SignInHubActivity.this;
            Set<AbstractC3268c> set = AbstractC3268c.f9338a;
            synchronized (set) {
            }
            return new C3201d(signInHubActivity, set);
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public final /* synthetic */ void onLoadFinished(Loader<Void> loader, Void r3) {
            SignInHubActivity signInHubActivity = SignInHubActivity.this;
            signInHubActivity.setResult(signInHubActivity.f20467n, signInHubActivity.f20468o);
            SignInHubActivity.this.finish();
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public final void onLoaderReset(Loader<Void> loader) {
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m9016a(int i) {
        Status status = new Status(i, null);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
        f20463j = false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        GoogleSignInAccount googleSignInAccount;
        if (this.f20464k) {
            return;
        }
        setResult(0);
        if (i != 40962) {
            return;
        }
        if (intent != null) {
            SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
            if (signInAccount != null && (googleSignInAccount = signInAccount.f20456k) != null) {
                C3210m c3210mM3990b = C3210m.m3990b(this);
                GoogleSignInOptions googleSignInOptions = this.f20465l.f20462k;
                synchronized (c3210mM3990b) {
                    c3210mM3990b.f9239b.m3977d(googleSignInAccount, googleSignInOptions);
                }
                intent.removeExtra("signInAccount");
                intent.putExtra("googleSignInAccount", googleSignInAccount);
                this.f20466m = true;
                this.f20467n = i2;
                this.f20468o = intent;
                getSupportLoaderManager().initLoader(0, null, new C10795a(null));
                f20463j = false;
                return;
            }
            if (intent.hasExtra("errorCode")) {
                int intExtra = intent.getIntExtra("errorCode", 8);
                if (intExtra == 13) {
                    intExtra = 12501;
                }
                m9016a(intExtra);
                return;
            }
        }
        m9016a(8);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String action = intent.getAction();
        Objects.requireNonNull(action);
        if ("com.google.android.gms.auth.NO_IMPL".equals(action)) {
            m9016a(12500);
            return;
        }
        if (!action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") && !action.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            String strValueOf = String.valueOf(intent.getAction());
            Log.e("AuthSignInClient", strValueOf.length() != 0 ? "Unknown action: ".concat(strValueOf) : new String("Unknown action: "));
            finish();
            return;
        }
        Bundle bundleExtra = intent.getBundleExtra("config");
        Objects.requireNonNull(bundleExtra);
        SignInConfiguration signInConfiguration = (SignInConfiguration) bundleExtra.getParcelable("config");
        if (signInConfiguration == null) {
            Log.e("AuthSignInClient", "Activity started with invalid configuration.");
            setResult(0);
            finish();
            return;
        }
        this.f20465l = signInConfiguration;
        if (bundle != null) {
            boolean z2 = bundle.getBoolean("signingInGoogleApiClients");
            this.f20466m = z2;
            if (z2) {
                this.f20467n = bundle.getInt("signInResultCode");
                Intent intent2 = (Intent) bundle.getParcelable("signInResultData");
                Objects.requireNonNull(intent2);
                this.f20468o = intent2;
                getSupportLoaderManager().initLoader(0, null, new C10795a(null));
                f20463j = false;
                return;
            }
            return;
        }
        if (f20463j) {
            setResult(0);
            m9016a(12502);
            return;
        }
        f20463j = true;
        Intent intent3 = new Intent(action);
        if (action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
            intent3.setPackage("com.google.android.gms");
        } else {
            intent3.setPackage(getPackageName());
        }
        intent3.putExtra("config", this.f20465l);
        try {
            startActivityForResult(intent3, 40962);
        } catch (ActivityNotFoundException unused) {
            this.f20464k = true;
            Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
            m9016a(17);
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.f20466m);
        if (this.f20466m) {
            bundle.putInt("signInResultCode", this.f20467n);
            bundle.putParcelable("signInResultData", this.f20468o);
        }
    }
}
