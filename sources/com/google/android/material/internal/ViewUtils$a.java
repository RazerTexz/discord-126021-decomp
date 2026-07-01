package com.google.android.material.internal;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* JADX INFO: loaded from: classes3.dex */
public class ViewUtils$a implements Runnable {
    public final /* synthetic */ View j;

    public ViewUtils$a(View view) {
        this.j = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        ((InputMethodManager) this.j.getContext().getSystemService("input_method")).showSoftInput(this.j, 1);
    }
}
