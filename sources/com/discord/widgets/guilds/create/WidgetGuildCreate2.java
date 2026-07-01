package com.discord.widgets.guilds.create;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.a.i.LayoutIconUploaderBinding;
import com.discord.R;
import com.discord.databinding.WidgetGuildCreateBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.discord.views.ScreenTitleView;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.guilds.create.WidgetGuildCreate$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildCreate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildCreate2 extends FunctionReferenceImpl implements Function1<View, WidgetGuildCreateBinding> {
    public static final WidgetGuildCreate2 INSTANCE = new WidgetGuildCreate2();

    public WidgetGuildCreate2() {
        super(1, WidgetGuildCreateBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildCreateBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildCreateBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.guild_create_button;
        LoadingButton loadingButton = (LoadingButton) view.findViewById(R.id.guild_create_button);
        if (loadingButton != null) {
            i = R.id.guild_create_guidelines;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.guild_create_guidelines);
            if (linkifiedTextView != null) {
                i = R.id.guild_create_icon_uploader;
                View viewFindViewById = view.findViewById(R.id.guild_create_icon_uploader);
                if (viewFindViewById != null) {
                    LayoutIconUploaderBinding layoutIconUploaderBindingA = LayoutIconUploaderBinding.a(viewFindViewById);
                    i = R.id.guild_create_name;
                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.guild_create_name);
                    if (textInputLayout != null) {
                        i = R.id.guild_create_screen_title;
                        ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(R.id.guild_create_screen_title);
                        if (screenTitleView != null) {
                            return new WidgetGuildCreateBinding((CoordinatorLayout) view, loadingButton, linkifiedTextView, layoutIconUploaderBindingA, textInputLayout, screenTitleView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
