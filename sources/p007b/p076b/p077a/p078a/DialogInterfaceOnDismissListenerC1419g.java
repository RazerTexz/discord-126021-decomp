package p007b.p076b.p077a.p078a;

import android.content.DialogInterface;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.b.a.a.g */
/* JADX INFO: compiled from: FlexInputFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DialogInterfaceOnDismissListenerC1419g implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ FlexInputFragment f2134j;

    public DialogInterfaceOnDismissListenerC1419g(FlexInputFragment flexInputFragment) {
        this.f2134j = flexInputFragment;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        FlexInputViewModel flexInputViewModel;
        if (!this.f2134j.isAdded() || this.f2134j.isHidden() || (flexInputViewModel = this.f2134j.viewModel) == null) {
            return;
        }
        C3404f.m4232O0(flexInputViewModel, false, 1, null);
    }
}
