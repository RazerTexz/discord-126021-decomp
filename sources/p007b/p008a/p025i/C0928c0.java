package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;

/* JADX INFO: renamed from: b.a.i.c0 */
/* JADX INFO: compiled from: ImageUploadFailedDialogBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0928c0 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f726a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f727b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final SwitchMaterial f728c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final RelativeLayout f729d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final View f730e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final MaterialButton f731f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final RelativeLayout f732g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final MaterialButton f733h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final MaterialButton f734i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final TextView f735j;

    public C0928c0(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull MaterialButton materialButton, @NonNull SwitchMaterial switchMaterial, @NonNull RelativeLayout relativeLayout2, @NonNull View view, @NonNull MaterialButton materialButton2, @NonNull RelativeLayout relativeLayout3, @NonNull MaterialButton materialButton3, @NonNull MaterialButton materialButton4, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f726a = relativeLayout;
        this.f727b = materialButton;
        this.f728c = switchMaterial;
        this.f729d = relativeLayout2;
        this.f730e = view;
        this.f731f = materialButton2;
        this.f732g = relativeLayout3;
        this.f733h = materialButton3;
        this.f734i = materialButton4;
        this.f735j = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f726a;
    }
}
