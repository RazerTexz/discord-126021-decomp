package com.discord.widgets.tos;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetTosBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.tos.WidgetTos$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetTos.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetTos2 extends FunctionReferenceImpl implements Function1<View, WidgetTosBinding> {
    public static final WidgetTos2 INSTANCE = new WidgetTos2();

    public WidgetTos2() {
        super(1, WidgetTosBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetTosBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetTosBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.alert_tos_ack_continue;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.alert_tos_ack_continue);
        if (materialButton != null) {
            i = R.id.alert_tos_ack_wrap;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.alert_tos_ack_wrap);
            if (linearLayout != null) {
                i = R.id.alert_tos_blog_post;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.alert_tos_blog_post);
                if (linkifiedTextView != null) {
                    i = R.id.alert_tos_community_guidelines;
                    LinkifiedTextView linkifiedTextView2 = (LinkifiedTextView) view.findViewById(R.id.alert_tos_community_guidelines);
                    if (linkifiedTextView2 != null) {
                        i = R.id.alert_tos_privacy_policy;
                        LinkifiedTextView linkifiedTextView3 = (LinkifiedTextView) view.findViewById(R.id.alert_tos_privacy_policy);
                        if (linkifiedTextView3 != null) {
                            i = R.id.alert_tos_terms_of_service;
                            LinkifiedTextView linkifiedTextView4 = (LinkifiedTextView) view.findViewById(R.id.alert_tos_terms_of_service);
                            if (linkifiedTextView4 != null) {
                                i = R.id.alert_tos_text_description_bottom;
                                TextView textView = (TextView) view.findViewById(R.id.alert_tos_text_description_bottom);
                                if (textView != null) {
                                    i = R.id.alert_tos_text_description_top;
                                    TextView textView2 = (TextView) view.findViewById(R.id.alert_tos_text_description_top);
                                    if (textView2 != null) {
                                        i = R.id.tos_icon;
                                        ImageView imageView = (ImageView) view.findViewById(R.id.tos_icon);
                                        if (imageView != null) {
                                            return new WidgetTosBinding((RelativeLayout) view, materialButton, linearLayout, linkifiedTextView, linkifiedTextView2, linkifiedTextView3, linkifiedTextView4, textView, textView2, imageView);
                                        }
                                    }
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
