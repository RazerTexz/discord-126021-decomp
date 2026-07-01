package b.a.y;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.utilities.color.ColorCompat;
import d0.z.d.Intrinsics3;
import java.util.Objects;

/* JADX INFO: renamed from: b.a.y.f, reason: use source file name */
/* JADX INFO: compiled from: DividerDecoration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DividerDecoration2 extends DividerItemDecoration {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f311b;
    public final int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DividerDecoration2(Context context, int i, int i2, int i3, int i4, int i5) {
        super(context, i);
        i2 = (i5 & 4) != 0 ? ColorCompat.getThemedColor(context, R.attr.colorPrimaryDivider) : i2;
        i3 = (i5 & 8) != 0 ? 0 : i3;
        i4 = (i5 & 16) != 0 ? 0 : i4;
        Intrinsics3.checkNotNullParameter(context, "context");
        this.a = i2;
        this.f311b = i3;
        this.c = i4;
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.drawable_divider);
        if (drawable != null) {
            Drawable drawableWrap = DrawableCompat.wrap(drawable);
            DrawableCompat.setTint(drawableWrap, i2);
            setDrawable(drawableWrap);
        }
    }

    @Override // androidx.recyclerview.widget.DividerItemDecoration, androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        Intrinsics3.checkNotNullParameter(canvas, "c");
        Intrinsics3.checkNotNullParameter(recyclerView, "parent");
        Intrinsics3.checkNotNullParameter(state, "state");
        int paddingLeft = recyclerView.getPaddingLeft() + this.f311b;
        int width = (recyclerView.getWidth() - recyclerView.getPaddingRight()) - this.c;
        Drawable drawable = getDrawable();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            Intrinsics3.checkNotNullExpressionValue(childAt, "parent.getChildAt(i)");
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
