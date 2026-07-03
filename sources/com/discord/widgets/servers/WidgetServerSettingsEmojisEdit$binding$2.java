package com.discord.widgets.servers;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetServerSettingsEmojisEditBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetServerSettingsEmojisEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsEmojisEdit$binding$2 extends C12236k implements Function1<View, WidgetServerSettingsEmojisEditBinding> {
    public static final WidgetServerSettingsEmojisEdit$binding$2 INSTANCE = new WidgetServerSettingsEmojisEdit$binding$2();

    public WidgetServerSettingsEmojisEdit$binding$2() {
        super(1, WidgetServerSettingsEmojisEditBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsEmojisEditBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsEmojisEditBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.server_settings_emojis_edit_alias;
        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.server_settings_emojis_edit_alias);
        if (textInputLayout != null) {
            i = C5419R.id.server_settings_emojis_edit_alias_save;
            FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(C5419R.id.server_settings_emojis_edit_alias_save);
            if (floatingActionButton != null) {
                return new WidgetServerSettingsEmojisEditBinding((CoordinatorLayout) view, textInputLayout, floatingActionButton);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
