package com.discord.widgets.guilds.invite;

import androidx.annotation.IdRes;
import com.discord.R;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteSettings$ChannelsSpinnerAdapter$setupViews$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildInviteSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteSettings2 extends Lambda implements Function0<Integer> {
    public final /* synthetic */ boolean $dropDownMode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInviteSettings2(boolean z2) {
        super(0);
        this.$dropDownMode = z2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(invoke2());
    }

    @IdRes
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2() {
        return this.$dropDownMode ? R.id.channel_spinner_dropdown_item_textview : R.id.channel_spinner_item_textview;
    }
}
