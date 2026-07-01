package b.j.a;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import com.hcaptcha.sdk.HCaptchaConfig;
import com.hcaptcha.sdk.HCaptchaDialogListener;
import com.hcaptcha.sdk.HCaptchaError;
import com.hcaptcha.sdk.HCaptchaException;
import com.hcaptcha.sdk.HCaptchaTokenResponse;
import com.hcaptcha.sdk.R$a;
import com.hcaptcha.sdk.R$b;
import com.hcaptcha.sdk.R$c;

/* JADX INFO: loaded from: classes3.dex */
public class c extends DialogFragment implements b.j.a.f.b, b.j.a.f.c<HCaptchaTokenResponse>, b.j.a.f.a {
    public static final String j = c.class.getSimpleName();
    public final Handler k = new Handler(Looper.getMainLooper());
    public e l;
    public boolean m;
    public HCaptchaDialogListener n;
    public View o;
    public WebView p;
    public LinearLayout q;

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface$OnCancelListener
    public void onCancel(@NonNull DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        onFailure(new HCaptchaException(HCaptchaError.CHALLENGE_CLOSED));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.n = (HCaptchaDialogListener) getArguments().getParcelable("hCaptchaDialogListener");
            HCaptchaConfig hCaptchaConfig = (HCaptchaConfig) getArguments().getSerializable("hCaptchaConfig");
            this.l = new e(hCaptchaConfig, this, this, this);
            this.m = hCaptchaConfig.getLoading().booleanValue();
            setStyle(2, R$c.HCaptchaDialogTheme);
        } catch (BadParcelableException unused) {
            dismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R$b.hcaptcha_fragment, viewGroup, false);
        this.o = viewInflate;
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R$a.loadingContainer);
        this.q = linearLayout;
        linearLayout.setVisibility(this.m ? 0 : 8);
        WebView webView = (WebView) this.o.findViewById(R$a.webView);
        this.p = webView;
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        webView.setBackgroundColor(0);
        webView.setLayerType(1, null);
        webView.addJavascriptInterface(this.l, "JSInterface");
        webView.loadUrl("file:///android_asset/hcaptcha-form.html");
        return this.o;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        WebView webView = this.p;
        if (webView != null) {
            webView.removeJavascriptInterface("JSInterface");
            ((ViewGroup) this.o).removeAllViews();
            this.p.destroy();
            this.p = null;
        }
    }

    @Override // b.j.a.f.a
    public void onFailure(@NonNull HCaptchaException hCaptchaException) {
        if (isAdded()) {
            dismiss();
        }
        this.k.post(new c$a(this, hCaptchaException));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            Window window = dialog.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            if (this.m) {
                return;
            }
            window.clearFlags(2);
        }
    }

    @Override // b.j.a.f.c
    public void onSuccess(HCaptchaTokenResponse hCaptchaTokenResponse) {
        HCaptchaTokenResponse hCaptchaTokenResponse2 = hCaptchaTokenResponse;
        if (isAdded()) {
            dismiss();
        }
        this.k.post(new d(this, hCaptchaTokenResponse2));
    }
}
