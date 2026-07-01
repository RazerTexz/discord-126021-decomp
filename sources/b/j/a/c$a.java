package b.j.a;

import com.hcaptcha.sdk.HCaptchaException;

/* JADX INFO: loaded from: classes3.dex */
public class c$a implements Runnable {
    public final /* synthetic */ HCaptchaException j;
    public final /* synthetic */ c k;

    public c$a(c cVar, HCaptchaException hCaptchaException) {
        this.k = cVar;
        this.j = hCaptchaException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.k.n.a(this.j);
    }
}
