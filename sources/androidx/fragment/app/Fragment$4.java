package androidx.fragment.app;

import android.view.View;
import androidx.annotation.Nullable;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class Fragment$4 extends FragmentContainer {
    public final /* synthetic */ Fragment this$0;

    public Fragment$4(Fragment fragment) {
        this.this$0 = fragment;
    }

    @Override // androidx.fragment.app.FragmentContainer
    @Nullable
    public View onFindViewById(int i) {
        View view = this.this$0.mView;
        if (view != null) {
            return view.findViewById(i);
        }
        StringBuilder sbU = a.U("Fragment ");
        sbU.append(this.this$0);
        sbU.append(" does not have a view");
        throw new IllegalStateException(sbU.toString());
    }

    @Override // androidx.fragment.app.FragmentContainer
    public boolean onHasView() {
        return this.this$0.mView != null;
    }
}
