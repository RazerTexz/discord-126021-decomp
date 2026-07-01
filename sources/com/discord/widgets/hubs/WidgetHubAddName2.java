package com.discord.widgets.hubs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetHubAddNameBinding;
import com.discord.views.GuildView;
import com.discord.views.LoadingButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAddName$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubAddName.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetHubAddName2 extends FunctionReferenceImpl implements Function1<View, WidgetHubAddNameBinding> {
    public static final WidgetHubAddName2 INSTANCE = new WidgetHubAddName2();

    public WidgetHubAddName2() {
        super(1, WidgetHubAddNameBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetHubAddNameBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetHubAddNameBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.discord_hub_add_name_image;
        GuildView guildView = (GuildView) view.findViewById(R.id.discord_hub_add_name_image);
        if (guildView != null) {
            i = R.id.discord_hub_add_name_input;
            TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(R.id.discord_hub_add_name_input);
            if (textInputEditText != null) {
                i = R.id.discord_hub_add_name_input_layout;
                TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.discord_hub_add_name_input_layout);
                if (textInputLayout != null) {
                    i = R.id.discord_hub_add_name_title;
                    TextView textView = (TextView) view.findViewById(R.id.discord_hub_add_name_title);
                    if (textView != null) {
                        i = R.id.discord_hub_add_name_title_button;
                        LoadingButton loadingButton = (LoadingButton) view.findViewById(R.id.discord_hub_add_name_title_button);
                        if (loadingButton != null) {
                            return new WidgetHubAddNameBinding((LinearLayout) view, guildView, textInputEditText, textInputLayout, textView, loadingButton);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
