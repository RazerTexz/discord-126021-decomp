package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.C10817R;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* JADX INFO: renamed from: j */
    public final Chip f21181j;

    /* JADX INFO: renamed from: k */
    public final TextInputLayout f21182k;

    /* JADX INFO: renamed from: l */
    public final EditText f21183l;

    /* JADX INFO: renamed from: m */
    public TextWatcher f21184m;

    /* JADX INFO: renamed from: com.google.android.material.timepicker.ChipTextInputComboView$b */
    public class C11020b extends TextWatcherAdapter {
        public C11020b(C11019a c11019a) {
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView chipTextInputComboView = ChipTextInputComboView.this;
                chipTextInputComboView.f21181j.setText(TimeModel.m9160a(chipTextInputComboView.getResources(), "00", "%02d"));
            } else {
                ChipTextInputComboView chipTextInputComboView2 = ChipTextInputComboView.this;
                chipTextInputComboView2.f21181j.setText(TimeModel.m9160a(chipTextInputComboView2.getResources(), editable, "%02d"));
            }
        }
    }

    public ChipTextInputComboView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        Chip chip = (Chip) layoutInflaterFrom.inflate(C10817R.layout.material_time_chip, (ViewGroup) this, false);
        this.f21181j = chip;
        TextInputLayout textInputLayout = (TextInputLayout) layoutInflaterFrom.inflate(C10817R.layout.material_time_input, (ViewGroup) this, false);
        this.f21182k = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.f21183l = editText;
        editText.setVisibility(4);
        C11020b c11020b = new C11020b(null);
        this.f21184m = c11020b;
        editText.addTextChangedListener(c11020b);
        m9154c();
        addView(chip);
        addView(textInputLayout);
        editText.setSaveEnabled(false);
    }

    /* JADX INFO: renamed from: a */
    public void m9152a(InputFilter inputFilter) {
        InputFilter[] filters = this.f21183l.getFilters();
        InputFilter[] inputFilterArr = (InputFilter[]) Arrays.copyOf(filters, filters.length + 1);
        inputFilterArr[filters.length] = inputFilter;
        this.f21183l.setFilters(inputFilterArr);
    }

    /* JADX INFO: renamed from: b */
    public void m9153b(CharSequence charSequence) {
        this.f21181j.setText(TimeModel.m9160a(getResources(), charSequence, "%02d"));
        if (TextUtils.isEmpty(this.f21183l.getText())) {
            return;
        }
        this.f21183l.removeTextChangedListener(this.f21184m);
        this.f21183l.setText((CharSequence) null);
        this.f21183l.addTextChangedListener(this.f21184m);
    }

    /* JADX INFO: renamed from: c */
    public final void m9154c() {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f21183l.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f21181j.isChecked();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m9154c();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z2) {
        this.f21181j.setChecked(z2);
        this.f21183l.setVisibility(z2 ? 0 : 4);
        this.f21181j.setVisibility(z2 ? 8 : 0);
        if (isChecked()) {
            this.f21183l.requestFocus();
            if (TextUtils.isEmpty(this.f21183l.getText())) {
                return;
            }
            EditText editText = this.f21183l;
            editText.setSelection(editText.getText().length());
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.f21181j.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setTag(int i, Object obj) {
        this.f21181j.setTag(i, obj);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.f21181j.toggle();
    }
}
