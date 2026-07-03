package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import com.google.android.material.C10817R;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p341g.p345d.AbstractC4392c;
import p007b.p225i.p226a.p341g.p345d.C4401l;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = new C10907b();

    @Nullable
    private Long selectedItem;

    /* JADX INFO: renamed from: com.google.android.material.datepicker.SingleDateSelector$a */
    public class C10906a extends AbstractC4392c {

        /* JADX INFO: renamed from: p */
        public final /* synthetic */ OnSelectionChangedListener f21004p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10906a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, OnSelectionChangedListener onSelectionChangedListener) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f21004p = onSelectionChangedListener;
        }

        @Override // p007b.p225i.p226a.p341g.p345d.AbstractC4392c
        /* JADX INFO: renamed from: a */
        public void mo6060a() {
            this.f21004p.onIncompleteSelectionChanged();
        }

        @Override // p007b.p225i.p226a.p341g.p345d.AbstractC4392c
        /* JADX INFO: renamed from: b */
        public void mo6061b(@Nullable Long l) {
            if (l == null) {
                SingleDateSelector.this.clearSelection();
            } else {
                SingleDateSelector.this.select(l.longValue());
            }
            this.f21004p.onSelectionChanged(SingleDateSelector.this.getSelection());
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.datepicker.SingleDateSelector$b */
    public static class C10907b implements Parcelable.Creator<SingleDateSelector> {
        @Override // android.os.Parcelable.Creator
        @NonNull
        public SingleDateSelector createFromParcel(@NonNull Parcel parcel) {
            SingleDateSelector singleDateSelector = new SingleDateSelector();
            singleDateSelector.selectedItem = (Long) parcel.readValue(Long.class.getClassLoader());
            return singleDateSelector;
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        public SingleDateSelector[] newArray(int i) {
            return new SingleDateSelector[i];
        }
    }

    private void clearSelection() {
        this.selectedItem = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultThemeResId(Context context) {
        return MaterialAttributes.resolveOrThrow(context, C10817R.attr.materialCalendarTheme, MaterialDatePicker.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultTitleResId() {
        return C10817R.string.mtrl_picker_date_header_title;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Long> getSelectedDays() {
        ArrayList arrayList = new ArrayList();
        Long l = this.selectedItem;
        if (l != null) {
            arrayList.add(l);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Pair<Long, Long>> getSelectedRanges() {
        return new ArrayList();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public String getSelectionDisplayString(@NonNull Context context) {
        Resources resources = context.getResources();
        Long l = this.selectedItem;
        if (l == null) {
            return resources.getString(C10817R.string.mtrl_picker_date_header_unselected);
        }
        return resources.getString(C10817R.string.mtrl_picker_date_header_selected, C3404f.m4340s0(l.longValue(), Locale.getDefault()));
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean isSelectionComplete() {
        return this.selectedItem != null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View onCreateTextInputView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, CalendarConstraints calendarConstraints, @NonNull OnSelectionChangedListener<Long> onSelectionChangedListener) {
        View viewInflate = layoutInflater.inflate(C10817R.layout.mtrl_picker_text_input_date, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(C10817R.id.mtrl_picker_text_input_date);
        EditText editText = textInputLayout.getEditText();
        if (ManufacturerUtils.isDateInputKeyboardMissingSeparatorCharacters()) {
            editText.setInputType(17);
        }
        SimpleDateFormat simpleDateFormatM6072e = C4401l.m6072e();
        String strM6073f = C4401l.m6073f(viewInflate.getResources(), simpleDateFormatM6072e);
        textInputLayout.setPlaceholderText(strM6073f);
        Long l = this.selectedItem;
        if (l != null) {
            editText.setText(simpleDateFormatM6072e.format(l));
        }
        editText.addTextChangedListener(new C10906a(strM6073f, simpleDateFormatM6072e, textInputLayout, calendarConstraints, onSelectionChangedListener));
        ViewUtils.requestFocusAndShowKeyboard(editText);
        return viewInflate;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void select(long j) {
        this.selectedItem = Long.valueOf(j);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeValue(this.selectedItem);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.material.datepicker.DateSelector
    @Nullable
    public Long getSelection() {
        return this.selectedItem;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void setSelection(@Nullable Long l) {
        this.selectedItem = l == null ? null : Long.valueOf(C4401l.m6068a(l.longValue()));
    }
}
