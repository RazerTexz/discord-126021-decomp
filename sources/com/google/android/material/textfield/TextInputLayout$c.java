package com.google.android.material.textfield;

/* JADX INFO: loaded from: classes3.dex */
public class TextInputLayout$c implements Runnable {
    public final /* synthetic */ TextInputLayout j;

    public TextInputLayout$c(TextInputLayout textInputLayout) {
        this.j = textInputLayout;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.j.editText.requestLayout();
    }
}
