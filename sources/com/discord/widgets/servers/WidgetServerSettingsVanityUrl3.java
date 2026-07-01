package com.discord.widgets.servers;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetServerSettingsVanityUrlBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsVanityUrl$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsVanityUrl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsVanityUrl3 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsVanityUrlBinding> {
    public static final WidgetServerSettingsVanityUrl3 INSTANCE = new WidgetServerSettingsVanityUrl3();

    public WidgetServerSettingsVanityUrl3() {
        super(1, WidgetServerSettingsVanityUrlBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsVanityUrlBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsVanityUrlBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.server_settings_vanity_input;
        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.server_settings_vanity_input);
        if (textInputLayout != null) {
            i = R.id.server_settings_vanity_url_current_url;
            TextView textView = (TextView) view.findViewById(R.id.server_settings_vanity_url_current_url);
            if (textView != null) {
                i = R.id.server_settings_vanity_url_error_text;
                TextView textView2 = (TextView) view.findViewById(R.id.server_settings_vanity_url_error_text);
                if (textView2 != null) {
                    i = R.id.server_settings_vanity_url_header;
                    TextView textView3 = (TextView) view.findViewById(R.id.server_settings_vanity_url_header);
                    if (textView3 != null) {
                        i = R.id.server_settings_vanity_url_input_container;
                        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.server_settings_vanity_url_input_container);
                        if (relativeLayout != null) {
                            i = R.id.server_settings_vanity_url_loading_indicator;
                            ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.server_settings_vanity_url_loading_indicator);
                            if (progressBar != null) {
                                i = R.id.server_settings_vanity_url_prefix;
                                TextView textView4 = (TextView) view.findViewById(R.id.server_settings_vanity_url_prefix);
                                if (textView4 != null) {
                                    i = R.id.server_settings_vanity_url_remove;
                                    TextView textView5 = (TextView) view.findViewById(R.id.server_settings_vanity_url_remove);
                                    if (textView5 != null) {
                                        i = R.id.server_settings_vanity_url_save;
                                        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.server_settings_vanity_url_save);
                                        if (floatingActionButton != null) {
                                            return new WidgetServerSettingsVanityUrlBinding((CoordinatorLayout) view, textInputLayout, textView, textView2, textView3, relativeLayout, progressBar, textView4, textView5, floatingActionButton);
                                        }
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
