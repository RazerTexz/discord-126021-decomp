package b.j.a;

import com.hcaptcha.sdk.HCaptchaTokenResponse;

/* JADX INFO: loaded from: classes3.dex */
public class d implements Runnable {
    public final /* synthetic */ HCaptchaTokenResponse j;
    public final /* synthetic */ c k;

    public d(c cVar, HCaptchaTokenResponse hCaptchaTokenResponse) {
        this.k = cVar;
        this.j = hCaptchaTokenResponse;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.k.n.b(this.j);
    }
}
