package b.i.a.g.k;

import android.content.res.Resources;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$id;
import com.google.android.material.R$string;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.timepicker.ChipTextInputComboView;
import com.google.android.material.timepicker.TimeModel;
import com.google.android.material.timepicker.TimePickerView$d;
import java.util.Locale;

/* JADX INFO: compiled from: TimePickerTextInputPresenter.java */
/* JADX INFO: loaded from: classes3.dex */
public class i implements TimePickerView$d, g {
    public final LinearLayout j;
    public final TimeModel k;
    public final TextWatcher l;
    public final TextWatcher m;
    public final ChipTextInputComboView n;
    public final ChipTextInputComboView o;
    public final h p;
    public final EditText q;
    public final EditText r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public MaterialButtonToggleGroup f1630s;

    public i(LinearLayout linearLayout, TimeModel timeModel) {
        i$a i_a = new i$a(this);
        this.l = i_a;
        i$b i_b = new i$b(this);
        this.m = i_b;
        this.j = linearLayout;
        this.k = timeModel;
        Resources resources = linearLayout.getResources();
        ChipTextInputComboView chipTextInputComboView = (ChipTextInputComboView) linearLayout.findViewById(R$id.material_minute_text_input);
        this.n = chipTextInputComboView;
        ChipTextInputComboView chipTextInputComboView2 = (ChipTextInputComboView) linearLayout.findViewById(R$id.material_hour_text_input);
        this.o = chipTextInputComboView2;
        int i = R$id.material_label;
        TextView textView = (TextView) chipTextInputComboView.findViewById(i);
        TextView textView2 = (TextView) chipTextInputComboView2.findViewById(i);
        textView.setText(resources.getString(R$string.material_timepicker_minute));
        textView2.setText(resources.getString(R$string.material_timepicker_hour));
        int i2 = R$id.selection_type;
        chipTextInputComboView.setTag(i2, 12);
        chipTextInputComboView2.setTag(i2, 10);
        if (timeModel.l == 0) {
            MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) linearLayout.findViewById(R$id.material_clock_period_toggle);
            this.f1630s = materialButtonToggleGroup;
            materialButtonToggleGroup.addOnButtonCheckedListener(new j(this));
            this.f1630s.setVisibility(0);
            e();
        }
        i$c i_c = new i$c(this);
        chipTextInputComboView2.setOnClickListener(i_c);
        chipTextInputComboView.setOnClickListener(i_c);
        chipTextInputComboView2.a(timeModel.k);
        chipTextInputComboView.a(timeModel.j);
        EditText editText = chipTextInputComboView2.k.getEditText();
        this.q = editText;
        EditText editText2 = chipTextInputComboView.k.getEditText();
        this.r = editText2;
        h hVar = new h(chipTextInputComboView2, chipTextInputComboView, timeModel);
        this.p = hVar;
        ViewCompat.setAccessibilityDelegate(chipTextInputComboView2.j, new a(linearLayout.getContext(), R$string.material_hour_selection));
        ViewCompat.setAccessibilityDelegate(chipTextInputComboView.j, new a(linearLayout.getContext(), R$string.material_minute_selection));
        editText.addTextChangedListener(i_b);
        editText2.addTextChangedListener(i_a);
        d(timeModel);
        TextInputLayout textInputLayout = chipTextInputComboView2.k;
        TextInputLayout textInputLayout2 = chipTextInputComboView.k;
        EditText editText3 = textInputLayout.getEditText();
        EditText editText4 = textInputLayout2.getEditText();
        editText3.setImeOptions(268435461);
        editText4.setImeOptions(268435462);
        editText3.setOnEditorActionListener(hVar);
        editText3.setOnKeyListener(hVar);
        editText4.setOnKeyListener(hVar);
    }

    @Override // b.i.a.g.k.g
    public void a() {
        d(this.k);
    }

    @Override // com.google.android.material.timepicker.TimePickerView$d
    public void b(int i) {
        this.k.o = i;
        this.n.setChecked(i == 12);
        this.o.setChecked(i == 10);
        e();
    }

    @Override // b.i.a.g.k.g
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
        materialButtonToggleGroup.check(this.k.p == 0 ? R$id.material_clock_period_am_button : R$id.material_clock_period_pm_button);
    }

    @Override // b.i.a.g.k.g
    public void show() {
        this.j.setVisibility(0);
    }
}
