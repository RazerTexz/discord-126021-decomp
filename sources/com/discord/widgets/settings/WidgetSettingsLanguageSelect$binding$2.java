package com.discord.widgets.settings;

import android.view.View;
import androidx.core.widget.NestedScrollView;
import com.discord.R$id;
import com.discord.databinding.WidgetSettingsLanguageSelectBinding;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsLanguageSelect.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsLanguageSelect$binding$2 extends k implements Function1<View, WidgetSettingsLanguageSelectBinding> {
    public static final WidgetSettingsLanguageSelect$binding$2 INSTANCE = new WidgetSettingsLanguageSelect$binding$2();

    public WidgetSettingsLanguageSelect$binding$2() {
        super(1, WidgetSettingsLanguageSelectBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsLanguageSelectBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsLanguageSelectBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsLanguageSelectBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        MaxHeightRecyclerView maxHeightRecyclerView = (MaxHeightRecyclerView) view.findViewById(R$id.settings_language_select_list);
        if (maxHeightRecyclerView != null) {
            return new WidgetSettingsLanguageSelectBinding((NestedScrollView) view, maxHeightRecyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R$id.settings_language_select_list)));
    }
}
