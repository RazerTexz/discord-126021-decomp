package com.discord.widgets.status;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetThreadStatusBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetThreadStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetThreadStatus$binding$2 extends k implements Function1<View, WidgetThreadStatusBinding> {
    public static final WidgetThreadStatus$binding$2 INSTANCE = new WidgetThreadStatus$binding$2();

    public WidgetThreadStatus$binding$2() {
        super(1, WidgetThreadStatusBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetThreadStatusBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetThreadStatusBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetThreadStatusBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R$id.thread_status_button;
        LoadingButton loadingButton = (LoadingButton) view.findViewById(R$id.thread_status_button);
        if (loadingButton != null) {
            i = R$id.thread_status_text;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R$id.thread_status_text);
            if (linkifiedTextView != null) {
                return new WidgetThreadStatusBinding((ConstraintLayout) view, constraintLayout, loadingButton, linkifiedTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
