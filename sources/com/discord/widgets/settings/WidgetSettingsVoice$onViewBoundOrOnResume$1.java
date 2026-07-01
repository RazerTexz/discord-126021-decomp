package com.discord.widgets.settings;

import android.widget.SeekBar;
import b.a.y.j;
import com.discord.stores.StoreStream;
import com.discord.utilities.voice.PerceptualVolumeUtils;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsVoice.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsVoice$onViewBoundOrOnResume$1 extends j {
    @Override // b.a.y.j, android.widget.SeekBar$OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        m.checkNotNullParameter(seekBar, "seekBar");
        if (fromUser) {
            StoreStream.Companion.getMediaSettings().setOutputVolume(PerceptualVolumeUtils.perceptualToAmplitude$default(PerceptualVolumeUtils.INSTANCE, progress, 0.0f, 2, null));
        }
    }
}
