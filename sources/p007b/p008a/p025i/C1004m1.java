package p007b.p008a.p025i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.UsernameView;
import com.facebook.drawee.span.SimpleDraweeSpanTextView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: renamed from: b.a.i.m1 */
/* JADX INFO: compiled from: SettingsMemberViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1004m1 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f1043a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f1044b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final SimpleDraweeSpanTextView f1045c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final UsernameView f1046d;

    public C1004m1(@NonNull View view, @NonNull SimpleDraweeView simpleDraweeView, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView, @NonNull UsernameView usernameView) {
        this.f1043a = view;
        this.f1044b = simpleDraweeView;
        this.f1045c = simpleDraweeSpanTextView;
        this.f1046d = usernameView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1043a;
    }
}
