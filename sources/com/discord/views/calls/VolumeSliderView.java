package com.discord.views.calls;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import b.a.i.VolumeSliderViewBinding;
import b.a.y.OnSeekBarChangeListenerAdapter;
import com.discord.R;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompat2;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: VolumeSliderView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VolumeSliderView extends LinearLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final VolumeSliderViewBinding binding;

    /* JADX INFO: compiled from: VolumeSliderView.kt */
    public static final class a extends OnSeekBarChangeListenerAdapter {
        public final /* synthetic */ Function2 a;

        public a(Function2 function2) {
            this.a = function2;
        }

        @Override // b.a.y.OnSeekBarChangeListenerAdapter, android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z2) {
            Intrinsics3.checkNotNullParameter(seekBar, "seekBar");
            this.a.invoke(Float.valueOf(i), Boolean.valueOf(z2));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VolumeSliderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.volume_slider_view, this);
        int i = R.id.volume_slider_max_vol;
        ImageView imageView = (ImageView) findViewById(R.id.volume_slider_max_vol);
        if (imageView != null) {
            i = R.id.volume_slider_min_vol;
            ImageView imageView2 = (ImageView) findViewById(R.id.volume_slider_min_vol);
            if (imageView2 != null) {
                i = R.id.volume_slider_seek_bar;
                SeekBar seekBar = (SeekBar) findViewById(R.id.volume_slider_seek_bar);
                if (seekBar != null) {
                    VolumeSliderViewBinding volumeSliderViewBinding = new VolumeSliderViewBinding(this, imageView, imageView2, seekBar);
                    Intrinsics3.checkNotNullExpressionValue(volumeSliderViewBinding, "VolumeSliderViewBinding.…ater.from(context), this)");
                    this.binding = volumeSliderViewBinding;
                    if (attributeSet != null) {
                        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.a.VolumeSliderView, 0, 0);
                        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…e.VolumeSliderView, 0, 0)");
                        int i2 = typedArrayObtainStyledAttributes.getInt(1, 100);
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
                        if (resourceId != -1) {
                            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.volumeSliderMinVol");
                            ColorCompat2.tintWithColor(imageView2, ColorCompat.getColor(getContext(), resourceId));
                            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.volumeSliderMaxVol");
                            ColorCompat2.tintWithColor(imageView, ColorCompat.getColor(getContext(), resourceId));
                        }
                        Intrinsics3.checkNotNullExpressionValue(seekBar, "binding.volumeSliderSeekBar");
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
        Intrinsics3.checkNotNullParameter(onVolumeChanged, "onVolumeChanged");
        this.binding.d.setOnSeekBarChangeListener(new a(onVolumeChanged));
    }
}
