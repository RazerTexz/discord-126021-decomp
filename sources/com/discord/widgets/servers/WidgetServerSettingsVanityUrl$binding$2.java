package com.discord.widgets.servers;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetServerSettingsVanityUrlBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetServerSettingsVanityUrl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsVanityUrl$binding$2 extends C12236k implements Function1<View, WidgetServerSettingsVanityUrlBinding> {
    public static final WidgetServerSettingsVanityUrl$binding$2 INSTANCE = new WidgetServerSettingsVanityUrl$binding$2();

    public WidgetServerSettingsVanityUrl$binding$2() {
        super(1, WidgetServerSettingsVanityUrlBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsVanityUrlBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsVanityUrlBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.server_settings_vanity_input;
        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.server_settings_vanity_input);
        if (textInputLayout != null) {
            i = C5419R.id.server_settings_vanity_url_current_url;
            TextView textView = (TextView) view.findViewById(C5419R.id.server_settings_vanity_url_current_url);
            if (textView != null) {
                i = C5419R.id.server_settings_vanity_url_error_text;
                TextView textView2 = (TextView) view.findViewById(C5419R.id.server_settings_vanity_url_error_text);
                if (textView2 != null) {
                    i = C5419R.id.server_settings_vanity_url_header;
                    TextView textView3 = (TextView) view.findViewById(C5419R.id.server_settings_vanity_url_header);
                    if (textView3 != null) {
                        i = C5419R.id.server_settings_vanity_url_input_container;
                        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(C5419R.id.server_settings_vanity_url_input_container);
                        if (relativeLayout != null) {
                            i = C5419R.id.server_settings_vanity_url_loading_indicator;
                            ProgressBar progressBar = (ProgressBar) view.findViewById(C5419R.id.server_settings_vanity_url_loading_indicator);
                            if (progressBar != null) {
                                i = C5419R.id.server_settings_vanity_url_prefix;
                                TextView textView4 = (TextView) view.findViewById(C5419R.id.server_settings_vanity_url_prefix);
                                if (textView4 != null) {
                                    i = C5419R.id.server_settings_vanity_url_remove;
                                    TextView textView5 = (TextView) view.findViewById(C5419R.id.server_settings_vanity_url_remove);
                                    if (textView5 != null) {
                                        i = C5419R.id.server_settings_vanity_url_save;
                                        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(C5419R.id.server_settings_vanity_url_save);
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
