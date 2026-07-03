package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: renamed from: b.a.i.z4 */
/* JADX INFO: compiled from: WidgetChatListAdapterItemSingleLineMessagePreviewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1098z4 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f1444a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f1445b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final LinkifiedTextView f1446c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final SimpleDraweeView f1447d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f1448e;

    public C1098z4(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull Guideline guideline, @NonNull Guideline guideline2, @NonNull Guideline guideline3) {
        this.f1444a = constraintLayout;
        this.f1445b = imageView;
        this.f1446c = linkifiedTextView;
        this.f1447d = simpleDraweeView;
        this.f1448e = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1444a;
    }
}
