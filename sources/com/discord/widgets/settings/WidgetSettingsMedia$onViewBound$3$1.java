package com.discord.widgets.settings;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import b.a.a.b.c;
import b.a.a.b.c$b;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsMedia.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsMedia$onViewBound$3$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetSettingsMedia$onViewBound$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsMedia$onViewBound$3$1(WidgetSettingsMedia$onViewBound$3 widgetSettingsMedia$onViewBound$3) {
        super(1);
        this.this$0 = widgetSettingsMedia$onViewBound$3;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        c$b c_b = c.k;
        FragmentManager childFragmentManager = this.this$0.this$0.getChildFragmentManager();
        m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        c$b.a(c_b, childFragmentManager, 3, null, null, null, "Image Compression Settings", null, null, false, false, 988);
    }
}
