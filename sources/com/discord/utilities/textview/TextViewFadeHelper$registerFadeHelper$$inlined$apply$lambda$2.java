package com.discord.utilities.textview;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: compiled from: TextViewFadeHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TextViewFadeHelper$registerFadeHelper$$inlined$apply$lambda$2 implements TextWatcher {
    public final /* synthetic */ TextViewFadeHelper this$0;

    public TextViewFadeHelper$registerFadeHelper$$inlined$apply$lambda$2(TextViewFadeHelper textViewFadeHelper) {
        this.this$0 = textViewFadeHelper;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s2) {
        TextViewFadeHelper.access$updateFade(this.this$0);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s2, int start, int count, int after) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s2, int start, int before, int count) {
    }
}
