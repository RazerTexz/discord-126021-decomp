package com.discord.widgets.stickers;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.guild.Guild;

/* JADX INFO: compiled from: WidgetGuildStickerSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildStickerSheet$configureButtons$$inlined$with$lambda$2 implements View$OnClickListener {
    public final /* synthetic */ Guild $guild$inlined;
    public final /* synthetic */ boolean $isUserInGuild$inlined;
    public final /* synthetic */ boolean $isUserPremium$inlined;
    public final /* synthetic */ WidgetGuildStickerSheet this$0;

    public WidgetGuildStickerSheet$configureButtons$$inlined$with$lambda$2(WidgetGuildStickerSheet widgetGuildStickerSheet, Guild guild, boolean z2, boolean z3) {
        this.this$0 = widgetGuildStickerSheet;
        this.$guild$inlined = guild;
        this.$isUserPremium$inlined = z2;
        this.$isUserInGuild$inlined = z3;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildStickerSheet.access$getViewModel$p(this.this$0).joinGuild(this.$guild$inlined, this.this$0);
    }
}
