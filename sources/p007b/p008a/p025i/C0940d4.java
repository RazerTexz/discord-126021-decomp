package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.StatusView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: renamed from: b.a.i.d4 */
/* JADX INFO: compiled from: ViewUserListItemBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0940d4 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f783a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f784b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f785c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f786d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final StatusView f787e;

    public C0940d4(@NonNull View view, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull StatusView statusView) {
        this.f783a = view;
        this.f784b = simpleDraweeView;
        this.f785c = textView;
        this.f786d = textView2;
        this.f787e = statusView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f783a;
    }
}
