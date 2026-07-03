package com.discord.widgets.media;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.discord.C5419R;
import com.discord.databinding.WidgetMediaBinding;
import com.facebook.samples.zoomable.ZoomableDraweeView;
import com.google.android.exoplayer2.p505ui.PlayerControlView;
import com.google.android.exoplayer2.p505ui.PlayerView;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetMedia.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetMedia$binding$2 extends C12236k implements Function1<View, WidgetMediaBinding> {
    public static final WidgetMedia$binding$2 INSTANCE = new WidgetMedia$binding$2();

    public WidgetMedia$binding$2() {
        super(1, WidgetMediaBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetMediaBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetMediaBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.action_bar_toolbar_layout;
        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(C5419R.id.action_bar_toolbar_layout);
        if (appBarLayout != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            i = C5419R.id.media_image;
            ZoomableDraweeView zoomableDraweeView = (ZoomableDraweeView) view.findViewById(C5419R.id.media_image);
            if (zoomableDraweeView != null) {
                i = C5419R.id.media_loading_indicator;
                ProgressBar progressBar = (ProgressBar) view.findViewById(C5419R.id.media_loading_indicator);
                if (progressBar != null) {
                    i = C5419R.id.media_player_control_view;
                    PlayerControlView playerControlView = (PlayerControlView) view.findViewById(C5419R.id.media_player_control_view);
                    if (playerControlView != null) {
                        i = C5419R.id.media_player_view;
                        PlayerView playerView = (PlayerView) view.findViewById(C5419R.id.media_player_view);
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
