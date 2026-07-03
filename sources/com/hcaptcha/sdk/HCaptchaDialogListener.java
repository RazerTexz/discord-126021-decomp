package com.hcaptcha.sdk;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class HCaptchaDialogListener implements Parcelable {
    /* JADX INFO: renamed from: a */
    public abstract void mo9263a(HCaptchaException hCaptchaException);

    /* JADX INFO: renamed from: b */
    public abstract void mo9264b(HCaptchaTokenResponse hCaptchaTokenResponse);

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
    }
}
