package androidx.preference;

import android.widget.CompoundButton;
import android.widget.CompoundButton$OnCheckedChangeListener;

/* JADX INFO: loaded from: classes.dex */
public class CheckBoxPreference$Listener implements CompoundButton$OnCheckedChangeListener {
    public final /* synthetic */ CheckBoxPreference this$0;

    public CheckBoxPreference$Listener(CheckBoxPreference checkBoxPreference) {
        this.this$0 = checkBoxPreference;
    }

    @Override // android.widget.CompoundButton$OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        if (this.this$0.callChangeListener(Boolean.valueOf(z2))) {
            this.this$0.setChecked(z2);
        } else {
            compoundButton.setChecked(!z2);
        }
    }
}
