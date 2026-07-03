package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.radiobutton.MaterialRadioButton;

/* JADX INFO: renamed from: b.a.i.b */
/* JADX INFO: compiled from: AudioOutputSelectionDialogBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0919b implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f685a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialRadioButton f686b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final RadioGroup f687c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialRadioButton f688d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final MaterialRadioButton f689e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final MaterialRadioButton f690f;

    public C0919b(@NonNull LinearLayout linearLayout, @NonNull MaterialRadioButton materialRadioButton, @NonNull TextView textView, @NonNull RadioGroup radioGroup, @NonNull MaterialRadioButton materialRadioButton2, @NonNull MaterialRadioButton materialRadioButton3, @NonNull MaterialRadioButton materialRadioButton4) {
        this.f685a = linearLayout;
        this.f686b = materialRadioButton;
        this.f687c = radioGroup;
        this.f688d = materialRadioButton2;
        this.f689e = materialRadioButton3;
        this.f690f = materialRadioButton4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f685a;
    }
}
