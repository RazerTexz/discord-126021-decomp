package com.discord.widgets.guilds.create;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetGuildCreateBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.discord.views.ScreenTitleView;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p025i.C1038r0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildCreate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildCreate$binding$2 extends C12236k implements Function1<View, WidgetGuildCreateBinding> {
    public static final WidgetGuildCreate$binding$2 INSTANCE = new WidgetGuildCreate$binding$2();

    public WidgetGuildCreate$binding$2() {
        super(1, WidgetGuildCreateBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildCreateBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildCreateBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.guild_create_button;
        LoadingButton loadingButton = (LoadingButton) view.findViewById(C5419R.id.guild_create_button);
        if (loadingButton != null) {
            i = C5419R.id.guild_create_guidelines;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.guild_create_guidelines);
            if (linkifiedTextView != null) {
                i = C5419R.id.guild_create_icon_uploader;
                View viewFindViewById = view.findViewById(C5419R.id.guild_create_icon_uploader);
                if (viewFindViewById != null) {
                    C1038r0 c1038r0M204a = C1038r0.m204a(viewFindViewById);
                    i = C5419R.id.guild_create_name;
                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.guild_create_name);
                    if (textInputLayout != null) {
                        i = C5419R.id.guild_create_screen_title;
                        ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(C5419R.id.guild_create_screen_title);
                        if (screenTitleView != null) {
                            return new WidgetGuildCreateBinding((CoordinatorLayout) view, loadingButton, linkifiedTextView, c1038r0M204a, textInputLayout, screenTitleView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
