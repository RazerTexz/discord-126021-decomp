package com.discord.widgets.servers.community;

import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import com.discord.R$id;
import com.discord.databinding.WidgetServerSettingsCommunitySetupFirstStepBinding;
import com.discord.views.CheckedSetting;
import com.discord.views.ScreenTitleView;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsCommunityFirstStep.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsCommunityFirstStep$binding$2 extends k implements Function1<View, WidgetServerSettingsCommunitySetupFirstStepBinding> {
    public static final WidgetServerSettingsCommunityFirstStep$binding$2 INSTANCE = new WidgetServerSettingsCommunityFirstStep$binding$2();

    public WidgetServerSettingsCommunityFirstStep$binding$2() {
        super(1, WidgetServerSettingsCommunitySetupFirstStepBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsCommunitySetupFirstStepBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsCommunitySetupFirstStepBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsCommunitySetupFirstStepBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        ScrollView scrollView = (ScrollView) view;
        int i = R$id.community_get_started_header_image;
        ImageView imageView = (ImageView) view.findViewById(R$id.community_get_started_header_image);
        if (imageView != null) {
            i = R$id.community_settings_scan_messages_switch;
            CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R$id.community_settings_scan_messages_switch);
            if (checkedSetting != null) {
                i = R$id.community_settings_verified_emailed_switch;
                CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R$id.community_settings_verified_emailed_switch);
                if (checkedSetting2 != null) {
                    i = R$id.community_step_header;
                    ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(R$id.community_step_header);
                    if (screenTitleView != null) {
                        return new WidgetServerSettingsCommunitySetupFirstStepBinding((ScrollView) view, scrollView, imageView, checkedSetting, checkedSetting2, screenTitleView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
