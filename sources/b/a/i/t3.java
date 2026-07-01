package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: compiled from: ViewSettingsPremiumGuildNoGuildsBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class t3 implements ViewBinding {

    @NonNull
    public final LinearLayoutCompat a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f204b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public t3(@NonNull LinearLayoutCompat linearLayoutCompat, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.a = linearLayoutCompat;
        this.f204b = imageView;
        this.c = textView;
        this.d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
