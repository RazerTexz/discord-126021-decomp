package p007b.p008a.p021f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.f.e */
/* JADX INFO: compiled from: ChipsVerticalLinearLayout.kt */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ViewConstructor"})
public final class C0899e extends LinearLayout {

    /* JADX INFO: renamed from: j */
    public final List<LinearLayout> f618j;

    /* JADX INFO: renamed from: k */
    public final int f619k;

    /* JADX INFO: renamed from: b.a.f.e$a */
    /* JADX INFO: compiled from: ChipsVerticalLinearLayout.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public int f620a;

        public a(int i, int i2) {
            this.f620a = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0899e(Context context, int i) {
        super(context);
        C12238m.checkNotNullParameter(context, "context");
        this.f619k = i;
        this.f618j = new ArrayList();
        setOrientation(1);
    }

    /* JADX INFO: renamed from: a */
    public final LinearLayout m188a() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, this.f619k));
        linearLayout.setPadding(0, 0, 0, 0);
        linearLayout.setOrientation(0);
        addView(linearLayout);
        this.f618j.add(linearLayout);
        return linearLayout;
    }
}
