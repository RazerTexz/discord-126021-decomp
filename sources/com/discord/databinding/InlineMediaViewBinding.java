package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.exoplayer2.ui.PlayerView;

/* JADX INFO: loaded from: classes.dex */
public final class InlineMediaViewBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f2126b;

    @NonNull
    public final SimpleDraweeView c;

    @NonNull
    public final ProgressBar d;

    @NonNull
    public final ImageView e;

    @NonNull
    public final PlayerView f;

    @NonNull
    public final ImageView g;

    @NonNull
    public final View h;

    public InlineMediaViewBinding(@NonNull View view, @NonNull ImageView imageView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull ProgressBar progressBar, @NonNull ImageView imageView2, @NonNull PlayerView playerView, @NonNull ImageView imageView3, @NonNull View view2) {
        this.a = view;
        this.f2126b = imageView;
        this.c = simpleDraweeView;
        this.d = progressBar;
        this.e = imageView2;
        this.f = playerView;
        this.g = imageView3;
        this.h = view2;
    }

    @NonNull
    public static InlineMediaViewBinding a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        layoutInflater.inflate(R.layout.inline_media_view, viewGroup);
        int i = R.id.inline_media_gif_indicator;
        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.inline_media_gif_indicator);
        if (imageView != null) {
            i = R.id.inline_media_image_preview;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewGroup.findViewById(R.id.inline_media_image_preview);
            if (simpleDraweeView != null) {
                i = R.id.inline_media_loading_indicator;
                ProgressBar progressBar = (ProgressBar) viewGroup.findViewById(R.id.inline_media_loading_indicator);
                if (progressBar != null) {
                    i = R.id.inline_media_play_button;
                    ImageView imageView2 = (ImageView) viewGroup.findViewById(R.id.inline_media_play_button);
                    if (imageView2 != null) {
                        i = R.id.inline_media_player_view;
                        PlayerView playerView = (PlayerView) viewGroup.findViewById(R.id.inline_media_player_view);
                        if (playerView != null) {
                            i = R.id.inline_media_volume_toggle;
                            ImageView imageView3 = (ImageView) viewGroup.findViewById(R.id.inline_media_volume_toggle);
                            if (imageView3 != null) {
                                i = R.id.opacity_shim;
                                View viewFindViewById = viewGroup.findViewById(R.id.opacity_shim);
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
        return this.a;
    }
}
