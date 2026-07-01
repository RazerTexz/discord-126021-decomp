package com.discord.views.channelsidebar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import b.a.i.x;
import b.a.y.k0.a;
import b.a.y.k0.b;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.utilities.drawable.DrawableCompat;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;
import defpackage.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildChannelSideBarActionsView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildChannelSideBarActionsView extends LinearLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final x binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildChannelSideBarActionsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R$layout.guild_channel_side_bar_actions_view, this);
        int i = R$id.channel_sidebar_actions_notifications;
        MaterialButton materialButton = (MaterialButton) findViewById(R$id.channel_sidebar_actions_notifications);
        if (materialButton != null) {
            i = R$id.channel_sidebar_actions_pins;
            MaterialButton materialButton2 = (MaterialButton) findViewById(R$id.channel_sidebar_actions_pins);
            if (materialButton2 != null) {
                i = R$id.channel_sidebar_actions_search_or_threads;
                MaterialButton materialButton3 = (MaterialButton) findViewById(R$id.channel_sidebar_actions_search_or_threads);
                if (materialButton3 != null) {
                    i = R$id.channel_sidebar_actions_settings;
                    MaterialButton materialButton4 = (MaterialButton) findViewById(R$id.channel_sidebar_actions_settings);
                    if (materialButton4 != null) {
                        x xVar = new x(this, materialButton, materialButton2, materialButton3, materialButton4);
                        m.checkNotNullExpressionValue(xVar, "GuildChannelSideBarActio…ater.from(context), this)");
                        this.binding = xVar;
                        a(o.j, o.k, o.l, o.m, o.n, false, false, false, true);
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    public final void a(Function1<? super View, Unit> onSearchClicked, Function1<? super View, Unit> onThreadBrowserClicked, Function1<? super View, Unit> onNotificationsClicked, Function1<? super View, Unit> onPinsClicked, Function1<? super View, Unit> onSettingsClicked, boolean hasUnseenPins, boolean channelIsMuted, boolean disablePins, boolean showSearch) {
        m.checkNotNullParameter(onSearchClicked, "onSearchClicked");
        m.checkNotNullParameter(onThreadBrowserClicked, "onThreadBrowserClicked");
        m.checkNotNullParameter(onNotificationsClicked, "onNotificationsClicked");
        m.checkNotNullParameter(onPinsClicked, "onPinsClicked");
        m.checkNotNullParameter(onSettingsClicked, "onSettingsClicked");
        int themedDrawableRes$default = hasUnseenPins ? DrawableCompat.getThemedDrawableRes$default(this, 2130969545, 0, 2, (Object) null) : DrawableCompat.getThemedDrawableRes$default(this, 2130969544, 0, 2, (Object) null);
        int themedDrawableRes$default2 = channelIsMuted ? DrawableCompat.getThemedDrawableRes$default(this, 2130969542, 0, 2, (Object) null) : DrawableCompat.getThemedDrawableRes$default(this, 2130969543, 0, 2, (Object) null);
        if (showSearch) {
            MaterialButton materialButton = this.binding.d;
            m.checkNotNullExpressionValue(materialButton, "binding.channelSidebarActionsSearchOrThreads");
            DrawableCompat.setCompoundDrawablesCompat$default(materialButton, 0, 2131232128, 0, 0, 13, (Object) null);
            this.binding.d.setOnClickListener(new a(onSearchClicked));
            MaterialButton materialButton2 = this.binding.d;
            m.checkNotNullExpressionValue(materialButton2, "binding.channelSidebarActionsSearchOrThreads");
            materialButton2.setText(getContext().getString(2131895292));
        } else {
            MaterialButton materialButton3 = this.binding.d;
            m.checkNotNullExpressionValue(materialButton3, "binding.channelSidebarActionsSearchOrThreads");
            DrawableCompat.setCompoundDrawablesCompat$default(materialButton3, 0, 2131232193, 0, 0, 13, (Object) null);
            this.binding.d.setOnClickListener(new a(onThreadBrowserClicked));
            MaterialButton materialButton4 = this.binding.d;
            m.checkNotNullExpressionValue(materialButton4, "binding.channelSidebarActionsSearchOrThreads");
            materialButton4.setText(getContext().getString(2131896399));
        }
        this.binding.e.setOnClickListener(new a(onSettingsClicked));
        MaterialButton materialButton5 = this.binding.c;
        DrawableCompat.setCompoundDrawablesCompat(materialButton5, (Drawable) null, ContextCompat.getDrawable(materialButton5.getContext(), themedDrawableRes$default), (Drawable) null, (Drawable) null);
        materialButton5.setOnClickListener(new b(onPinsClicked));
        MaterialButton materialButton6 = this.binding.c;
        m.checkNotNullExpressionValue(materialButton6, "binding.channelSidebarActionsPins");
        materialButton6.setEnabled(!disablePins);
        MaterialButton materialButton7 = this.binding.f226b;
        DrawableCompat.setCompoundDrawablesCompat(materialButton7, (Drawable) null, ContextCompat.getDrawable(materialButton7.getContext(), themedDrawableRes$default2), (Drawable) null, (Drawable) null);
        materialButton7.setOnClickListener(new b(onNotificationsClicked));
        materialButton7.setContentDescription(channelIsMuted ? materialButton7.getContext().getString(2131893386) : materialButton7.getContext().getString(2131893385));
    }
}
