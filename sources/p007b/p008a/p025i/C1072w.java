package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.w */
/* JADX INFO: compiled from: GuildBoostUpsellDialogBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1072w implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f1328a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f1329b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f1330c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialButton f1331d;

    public C1072w(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull MaterialButton materialButton) {
        this.f1328a = relativeLayout;
        this.f1329b = imageView;
        this.f1330c = textView;
        this.f1331d = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1328a;
    }
}
