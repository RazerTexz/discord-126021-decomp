package com.discord.widgets.nux;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.discord.C5419R;
import com.discord.databinding.WidgetNuxChannelPromptBinding;
import com.discord.views.LoadingButton;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetNuxChannelPrompt$binding$2 extends C12236k implements Function1<View, WidgetNuxChannelPromptBinding> {
    public static final WidgetNuxChannelPrompt$binding$2 INSTANCE = new WidgetNuxChannelPrompt$binding$2();

    public WidgetNuxChannelPrompt$binding$2() {
        super(1, WidgetNuxChannelPromptBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetNuxChannelPromptBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetNuxChannelPromptBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.nuf_channel_prompt_cta_button;
        LoadingButton loadingButton = (LoadingButton) view.findViewById(C5419R.id.nuf_channel_prompt_cta_button);
        if (loadingButton != null) {
            i = C5419R.id.nuf_channel_prompt_guild_icon;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.nuf_channel_prompt_guild_icon);
            if (simpleDraweeView != null) {
                i = C5419R.id.nuf_channel_prompt_guild_icon_name;
                TextView textView = (TextView) view.findViewById(C5419R.id.nuf_channel_prompt_guild_icon_name);
                if (textView != null) {
                    i = C5419R.id.nuf_channel_prompt_guild_name;
                    TextView textView2 = (TextView) view.findViewById(C5419R.id.nuf_channel_prompt_guild_name);
                    if (textView2 != null) {
                        i = C5419R.id.nuf_channel_prompt_skip_button;
                        TextView textView3 = (TextView) view.findViewById(C5419R.id.nuf_channel_prompt_skip_button);
                        if (textView3 != null) {
                            i = C5419R.id.nuf_channel_prompt_topic_wrap;
                            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.nuf_channel_prompt_topic_wrap);
                            if (textInputLayout != null) {
                                i = C5419R.id.toolbar;
                                Toolbar toolbar = (Toolbar) view.findViewById(C5419R.id.toolbar);
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
