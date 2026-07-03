package com.discord.widgets.settings;

import android.view.View;
import androidx.core.widget.NestedScrollView;
import com.discord.C5419R;
import com.discord.databinding.WidgetSettingsLanguageSelectBinding;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSettingsLanguageSelect.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsLanguageSelect$binding$2 extends C12236k implements Function1<View, WidgetSettingsLanguageSelectBinding> {
    public static final WidgetSettingsLanguageSelect$binding$2 INSTANCE = new WidgetSettingsLanguageSelect$binding$2();

    public WidgetSettingsLanguageSelect$binding$2() {
        super(1, WidgetSettingsLanguageSelectBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsLanguageSelectBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsLanguageSelectBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        MaxHeightRecyclerView maxHeightRecyclerView = (MaxHeightRecyclerView) view.findViewById(C5419R.id.settings_language_select_list);
        if (maxHeightRecyclerView != null) {
            return new WidgetSettingsLanguageSelectBinding((NestedScrollView) view, maxHeightRecyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.settings_language_select_list)));
    }
}
