package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: renamed from: b.a.i.z4, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatListAdapterItemSingleLineMessagePreviewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemSingleLineMessagePreviewBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f241b;

    @NonNull
    public final LinkifiedTextView c;

    @NonNull
    public final SimpleDraweeView d;

    @NonNull
    public final TextView e;

    public WidgetChatListAdapterItemSingleLineMessagePreviewBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull Guideline guideline, @NonNull Guideline guideline2, @NonNull Guideline guideline3) {
        this.a = constraintLayout;
        this.f241b = imageView;
        this.c = linkifiedTextView;
        this.d = simpleDraweeView;
        this.e = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
