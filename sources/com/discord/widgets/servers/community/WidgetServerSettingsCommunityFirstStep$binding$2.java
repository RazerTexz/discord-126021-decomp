package com.discord.widgets.servers.community;

import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import com.discord.C5419R;
import com.discord.databinding.WidgetServerSettingsCommunitySetupFirstStepBinding;
import com.discord.views.CheckedSetting;
import com.discord.views.ScreenTitleView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetServerSettingsCommunityFirstStep.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsCommunityFirstStep$binding$2 extends C12236k implements Function1<View, WidgetServerSettingsCommunitySetupFirstStepBinding> {
    public static final WidgetServerSettingsCommunityFirstStep$binding$2 INSTANCE = new WidgetServerSettingsCommunityFirstStep$binding$2();

    public WidgetServerSettingsCommunityFirstStep$binding$2() {
        super(1, WidgetServerSettingsCommunitySetupFirstStepBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsCommunitySetupFirstStepBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsCommunitySetupFirstStepBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        ScrollView scrollView = (ScrollView) view;
        int i = C5419R.id.community_get_started_header_image;
        ImageView imageView = (ImageView) view.findViewById(C5419R.id.community_get_started_header_image);
        if (imageView != null) {
            i = C5419R.id.community_settings_scan_messages_switch;
            CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(C5419R.id.community_settings_scan_messages_switch);
            if (checkedSetting != null) {
                i = C5419R.id.community_settings_verified_emailed_switch;
                CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(C5419R.id.community_settings_verified_emailed_switch);
                if (checkedSetting2 != null) {
                    i = C5419R.id.community_step_header;
                    ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(C5419R.id.community_step_header);
                    if (screenTitleView != null) {
                        return new WidgetServerSettingsCommunitySetupFirstStepBinding((ScrollView) view, scrollView, imageView, checkedSetting, checkedSetting2, screenTitleView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
