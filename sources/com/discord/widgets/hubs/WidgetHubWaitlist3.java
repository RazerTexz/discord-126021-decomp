package com.discord.widgets.hubs;

import android.view.View;
import android.widget.LinearLayout;
import com.discord.R;
import com.discord.databinding.WidgetHubWaitlistBinding;
import com.discord.views.LoadingButton;
import com.discord.views.ScreenTitleView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubWaitlist$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubWaitlist.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetHubWaitlist3 extends FunctionReferenceImpl implements Function1<View, WidgetHubWaitlistBinding> {
    public static final WidgetHubWaitlist3 INSTANCE = new WidgetHubWaitlist3();

    public WidgetHubWaitlist3() {
        super(1, WidgetHubWaitlistBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetHubWaitlistBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetHubWaitlistBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.hub_waitlist_button;
        LoadingButton loadingButton = (LoadingButton) view.findViewById(R.id.hub_waitlist_button);
        if (loadingButton != null) {
            i = R.id.hub_waitlist_edit_text;
            TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(R.id.hub_waitlist_edit_text);
            if (textInputEditText != null) {
                i = R.id.hub_waitlist_header;
                ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(R.id.hub_waitlist_header);
                if (screenTitleView != null) {
                    i = R.id.hub_waitlist_layout;
                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.hub_waitlist_layout);
                    if (textInputLayout != null) {
                        return new WidgetHubWaitlistBinding((LinearLayout) view, loadingButton, textInputEditText, screenTitleView, textInputLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
