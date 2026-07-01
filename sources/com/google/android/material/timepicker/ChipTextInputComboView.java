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
import com.google.android.material.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class ChipTextInputComboView extends FrameLayout implements Checkable {
    public final Chip j;
    public final TextInputLayout k;
    public final EditText l;
    public TextWatcher m;

    public class b extends TextWatcherAdapter {
        public b(a aVar) {
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView chipTextInputComboView = ChipTextInputComboView.this;
                chipTextInputComboView.j.setText(TimeModel.a(chipTextInputComboView.getResources(), "00", "%02d"));
            } else {
                ChipTextInputComboView chipTextInputComboView2 = ChipTextInputComboView.this;
                chipTextInputComboView2.j.setText(TimeModel.a(chipTextInputComboView2.getResources(), editable, "%02d"));
            }
        }
    }

    public ChipTextInputComboView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        Chip chip = (Chip) layoutInflaterFrom.inflate(R.layout.material_time_chip, (ViewGroup) this, false);
        this.j = chip;
        TextInputLayout textInputLayout = (TextInputLayout) layoutInflaterFrom.inflate(R.layout.material_time_input, (ViewGroup) this, false);
        this.k = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.l = editText;
        editText.setVisibility(4);
        b bVar = new b(null);
        this.m = bVar;
        editText.addTextChangedListener(bVar);
        c();
        addView(chip);
        addView(textInputLayout);
        editText.setSaveEnabled(false);
    }

    public void a(InputFilter inputFilter) {
        InputFilter[] filters = this.l.getFilters();
        InputFilter[] inputFilterArr = (InputFilter[]) Arrays.copyOf(filters, filters.length + 1);
        inputFilterArr[filters.length] = inputFilter;
        this.l.setFilters(inputFilterArr);
    }

    public void b(CharSequence charSequence) {
        this.j.setText(TimeModel.a(getResources(), charSequence, "%02d"));
        if (TextUtils.isEmpty(this.l.getText())) {
            return;
        }
        this.l.removeTextChangedListener(this.m);
        this.l.setText((CharSequence) null);
        this.l.addTextChangedListener(this.m);
    }

    public final void c() {
        if (Build.VERSION.SDK_INT >= 24) {
            this.l.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.j.isChecked();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        c();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z2) {
        this.j.setChecked(z2);
        this.l.setVisibility(z2 ? 0 : 4);
        this.j.setVisibility(z2 ? 8 : 0);
        if (isChecked()) {
            this.l.requestFocus();
            if (TextUtils.isEmpty(this.l.getText())) {
                return;
            }
            EditText editText = this.l;
            editText.setSelection(editText.getText().length());
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.j.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setTag(int i, Object obj) {
        this.j.setTag(i, obj);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.j.toggle();
    }
}
