package com.discord.widgets.servers;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetServerSettingsEmojisEditBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsEmojisEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsEmojisEdit$binding$2 extends k implements Function1<View, WidgetServerSettingsEmojisEditBinding> {
    public static final WidgetServerSettingsEmojisEdit$binding$2 INSTANCE = new WidgetServerSettingsEmojisEdit$binding$2();

    public WidgetServerSettingsEmojisEdit$binding$2() {
        super(1, WidgetServerSettingsEmojisEditBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsEmojisEditBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsEmojisEditBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsEmojisEditBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.server_settings_emojis_edit_alias;
        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.server_settings_emojis_edit_alias);
        if (textInputLayout != null) {
            i = R$id.server_settings_emojis_edit_alias_save;
            FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R$id.server_settings_emojis_edit_alias_save);
            if (floatingActionButton != null) {
                return new WidgetServerSettingsEmojisEditBinding((CoordinatorLayout) view, textInputLayout, floatingActionButton);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
