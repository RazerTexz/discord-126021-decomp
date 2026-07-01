package com.discord.widgets.settings;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetSettingsLanguageBinding;
import com.discord.views.CheckedSetting;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsLanguage$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsLanguage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsLanguage2 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsLanguageBinding> {
    public static final WidgetSettingsLanguage2 INSTANCE = new WidgetSettingsLanguage2();

    public WidgetSettingsLanguage2() {
        super(1, WidgetSettingsLanguageBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsLanguageBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsLanguageBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.settings_language_current;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.settings_language_current);
        if (relativeLayout != null) {
            i = R.id.settings_language_current_flag;
            ImageView imageView = (ImageView) view.findViewById(R.id.settings_language_current_flag);
            if (imageView != null) {
                i = R.id.settings_language_current_text;
                TextView textView = (TextView) view.findViewById(R.id.settings_language_current_text);
                if (textView != null) {
                    i = R.id.settings_language_header;
                    TextView textView2 = (TextView) view.findViewById(R.id.settings_language_header);
                    if (textView2 != null) {
                        i = R.id.settings_language_sync_check;
                        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.settings_language_sync_check);
                        if (checkedSetting != null) {
                            i = R.id.settings_language_sync_header;
                            TextView textView3 = (TextView) view.findViewById(R.id.settings_language_sync_header);
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
