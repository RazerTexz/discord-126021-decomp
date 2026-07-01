package com.discord.widgets.changelog;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.VideoView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.widget.NestedScrollView;
import com.discord.R$id;
import com.discord.databinding.WidgetChangeLogBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChangeLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChangeLog$binding$2 extends k implements Function1<View, WidgetChangeLogBinding> {
    public static final WidgetChangeLog$binding$2 INSTANCE = new WidgetChangeLog$binding$2();

    public WidgetChangeLog$binding$2() {
        super(1, WidgetChangeLogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChangeLogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetChangeLogBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetChangeLogBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.change_log_body;
        LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R$id.change_log_body);
        if (linkifiedTextView != null) {
            i = R$id.change_log_contents;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.change_log_contents);
            if (linearLayout != null) {
                i = R$id.change_log_facebook;
                AppCompatImageButton appCompatImageButton = (AppCompatImageButton) view.findViewById(R$id.change_log_facebook);
                if (appCompatImageButton != null) {
                    i = R$id.change_log_instagram;
                    AppCompatImageButton appCompatImageButton2 = (AppCompatImageButton) view.findViewById(R$id.change_log_instagram);
                    if (appCompatImageButton2 != null) {
                        i = R$id.change_log_scrollview;
                        NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R$id.change_log_scrollview);
                        if (nestedScrollView != null) {
                            i = R$id.change_log_thumbnail;
                            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.change_log_thumbnail);
                            if (simpleDraweeView != null) {
                                i = R$id.change_log_twitter;
                                AppCompatImageButton appCompatImageButton3 = (AppCompatImageButton) view.findViewById(R$id.change_log_twitter);
                                if (appCompatImageButton3 != null) {
                                    i = R$id.change_log_video;
                                    VideoView videoView = (VideoView) view.findViewById(R$id.change_log_video);
                                    if (videoView != null) {
                                        i = R$id.change_log_video_overlay;
                                        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) view.findViewById(R$id.change_log_video_overlay);
                                        if (simpleDraweeView2 != null) {
                                            return new WidgetChangeLogBinding((LinearLayout) view, linkifiedTextView, linearLayout, appCompatImageButton, appCompatImageButton2, nestedScrollView, simpleDraweeView, appCompatImageButton3, videoView, simpleDraweeView2);
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
