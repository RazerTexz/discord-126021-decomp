package p007b.p008a.p025i;

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
import com.discord.C5419R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.g6 */
/* JADX INFO: compiled from: WidgetUserRichPresenceBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0966g6 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f880a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LinearLayout f881b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f882c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f883d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final SimpleDraweeView f884e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final SimpleDraweeView f885f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final MaterialButton f886g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final MaterialButton f887h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final TextView f888i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final TextView f889j;

    /* JADX INFO: renamed from: k */
    @NonNull
    public final TextView f890k;

    public C0966g6(@NonNull LinearLayout linearLayout, @NonNull Barrier barrier, @NonNull Space space, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5) {
        this.f880a = linearLayout;
        this.f881b = linearLayout2;
        this.f882c = textView;
        this.f883d = textView2;
        this.f884e = simpleDraweeView;
        this.f885f = simpleDraweeView2;
        this.f886g = materialButton;
        this.f887h = materialButton2;
        this.f888i = textView3;
        this.f889j = textView4;
        this.f890k = textView5;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static C0966g6 m201a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(C5419R.layout.widget_user_rich_presence, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        int i = C5419R.id.barrier;
        Barrier barrier = (Barrier) viewInflate.findViewById(C5419R.id.barrier);
        if (barrier != null) {
            i = C5419R.id.image_bottom_guideline;
            Space space = (Space) viewInflate.findViewById(C5419R.id.image_bottom_guideline);
            if (space != null) {
                i = C5419R.id.rich_presence_container_data;
                LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(C5419R.id.rich_presence_container_data);
                if (linearLayout != null) {
                    i = C5419R.id.rich_presence_details;
                    TextView textView = (TextView) viewInflate.findViewById(C5419R.id.rich_presence_details);
                    if (textView != null) {
                        i = C5419R.id.rich_presence_header;
                        TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.rich_presence_header);
                        if (textView2 != null) {
                            i = C5419R.id.rich_presence_image_large;
                            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(C5419R.id.rich_presence_image_large);
                            if (simpleDraweeView != null) {
                                i = C5419R.id.rich_presence_image_small;
                                SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) viewInflate.findViewById(C5419R.id.rich_presence_image_small);
                                if (simpleDraweeView2 != null) {
                                    i = C5419R.id.rich_presence_primary_button;
                                    MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(C5419R.id.rich_presence_primary_button);
                                    if (materialButton != null) {
                                        i = C5419R.id.rich_presence_secondary_button;
                                        MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(C5419R.id.rich_presence_secondary_button);
                                        if (materialButton2 != null) {
                                            i = C5419R.id.rich_presence_state;
                                            TextView textView3 = (TextView) viewInflate.findViewById(C5419R.id.rich_presence_state);
                                            if (textView3 != null) {
                                                i = C5419R.id.rich_presence_time;
                                                TextView textView4 = (TextView) viewInflate.findViewById(C5419R.id.rich_presence_time);
                                                if (textView4 != null) {
                                                    i = C5419R.id.rich_presence_title;
                                                    TextView textView5 = (TextView) viewInflate.findViewById(C5419R.id.rich_presence_title);
                                                    if (textView5 != null) {
                                                        return new C0966g6((LinearLayout) viewInflate, barrier, space, linearLayout, textView, textView2, simpleDraweeView, simpleDraweeView2, materialButton, materialButton2, textView3, textView4, textView5);
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
        return this.f880a;
    }
}
