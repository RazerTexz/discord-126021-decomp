package com.discord.widgets.quickmentions;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.discord.C5419R;
import com.discord.databinding.WidgetQuickMentionsDialogBinding;
import com.google.android.material.tabs.TabLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetQuickMentionsDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetQuickMentionsDialog$binding$2 extends C12236k implements Function1<View, WidgetQuickMentionsDialogBinding> {
    public static final WidgetQuickMentionsDialog$binding$2 INSTANCE = new WidgetQuickMentionsDialog$binding$2();

    public WidgetQuickMentionsDialog$binding$2() {
        super(1, WidgetQuickMentionsDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetQuickMentionsDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetQuickMentionsDialogBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.tab_contents;
        ViewPager2 viewPager2 = (ViewPager2) view.findViewById(C5419R.id.tab_contents);
        if (viewPager2 != null) {
            i = C5419R.id.tabs;
            TabLayout tabLayout = (TabLayout) view.findViewById(C5419R.id.tabs);
            if (tabLayout != null) {
                return new WidgetQuickMentionsDialogBinding((ConstraintLayout) view, viewPager2, tabLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
