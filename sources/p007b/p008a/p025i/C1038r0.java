package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: renamed from: b.a.i.r0 */
/* JADX INFO: compiled from: LayoutIconUploaderBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1038r0 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f1173a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f1174b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final Group f1175c;

    public C1038r0(@NonNull ConstraintLayout constraintLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull ImageView imageView3, @NonNull Group group) {
        this.f1173a = constraintLayout;
        this.f1174b = simpleDraweeView;
        this.f1175c = group;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static C1038r0 m204a(@NonNull View view) {
        int i = C5419R.id.icon_uploader_image;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.icon_uploader_image);
        if (simpleDraweeView != null) {
            i = C5419R.id.icon_uploader_placeholder_border;
            ImageView imageView = (ImageView) view.findViewById(C5419R.id.icon_uploader_placeholder_border);
            if (imageView != null) {
                i = C5419R.id.icon_uploader_placeholder_icon;
                ImageView imageView2 = (ImageView) view.findViewById(C5419R.id.icon_uploader_placeholder_icon);
                if (imageView2 != null) {
                    i = C5419R.id.icon_uploader_placeholder_text;
                    TextView textView = (TextView) view.findViewById(C5419R.id.icon_uploader_placeholder_text);
                    if (textView != null) {
                        i = C5419R.id.icon_uploader_plus;
                        ImageView imageView3 = (ImageView) view.findViewById(C5419R.id.icon_uploader_plus);
                        if (imageView3 != null) {
                            i = C5419R.id.placeholder_group;
                            Group group = (Group) view.findViewById(C5419R.id.placeholder_group);
                            if (group != null) {
                                return new C1038r0((ConstraintLayout) view, simpleDraweeView, imageView, imageView2, textView, imageView3, group);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1173a;
    }
}
