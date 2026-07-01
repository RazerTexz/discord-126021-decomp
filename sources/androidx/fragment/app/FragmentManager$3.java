package androidx.fragment.app;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class FragmentManager$3 extends FragmentFactory {
    public final /* synthetic */ FragmentManager this$0;

    public FragmentManager$3(FragmentManager fragmentManager) {
        this.this$0 = fragmentManager;
    }

    @Override // androidx.fragment.app.FragmentFactory
    @NonNull
    public Fragment instantiate(@NonNull ClassLoader classLoader, @NonNull String str) {
        return this.this$0.getHost().instantiate(this.this$0.getHost().getContext(), str, null);
    }
}
