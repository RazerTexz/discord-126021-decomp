package com.discord.views.channelsidebar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View$OnClickListener;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import b.a.i.g1;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.utilities.drawable.DrawableCompat;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;
import defpackage.d;

/* JADX INFO: compiled from: PrivateChannelSideBarActionsView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PrivateChannelSideBarActionsView extends LinearLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final g1 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivateChannelSideBarActionsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R$layout.private_channel_side_bar_actions_view, this);
        int i = R$id.private_channel_sidebar_actions_call;
        MaterialButton materialButton = (MaterialButton) findViewById(R$id.private_channel_sidebar_actions_call);
        if (materialButton != null) {
            i = R$id.private_channel_sidebar_actions_notifications;
            MaterialButton materialButton2 = (MaterialButton) findViewById(R$id.private_channel_sidebar_actions_notifications);
            if (materialButton2 != null) {
                i = R$id.private_channel_sidebar_actions_search;
                MaterialButton materialButton3 = (MaterialButton) findViewById(R$id.private_channel_sidebar_actions_search);
                if (materialButton3 != null) {
                    i = R$id.private_channel_sidebar_actions_video;
                    MaterialButton materialButton4 = (MaterialButton) findViewById(R$id.private_channel_sidebar_actions_video);
                    if (materialButton4 != null) {
                        g1 g1Var = new g1(this, materialButton, materialButton2, materialButton3, materialButton4);
                        m.checkNotNullExpressionValue(g1Var, "PrivateChannelSideBarAct…ater.from(context), this)");
                        this.binding = g1Var;
                        a(d.j, d.k, d.l, d.m, false);
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    public final void a(View$OnClickListener onCallClicked, View$OnClickListener onVideoClicked, View$OnClickListener onNotificationsClicked, View$OnClickListener onSearchClicked, boolean channelIsMuted) {
        m.checkNotNullParameter(onCallClicked, "onCallClicked");
        m.checkNotNullParameter(onVideoClicked, "onVideoClicked");
        m.checkNotNullParameter(onNotificationsClicked, "onNotificationsClicked");
        m.checkNotNullParameter(onSearchClicked, "onSearchClicked");
        int themedDrawableRes$default = channelIsMuted ? DrawableCompat.getThemedDrawableRes$default(this, 2130969542, 0, 2, (Object) null) : DrawableCompat.getThemedDrawableRes$default(this, 2130969543, 0, 2, (Object) null);
        this.binding.f118b.setOnClickListener(onCallClicked);
        this.binding.e.setOnClickListener(onVideoClicked);
        MaterialButton materialButton = this.binding.c;
        DrawableCompat.setCompoundDrawablesCompat(materialButton, (Drawable) null, ContextCompat.getDrawable(materialButton.getContext(), themedDrawableRes$default), (Drawable) null, (Drawable) null);
        materialButton.setOnClickListener(onNotificationsClicked);
        this.binding.d.setOnClickListener(onSearchClicked);
    }
}
