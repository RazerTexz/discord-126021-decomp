package com.discord.widgets.settings.profile;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEditUserOrGuildMemberProfile$onViewBoundOrOnResume$2 extends o implements Function1<SettingsUserProfileViewModel$Event, Unit> {
    public final /* synthetic */ WidgetEditUserOrGuildMemberProfile this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEditUserOrGuildMemberProfile$onViewBoundOrOnResume$2(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile) {
        super(1);
        this.this$0 = widgetEditUserOrGuildMemberProfile;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SettingsUserProfileViewModel$Event settingsUserProfileViewModel$Event) {
        invoke2(settingsUserProfileViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SettingsUserProfileViewModel$Event settingsUserProfileViewModel$Event) {
        m.checkNotNullParameter(settingsUserProfileViewModel$Event, "event");
        WidgetEditUserOrGuildMemberProfile.access$handleEvent(this.this$0, settingsUserProfileViewModel$Event);
    }
}
