package b.a.i;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Barrier;
import androidx.viewbinding.ViewBinding;
import com.discord.R$id;
import com.discord.R$layout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: compiled from: WidgetUserRichPresenceBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class g6 implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f122b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final SimpleDraweeView e;

    @NonNull
    public final SimpleDraweeView f;

    @NonNull
    public final MaterialButton g;

    @NonNull
    public final MaterialButton h;

    @NonNull
    public final TextView i;

    @NonNull
    public final TextView j;

    @NonNull
    public final TextView k;

    public g6(@NonNull LinearLayout linearLayout, @NonNull Barrier barrier, @NonNull Space space, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5) {
        this.a = linearLayout;
        this.f122b = linearLayout2;
        this.c = textView;
        this.d = textView2;
        this.e = simpleDraweeView;
        this.f = simpleDraweeView2;
        this.g = materialButton;
        this.h = materialButton2;
        this.i = textView3;
        this.j = textView4;
        this.k = textView5;
    }

    @NonNull
    public static g6 a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R$layout.widget_user_rich_presence, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        int i = 2131362146;
        Barrier barrier = (Barrier) viewInflate.findViewById(2131362146);
        if (barrier != null) {
            i = R$id.image_bottom_guideline;
            Space space = (Space) viewInflate.findViewById(R$id.image_bottom_guideline);
            if (space != null) {
                i = R$id.rich_presence_container_data;
                LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R$id.rich_presence_container_data);
                if (linearLayout != null) {
                    i = R$id.rich_presence_details;
                    TextView textView = (TextView) viewInflate.findViewById(R$id.rich_presence_details);
                    if (textView != null) {
                        i = R$id.rich_presence_header;
                        TextView textView2 = (TextView) viewInflate.findViewById(R$id.rich_presence_header);
                        if (textView2 != null) {
                            i = R$id.rich_presence_image_large;
                            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R$id.rich_presence_image_large);
                            if (simpleDraweeView != null) {
                                i = R$id.rich_presence_image_small;
                                SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) viewInflate.findViewById(R$id.rich_presence_image_small);
                                if (simpleDraweeView2 != null) {
                                    i = R$id.rich_presence_primary_button;
                                    MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R$id.rich_presence_primary_button);
                                    if (materialButton != null) {
                                        i = R$id.rich_presence_secondary_button;
                                        MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(R$id.rich_presence_secondary_button);
                                        if (materialButton2 != null) {
                                            i = R$id.rich_presence_state;
                                            TextView textView3 = (TextView) viewInflate.findViewById(R$id.rich_presence_state);
                                            if (textView3 != null) {
                                                i = R$id.rich_presence_time;
                                                TextView textView4 = (TextView) viewInflate.findViewById(R$id.rich_presence_time);
                                                if (textView4 != null) {
                                                    i = R$id.rich_presence_title;
                                                    TextView textView5 = (TextView) viewInflate.findViewById(R$id.rich_presence_title);
                                                    if (textView5 != null) {
                                                        return new g6((LinearLayout) viewInflate, barrier, space, linearLayout, textView, textView2, simpleDraweeView, simpleDraweeView2, materialButton, materialButton2, textView3, textView4, textView5);
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
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
