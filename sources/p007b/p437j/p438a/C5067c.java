package p007b.p437j.p438a;

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
import com.hcaptcha.sdk.C11152R;
import com.hcaptcha.sdk.HCaptchaConfig;
import com.hcaptcha.sdk.HCaptchaDialogListener;
import com.hcaptcha.sdk.HCaptchaError;
import com.hcaptcha.sdk.HCaptchaException;
import com.hcaptcha.sdk.HCaptchaTokenResponse;
import p007b.p437j.p438a.p439f.InterfaceC5070a;
import p007b.p437j.p438a.p439f.InterfaceC5071b;
import p007b.p437j.p438a.p439f.InterfaceC5072c;

/* JADX INFO: renamed from: b.j.a.c */
/* JADX INFO: loaded from: classes3.dex */
public class C5067c extends DialogFragment implements InterfaceC5071b, InterfaceC5072c<HCaptchaTokenResponse>, InterfaceC5070a {

    /* JADX INFO: renamed from: j */
    public static final String f13582j = C5067c.class.getSimpleName();

    /* JADX INFO: renamed from: k */
    public final Handler f13583k = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: l */
    public C5069e f13584l;

    /* JADX INFO: renamed from: m */
    public boolean f13585m;

    /* JADX INFO: renamed from: n */
    public HCaptchaDialogListener f13586n;

    /* JADX INFO: renamed from: o */
    public View f13587o;

    /* JADX INFO: renamed from: p */
    public WebView f13588p;

    /* JADX INFO: renamed from: q */
    public LinearLayout f13589q;

    /* JADX INFO: renamed from: b.j.a.c$a */
    public class a implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ HCaptchaException f13590j;

        public a(HCaptchaException hCaptchaException) {
            this.f13590j = hCaptchaException;
        }

        @Override // java.lang.Runnable
        public void run() {
            C5067c.this.f13586n.mo9263a(this.f13590j);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(@NonNull DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        onFailure(new HCaptchaException(HCaptchaError.CHALLENGE_CLOSED));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.f13586n = (HCaptchaDialogListener) getArguments().getParcelable("hCaptchaDialogListener");
            HCaptchaConfig hCaptchaConfig = (HCaptchaConfig) getArguments().getSerializable("hCaptchaConfig");
            this.f13584l = new C5069e(hCaptchaConfig, this, this, this);
            this.f13585m = hCaptchaConfig.getLoading().booleanValue();
            setStyle(2, C11152R.c.HCaptchaDialogTheme);
        } catch (BadParcelableException unused) {
            dismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(C11152R.b.hcaptcha_fragment, viewGroup, false);
        this.f13587o = viewInflate;
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(C11152R.a.loadingContainer);
        this.f13589q = linearLayout;
        linearLayout.setVisibility(this.f13585m ? 0 : 8);
        WebView webView = (WebView) this.f13587o.findViewById(C11152R.a.webView);
        this.f13588p = webView;
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        webView.setBackgroundColor(0);
        webView.setLayerType(1, null);
        webView.addJavascriptInterface(this.f13584l, "JSInterface");
        webView.loadUrl("file:///android_asset/hcaptcha-form.html");
        return this.f13587o;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        WebView webView = this.f13588p;
        if (webView != null) {
            webView.removeJavascriptInterface("JSInterface");
            ((ViewGroup) this.f13587o).removeAllViews();
            this.f13588p.destroy();
            this.f13588p = null;
        }
    }

    @Override // p007b.p437j.p438a.p439f.InterfaceC5070a
    public void onFailure(@NonNull HCaptchaException hCaptchaException) {
        if (isAdded()) {
            dismiss();
        }
        this.f13583k.post(new a(hCaptchaException));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            Window window = dialog.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            if (this.f13585m) {
                return;
            }
            window.clearFlags(2);
        }
    }

    @Override // p007b.p437j.p438a.p439f.InterfaceC5072c
    public void onSuccess(HCaptchaTokenResponse hCaptchaTokenResponse) {
        HCaptchaTokenResponse hCaptchaTokenResponse2 = hCaptchaTokenResponse;
        if (isAdded()) {
            dismiss();
        }
        this.f13583k.post(new RunnableC5068d(this, hCaptchaTokenResponse2));
    }
}
