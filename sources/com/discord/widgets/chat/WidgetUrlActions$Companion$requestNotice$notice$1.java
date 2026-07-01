package com.discord.widgets.chat;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUrlActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetUrlActions$Companion$requestNotice$notice$1 extends o implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ String $url;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUrlActions$Companion$requestNotice$notice$1(String str) {
        super(1);
        this.$url = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        m.checkNotNullParameter(fragmentActivity, "fragmentActivity");
        WidgetUrlActions$Companion widgetUrlActions$Companion = WidgetUrlActions.Companion;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        m.checkNotNullExpressionValue(supportFragmentManager, "fragmentActivity.supportFragmentManager");
        widgetUrlActions$Companion.launch(supportFragmentManager, this.$url);
        return true;
    }
}
