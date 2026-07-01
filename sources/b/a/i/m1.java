package b.a.i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.UsernameView;
import com.facebook.drawee.span.SimpleDraweeSpanTextView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: compiled from: SettingsMemberViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class m1 implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeView f158b;

    @NonNull
    public final SimpleDraweeSpanTextView c;

    @NonNull
    public final UsernameView d;

    public m1(@NonNull View view, @NonNull SimpleDraweeView simpleDraweeView, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView, @NonNull UsernameView usernameView) {
        this.a = view;
        this.f158b = simpleDraweeView;
        this.c = simpleDraweeSpanTextView;
        this.d = usernameView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
