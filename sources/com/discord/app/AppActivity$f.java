package com.discord.app;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: AppActivity.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppActivity$f implements Runnable {
    public final /* synthetic */ View j;
    public final /* synthetic */ InputMethodManager k;

    public AppActivity$f(View view, InputMethodManager inputMethodManager) {
        this.j = view;
        this.k = inputMethodManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            View editText = this.j;
            if ((editText instanceof TextInputLayout) && (editText = ((TextInputLayout) editText).getEditText()) == null) {
                editText = this.j;
            }
            editText.requestFocus();
            this.k.showSoftInput(editText, 2);
        } catch (Exception e) {
            AppLog.g.d("Error Opening/Closing the Keyboard", e);
        }
    }
}
