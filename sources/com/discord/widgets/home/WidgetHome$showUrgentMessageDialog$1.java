package com.discord.widgets.home;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import b.a.a.t;
import b.a.a.t$a;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHome$showUrgentMessageDialog$1 extends o implements Function1<FragmentActivity, Boolean> {
    public static final WidgetHome$showUrgentMessageDialog$1 INSTANCE = new WidgetHome$showUrgentMessageDialog$1();

    public WidgetHome$showUrgentMessageDialog$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        m.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        t$a t_a = t.k;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        m.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        Objects.requireNonNull(t_a);
        m.checkNotNullParameter(supportFragmentManager, "fragmentManager");
        new t().show(supportFragmentManager, "WidgetUrgentMessageDialog");
        return true;
    }
}
