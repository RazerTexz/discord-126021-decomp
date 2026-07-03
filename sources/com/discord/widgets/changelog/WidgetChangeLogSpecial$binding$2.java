package com.discord.widgets.changelog;

import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import com.discord.C5419R;
import com.discord.databinding.WidgetChangeLogSpecialBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChangeLogSpecial.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChangeLogSpecial$binding$2 extends C12236k implements Function1<View, WidgetChangeLogSpecialBinding> {
    public static final WidgetChangeLogSpecial$binding$2 INSTANCE = new WidgetChangeLogSpecial$binding$2();

    public WidgetChangeLogSpecial$binding$2() {
        super(1, WidgetChangeLogSpecialBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChangeLogSpecialBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetChangeLogSpecialBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.change_log_body;
        LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.change_log_body);
        if (linkifiedTextView != null) {
            i = C5419R.id.change_log_special_back;
            ImageButton imageButton = (ImageButton) view.findViewById(C5419R.id.change_log_special_back);
            if (imageButton != null) {
                i = C5419R.id.change_log_special_button;
                MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.change_log_special_button);
                if (materialButton != null) {
                    i = C5419R.id.change_log_special_close;
                    ImageButton imageButton2 = (ImageButton) view.findViewById(C5419R.id.change_log_special_close);
                    if (imageButton2 != null) {
                        i = C5419R.id.change_log_special_contents;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.change_log_special_contents);
                        if (linearLayout != null) {
                            i = C5419R.id.change_log_special_cta_body;
                            TextView textView = (TextView) view.findViewById(C5419R.id.change_log_special_cta_body);
                            if (textView != null) {
                                i = C5419R.id.change_log_special_date;
                                TextView textView2 = (TextView) view.findViewById(C5419R.id.change_log_special_date);
                                if (textView2 != null) {
                                    i = C5419R.id.change_log_special_scrollview;
                                    NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(C5419R.id.change_log_special_scrollview);
                                    if (nestedScrollView != null) {
                                        i = C5419R.id.change_log_thumbnail;
                                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.change_log_thumbnail);
                                        if (simpleDraweeView != null) {
                                            i = C5419R.id.change_log_video;
                                            VideoView videoView = (VideoView) view.findViewById(C5419R.id.change_log_video);
                                            if (videoView != null) {
                                                i = C5419R.id.change_log_video_overlay;
                                                SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) view.findViewById(C5419R.id.change_log_video_overlay);
                                                if (simpleDraweeView2 != null) {
                                                    i = C5419R.id.changelog_special_header_container;
                                                    CardView cardView = (CardView) view.findViewById(C5419R.id.changelog_special_header_container);
                                                    if (cardView != null) {
                                                        i = C5419R.id.changelog_special_video;
                                                        CardView cardView2 = (CardView) view.findViewById(C5419R.id.changelog_special_video);
                                                        if (cardView2 != null) {
                                                            return new WidgetChangeLogSpecialBinding((LinearLayout) view, linkifiedTextView, imageButton, materialButton, imageButton2, linearLayout, textView, textView2, nestedScrollView, simpleDraweeView, videoView, simpleDraweeView2, cardView, cardView2);
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
