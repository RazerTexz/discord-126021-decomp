package com.discord.widgets.voice.call;

import android.view.View;
import android.widget.LinearLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetVoiceCallInlineBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetVoiceCallInline.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetVoiceCallInline$binding$2 extends C12236k implements Function1<View, WidgetVoiceCallInlineBinding> {
    public static final WidgetVoiceCallInline$binding$2 INSTANCE = new WidgetVoiceCallInline$binding$2();

    public WidgetVoiceCallInline$binding$2() {
        super(1, WidgetVoiceCallInlineBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetVoiceCallInlineBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetVoiceCallInlineBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        LinearLayout linearLayout = (LinearLayout) view;
        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.voice_connected_ptt);
        if (materialButton != null) {
            return new WidgetVoiceCallInlineBinding((LinearLayout) view, linearLayout, materialButton);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.voice_connected_ptt)));
    }
}
