package com.discord.widgets.guilds.join;

import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R$id;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGuildWelcomeSheetBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildWelcomeSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildWelcomeSheet$binding$2 extends k implements Function1<View, WidgetGuildWelcomeSheetBinding> {
    public static final WidgetGuildWelcomeSheet$binding$2 INSTANCE = new WidgetGuildWelcomeSheet$binding$2();

    public WidgetGuildWelcomeSheet$binding$2() {
        super(1, WidgetGuildWelcomeSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildWelcomeSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildWelcomeSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildWelcomeSheetBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.guild_welcome_sheet_channels;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.guild_welcome_sheet_channels);
        if (recyclerView != null) {
            i = R$id.guild_welcome_sheet_description;
            TextView textView = (TextView) view.findViewById(R$id.guild_welcome_sheet_description);
            if (textView != null) {
                i = R$id.guild_welcome_sheet_flipper;
                AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R$id.guild_welcome_sheet_flipper);
                if (appViewFlipper != null) {
                    i = R$id.guild_welcome_sheet_icon;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.guild_welcome_sheet_icon);
                    if (simpleDraweeView != null) {
                        i = R$id.guild_welcome_sheet_icon_card;
                        CardView cardView = (CardView) view.findViewById(R$id.guild_welcome_sheet_icon_card);
                        if (cardView != null) {
                            i = R$id.guild_welcome_sheet_icon_name;
                            TextView textView2 = (TextView) view.findViewById(R$id.guild_welcome_sheet_icon_name);
                            if (textView2 != null) {
                                i = R$id.guild_welcome_sheet_name;
                                TextView textView3 = (TextView) view.findViewById(R$id.guild_welcome_sheet_name);
                                if (textView3 != null) {
                                    return new WidgetGuildWelcomeSheetBinding((NestedScrollView) view, recyclerView, textView, appViewFlipper, simpleDraweeView, cardView, textView2, textView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
