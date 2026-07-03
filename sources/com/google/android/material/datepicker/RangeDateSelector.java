package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import androidx.core.util.Preconditions;
import com.google.android.material.C10817R;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Locale;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p341g.p345d.AbstractC4392c;
import p007b.p225i.p226a.p341g.p345d.C4401l;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class RangeDateSelector implements DateSelector<Pair<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new C10905c();
    private String invalidRangeStartError;
    private final String invalidRangeEndError = " ";

    @Nullable
    private Long selectedStartItem = null;

    @Nullable
    private Long selectedEndItem = null;

    @Nullable
    private Long proposedTextStart = null;

    @Nullable
    private Long proposedTextEnd = null;

    /* JADX INFO: renamed from: com.google.android.material.datepicker.RangeDateSelector$a */
    public class C10903a extends AbstractC4392c {

        /* JADX INFO: renamed from: p */
        public final /* synthetic */ TextInputLayout f20996p;

        /* JADX INFO: renamed from: q */
        public final /* synthetic */ TextInputLayout f20997q;

        /* JADX INFO: renamed from: r */
        public final /* synthetic */ OnSelectionChangedListener f20998r;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10903a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, OnSelectionChangedListener onSelectionChangedListener) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f20996p = textInputLayout2;
            this.f20997q = textInputLayout3;
            this.f20998r = onSelectionChangedListener;
        }

        @Override // p007b.p225i.p226a.p341g.p345d.AbstractC4392c
        /* JADX INFO: renamed from: a */
        public void mo6060a() {
            RangeDateSelector.this.proposedTextStart = null;
            RangeDateSelector.this.updateIfValidTextProposal(this.f20996p, this.f20997q, this.f20998r);
        }

        @Override // p007b.p225i.p226a.p341g.p345d.AbstractC4392c
        /* JADX INFO: renamed from: b */
        public void mo6061b(@Nullable Long l) {
            RangeDateSelector.this.proposedTextStart = l;
            RangeDateSelector.this.updateIfValidTextProposal(this.f20996p, this.f20997q, this.f20998r);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.datepicker.RangeDateSelector$b */
    public class C10904b extends AbstractC4392c {

        /* JADX INFO: renamed from: p */
        public final /* synthetic */ TextInputLayout f21000p;

        /* JADX INFO: renamed from: q */
        public final /* synthetic */ TextInputLayout f21001q;

        /* JADX INFO: renamed from: r */
        public final /* synthetic */ OnSelectionChangedListener f21002r;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10904b(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, OnSelectionChangedListener onSelectionChangedListener) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f21000p = textInputLayout2;
            this.f21001q = textInputLayout3;
            this.f21002r = onSelectionChangedListener;
        }

        @Override // p007b.p225i.p226a.p341g.p345d.AbstractC4392c
        /* JADX INFO: renamed from: a */
        public void mo6060a() {
            RangeDateSelector.this.proposedTextEnd = null;
            RangeDateSelector.this.updateIfValidTextProposal(this.f21000p, this.f21001q, this.f21002r);
        }

        @Override // p007b.p225i.p226a.p341g.p345d.AbstractC4392c
        /* JADX INFO: renamed from: b */
        public void mo6061b(@Nullable Long l) {
            RangeDateSelector.this.proposedTextEnd = l;
            RangeDateSelector.this.updateIfValidTextProposal(this.f21000p, this.f21001q, this.f21002r);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.datepicker.RangeDateSelector$c */
    public static class C10905c implements Parcelable.Creator<RangeDateSelector> {
        @Override // android.os.Parcelable.Creator
        @NonNull
        public RangeDateSelector createFromParcel(@NonNull Parcel parcel) {
            RangeDateSelector rangeDateSelector = new RangeDateSelector();
            rangeDateSelector.selectedStartItem = (Long) parcel.readValue(Long.class.getClassLoader());
            rangeDateSelector.selectedEndItem = (Long) parcel.readValue(Long.class.getClassLoader());
            return rangeDateSelector;
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        public RangeDateSelector[] newArray(int i) {
            return new RangeDateSelector[i];
        }
    }

    private void clearInvalidRange(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        if (textInputLayout.getError() != null && this.invalidRangeStartError.contentEquals(textInputLayout.getError())) {
            textInputLayout.setError(null);
        }
        if (textInputLayout2.getError() == null || !" ".contentEquals(textInputLayout2.getError())) {
            return;
        }
        textInputLayout2.setError(null);
    }

    private boolean isValidRange(long j, long j2) {
        return j <= j2;
    }

    private void setInvalidRange(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        textInputLayout.setError(this.invalidRangeStartError);
        textInputLayout2.setError(" ");
    }

    private void updateIfValidTextProposal(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2, @NonNull OnSelectionChangedListener<Pair<Long, Long>> onSelectionChangedListener) {
        Long l = this.proposedTextStart;
        if (l == null || this.proposedTextEnd == null) {
            clearInvalidRange(textInputLayout, textInputLayout2);
            onSelectionChangedListener.onIncompleteSelectionChanged();
        } else if (!isValidRange(l.longValue(), this.proposedTextEnd.longValue())) {
            setInvalidRange(textInputLayout, textInputLayout2);
            onSelectionChangedListener.onIncompleteSelectionChanged();
        } else {
            this.selectedStartItem = this.proposedTextStart;
            this.selectedEndItem = this.proposedTextEnd;
            onSelectionChangedListener.onSelectionChanged(getSelection());
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultThemeResId(@NonNull Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return MaterialAttributes.resolveOrThrow(context, Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(C10817R.dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis) ? C10817R.attr.materialCalendarTheme : C10817R.attr.materialCalendarFullscreenTheme, MaterialDatePicker.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultTitleResId() {
        return C10817R.string.mtrl_picker_range_header_title;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Long> getSelectedDays() {
        ArrayList arrayList = new ArrayList();
        Long l = this.selectedStartItem;
        if (l != null) {
            arrayList.add(l);
        }
        Long l2 = this.selectedEndItem;
        if (l2 != null) {
            arrayList.add(l2);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Pair<Long, Long>> getSelectedRanges() {
        if (this.selectedStartItem == null || this.selectedEndItem == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(this.selectedStartItem, this.selectedEndItem));
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public String getSelectionDisplayString(@NonNull Context context) {
        Pair pairCreate;
        Resources resources = context.getResources();
        Long l = this.selectedStartItem;
        if (l == null && this.selectedEndItem == null) {
            return resources.getString(C10817R.string.mtrl_picker_range_header_unselected);
        }
        Long l2 = this.selectedEndItem;
        if (l2 == null) {
            return resources.getString(C10817R.string.mtrl_picker_range_header_only_start_selected, C3404f.m4292g0(l.longValue()));
        }
        if (l == null) {
            return resources.getString(C10817R.string.mtrl_picker_range_header_only_end_selected, C3404f.m4292g0(l2.longValue()));
        }
        if (l == null && l2 == null) {
            pairCreate = Pair.create(null, null);
        } else if (l == null) {
            pairCreate = Pair.create(null, C3404f.m4296h0(l2.longValue(), null));
        } else if (l2 == null) {
            pairCreate = Pair.create(C3404f.m4296h0(l.longValue(), null), null);
        } else {
            Calendar calendarM6075h = C4401l.m6075h();
            Calendar calendarM6076i = C4401l.m6076i();
            calendarM6076i.setTimeInMillis(l.longValue());
            Calendar calendarM6076i2 = C4401l.m6076i();
            calendarM6076i2.setTimeInMillis(l2.longValue());
            if (calendarM6076i.get(1) == calendarM6076i2.get(1)) {
                pairCreate = calendarM6076i.get(1) == calendarM6075h.get(1) ? Pair.create(C3404f.m4320n0(l.longValue(), Locale.getDefault()), C3404f.m4320n0(l2.longValue(), Locale.getDefault())) : Pair.create(C3404f.m4320n0(l.longValue(), Locale.getDefault()), C3404f.m4340s0(l2.longValue(), Locale.getDefault()));
            } else {
                pairCreate = Pair.create(C3404f.m4340s0(l.longValue(), Locale.getDefault()), C3404f.m4340s0(l2.longValue(), Locale.getDefault()));
            }
        }
        return resources.getString(C10817R.string.mtrl_picker_range_header_selected, pairCreate.first, pairCreate.second);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean isSelectionComplete() {
        Long l = this.selectedStartItem;
        return (l == null || this.selectedEndItem == null || !isValidRange(l.longValue(), this.selectedEndItem.longValue())) ? false : true;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View onCreateTextInputView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, CalendarConstraints calendarConstraints, @NonNull OnSelectionChangedListener<Pair<Long, Long>> onSelectionChangedListener) {
        View viewInflate = layoutInflater.inflate(C10817R.layout.mtrl_picker_text_input_date_range, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(C10817R.id.mtrl_picker_text_input_range_start);
        TextInputLayout textInputLayout2 = (TextInputLayout) viewInflate.findViewById(C10817R.id.mtrl_picker_text_input_range_end);
        EditText editText = textInputLayout.getEditText();
        EditText editText2 = textInputLayout2.getEditText();
        if (ManufacturerUtils.isDateInputKeyboardMissingSeparatorCharacters()) {
            editText.setInputType(17);
            editText2.setInputType(17);
        }
        this.invalidRangeStartError = viewInflate.getResources().getString(C10817R.string.mtrl_picker_invalid_range);
        SimpleDateFormat simpleDateFormatM6072e = C4401l.m6072e();
        Long l = this.selectedStartItem;
        if (l != null) {
            editText.setText(simpleDateFormatM6072e.format(l));
            this.proposedTextStart = this.selectedStartItem;
        }
        Long l2 = this.selectedEndItem;
        if (l2 != null) {
            editText2.setText(simpleDateFormatM6072e.format(l2));
            this.proposedTextEnd = this.selectedEndItem;
        }
        String strM6073f = C4401l.m6073f(viewInflate.getResources(), simpleDateFormatM6072e);
        textInputLayout.setPlaceholderText(strM6073f);
        textInputLayout2.setPlaceholderText(strM6073f);
        editText.addTextChangedListener(new C10903a(strM6073f, simpleDateFormatM6072e, textInputLayout, calendarConstraints, textInputLayout, textInputLayout2, onSelectionChangedListener));
        editText2.addTextChangedListener(new C10904b(strM6073f, simpleDateFormatM6072e, textInputLayout2, calendarConstraints, textInputLayout, textInputLayout2, onSelectionChangedListener));
        ViewUtils.requestFocusAndShowKeyboard(editText);
        return viewInflate;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void select(long j) {
        Long l = this.selectedStartItem;
        if (l == null) {
            this.selectedStartItem = Long.valueOf(j);
        } else if (this.selectedEndItem == null && isValidRange(l.longValue(), j)) {
            this.selectedEndItem = Long.valueOf(j);
        } else {
            this.selectedEndItem = null;
            this.selectedStartItem = Long.valueOf(j);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeValue(this.selectedStartItem);
        parcel.writeValue(this.selectedEndItem);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Pair<Long, Long> getSelection() {
        return new Pair<>(this.selectedStartItem, this.selectedEndItem);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void setSelection(@NonNull Pair<Long, Long> pair) {
        Long l = pair.first;
        if (l != null && pair.second != null) {
            Preconditions.checkArgument(isValidRange(l.longValue(), pair.second.longValue()));
        }
        Long l2 = pair.first;
        this.selectedStartItem = l2 == null ? null : Long.valueOf(C4401l.m6068a(l2.longValue()));
        Long l3 = pair.second;
        this.selectedEndItem = l3 != null ? Long.valueOf(C4401l.m6068a(l3.longValue())) : null;
    }
}
