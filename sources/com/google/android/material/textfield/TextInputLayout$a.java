package com.google.android.material.textfield;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class TextInputLayout$a implements TextWatcher {
    public final /* synthetic */ TextInputLayout j;

    public TextInputLayout$a(TextInputLayout textInputLayout) {
        this.j = textInputLayout;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@NonNull Editable editable) {
        TextInputLayout textInputLayout = this.j;
        textInputLayout.updateLabelState(!TextInputLayout.access$000(textInputLayout));
        TextInputLayout textInputLayout2 = this.j;
        if (textInputLayout2.counterEnabled) {
            textInputLayout2.updateCounter(editable.length());
        }
        if (TextInputLayout.access$100(this.j)) {
            TextInputLayout.access$200(this.j, editable.length());
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
