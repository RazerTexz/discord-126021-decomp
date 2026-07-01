package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: compiled from: VolumeSliderViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class l4 implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f154b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final SeekBar d;

    public l4(@NonNull View view, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull SeekBar seekBar) {
        this.a = view;
        this.f154b = imageView;
        this.c = imageView2;
        this.d = seekBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
