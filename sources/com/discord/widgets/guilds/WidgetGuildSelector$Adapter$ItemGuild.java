package com.discord.widgets.guilds;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import b.a.k.b;
import com.discord.R$id;
import com.discord.databinding.WidgetGuildSelectorItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.extensions.SimpleDraweeViewExtensionsKt;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildSelector$Adapter$ItemGuild extends MGRecyclerViewHolder<WidgetGuildSelector$Adapter, WidgetGuildSelector$Item> {
    private final WidgetGuildSelectorItemBinding binding;
    private final int noGuildStringId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildSelector$Adapter$ItemGuild(@LayoutRes int i, WidgetGuildSelector$Adapter widgetGuildSelector$Adapter, int i2) {
        super(i, widgetGuildSelector$Adapter);
        m.checkNotNullParameter(widgetGuildSelector$Adapter, "adapter");
        this.noGuildStringId = i2;
        View view = this.itemView;
        int i3 = R$id.item_avatar_wrap;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R$id.item_avatar_wrap);
        if (frameLayout != null) {
            i3 = R$id.item_icon;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.item_icon);
            if (simpleDraweeView != null) {
                i3 = R$id.item_name;
                TextView textView = (TextView) view.findViewById(R$id.item_name);
                if (textView != null) {
                    i3 = R$id.item_text;
                    TextView textView2 = (TextView) view.findViewById(R$id.item_text);
                    if (textView2 != null) {
                        WidgetGuildSelectorItemBinding widgetGuildSelectorItemBinding = new WidgetGuildSelectorItemBinding((LinearLayout) view, frameLayout, simpleDraweeView, textView, textView2);
                        m.checkNotNullExpressionValue(widgetGuildSelectorItemBinding, "WidgetGuildSelectorItemBinding.bind(itemView)");
                        this.binding = widgetGuildSelectorItemBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static final /* synthetic */ WidgetGuildSelector$Adapter access$getAdapter$p(WidgetGuildSelector$Adapter$ItemGuild widgetGuildSelector$Adapter$ItemGuild) {
        return (WidgetGuildSelector$Adapter) widgetGuildSelector$Adapter$ItemGuild.adapter;
    }

    public final int getNoGuildStringId() {
        return this.noGuildStringId;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetGuildSelector$Item widgetGuildSelector$Item) {
        onConfigure2(i, widgetGuildSelector$Item);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetGuildSelector$Item data) {
        CharSequence charSequenceJ;
        Guild guild;
        String icon;
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        this.binding.a.setOnClickListener(new WidgetGuildSelector$Adapter$ItemGuild$onConfigure$1(this, data));
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.itemName");
        Guild guild2 = data.getGuild();
        boolean z2 = false;
        String shortName = null;
        if (guild2 == null || (charSequenceJ = guild2.getName()) == null) {
            TextView textView2 = this.binding.d;
            m.checkNotNullExpressionValue(textView2, "binding.itemName");
            charSequenceJ = b.j(textView2, this.noGuildStringId, new Object[0], null, 4);
        }
        textView.setText(charSequenceJ);
        Guild guild3 = data.getGuild();
        if (guild3 != null && (icon = guild3.getIcon()) != null) {
            if (icon.length() > 0) {
                z2 = true;
            }
        }
        SimpleDraweeView simpleDraweeView = this.binding.c;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.itemIcon");
        Guild guild4 = data.getGuild();
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        Integer numValueOf = Integer.valueOf(ColorCompat.getThemedColor(view, 2130968911));
        SimpleDraweeView simpleDraweeView2 = this.binding.c;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.itemIcon");
        SimpleDraweeViewExtensionsKt.setGuildIcon$default(simpleDraweeView, false, guild4, simpleDraweeView2.getResources().getDimensionPixelSize(2131165449), null, numValueOf, null, null, true, null, 360, null);
        FrameLayout frameLayout = this.binding.f2452b;
        m.checkNotNullExpressionValue(frameLayout, "binding.itemAvatarWrap");
        frameLayout.setClipToOutline(true);
        TextView textView3 = this.binding.e;
        m.checkNotNullExpressionValue(textView3, "binding.itemText");
        if (!z2 && (guild = data.getGuild()) != null) {
            shortName = guild.getShortName();
        }
        textView3.setText(shortName);
    }
}
