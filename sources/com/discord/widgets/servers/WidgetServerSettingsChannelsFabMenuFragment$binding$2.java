package com.discord.widgets.servers;

import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import com.discord.R$id;
import com.discord.databinding.WidgetServerSettingsChannelsSortFabMenuBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsChannelsFabMenuFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsChannelsFabMenuFragment$binding$2 extends k implements Function1<View, WidgetServerSettingsChannelsSortFabMenuBinding> {
    public static final WidgetServerSettingsChannelsFabMenuFragment$binding$2 INSTANCE = new WidgetServerSettingsChannelsFabMenuFragment$binding$2();

    public WidgetServerSettingsChannelsFabMenuFragment$binding$2() {
        super(1, WidgetServerSettingsChannelsSortFabMenuBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsChannelsSortFabMenuBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsChannelsSortFabMenuBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsChannelsSortFabMenuBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.fab_menu_add_category;
        TableRow tableRow = (TableRow) view.findViewById(R$id.fab_menu_add_category);
        if (tableRow != null) {
            i = R$id.fab_menu_add_text;
            TableRow tableRow2 = (TableRow) view.findViewById(R$id.fab_menu_add_text);
            if (tableRow2 != null) {
                i = R$id.fab_menu_add_voice;
                TableRow tableRow3 = (TableRow) view.findViewById(R$id.fab_menu_add_voice);
                if (tableRow3 != null) {
                    i = R$id.fab_menu_main;
                    TableRow tableRow4 = (TableRow) view.findViewById(R$id.fab_menu_main);
                    if (tableRow4 != null) {
                        i = R$id.fab_menu_main_fab;
                        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R$id.fab_menu_main_fab);
                        if (floatingActionButton != null) {
                            TableLayout tableLayout = (TableLayout) view;
                            return new WidgetServerSettingsChannelsSortFabMenuBinding(tableLayout, tableRow, tableRow2, tableRow3, tableRow4, floatingActionButton, tableLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
