package com.discord.widgets.emoji;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.guild.Guild;
import com.discord.utilities.analytics.Traits$Location$Section;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.discord.widgets.settings.premium.WidgetSettingsPremium$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetEmojiSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiSheet$configureButtons$$inlined$with$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ Guild $guild$inlined;
    public final /* synthetic */ boolean $isUserInGuild$inlined;
    public final /* synthetic */ boolean $isUserPremium$inlined;
    public final /* synthetic */ WidgetEmojiSheet this$0;

    public WidgetEmojiSheet$configureButtons$$inlined$with$lambda$1(WidgetEmojiSheet widgetEmojiSheet, Guild guild, boolean z2, boolean z3) {
        this.this$0 = widgetEmojiSheet;
        this.$guild$inlined = guild;
        this.$isUserPremium$inlined = z2;
        this.$isUserInGuild$inlined = z3;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
        WidgetSettingsPremium$Companion widgetSettingsPremium$Companion = WidgetSettingsPremium.Companion;
        Context contextRequireContext = this.this$0.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        WidgetSettingsPremium$Companion.launch$default(widgetSettingsPremium$Companion, contextRequireContext, null, Traits$Location$Section.EMOJI_SHEET_UPSELL, 2, null);
    }
}
