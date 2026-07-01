package com.discord.widgets.guilds.create;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.a.i.r0;
import com.discord.R$id;
import com.discord.databinding.WidgetGuildCreateBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.discord.views.ScreenTitleView;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildCreate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildCreate$binding$2 extends k implements Function1<View, WidgetGuildCreateBinding> {
    public static final WidgetGuildCreate$binding$2 INSTANCE = new WidgetGuildCreate$binding$2();

    public WidgetGuildCreate$binding$2() {
        super(1, WidgetGuildCreateBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildCreateBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildCreateBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildCreateBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.guild_create_button;
        LoadingButton loadingButton = (LoadingButton) view.findViewById(R$id.guild_create_button);
        if (loadingButton != null) {
            i = R$id.guild_create_guidelines;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R$id.guild_create_guidelines);
            if (linkifiedTextView != null) {
                i = R$id.guild_create_icon_uploader;
                View viewFindViewById = view.findViewById(R$id.guild_create_icon_uploader);
                if (viewFindViewById != null) {
                    r0 r0VarA = r0.a(viewFindViewById);
                    i = R$id.guild_create_name;
                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.guild_create_name);
                    if (textInputLayout != null) {
                        i = R$id.guild_create_screen_title;
                        ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(R$id.guild_create_screen_title);
                        if (screenTitleView != null) {
                            return new WidgetGuildCreateBinding((CoordinatorLayout) view, loadingButton, linkifiedTextView, r0VarA, textInputLayout, screenTitleView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
