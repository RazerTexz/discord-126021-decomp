package androidx.vectordrawable.graphics.drawable;

import android.content.res.Resources;
import android.content.res.Resources$Theme;
import android.content.res.TypedArray;
import android.graphics.Paint$Cap;
import android.graphics.Paint$Join;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class VectorDrawableCompat$VFullPath extends VectorDrawableCompat$VPath {
    public float mFillAlpha;
    public ComplexColorCompat mFillColor;
    public float mStrokeAlpha;
    public ComplexColorCompat mStrokeColor;
    public Paint$Cap mStrokeLineCap;
    public Paint$Join mStrokeLineJoin;
    public float mStrokeMiterlimit;
    public float mStrokeWidth;
    private int[] mThemeAttrs;
    public float mTrimPathEnd;
    public float mTrimPathOffset;
    public float mTrimPathStart;

    public VectorDrawableCompat$VFullPath() {
        this.mStrokeWidth = 0.0f;
        this.mStrokeAlpha = 1.0f;
        this.mFillAlpha = 1.0f;
        this.mTrimPathStart = 0.0f;
        this.mTrimPathEnd = 1.0f;
        this.mTrimPathOffset = 0.0f;
        this.mStrokeLineCap = Paint$Cap.BUTT;
        this.mStrokeLineJoin = Paint$Join.MITER;
        this.mStrokeMiterlimit = 4.0f;
    }

    private Paint$Cap getStrokeLineCap(int i, Paint$Cap paint$Cap) {
        if (i == 0) {
            return Paint$Cap.BUTT;
        }
        if (i != 1) {
            return i != 2 ? paint$Cap : Paint$Cap.SQUARE;
        }
        return Paint$Cap.ROUND;
    }

    private Paint$Join getStrokeLineJoin(int i, Paint$Join paint$Join) {
        if (i == 0) {
            return Paint$Join.MITER;
        }
        if (i != 1) {
            return i != 2 ? paint$Join : Paint$Join.BEVEL;
        }
        return Paint$Join.ROUND;
    }

    private void updateStateFromTypedArray(TypedArray typedArray, XmlPullParser xmlPullParser, Resources$Theme resources$Theme) {
        this.mThemeAttrs = null;
        if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.mPathName = string;
            }
            String string2 = typedArray.getString(2);
            if (string2 != null) {
                this.mNodes = PathParser.createNodesFromPathData(string2);
            }
            this.mFillColor = TypedArrayUtils.getNamedComplexColor(typedArray, xmlPullParser, resources$Theme, "fillColor", 1, 0);
            this.mFillAlpha = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "fillAlpha", 12, this.mFillAlpha);
            this.mStrokeLineCap = getStrokeLineCap(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.mStrokeLineCap);
            this.mStrokeLineJoin = getStrokeLineJoin(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.mStrokeLineJoin);
            this.mStrokeMiterlimit = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.mStrokeMiterlimit);
            this.mStrokeColor = TypedArrayUtils.getNamedComplexColor(typedArray, xmlPullParser, resources$Theme, "strokeColor", 3, 0);
            this.mStrokeAlpha = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeAlpha", 11, this.mStrokeAlpha);
            this.mStrokeWidth = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeWidth", 4, this.mStrokeWidth);
            this.mTrimPathEnd = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathEnd", 6, this.mTrimPathEnd);
            this.mTrimPathOffset = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathOffset", 7, this.mTrimPathOffset);
            this.mTrimPathStart = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathStart", 5, this.mTrimPathStart);
            this.mFillRule = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "fillType", 13, this.mFillRule);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VPath
    public void applyTheme(Resources$Theme resources$Theme) {
        if (this.mThemeAttrs == null) {
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VPath
    public boolean canApplyTheme() {
        return this.mThemeAttrs != null;
    }

    public float getFillAlpha() {
        return this.mFillAlpha;
    }

    @ColorInt
    public int getFillColor() {
        return this.mFillColor.getColor();
    }

    public float getStrokeAlpha() {
        return this.mStrokeAlpha;
    }

    @ColorInt
    public int getStrokeColor() {
        return this.mStrokeColor.getColor();
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public float getTrimPathEnd() {
        return this.mTrimPathEnd;
    }

    public float getTrimPathOffset() {
        return this.mTrimPathOffset;
    }

    public float getTrimPathStart() {
        return this.mTrimPathStart;
    }

    public void inflate(Resources resources, AttributeSet attributeSet, Resources$Theme resources$Theme, XmlPullParser xmlPullParser) {
        TypedArray typedArrayObtainAttributes = TypedArrayUtils.obtainAttributes(resources, resources$Theme, attributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_PATH);
        updateStateFromTypedArray(typedArrayObtainAttributes, xmlPullParser, resources$Theme);
        typedArrayObtainAttributes.recycle();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VObject
    public boolean isStateful() {
        return this.mFillColor.isStateful() || this.mStrokeColor.isStateful();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VObject
    public boolean onStateChanged(int[] iArr) {
        return this.mStrokeColor.onStateChanged(iArr) | this.mFillColor.onStateChanged(iArr);
    }

    public void setFillAlpha(float f) {
        this.mFillAlpha = f;
    }

    public void setFillColor(int i) {
        this.mFillColor.setColor(i);
    }

    public void setStrokeAlpha(float f) {
        this.mStrokeAlpha = f;
    }

    public void setStrokeColor(int i) {
        this.mStrokeColor.setColor(i);
    }

    public void setStrokeWidth(float f) {
        this.mStrokeWidth = f;
    }

    public void setTrimPathEnd(float f) {
        this.mTrimPathEnd = f;
    }

    public void setTrimPathOffset(float f) {
        this.mTrimPathOffset = f;
    }

    public void setTrimPathStart(float f) {
        this.mTrimPathStart = f;
    }

    public VectorDrawableCompat$VFullPath(VectorDrawableCompat$VFullPath vectorDrawableCompat$VFullPath) {
        super(vectorDrawableCompat$VFullPath);
        this.mStrokeWidth = 0.0f;
        this.mStrokeAlpha = 1.0f;
        this.mFillAlpha = 1.0f;
        this.mTrimPathStart = 0.0f;
        this.mTrimPathEnd = 1.0f;
        this.mTrimPathOffset = 0.0f;
        this.mStrokeLineCap = Paint$Cap.BUTT;
        this.mStrokeLineJoin = Paint$Join.MITER;
        this.mStrokeMiterlimit = 4.0f;
        this.mThemeAttrs = vectorDrawableCompat$VFullPath.mThemeAttrs;
        this.mStrokeColor = vectorDrawableCompat$VFullPath.mStrokeColor;
        this.mStrokeWidth = vectorDrawableCompat$VFullPath.mStrokeWidth;
        this.mStrokeAlpha = vectorDrawableCompat$VFullPath.mStrokeAlpha;
        this.mFillColor = vectorDrawableCompat$VFullPath.mFillColor;
        this.mFillRule = vectorDrawableCompat$VFullPath.mFillRule;
        this.mFillAlpha = vectorDrawableCompat$VFullPath.mFillAlpha;
        this.mTrimPathStart = vectorDrawableCompat$VFullPath.mTrimPathStart;
        this.mTrimPathEnd = vectorDrawableCompat$VFullPath.mTrimPathEnd;
        this.mTrimPathOffset = vectorDrawableCompat$VFullPath.mTrimPathOffset;
        this.mStrokeLineCap = vectorDrawableCompat$VFullPath.mStrokeLineCap;
        this.mStrokeLineJoin = vectorDrawableCompat$VFullPath.mStrokeLineJoin;
        this.mStrokeMiterlimit = vectorDrawableCompat$VFullPath.mStrokeMiterlimit;
    }
}
