package com.discord.widgets.settings.profile;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEditUserOrGuildMemberProfile$configureAvatarSelect$2$1 extends o implements Function1<Integer, Unit> {
    public final /* synthetic */ WidgetEditUserOrGuildMemberProfile$configureAvatarSelect$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEditUserOrGuildMemberProfile$configureAvatarSelect$2$1(WidgetEditUserOrGuildMemberProfile$configureAvatarSelect$2 widgetEditUserOrGuildMemberProfile$configureAvatarSelect$2) {
        super(1);
        this.this$0 = widgetEditUserOrGuildMemberProfile$configureAvatarSelect$2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        if (i != 0) {
            if (i != 1) {
                return;
            }
            WidgetEditUserOrGuildMemberProfile.access$getViewModel$p(this.this$0.this$0).updateAvatar(null);
        } else {
            WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile = this.this$0.this$0;
            WidgetEditUserOrGuildMemberProfile.access$setImageSelectedResult$p(widgetEditUserOrGuildMemberProfile, WidgetEditUserOrGuildMemberProfile.access$getAvatarSelectedResult$p(widgetEditUserOrGuildMemberProfile));
            this.this$0.this$0.openMediaChooser();
        }
    }
}
