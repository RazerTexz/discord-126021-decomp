package androidx.fragment.app;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class FragmentManager$8 implements FragmentOnAttachListener {
    public final /* synthetic */ FragmentManager this$0;
    public final /* synthetic */ Fragment val$parent;

    public FragmentManager$8(FragmentManager fragmentManager, Fragment fragment) {
        this.this$0 = fragmentManager;
        this.val$parent = fragment;
    }

    @Override // androidx.fragment.app.FragmentOnAttachListener
    public void onAttachFragment(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        this.val$parent.onAttachFragment(fragment);
    }
}
