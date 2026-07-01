package androidx.fragment.app;

import androidx.activity.OnBackPressedCallback;

/* JADX INFO: loaded from: classes.dex */
public class FragmentManager$1 extends OnBackPressedCallback {
    public final /* synthetic */ FragmentManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentManager$1(FragmentManager fragmentManager, boolean z2) {
        super(z2);
        this.this$0 = fragmentManager;
    }

    @Override // androidx.activity.OnBackPressedCallback
    public void handleOnBackPressed() {
        this.this$0.handleOnBackPressed();
    }
}
