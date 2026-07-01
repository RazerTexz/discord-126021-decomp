package b.a.y;

import android.widget.SeekBar;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: b.a.y.j, reason: use source file name */
/* JADX INFO: compiled from: OnSeekBarChangeListenerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public class OnSeekBarChangeListenerAdapter implements SeekBar.OnSeekBarChangeListener {
    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z2) {
        Intrinsics3.checkNotNullParameter(seekBar, "seekBar");
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        Intrinsics3.checkNotNullParameter(seekBar, "seekBar");
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        Intrinsics3.checkNotNullParameter(seekBar, "seekBar");
    }
}
