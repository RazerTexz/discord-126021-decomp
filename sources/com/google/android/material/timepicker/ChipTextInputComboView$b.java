package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import com.google.android.material.internal.TextWatcherAdapter;

/* JADX INFO: loaded from: classes3.dex */
public class ChipTextInputComboView$b extends TextWatcherAdapter {
    public final /* synthetic */ ChipTextInputComboView j;

    public ChipTextInputComboView$b(ChipTextInputComboView chipTextInputComboView, ChipTextInputComboView$a chipTextInputComboView$a) {
        this.j = chipTextInputComboView;
    }

    @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (TextUtils.isEmpty(editable)) {
            ChipTextInputComboView chipTextInputComboView = this.j;
            chipTextInputComboView.j.setText(TimeModel.a(chipTextInputComboView.getResources(), "00", "%02d"));
        } else {
            ChipTextInputComboView chipTextInputComboView2 = this.j;
            chipTextInputComboView2.j.setText(TimeModel.a(chipTextInputComboView2.getResources(), editable, "%02d"));
        }
    }
}
