package androidx.preference;

import android.widget.CompoundButton;
import android.widget.CompoundButton$OnCheckedChangeListener;

/* JADX INFO: loaded from: classes.dex */
public class SwitchPreferenceCompat$Listener implements CompoundButton$OnCheckedChangeListener {
    public final /* synthetic */ SwitchPreferenceCompat this$0;

    public SwitchPreferenceCompat$Listener(SwitchPreferenceCompat switchPreferenceCompat) {
        this.this$0 = switchPreferenceCompat;
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
