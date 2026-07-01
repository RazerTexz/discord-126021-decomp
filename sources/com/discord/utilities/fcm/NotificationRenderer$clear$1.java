package com.discord.utilities.fcm;

import android.content.Context;
import androidx.core.app.NotificationManagerCompat;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: NotificationRenderer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationRenderer$clear$1 extends o implements Function1<Integer, Unit> {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationRenderer$clear$1(Context context) {
        super(1);
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        Context context = this.$context;
        if (context != null) {
            NotificationManagerCompat.from(context).cancel(i);
        }
    }
}
