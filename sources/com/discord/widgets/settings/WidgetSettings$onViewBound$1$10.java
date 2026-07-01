package com.discord.widgets.settings;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.app.AppTransitionActivity$Transition;
import com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile;
import com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$Companion;

/* JADX INFO: compiled from: WidgetSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettings$onViewBound$1$10 implements View$OnClickListener {
    public static final WidgetSettings$onViewBound$1$10 INSTANCE = new WidgetSettings$onViewBound$1$10();

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetEditUserOrGuildMemberProfile$Companion.launch$default(WidgetEditUserOrGuildMemberProfile.Companion, a.x(view, "it", "it.context"), AppTransitionActivity$Transition.TYPE_SLIDE_HORIZONTAL, null, 4, null);
    }
}
