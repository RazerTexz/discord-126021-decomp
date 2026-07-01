package com.discord.widgets.servers.community;

import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import com.discord.R;
import com.discord.databinding.WidgetServerSettingsCommunitySetupSecondStepBinding;
import com.discord.views.ScreenTitleView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunitySecondStep$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsCommunitySecondStep.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsCommunitySecondStep2 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsCommunitySetupSecondStepBinding> {
    public static final WidgetServerSettingsCommunitySecondStep2 INSTANCE = new WidgetServerSettingsCommunitySecondStep2();

    public WidgetServerSettingsCommunitySecondStep2() {
        super(1, WidgetServerSettingsCommunitySetupSecondStepBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsCommunitySetupSecondStepBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsCommunitySetupSecondStepBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        ScrollView scrollView = (ScrollView) view;
        int i = R.id.community_get_started_header_image;
        ImageView imageView = (ImageView) view.findViewById(R.id.community_get_started_header_image);
        if (imageView != null) {
            i = R.id.community_guidelines_channel;
            CommunitySelectorView communitySelectorView = (CommunitySelectorView) view.findViewById(R.id.community_guidelines_channel);
            if (communitySelectorView != null) {
                i = R.id.community_step_header;
                ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(R.id.community_step_header);
                if (screenTitleView != null) {
                    i = R.id.community_updates_channel;
                    CommunitySelectorView communitySelectorView2 = (CommunitySelectorView) view.findViewById(R.id.community_updates_channel);
                    if (communitySelectorView2 != null) {
                        return new WidgetServerSettingsCommunitySetupSecondStepBinding((ScrollView) view, scrollView, imageView, communitySelectorView, screenTitleView, communitySelectorView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
