package p007b.p225i.p226a.p341g.p352k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import com.google.android.material.C10817R;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RelativeCornerSize;

/* JADX INFO: renamed from: b.i.a.g.k.e */
/* JADX INFO: compiled from: RadialViewGroup.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4450e extends ConstraintLayout {

    /* JADX INFO: renamed from: j */
    public final Runnable f11861j;

    /* JADX INFO: renamed from: k */
    public int f11862k;

    /* JADX INFO: renamed from: l */
    public MaterialShapeDrawable f11863l;

    /* JADX INFO: renamed from: b.i.a.g.k.e$a */
    /* JADX INFO: compiled from: RadialViewGroup.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C4450e.this.m6170a();
        }
    }

    public C4450e(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: renamed from: a */
    public void m6170a() {
        int childCount = getChildCount();
        int i = 1;
        for (int i2 = 0; i2 < childCount; i2++) {
            if ("skip".equals(getChildAt(i2).getTag())) {
                i++;
            }
        }
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this);
        float f = 0.0f;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int id2 = childAt.getId();
            int i4 = C10817R.id.circle_center;
            if (id2 != i4 && !"skip".equals(childAt.getTag())) {
                constraintSet.constrainCircle(childAt.getId(), i4, this.f11862k, f);
                f = (360.0f / (childCount - i)) + f;
            }
        }
        constraintSet.applyTo(this);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (view.getId() == -1) {
            view.setId(ViewCompat.generateViewId());
        }
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.f11861j);
            handler.post(this.f11861j);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        m6170a();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.f11861j);
            handler.post(this.f11861j);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i) {
        this.f11863l.setFillColor(ColorStateList.valueOf(i));
    }

    public C4450e(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(C10817R.layout.material_radial_view_group, this);
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.f11863l = materialShapeDrawable;
        materialShapeDrawable.setCornerSize(new RelativeCornerSize(0.5f));
        this.f11863l.setFillColor(ColorStateList.valueOf(-1));
        ViewCompat.setBackground(this, this.f11863l);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10817R.styleable.RadialViewGroup, i, 0);
        this.f11862k = typedArrayObtainStyledAttributes.getDimensionPixelSize(C10817R.styleable.RadialViewGroup_materialCircleRadius, 0);
        this.f11861j = new a();
        typedArrayObtainStyledAttributes.recycle();
    }
}
