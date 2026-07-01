package com.discord.widgets.quickmentions;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.discord.R$id;
import com.discord.databinding.WidgetQuickMentionsDialogBinding;
import com.google.android.material.tabs.TabLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetQuickMentionsDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetQuickMentionsDialog$binding$2 extends k implements Function1<View, WidgetQuickMentionsDialogBinding> {
    public static final WidgetQuickMentionsDialog$binding$2 INSTANCE = new WidgetQuickMentionsDialog$binding$2();

    public WidgetQuickMentionsDialog$binding$2() {
        super(1, WidgetQuickMentionsDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetQuickMentionsDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetQuickMentionsDialogBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetQuickMentionsDialogBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.tab_contents;
        ViewPager2 viewPager2 = (ViewPager2) view.findViewById(R$id.tab_contents);
        if (viewPager2 != null) {
            i = R$id.tabs;
            TabLayout tabLayout = (TabLayout) view.findViewById(R$id.tabs);
            if (tabLayout != null) {
                return new WidgetQuickMentionsDialogBinding((ConstraintLayout) view, viewPager2, tabLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
