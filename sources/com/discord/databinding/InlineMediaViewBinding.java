package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.exoplayer2.p505ui.PlayerView;

/* JADX INFO: loaded from: classes.dex */
public final class InlineMediaViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f15166a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f15167b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final SimpleDraweeView f15168c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ProgressBar f15169d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final ImageView f15170e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final PlayerView f15171f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final ImageView f15172g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final View f15173h;

    public InlineMediaViewBinding(@NonNull View view, @NonNull ImageView imageView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull ProgressBar progressBar, @NonNull ImageView imageView2, @NonNull PlayerView playerView, @NonNull ImageView imageView3, @NonNull View view2) {
        this.f15166a = view;
        this.f15167b = imageView;
        this.f15168c = simpleDraweeView;
        this.f15169d = progressBar;
        this.f15170e = imageView2;
        this.f15171f = playerView;
        this.f15172g = imageView3;
        this.f15173h = view2;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static InlineMediaViewBinding m8388a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        layoutInflater.inflate(C5419R.layout.inline_media_view, viewGroup);
        int i = C5419R.id.inline_media_gif_indicator;
        ImageView imageView = (ImageView) viewGroup.findViewById(C5419R.id.inline_media_gif_indicator);
        if (imageView != null) {
            i = C5419R.id.inline_media_image_preview;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewGroup.findViewById(C5419R.id.inline_media_image_preview);
            if (simpleDraweeView != null) {
                i = C5419R.id.inline_media_loading_indicator;
                ProgressBar progressBar = (ProgressBar) viewGroup.findViewById(C5419R.id.inline_media_loading_indicator);
                if (progressBar != null) {
                    i = C5419R.id.inline_media_play_button;
                    ImageView imageView2 = (ImageView) viewGroup.findViewById(C5419R.id.inline_media_play_button);
                    if (imageView2 != null) {
                        i = C5419R.id.inline_media_player_view;
                        PlayerView playerView = (PlayerView) viewGroup.findViewById(C5419R.id.inline_media_player_view);
                        if (playerView != null) {
                            i = C5419R.id.inline_media_volume_toggle;
                            ImageView imageView3 = (ImageView) viewGroup.findViewById(C5419R.id.inline_media_volume_toggle);
                            if (imageView3 != null) {
                                i = C5419R.id.opacity_shim;
                                View viewFindViewById = viewGroup.findViewById(C5419R.id.opacity_shim);
                                if (viewFindViewById != null) {
                                    return new InlineMediaViewBinding(viewGroup, imageView, simpleDraweeView, progressBar, imageView2, playerView, imageView3, viewFindViewById);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewGroup.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15166a;
    }
}
