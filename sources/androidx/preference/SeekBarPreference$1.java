package androidx.preference;

import android.widget.SeekBar;
import android.widget.SeekBar$OnSeekBarChangeListener;

/* JADX INFO: loaded from: classes.dex */
public class SeekBarPreference$1 implements SeekBar$OnSeekBarChangeListener {
    public final /* synthetic */ SeekBarPreference this$0;

    public SeekBarPreference$1(SeekBarPreference seekBarPreference) {
        this.this$0 = seekBarPreference;
    }

    @Override // android.widget.SeekBar$OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z2) {
        if (z2) {
            SeekBarPreference seekBarPreference = this.this$0;
            if (seekBarPreference.mUpdatesContinuously || !seekBarPreference.mTrackingTouch) {
                seekBarPreference.syncValueInternal(seekBar);
                return;
            }
        }
        SeekBarPreference seekBarPreference2 = this.this$0;
        seekBarPreference2.updateLabelValue(i + seekBarPreference2.mMin);
    }

    @Override // android.widget.SeekBar$OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        this.this$0.mTrackingTouch = true;
    }

    @Override // android.widget.SeekBar$OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        this.this$0.mTrackingTouch = false;
        int progress = seekBar.getProgress();
        SeekBarPreference seekBarPreference = this.this$0;
        if (progress + seekBarPreference.mMin != seekBarPreference.mSeekBarValue) {
            seekBarPreference.syncValueInternal(seekBar);
        }
    }
}
