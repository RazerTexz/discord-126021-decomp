package b.a.y;

import android.widget.SeekBar;
import android.widget.SeekBar$OnSeekBarChangeListener;

/* JADX INFO: compiled from: OnSeekBarChangeListenerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public class j implements SeekBar$OnSeekBarChangeListener {
    @Override // android.widget.SeekBar$OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z2) {
        d0.z.d.m.checkNotNullParameter(seekBar, "seekBar");
    }

    @Override // android.widget.SeekBar$OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        d0.z.d.m.checkNotNullParameter(seekBar, "seekBar");
    }

    @Override // android.widget.SeekBar$OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        d0.z.d.m.checkNotNullParameter(seekBar, "seekBar");
    }
}
