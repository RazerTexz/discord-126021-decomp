package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.t3, reason: use source file name */
/* JADX INFO: compiled from: ViewSettingsPremiumGuildNoGuildsBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ViewSettingsPremiumGuildNoGuildsBinding implements ViewBinding {

    @NonNull
    public final LinearLayoutCompat a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f204b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public ViewSettingsPremiumGuildNoGuildsBinding(@NonNull LinearLayoutCompat linearLayoutCompat, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2) {
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
