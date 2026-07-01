package com.discord.widgets.media;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.discord.R;
import com.discord.databinding.WidgetMediaBinding;
import com.facebook.samples.zoomable.ZoomableDraweeView;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.material.appbar.AppBarLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.media.WidgetMedia$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetMedia.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetMedia2 extends FunctionReferenceImpl implements Function1<View, WidgetMediaBinding> {
    public static final WidgetMedia2 INSTANCE = new WidgetMedia2();

    public WidgetMedia2() {
        super(1, WidgetMediaBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetMediaBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetMediaBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.action_bar_toolbar_layout;
        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.action_bar_toolbar_layout);
        if (appBarLayout != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            i = R.id.media_image;
            ZoomableDraweeView zoomableDraweeView = (ZoomableDraweeView) view.findViewById(R.id.media_image);
            if (zoomableDraweeView != null) {
                i = R.id.media_loading_indicator;
                ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.media_loading_indicator);
                if (progressBar != null) {
                    i = R.id.media_player_control_view;
                    PlayerControlView playerControlView = (PlayerControlView) view.findViewById(R.id.media_player_control_view);
                    if (playerControlView != null) {
                        i = R.id.media_player_view;
                        PlayerView playerView = (PlayerView) view.findViewById(R.id.media_player_view);
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
