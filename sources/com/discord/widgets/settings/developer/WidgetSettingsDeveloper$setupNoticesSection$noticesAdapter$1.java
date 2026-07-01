package com.discord.widgets.settings.developer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.discord.R$layout;
import com.discord.databinding.IconListItemTextViewBinding;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsDeveloper$setupNoticesSection$noticesAdapter$1 extends o implements Function2<LayoutInflater, ViewGroup, WidgetSettingsDeveloper$NoticeViewHolder> {
    public static final WidgetSettingsDeveloper$setupNoticesSection$noticesAdapter$1 INSTANCE = new WidgetSettingsDeveloper$setupNoticesSection$noticesAdapter$1();

    public WidgetSettingsDeveloper$setupNoticesSection$noticesAdapter$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ WidgetSettingsDeveloper$NoticeViewHolder invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return invoke2(layoutInflater, viewGroup);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsDeveloper$NoticeViewHolder invoke2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        m.checkNotNullParameter(layoutInflater, "layoutInflater");
        m.checkNotNullParameter(viewGroup, "parent");
        View viewInflate = layoutInflater.inflate(R$layout.icon_list_item_text_view, viewGroup, false);
        Objects.requireNonNull(viewInflate, "rootView");
        IconListItemTextViewBinding iconListItemTextViewBinding = new IconListItemTextViewBinding((TextView) viewInflate);
        m.checkNotNullExpressionValue(iconListItemTextViewBinding, "IconListItemTextViewBind…tInflater, parent, false)");
        return new WidgetSettingsDeveloper$NoticeViewHolder(iconListItemTextViewBinding);
    }
}
