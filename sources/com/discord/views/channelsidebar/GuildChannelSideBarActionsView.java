package com.discord.views.channelsidebar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.discord.C5419R;
import com.discord.utilities.drawable.DrawableCompat;
import com.google.android.material.button.MaterialButton;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p000.C12929o;
import p007b.p008a.p025i.C1079x;
import p007b.p008a.p062y.p064k0.ViewOnClickListenerC1354a;
import p007b.p008a.p062y.p064k0.ViewOnClickListenerC1355b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildChannelSideBarActionsView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildChannelSideBarActionsView extends LinearLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final C1079x binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildChannelSideBarActionsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(C5419R.layout.guild_channel_side_bar_actions_view, this);
        int i = C5419R.id.channel_sidebar_actions_notifications;
        MaterialButton materialButton = (MaterialButton) findViewById(C5419R.id.channel_sidebar_actions_notifications);
        if (materialButton != null) {
            i = C5419R.id.channel_sidebar_actions_pins;
            MaterialButton materialButton2 = (MaterialButton) findViewById(C5419R.id.channel_sidebar_actions_pins);
            if (materialButton2 != null) {
                i = C5419R.id.channel_sidebar_actions_search_or_threads;
                MaterialButton materialButton3 = (MaterialButton) findViewById(C5419R.id.channel_sidebar_actions_search_or_threads);
                if (materialButton3 != null) {
                    i = C5419R.id.channel_sidebar_actions_settings;
                    MaterialButton materialButton4 = (MaterialButton) findViewById(C5419R.id.channel_sidebar_actions_settings);
                    if (materialButton4 != null) {
                        C1079x c1079x = new C1079x(this, materialButton, materialButton2, materialButton3, materialButton4);
                        C12238m.checkNotNullExpressionValue(c1079x, "GuildChannelSideBarActio…ater.from(context), this)");
                        this.binding = c1079x;
                        m8589a(C12929o.f27504j, C12929o.f27505k, C12929o.f27506l, C12929o.f27507m, C12929o.f27508n, false, false, false, true);
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    /* JADX INFO: renamed from: a */
    public final void m8589a(Function1<? super View, Unit> onSearchClicked, Function1<? super View, Unit> onThreadBrowserClicked, Function1<? super View, Unit> onNotificationsClicked, Function1<? super View, Unit> onPinsClicked, Function1<? super View, Unit> onSettingsClicked, boolean hasUnseenPins, boolean channelIsMuted, boolean disablePins, boolean showSearch) {
        C12238m.checkNotNullParameter(onSearchClicked, "onSearchClicked");
        C12238m.checkNotNullParameter(onThreadBrowserClicked, "onThreadBrowserClicked");
        C12238m.checkNotNullParameter(onNotificationsClicked, "onNotificationsClicked");
        C12238m.checkNotNullParameter(onPinsClicked, "onPinsClicked");
        C12238m.checkNotNullParameter(onSettingsClicked, "onSettingsClicked");
        int themedDrawableRes$default = hasUnseenPins ? DrawableCompat.getThemedDrawableRes$default(this, C5419R.attr.ic_sidebar_pins_on_24dp, 0, 2, (Object) null) : DrawableCompat.getThemedDrawableRes$default(this, C5419R.attr.ic_sidebar_pins_off_24dp, 0, 2, (Object) null);
        int themedDrawableRes$default2 = channelIsMuted ? DrawableCompat.getThemedDrawableRes$default(this, C5419R.attr.ic_sidebar_notifications_off_24dp, 0, 2, (Object) null) : DrawableCompat.getThemedDrawableRes$default(this, C5419R.attr.ic_sidebar_notifications_on_24dp, 0, 2, (Object) null);
        if (showSearch) {
            MaterialButton materialButton = this.binding.f1365d;
            C12238m.checkNotNullExpressionValue(materialButton, "binding.channelSidebarActionsSearchOrThreads");
            DrawableCompat.setCompoundDrawablesCompat$default(materialButton, 0, C5419R.drawable.ic_sidebar_search_24dp, 0, 0, 13, (Object) null);
            this.binding.f1365d.setOnClickListener(new ViewOnClickListenerC1354a(onSearchClicked));
            MaterialButton materialButton2 = this.binding.f1365d;
            C12238m.checkNotNullExpressionValue(materialButton2, "binding.channelSidebarActionsSearchOrThreads");
            materialButton2.setText(getContext().getString(C5419R.string.search));
        } else {
            MaterialButton materialButton3 = this.binding.f1365d;
            C12238m.checkNotNullExpressionValue(materialButton3, "binding.channelSidebarActionsSearchOrThreads");
            DrawableCompat.setCompoundDrawablesCompat$default(materialButton3, 0, C5419R.drawable.ic_thread, 0, 0, 13, (Object) null);
            this.binding.f1365d.setOnClickListener(new ViewOnClickListenerC1354a(onThreadBrowserClicked));
            MaterialButton materialButton4 = this.binding.f1365d;
            C12238m.checkNotNullExpressionValue(materialButton4, "binding.channelSidebarActionsSearchOrThreads");
            materialButton4.setText(getContext().getString(C5419R.string.threads));
        }
        this.binding.f1366e.setOnClickListener(new ViewOnClickListenerC1354a(onSettingsClicked));
        MaterialButton materialButton5 = this.binding.f1364c;
        DrawableCompat.setCompoundDrawablesCompat(materialButton5, (Drawable) null, ContextCompat.getDrawable(materialButton5.getContext(), themedDrawableRes$default), (Drawable) null, (Drawable) null);
        materialButton5.setOnClickListener(new ViewOnClickListenerC1355b(onPinsClicked));
        MaterialButton materialButton6 = this.binding.f1364c;
        C12238m.checkNotNullExpressionValue(materialButton6, "binding.channelSidebarActionsPins");
        materialButton6.setEnabled(!disablePins);
        MaterialButton materialButton7 = this.binding.f1363b;
        DrawableCompat.setCompoundDrawablesCompat(materialButton7, (Drawable) null, ContextCompat.getDrawable(materialButton7.getContext(), themedDrawableRes$default2), (Drawable) null, (Drawable) null);
        materialButton7.setOnClickListener(new ViewOnClickListenerC1355b(onNotificationsClicked));
        materialButton7.setContentDescription(channelIsMuted ? materialButton7.getContext().getString(C5419R.string.notifications_muted) : materialButton7.getContext().getString(C5419R.string.notifications));
    }
}
