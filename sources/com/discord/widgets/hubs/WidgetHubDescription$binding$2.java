package com.discord.widgets.hubs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.databinding.WidgetHubDescriptionBinding;
import com.discord.views.LoadingButton;
import com.discord.views.ScreenTitleView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubDescription.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetHubDescription$binding$2 extends k implements Function1<View, WidgetHubDescriptionBinding> {
    public static final WidgetHubDescription$binding$2 INSTANCE = new WidgetHubDescription$binding$2();

    public WidgetHubDescription$binding$2() {
        super(1, WidgetHubDescriptionBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetHubDescriptionBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetHubDescriptionBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetHubDescriptionBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.add_server;
        LoadingButton loadingButton = (LoadingButton) view.findViewById(R$id.add_server);
        if (loadingButton != null) {
            i = R$id.category;
            TextView textView = (TextView) view.findViewById(R$id.category);
            if (textView != null) {
                i = R$id.category_error;
                TextView textView2 = (TextView) view.findViewById(R$id.category_error);
                if (textView2 != null) {
                    i = R$id.category_layout;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.category_layout);
                    if (linearLayout != null) {
                        i = R$id.contact_sync_permissions_subtitle;
                        TextView textView3 = (TextView) view.findViewById(R$id.contact_sync_permissions_subtitle);
                        if (textView3 != null) {
                            i = R$id.description;
                            TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(R$id.description);
                            if (textInputEditText != null) {
                                i = R$id.description_layout;
                                TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.description_layout);
                                if (textInputLayout != null) {
                                    i = R$id.header;
                                    ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(R$id.header);
                                    if (screenTitleView != null) {
                                        return new WidgetHubDescriptionBinding((LinearLayout) view, loadingButton, textView, textView2, linearLayout, textView3, textInputEditText, textInputLayout, screenTitleView);
                                    }
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
