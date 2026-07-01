package com.discord.widgets.hubs;

import android.view.View;
import android.widget.LinearLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetHubWaitlistBinding;
import com.discord.views.LoadingButton;
import com.discord.views.ScreenTitleView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubWaitlist.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetHubWaitlist$binding$2 extends k implements Function1<View, WidgetHubWaitlistBinding> {
    public static final WidgetHubWaitlist$binding$2 INSTANCE = new WidgetHubWaitlist$binding$2();

    public WidgetHubWaitlist$binding$2() {
        super(1, WidgetHubWaitlistBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetHubWaitlistBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetHubWaitlistBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetHubWaitlistBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.hub_waitlist_button;
        LoadingButton loadingButton = (LoadingButton) view.findViewById(R$id.hub_waitlist_button);
        if (loadingButton != null) {
            i = R$id.hub_waitlist_edit_text;
            TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(R$id.hub_waitlist_edit_text);
            if (textInputEditText != null) {
                i = R$id.hub_waitlist_header;
                ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(R$id.hub_waitlist_header);
                if (screenTitleView != null) {
                    i = R$id.hub_waitlist_layout;
                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.hub_waitlist_layout);
                    if (textInputLayout != null) {
                        return new WidgetHubWaitlistBinding((LinearLayout) view, loadingButton, textInputEditText, screenTitleView, textInputLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
