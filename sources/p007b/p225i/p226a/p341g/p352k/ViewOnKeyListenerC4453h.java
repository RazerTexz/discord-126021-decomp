package p007b.p225i.p226a.p341g.p352k;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.timepicker.ChipTextInputComboView;
import com.google.android.material.timepicker.TimeModel;

/* JADX INFO: renamed from: b.i.a.g.k.h */
/* JADX INFO: compiled from: TimePickerTextInputKeyController.java */
/* JADX INFO: loaded from: classes3.dex */
public class ViewOnKeyListenerC4453h implements TextView.OnEditorActionListener, View.OnKeyListener {

    /* JADX INFO: renamed from: j */
    public final ChipTextInputComboView f11873j;

    /* JADX INFO: renamed from: k */
    public final ChipTextInputComboView f11874k;

    /* JADX INFO: renamed from: l */
    public final TimeModel f11875l;

    /* JADX INFO: renamed from: m */
    public boolean f11876m = false;

    public ViewOnKeyListenerC4453h(ChipTextInputComboView chipTextInputComboView, ChipTextInputComboView chipTextInputComboView2, TimeModel timeModel) {
        this.f11873j = chipTextInputComboView;
        this.f11874k = chipTextInputComboView2;
        this.f11875l = timeModel;
    }

    /* JADX INFO: renamed from: a */
    public final void m6178a(int i) {
        this.f11874k.setChecked(i == 12);
        this.f11873j.setChecked(i == 10);
        this.f11875l.f21225o = i;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        boolean z2 = i == 5;
        if (z2) {
            m6178a(12);
        }
        return z2;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0032  */
    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.f11876m) {
            return false;
        }
        boolean z2 = true;
        this.f11876m = true;
        EditText editText = (EditText) view;
        if (this.f11875l.f21225o == 12) {
            if (i == 67 && keyEvent.getAction() == 0 && TextUtils.isEmpty(editText.getText())) {
                m6178a(10);
            } else {
                z2 = false;
            }
        } else {
            Editable text = editText.getText();
            if (text != null) {
                if (i >= 7 && i <= 16 && keyEvent.getAction() == 1 && editText.getSelectionStart() == 2 && text.length() == 2) {
                    m6178a(12);
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
        }
        this.f11876m = false;
        return z2;
    }
}
