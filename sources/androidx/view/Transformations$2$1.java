package androidx.view;

import androidx.annotation.Nullable;

/* JADX INFO: Add missing generic type declarations: [Y] */
/* JADX INFO: loaded from: classes.dex */
public class Transformations$2$1<Y> implements Observer<Y> {
    public final /* synthetic */ Transformations$2 this$0;

    public Transformations$2$1(Transformations$2 transformations$2) {
        this.this$0 = transformations$2;
    }

    @Override // androidx.view.Observer
    public void onChanged(@Nullable Y y2) {
        this.this$0.val$result.setValue(y2);
    }
}
