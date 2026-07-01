package com.discord.widgets.settings.profile;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEditUserOrGuildMemberProfile$viewModel$2 extends o implements Function0<SettingsUserProfileViewModel> {
    public final /* synthetic */ WidgetEditUserOrGuildMemberProfile this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEditUserOrGuildMemberProfile$viewModel$2(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile) {
        super(0);
        this.this$0 = widgetEditUserOrGuildMemberProfile;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ SettingsUserProfileViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final SettingsUserProfileViewModel invoke() {
        return new SettingsUserProfileViewModel(WidgetEditUserOrGuildMemberProfile.access$getGuildId$p(this.this$0), null, null, null, null, null, null, 126, null);
    }
}
