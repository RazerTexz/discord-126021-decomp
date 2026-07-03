package p007b.p008a.p025i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.x */
/* JADX INFO: compiled from: GuildChannelSideBarActionsViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1079x implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f1362a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f1363b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f1364c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialButton f1365d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final MaterialButton f1366e;

    public C1079x(@NonNull View view, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull MaterialButton materialButton3, @NonNull MaterialButton materialButton4) {
        this.f1362a = view;
        this.f1363b = materialButton;
        this.f1364c = materialButton2;
        this.f1365d = materialButton3;
        this.f1366e = materialButton4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1362a;
    }
}
