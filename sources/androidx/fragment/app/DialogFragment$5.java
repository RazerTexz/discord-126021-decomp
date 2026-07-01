package androidx.fragment.app;

import android.view.View;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class DialogFragment$5 extends FragmentContainer {
    public final /* synthetic */ DialogFragment this$0;
    public final /* synthetic */ FragmentContainer val$fragmentContainer;

    public DialogFragment$5(DialogFragment dialogFragment, FragmentContainer fragmentContainer) {
        this.this$0 = dialogFragment;
        this.val$fragmentContainer = fragmentContainer;
    }

    @Override // androidx.fragment.app.FragmentContainer
    @Nullable
    public View onFindViewById(int i) {
        View viewOnFindViewById = this.this$0.onFindViewById(i);
        if (viewOnFindViewById != null) {
            return viewOnFindViewById;
        }
        if (this.val$fragmentContainer.onHasView()) {
            return this.val$fragmentContainer.onFindViewById(i);
        }
        return null;
    }

    @Override // androidx.fragment.app.FragmentContainer
    public boolean onHasView() {
        return this.this$0.onHasView() || this.val$fragmentContainer.onHasView();
    }
}
