package p007b.p225i.p226a.p341g.p345d;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.C10817R;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

/* JADX INFO: renamed from: b.i.a.g.d.a */
/* JADX INFO: compiled from: CalendarItemStyle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4390a {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final Rect f11578a;

    /* JADX INFO: renamed from: b */
    public final ColorStateList f11579b;

    /* JADX INFO: renamed from: c */
    public final ColorStateList f11580c;

    /* JADX INFO: renamed from: d */
    public final ColorStateList f11581d;

    /* JADX INFO: renamed from: e */
    public final int f11582e;

    /* JADX INFO: renamed from: f */
    public final ShapeAppearanceModel f11583f;

    public C4390a(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i, ShapeAppearanceModel shapeAppearanceModel, @NonNull Rect rect) {
        Preconditions.checkArgumentNonnegative(rect.left);
        Preconditions.checkArgumentNonnegative(rect.top);
        Preconditions.checkArgumentNonnegative(rect.right);
        Preconditions.checkArgumentNonnegative(rect.bottom);
        this.f11578a = rect;
        this.f11579b = colorStateList2;
        this.f11580c = colorStateList;
        this.f11581d = colorStateList3;
        this.f11582e = i;
        this.f11583f = shapeAppearanceModel;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static C4390a m6058a(@NonNull Context context, @StyleRes int i) {
        Preconditions.checkArgument(i != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, C10817R.styleable.MaterialCalendarItem);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(C10817R.styleable.MaterialCalendarItem_android_insetLeft, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(C10817R.styleable.MaterialCalendarItem_android_insetTop, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(C10817R.styleable.MaterialCalendarItem_android_insetRight, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(C10817R.styleable.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList colorStateList = MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, C10817R.styleable.MaterialCalendarItem_itemFillColor);
        ColorStateList colorStateList2 = MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, C10817R.styleable.MaterialCalendarItem_itemTextColor);
        ColorStateList colorStateList3 = MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, C10817R.styleable.MaterialCalendarItem_itemStrokeColor);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(C10817R.styleable.MaterialCalendarItem_itemStrokeWidth, 0);
        ShapeAppearanceModel shapeAppearanceModelBuild = ShapeAppearanceModel.builder(context, typedArrayObtainStyledAttributes.getResourceId(C10817R.styleable.MaterialCalendarItem_itemShapeAppearance, 0), typedArrayObtainStyledAttributes.getResourceId(C10817R.styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).build();
        typedArrayObtainStyledAttributes.recycle();
        return new C4390a(colorStateList, colorStateList2, colorStateList3, dimensionPixelSize, shapeAppearanceModelBuild, rect);
    }

    /* JADX INFO: renamed from: b */
    public void m6059b(@NonNull TextView textView) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable();
        materialShapeDrawable.setShapeAppearanceModel(this.f11583f);
        materialShapeDrawable2.setShapeAppearanceModel(this.f11583f);
        materialShapeDrawable.setFillColor(this.f11580c);
        materialShapeDrawable.setStroke(this.f11582e, this.f11581d);
        textView.setTextColor(this.f11579b);
        RippleDrawable rippleDrawable = new RippleDrawable(this.f11579b.withAlpha(30), materialShapeDrawable, materialShapeDrawable2);
        Rect rect = this.f11578a;
        ViewCompat.setBackground(textView, new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
