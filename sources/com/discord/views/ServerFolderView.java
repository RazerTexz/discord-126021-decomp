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
import com.discord.C5419R;
import com.discord.utilities.accessibility.AccessibilityUtils;
import p007b.p008a.p025i.C0971h3;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ServerFolderView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerFolderView extends LinearLayout {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ int f19145j = 0;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final C0971h3 binding;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public Long folderId;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public boolean isOpen;

    /* JADX INFO: renamed from: com.discord.views.ServerFolderView$a */
    /* JADX INFO: compiled from: ServerFolderView.kt */
    public static final class AnimationAnimationListenerC7092a implements Animation.AnimationListener {
        public AnimationAnimationListenerC7092a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ServerFolderView serverFolderView = ServerFolderView.this;
            int i = ServerFolderView.f19145j;
            serverFolderView.m8555a();
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
        C12238m.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(C5419R.layout.view_server_folder, this);
        int i = C5419R.id.folder_view_folder_image;
        ImageView imageView = (ImageView) findViewById(C5419R.id.folder_view_folder_image);
        if (imageView != null) {
            i = C5419R.id.guild_view_1;
            GuildView guildView = (GuildView) findViewById(C5419R.id.guild_view_1);
            if (guildView != null) {
                i = C5419R.id.guild_view_2;
                GuildView guildView2 = (GuildView) findViewById(C5419R.id.guild_view_2);
                if (guildView2 != null) {
                    i = C5419R.id.guild_view_3;
                    GuildView guildView3 = (GuildView) findViewById(C5419R.id.guild_view_3);
                    if (guildView3 != null) {
                        i = C5419R.id.guild_view_4;
                        GuildView guildView4 = (GuildView) findViewById(C5419R.id.guild_view_4);
                        if (guildView4 != null) {
                            i = C5419R.id.guild_views;
                            GridLayout gridLayout = (GridLayout) findViewById(C5419R.id.guild_views);
                            if (gridLayout != null) {
                                C0971h3 c0971h3 = new C0971h3(this, imageView, guildView, guildView2, guildView3, guildView4, gridLayout);
                                C12238m.checkNotNullExpressionValue(c0971h3, "ViewServerFolderBinding.…ater.from(context), this)");
                                this.binding = c0971h3;
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

    /* JADX INFO: renamed from: a */
    public final void m8555a() {
        if (this.isOpen) {
            ImageView imageView = this.binding.f906b;
            C12238m.checkNotNullExpressionValue(imageView, "binding.folderViewFolderImage");
            imageView.setVisibility(0);
            GridLayout gridLayout = this.binding.f911g;
            C12238m.checkNotNullExpressionValue(gridLayout, "binding.guildViews");
            gridLayout.setVisibility(8);
            return;
        }
        ImageView imageView2 = this.binding.f906b;
        C12238m.checkNotNullExpressionValue(imageView2, "binding.folderViewFolderImage");
        imageView2.setVisibility(8);
        GridLayout gridLayout2 = this.binding.f911g;
        C12238m.checkNotNullExpressionValue(gridLayout2, "binding.guildViews");
        gridLayout2.setVisibility(0);
    }

    /* JADX INFO: renamed from: b */
    public final void m8556b(@AnimRes int animationId) {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), animationId);
        animationLoadAnimation.setAnimationListener(new AnimationAnimationListenerC7092a());
        if (AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
            C12238m.checkNotNullExpressionValue(animationLoadAnimation, "animation");
            animationLoadAnimation.setDuration(0L);
        }
        ImageView imageView = this.binding.f906b;
        C12238m.checkNotNullExpressionValue(imageView, "binding.folderViewFolderImage");
        imageView.setVisibility(0);
        GridLayout gridLayout = this.binding.f911g;
        C12238m.checkNotNullExpressionValue(gridLayout, "binding.guildViews");
        gridLayout.setVisibility(0);
        this.binding.f906b.startAnimation(animationLoadAnimation);
    }
}
