package com.discord.widgets.media;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.discord.R$id;
import com.discord.databinding.WidgetMediaBinding;
import com.facebook.samples.zoomable.ZoomableDraweeView;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.material.appbar.AppBarLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetMedia.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetMedia$binding$2 extends k implements Function1<View, WidgetMediaBinding> {
    public static final WidgetMedia$binding$2 INSTANCE = new WidgetMedia$binding$2();

    public WidgetMedia$binding$2() {
        super(1, WidgetMediaBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetMediaBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetMediaBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetMediaBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = 2131361879;
        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(2131361879);
        if (appBarLayout != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            i = R$id.media_image;
            ZoomableDraweeView zoomableDraweeView = (ZoomableDraweeView) view.findViewById(R$id.media_image);
            if (zoomableDraweeView != null) {
                i = R$id.media_loading_indicator;
                ProgressBar progressBar = (ProgressBar) view.findViewById(R$id.media_loading_indicator);
                if (progressBar != null) {
                    i = R$id.media_player_control_view;
                    PlayerControlView playerControlView = (PlayerControlView) view.findViewById(R$id.media_player_control_view);
                    if (playerControlView != null) {
                        i = R$id.media_player_view;
                        PlayerView playerView = (PlayerView) view.findViewById(R$id.media_player_view);
                        if (playerView != null) {
                            return new WidgetMediaBinding(frameLayout, appBarLayout, frameLayout, zoomableDraweeView, progressBar, playerControlView, playerView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
