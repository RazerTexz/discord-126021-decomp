package com.discord.widgets.settings.developer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.IconListItemTextViewBinding;
import java.util.Objects;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsDeveloper$setupNoticesSection$noticesAdapter$1 extends AbstractC12240o implements Function2<LayoutInflater, ViewGroup, WidgetSettingsDeveloper.NoticeViewHolder> {
    public static final WidgetSettingsDeveloper$setupNoticesSection$noticesAdapter$1 INSTANCE = new WidgetSettingsDeveloper$setupNoticesSection$noticesAdapter$1();

    public WidgetSettingsDeveloper$setupNoticesSection$noticesAdapter$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final WidgetSettingsDeveloper.NoticeViewHolder invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C12238m.checkNotNullParameter(layoutInflater, "layoutInflater");
        C12238m.checkNotNullParameter(viewGroup, "parent");
        View viewInflate = layoutInflater.inflate(C5419R.layout.icon_list_item_text_view, viewGroup, false);
        Objects.requireNonNull(viewInflate, "rootView");
        IconListItemTextViewBinding iconListItemTextViewBinding = new IconListItemTextViewBinding((TextView) viewInflate);
        C12238m.checkNotNullExpressionValue(iconListItemTextViewBinding, "IconListItemTextViewBind…tInflater, parent, false)");
        return new WidgetSettingsDeveloper.NoticeViewHolder(iconListItemTextViewBinding);
    }
}
