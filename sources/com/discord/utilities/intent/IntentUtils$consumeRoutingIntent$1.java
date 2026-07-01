package com.discord.utilities.intent;

import android.net.Uri;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: IntentUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IntentUtils$consumeRoutingIntent$1 extends o implements Function2<Uri, Boolean, Unit> {
    public static final IntentUtils$consumeRoutingIntent$1 INSTANCE = new IntentUtils$consumeRoutingIntent$1();

    public IntentUtils$consumeRoutingIntent$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Uri uri, Boolean bool) {
        invoke(uri, bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(Uri uri, boolean z2) {
        m.checkNotNullParameter(uri, "<anonymous parameter 0>");
    }
}
