package com.discord.widgets.nux;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.discord.R$id;
import com.discord.databinding.WidgetNuxChannelPromptBinding;
import com.discord.views.LoadingButton;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetNuxChannelPrompt$binding$2 extends k implements Function1<View, WidgetNuxChannelPromptBinding> {
    public static final WidgetNuxChannelPrompt$binding$2 INSTANCE = new WidgetNuxChannelPrompt$binding$2();

    public WidgetNuxChannelPrompt$binding$2() {
        super(1, WidgetNuxChannelPromptBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetNuxChannelPromptBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetNuxChannelPromptBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetNuxChannelPromptBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.nuf_channel_prompt_cta_button;
        LoadingButton loadingButton = (LoadingButton) view.findViewById(R$id.nuf_channel_prompt_cta_button);
        if (loadingButton != null) {
            i = R$id.nuf_channel_prompt_guild_icon;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.nuf_channel_prompt_guild_icon);
            if (simpleDraweeView != null) {
                i = R$id.nuf_channel_prompt_guild_icon_name;
                TextView textView = (TextView) view.findViewById(R$id.nuf_channel_prompt_guild_icon_name);
                if (textView != null) {
                    i = R$id.nuf_channel_prompt_guild_name;
                    TextView textView2 = (TextView) view.findViewById(R$id.nuf_channel_prompt_guild_name);
                    if (textView2 != null) {
                        i = R$id.nuf_channel_prompt_skip_button;
                        TextView textView3 = (TextView) view.findViewById(R$id.nuf_channel_prompt_skip_button);
                        if (textView3 != null) {
                            i = R$id.nuf_channel_prompt_topic_wrap;
                            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.nuf_channel_prompt_topic_wrap);
                            if (textInputLayout != null) {
                                i = R$id.toolbar;
                                Toolbar toolbar = (Toolbar) view.findViewById(R$id.toolbar);
                                if (toolbar != null) {
                                    return new WidgetNuxChannelPromptBinding((RelativeLayout) view, loadingButton, simpleDraweeView, textView, textView2, textView3, textInputLayout, toolbar);
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
