package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.t3 */
/* JADX INFO: compiled from: ViewSettingsPremiumGuildNoGuildsBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1055t3 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayoutCompat f1250a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f1251b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f1252c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f1253d;

    public C1055t3(@NonNull LinearLayoutCompat linearLayoutCompat, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f1250a = linearLayoutCompat;
        this.f1251b = imageView;
        this.f1252c = textView;
        this.f1253d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1250a;
    }
}
