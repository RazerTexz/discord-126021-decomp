package com.discord.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.AnimRes;
import b.a.i.ViewServerFolderBinding;
import com.discord.R;
import com.discord.utilities.accessibility.AccessibilityUtils;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: ServerFolderView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerFolderView extends LinearLayout {
    public static final /* synthetic */ int j = 0;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final ViewServerFolderBinding binding;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public Long folderId;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public boolean isOpen;

    /* JADX INFO: compiled from: ServerFolderView.kt */
    public static final class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ServerFolderView serverFolderView = ServerFolderView.this;
            int i = ServerFolderView.j;
            serverFolderView.a();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerFolderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.view_server_folder, this);
        int i = R.id.folder_view_folder_image;
        ImageView imageView = (ImageView) findViewById(R.id.folder_view_folder_image);
        if (imageView != null) {
            i = R.id.guild_view_1;
            GuildView guildView = (GuildView) findViewById(R.id.guild_view_1);
            if (guildView != null) {
                i = R.id.guild_view_2;
                GuildView guildView2 = (GuildView) findViewById(R.id.guild_view_2);
                if (guildView2 != null) {
                    i = R.id.guild_view_3;
                    GuildView guildView3 = (GuildView) findViewById(R.id.guild_view_3);
                    if (guildView3 != null) {
                        i = R.id.guild_view_4;
                        GuildView guildView4 = (GuildView) findViewById(R.id.guild_view_4);
                        if (guildView4 != null) {
                            i = R.id.guild_views;
                            GridLayout gridLayout = (GridLayout) findViewById(R.id.guild_views);
                            if (gridLayout != null) {
                                ViewServerFolderBinding viewServerFolderBinding = new ViewServerFolderBinding(this, imageView, guildView, guildView2, guildView3, guildView4, gridLayout);
                                Intrinsics3.checkNotNullExpressionValue(viewServerFolderBinding, "ViewServerFolderBinding.…ater.from(context), this)");
                                this.binding = viewServerFolderBinding;
                                setOrientation(1);
                                return;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    public final void a() {
        if (this.isOpen) {
            ImageView imageView = this.binding.f126b;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.folderViewFolderImage");
            imageView.setVisibility(0);
            GridLayout gridLayout = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(gridLayout, "binding.guildViews");
            gridLayout.setVisibility(8);
            return;
        }
        ImageView imageView2 = this.binding.f126b;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.folderViewFolderImage");
        imageView2.setVisibility(8);
        GridLayout gridLayout2 = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(gridLayout2, "binding.guildViews");
        gridLayout2.setVisibility(0);
    }

    public final void b(@AnimRes int animationId) {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), animationId);
        animationLoadAnimation.setAnimationListener(new a());
        if (AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
            Intrinsics3.checkNotNullExpressionValue(animationLoadAnimation, "animation");
            animationLoadAnimation.setDuration(0L);
        }
        ImageView imageView = this.binding.f126b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.folderViewFolderImage");
        imageView.setVisibility(0);
        GridLayout gridLayout = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(gridLayout, "binding.guildViews");
        gridLayout.setVisibility(0);
        this.binding.f126b.startAnimation(animationLoadAnimation);
    }
}
