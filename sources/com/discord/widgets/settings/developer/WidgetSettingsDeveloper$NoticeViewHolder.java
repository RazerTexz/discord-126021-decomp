package com.discord.widgets.settings.developer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.TextView;
import com.discord.databinding.IconListItemTextViewBinding;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.views.SimpleRecyclerAdapter$ViewHolder;
import d0.z.d.m;
import kotlin.Pair;

/* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsDeveloper$NoticeViewHolder extends SimpleRecyclerAdapter$ViewHolder<Pair<? extends String, ? extends Long>> {
    private final IconListItemTextViewBinding binding;
    public String noticeName;

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetSettingsDeveloper$NoticeViewHolder(IconListItemTextViewBinding iconListItemTextViewBinding) {
        m.checkNotNullParameter(iconListItemTextViewBinding, "binding");
        TextView textView = iconListItemTextViewBinding.a;
        m.checkNotNullExpressionValue(textView, "binding.root");
        super(textView);
        this.binding = iconListItemTextViewBinding;
    }

    @Override // com.discord.utilities.views.SimpleRecyclerAdapter$ViewHolder
    public /* bridge */ /* synthetic */ void bind(Pair<? extends String, ? extends Long> pair) {
        bind2((Pair<String, Long>) pair);
    }

    public final String getNoticeName() {
        String str = this.noticeName;
        if (str == null) {
            m.throwUninitializedPropertyAccessException("noticeName");
        }
        return str;
    }

    public final void setNoticeName(String str) {
        m.checkNotNullParameter(str, "<set-?>");
        this.noticeName = str;
    }

    @SuppressLint({"SetTextI18n"})
    /* JADX INFO: renamed from: bind, reason: avoid collision after fix types in other method */
    public void bind2(Pair<String, Long> data) {
        m.checkNotNullParameter(data, "data");
        String strComponent1 = data.component1();
        long jLongValue = data.component2().longValue();
        this.noticeName = strComponent1;
        TextView textView = this.binding.a;
        m.checkNotNullExpressionValue(textView, "binding.root");
        Context context = textView.getContext();
        m.checkNotNullExpressionValue(context, "binding.root.context");
        CharSequence readableTimeString$default = TimeUtils.toReadableTimeString$default(context, jLongValue, null, 4, null);
        TextView textView2 = this.binding.a;
        m.checkNotNullExpressionValue(textView2, "binding.root");
        textView2.setText(strComponent1 + " @ " + readableTimeString$default);
    }
}
