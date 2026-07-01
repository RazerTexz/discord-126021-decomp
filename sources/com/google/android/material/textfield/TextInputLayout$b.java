package com.google.android.material.textfield;

/* JADX INFO: loaded from: classes3.dex */
public class TextInputLayout$b implements Runnable {
    public final /* synthetic */ TextInputLayout j;

    public TextInputLayout$b(TextInputLayout textInputLayout) {
        this.j = textInputLayout;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextInputLayout.access$300(this.j).performClick();
        TextInputLayout.access$300(this.j).jumpDrawablesToCurrentState();
    }
}
