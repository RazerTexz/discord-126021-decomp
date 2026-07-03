package p007b.p225i.p226a.p341g.p352k;

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
import com.google.android.material.C10817R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.timepicker.ChipTextInputComboView;
import com.google.android.material.timepicker.TimeModel;
import com.google.android.material.timepicker.TimePickerView;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.g.k.i */
/* JADX INFO: compiled from: TimePickerTextInputPresenter.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4454i implements TimePickerView.InterfaceC11031d, InterfaceC4452g {

    /* JADX INFO: renamed from: j */
    public final LinearLayout f11877j;

    /* JADX INFO: renamed from: k */
    public final TimeModel f11878k;

    /* JADX INFO: renamed from: l */
    public final TextWatcher f11879l;

    /* JADX INFO: renamed from: m */
    public final TextWatcher f11880m;

    /* JADX INFO: renamed from: n */
    public final ChipTextInputComboView f11881n;

    /* JADX INFO: renamed from: o */
    public final ChipTextInputComboView f11882o;

    /* JADX INFO: renamed from: p */
    public final ViewOnKeyListenerC4453h f11883p;

    /* JADX INFO: renamed from: q */
    public final EditText f11884q;

    /* JADX INFO: renamed from: r */
    public final EditText f11885r;

    /* JADX INFO: renamed from: s */
    public MaterialButtonToggleGroup f11886s;

    /* JADX INFO: renamed from: b.i.a.g.k.i$a */
    /* JADX INFO: compiled from: TimePickerTextInputPresenter.java */
    public class a extends TextWatcherAdapter {
        public a() {
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    TimeModel timeModel = C4454i.this.f11878k;
                    Objects.requireNonNull(timeModel);
                    timeModel.f21224n = 0;
                } else {
                    int i = Integer.parseInt(editable.toString());
                    TimeModel timeModel2 = C4454i.this.f11878k;
                    Objects.requireNonNull(timeModel2);
                    timeModel2.f21224n = i % 60;
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
                    C4454i.this.f11878k.m9162c(0);
                } else {
                    C4454i.this.f11878k.m9162c(Integer.parseInt(editable.toString()));
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
            C4454i.this.mo6172b(((Integer) view.getTag(C10817R.id.selection_type)).intValue());
        }
    }

    public C4454i(LinearLayout linearLayout, TimeModel timeModel) {
        a aVar = new a();
        this.f11879l = aVar;
        b bVar = new b();
        this.f11880m = bVar;
        this.f11877j = linearLayout;
        this.f11878k = timeModel;
        Resources resources = linearLayout.getResources();
        ChipTextInputComboView chipTextInputComboView = (ChipTextInputComboView) linearLayout.findViewById(C10817R.id.material_minute_text_input);
        this.f11881n = chipTextInputComboView;
        ChipTextInputComboView chipTextInputComboView2 = (ChipTextInputComboView) linearLayout.findViewById(C10817R.id.material_hour_text_input);
        this.f11882o = chipTextInputComboView2;
        int i = C10817R.id.material_label;
        TextView textView = (TextView) chipTextInputComboView.findViewById(i);
        TextView textView2 = (TextView) chipTextInputComboView2.findViewById(i);
        textView.setText(resources.getString(C10817R.string.material_timepicker_minute));
        textView2.setText(resources.getString(C10817R.string.material_timepicker_hour));
        int i2 = C10817R.id.selection_type;
        chipTextInputComboView.setTag(i2, 12);
        chipTextInputComboView2.setTag(i2, 10);
        if (timeModel.f21222l == 0) {
            MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) linearLayout.findViewById(C10817R.id.material_clock_period_toggle);
            this.f11886s = materialButtonToggleGroup;
            materialButtonToggleGroup.addOnButtonCheckedListener(new C4455j(this));
            this.f11886s.setVisibility(0);
            m6180e();
        }
        c cVar = new c();
        chipTextInputComboView2.setOnClickListener(cVar);
        chipTextInputComboView.setOnClickListener(cVar);
        chipTextInputComboView2.m9152a(timeModel.f21221k);
        chipTextInputComboView.m9152a(timeModel.f21220j);
        EditText editText = chipTextInputComboView2.f21182k.getEditText();
        this.f11884q = editText;
        EditText editText2 = chipTextInputComboView.f21182k.getEditText();
        this.f11885r = editText2;
        ViewOnKeyListenerC4453h viewOnKeyListenerC4453h = new ViewOnKeyListenerC4453h(chipTextInputComboView2, chipTextInputComboView, timeModel);
        this.f11883p = viewOnKeyListenerC4453h;
        ViewCompat.setAccessibilityDelegate(chipTextInputComboView2.f21181j, new C4446a(linearLayout.getContext(), C10817R.string.material_hour_selection));
        ViewCompat.setAccessibilityDelegate(chipTextInputComboView.f21181j, new C4446a(linearLayout.getContext(), C10817R.string.material_minute_selection));
        editText.addTextChangedListener(bVar);
        editText2.addTextChangedListener(aVar);
        m6179d(timeModel);
        TextInputLayout textInputLayout = chipTextInputComboView2.f21182k;
        TextInputLayout textInputLayout2 = chipTextInputComboView.f21182k;
        EditText editText3 = textInputLayout.getEditText();
        EditText editText4 = textInputLayout2.getEditText();
        editText3.setImeOptions(268435461);
        editText4.setImeOptions(268435462);
        editText3.setOnEditorActionListener(viewOnKeyListenerC4453h);
        editText3.setOnKeyListener(viewOnKeyListenerC4453h);
        editText4.setOnKeyListener(viewOnKeyListenerC4453h);
    }

    @Override // p007b.p225i.p226a.p341g.p352k.InterfaceC4452g
    /* JADX INFO: renamed from: a */
    public void mo6171a() {
        m6179d(this.f11878k);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.InterfaceC11031d
    /* JADX INFO: renamed from: b */
    public void mo6172b(int i) {
        this.f11878k.f21225o = i;
        this.f11881n.setChecked(i == 12);
        this.f11882o.setChecked(i == 10);
        m6180e();
    }

    @Override // p007b.p225i.p226a.p341g.p352k.InterfaceC4452g
    /* JADX INFO: renamed from: c */
    public void mo6173c() {
        View focusedChild = this.f11877j.getFocusedChild();
        if (focusedChild == null) {
            this.f11877j.setVisibility(8);
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) ContextCompat.getSystemService(this.f11877j.getContext(), InputMethodManager.class);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(focusedChild.getWindowToken(), 0);
        }
        this.f11877j.setVisibility(8);
    }

    /* JADX INFO: renamed from: d */
    public final void m6179d(TimeModel timeModel) {
        this.f11884q.removeTextChangedListener(this.f11880m);
        this.f11885r.removeTextChangedListener(this.f11879l);
        Locale locale = this.f11877j.getResources().getConfiguration().locale;
        String str = String.format(locale, "%02d", Integer.valueOf(timeModel.f21224n));
        String str2 = String.format(locale, "%02d", Integer.valueOf(timeModel.m9161b()));
        this.f11881n.m9153b(str);
        this.f11882o.m9153b(str2);
        this.f11884q.addTextChangedListener(this.f11880m);
        this.f11885r.addTextChangedListener(this.f11879l);
        m6180e();
    }

    /* JADX INFO: renamed from: e */
    public final void m6180e() {
        MaterialButtonToggleGroup materialButtonToggleGroup = this.f11886s;
        if (materialButtonToggleGroup == null) {
            return;
        }
        materialButtonToggleGroup.check(this.f11878k.f21226p == 0 ? C10817R.id.material_clock_period_am_button : C10817R.id.material_clock_period_pm_button);
    }

    @Override // p007b.p225i.p226a.p341g.p352k.InterfaceC4452g
    public void show() {
        this.f11877j.setVisibility(0);
    }
}
