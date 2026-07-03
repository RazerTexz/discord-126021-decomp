package com.discord.widgets.settings;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetSettingsLanguageBinding;
import com.discord.views.CheckedSetting;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSettingsLanguage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsLanguage$binding$2 extends C12236k implements Function1<View, WidgetSettingsLanguageBinding> {
    public static final WidgetSettingsLanguage$binding$2 INSTANCE = new WidgetSettingsLanguage$binding$2();

    public WidgetSettingsLanguage$binding$2() {
        super(1, WidgetSettingsLanguageBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsLanguageBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsLanguageBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.settings_language_current;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(C5419R.id.settings_language_current);
        if (relativeLayout != null) {
            i = C5419R.id.settings_language_current_flag;
            ImageView imageView = (ImageView) view.findViewById(C5419R.id.settings_language_current_flag);
            if (imageView != null) {
                i = C5419R.id.settings_language_current_text;
                TextView textView = (TextView) view.findViewById(C5419R.id.settings_language_current_text);
                if (textView != null) {
                    i = C5419R.id.settings_language_header;
                    TextView textView2 = (TextView) view.findViewById(C5419R.id.settings_language_header);
                    if (textView2 != null) {
                        i = C5419R.id.settings_language_sync_check;
                        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(C5419R.id.settings_language_sync_check);
                        if (checkedSetting != null) {
                            i = C5419R.id.settings_language_sync_header;
                            TextView textView3 = (TextView) view.findViewById(C5419R.id.settings_language_sync_header);
                            if (textView3 != null) {
                                return new WidgetSettingsLanguageBinding((CoordinatorLayout) view, relativeLayout, imageView, textView, textView2, checkedSetting, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
