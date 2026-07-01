package com.discord.widgets.settings.profile;

import com.discord.utilities.color.ColorCompat;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEditUserOrGuildMemberProfile$onViewBound$4 extends o implements Function1<Integer, Unit> {
    public final /* synthetic */ WidgetEditUserOrGuildMemberProfile this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEditUserOrGuildMemberProfile$onViewBound$4(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile) {
        super(1);
        this.this$0 = widgetEditUserOrGuildMemberProfile;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        WidgetEditUserOrGuildMemberProfile.access$getAvatarRepresentativeColorHexSubject$p(this.this$0).onNext(ColorCompat.INSTANCE.getColorHexFromColorInt(i));
    }
}
