package com.discord.widgets.user.usersheet;

import android.content.Context;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;

/* JADX INFO: compiled from: WidgetUserSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserSheet$configureUI$4 extends k implements Function5<Context, Long, String, Long, Integer, Unit> {
    public WidgetUserSheet$configureUI$4(WidgetUserSheetViewModel widgetUserSheetViewModel) {
        super(5, widgetUserSheetViewModel, WidgetUserSheetViewModel.class, "onActivityCustomButtonClicked", "onActivityCustomButtonClicked(Landroid/content/Context;JLjava/lang/String;JI)V", 0);
    }

    @Override // kotlin.jvm.functions.Function5
    public /* bridge */ /* synthetic */ Unit invoke(Context context, Long l, String str, Long l2, Integer num) {
        invoke(context, l.longValue(), str, l2.longValue(), num.intValue());
        return Unit.a;
    }

    public final void invoke(Context context, long j, String str, long j2, int i) {
        m.checkNotNullParameter(context, "p1");
        m.checkNotNullParameter(str, "p3");
        ((WidgetUserSheetViewModel) this.receiver).onActivityCustomButtonClicked(context, j, str, j2, i);
    }
}
