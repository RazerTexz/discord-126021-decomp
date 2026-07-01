package com.discord.widgets.quickmentions;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.discord.R;
import com.discord.databinding.WidgetQuickMentionsDialogBinding;
import com.google.android.material.tabs.TabLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.quickmentions.WidgetQuickMentionsDialog$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetQuickMentionsDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetQuickMentionsDialog2 extends FunctionReferenceImpl implements Function1<View, WidgetQuickMentionsDialogBinding> {
    public static final WidgetQuickMentionsDialog2 INSTANCE = new WidgetQuickMentionsDialog2();

    public WidgetQuickMentionsDialog2() {
        super(1, WidgetQuickMentionsDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetQuickMentionsDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetQuickMentionsDialogBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.tab_contents;
        ViewPager2 viewPager2 = (ViewPager2) view.findViewById(R.id.tab_contents);
        if (viewPager2 != null) {
            i = R.id.tabs;
            TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
            if (tabLayout != null) {
                return new WidgetQuickMentionsDialogBinding((ConstraintLayout) view, viewPager2, tabLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
