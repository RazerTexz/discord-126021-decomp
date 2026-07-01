package com.lytefast.flexinput.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.recyclerview.widget.RecyclerView;
import b.b.a.e.a;
import com.lytefast.flexinput.R$f;
import com.lytefast.flexinput.widget.FlexEditText;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: FlexInputFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class FlexInputFragment$c extends k implements Function1<View, a> {
    public static final FlexInputFragment$c j = new FlexInputFragment$c();

    public FlexInputFragment$c() {
        super(1, a.class, "bind", "bind(Landroid/view/View;)Lcom/lytefast/flexinput/databinding/FlexInputWidgetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public a invoke(View view) {
        View view2 = view;
        m.checkNotNullParameter(view2, "p1");
        int i = R$f.attachment_clear_btn;
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) view2.findViewById(i);
        if (appCompatImageButton != null) {
            i = R$f.attachment_preview_container;
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(i);
            if (linearLayout != null) {
                i = R$f.attachment_preview_list;
                RecyclerView recyclerView = (RecyclerView) view2.findViewById(i);
                if (recyclerView != null) {
                    i = R$f.cannot_send_text;
                    TextView textView = (TextView) view2.findViewById(i);
                    if (textView != null) {
                        LinearLayout linearLayout2 = (LinearLayout) view2;
                        i = R$f.default_window_insets_handler;
                        FrameLayout frameLayout = (FrameLayout) view2.findViewById(i);
                        if (frameLayout != null) {
                            i = R$f.expand_btn;
                            AppCompatImageButton appCompatImageButton2 = (AppCompatImageButton) view2.findViewById(i);
                            if (appCompatImageButton2 != null) {
                                i = R$f.expression_btn;
                                AppCompatImageButton appCompatImageButton3 = (AppCompatImageButton) view2.findViewById(i);
                                if (appCompatImageButton3 != null) {
                                    i = R$f.expression_btn_badge;
                                    ImageView imageView = (ImageView) view2.findViewById(i);
                                    if (imageView != null) {
                                        i = R$f.expression_btn_container;
                                        FrameLayout frameLayout2 = (FrameLayout) view2.findViewById(i);
                                        if (frameLayout2 != null) {
                                            i = R$f.expression_tray_container;
                                            FrameLayout frameLayout3 = (FrameLayout) view2.findViewById(i);
                                            if (frameLayout3 != null) {
                                                i = R$f.gallery_btn;
                                                AppCompatImageButton appCompatImageButton4 = (AppCompatImageButton) view2.findViewById(i);
                                                if (appCompatImageButton4 != null) {
                                                    i = R$f.gift_btn;
                                                    AppCompatImageButton appCompatImageButton5 = (AppCompatImageButton) view2.findViewById(i);
                                                    if (appCompatImageButton5 != null) {
                                                        i = R$f.left_btns_container;
                                                        LinearLayout linearLayout3 = (LinearLayout) view2.findViewById(i);
                                                        if (linearLayout3 != null) {
                                                            i = R$f.main_input_container;
                                                            LinearLayout linearLayout4 = (LinearLayout) view2.findViewById(i);
                                                            if (linearLayout4 != null) {
                                                                i = R$f.send_btn_container;
                                                                FrameLayout frameLayout4 = (FrameLayout) view2.findViewById(i);
                                                                if (frameLayout4 != null) {
                                                                    i = R$f.send_btn_image;
                                                                    ImageView imageView2 = (ImageView) view2.findViewById(i);
                                                                    if (imageView2 != null) {
                                                                        i = R$f.text_input;
                                                                        FlexEditText flexEditText = (FlexEditText) view2.findViewById(i);
                                                                        if (flexEditText != null) {
                                                                            return new a(linearLayout2, appCompatImageButton, linearLayout, recyclerView, textView, linearLayout2, frameLayout, appCompatImageButton2, appCompatImageButton3, imageView, frameLayout2, frameLayout3, appCompatImageButton4, appCompatImageButton5, linearLayout3, linearLayout4, frameLayout4, imageView2, flexEditText);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
