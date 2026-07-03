package com.discord.widgets.tos;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetTosBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetTos.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetTos$binding$2 extends C12236k implements Function1<View, WidgetTosBinding> {
    public static final WidgetTos$binding$2 INSTANCE = new WidgetTos$binding$2();

    public WidgetTos$binding$2() {
        super(1, WidgetTosBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetTosBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetTosBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.alert_tos_ack_continue;
        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.alert_tos_ack_continue);
        if (materialButton != null) {
            i = C5419R.id.alert_tos_ack_wrap;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.alert_tos_ack_wrap);
            if (linearLayout != null) {
                i = C5419R.id.alert_tos_blog_post;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.alert_tos_blog_post);
                if (linkifiedTextView != null) {
                    i = C5419R.id.alert_tos_community_guidelines;
                    LinkifiedTextView linkifiedTextView2 = (LinkifiedTextView) view.findViewById(C5419R.id.alert_tos_community_guidelines);
                    if (linkifiedTextView2 != null) {
                        i = C5419R.id.alert_tos_privacy_policy;
                        LinkifiedTextView linkifiedTextView3 = (LinkifiedTextView) view.findViewById(C5419R.id.alert_tos_privacy_policy);
                        if (linkifiedTextView3 != null) {
                            i = C5419R.id.alert_tos_terms_of_service;
                            LinkifiedTextView linkifiedTextView4 = (LinkifiedTextView) view.findViewById(C5419R.id.alert_tos_terms_of_service);
                            if (linkifiedTextView4 != null) {
                                i = C5419R.id.alert_tos_text_description_bottom;
                                TextView textView = (TextView) view.findViewById(C5419R.id.alert_tos_text_description_bottom);
                                if (textView != null) {
                                    i = C5419R.id.alert_tos_text_description_top;
                                    TextView textView2 = (TextView) view.findViewById(C5419R.id.alert_tos_text_description_top);
                                    if (textView2 != null) {
                                        i = C5419R.id.tos_icon;
                                        ImageView imageView = (ImageView) view.findViewById(C5419R.id.tos_icon);
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
