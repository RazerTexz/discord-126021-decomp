package com.discord.widgets.guilds.invite;

import android.content.Context;
import com.discord.utilities.resources.DurationUtilsKt;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ViewInviteSettingsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewInviteSettingsSheet$1 extends o implements Function1<Integer, CharSequence> {
    public final /* synthetic */ ViewInviteSettingsSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewInviteSettingsSheet$1(ViewInviteSettingsSheet viewInviteSettingsSheet) {
        super(1);
        this.this$0 = viewInviteSettingsSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final CharSequence invoke(int i) {
        Context context = this.this$0.getContext();
        m.checkNotNullExpressionValue(context, "context");
        return DurationUtilsKt.formatInviteExpireAfterString(context, i);
    }
}
