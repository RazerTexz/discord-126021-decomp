package com.discord.widgets.servers.community;

import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import com.discord.R$id;
import com.discord.databinding.WidgetServerSettingsCommunitySetupThirdStepBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.CheckedSetting;
import com.discord.views.ScreenTitleView;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsCommunityThirdStep.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsCommunityThirdStep$binding$2 extends k implements Function1<View, WidgetServerSettingsCommunitySetupThirdStepBinding> {
    public static final WidgetServerSettingsCommunityThirdStep$binding$2 INSTANCE = new WidgetServerSettingsCommunityThirdStep$binding$2();

    public WidgetServerSettingsCommunityThirdStep$binding$2() {
        super(1, WidgetServerSettingsCommunitySetupThirdStepBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsCommunitySetupThirdStepBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsCommunitySetupThirdStepBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsCommunitySetupThirdStepBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        ScrollView scrollView = (ScrollView) view;
        int i = R$id.community_get_started_header_image;
        ImageView imageView = (ImageView) view.findViewById(R$id.community_get_started_header_image);
        if (imageView != null) {
            i = R$id.community_setting_community_guidelines_switch;
            CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R$id.community_setting_community_guidelines_switch);
            if (checkedSetting != null) {
                i = R$id.community_setting_guidelines;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R$id.community_setting_guidelines);
                if (linkifiedTextView != null) {
                    i = R$id.community_setting_manage_permissions_switch;
                    CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R$id.community_setting_manage_permissions_switch);
                    if (checkedSetting2 != null) {
                        i = R$id.community_setting_notifications_to_mentions_switch;
                        CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(R$id.community_setting_notifications_to_mentions_switch);
                        if (checkedSetting3 != null) {
                            i = R$id.community_step_header;
                            ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(R$id.community_step_header);
                            if (screenTitleView != null) {
                                return new WidgetServerSettingsCommunitySetupThirdStepBinding((ScrollView) view, scrollView, imageView, checkedSetting, linkifiedTextView, checkedSetting2, checkedSetting3, screenTitleView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
