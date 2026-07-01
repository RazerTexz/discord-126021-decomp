package com.discord.widgets.settings.developer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.IconListItemTextViewBinding;
import com.discord.widgets.settings.developer.WidgetSettingsDeveloper;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupNoticesSection$noticesAdapter$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsDeveloper4 extends Lambda implements Function2<LayoutInflater, ViewGroup, WidgetSettingsDeveloper.NoticeViewHolder> {
    public static final WidgetSettingsDeveloper4 INSTANCE = new WidgetSettingsDeveloper4();

    public WidgetSettingsDeveloper4() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final WidgetSettingsDeveloper.NoticeViewHolder invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics3.checkNotNullParameter(layoutInflater, "layoutInflater");
        Intrinsics3.checkNotNullParameter(viewGroup, "parent");
        View viewInflate = layoutInflater.inflate(R.layout.icon_list_item_text_view, viewGroup, false);
        Objects.requireNonNull(viewInflate, "rootView");
        IconListItemTextViewBinding iconListItemTextViewBinding = new IconListItemTextViewBinding((TextView) viewInflate);
        Intrinsics3.checkNotNullExpressionValue(iconListItemTextViewBinding, "IconListItemTextViewBind…tInflater, parent, false)");
        return new WidgetSettingsDeveloper.NoticeViewHolder(iconListItemTextViewBinding);
    }
}
