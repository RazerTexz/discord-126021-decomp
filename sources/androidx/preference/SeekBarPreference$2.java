package androidx.preference;

import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View$OnKeyListener;
import android.widget.SeekBar;

/* JADX INFO: loaded from: classes.dex */
public class SeekBarPreference$2 implements View$OnKeyListener {
    public final /* synthetic */ SeekBarPreference this$0;

    public SeekBarPreference$2(SeekBarPreference seekBarPreference) {
        this.this$0 = seekBarPreference;
    }

    @Override // android.view.View$OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        SeekBarPreference seekBarPreference = this.this$0;
        if ((!seekBarPreference.mAdjustable && (i == 21 || i == 22)) || i == 23 || i == 66) {
            return false;
        }
        SeekBar seekBar = seekBarPreference.mSeekBar;
        if (seekBar != null) {
            return seekBar.onKeyDown(i, keyEvent);
        }
        Log.e("SeekBarPreference", "SeekBar view is null and hence cannot be adjusted.");
        return false;
    }
}
