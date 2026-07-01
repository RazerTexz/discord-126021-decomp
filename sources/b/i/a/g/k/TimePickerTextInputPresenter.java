package b.i.a.g.k;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.timepicker.ChipTextInputComboView;
import com.google.android.material.timepicker.TimeModel;
import com.google.android.material.timepicker.TimePickerView;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.g.k.i, reason: use source file name */
/* JADX INFO: compiled from: TimePickerTextInputPresenter.java */
/* JADX INFO: loaded from: classes3.dex */
public class TimePickerTextInputPresenter implements TimePickerView.d, TimePickerPresenter {
    public final LinearLayout j;
    public final TimeModel k;
    public final TextWatcher l;
    public final TextWatcher m;
    public final ChipTextInputComboView n;
    public final ChipTextInputComboView o;
    public final TimePickerTextInputKeyController p;
    public final EditText q;
    public final EditText r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public MaterialButtonToggleGroup f1630s;

    /* JADX INFO: renamed from: b.i.a.g.k.i$a */
    /* JADX INFO: compiled from: TimePickerTextInputPresenter.java */
    public class a extends TextWatcherAdapter {
        public a() {
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    TimeModel timeModel = TimePickerTextInputPresenter.this.k;
                    Objects.requireNonNull(timeModel);
                    timeModel.n = 0;
                } else {
                    int i = Integer.parseInt(editable.toString());
                    TimeModel timeModel2 = TimePickerTextInputPresenter.this.k;
                    Objects.requireNonNull(timeModel2);
                    timeModel2.n = i % 60;
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.k.i$b */
    /* JADX INFO: compiled from: TimePickerTextInputPresenter.java */
    public class b extends TextWatcherAdapter {
        public b() {
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    TimePickerTextInputPresenter.this.k.c(0);
                } else {
                    TimePickerTextInputPresenter.this.k.c(Integer.parseInt(editable.toString()));
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.k.i$c */
    /* JADX INFO: compiled from: TimePickerTextInputPresenter.java */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TimePickerTextInputPresenter.this.b(((Integer) view.getTag(R.id.selection_type)).intValue());
        }
    }

    public TimePickerTextInputPresenter(LinearLayout linearLayout, TimeModel timeModel) {
        a aVar = new a();
        this.l = aVar;
        b bVar = new b();
        this.m = bVar;
        this.j = linearLayout;
        this.k = timeModel;
        Resources resources = linearLayout.getResources();
        ChipTextInputComboView chipTextInputComboView = (ChipTextInputComboView) linearLayout.findViewById(R.id.material_minute_text_input);
        this.n = chipTextInputComboView;
        ChipTextInputComboView chipTextInputComboView2 = (ChipTextInputComboView) linearLayout.findViewById(R.id.material_hour_text_input);
        this.o = chipTextInputComboView2;
        int i = R.id.material_label;
        TextView textView = (TextView) chipTextInputComboView.findViewById(i);
        TextView textView2 = (TextView) chipTextInputComboView2.findViewById(i);
        textView.setText(resources.getString(R.string.material_timepicker_minute));
        textView2.setText(resources.getString(R.string.material_timepicker_hour));
        int i2 = R.id.selection_type;
        chipTextInputComboView.setTag(i2, 12);
        chipTextInputComboView2.setTag(i2, 10);
        if (timeModel.l == 0) {
            MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) linearLayout.findViewById(R.id.material_clock_period_toggle);
            this.f1630s = materialButtonToggleGroup;
            materialButtonToggleGroup.addOnButtonCheckedListener(new TimePickerTextInputPresenter2(this));
            this.f1630s.setVisibility(0);
            e();
        }
        c cVar = new c();
        chipTextInputComboView2.setOnClickListener(cVar);
        chipTextInputComboView.setOnClickListener(cVar);
        chipTextInputComboView2.a(timeModel.k);
        chipTextInputComboView.a(timeModel.j);
        EditText editText = chipTextInputComboView2.k.getEditText();
        this.q = editText;
        EditText editText2 = chipTextInputComboView.k.getEditText();
        this.r = editText2;
        TimePickerTextInputKeyController timePickerTextInputKeyController = new TimePickerTextInputKeyController(chipTextInputComboView2, chipTextInputComboView, timeModel);
        this.p = timePickerTextInputKeyController;
        ViewCompat.setAccessibilityDelegate(chipTextInputComboView2.j, new ClickActionDelegate(linearLayout.getContext(), R.string.material_hour_selection));
        ViewCompat.setAccessibilityDelegate(chipTextInputComboView.j, new ClickActionDelegate(linearLayout.getContext(), R.string.material_minute_selection));
        editText.addTextChangedListener(bVar);
        editText2.addTextChangedListener(aVar);
        d(timeModel);
        TextInputLayout textInputLayout = chipTextInputComboView2.k;
        TextInputLayout textInputLayout2 = chipTextInputComboView.k;
        EditText editText3 = textInputLayout.getEditText();
        EditText editText4 = textInputLayout2.getEditText();
        editText3.setImeOptions(268435461);
        editText4.setImeOptions(268435462);
        editText3.setOnEditorActionListener(timePickerTextInputKeyController);
        editText3.setOnKeyListener(timePickerTextInputKeyController);
        editText4.setOnKeyListener(timePickerTextInputKeyController);
    }

    @Override // b.i.a.g.k.TimePickerPresenter
    public void a() {
        d(this.k);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.d
    public void b(int i) {
        this.k.o = i;
        this.n.setChecked(i == 12);
        this.o.setChecked(i == 10);
        e();
    }

    @Override // b.i.a.g.k.TimePickerPresenter
    public void c() {
        View focusedChild = this.j.getFocusedChild();
        if (focusedChild == null) {
            this.j.setVisibility(8);
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) ContextCompat.getSystemService(this.j.getContext(), InputMethodManager.class);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(focusedChild.getWindowToken(), 0);
        }
        this.j.setVisibility(8);
    }

    public final void d(TimeModel timeModel) {
        this.q.removeTextChangedListener(this.m);
        this.r.removeTextChangedListener(this.l);
        Locale locale = this.j.getResources().getConfiguration().locale;
        String str = String.format(locale, "%02d", Integer.valueOf(timeModel.n));
        String str2 = String.format(locale, "%02d", Integer.valueOf(timeModel.b()));
        this.n.b(str);
        this.o.b(str2);
        this.q.addTextChangedListener(this.m);
        this.r.addTextChangedListener(this.l);
        e();
    }

    public final void e() {
        MaterialButtonToggleGroup materialButtonToggleGroup = this.f1630s;
        if (materialButtonToggleGroup == null) {
            return;
        }
        materialButtonToggleGroup.check(this.k.p == 0 ? R.id.material_clock_period_am_button : R.id.material_clock_period_pm_button);
    }

    @Override // b.i.a.g.k.TimePickerPresenter
    public void show() {
        this.j.setVisibility(0);
    }
}
