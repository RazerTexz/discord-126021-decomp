package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.StreamPreviewView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: renamed from: b.a.i.d6 */
/* JADX INFO: compiled from: WidgetStreamRichPresenceBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0942d6 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f792a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LinearLayout f793b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f794c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f795d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final SimpleDraweeView f796e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f797f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f798g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final TextView f799h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final StreamPreviewView f800i;

    public C0942d6(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull StreamPreviewView streamPreviewView) {
        this.f792a = constraintLayout;
        this.f793b = linearLayout;
        this.f794c = textView;
        this.f795d = textView2;
        this.f796e = simpleDraweeView;
        this.f797f = textView3;
        this.f798g = textView4;
        this.f799h = textView5;
        this.f800i = streamPreviewView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f792a;
    }
}
