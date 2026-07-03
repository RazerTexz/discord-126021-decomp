package p007b.p225i.p226a.p341g.p343b;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.C10817R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;

/* JADX INFO: renamed from: b.i.a.g.b.a */
/* JADX INFO: compiled from: MaterialButtonHelper.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class C4388a {

    /* JADX INFO: renamed from: a */
    public final MaterialButton f11538a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public ShapeAppearanceModel f11539b;

    /* JADX INFO: renamed from: c */
    public int f11540c;

    /* JADX INFO: renamed from: d */
    public int f11541d;

    /* JADX INFO: renamed from: e */
    public int f11542e;

    /* JADX INFO: renamed from: f */
    public int f11543f;

    /* JADX INFO: renamed from: g */
    public int f11544g;

    /* JADX INFO: renamed from: h */
    public int f11545h;

    /* JADX INFO: renamed from: i */
    @Nullable
    public PorterDuff.Mode f11546i;

    /* JADX INFO: renamed from: j */
    @Nullable
    public ColorStateList f11547j;

    /* JADX INFO: renamed from: k */
    @Nullable
    public ColorStateList f11548k;

    /* JADX INFO: renamed from: l */
    @Nullable
    public ColorStateList f11549l;

    /* JADX INFO: renamed from: m */
    @Nullable
    public Drawable f11550m;

    /* JADX INFO: renamed from: n */
    public boolean f11551n = false;

    /* JADX INFO: renamed from: o */
    public boolean f11552o = false;

    /* JADX INFO: renamed from: p */
    public boolean f11553p = false;

    /* JADX INFO: renamed from: q */
    public boolean f11554q;

    /* JADX INFO: renamed from: r */
    public LayerDrawable f11555r;

    /* JADX INFO: renamed from: s */
    public int f11556s;

    public C4388a(MaterialButton materialButton, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.f11538a = materialButton;
        this.f11539b = shapeAppearanceModel;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public Shapeable m6036a() {
        LayerDrawable layerDrawable = this.f11555r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return this.f11555r.getNumberOfLayers() > 2 ? (Shapeable) this.f11555r.getDrawable(2) : (Shapeable) this.f11555r.getDrawable(1);
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public MaterialShapeDrawable m6037b() {
        return m6038c(false);
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    public final MaterialShapeDrawable m6038c(boolean z2) {
        LayerDrawable layerDrawable = this.f11555r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (MaterialShapeDrawable) ((LayerDrawable) ((InsetDrawable) this.f11555r.getDrawable(0)).getDrawable()).getDrawable(!z2 ? 1 : 0);
    }

    @Nullable
    /* JADX INFO: renamed from: d */
    public final MaterialShapeDrawable m6039d() {
        return m6038c(true);
    }

    /* JADX INFO: renamed from: e */
    public void m6040e(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.f11539b = shapeAppearanceModel;
        if (m6037b() != null) {
            m6037b().setShapeAppearanceModel(shapeAppearanceModel);
        }
        if (m6039d() != null) {
            m6039d().setShapeAppearanceModel(shapeAppearanceModel);
        }
        if (m6036a() != null) {
            m6036a().setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m6041f(@Dimension int i, @Dimension int i2) {
        int paddingStart = ViewCompat.getPaddingStart(this.f11538a);
        int paddingTop = this.f11538a.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this.f11538a);
        int paddingBottom = this.f11538a.getPaddingBottom();
        int i3 = this.f11542e;
        int i4 = this.f11543f;
        this.f11543f = i2;
        this.f11542e = i;
        if (!this.f11552o) {
            m6042g();
        }
        ViewCompat.setPaddingRelative(this.f11538a, paddingStart, (paddingTop + i) - i3, paddingEnd, (paddingBottom + i2) - i4);
    }

    /* JADX INFO: renamed from: g */
    public final void m6042g() {
        MaterialButton materialButton = this.f11538a;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.f11539b);
        materialShapeDrawable.initializeElevationOverlay(this.f11538a.getContext());
        DrawableCompat.setTintList(materialShapeDrawable, this.f11547j);
        PorterDuff.Mode mode = this.f11546i;
        if (mode != null) {
            DrawableCompat.setTintMode(materialShapeDrawable, mode);
        }
        materialShapeDrawable.setStroke(this.f11545h, this.f11548k);
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(this.f11539b);
        materialShapeDrawable2.setTint(0);
        materialShapeDrawable2.setStroke(this.f11545h, this.f11551n ? MaterialColors.getColor(this.f11538a, C10817R.attr.colorSurface) : 0);
        MaterialShapeDrawable materialShapeDrawable3 = new MaterialShapeDrawable(this.f11539b);
        this.f11550m = materialShapeDrawable3;
        DrawableCompat.setTint(materialShapeDrawable3, -1);
        RippleDrawable rippleDrawable = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.f11549l), new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable}), this.f11540c, this.f11542e, this.f11541d, this.f11543f), this.f11550m);
        this.f11555r = rippleDrawable;
        materialButton.setInternalBackground(rippleDrawable);
        MaterialShapeDrawable materialShapeDrawableM6037b = m6037b();
        if (materialShapeDrawableM6037b != null) {
            materialShapeDrawableM6037b.setElevation(this.f11556s);
        }
    }

    /* JADX INFO: renamed from: h */
    public final void m6043h() {
        MaterialShapeDrawable materialShapeDrawableM6037b = m6037b();
        MaterialShapeDrawable materialShapeDrawableM6039d = m6039d();
        if (materialShapeDrawableM6037b != null) {
            materialShapeDrawableM6037b.setStroke(this.f11545h, this.f11548k);
            if (materialShapeDrawableM6039d != null) {
                materialShapeDrawableM6039d.setStroke(this.f11545h, this.f11551n ? MaterialColors.getColor(this.f11538a, C10817R.attr.colorSurface) : 0);
            }
        }
    }
}
