package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: compiled from: VoiceUserLimitViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class k4 implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f148b;

    @NonNull
    public final TextView c;

    public k4(@NonNull View view, @NonNull TextView textView, @NonNull TextView textView2) {
        this.a = view;
        this.f148b = textView;
        this.c = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
