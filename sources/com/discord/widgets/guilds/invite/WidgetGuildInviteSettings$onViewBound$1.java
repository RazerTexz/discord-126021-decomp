package com.discord.widgets.guilds.invite;

import com.discord.utilities.resources.DurationUtilsKt;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildInviteSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteSettings$onViewBound$1 extends o implements Function1<Integer, CharSequence> {
    public final /* synthetic */ WidgetGuildInviteSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInviteSettings$onViewBound$1(WidgetGuildInviteSettings widgetGuildInviteSettings) {
        super(1);
        this.this$0 = widgetGuildInviteSettings;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final CharSequence invoke(int i) {
        return DurationUtilsKt.formatInviteExpireAfterString(this.this$0.requireContext(), i);
    }
}
