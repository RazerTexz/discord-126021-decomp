package p007b.p008a.p062y;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.utilities.color.ColorCompat;
import java.util.Objects;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.y.f */
/* JADX INFO: compiled from: DividerDecoration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1329f extends DividerItemDecoration {

    /* JADX INFO: renamed from: a */
    public final int f2021a;

    /* JADX INFO: renamed from: b */
    public final int f2022b;

    /* JADX INFO: renamed from: c */
    public final int f2023c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1329f(Context context, int i, int i2, int i3, int i4, int i5) {
        super(context, i);
        i2 = (i5 & 4) != 0 ? ColorCompat.getThemedColor(context, C5419R.attr.colorPrimaryDivider) : i2;
        i3 = (i5 & 8) != 0 ? 0 : i3;
        i4 = (i5 & 16) != 0 ? 0 : i4;
        C12238m.checkNotNullParameter(context, "context");
        this.f2021a = i2;
        this.f2022b = i3;
        this.f2023c = i4;
        Drawable drawable = ContextCompat.getDrawable(context, C5419R.drawable.drawable_divider);
        if (drawable != null) {
            Drawable drawableWrap = DrawableCompat.wrap(drawable);
            DrawableCompat.setTint(drawableWrap, i2);
            setDrawable(drawableWrap);
        }
    }

    @Override // androidx.recyclerview.widget.DividerItemDecoration, androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        C12238m.checkNotNullParameter(canvas, "c");
        C12238m.checkNotNullParameter(recyclerView, "parent");
        C12238m.checkNotNullParameter(state, "state");
        int paddingLeft = recyclerView.getPaddingLeft() + this.f2022b;
        int width = (recyclerView.getWidth() - recyclerView.getPaddingRight()) - this.f2023c;
        Drawable drawable = getDrawable();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            C12238m.checkNotNullExpressionValue(childAt, "parent.getChildAt(i)");
            int bottom = childAt.getBottom();
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            int i2 = bottom + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) layoutParams)).bottomMargin;
            int intrinsicHeight = (drawable != null ? drawable.getIntrinsicHeight() : 0) + i2;
            if (drawable != null) {
                drawable.setBounds(paddingLeft, i2, width, intrinsicHeight);
            }
            if (drawable != null) {
                drawable.draw(canvas);
            }
        }
    }
}
