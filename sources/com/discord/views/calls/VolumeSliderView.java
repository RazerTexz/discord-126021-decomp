package com.discord.views.calls;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import b.a.i.l4;
import com.discord.R$a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompatKt;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: VolumeSliderView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VolumeSliderView extends LinearLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final l4 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VolumeSliderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R$layout.volume_slider_view, this);
        int i = R$id.volume_slider_max_vol;
        ImageView imageView = (ImageView) findViewById(R$id.volume_slider_max_vol);
        if (imageView != null) {
            i = R$id.volume_slider_min_vol;
            ImageView imageView2 = (ImageView) findViewById(R$id.volume_slider_min_vol);
            if (imageView2 != null) {
                i = R$id.volume_slider_seek_bar;
                SeekBar seekBar = (SeekBar) findViewById(R$id.volume_slider_seek_bar);
                if (seekBar != null) {
                    l4 l4Var = new l4(this, imageView, imageView2, seekBar);
                    m.checkNotNullExpressionValue(l4Var, "VolumeSliderViewBinding.…ater.from(context), this)");
                    this.binding = l4Var;
                    if (attributeSet != null) {
                        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$a.VolumeSliderView, 0, 0);
                        m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…e.VolumeSliderView, 0, 0)");
                        int i2 = typedArrayObtainStyledAttributes.getInt(1, 100);
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
                        if (resourceId != -1) {
                            m.checkNotNullExpressionValue(imageView2, "binding.volumeSliderMinVol");
                            ColorCompatKt.tintWithColor(imageView2, ColorCompat.getColor(getContext(), resourceId));
                            m.checkNotNullExpressionValue(imageView, "binding.volumeSliderMaxVol");
                            ColorCompatKt.tintWithColor(imageView, ColorCompat.getColor(getContext(), resourceId));
                        }
                        m.checkNotNullExpressionValue(seekBar, "binding.volumeSliderSeekBar");
                        seekBar.setMax(i2);
                        typedArrayObtainStyledAttributes.recycle();
                        return;
                    }
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    public final void setOnVolumeChange(Function2<? super Float, ? super Boolean, Unit> onVolumeChanged) {
        m.checkNotNullParameter(onVolumeChanged, "onVolumeChanged");
        this.binding.d.setOnSeekBarChangeListener(new VolumeSliderView$a(onVolumeChanged));
    }
}
