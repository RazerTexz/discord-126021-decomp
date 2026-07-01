package com.discord.widgets.voice.fullscreen;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.a.i.q0;
import com.discord.R$id;
import com.discord.databinding.WidgetCallPreviewFullscreenBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetCallPreviewFullscreen$binding$2 extends k implements Function1<View, WidgetCallPreviewFullscreenBinding> {
    public static final WidgetCallPreviewFullscreen$binding$2 INSTANCE = new WidgetCallPreviewFullscreen$binding$2();

    public WidgetCallPreviewFullscreen$binding$2() {
        super(1, WidgetCallPreviewFullscreenBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetCallPreviewFullscreenBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetCallPreviewFullscreenBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetCallPreviewFullscreenBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = 2131361878;
        Toolbar toolbar = (Toolbar) view.findViewById(2131361878);
        if (toolbar != null) {
            i = 2131361879;
            AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(2131361879);
            if (appBarLayout != null) {
                i = R$id.call_fullscreen_body;
                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R$id.call_fullscreen_body);
                if (constraintLayout != null) {
                    i = R$id.call_fullscreen_mentions;
                    TextView textView = (TextView) view.findViewById(R$id.call_fullscreen_mentions);
                    if (textView != null) {
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                        i = R$id.call_preview_join_buttons;
                        ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R$id.call_preview_join_buttons);
                        if (constraintLayout3 != null) {
                            i = R$id.call_preview_join_muted;
                            MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.call_preview_join_muted);
                            if (materialButton != null) {
                                i = R$id.call_preview_join_voice;
                                MaterialButton materialButton2 = (MaterialButton) view.findViewById(R$id.call_preview_join_voice);
                                if (materialButton2 != null) {
                                    i = R$id.call_preview_nsfw;
                                    ViewStub viewStub = (ViewStub) view.findViewById(R$id.call_preview_nsfw);
                                    if (viewStub != null) {
                                        i = R$id.call_preview_voice_sheet_recycler;
                                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.call_preview_voice_sheet_recycler);
                                        if (recyclerView != null) {
                                            i = R$id.empty;
                                            View viewFindViewById = view.findViewById(R$id.empty);
                                            if (viewFindViewById != null) {
                                                int i2 = R$id.fullscreen_call_preview_empty_image;
                                                ImageView imageView = (ImageView) viewFindViewById.findViewById(R$id.fullscreen_call_preview_empty_image);
                                                if (imageView != null) {
                                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) viewFindViewById;
                                                    i2 = R$id.fullscreen_call_preview_header;
                                                    TextView textView2 = (TextView) viewFindViewById.findViewById(R$id.fullscreen_call_preview_header);
                                                    if (textView2 != null) {
                                                        i2 = R$id.fullscreen_call_preview_subtitle;
                                                        TextView textView3 = (TextView) viewFindViewById.findViewById(R$id.fullscreen_call_preview_subtitle);
                                                        if (textView3 != null) {
                                                            return new WidgetCallPreviewFullscreenBinding(constraintLayout2, toolbar, appBarLayout, constraintLayout, textView, constraintLayout2, constraintLayout3, materialButton, materialButton2, viewStub, recyclerView, new q0(constraintLayout4, imageView, constraintLayout4, textView2, textView3));
                                                        }
                                                    }
                                                }
                                                throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById.getResources().getResourceName(i2)));
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
