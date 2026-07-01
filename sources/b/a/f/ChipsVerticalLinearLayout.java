package b.a.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: b.a.f.e, reason: use source file name */
/* JADX INFO: compiled from: ChipsVerticalLinearLayout.kt */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ViewConstructor"})
public final class ChipsVerticalLinearLayout extends LinearLayout {
    public final List<LinearLayout> j;
    public final int k;

    /* JADX INFO: renamed from: b.a.f.e$a */
    /* JADX INFO: compiled from: ChipsVerticalLinearLayout.kt */
    public static final class a {
        public int a;

        public a(int i, int i2) {
            this.a = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChipsVerticalLinearLayout(Context context, int i) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        this.k = i;
        this.j = new ArrayList();
        setOrientation(1);
    }

    public final LinearLayout a() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, this.k));
        linearLayout.setPadding(0, 0, 0, 0);
        linearLayout.setOrientation(0);
        addView(linearLayout);
        this.j.add(linearLayout);
        return linearLayout;
    }
}
