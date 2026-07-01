package com.hcaptcha.sdk;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class HCaptchaDialogListener implements Parcelable {
    public abstract void a(HCaptchaException hCaptchaException);

    public abstract void b(HCaptchaTokenResponse hCaptchaTokenResponse);

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
    }
}
