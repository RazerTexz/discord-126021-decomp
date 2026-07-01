package com.discord.views.calls;

import android.widget.SeekBar;
import b.a.y.j;
import d0.z.d.m;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: VolumeSliderView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VolumeSliderView$a extends j {
    public final /* synthetic */ Function2 a;

    public VolumeSliderView$a(Function2 function2) {
        this.a = function2;
    }

    @Override // b.a.y.j, android.widget.SeekBar$OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z2) {
        m.checkNotNullParameter(seekBar, "seekBar");
        this.a.invoke(Float.valueOf(i), Boolean.valueOf(z2));
    }
}
