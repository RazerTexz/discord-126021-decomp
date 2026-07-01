package com.discord.widgets.voice.sheet;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.a.i.t0;
import b.a.i.u0;
import com.discord.R$id;
import com.discord.databinding.WidgetVoiceBottomSheetBinding;
import com.discord.widgets.voice.controls.AnchoredVoiceControlsView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetVoiceBottomSheet$binding$2 extends k implements Function1<View, WidgetVoiceBottomSheetBinding> {
    public static final WidgetVoiceBottomSheet$binding$2 INSTANCE = new WidgetVoiceBottomSheet$binding$2();

    public WidgetVoiceBottomSheet$binding$2() {
        super(1, WidgetVoiceBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetVoiceBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetVoiceBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetVoiceBottomSheetBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.empty;
        View viewFindViewById = view.findViewById(R$id.empty);
        if (viewFindViewById != null) {
            t0 t0Var = new t0((LinearLayout) viewFindViewById);
            i = R$id.header;
            View viewFindViewById2 = view.findViewById(R$id.header);
            if (viewFindViewById2 != null) {
                int i2 = R$id.title_text_barrier;
                Barrier barrier = (Barrier) viewFindViewById2.findViewById(R$id.title_text_barrier);
                if (barrier != null) {
                    i2 = R$id.voice_bottom_sheet_header_deafen;
                    ImageView imageView = (ImageView) viewFindViewById2.findViewById(R$id.voice_bottom_sheet_header_deafen);
                    if (imageView != null) {
                        i2 = R$id.voice_bottom_sheet_header_icon;
                        ImageView imageView2 = (ImageView) viewFindViewById2.findViewById(R$id.voice_bottom_sheet_header_icon);
                        if (imageView2 != null) {
                            i2 = R$id.voice_bottom_sheet_header_invite;
                            ImageView imageView3 = (ImageView) viewFindViewById2.findViewById(R$id.voice_bottom_sheet_header_invite);
                            if (imageView3 != null) {
                                i2 = R$id.voice_bottom_sheet_header_noise_cancellation;
                                ImageView imageView4 = (ImageView) viewFindViewById2.findViewById(R$id.voice_bottom_sheet_header_noise_cancellation);
                                if (imageView4 != null) {
                                    i2 = R$id.voice_bottom_sheet_header_settings;
                                    ImageView imageView5 = (ImageView) viewFindViewById2.findViewById(R$id.voice_bottom_sheet_header_settings);
                                    if (imageView5 != null) {
                                        i2 = R$id.voice_bottom_sheet_header_subtitle;
                                        TextView textView = (TextView) viewFindViewById2.findViewById(R$id.voice_bottom_sheet_header_subtitle);
                                        if (textView != null) {
                                            i2 = R$id.voice_bottom_sheet_header_title;
                                            TextView textView2 = (TextView) viewFindViewById2.findViewById(R$id.voice_bottom_sheet_header_title);
                                            if (textView2 != null) {
                                                u0 u0Var = new u0((ConstraintLayout) viewFindViewById2, barrier, imageView, imageView2, imageView3, imageView4, imageView5, textView, textView2);
                                                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R$id.voice_bottom_sheet_bottom_content_container);
                                                if (constraintLayout != null) {
                                                    MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.voice_bottom_sheet_connect);
                                                    if (materialButton != null) {
                                                        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R$id.voice_bottom_sheet_connect_container);
                                                        if (relativeLayout != null) {
                                                            AnchoredVoiceControlsView anchoredVoiceControlsView = (AnchoredVoiceControlsView) view.findViewById(R$id.voice_bottom_sheet_controls);
                                                            if (anchoredVoiceControlsView != null) {
                                                                MaterialButton materialButton2 = (MaterialButton) view.findViewById(R$id.voice_bottom_sheet_join_video);
                                                                if (materialButton2 != null) {
                                                                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.voice_bottom_sheet_recycler);
                                                                    if (recyclerView != null) {
                                                                        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view;
                                                                        return new WidgetVoiceBottomSheetBinding(coordinatorLayout, t0Var, u0Var, constraintLayout, materialButton, relativeLayout, anchoredVoiceControlsView, materialButton2, recyclerView, coordinatorLayout);
                                                                    }
                                                                    i = R$id.voice_bottom_sheet_recycler;
                                                                } else {
                                                                    i = R$id.voice_bottom_sheet_join_video;
                                                                }
                                                            } else {
                                                                i = R$id.voice_bottom_sheet_controls;
                                                            }
                                                        } else {
                                                            i = R$id.voice_bottom_sheet_connect_container;
                                                        }
                                                    } else {
                                                        i = R$id.voice_bottom_sheet_connect;
                                                    }
                                                } else {
                                                    i = R$id.voice_bottom_sheet_bottom_content_container;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById2.getResources().getResourceName(i2)));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
