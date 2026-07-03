package com.google.android.material.shape;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
import com.google.android.material.C10817R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.shadow.ShadowRenderer;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.shape.ShapePath;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.BitSet;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialShapeDrawable extends Drawable implements TintAwareDrawable, Shapeable {
    public static final int SHADOW_COMPAT_MODE_ALWAYS = 2;
    public static final int SHADOW_COMPAT_MODE_DEFAULT = 0;
    public static final int SHADOW_COMPAT_MODE_NEVER = 1;
    private static final float SHADOW_OFFSET_MULTIPLIER = 0.25f;
    private static final float SHADOW_RADIUS_MULTIPLIER = 0.75f;
    private static final String TAG = MaterialShapeDrawable.class.getSimpleName();
    private static final Paint clearPaint = new Paint(1);
    private final BitSet containsIncompatibleShadowOp;
    private final ShapePath.AbstractC10974d[] cornerShadowOperation;
    private C10967c drawableState;
    private final ShapePath.AbstractC10974d[] edgeShadowOperation;
    private final Paint fillPaint;
    private final RectF insetRectF;
    private final Matrix matrix;
    private final Path path;

    @NonNull
    private final RectF pathBounds;
    private boolean pathDirty;
    private final Path pathInsetByStroke;
    private final ShapeAppearancePathProvider pathProvider;

    @NonNull
    private final ShapeAppearancePathProvider.PathListener pathShadowListener;
    private final RectF rectF;
    private final Region scratchRegion;
    private boolean shadowBitmapDrawingEnable;
    private final ShadowRenderer shadowRenderer;
    private final Paint strokePaint;
    private ShapeAppearanceModel strokeShapeAppearance;

    @Nullable
    private PorterDuffColorFilter strokeTintFilter;

    @Nullable
    private PorterDuffColorFilter tintFilter;
    private final Region transparentRegion;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CompatibilityShadowMode {
    }

    /* JADX INFO: renamed from: com.google.android.material.shape.MaterialShapeDrawable$a */
    public class C10965a implements ShapeAppearancePathProvider.PathListener {
        public C10965a() {
        }

        @Override // com.google.android.material.shape.ShapeAppearancePathProvider.PathListener
        public void onCornerPathCreated(@NonNull ShapePath shapePath, Matrix matrix, int i) {
            MaterialShapeDrawable.this.containsIncompatibleShadowOp.set(i, shapePath.containsIncompatibleShadowOp());
            MaterialShapeDrawable.this.cornerShadowOperation[i] = shapePath.createShadowCompatOperation(matrix);
        }

        @Override // com.google.android.material.shape.ShapeAppearancePathProvider.PathListener
        public void onEdgePathCreated(@NonNull ShapePath shapePath, Matrix matrix, int i) {
            MaterialShapeDrawable.this.containsIncompatibleShadowOp.set(i + 4, shapePath.containsIncompatibleShadowOp());
            MaterialShapeDrawable.this.edgeShadowOperation[i] = shapePath.createShadowCompatOperation(matrix);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.shape.MaterialShapeDrawable$b */
    public class C10966b implements ShapeAppearanceModel.CornerSizeUnaryOperator {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ float f21069a;

        public C10966b(MaterialShapeDrawable materialShapeDrawable, float f) {
            this.f21069a = f;
        }

        @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
        @NonNull
        public CornerSize apply(@NonNull CornerSize cornerSize) {
            return cornerSize instanceof RelativeCornerSize ? cornerSize : new AdjustedCornerSize(this.f21069a, cornerSize);
        }
    }

    public /* synthetic */ MaterialShapeDrawable(C10967c c10967c, C10965a c10965a) {
        this(c10967c);
    }

    @Nullable
    private PorterDuffColorFilter calculatePaintColorTintFilter(@NonNull Paint paint, boolean z2) {
        int color;
        int iCompositeElevationOverlayIfNeeded;
        if (!z2 || (iCompositeElevationOverlayIfNeeded = compositeElevationOverlayIfNeeded((color = paint.getColor()))) == color) {
            return null;
        }
        return new PorterDuffColorFilter(iCompositeElevationOverlayIfNeeded, PorterDuff.Mode.SRC_IN);
    }

    private void calculatePath(@NonNull RectF rectF, @NonNull Path path) {
        calculatePathForSize(rectF, path);
        if (this.drawableState.f21079j != 1.0f) {
            this.matrix.reset();
            Matrix matrix = this.matrix;
            float f = this.drawableState.f21079j;
            matrix.setScale(f, f, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.matrix);
        }
        path.computeBounds(this.pathBounds, true);
    }

    private void calculateStrokePath() {
        ShapeAppearanceModel shapeAppearanceModelWithTransformedCornerSizes = getShapeAppearanceModel().withTransformedCornerSizes(new C10966b(this, -getStrokeInsetLength()));
        this.strokeShapeAppearance = shapeAppearanceModelWithTransformedCornerSizes;
        this.pathProvider.calculatePath(shapeAppearanceModelWithTransformedCornerSizes, this.drawableState.f21080k, getBoundsInsetByStroke(), this.pathInsetByStroke);
    }

    @NonNull
    private PorterDuffColorFilter calculateTintColorTintFilter(@NonNull ColorStateList colorStateList, @NonNull PorterDuff.Mode mode, boolean z2) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z2) {
            colorForState = compositeElevationOverlayIfNeeded(colorForState);
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    @NonNull
    private PorterDuffColorFilter calculateTintFilter(@Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, @NonNull Paint paint, boolean z2) {
        return (colorStateList == null || mode == null) ? calculatePaintColorTintFilter(paint, z2) : calculateTintColorTintFilter(colorStateList, mode, z2);
    }

    @NonNull
    public static MaterialShapeDrawable createWithElevationOverlay(Context context) {
        return createWithElevationOverlay(context, 0.0f);
    }

    private void drawCompatShadow(@NonNull Canvas canvas) {
        if (this.containsIncompatibleShadowOp.cardinality() > 0) {
            Log.w(TAG, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.drawableState.f21088s != 0) {
            canvas.drawPath(this.path, this.shadowRenderer.getShadowPaint());
        }
        for (int i = 0; i < 4; i++) {
            ShapePath.AbstractC10974d abstractC10974d = this.cornerShadowOperation[i];
            ShadowRenderer shadowRenderer = this.shadowRenderer;
            int i2 = this.drawableState.f21087r;
            Matrix matrix = ShapePath.AbstractC10974d.f21106a;
            abstractC10974d.mo9146a(matrix, shadowRenderer, i2, canvas);
            this.edgeShadowOperation[i].mo9146a(matrix, this.shadowRenderer, this.drawableState.f21087r, canvas);
        }
        if (this.shadowBitmapDrawingEnable) {
            int shadowOffsetX = getShadowOffsetX();
            int shadowOffsetY = getShadowOffsetY();
            canvas.translate(-shadowOffsetX, -shadowOffsetY);
            canvas.drawPath(this.path, clearPaint);
            canvas.translate(shadowOffsetX, shadowOffsetY);
        }
    }

    private void drawFillShape(@NonNull Canvas canvas) {
        drawShape(canvas, this.fillPaint, this.path, this.drawableState.f21070a, getBoundsAsRectF());
    }

    private void drawStrokeShape(@NonNull Canvas canvas) {
        drawShape(canvas, this.strokePaint, this.pathInsetByStroke, this.strokeShapeAppearance, getBoundsInsetByStroke());
    }

    @NonNull
    private RectF getBoundsInsetByStroke() {
        this.insetRectF.set(getBoundsAsRectF());
        float strokeInsetLength = getStrokeInsetLength();
        this.insetRectF.inset(strokeInsetLength, strokeInsetLength);
        return this.insetRectF;
    }

    private float getStrokeInsetLength() {
        if (hasStroke()) {
            return this.strokePaint.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private boolean hasCompatShadow() {
        C10967c c10967c = this.drawableState;
        int i = c10967c.f21086q;
        return i != 1 && c10967c.f21087r > 0 && (i == 2 || requiresCompatShadow());
    }

    private boolean hasFill() {
        Paint.Style style = this.drawableState.f21091v;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    private boolean hasStroke() {
        Paint.Style style = this.drawableState.f21091v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.strokePaint.getStrokeWidth() > 0.0f;
    }

    private void invalidateSelfIgnoreShape() {
        super.invalidateSelf();
    }

    private void maybeDrawCompatShadow(@NonNull Canvas canvas) {
        if (hasCompatShadow()) {
            canvas.save();
            prepareCanvasForShadow(canvas);
            if (!this.shadowBitmapDrawingEnable) {
                drawCompatShadow(canvas);
                canvas.restore();
                return;
            }
            int iWidth = (int) (this.pathBounds.width() - getBounds().width());
            int iHeight = (int) (this.pathBounds.height() - getBounds().height());
            if (iWidth < 0 || iHeight < 0) {
                throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap((this.drawableState.f21087r * 2) + ((int) this.pathBounds.width()) + iWidth, (this.drawableState.f21087r * 2) + ((int) this.pathBounds.height()) + iHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap);
            float f = (getBounds().left - this.drawableState.f21087r) - iWidth;
            float f2 = (getBounds().top - this.drawableState.f21087r) - iHeight;
            canvas2.translate(-f, -f2);
            drawCompatShadow(canvas2);
            canvas.drawBitmap(bitmapCreateBitmap, f, f2, (Paint) null);
            bitmapCreateBitmap.recycle();
            canvas.restore();
        }
    }

    private static int modulateAlpha(int i, int i2) {
        return ((i2 + (i2 >>> 7)) * i) >>> 8;
    }

    private void prepareCanvasForShadow(@NonNull Canvas canvas) {
        canvas.translate(getShadowOffsetX(), getShadowOffsetY());
    }

    private boolean updateColorsForState(int[] iArr) {
        boolean z2;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.drawableState.f21073d == null || color2 == (colorForState2 = this.drawableState.f21073d.getColorForState(iArr, (color2 = this.fillPaint.getColor())))) {
            z2 = false;
        } else {
            this.fillPaint.setColor(colorForState2);
            z2 = true;
        }
        if (this.drawableState.f21074e == null || color == (colorForState = this.drawableState.f21074e.getColorForState(iArr, (color = this.strokePaint.getColor())))) {
            return z2;
        }
        this.strokePaint.setColor(colorForState);
        return true;
    }

    private boolean updateTintFilter() {
        PorterDuffColorFilter porterDuffColorFilter = this.tintFilter;
        PorterDuffColorFilter porterDuffColorFilter2 = this.strokeTintFilter;
        C10967c c10967c = this.drawableState;
        this.tintFilter = calculateTintFilter(c10967c.f21076g, c10967c.f21077h, this.fillPaint, true);
        C10967c c10967c2 = this.drawableState;
        this.strokeTintFilter = calculateTintFilter(c10967c2.f21075f, c10967c2.f21077h, this.strokePaint, false);
        C10967c c10967c3 = this.drawableState;
        if (c10967c3.f21090u) {
            this.shadowRenderer.setShadowColor(c10967c3.f21076g.getColorForState(getState(), 0));
        }
        return (ObjectsCompat.equals(porterDuffColorFilter, this.tintFilter) && ObjectsCompat.equals(porterDuffColorFilter2, this.strokeTintFilter)) ? false : true;
    }

    private void updateZ() {
        float z2 = getZ();
        this.drawableState.f21087r = (int) Math.ceil(0.75f * z2);
        this.drawableState.f21088s = (int) Math.ceil(z2 * 0.25f);
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void calculatePathForSize(@NonNull RectF rectF, @NonNull Path path) {
        ShapeAppearancePathProvider shapeAppearancePathProvider = this.pathProvider;
        C10967c c10967c = this.drawableState;
        shapeAppearancePathProvider.calculatePath(c10967c.f21070a, c10967c.f21080k, rectF, this.pathShadowListener, path);
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int compositeElevationOverlayIfNeeded(@ColorInt int i) {
        float parentAbsoluteElevation = getParentAbsoluteElevation() + getZ();
        ElevationOverlayProvider elevationOverlayProvider = this.drawableState.f21071b;
        return elevationOverlayProvider != null ? elevationOverlayProvider.compositeOverlayIfNeeded(i, parentAbsoluteElevation) : i;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.fillPaint.setColorFilter(this.tintFilter);
        int alpha = this.fillPaint.getAlpha();
        this.fillPaint.setAlpha(modulateAlpha(alpha, this.drawableState.f21082m));
        this.strokePaint.setColorFilter(this.strokeTintFilter);
        this.strokePaint.setStrokeWidth(this.drawableState.f21081l);
        int alpha2 = this.strokePaint.getAlpha();
        this.strokePaint.setAlpha(modulateAlpha(alpha2, this.drawableState.f21082m));
        if (this.pathDirty) {
            calculateStrokePath();
            calculatePath(getBoundsAsRectF(), this.path);
            this.pathDirty = false;
        }
        maybeDrawCompatShadow(canvas);
        if (hasFill()) {
            drawFillShape(canvas);
        }
        if (hasStroke()) {
            drawStrokeShape(canvas);
        }
        this.fillPaint.setAlpha(alpha);
        this.strokePaint.setAlpha(alpha2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void drawShape(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path, @NonNull RectF rectF) {
        drawShape(canvas, paint, path, this.drawableState.f21070a, rectF);
    }

    public float getBottomLeftCornerResolvedSize() {
        return this.drawableState.f21070a.getBottomLeftCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getBottomRightCornerResolvedSize() {
        return this.drawableState.f21070a.getBottomRightCornerSize().getCornerSize(getBoundsAsRectF());
    }

    @NonNull
    public RectF getBoundsAsRectF() {
        this.rectF.set(getBounds());
        return this.rectF;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.drawableState;
    }

    public float getElevation() {
        return this.drawableState.f21084o;
    }

    @Nullable
    public ColorStateList getFillColor() {
        return this.drawableState.f21073d;
    }

    public float getInterpolation() {
        return this.drawableState.f21080k;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.drawableState.f21086q == 2) {
            return;
        }
        if (isRoundRect()) {
            outline.setRoundRect(getBounds(), getTopLeftCornerResolvedSize() * this.drawableState.f21080k);
            return;
        }
        calculatePath(getBoundsAsRectF(), this.path);
        if (this.path.isConvex() || Build.VERSION.SDK_INT >= 29) {
            try {
                outline.setConvexPath(this.path);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        Rect rect2 = this.drawableState.f21078i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    public Paint.Style getPaintStyle() {
        return this.drawableState.f21091v;
    }

    public float getParentAbsoluteElevation() {
        return this.drawableState.f21083n;
    }

    @Deprecated
    public void getPathForSize(int i, int i2, @NonNull Path path) {
        calculatePathForSize(new RectF(0.0f, 0.0f, i, i2), path);
    }

    public float getScale() {
        return this.drawableState.f21079j;
    }

    public int getShadowCompatRotation() {
        return this.drawableState.f21089t;
    }

    public int getShadowCompatibilityMode() {
        return this.drawableState.f21086q;
    }

    @Deprecated
    public int getShadowElevation() {
        return (int) getElevation();
    }

    public int getShadowOffsetX() {
        C10967c c10967c = this.drawableState;
        return (int) (Math.sin(Math.toRadians(c10967c.f21089t)) * ((double) c10967c.f21088s));
    }

    public int getShadowOffsetY() {
        C10967c c10967c = this.drawableState;
        return (int) (Math.cos(Math.toRadians(c10967c.f21089t)) * ((double) c10967c.f21088s));
    }

    public int getShadowRadius() {
        return this.drawableState.f21087r;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getShadowVerticalOffset() {
        return this.drawableState.f21088s;
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.drawableState.f21070a;
    }

    @Nullable
    @Deprecated
    public ShapePathModel getShapedViewModel() {
        ShapeAppearanceModel shapeAppearanceModel = getShapeAppearanceModel();
        if (shapeAppearanceModel instanceof ShapePathModel) {
            return (ShapePathModel) shapeAppearanceModel;
        }
        return null;
    }

    @Nullable
    public ColorStateList getStrokeColor() {
        return this.drawableState.f21074e;
    }

    @Nullable
    public ColorStateList getStrokeTintList() {
        return this.drawableState.f21075f;
    }

    public float getStrokeWidth() {
        return this.drawableState.f21081l;
    }

    @Nullable
    public ColorStateList getTintList() {
        return this.drawableState.f21076g;
    }

    public float getTopLeftCornerResolvedSize() {
        return this.drawableState.f21070a.getTopLeftCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getTopRightCornerResolvedSize() {
        return this.drawableState.f21070a.getTopRightCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getTranslationZ() {
        return this.drawableState.f21085p;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.transparentRegion.set(getBounds());
        calculatePath(getBoundsAsRectF(), this.path);
        this.scratchRegion.setPath(this.path, this.transparentRegion);
        this.transparentRegion.op(this.scratchRegion, Region.Op.DIFFERENCE);
        return this.transparentRegion;
    }

    public float getZ() {
        return getTranslationZ() + getElevation();
    }

    public void initializeElevationOverlay(Context context) {
        this.drawableState.f21071b = new ElevationOverlayProvider(context);
        updateZ();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.pathDirty = true;
        super.invalidateSelf();
    }

    public boolean isElevationOverlayEnabled() {
        ElevationOverlayProvider elevationOverlayProvider = this.drawableState.f21071b;
        return elevationOverlayProvider != null && elevationOverlayProvider.isThemeElevationOverlayEnabled();
    }

    public boolean isElevationOverlayInitialized() {
        return this.drawableState.f21071b != null;
    }

    public boolean isPointInTransparentRegion(int i, int i2) {
        return getTransparentRegion().contains(i, i2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isRoundRect() {
        return this.drawableState.f21070a.isRoundRect(getBoundsAsRectF());
    }

    @Deprecated
    public boolean isShadowEnabled() {
        int i = this.drawableState.f21086q;
        return i == 0 || i == 2;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.drawableState.f21076g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.drawableState.f21075f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.drawableState.f21074e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.drawableState.f21073d) != null && colorStateList4.isStateful())));
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        this.drawableState = new C10967c(this.drawableState);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.pathDirty = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        boolean z2 = updateColorsForState(iArr) || updateTintFilter();
        if (z2) {
            invalidateSelf();
        }
        return z2;
    }

    public boolean requiresCompatShadow() {
        return (isRoundRect() || this.path.isConvex() || Build.VERSION.SDK_INT >= 29) ? false : true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, m76to = 255) int i) {
        C10967c c10967c = this.drawableState;
        if (c10967c.f21082m != i) {
            c10967c.f21082m = i;
            invalidateSelfIgnoreShape();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.drawableState.f21072c = colorFilter;
        invalidateSelfIgnoreShape();
    }

    public void setCornerSize(float f) {
        setShapeAppearanceModel(this.drawableState.f21070a.withCornerSize(f));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setEdgeIntersectionCheckEnable(boolean z2) {
        this.pathProvider.setEdgeIntersectionCheckEnable(z2);
    }

    public void setElevation(float f) {
        C10967c c10967c = this.drawableState;
        if (c10967c.f21084o != f) {
            c10967c.f21084o = f;
            updateZ();
        }
    }

    public void setFillColor(@Nullable ColorStateList colorStateList) {
        C10967c c10967c = this.drawableState;
        if (c10967c.f21073d != colorStateList) {
            c10967c.f21073d = colorStateList;
            onStateChange(getState());
        }
    }

    public void setInterpolation(float f) {
        C10967c c10967c = this.drawableState;
        if (c10967c.f21080k != f) {
            c10967c.f21080k = f;
            this.pathDirty = true;
            invalidateSelf();
        }
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        C10967c c10967c = this.drawableState;
        if (c10967c.f21078i == null) {
            c10967c.f21078i = new Rect();
        }
        this.drawableState.f21078i.set(i, i2, i3, i4);
        invalidateSelf();
    }

    public void setPaintStyle(Paint.Style style) {
        this.drawableState.f21091v = style;
        invalidateSelfIgnoreShape();
    }

    public void setParentAbsoluteElevation(float f) {
        C10967c c10967c = this.drawableState;
        if (c10967c.f21083n != f) {
            c10967c.f21083n = f;
            updateZ();
        }
    }

    public void setScale(float f) {
        C10967c c10967c = this.drawableState;
        if (c10967c.f21079j != f) {
            c10967c.f21079j = f;
            invalidateSelf();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setShadowBitmapDrawingEnable(boolean z2) {
        this.shadowBitmapDrawingEnable = z2;
    }

    public void setShadowColor(int i) {
        this.shadowRenderer.setShadowColor(i);
        this.drawableState.f21090u = false;
        invalidateSelfIgnoreShape();
    }

    public void setShadowCompatRotation(int i) {
        C10967c c10967c = this.drawableState;
        if (c10967c.f21089t != i) {
            c10967c.f21089t = i;
            invalidateSelfIgnoreShape();
        }
    }

    public void setShadowCompatibilityMode(int i) {
        C10967c c10967c = this.drawableState;
        if (c10967c.f21086q != i) {
            c10967c.f21086q = i;
            invalidateSelfIgnoreShape();
        }
    }

    @Deprecated
    public void setShadowElevation(int i) {
        setElevation(i);
    }

    @Deprecated
    public void setShadowEnabled(boolean z2) {
        setShadowCompatibilityMode(!z2 ? 1 : 0);
    }

    @Deprecated
    public void setShadowRadius(int i) {
        this.drawableState.f21087r = i;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setShadowVerticalOffset(int i) {
        C10967c c10967c = this.drawableState;
        if (c10967c.f21088s != i) {
            c10967c.f21088s = i;
            invalidateSelfIgnoreShape();
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.drawableState.f21070a = shapeAppearanceModel;
        invalidateSelf();
    }

    @Deprecated
    public void setShapedViewModel(@NonNull ShapePathModel shapePathModel) {
        setShapeAppearanceModel(shapePathModel);
    }

    public void setStroke(float f, @ColorInt int i) {
        setStrokeWidth(f);
        setStrokeColor(ColorStateList.valueOf(i));
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        C10967c c10967c = this.drawableState;
        if (c10967c.f21074e != colorStateList) {
            c10967c.f21074e = colorStateList;
            onStateChange(getState());
        }
    }

    public void setStrokeTint(ColorStateList colorStateList) {
        this.drawableState.f21075f = colorStateList;
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    public void setStrokeWidth(float f) {
        this.drawableState.f21081l = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(@ColorInt int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        this.drawableState.f21076g = colorStateList;
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        C10967c c10967c = this.drawableState;
        if (c10967c.f21077h != mode) {
            c10967c.f21077h = mode;
            updateTintFilter();
            invalidateSelfIgnoreShape();
        }
    }

    public void setTranslationZ(float f) {
        C10967c c10967c = this.drawableState;
        if (c10967c.f21085p != f) {
            c10967c.f21085p = f;
            updateZ();
        }
    }

    public void setUseTintColorForShadow(boolean z2) {
        C10967c c10967c = this.drawableState;
        if (c10967c.f21090u != z2) {
            c10967c.f21090u = z2;
            invalidateSelf();
        }
    }

    public void setZ(float f) {
        setTranslationZ(f - getElevation());
    }

    public MaterialShapeDrawable() {
        this(new ShapeAppearanceModel());
    }

    @NonNull
    public static MaterialShapeDrawable createWithElevationOverlay(Context context, float f) {
        int color = MaterialColors.getColor(context, C10817R.attr.colorSurface, MaterialShapeDrawable.class.getSimpleName());
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        materialShapeDrawable.initializeElevationOverlay(context);
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(color));
        materialShapeDrawable.setElevation(f);
        return materialShapeDrawable;
    }

    private void drawShape(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path, @NonNull ShapeAppearanceModel shapeAppearanceModel, @NonNull RectF rectF) {
        if (!shapeAppearanceModel.isRoundRect(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float cornerSize = shapeAppearanceModel.getTopRightCornerSize().getCornerSize(rectF) * this.drawableState.f21080k;
            canvas.drawRoundRect(rectF, cornerSize, cornerSize, paint);
        }
    }

    public void setCornerSize(@NonNull CornerSize cornerSize) {
        setShapeAppearanceModel(this.drawableState.f21070a.withCornerSize(cornerSize));
    }

    public MaterialShapeDrawable(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        this(ShapeAppearanceModel.builder(context, attributeSet, i, i2).build());
    }

    public void setStroke(float f, @Nullable ColorStateList colorStateList) {
        setStrokeWidth(f);
        setStrokeColor(colorStateList);
    }

    @Deprecated
    public MaterialShapeDrawable(@NonNull ShapePathModel shapePathModel) {
        this((ShapeAppearanceModel) shapePathModel);
    }

    public void setStrokeTint(@ColorInt int i) {
        setStrokeTint(ColorStateList.valueOf(i));
    }

    public MaterialShapeDrawable(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this(new C10967c(shapeAppearanceModel, null));
    }

    private MaterialShapeDrawable(@NonNull C10967c c10967c) {
        this.cornerShadowOperation = new ShapePath.AbstractC10974d[4];
        this.edgeShadowOperation = new ShapePath.AbstractC10974d[4];
        this.containsIncompatibleShadowOp = new BitSet(8);
        this.matrix = new Matrix();
        this.path = new Path();
        this.pathInsetByStroke = new Path();
        this.rectF = new RectF();
        this.insetRectF = new RectF();
        this.transparentRegion = new Region();
        this.scratchRegion = new Region();
        Paint paint = new Paint(1);
        this.fillPaint = paint;
        Paint paint2 = new Paint(1);
        this.strokePaint = paint2;
        this.shadowRenderer = new ShadowRenderer();
        this.pathProvider = Looper.getMainLooper().getThread() == Thread.currentThread() ? ShapeAppearancePathProvider.getInstance() : new ShapeAppearancePathProvider();
        this.pathBounds = new RectF();
        this.shadowBitmapDrawingEnable = true;
        this.drawableState = c10967c;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        Paint paint3 = clearPaint;
        paint3.setColor(-1);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        updateTintFilter();
        updateColorsForState(getState());
        this.pathShadowListener = new C10965a();
    }

    /* JADX INFO: renamed from: com.google.android.material.shape.MaterialShapeDrawable$c */
    public static final class C10967c extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a */
        @NonNull
        public ShapeAppearanceModel f21070a;

        /* JADX INFO: renamed from: b */
        @Nullable
        public ElevationOverlayProvider f21071b;

        /* JADX INFO: renamed from: c */
        @Nullable
        public ColorFilter f21072c;

        /* JADX INFO: renamed from: d */
        @Nullable
        public ColorStateList f21073d;

        /* JADX INFO: renamed from: e */
        @Nullable
        public ColorStateList f21074e;

        /* JADX INFO: renamed from: f */
        @Nullable
        public ColorStateList f21075f;

        /* JADX INFO: renamed from: g */
        @Nullable
        public ColorStateList f21076g;

        /* JADX INFO: renamed from: h */
        @Nullable
        public PorterDuff.Mode f21077h;

        /* JADX INFO: renamed from: i */
        @Nullable
        public Rect f21078i;

        /* JADX INFO: renamed from: j */
        public float f21079j;

        /* JADX INFO: renamed from: k */
        public float f21080k;

        /* JADX INFO: renamed from: l */
        public float f21081l;

        /* JADX INFO: renamed from: m */
        public int f21082m;

        /* JADX INFO: renamed from: n */
        public float f21083n;

        /* JADX INFO: renamed from: o */
        public float f21084o;

        /* JADX INFO: renamed from: p */
        public float f21085p;

        /* JADX INFO: renamed from: q */
        public int f21086q;

        /* JADX INFO: renamed from: r */
        public int f21087r;

        /* JADX INFO: renamed from: s */
        public int f21088s;

        /* JADX INFO: renamed from: t */
        public int f21089t;

        /* JADX INFO: renamed from: u */
        public boolean f21090u;

        /* JADX INFO: renamed from: v */
        public Paint.Style f21091v;

        public C10967c(ShapeAppearanceModel shapeAppearanceModel, ElevationOverlayProvider elevationOverlayProvider) {
            this.f21073d = null;
            this.f21074e = null;
            this.f21075f = null;
            this.f21076g = null;
            this.f21077h = PorterDuff.Mode.SRC_IN;
            this.f21078i = null;
            this.f21079j = 1.0f;
            this.f21080k = 1.0f;
            this.f21082m = 255;
            this.f21083n = 0.0f;
            this.f21084o = 0.0f;
            this.f21085p = 0.0f;
            this.f21086q = 0;
            this.f21087r = 0;
            this.f21088s = 0;
            this.f21089t = 0;
            this.f21090u = false;
            this.f21091v = Paint.Style.FILL_AND_STROKE;
            this.f21070a = shapeAppearanceModel;
            this.f21071b = null;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this, null);
            materialShapeDrawable.pathDirty = true;
            return materialShapeDrawable;
        }

        public C10967c(@NonNull C10967c c10967c) {
            this.f21073d = null;
            this.f21074e = null;
            this.f21075f = null;
            this.f21076g = null;
            this.f21077h = PorterDuff.Mode.SRC_IN;
            this.f21078i = null;
            this.f21079j = 1.0f;
            this.f21080k = 1.0f;
            this.f21082m = 255;
            this.f21083n = 0.0f;
            this.f21084o = 0.0f;
            this.f21085p = 0.0f;
            this.f21086q = 0;
            this.f21087r = 0;
            this.f21088s = 0;
            this.f21089t = 0;
            this.f21090u = false;
            this.f21091v = Paint.Style.FILL_AND_STROKE;
            this.f21070a = c10967c.f21070a;
            this.f21071b = c10967c.f21071b;
            this.f21081l = c10967c.f21081l;
            this.f21072c = c10967c.f21072c;
            this.f21073d = c10967c.f21073d;
            this.f21074e = c10967c.f21074e;
            this.f21077h = c10967c.f21077h;
            this.f21076g = c10967c.f21076g;
            this.f21082m = c10967c.f21082m;
            this.f21079j = c10967c.f21079j;
            this.f21088s = c10967c.f21088s;
            this.f21086q = c10967c.f21086q;
            this.f21090u = c10967c.f21090u;
            this.f21080k = c10967c.f21080k;
            this.f21083n = c10967c.f21083n;
            this.f21084o = c10967c.f21084o;
            this.f21085p = c10967c.f21085p;
            this.f21087r = c10967c.f21087r;
            this.f21089t = c10967c.f21089t;
            this.f21075f = c10967c.f21075f;
            this.f21091v = c10967c.f21091v;
            if (c10967c.f21078i != null) {
                this.f21078i = new Rect(c10967c.f21078i);
            }
        }
    }
}
