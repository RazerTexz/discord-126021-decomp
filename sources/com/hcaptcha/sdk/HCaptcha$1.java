package com.hcaptcha.sdk;

import b.j.a.a;

/* JADX INFO: loaded from: classes3.dex */
public class HCaptcha$1 extends HCaptchaDialogListener {
    public final /* synthetic */ a j;

    public HCaptcha$1(a aVar) {
        this.j = aVar;
    }

    @Override // com.hcaptcha.sdk.HCaptchaDialogListener
    public void a(HCaptchaException hCaptchaException) {
        a aVar = this.j;
        aVar.f1897b = hCaptchaException;
        aVar.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hcaptcha.sdk.HCaptchaDialogListener
    public void b(HCaptchaTokenResponse hCaptchaTokenResponse) {
        a aVar = this.j;
        aVar.a = hCaptchaTokenResponse;
        aVar.a();
    }
}
