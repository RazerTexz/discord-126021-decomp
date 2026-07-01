package com.discord.widgets.servers.community;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.discord.R;
import com.discord.databinding.WidgetServerSettingsEnableCommunityBinding;
import com.discord.views.ScreenTitleView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunity$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsEnableCommunity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsEnableCommunity2 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsEnableCommunityBinding> {
    public static final WidgetServerSettingsEnableCommunity2 INSTANCE = new WidgetServerSettingsEnableCommunity2();

    public WidgetServerSettingsEnableCommunity2() {
        super(1, WidgetServerSettingsEnableCommunityBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsEnableCommunityBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsEnableCommunityBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.community_get_started_header;
        ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(R.id.community_get_started_header);
        if (screenTitleView != null) {
            i = R.id.community_get_started_header_image;
            ImageView imageView = (ImageView) view.findViewById(R.id.community_get_started_header_image);
            if (imageView != null) {
                ScrollView scrollView = (ScrollView) view;
                i = R.id.community_header_image;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.community_header_image);
                if (relativeLayout != null) {
                    i = R.id.community_setting_get_started;
                    MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.community_setting_get_started);
                    if (materialButton != null) {
                        return new WidgetServerSettingsEnableCommunityBinding(scrollView, screenTitleView, imageView, scrollView, relativeLayout, materialButton);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
